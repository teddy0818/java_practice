package algorithm;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

import javax.swing.JOptionPane;

public class Baseball extends Frame implements ActionListener {
    private static final int NUMBER_LENGTH = 3;
    private TextField[] inputFields = new TextField[NUMBER_LENGTH];
    private TextArea outputArea = new TextArea(10, 30);
    private Button guessButton = new Button("Guess");
    private DataInputStream input;
    private DataOutputStream output;

    public Baseball(String title, String serverAddress, int port) {
        super(title);

        setLayout(new BorderLayout());
        Panel inputPanel = new Panel();
        inputPanel.setLayout(new FlowLayout());
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            inputFields[i] = new TextField(1);
            inputPanel.add(inputFields[i]);
        }
        inputPanel.add(guessButton);
        add(inputPanel, BorderLayout.NORTH);
        add(outputArea, BorderLayout.CENTER);

        guessButton.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        setSize(400, 300);
        setVisible(true);

        try {
            Socket socket = new Socket(serverAddress, port);
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());

            // 숫자 입력
            String numberInput = JOptionPane.showInputDialog(this, "Enter your 3-digit number:");
            for (int i = 0; i < NUMBER_LENGTH; i++) {
                output.writeInt(Character.getNumericValue(numberInput.charAt(i)));
            }

            new Thread(new ServerMessageListener()).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int[] guess = new int[NUMBER_LENGTH];
            for (int i = 0; i < NUMBER_LENGTH; i++) {
                guess[i] = Integer.parseInt(inputFields[i].getText());
                inputFields[i].setText("");
            }
            for (int num : guess) {
                output.writeInt(num);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private class ServerMessageListener implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    int strikes = input.readInt();
                    int balls = input.readInt();
                    String message = input.readUTF();
                    outputArea.append("Result: " + strikes + " Strike, " + balls + " Ball\n");
                    outputArea.append(message + "\n");
                    if (message.equals("You win!") || message.equals("You lose!")) {
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Baseball("Number Baseball Game - Player 1", "localhost", 12345);
    }
}