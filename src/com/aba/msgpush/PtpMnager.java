package com.aba.msgpush;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

import javax.websocket.Session;

import org.apache.catalina.tribes.membership.StaticMember;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

public class PtpMnager {

	private static final Log log = LogFactory.getLog(ChatAnnotation.class);
	private static final Set<PTPUserSocket> connections = new CopyOnWriteArraySet<PTPUserSocket>();
	private static final Set<OnetoOneSocket> otoUsersers = new CopyOnWriteArraySet<OnetoOneSocket>();
	private int usernum = 0;
	
	//����ģʽ
	private PtpMnager(){
		
	}
	private static PtpMnager manger;
	//�����û���Ϣ�Ķ���
	private PTPMangerSocket ms;

	//�������ⲿ�ṩһ��ʵ��
	public static PtpMnager getManager()
	{
		if(manger==null)
		{
			manger = new PtpMnager();
			return manger;
		}
		else {
			return manger;
		}
		
	}
	//Ϊms��ֵ
	public void setms(PTPMangerSocket msMangerSocket)
	{
		this.ms = msMangerSocket;
	}
	// ÿ��һ���û������Ե����ʱ�ͼ����û�������
	public void AddUsers(PTPUserSocket user) {
		connections.add(user);
		usernum++;
	}
	//sɾ���û�
	public void RemoveUser(PTPUserSocket user) {
		connections.remove(user);
		usernum--;
	}
	//����Ա�������û�������Ϣ
	public void BroadcatMsg(String msg) {
		for (PTPUserSocket client : connections) {

			try {
				synchronized (client) {
					client.getSesstion().getBasicRemote().sendText(msg);
				}
			} catch (IOException e) {
				log.debug("Chat Error: Failed to send message to client", e);
				connections.remove(client);
				try {
					client.getSesstion().close();
				} catch (IOException e1) {
					// Ignore
				}
				String message = String.format("* %s %s", client.toString(),
						"has been disconnected.");
				BroadcatMsg(message);
			}
		}
	}
	//�û������Ա������Ϣֻ�й���Ա���Կ���
	public void UsersendMsg(String msg)
	{
		try {
			ms.getSesstion().getBasicRemote().sendText(msg);
		} catch (IOException e) {
			
			String message = String.format("* %s %s", ms.toString(),
					"暂时无法发送");
			BroadcatMsg(message);
		}
	}
	/*
	 * ��Ե������ʵ�ֲ���
	 * �ݶ�ֻ����һ�Թ���Ա���û�ʵʱͨ��
	 * ����Աֻ��һ�����û�ʵ��Ҳֻ��һ��
	 * �����µ�ʵ�����ʱ��Ҫ�ȴ�
	 * */
	//���
	public void addOOuser(OnetoOneSocket newUser,String oid)
	{
		boolean flag = false;
		
		//������û���ظ���ID
		for(OnetoOneSocket one : otoUsersers)
		{
			if(one.id.equals(oid))
			{
				flag=true;
				one = newUser;
			}
		}
		if(flag==false)
		{
			newUser.id = oid;
			otoUsersers.add(newUser);
		}
		else
		{
			//done nothing for now
		}
	}
	//ɾ��
	public void removeOOuser(OnetoOneSocket OOuser)
	{
		otoUsersers.remove(OOuser);
	}
	//ʵʱ����
	public void chat(OnetoOneSocket itself,String msg)
	{
		for(OnetoOneSocket OOuser : otoUsersers)
		{
			if(itself.id.equals(OOuser.id))
			{
				//do nothing
			}
			else 
			{
				try {synchronized(OOuser){OOuser.getSesstion().getBasicRemote().sendText(msg);}} 
				catch (IOException e) {e.printStackTrace();}
			}
		}
	}
	

}
