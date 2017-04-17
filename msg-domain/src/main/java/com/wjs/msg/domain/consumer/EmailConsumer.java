package com.wjs.msg.domain.consumer;

import com.wjs.common.base.annotation.StatusAndClassNum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

import static com.wjs.common.base.properties.ProjectProperties.getProperty;
import static com.wjs.msg.api.dto.ConsumerDTO.TYPE_EMAIL;

/**
 * Created by panqingqing on 16/7/8.
 */
@StatusAndClassNum(superClass = Consumer.class, number = TYPE_EMAIL, describe = "邮件", parasitClass = Consumer.class)
public class EmailConsumer extends Consumer {
    private Logger logger = LoggerFactory.getLogger(EmailConsumer.class);
    private Properties properties = new Properties();

    public EmailConsumer() {
    }

    @Override
    public boolean doSend() {
        boolean result = true;
        init();
        Session session = Session.getInstance(properties);
        session.setDebug(true);
        Transport transport = null;
        try {
            transport = session.getTransport();
            transport.connect(getProperty("mail.host"), getProperty("mail.username"), getProperty("mail.password"));
            Message message = createMessage(session);
            transport.sendMessage(message, message.getAllRecipients());
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
            result = false;
        } finally {
            try {
                transport.close();
            } catch (MessagingException e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
        return result;
    }

    private void init() {
        properties.setProperty("mail.host", getProperty("mail.host"));
        properties.setProperty("mail.smtp.auth", getProperty("mail.smtp.auth"));
        properties.setProperty("mail.transport.protocol", getProperty("mail.transport.protocol"));
    }

    public MimeMessage createMessage(Session session) {
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(getProperty("mail.username")));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(contact));
            message.setSubject("发文");
            message.setContent("文本", "text/html;charset=UTF-8");
        } catch (MessagingException e) {
            logger.info(e.getMessage(), e);
        }
        return message;
    }
}