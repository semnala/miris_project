package com.miris.hrms.service.adm.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class DeptVO {
	String dept_code;
	String dept_name;
	String reg_date;
}
