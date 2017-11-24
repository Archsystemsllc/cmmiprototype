package com.archsystemsinc.qam.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.google.common.base.Preconditions;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.archsystemsinc.qam" })
@EnableJpaRepositories(basePackages = "com.archsystemsinc.qam.repository")
public class PersistenceConfig {

	@Value("${jdbc.driverClassName}")
    String driverClassName;
	@Value("${jdbc.url}")
    String jdbcURL;
	
	@Value("${jdbc.username}")
    String jdbcUsername;
	
	@Value("${jdbc.password}")
    String jdbcpassword;
	
	@Value("${hibernate.hbm2ddl.auto}")
    String hbm2ddlAuto;
	
	@Value("${hibernate.dialect}")
    String hibernateDialect;

    public PersistenceConfig() {
        super();
    }

    @Bean
   	public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
   		String activeProfile = System.getProperty("spring.profiles.active",
   				"local");
   		String propertiesFilename = "application-" + activeProfile
   				+ ".properties";
   		System.out.println("propertiesFilename:" + propertiesFilename);
   		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
   		configurer.setLocation(new ClassPathResource(propertiesFilename));

   		return configurer;
   	}
       @Bean
       public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
           final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
           em.setDataSource(dataSource());
           em.setPackagesToScan(new String[] { "com.archsystemsinc.qam.model" });

           final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
           // vendorAdapter.set
           em.setJpaVendorAdapter(vendorAdapter);
           em.setJpaProperties(additionalProperties());

           return em;
       }

       @Bean
       public DataSource dataSource() {
           final DriverManagerDataSource dataSource = new DriverManagerDataSource();
           dataSource.setDriverClassName(Preconditions.checkNotNull(driverClassName));
           dataSource.setUrl(Preconditions.checkNotNull(jdbcURL));
           dataSource.setUsername(Preconditions.checkNotNull(jdbcUsername));
           dataSource.setPassword(Preconditions.checkNotNull(jdbcpassword));

           return dataSource;
       }

      /*@Bean
       @Resource(name="jdbc/imap")
       public DataSource dataSource() {
           final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
           dsLookup.setResourceRef(true);
           DataSource dataSource = dsLookup.getDataSource("java:comp/env/jdbc/imap");
           return dataSource;
       }
       */
       @Bean
       public PlatformTransactionManager transactionManager() {
           final JpaTransactionManager transactionManager = new JpaTransactionManager();
           transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

           return transactionManager;
       }

       @Bean
       public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
           return new PersistenceExceptionTranslationPostProcessor();
       }

       
       final Properties additionalProperties() {
           final Properties hibernateProperties = new Properties();
           hibernateProperties.setProperty("hibernate.hbm2ddl.auto", hbm2ddlAuto);
           hibernateProperties.setProperty("hibernate.dialect", hibernateDialect);
           return hibernateProperties;
       }

}
