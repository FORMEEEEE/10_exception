package edu.kh.exception.model.vo;

import java.io.IOException;

public class Parent {

	public void method() throws IOException{
		System.out.println("부모메서드"); //IoException
		// 호출한곳으로 IoException을 던짐
		// ==해당 메서드는
		//IOException을 발생 시킬 가능성이 있으므로
		// 호출하는 곳에서 예외처리
		
		
	}
}
