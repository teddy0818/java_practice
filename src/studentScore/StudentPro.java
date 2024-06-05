package studentScore;

public class StudentPro {
	
	int calTot(Student st) {
		int tot = st.score1 + + st.score2 + st.score3 + st.score4 + st.score5 - st.mnScore - st.mxScore;
		return tot;
	}
	
	double calAvr(Student st) {
		double avr = st.tot / 3.0; 
		return avr;
	}
	
	int calMax(Student st) {
		int max = st.score1;
		
		if(max < st.score2) {
			max = st.score2;
		}
		if(max < st.score3) {
			max = st.score3;
		}
		if(max < st.score4) {
			max = st.score4;
		}
		if(max < st.score5) {
			max = st.score5;
		}
		
		return max;
	}
	
	int calMin(Student st) {
		int min = st.score1;
		
		if(min > st.score2) {
			min = st.score2;
		}
		if(min > st.score3) {
			min = st.score3;
		}
		if(min > st.score4) {
			min = st.score4;
		}
		if(min > st.score5) {
			min = st.score5;
		}
		
		return min;
	}
	
	void calRank(Student[] studentArr, int cnt) {
		for(int i=0; i<cnt; i++) {
			int rank = 1;
			for(int j=0; j<cnt; j++) {
				if(studentArr[i].tot < studentArr[j].tot) {
					rank++;
				}
			}
			studentArr[i].rank = rank;
		}
	}
	
	void sortByBun(Student[] studentArr, int cnt) {
		for(int i=0; i<cnt; i++) {
			for(int j=i+1; j<cnt; j++) {
				if(studentArr[i].bun > studentArr[j].bun) {
					Student temp = studentArr[i];
					studentArr[i] = studentArr[j];
					studentArr[j] = temp;
				}
			}
		}
	}
	
	void sortByRank(Student[] studentArr, int cnt) {
		for(int i=0; i<cnt; i++) {
			for(int j=i+1; j<cnt; j++) {
				if(studentArr[i].rank > studentArr[j].rank) {
					Student temp = studentArr[i];
					studentArr[i] = studentArr[j];
					studentArr[j] = temp;
				}
			}
		}
	}
	
	void show(Student[] studentArr, int cnt) {
		System.out.println("번호\t이름\t점수1\t점수2\t점수3\t점수4\t점수5\t최대점수\t최소점수\t합계\t평균\t순위");
		for(int i=0; i<cnt; i++) {
			studentArr[i].print();
			System.out.println();
		}
	}

}
