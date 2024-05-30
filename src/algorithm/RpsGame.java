package algorithm;

import java.util.Scanner;

public class RpsGame {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int cnt = 0;
		String arr[] = {"가위","바위","보"};
		
		System.out.println("---------- 가위바위보 게임 시작 ----------");
		while(true) {
			
			if(cnt >= 5) {
				System.out.print("게임을 계속 진행하시겠습니까 ? (Y/N) : ");
				String answer = scan.next();
				if(answer.equals("N")) {
					System.out.println("---------- 게임종료 ----------");
					break;
				}
			}
			
			// 1:가위, 2:바위, 3:보
			int random = (int) (Math.random()*3+1);
			// 사용자 입력 값 
			System.out.print("숫자를 입력하세요 (1:가위/2:바위/3:보) : ");
			int input = scan.nextInt();
			
			if(input < 1 || input > 3) {
				System.out.println("다시 입력하세요");
				continue;
			}
			
			System.out.println("컴퓨터 : " + arr[random-1]);
			System.out.println("사용자 : " + arr[input-1]);
			int result = input - random;
			if(result == -2 || result == 1) {
				System.out.println("승리하셨습니다");
			} else if(result == 2 || result == -1) {
				System.out.println("패배하셨습니다");
			} else if(result == 0) {
				System.out.println("무승부입니다");
			}
			
			cnt++;
		}
		
	}

}
