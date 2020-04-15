package com.miris.comm.preprocess.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.miris.comm.preprocess.filter.wrapper.MrsReadableRequestWrapper;

public class MrsReadableRequestFilter implements Filter {
	
	public static Logger logger = LogManager.getFormatterLogger(MrsReadableRequestFilter.class);
	
	private String clientIp;
	private String clientBrowser;

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		MrsReadableRequestWrapper wrapper = new MrsReadableRequestWrapper((HttpServletRequest)request);
		chain.doFilter(wrapper, response);

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
}
