package com.app.config;

import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.app.model.Document;
import com.app.model.Item;
import com.app.model.OrderMethod;
import com.app.model.PurchaseOrder;
import com.app.model.SaleOrder;
import com.app.model.ShipmentType;
import com.app.model.Uom;
import com.app.model.User;
import com.app.model.WhUserType;

@ComponentScan(basePackages = "com.app")
@EnableTransactionManagement // it is commit or rollback
@EnableWebMvc // it is a spring web mvc config
@Configuration
@PropertySource(value = "Classpath:app.properties")
//@Import(SecurityConfig.class)
public class AppConfig implements WebMvcConfigurer {
	
	@Autowired
	private Environment env;

	// 1.DataSource
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

	
	// 2.SessionFactory
	@Bean
	public LocalSessionFactoryBean sfObj() {

		LocalSessionFactoryBean lsfb = null;

		lsfb = new LocalSessionFactoryBean();

		// set datasource to Session factory
		lsfb.setDataSource(dsObj());

		// set Hibernate Properties to Session factory
		lsfb.setHibernateProperties(props());

		// set annotated entity class to Session Factory
		lsfb.setAnnotatedClasses(WhUserType.class,ShipmentType.class, Uom.class, OrderMethod.class, User.class,
				Document.class,Item.class,PurchaseOrder.class,SaleOrder.class);

		return lsfb;
	}

	// 3.Properties
	@Bean
	public Properties props() {

		Properties prop = null;

		prop = new Properties();

		prop.setProperty("hibernate.dialect", env.getProperty("dialect"));
		prop.setProperty("hibernate.show_sql", env.getProperty("showsql"));
		prop.setProperty("hibernate.format_sql", env.getProperty("fmtsql"));
		prop.setProperty("hibernate.hbm2ddl.auto", env.getProperty("ddlauto"));

		return prop;

	}

	// 4.HibernateTemplate
	@Bean
	public HibernateTemplate htObj() {
		HibernateTemplate ht = null;

		ht = new HibernateTemplate();

		// set factory bean to hibernate template
		ht.setSessionFactory(sfObj().getObject());

		return ht;
	}

	// 5.HibernateTransactionManager
	@Bean
	public HibernateTransactionManager hthObj() {

		HibernateTransactionManager htm = null;

		htm = new HibernateTransactionManager();

		htm.setSessionFactory(sfObj().getObject());

		return htm;
	}

	// 6.InternalResourceViewResolver
	@Bean
	public InternalResourceViewResolver ivr() {

		InternalResourceViewResolver irvr = null;

		irvr = new InternalResourceViewResolver();

		// location of UI file
		irvr.setPrefix(env.getProperty("mvc.prefix"));

		// extension of UI file
		irvr.setSuffix(env.getProperty("mvc.suffix"));

		return irvr;
	}

	// 7.Configure Resource Handler
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry reg) {
		reg.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
		
	// 8.Configure CommonsMultipartResolver 
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver cm = new CommonsMultipartResolver();
		return cm;
	}
	
	// 9.configure mail properties
	@Bean
	public JavaMailSenderImpl mailSender() {
		JavaMailSenderImpl jm=new JavaMailSenderImpl();
		jm.setHost(env.getProperty("email.host"));
		jm.setPort(env.getProperty("email.port",Integer.class));
		jm.setUsername(env.getProperty("email.usr"));
		jm.setPassword(env.getProperty("email.pwd"));
		jm.setJavaMailProperties(eprops());
		return jm;
	}
	
	// 10.configure properties
	public Properties eprops() {
		Properties p=new Properties();
		p.put("mail.smtp.auth",env.getProperty("email.auth"));
		p.put("mail.smtp.starttls.enable",env.getProperty("email.ssl.enbl"));
		return p;
	}
	
	//11.passwordEncoder
	@Bean
	public BCryptPasswordEncoder pwdEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
