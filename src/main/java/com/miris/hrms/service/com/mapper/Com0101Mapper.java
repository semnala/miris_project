package com.miris.hrms.service.com.mapper;

import com.miris.hrms.service.com.vo.ManagerVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("com0101Mapper")
public interface Com0101Mapper {
	
	/* 로그인 회원 정보 조회*/
	ManagerVO selectManagerInfo(ManagerVO manager) throws Exception;
	
	/* 로그인 일시 기록 */
	void updateLoginDate(String id) throws Exception;

}
