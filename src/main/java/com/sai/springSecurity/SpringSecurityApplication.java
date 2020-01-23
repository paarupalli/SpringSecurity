package com.sai.springSecurity;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@SpringBootApplication
public class SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

	@Bean
	public DataSource datasource() {
		
		DriverManagerDataSource dmdatasource = new DriverManagerDataSource();
		dmdatasource.setDriverClassName("com.mysql.jdbc.Driver");
		dmdatasource.setUrl("jdbc:mysql://localhost:3306/practice");
		dmdatasource.setUsername("paarupalli");
		dmdatasource.setPassword("Hamaradesh2@");
		return dmdatasource;
	}
	
	@Bean
	  public LocalSessionFactoryBean sessionFactory() {
	    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	    sessionFactory.setDataSource(datasource());
	    sessionFactory.setPackagesToScan("com.sai.springSecurity.*");
	    
	    Properties props = new Properties();
	    props.put("hibernate.dialect", 
                "org.hibernate.dialect.MySQL5Dialect");
	    props.put("hibernate.show_sql", "true");
	    props.put("hibernate.hbm2ddl.auto","update");
	    sessionFactory.setHibernateProperties(props);
	    
	    return sessionFactory;
	  }
	
	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
		
		
		
	}
}
