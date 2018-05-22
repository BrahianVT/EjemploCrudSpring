package edu.ejemplo.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages="edu.ejemplo")
public class HibernateConfig {

	@Bean
	LocalSessionFactoryBean localSession(){
		LocalSessionFactoryBean session = new LocalSessionFactoryBean();
		session.setDataSource(datasource());
		session.setPackagesToScan("edu.ejemplo.modelos");
		session.setHibernateProperties(hibernarteProperties());
		return session;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager getTx (SessionFactory sf){
		HibernateTransactionManager tx = new HibernateTransactionManager();
		tx.setSessionFactory(sf);
		return tx;
	}
	@Bean
	DataSource datasource(){
		DriverManagerDataSource dm = new DriverManagerDataSource();
		dm.setDriverClassName("org.postgresql.Driver");
		dm.setUrl("jdbc:postgresql://localhost:5433/prueba");
		dm.setUsername("postgres");
		dm.setPassword("root");
		return dm;
	}
	private Properties hibernarteProperties(){
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "validate");
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.default_schema", "public");
		return properties;
	}
}
