package com.sap.cf.springboot.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.cloud.service.PooledServiceConnectorConfig.PoolConfig;
import org.springframework.cloud.service.relational.DataSourceConfig;
import org.springframework.cloud.service.relational.DataSourceConfig.ConnectionConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * @author fabiano.rosa
 *
 * https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html
 * http://www.baeldung.com/spring-eclipselink
 *
 */

@Configuration
@Profile("cloud")
@EnableTransactionManagement
@ImportResource("classpath:/spring/spring-security.xml")
public class CloudConfig extends AbstractCloudConfig {
	private static final String HANA_SVC = "hanadb-hdi-container";
	private static final Logger logger = LoggerFactory.getLogger(CloudConfig.class);

	// TODO read the Pool configuration from a Properties
	private static final int MIN_POOL_SIZE = 2;
	private static final int MAX_POOL_SIZE = 10;
	private static final int MAX_WAIT_TIME = 5;
	// private static final String CONNECTION_PROPERTIES_STRING =
	// "useUnicode=true;characterEncoding=UTF-8";

	/**
	 * Create dataSource bean from SAP CF
	 * 
	 * @return dataSource dataSoruce created from HANA Service.
	 */
	@Bean
	public DataSource dataSource() {
		logger.info(">>>Enter dataSource!!!!!");

		CloudFactory cloudFactory = new CloudFactory();
		Cloud cloud = cloudFactory.getCloud();

		// DataSource Pool configuration
		PoolConfig poolConfig = new PoolConfig(MIN_POOL_SIZE, MAX_POOL_SIZE, MAX_WAIT_TIME);
		ConnectionConfig connectionConfig = new ConnectionConfig(null);
		DataSourceConfig config = new DataSourceConfig(poolConfig, connectionConfig);

		DataSource ds = cloud.getServiceConnector(HANA_SVC, DataSource.class, config);

		logger.info(">>>DataSource: " + ds);

		return ds;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		logger.info(">>>Enter transactionManager!!!!!: " + emf);

		final JpaTransactionManager transactionManager = new JpaTransactionManager();

		transactionManager.setEntityManagerFactory(emf);
		logger.debug(">>>transactionManager: " + transactionManager);

		return transactionManager;
	}
}
