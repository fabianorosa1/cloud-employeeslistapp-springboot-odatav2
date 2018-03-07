package com.sap.cf.springboot.util;

import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.olingo.odata2.api.processor.ODataContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ODataContextUtil {

	private static ThreadLocal<ODataContext> oDataContext = new ThreadLocal<ODataContext>(); 
	
	public static void setODataContext(ODataContext c) {
		log.info(">>> Enter setODataContext: " + c);
		
		oDataContext.set(c);
	}
	
	public static ODataContext getODataContext() {
		log.info(">>> Enter getODataContext: " + oDataContext.get());
		
		return oDataContext.get();
	}
	
	public static ResourceBundle getResourceBundle(String name) {
		log.info(">>> Enter getResourceBundle: " + name);
		
		ResourceBundle i18n = null;
		if (oDataContext.get() != null) {
	 		for (Locale locale : oDataContext.get().getAcceptableLanguages()) {
				i18n = ResourceBundle.getBundle(name, locale);
				if (i18n.getLocale().equals(locale)) break;
			}
			return i18n;
		} else {
			return null;
		}
	}
}
