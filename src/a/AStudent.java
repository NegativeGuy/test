package a;
// ArrayList를 활용한 학생관리 프로그램
import java.util.ArrayList;
import java.util.Scanner;

public class AStudent {
	private ArrayList<StudentDTO> list;
	private Scanner sc;
	
	public AStudent() {	// main에서 AStudent 객체 생성하면 이 생성자도 자동 실행
		// AStudent 클래스의 초기화 조건 설정들을 이 곳에 넣어준다
		list = new ArrayList<StudentDTO>();
		sc = new Scanner(System.in);
	}
	
	public void display() {
		System.out.println("a학생 관리 연결");
		int num;
		while(true) {
			System.out.println("1.학생등록 2.전체확인 3.개인정보 4.종료");
			num = sc.nextInt();
			switch(num) {
			case 1:
				System.out.println("==학생등록==");
				register();
				break;
			case 2:
				System.out.println("==전체확인==");
				viewAll();
				break;
			case 3:
				System.out.println("==개인정보==");
				PersInfo();
				break;
			case 4:
				System.out.println("==종료합니다==");
				return;
			}
		}
	}
	
	public void register() {
		String name, addr, stNum;
		int age;
		while(true) { //학번을 우선 입력받아 중복된 학번이 있는지 확인해본다		
			System.out.println("학번 입력");
			stNum = sc.next();
			if(list.size() != 0) {//list에 무언가 저장 되어 있다면 0이 아니므로 if문 실행
				int i;	// 아래 if문의 조건으로 쓰기 위해 먼저 i를 선언
				for(i=0; i<list.size(); i++) {	// 중복확인 하기 위한 for문
					if(list.get(i).getStNum().equals(stNum)) {
						//list의 i번 인덱스의 StNum(학번)과 입력받은stNum이 같으면
						System.out.println("이미 존재하는 학번 입니다");
						break;	//for문 종료 후 아래 if문을 만난다
					}
				}
				if(i != list.size()) {
					// i와 list.size()가 같지 않다는 것은
					// 위에서 중복에 해당하는 경우이고 그러면 다시 학번을 입력 받기 위해
					// 맨 처음의 while문으로 돌아가기 위해 continue를 써준다
					continue;	// 맨 위의 while문으로 이동
				}
			}
			break;	//while문을 빠져나가 아래의 이름,나이,주소를 입력받는다
			// list.size가 0이거나 (기록된것이 아무것도 없는경우)
			// 기록되지 않은 학번을 입력한 경우
		}
		System.out.println("이름 입력");
		name = sc.next();
		System.out.println("나이 입력");
		age = sc.nextInt();
		System.out.println("주소 입력");
		addr = sc.next();
		
		StudentDTO dto = new StudentDTO();	// StudentDTO 객체 생성
		// dto 변수를 통해 StudentDTO에 있는 setter와 getter를 사용하기 위해
		dto.setStNum(stNum);
		dto.setName(name);
		dto.setAge(age);
		dto.setAddr(addr);
		// 각각 입력받은 정보를 각각의 setter로 보낸다
		
		list.add(dto); 
		// setter로 보내진 값들을 하나로 묶어(dto) list에 있는 하나의 인덱스에 추가
		// register()가 실행될 때마다 이런식으로 등록된 학생의 정보들이 하나의 묶음으로
		// list인덱스에 추가된다
		
		System.out.println("등록완료!!");
	}
	
	public void viewAll() {
		System.out.println("전체 학생정보 리스트");
		for(int i=0; i<list.size(); i++) {
			System.out.println("학번: "+list.get(i).getStNum());
			System.out.println("이름: "+list.get(i).getName());
			System.out.println("나이: "+list.get(i).getAge());
			System.out.println("주소: "+list.get(i).getAddr());
			System.out.println("------------------------------");
			}		
		if(list.size()==0){
			System.out.println("저장된 학생 정보가 없습니다");
			return;
		}
	}
	
	public void PersInfo() {
		while(true) {
			System.out.println("검색할 학번 입력");
			String num = sc.next();
			for(int i=0; i<list.size(); i++) {			
				if(list.get(i).getStNum().equals(num)) {
					System.out.println("학번: "+list.get(i).getStNum());
					System.out.println("이름: "+list.get(i).getName());
					System.out.println("나이: "+list.get(i).getAge());
					System.out.println("주소: "+list.get(i).getAddr());
					System.out.println("------------------------");
					return;
				}
			}
			System.out.println("없는 학번을 입력하셨습니다");
			continue;		
		}
	}
}
