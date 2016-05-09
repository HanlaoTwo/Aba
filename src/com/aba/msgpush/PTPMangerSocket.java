/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.aba.msgpush;

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

@ServerEndpoint(value = "/ptpmanager/chat")
public class PTPMangerSocket {

    private static final Log log = LogFactory.getLog(ChatAnnotation.class);
    private static final String GUEST_PREFIX = "用户";
    //ÿ���½�һ��ʵ�������
    private static final AtomicInteger connectionIds = new AtomicInteger(0);    
    private final String nickname;
    private Session session;
    //��ȡmanger
    PtpMnager manger;
    //����Ա���Ի�ȡsesstion
    public Session getSesstion()
    {
    	return this.session;
    }
    //���췽������ֵ����manger�����ڹ���
    public PTPMangerSocket() {
        nickname = GUEST_PREFIX + connectionIds.getAndIncrement();
        manger = PtpMnager.getManager();
       
    }

    //��ʱ�Ĳ���
    @OnOpen
    public void start(Session session) {
        this.session = session;
        manger.setms(this);
       String message = String.format("* %s %s", nickname, "建立连接");
       //ͨ��manger���û�������Ϣ
        manger.BroadcatMsg(message);
    }
    @OnClose
    public void end() {
      
        String message = String.format("* %s %s",
                nickname, "管理员暂时不在");
        manger.BroadcatMsg(message);
    }
    @OnMessage
    public void incoming(String message) {
        // Never trust the client
        String filteredMessage = String.format("%s: %s",
                nickname, HTMLFilter.filter(message.toString()));
        manger.BroadcatMsg(message);
    }

    @OnError
    public void onError(Throwable t) throws Throwable {
        log.error("Chat Error: " + t.toString(), t);
    }

}
