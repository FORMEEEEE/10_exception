package edu.kh.exception.text;

import java.util.Scanner;

public class Exceptiontext {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//int a = 99.9; // 컴파일 에러
		// 개발자가 코드 잘못쓴 경우
		// 코드로 수정 가능
		
		double a = 99.9; // 1) 변수자료형을 double로 바꾸거나
						 // 2) (int)99.9 강제 형변환
						 // 3) 99.9 -> 100또는 99 정수형으로 바꾸는법
		
		/*while(true) {
			
			// 0 입력시 종료되도록 함.
			System.out.print("0입력시 종료");
			int input = sc.nextInt();
			
			// 탈추구문
			if(input == 0) {
				break;
			}
		}*/
		
		// 런타임 에러 : 프로그램 수행중 발생하는 에러
		//				주로 if문으로 처리가능
		
		int arr[] = new int[3]; //길이 3 index 0,1,2
		
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		
		
		if(arr.length <= 3) {
			System.out.println("배열범위 초과");
		}else {
			arr[3] = 40;
		}
		
		// java.lang.ArrayIndexOutOfBoundsException: <이거 외우셈>
		// <외우셈> 배열에서 부적절한 인덱스에 접근하려고 할 때 사용될 수 있는 예외
		// Index 3 out of bounds for length 3
		
		//  java.lang.NegativeArraySizeException: <이거도 외우셈 그냥>
		// 배열의 크기로 음수를 제시했을때 발생할 수 있는 예외
		
		
		
		
		
		
		
	}

}
