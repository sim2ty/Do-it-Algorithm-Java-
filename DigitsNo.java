package chap01;

import java.util.Scanner;

public class DigitsNo {
	public static void main(String[] args) {
		System.out.print("숫자 입력 > ");
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		int temp=num;
		int digit=0;
		
		while(temp>0) {
			temp /= 10;
			digit++;
		}
		
		System.out.println(num + " : " + digit + "자리 숫자");

	}

}
