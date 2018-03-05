package com.sap.cf.springboot.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 
 * @author fabiano.rosa
 *
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {
	private static final Logger logger = LoggerFactory.getLogger(SpringContextUtil.class);
	
	private static ApplicationContext applicationContext;

	public SpringContextUtil() {

	}

	public static Object getBean(String beanName) throws BeansException {
		logger.info(">>>Enter getBean!!!!!");
		
		return applicationContext.getBean(beanName);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		logger.info(">>>Enter setApplicationContext!!!!!");
		
		SpringContextUtil.applicationContext = applicationContext;
	}

}
