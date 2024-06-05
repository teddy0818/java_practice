package studentScore;

import java.util.Scanner;

public class StudentMain {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StudentPro sp = new StudentPro();
		int num = 10;
		Student[] studentArr = new Student[num];
		int cnt = 0;
		
		//키보드입력
		for(int i=0; i<num; i++) {
			int bun = scan.nextInt();
			if(bun == 0) {
				break;
			}
			cnt++;
			
			String name = scan.next();
			int score1 = scan.nextInt();
			int score2 = scan.nextInt();
			int score3 = scan.nextInt();
			int score4 = scan.nextInt();
			int score5 = scan.nextInt();
			
			Student st = new Student(bun, name, score1, score2, score3, score4, score5);
			st.mxScore = sp.calMax(st);
			st.mnScore = sp.calMin(st);
			st.tot = sp.calTot(st);
			st.ave = sp.calAvr(st);
			
			studentArr[i] = st;
		}
		
		// 랭크 매기기
		sp.calRank(studentArr, cnt);
		
		// 기본 출력
//		sp.show(studentArr, cnt);
		
		// 번호순 정렬
		System.out.println("-------------- 번호 순 정렬 --------------");
		sp.sortByBun(studentArr, cnt);
		sp.show(studentArr, cnt);
		
		// 성적순 정렬
		System.out.println("-------------- 성적 순 정렬 --------------");
		sp.sortByRank(studentArr, cnt);
		sp.show(studentArr, cnt);
	
	}

}
