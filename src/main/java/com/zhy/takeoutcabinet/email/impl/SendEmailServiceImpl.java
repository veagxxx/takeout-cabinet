package com.zhy.takeoutcabinet.email.impl;

import com.zhy.takeoutcabinet.email.SendEmailService;
import com.zhy.takeoutcabinet.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class SendEmailServiceImpl implements SendEmailService {
    @Resource
    JavaMailSender mailSender;
    // 发送方，从配置文件中获取
    @Value("${spring.mail.username}")
    private String sender;
    @Override
    public boolean sendEmail(User user, String subject, String text) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setTo(user.getEmail());
            mimeMessageHelper.setText(user.getPhone() + text);
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            return false;
        }
        return true;
    }
}
