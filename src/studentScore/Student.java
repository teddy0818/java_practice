package studentScore;

public class Student {
		int bun;
		String name;
		int score1;
		int score2;
		int score3;
		int score4;
		int score5;
		int mxScore;
		int mnScore;
		int tot;
		double ave;
		int rank;
		
		Student(int bun, String name, int score1, int score2, int score3, int score4, int score5) {
			this.bun = bun;
			this.name = name;
			this.score1 = score1;
			this.score2 = score2;
			this.score3 = score3;
			this.score4 = score4;
			this.score5 = score5;
		}
		
		void print() {
			System.out.print(bun+"\t");
			System.out.print(name+"\t");
			System.out.print(score1+"\t");
			System.out.print(score2+"\t");
			System.out.print(score3+"\t");
			System.out.print(score4+"\t");
			System.out.print(score5+"\t");
			System.out.print(mxScore+"\t");
			System.out.print(mnScore+"\t");
			System.out.print(tot+"\t");
			System.out.printf("%.2f\t", ave);
			System.out.print(rank);
		}
}
