package dao;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class daoUtil {
	private ApplicationContext ctx = null;
	
	public void before()
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		// System.out.println(ctx);
		DataSource dataSource = ctx.getBean(DataSource.class);
		// System.out.println(dataSource.getConnection().toString());
		SessionFactory sessionFactory = ctx.getBean(SessionFactory.class);
		System.out.println(sessionFactory);
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
	}
	
}
