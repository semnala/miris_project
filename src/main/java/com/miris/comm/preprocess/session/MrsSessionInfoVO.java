package com.miris.comm.preprocess.session;

import lombok.Data;

@Data
public class MrsSessionInfoVO {
	String clientIP;
	String clientBrowser;
	String clientOS;
	String hostname;
	String container;
	long validTimeStamp;
}
