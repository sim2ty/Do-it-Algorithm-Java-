package chap01;

public class Max4_Mid3 {
	public static void main(String[] args) {
		System.out.println("최대값 : " + max4(1,2,3,4));
		System.out.println("최대값 : " + max4(3,5,2,8));
		
		System.out.println("중앙값 : " + mid3(5,2,5));
		System.out.println("중앙값 : " + mid3(9,8,7));
	}
	//네 값의 최대값을 구하는 메서드
	static int max4(int a, int b, int c, int d) {
		int max=a;
		if(b>max) max=b;
		if(c>max) max=c;
		if(d>max) max=d;
		return max;
	}
	//세 값의 중앙값을 구하는 메서드
	static int mid3(int a, int b, int c) {
		return ( (a-b)*(a-c) <= 0 ) ? a : ( (b-a)*(b-c) <=0 ) ? b : c;
	}
}
