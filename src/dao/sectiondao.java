package dao;

import java.sql.SQLException;

import javax.sql.DataSource;

import model.Section;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class sectiondao {
	
	private ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	
	public void saveSection() {
		
	}
	public Section getSection(int id)
	{
		DataSource dataSource = ctx.getBean(DataSource.class);
		SessionFactory sessionFactory = ctx.getBean(SessionFactory.class);
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Section s = (Section) session.get(Section.class, id);
		tx.commit();
		session.close();
		return s;
	}
	public void saveSection(int id,String msg, String description){
		DataSource dataSource = ctx.getBean(DataSource.class);
		SessionFactory sessionFactory = ctx.getBean(SessionFactory.class);
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Section s = (Section) session.get(Section.class, id);
		System.out.println("msg: "+msg+"   des: "+description);
		if(!msg.equals(""))
		{
			s.setMsg(msg);
		}
		if(!description.equals(""))
		{
			s.setDescription(description);
		}
		session.update(s);
		tx.commit();
		session.close();
	}
	
	public void after(){
		
	}
}
