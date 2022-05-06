package com.zhy.takeoutcabinet.email;

import com.zhy.takeoutcabinet.entity.User;

public interface SendEmailService {
    boolean sendEmail(User user, String subject, String text);
}
