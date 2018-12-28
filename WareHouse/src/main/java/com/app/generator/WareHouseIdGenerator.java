package com.app.generator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class WareHouseIdGenerator implements IdentifierGenerator {

	public WareHouseIdGenerator() {
		System.out.println("WareHouseIdGenerator:0-param Constructor");
	}

	public int generateCustId() {
		Random rd = null;
		rd = new Random();
		return rd.nextInt(10000);
	}

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

		Calendar cal = null;

		cal = Calendar.getInstance();

		return "WRHS" + this.generateCustId() + cal.get(Calendar.YEAR);
	}

}
