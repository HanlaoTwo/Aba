package dao;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import model.Message;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String s[])
	{
		 ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		DataSource dataSource = ctx.getBean(DataSource.class); 
		SessionFactory sessionFactory = ctx.getBean(SessionFactory.class);
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			//System.out.println("dao>>>>>>>>>>>>>>"+emergency);
			Message m = new Message(1, "号", new Date(), "哈哈","拉拉");
			session.save(m);
			tx.commit();
			session.close();    
	}
}
