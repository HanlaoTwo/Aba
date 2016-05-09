package com.aba.msgpush;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

import util.HTMLFilter;

@ServerEndpoint(value = "/ptpuser/chat")
public class PTPUserSocket {
    private static final Log log = LogFactory.getLog(ChatAnnotation.class);
    private static final String GUEST_PREFIX = "游客";
    //ÿ���½�һ��ʵ�������
    private static final AtomicInteger connectionIds = new AtomicInteger(0);    
    private final String nickname;
    private Session session;
    PtpMnager mnager;
    //����Ա���Ի�ȡsesstion
    public Session getSesstion()
    {
    	return this.session;
    }
    
    public PTPUserSocket() {
        nickname = GUEST_PREFIX + connectionIds.getAndIncrement();
        mnager = PtpMnager.getManager();
    }

    @OnOpen
    public void start(Session session) {
        this.session = session;
        mnager.AddUsers(this);
       String message = String.format("* %s %s", nickname, "连接到");
        mnager.UsersendMsg(message);
    }


    @OnClose
    public void end() {
        mnager.RemoveUser(this);
        String message = String.format("* %s %s",
                nickname, "关闭了消息推送窗口");
        mnager.UsersendMsg(message);
    }


    @OnMessage
    public void incoming(String message) {
        // Never trust the client
        String filteredMessage = String.format("%s: %s",
                nickname, HTMLFilter.filter(message.toString()));
        mnager.UsersendMsg(message);
    }

    @OnError
    public void onError(Throwable t) throws Throwable {
        log.error("Chat Error: " + t.toString(), t);
    }

    
}
