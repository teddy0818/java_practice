package algorithm;

public class SnailArray {

/*
 
 [ 출력 ]  
 1	2	3	4	5	
16	17	18	19	6	
15	24	25	20	7	
14	23	22	21	8	
13	12	11	10	9	

 */
	public static void main(String[] args) {
		int n = 5;
		int[][] arr = new int[n][n];
		int value = 1;
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
		
		for(int i=0; i<arr.length * arr.length; i++) {
			 // 상단
            for (int j = left; j <= right; j++) {
                arr[top][j] = value++;
            }
            top++;

            // 오른쪽
            for (int j = top; j <= bottom; j++) {
                arr[j][right] = value++;
            }
            right--;

            // 하단
            for (int j = right; j >= left; j--) {
                arr[bottom][j] = value++;
            }
            bottom--;

            // 왼쪽
            for (int j = bottom; j >= top; j--) {
                arr[j][left] = value++;
            }
            left++;
		}
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		
	}

}
