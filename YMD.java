package chap02;
import java.util.Scanner;

class YMD {
	int y; 
	int m; 
	int d; 

	// 각 달의 일수
	static int[][] mdays = { 
			{ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }, // 평년
			{ 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }, // 윤년
	};

	// 서기 year년은 윤년인가? (윤년：1／평년：0)
	static int isLeap(int year) {
		return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
	}

	// 생성자(주어진 날짜로 설정)
	YMD(int y, int m, int d) {
		this.y = y;
		this.m = m;
		this.d = d;
	}

	// n일 뒤의 날짜를 반환
	YMD after(int n) {
		YMD temp = new YMD(this.y, this.m, this.d);
		if (n < 0)
			return (before(-n));

		temp.d += n;

		while (temp.d > mdays[isLeap(temp.y)][temp.m - 1]) {	// 해당 월의 최대일수 초과하면
			temp.d -= mdays[isLeap(temp.y)][temp.m - 1];		// 해당 월의 최대일수보다 작아질때까지 뺀다
			if (++temp.m > 12) {								// temp.m이 12보다 크면 연도를 하나 더하고 월은 1월로 설정.
				temp.y++;
				temp.m = 1;
			}
		}
		return temp;
	}

	// n일 앞의 날짜를 반환
	YMD before(int n) {
		YMD temp = new YMD(this.y, this.m, this.d);
		if (n < 0)
			return (after(-n));

		temp.d -= n;

		while (temp.d < 1) {
			if (--temp.m < 1) {
				temp.y--;
				temp.m = 12;
			}
			temp.d += mdays[isLeap(temp.y)][temp.m - 1];
		}
		return temp;
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("날짜를 입력하세요.\n");
		System.out.print("년：");
		int y = stdIn.nextInt();
		System.out.print("월：");
		int m = stdIn.nextInt();
		System.out.print("일：");
		int d = stdIn.nextInt();
		YMD date = new YMD(y, m, d);

		System.out.print("몇 일 앞/뒤의 날짜를 구할까요?：");
		int n = stdIn.nextInt();

		YMD d1 = date.after(n);
		System.out.printf("%d일 뒤의 날짜는 %d년 %d월 %d일입니다.\n", n, d1.y, d1.m, d1.d);

		YMD d2 = date.before(n);
		System.out.printf("%d일 앞의 날짜는 %d년 %d월 %d일입니다.\n", n, d2.y, d2.m, d2.d);
	}
}
