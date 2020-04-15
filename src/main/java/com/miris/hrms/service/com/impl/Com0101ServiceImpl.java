package com.miris.hrms.service.com.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.miris.hrms.service.com.Com0101Service;
import com.miris.hrms.service.com.mapper.Com0101Mapper;
import com.miris.hrms.service.com.vo.ManagerVO;

@Service("com0101Service")
public class Com0101ServiceImpl implements Com0101Service {
	
	public static Logger logger = LogManager.getLogger(Com0101ServiceImpl.class);

	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	Com0101Mapper mapper;
	
	@Override
	public boolean userLoginIn(ManagerVO manager) throws Exception {
		logger.debug("userLoginIn");
		boolean result;
		String encPasswd = passwordEncoder.encode(manager.getAdm_pw());
		manager.setAdm_pw(encPasswd);
		
		ManagerVO resultVO = mapper.selectManagerInfo(manager);
		if(resultVO != null) {
			result = true;
		} else {
			result = false;
		}

		return result;
	}

}