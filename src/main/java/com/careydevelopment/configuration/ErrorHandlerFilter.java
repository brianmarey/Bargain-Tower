package com.careydevelopment.configuration;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ErrorHandlerFilter implements Filter {

	private static final Logger LOGGER = LoggerFactory.getLogger(ErrorHandlerFilter.class);
	
	@Override
	public void destroy() {
		// ...
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		LOGGER.info("Initializing filter");
	}

	@Override
	public void doFilter(ServletRequest request, 
               ServletResponse response, FilterChain chain)
		throws IOException, ServletException {

		LOGGER.info("\n\n\nin fitler\n");
		try {
			//LOGGER.info(response.g);
			HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper((HttpServletResponse)response); 
			LOGGER.info("" + wrapper.getStatus());
			chain.doFilter(request, response);
		} catch (Exception ex) {
			LOGGER.error("Caught exception!");
			request.setAttribute("errorMessage", ex);
			request.getRequestDispatcher("/404").forward(request, response);
		}
	}
}
