package com.app.config;

import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@ComponentScan(basePackages="com.app")
@EnableTransactionManagement   //it is commit or rollback
@EnableWebMvc//it is a spring web mvc config
@Configuration     
@PropertySource(value="app.properties")
public class AppConfig {

	@Autowired
	private Environment env;

	//1.DataSource
	@Bean
	public BasicDataSource dsObj() {

		BasicDataSource bsds = null;

		bsds = new BasicDataSource();

		// set the properties to datasource
		bsds.setDriverClassName(env.getProperty("dc"));
		bsds.setUrl(env.getProperty("url"));
		bsds.setUsername(env.getProperty("un"));
		bsds.setPassword(env.getProperty("pwd"));

		return bsds;
	}

	//2.SessionFactory
	@Bean
	public LocalSessionFactoryBean sfObj() {

		LocalSessionFactoryBean lsfb = null;

		lsfb = new LocalSessionFactoryBean();

		//set datasource to to factory bean 
		lsfb.setDataSource(dsObj());

		return lsfb;
	}

	//3.Properties
	@Bean
	public Properties props() {
		
		Properties prop=null;
		
		prop=new Properties();
		
		prop.setProperty("hibernate.dialect",env.getProperty("dialect"));
		prop.setProperty("hibernate.show_sql",env.getProperty("showsql"));
		prop.setProperty("hibernate.format_sql",env.getProperty("fmtsql"));
		prop.setProperty("hibernate.hbm2ddl.auto",env.getProperty("ddlauto"));
		
		return prop;
		
	}
	
	//4.HibernateTemplate
	@Bean
	public HibernateTemplate htObj() {
		HibernateTemplate ht=null;
		
		ht=new HibernateTemplate();
		
		//set factory bean to hibernate template
		ht.setSessionFactory(sfObj().getObject());

	    return ht;
	}
	
	//5.HibernateTransactionManager
	@Bean
	public HibernateTransactionManager hthObj() {
		
		HibernateTransactionManager htm=null;
		
		htm=new HibernateTransactionManager();
		
		htm.setSessionFactory(sfObj().getObject());
		
		return htm;
	}
	
	//6.InternalResourceViewResolver
	@Bean
	public InternalResourceViewResolver ivr() {
		
		InternalResourceViewResolver irvr=null;
		
		irvr=new InternalResourceViewResolver();
		
		//location of UI file
		irvr.setPrefix(env.getProperty("mvc.prefix"));
	
		//extension of UI file
	    irvr.setSuffix(env.getProperty("mvc.suffix"));
	    
	    return irvr;
	}
		
}
