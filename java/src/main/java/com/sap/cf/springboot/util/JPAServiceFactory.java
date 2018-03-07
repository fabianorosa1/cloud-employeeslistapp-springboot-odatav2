package com.sap.cf.springboot.util;

import javax.persistence.EntityManagerFactory;

import org.apache.olingo.odata2.jpa.processor.api.ODataJPAContext;
import org.apache.olingo.odata2.jpa.processor.api.ODataJPAServiceFactory;
import org.apache.olingo.odata2.jpa.processor.api.exception.ODataJPARuntimeException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JPAServiceFactory extends ODataJPAServiceFactory {

	public static final String DEFAULT_ENTITY_UNIT_NAME = "Model";
	public static final String ENTITY_MANAGER_FACTORY_ID = "entityManagerFactory";

	@Override
	public ODataJPAContext initializeODataJPAContext() throws ODataJPARuntimeException {
		log.info(">>> Enter initializeODataJPAContext");
		
		ODataJPAContext oDataJPAContext = getODataJPAContext();

		EntityManagerFactory entityManagerFactory = (EntityManagerFactory) SpringContextsUtil.getBean(ENTITY_MANAGER_FACTORY_ID);
		log.info(">>> entityManagerFactory: " + entityManagerFactory);
		
		oDataJPAContext.setEntityManagerFactory(entityManagerFactory);
		oDataJPAContext.setPersistenceUnitName(DEFAULT_ENTITY_UNIT_NAME);
		ODataContextUtil.setODataContext(oDataJPAContext.getODataContext());
		
		return oDataJPAContext;
	}
}
