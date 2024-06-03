package baseball;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void showMenu() {
		System.out.println();
		System.out.println("< 메뉴 >");
		System.out.println("(1) 숫자야구 게임 시작");
		System.out.println("(2) 랭킹 확인");
		System.out.println("(3) 프로그램 종료");
		System.out.print("메뉴를 선택해주세요 (1~3)  :  ");
	}
	
	public static void gameStart() {
		
		// 초기 값 (전역 변수)
		Scanner scan = new Scanner(System.in);
		int cnt = 0;
		final int len = 3;
		double score = 100;
		String nick = "";
		
		// 닉네임 입력
		System.out.println();
		System.out.print("닉네임 입력 : ");
		nick = scan.next();
		
		// 정답 생성
		int[] answer = new int[len];
		for(int i=0; i<len; i++) {
			// 0 ~ 9 까지의 난수
			int random = (int) (Math.random()*10);
			boolean isSame = false;
			for(int j=0; j<i; j++) {
				if(answer[j] == random) {
					isSame = true;
				}
			}
			if(isSame) {
				i--;
				continue;
			}
			answer[i] = random;
		}
		// 테스트용 
//		System.out.println("정답 : " + Arrays.toString(answer));
		
		// 본 게임 실행
        long startTime = System.currentTimeMillis();
		while(true) {			
			int s = 0;
			int b = 0;
			int o = 0;
			
			cnt++;
			System.out.print(cnt + "회전 입력 : ");
			String strInput = scan.next();
			int[] inputs = new int[len];
			for(int i=0; i<len; i++) {
				inputs[i] = strInput.charAt(i) - '0';
			}
			
			// 결과 판별 
			for(int i=0; i<len; i++) {
				for(int j=0; j<len; j++) {
					if(answer[i] == inputs[j]) {
						if(i == j) {
							s++;
						} else {
							b++;
						}
					} 
				}
			}
			o = len - s - b;
			System.out.printf(cnt + "회전 결과 : %d Strike %d Ball %d Out \n", s, b, o);
			
			// 정답
			if(s == 3) {
				System.out.println("정답 : " + Arrays.toString(answer));
				System.out.println("정답을 맞추셨습니다 !!");

				long endTime = System.currentTimeMillis();
				int playTime = (int) ((endTime - startTime) / 1000);
				System.out.println("걸린 시간 : " + playTime + " 초");
				
				score = score - (playTime*0.1) - (cnt*0.5);
				score = Math.round(score*100)/100.0;
				System.out.println("점수 : " + score + " 점");
				
				insertRank(nick, score);
				
				break;
			}
			
			// 게임 오버
			if(s != 3 && cnt == 9) {
				System.out.println("정답 : " + Arrays.toString(answer));
				System.out.println("Game Over !! 9회전 만에 못푸셨습니다 !!");
				
				break;
			}
			
		}
	
		
	}

	public static void checkRank() {
		 	String jdbcUrl = "jdbc:mysql://localhost:3306/baseball";
	        String username = "root";
	        String password = "111111";

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            Connection conn = DriverManager.getConnection(jdbcUrl, username, password);

	            String sql = "SELECT * FROM bs_rank ORDER BY score DESC";
	            Statement st = conn.createStatement();
	            ResultSet rs = st.executeQuery(sql);

	            System.out.println();
	            System.out.println("< 랭킹 >");
	            int rankNum = 0;
	            while (rs.next()) {
	            	rankNum++;
	            	String nick = rs.getString("bs_nick");
	            	double score = rs.getDouble("score");
	            	
	            	System.out.printf("%d위 %s %.1f점 \n", rankNum, nick, score);
	            }

	            rs.close();
	            st.close();
	            conn.close();
	    		
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
	
	public static void insertRank(String nick, double score) {
	    String jdbcUrl = "jdbc:mysql://localhost:3306/baseball";
	    String username = "root";
	    String password = "111111";

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        Connection conn = DriverManager.getConnection(jdbcUrl, username, password);

	        String sql = "INSERT INTO bs_rank (bs_nick, score) VALUES (?, ?)";
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, nick);
	        pstmt.setDouble(2, score);

	        pstmt.close();
	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("------------- 프로그램 시작 -------------");
		showMenu();
		
		while(true) {
			int input = scan.nextInt();
			if (input == 1) {
				gameStart();
				showMenu();
			} else if (input == 2) {
				checkRank();
				showMenu();
			}
			if(input == 3) {
				break;
			}
		
		}
		
		System.out.println("------------- 프로그램 종료 -------------");
		
	}

}
