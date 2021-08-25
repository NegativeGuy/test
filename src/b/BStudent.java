package b;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import a.StudentDTO;

// HashMap을 활용한 학생관리 프로그램
public class BStudent {
	private Scanner sc;
	private HashMap<String, StudentDTO> map;
	
	public BStudent() {
		sc = new Scanner(System.in);
		map = new HashMap<String, StudentDTO>();
	}
	
	public void display() {
		while(true) {			
			System.out.println("1.학생등록 2.전체확인 3.개인확인 4.종료");
			int num = sc.nextInt();
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
				System.out.println("==개인확인==");
				PersInfo();
				break;
			case 4:
				System.out.println("==종료합니다==");
				return;
			}
		}
	}
	
	public void register() {
		StudentDTO st = new StudentDTO();
		String stNum, name, addr;
		int age;
		System.out.println("학번 입력");
		stNum = sc.next();
		if(map.size() != 0) {
			for(int i=0; i<map.size(); i++) {
				if(map.containsKey(stNum)) {
					System.out.println("이미 저장된 학번입니다");
					System.out.println("------------------");
					return;
				}
			}
		}
		System.out.println("이름 입력");
		name = sc.next();
		System.out.println("나이 입력");
		age = sc.nextInt();
		System.out.println("주소 입력");
		addr = sc.next();
		
		st.setStNum(stNum);
		st.setName(name);
		st.setAge(age);
		st.setAddr(addr);
		
		map.put(stNum, st);
		System.out.println("저장 완료!!");
		System.out.println("------------------");
		
	}
	
	public void viewAll() {
		if(map.size()!=0) {	//map에 저장된 데이터가 있으면
			Iterator<String> it = map.keySet().iterator();
			// 이터레이터 변수 it에 map의 keySet을 대입
			while(it.hasNext()) {
				StudentDTO v = map.get(it.next());
				// StudentDTO 객체를 만드는데 새로 입력이 아닌 저장된 데이터를 꺼내올거기 때문에
				// new가 아닌 map을 대입
				System.out.println("학번 : "+v.getStNum());
				System.out.println("이름 : "+v.getName());
				System.out.println("나이 : "+v.getAge());
				System.out.println("주소 : "+v.getAddr());
				System.out.println("-------------------");
			}
		}else {
			System.out.println("저장된 데이터가 없습니다");
			System.out.println("-------------------");
			return;
		}
	}

	public void PersInfo() {
		System.out.println("확인할 학번 입력");
		String stNum = sc.next();
		if(map.containsKey(stNum)) {
			StudentDTO p = map.get(stNum);
			System.out.println("학번 : "+p.getStNum());
			System.out.println("이름 : "+p.getName());
			System.out.println("나이 : "+p.getAge());
			System.out.println("주소 : "+p.getAddr());
			System.out.println("-------------------");
		}else {
			System.out.println("존재하지 않는 학번 입니다");
		}
	}
}
