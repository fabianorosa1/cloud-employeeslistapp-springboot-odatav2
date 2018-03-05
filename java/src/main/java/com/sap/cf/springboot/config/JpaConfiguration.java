package com.sap.cf.springboot.config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.eclipse.persistence.logging.SessionLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizers;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.jta.JtaTransactionManager;

/**
 * 
 * @author fabiano.a.rosa http://www.baeldung.com/spring-eclipselink
 * 
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.sap.cf.springboot.repository")
@EntityScan(basePackages = "com.sap.cf.springboot.model")
public class JpaConfiguration extends JpaBaseConfiguration {
	private static final Logger logger = LoggerFactory.getLogger(JpaConfiguration.class);

	protected JpaConfiguration(DataSource dataSource, JpaProperties properties,
			ObjectProvider<JtaTransactionManager> jtaTransactionManager,
			ObjectProvider<TransactionManagerCustomizers> transactionManagerCustomizers) {
		super(dataSource, properties, jtaTransactionManager, transactionManagerCustomizers);
		logger.info(">>>Enter JpaConfiguration");

		logger.debug(">>>Enter JpaConfiguration dataSource: " + dataSource);
		logger.debug(">>>Enter JpaConfiguration properties: " + properties);
		logger.debug(">>>Enter JpaConfiguration jtaTransactionManager: " + jtaTransactionManager);
	}

	@Override
	protected AbstractJpaVendorAdapter createJpaVendorAdapter() {
		logger.info(">>>Enter createJpaVendorAdapter!!!!!");
		return new EclipseLinkJpaVendorAdapter();
	}

	@Override
	protected String[] getPackagesToScan() {
		String[] packages = super.getPackagesToScan();
		logger.info("$$$$$ getPackagesToScan: " + Arrays.toString(packages));
		return packages;
	}

	@Override
	protected Map<String, Object> getVendorProperties() {
		/*
		 * <properties> <property name="eclipselink.weaving" value="false"/>
		 * 
		 * <property name="eclipselink.ddl-generation" value="none" /> <property
		 * name="eclipselink.refresh" value="true" /> <!-- property
		 * name="eclipselink.logging.level" value="OFF" / --> <!-- property
		 * name="eclipselink.logging.level" value="FINEST" / --> <property
		 * name="eclipselink.logging.level" value="OFF" /> <property
		 * name="eclipselink.target-database" value="HANA" /> <property
		 * name="eclipselink.connection-pool.default.initial" value="1" /> <property
		 * name="eclipselink.connection-pool.default.min" value="6" /> <property
		 * name="eclipselink.connection-pool.default.max" value="64" />
		 * 
		 * <!-- Optimization #9 - statement caching --> <property
		 * name="eclipselink.jdbc.cache-statements" value="true" />
		 * 
		 * <!-- Optimization #10 - batch writing --> <property
		 * name="eclipselink.jdbc.batch-writing" value="JDBC" /> <property
		 * name="eclipselink.jdbc.batch-writing.size" value="1000" /> </properties>
		 */
		HashMap<String, Object> map = new HashMap<>();
		map.put(PersistenceUnitProperties.WEAVING, detectWeavingMode());
		// map.put(PersistenceUnitProperties.DDL_GENERATION, "drop-and-create-tables");
		map.put(PersistenceUnitProperties.LOGGING_LEVEL, SessionLog.INFO_LABEL);
		map.put(PersistenceUnitProperties.TARGET_DATABASE, "HANA");
		map.put(PersistenceUnitProperties.CACHE_STATEMENTS, "true");

		logger.info(">>>Enter createJpaVendorAdapter: " + map);

		return map;
	}

	private String detectWeavingMode() {
		logger.info(">>>Enter detectWeavingMode!!!!!");
		return InstrumentationLoadTimeWeaver.isInstrumentationAvailable() ? "true" : "static";
	}
}
