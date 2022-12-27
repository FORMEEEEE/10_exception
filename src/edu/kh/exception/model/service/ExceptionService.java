package edu.kh.exception.model.service;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionService {
	
	Scanner sc = new Scanner(System.in);
	
	public void ex1() {
		
		// 예외(Exception) : 소스코드의 수정으로 해결 가능한 오류
		
		// 예외는 두 종류로 구분
		// 1) Unchecked Exception : 선택적으로 예외처리
		// 2) Checked Exception : 필수적 예외처리
		
		
		System.out.println("두 점수를 입력받아 나누기한 몫을 출력");
		
		System.out.print("점수 입력 : ");
		int input = sc.nextInt();
		
		System.out.print("점수2 압력 : ");
		int input2 = sc.nextInt();
		
		// try - catch 예외 처리
		// try{} : 괄호 내부에 예외가 발생할 가능성이 있는 코드 작성한 후 시도
		
		// catch(예외){} : try 구문에서 발생한 예외를 잡아서 처리하여
		//				프로그램이 비정상 종료되지 않게함
		
		
		try {
			System.out.println("두 점수 나누기 몫 : "+  input / input2 );
			//ArithmeticException : 산술적 예와
			// 		/by zero ==> 0으로 나눌수없음
		}catch(ArithmeticException e) {
			// try에서 던져진 예외를 catch문 매개변수로 잡음.
			
			System.out.println("infinity");//처리코드
		}
		if(input2 != 0) {
			System.out.println("두 점수 나누기 몫 : "+  input / input2);
		}else {
			System.out.println("infinity");
		}
		
		// 발생하는 예외처리 중 일부 예외는 try - catch 구문을 사용하지 않아도
		// 예외 상황 방지가 가능하다
		// (일부 예외 == 대부분의 UncheckedException)
		
		}
		
	public int inputNumber() {
		int num = 0;
		
		 
		 while(true) {
			 try {
				 System.out.print("정수입력");
				 num = sc.nextInt();
				 break;
			 }catch(InputMismatchException e) {
				 System.out.println("정수만 입력");
				 sc.nextLine(); //버퍼에 남아있는 잘못 입력된 문자열 제거
			 }
		 }
		 
		 
		 
		 
		 return num;
		 
		 
	}
	
	public void ex2() {
		int sum = 0;
		
		for(int i = 0; i < 3; i++) {
			sum += inputNumber();
		}
		System.out.println(sum);
	}	
	
	public void ex3() {
		// 여러가지 예외에 대한 처리방법
		
		try {
		
		System.out.println("정수 입력 : "); //inputmismatchexception
		int input = sc.nextInt();
		
		System.out.println("정수 입력 : ");// inputmismatchexception
		int input2 = sc.nextInt();
		
		System.out.println("나누기 결과 : " + input / input2); //ArithmaticException
		// 관계 없는 예외는 순서 관계 없이 catch문에 작성하면 됨
		
		
		// *************************************
		// 강제로 nullpointException 발생
		// * nullpointException : 참조하지 않는 참조변수를 이용해서 코드를 수행할때 발생
		
		String str = null;
		System.out.println(str.charAt(0));
		
		
		
		
		
		
		
		
		
		
		
		}catch(ArithmeticException e) {
			System.out.println("0으로 나눴지?");
		}catch(InputMismatchException e) {
			System.out.println("특수문자썻지?");
		}catch(Exception e) {
			// 예외처리 + 다형성
			// Exception 클래스 : 모든 예외의 최상위 부모
			// 부모타입 참조변수로 자식객체를 참조
			
			//** 상위타입의 예외 클래스를 catch문에 작성하면
			//		다형성 upcasting에 의해 모두 잡아서 처리
			
			System.out.println("예외가 발생해 처리함");
		}
		// * catch문 연속작성시 Exception 상속 구조를 주의(다형성)
		
	}
	
	public void ex4() {
		// try - catch -finally
		// finally : try 구문에서 예외가 발생하던 말던 무조건 마지막에 실행
		try {
			System.out.println( 4/ 0); // ArithmeticException
		}catch(ArithmeticException e) {
			System.out.println("예외처리됨");
			
			//catch문 매개변수 활용
			// 매개변수e : 예외 관련 정보 + 예외 관련 기능
			System.out.println(e.getClass()  );//어떤 예외 클래스?
			System.out.println(e.getMessage()); // 예외 발생시 출력된 내용
			
			System.out.println(e); // e.tostring();
			// ==> java.lang.ArithmeticException: / by zero
			
			e.printStackTrace(); //예외가 발생하기까지의 모든 메소드 흐름 출력
			// 어디서 어떤 에러가 발생했는지 파악하는 용도
			
			
		}finally { 
			System.out.println("무조건 수행됨");
		}
		
	}
	
	public void ex5() {
		// throws : 호출한 메서드에게 예외를 던짐
		// 		--> 호출한 메서드에게 예외를 처리하라고 위임하는 행위
		
		//throw : 예외 강제 발생 구문(현재 메서드에 예외를 던짐)
		try {
		methodA();
		}catch(Exception e){
			//Exception : 모든 예외의 최상위 부모
			// -> Exception이 catch 매개변수로 작성되었다 == 예외 종류 상관없이 모두 처리
			System.out.println("예외 처리함");
			e.printStackTrace();
			//발생한 예외가 메서드의 위치에 대한 모든 내용 출력
			// - 예외 발생 지점 추적
		}
		
	}
	public void methodA() throws IOException {
		methodB();
	}
	public void methodB() throws IOException{
		methodC();
	}
	public void methodC()throws IOException {
		// IOException예외 강제발생
		throw new IOException();
		
		//발생한 예외처리 하는 방법
		// 1) try - catch로 감싸서 현재위치에서 처리
		// 2) throws로 호출한 메서드로 예외를 위임하여 처리
	}
	
	public void methodD() {
		throw new RuntimeException();
	}
	
	
	
	
	}

