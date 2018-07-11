package chap01;

public class Spira {
	public static void main(String[] args) {
		spira(5);
	}
	//n단의 피라미드를 출력하는 메서드
	static void spira(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j < n - i + 1; j++) {
				System.out.print(' ');
			}
			for (int j = 1; j <=(2*i-1) ; j++) {
				System.out.print('*');
			}
			System.out.println();
		}

	}
}


