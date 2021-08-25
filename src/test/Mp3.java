package test;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JLabel;

class Music_Play extends Thread{
	static int vol=3;
	int music=0, i=0, stat=0;
	String dptop10;
	private String TSong;
	private String TMusician;
	boolean top=false;
	protected ArrayList top10 = new ArrayList();	
	private LinkedHashMap list;
	private Entry<String,String> entry;
	
	String dpM = "곡 대기중..";
	Scanner sc = new Scanner(System.in);
	public void setTSong(String Tsong) {
		this.TSong = Tsong;
	}
	public String getTsong() {
		return TSong;
	}
	public void setTMusician(String TMusician) {
		this.TMusician = TMusician;
	}
	public String getTMusician() {
		return TMusician;
	}
	public void setStat(int stat) {
		this.stat = stat;
	}
	public int getStat() {
		return stat;
	}
	public void setVol(int vol) {
		this.vol = vol;
	}
	public int getVol() {
		return this.vol;
	}
	public void setMusic(int music) {
		this.music = music;
	}
	public int getMusic() {
		return this.music;
	}
	public void sleep() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void top10_list(int sel) {
		setList(sel);
		int score = 1;
		i=0;
		top10.clear();
        Set set = list.entrySet();
        Iterator it = set.iterator();
        while(it.hasNext()){
            entry = (Entry)it.next();
            String Top10Song = (String)entry.getKey();
            String Top10Musician = (String)entry.getValue();
            System.out.print(score+"위 "+Top10Song);
            System.out.println(" - "+Top10Musician);
            top10.add(Top10Song+" - "+Top10Musician);
            score++;
        }
	}
	public void dpTop10() {
		dptop10 = (String)top10.get(i);
	}
	
	public void setList(int sel) {
		list = new LinkedHashMap();
		if(sel==1) {
			list.put("신호등", "이무진");
			list.put("바라만 본다", "MSG워너비");
			list.put("낙하 (with 아이유)", "AKMU");
			list.put("Next Level", "aespa");
			list.put("Permission to Dance", "방탄소년단");
			list.put("Weekend", "태연");
			list.put("Butter", "방탄소년단");
			list.put("좋아좋아", "조정석");
			list.put("헤픈 우연", "헤이즈");
			list.put("OHAYO MY NIGHT", "디핵, PATEKO");		
			return;
		}
		else if(sel==2){
			list.put("Steam", "Jimmy Brown");
			list.put("Cloud (Feat. Clavita, 도넛맨)", "Wavycake");
			list.put("헷갈리게 해", "조인 (ZOIN)");
			list.put("어쩌면", "라디오 파라다이스 (Radio Paradise)");
			list.put("폴라로이드 (Polaroid) (Feat. Mabinc, V.et)", "PicoVello");
			list.put("Criminals", "NOD (노드)");
			list.put("RUNAWAY (Feat. 명이월)", "Juhyeok");
			list.put("그곳에 머물러", "김비버 (Bieber Kim)");
			list.put("사랑합니다", "유대용 (DY)");
			list.put("돌아갈게", "이한울");
			return;
		}
		else if(sel==3) {
			list.put("The One Rose (Live On The Ed Sullivan Show, November 30, 1958)", "Teresa Brewer");
			list.put("Rumors (feat. Cardi B)", "Lizzo");
			list.put("Cold Heart (PNAU Remix)", "Elton John, Dua Lipa");
			list.put("everything sucks", "vaultboy, 에릭남 (Eric Nam)");
			list.put("Woof", "Still Woozy");
			list.put("A Different Kind of Love", "Anthony Lazaro");
			list.put("Sad Sad Sad", "Rosie");
			list.put("Beach (Acoustic)", "Veronica Fusaro");
			list.put("Imagine", "Ben Platt");
			list.put("Dahil Ba Sa Kanya", "Sahara");
			return;
		}
		System.out.println("리스트 번호를 다시 입력해 주세요");
		sleep();
		top10();	
	}		
	
	public void play() {
		if(getMusic()==0 && top==false) {
			System.out.println("재생 할 음악번호 입력(1~100)");
			System.out.print(">>> ");
			int sel = sc.nextInt();
			if(sel>100 || sel<=0) {
				System.out.println("잘못된 번호를 입력 하셨습니다");
				sleep();
				return;
			}
			setMusic(sel);
			System.out.println("음악을 재생 합니다");
			sleep();
			dpM = "[재생 중...]";
			return;
		}
		else if(getMusic()!=0) {
			System.out.println("음악을 재생 합니다");
			sleep();
			dpM = "[재생 중...]";
			if(top==true)
				dpTop10();
			return;
		}
		else if(getMusic()==0 || top==true) {
			System.out.println("음악을 재생 합니다");
			sleep();
			dpM = "[재생중...]";
			dpTop10();
			return;
		}
	}
	
	public void pause() {
		System.out.println("음악을 정지 합니다");
		sleep();
		dpM = "[일시 정지]"; 
	}
	
	public void next() {
		if(getMusic()==0) {
			if(top == false) {
				System.out.println("음악을 먼저 골라주세요");
				System.out.println("재생 or top10 버튼을");
				System.out.println("선택해 주세요");
				sleep();
				sleep();
				sleep();
			}
			else if(top == true && i<9) {
				System.out.println("다음곡으로 넘어갑니다");
				sleep();
				i++;
				dpTop10();
			}
			else if(top == true && i>=9) {
				System.out.println("마지막 곡입니다.");
				sleep();
			}	
		}
		else if(getMusic()<100 && getMusic() != 0) {
			if(top==true && i<9) {
				System.out.println("다음곡으로 넘어갑니다");
				sleep();
				i++;
				dpTop10();
			}
			else {
				System.out.println("다음곡으로 넘어갑니다");
				sleep();
				setMusic(music+1);
				return;
			}
		}
		else if(getMusic()>=100 || i>=9) {
			System.out.println("마지막 곡입니다.");
			sleep();

		}
	}
	
	public void previous() {
		if(getMusic()==0 && top == false) {
			System.out.println("음악을 먼저 골라주세요");
			System.out.println("재생 or top10 버튼을");
			System.out.println("선택해 주세요");
			sleep();
			sleep();
			sleep();
		}
		else if(getMusic()<100 && top == false) {
			if(getMusic()==1) {
				System.out.println("첫 곡입니다.");
				sleep();
				return;
			}
			else{
				System.out.println("이전곡으로 돌아갑니다");
				sleep();
				setMusic(music-1);
			}
		}
		else if(top==true && i>=0) {
			if(i==0){
				System.out.println("첫 곡입니다.");
				sleep();
				return;
			}
			else{
				System.out.println("이전곡으로 돌아갑니다");
				sleep();
				i--;
				dpTop10();
				return;
			}
		} 
	}
	
	public void volume() {
		System.out.println("원하는 볼륨을 입력해주세요(0~5)");
		System.out.print(">>> ");
		int vol = sc.nextInt();
		if(vol>5) {
			System.out.println("최대 볼륨은 5입니다");
			sleep();
			vol = Music_Play.vol;
		}
		else if(vol<6 && vol>=0){
			System.out.println("볼륨을 "+vol+"(으)로 설정 합니다");
			sleep();
			setVol(vol);
		}
	}
	
	public void top10() {
		System.out.println("=== top10 list 선택 ===");
		System.out.println("1. 2021 K-pop top 10");
		System.out.println("2. 2021 K-indi top 10");
		System.out.println("3. 2021 Non kpop top 10");
		System.out.print(">>> ");
		int sel = sc.nextInt();
		
		top10_list(sel);
		setStat(sel);
		
		System.out.println("================================");
		System.out.println("선택한 리스트를 재생목록으로 저장할까요?");
		System.out.println("(y/n)");
		System.out.print(">>> ");
		String sel_yn = sc.next();
		if(sel_yn.contains("y")) {
			top = true;
			play();
		}
	}
}
class MusicJF extends Music_Play{
	JFrame frame;
	Container c;
	JLabel label;
	Font font;
	public MusicJF() {	// 생성자 생성
		frame = new JFrame();	//객체 생성 : 프레임 만들기
		c = frame.getContentPane();	// 바탕 화면 만들기
		label = new JLabel();	// 라벨 객체 만들기
		font = new Font(null, 0, 32);	//폰트 설정
		label.setFont(font);	// 위 설정값 대입
		label.setHorizontalAlignment(JLabel.CENTER); //폰트위치
		c.add(label);	// 바탕화면에 label 삽입
		frame.setLocation(200, 200);	// 화면에 프레임창을 띄울 위치
		frame.setPreferredSize(new Dimension(500, 500));   //프레임창 크기
		frame.pack(); 	// 위치와 크기 설정 적용
		frame.setVisible(true); 	// 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		//프레임창 끄면 콘솔도 꺼짐	
		}
	public void run() {	// run 매서드를 꼭 만들어 줘야 함, 실제 기능이 들어가는 매서드
		for(int i=0; i<top10.size(); i++) {		
			label.setText((String)top10.get(i));
		}
	}
}
public class Mp3 {
	public static void main(String[] args) {
		Music_Play ex = new Music_Play();
		MusicJF mf = null;
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("====== Music player ======");
			if(ex.top==false){				
				System.out.println("music : "+ex.music);				}
			else {
				System.out.println("music : "+ex.dptop10);
			}
			System.out.println(ex.dpM);
			System.out.println("Vol : "+ex.vol);
			System.out.println("1.[>] 2.[||] 3.[>l] 4.[l<]");
			System.out.println("5.[vol] 6.Top10 7.[Exit]");
			System.out.println("==========================");
			System.out.print(">>> ");
			int sel = sc.nextInt();
				
			switch(sel) {
			case 1:
				ex.play(); break;
			case 2:
				ex.pause(); break;			
			case 3:
				ex.next(); break;
			case 4:
				ex.previous(); break;
			case 5:
				ex.volume(); break;
			case 6:
				ex.top10();
				System.out.println(ex.top10);
				ex.setDaemon(true);
				mf = new MusicJF();
				mf.start();
				break;
			case 7:
				return;
			}
		}	
	}
}
