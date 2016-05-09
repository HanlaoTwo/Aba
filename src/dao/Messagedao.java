package dao;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import model.Message;
import model.Section;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Messagedao {

	private ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	DataSource dataSource = ctx.getBean(DataSource.class);
	SessionFactory sessionFactory = ctx.getBean(SessionFactory.class);

	public void saveMessage(String weather, Date time_data,
			String tration, String emergency, int sectionid) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("dao>>>>>>>>>>>>>>"+emergency);
		Message m = new Message(sectionid, weather, time_data, tration,
				emergency);
		session.save(m);
		tx.commit();
		session.close();
	}

	public Message getMessage(int sectionid) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Message m = (Message) session.get(Message.class, sectionid);
		tx.commit();
		session.close();
		return m;
	}

	// ����������������µ���Ϣ
	public List<Message> getMessageByID(int sectionid){
		Session session = sessionFactory.openSession(); 
			  String hql = "from Message where sectionid = ? ORDER BY time_data DESC";  
			  Query query = session.createQuery(hql); 
			  //query.setParameter("n", sectionid);
			  query.setInteger(0, sectionid);  
			  List<Message> list = query.list();  
			  session.close();  
			  return list;  
			 
		
	}
}
