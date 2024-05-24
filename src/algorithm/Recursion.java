package algorithm;

// 재귀 함수
public class Recursion {

	static int multi(int num) {
		if(num==1) {
			return 1;
		}
		return num * multi(num-1);
	}

	public static void main(String[] args) {
		int multi = multi(5);
		System.out.println(multi);
	}
}
