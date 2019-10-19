package com.example.demo.mail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author liuyingying
 *
 */
public class MailUtil {

	private static Logger logger = LoggerFactory.getLogger(MailUtil.class);
	
	private static Log4Javamail log4JavaMail = new Log4Javamail(logger, "utf-8");//logger为slf4j的日志对象
	
	
	private static String senderAddress = "475811868@qq.com";
	
	private static String sendAccount = "475811868";
	
	private static String senderPasswd = "ltxekbahyypybhei";
	
	public static void main(String[] args) throws Exception {
		sendMail("18829290624@qq.com", "lalala");
	}
	/**
	 * 发送邮件
	 * @param recieveAddress
	 * @param sendText
	 */
	public static boolean sendMail(String recieveAddress,String sendText) {
		boolean success = false;
		try {
			Properties props = new Properties();
//			用户认证方式
			props.setProperty("mail.smtp.auth", "true");
			//传输协议
			props.setProperty("mail.transport.protocol", "smtp");
			//发件人的smtp服务器地址
			props.setProperty("mail.smtp.host", "smtp.qq.com");
			
			//2、创建定义整个应用程序所需的环境信息的 Session 对象
	        Session session = Session.getInstance(props);
	    	session.setDebugOut(log4JavaMail); //设置将日志输出到工具类对象
	        //设置调试信息在控制台打印出来
	        session.setDebug(true);
	        //3、创建邮件的实例对象
	        Message msg = getMimeMessage(session,recieveAddress,sendText);
	        //4、根据session对象获取邮件传输对象Transport
	        Transport transport = session.getTransport();
	        //设置发件人的账户名和密码
	        transport.connect(sendAccount, senderPasswd);
	        //发送邮件，并发送到所有收件人地址，message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
//	        transport.sendMessage(msg,msg.getAllRecipients());
	         
	        //如果只想发送给指定的人，可以如下写法
	        transport.sendMessage(msg, new Address[]{new InternetAddress(recieveAddress)});
	         
	        //5、关闭邮件连接
	        transport.close();
	        success = true;
	        return success;
		} catch (Exception e) {
			return success;
		}
	}
	
	 /**
     * 获得创建一封邮件的实例对象
     * @param session
     * @return
     * @throws MessagingException
     * @throws AddressException
     */
	private static MimeMessage getMimeMessage(Session session,String recieveAddress,String sendText) throws Exception{
        //创建一封邮件的实例对象
        MimeMessage msg = new MimeMessage(session);
        //设置发件人地址
        msg.setFrom(new InternetAddress(senderAddress));
        /**
         * 设置收件人地址（可以增加多个收件人、抄送、密送），即下面这一行代码书写多行
         * MimeMessage.RecipientType.TO:发送
         * MimeMessage.RecipientType.CC：抄送
         * MimeMessage.RecipientType.BCC：密送
         */
        msg.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress(recieveAddress));
        //设置邮件主题
        msg.setSubject("【SCKL验证码】","UTF-8");
        //设置邮件正文
        msg.setContent(sendText, "text/html;charset=UTF-8");
        //设置邮件的发送时间,默认立即发送
        msg.setSentDate(new Date());
        return msg;
    }
	
	
	
	
}
