package com.sap.cf.springboot.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.cxf.jaxrs.servlet.CXFNonSpringJaxrsServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class CxfServletRegister {
	
	@Bean
	public ServletRegistrationBean getODataServletRegistrationBean() {
		log.info(">>> Enter getODataServletRegistrationBean");
		
		ServletRegistrationBean odataServletRegistrationBean = new ServletRegistrationBean(new CXFNonSpringJaxrsServlet(), "/odata.svc/*");
		Map<String, String> initParameters = new HashMap<String, String>();
		initParameters.put("javax.ws.rs.Application", "org.apache.olingo.odata2.core.rest.app.ODataApplication");
		initParameters.put("org.apache.olingo.odata2.service.factory", "com.sap.cf.springboot.util.JPAServiceFactory");
		
		odataServletRegistrationBean.setInitParameters(initParameters);
		
		return odataServletRegistrationBean;
	}
}
