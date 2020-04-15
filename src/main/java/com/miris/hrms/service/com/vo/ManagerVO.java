package com.miris.hrms.service.com.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ManagerVO {
	String adm_id;
	String adm_pw;
	String adm_level;
	String use_yn;
}
