package test;
// 국비과정 2번째 시험
import java.util.ArrayList;
import java.util.Scanner;
class a{
	public int oddEven(int num) {
		if(num%2==0) {
			return num + 10;
		}else if(num%2!=0) {
			return num - 10;
		}
		return 0;
	}
}
public class test01 {
	public static void main(String[] args) {
		
//	double dou = 1.123;
//	float flt = 0;
//	flt = (float)dou;
	
//	Scanner sc = new Scanner(System.in);
//	int num = sc.nextInt();
//	switch(num) {
//	case 1:
//		System.out.println("1실행");
//		break;
//	case 2:
//		System.out.println("2실행");
//		break;
//		}
//	int num=0, sum = 0;
//	if(num==1) {
//		sum = num *10;
//	}else if(num==2) {
//		sum = num *20;
//	}
//	System.out.println("연산 결과 : "+sum);
//		int num = 123;
//		try {
//			int result = num/0;
//		} catch (Exception e) {
//			System.out.println("0으로 나눌 수 없습니다");
//		}
//		System.out.println("다음 코드들 진행");
		
//		Scanner input = new Scanner(System.in);
//		ArrayList arr = new ArrayList();
//		while(true) {
//			System.out.print("사용자 아이디 입력 : ");
//			String userId = input.next();
//			if(arr.contains(userId)==false) {			
//				arr.add(userId);
//				System.out.println("등록 완료");
//			}else {
//				System.out.println("이미 등록된 아이디 입니다");
//			}
//		}
	String userId = "   홍길동   ";
	String name = userId.trim();
	if(name.equals("홍길동")){
		System.out.println("인증 통과!!!");
	}else {
		System.out.println("인증 실패!!!");
	}
	
	}
}
