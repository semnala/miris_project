package com.miris.comm.preprocess.filter.wrapper;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.util.IOUtils;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.springframework.util.StringUtils;

public class MrsReadableRequestWrapper extends HttpServletRequestWrapper {
	
	public static Logger logger = LogManager.getLogger(MrsReadableRequestWrapper.class); 
	
	private Charset encoding;
	private byte[] rawData;
	private String bodyStr;

	public MrsReadableRequestWrapper(HttpServletRequest request) {
		super(request);
		
		this.encoding = null;
		
		String characterEncoding = request.getCharacterEncoding();
		
		if (StringUtils.isEmpty(characterEncoding)) {
			characterEncoding = StandardCharsets.UTF_8.name();
		}
		this.encoding = Charset.forName(characterEncoding);
		
		try {
			InputStream is = request.getInputStream();
			this.rawData = IOUtils.toByteArray(is); // InputStream을 바이트배열로 저장
			
			this.bodyStr = new String(rawData);
			
			//JSONObject jObject = new JSONObject(bodyStr);
			
			logger.info("Wrapper : {}", this.bodyStr);
			
			JSONParser jsonParser = new JSONParser();
			
			// Body 데이터를 JSON 객체(Object or Array)로 변환
			Object object = jsonParser.parse(bodyStr);
			
			if(object instanceof JSONObject) {
				JSONObject jObject = (JSONObject)jsonParser.parse(bodyStr);
				this.rawData = jObject.toString().getBytes();
				
			} else if(object instanceof JSONArray){
				JSONArray jArray = (JSONArray)jsonParser.parse(bodyStr);
				this.rawData = jArray.toString().getBytes();
			}
			
		} catch (Exception e) {
			
		}
	}

	@Override
	public ServletInputStream getInputStream() throws IOException {
		final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.rawData);
		
		ServletInputStream servletInputStream = new ServletInputStream() {
			@Override
			public int read() throws IOException{
				return byteArrayInputStream.read();
			}
			
			@Override
			public boolean isFinished() {
				return false;
			}

			@Override
			public boolean isReady() {
				return false;
			}

			@Override
			public void setReadListener(ReadListener arg0) {				
			}
		};
		return servletInputStream;
	}

	@Override
	public ServletRequest getRequest() {
		return super.getRequest();
	}

	@Override
	public BufferedReader getReader() throws IOException {
		return new BufferedReader(new InputStreamReader(this.getInputStream(), this.encoding));
	}
	
	
}
