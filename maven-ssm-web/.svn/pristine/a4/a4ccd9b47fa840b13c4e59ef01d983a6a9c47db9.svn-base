package com.zero.mail;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.zero.common.MethodResult;

/**
 * 邮件工具类
 * @author liuyingying
 *
 */
public class mailUtil {

	
	public static String senderAddress = "475811868@qq.com";
	
	public static String sendAccount = "475811868";
	
	public static String senderPasswd = "ltxekbahyypybhei";
	
	
	public static void main(String[] args) throws Exception {
		Map<String, Object> conn_req = new HashMap<String, Object>();
		Map<String,Object> content = new HashMap<String, Object>();
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("liusen@agree.com.cn");
		arr.add("18829290624@qq.com");
		conn_req.put("reciveAddress",arr );
		content.put("mailType", "UTF-8");
		content.put("subject", "gonfzi");
		content.put("mediaType", "text/html;charset=UTF-8");
		content.put("context", "您好，清注意查收");
		MethodResult res =  sendMail(conn_req, content);
		
		
		if("success".equals(res.getRetcode())) {
			System.out.println("success");
		}else {
			System.out.println(res.getRetmsg());
		}
	}
	
	public static MethodResult sendMail(Map<String, Object> conn_req,Map<String,Object> content) {
		MethodResult result = new MethodResult();
		
		Properties props = new Properties();
		//用户认证方式
		props.setProperty("mail.smtp.auth", "true");
		//传输协议
		props.setProperty("mail.transport.protocol", "smtp");
		//发件人的smtp服务器地址
		props.setProperty("mail.smtp.host", "smtp.qq.com");
		//2、创建定义整个应用程序所需的环境信息的 Session 对象
        Session session = Session.getInstance(props);
        //设置调试信息在控制台打印出来
        session.setDebug(true);
        //3、创建邮件的实例对象
        Transport transport = null;
        try {
        	
        	//创建一封邮件的实例对象
            MimeMessage msg = new MimeMessage(session);
            //设置发件人地址
            msg.setFrom(new InternetAddress(senderAddress));
            if(conn_req.containsKey("reciveAddress")) {
            	Object obj = conn_req.get("reciveAddress");
            	if(obj instanceof String) {
            		msg.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress(obj.toString()));
            	}else {
            		@SuppressWarnings("unchecked")
					ArrayList<String> addressList = (ArrayList<String>)obj;
            		for(String item:addressList) {
            			msg.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress(item));
            		}
            	}
            }else {
            	result.setRetcode("ERR_MAIL_01");
            	result.setRetmsg("请输入邮箱地址");
            }
            
            if(conn_req.containsKey("CCreciveAddress")) {
            	Object obj = conn_req.get("CCreciveAddress");
            	if(obj instanceof String) {
            		msg.setRecipient(MimeMessage.RecipientType.CC,new InternetAddress(obj.toString()));
            	}else {
            		@SuppressWarnings("unchecked")
					ArrayList<String> addressList = (ArrayList<String>)obj;
            		for(String item:addressList) {
            			msg.setRecipient(MimeMessage.RecipientType.CC,new InternetAddress(item));
            		}
            	}
            }

            if(conn_req.containsKey("BCCreciveAddress")) {
            	Object obj = conn_req.get("BCCreciveAddress");
            	if(obj instanceof String) {
            		msg.setRecipient(MimeMessage.RecipientType.BCC,new InternetAddress(obj.toString()));
            	}else {
            		@SuppressWarnings("unchecked")
					ArrayList<String> addressList = (ArrayList<String>)obj;
            		for(String item:addressList) {
            			msg.setRecipient(MimeMessage.RecipientType.BCC,new InternetAddress(item));
            		}
            	}
            }
            
            
            /**
             * 设置收件人地址（可以增加多个收件人、抄送、密送），即下面这一行代码书写多行
             * MimeMessage.RecipientType.TO:发送
             * MimeMessage.RecipientType.CC：抄送
             * MimeMessage.RecipientType.BCC：密送
             */
            String mailType = content.get("mailType")==null ? "UTF-8" : content.get("mailType").toString();
            String subject = content.get("content")==null ? "邮件主题" :content.get("content").toString();
            String mediaType = content.get("mediaType")==null ? "text/html;charset=UTF-8" : content.get("mediaType").toString();
            String context = content.get("context").toString();
            if(context == null || "".equals(context)) {
            	result.setRetcode("ERR_MAIL_02");
            	result.setRetmsg("邮件正文内容不能为空");
            }
            //设置邮件主题
            msg.setSubject(subject,mailType);
            //设置邮件正文
            msg.setContent(content, mediaType);
            //设置邮件的发送时间,默认立即发送
            msg.setSentDate(new Date());
			//4、根据session对象获取邮件传输对象Transport
          //4、根据session对象获取邮件传输对象Transport
            transport = session.getTransport();
            //设置发件人的账户名和密码
            transport.connect(sendAccount, senderPasswd);
            //发送邮件，并发送到所有收件人地址，message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
            transport.sendMessage(msg,msg.getAllRecipients());
             
            
            //如果只想发送给指定的人，可以如下写法
            //transport.sendMessage(msg, new Address[]{new InternetAddress("xxx@qq.com")});
             result.setRetcode("SUCCESS");
             return result;
		} catch (Exception e) {
			result.setRetcode("ERR_MAIL_03");
        	result.setRetmsg("邮件发送出错："+e.getMessage());
		}finally {
			//5、关闭邮件连接
	        try {
				transport.close();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
}
