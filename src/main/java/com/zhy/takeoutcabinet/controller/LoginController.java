package com.zhy.takeoutcabinet.controller;


import com.zhy.takeoutcabinet.entity.User;
import com.zhy.takeoutcabinet.service.UserService;
import com.zhy.takeoutcabinet.utils.ResponseJSON;
import com.zhy.takeoutcabinet.utils.TokenUtils;
import com.zhy.takeoutcabinet.utils.VerificationCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Resource
    UserService userService;
    // 记录验证码
    private String verifyCode;

    // 登录
    @PostMapping("/login")
    public Map<String, Object> doLogin(HttpServletRequest request,
                                       @RequestParam("username") String username,
                                       @RequestParam("password") String password,
                                       @RequestParam("captcha") String captcha) {
        User user = userService.findUserByUsername(username);
        if (user == null) {
            return ResponseJSON.error500("用户不存在");
        } else if (!user.getPassword().equals(password)) {
            return ResponseJSON.error500("用户名或密码错误");
        } else if (!captcha.toLowerCase().equals(verifyCode.toLowerCase())) {
            return ResponseJSON.error500("验证码错误");
        }
        String token = TokenUtils.createToken(username);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("token", token);
        map.put("data", user);
        return map;
    }

    // 获取验证码
    @GetMapping("/captcha")
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        VerificationCode code = new VerificationCode();
        BufferedImage image = code.getImage();
        verifyCode = code.getCaptcha();
        // HttpSession session = request.getSession();
        // session.setAttribute("captcha", verifyCode);
        VerificationCode.outputImage(image, response.getOutputStream());
    }
}
