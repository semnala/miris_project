package com.miris.comm.memory;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class MrsMemoryLoadInitailizer {
	
	// PostConstruct 어노테이션을 설정한 메소드는 WAS가 띄워질때 실행된다.
	@PostConstruct
	public void init() throws Exception{
		
	}

}
