package test;

import java.util.Scanner;

import a.AStudent;
import b.BStudent;

public class MainClass {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num;
		
		AStudent aStudent = new AStudent(); // AStudent 객체 생성 & AStudent 생성자 생성
		BStudent bStudent = new BStudent();	// BStudent 객체 생성 & BStudent 생성자 생성
		
		while(true) {
			System.out.println("1.A회원관리 2.B회원관리 3.종료");
			num = input.nextInt();
			switch(num) {
			case 1: 
				aStudent.display();
				break;
			case 2: 
				bStudent.display();
				break;
			case 3: 
				System.out.println("프로그램 종료"); 
				return;
			}
		}
	}
}
