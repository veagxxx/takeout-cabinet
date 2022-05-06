package com.zhy.takeoutcabinet.controller.uniapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhy.takeoutcabinet.entity.OpenIdJson;
import com.zhy.takeoutcabinet.entity.User;
import com.zhy.takeoutcabinet.service.UserService;
import com.zhy.takeoutcabinet.utils.HttpUtil;
import com.zhy.takeoutcabinet.utils.ResponseJSON;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("uni")
public class UniLoginController {

    @Resource
    UserService userService;

    String appId = "wx0ccbc2533003198c";
    String secret = "519f16ca6a5ab31a6d21c50cb78843f9";

    /**
     * 获取 openId
     * @param code
     * @return 用户信息
     */
    @GetMapping("/getOpenId")
    public Map<String, Object> getOpenId(@RequestParam("code") String code) {
        String result = "";
        try {
            result = HttpUtil.doGet("https://api.weixin.qq.com/sns/jscode2session?appid="
                    + this.appId + "&secret="
                    + this.secret + "&js_code="
                    + code
                    + "&grant_type=authorization_code", null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
        OpenIdJson openIdJson = null;
        try {
            openIdJson = mapper.readValue(result, OpenIdJson.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ResponseJSON.success("success", openIdJson);
    }

    @GetMapping("/login/{openId}")
    public Object doLogin(@PathVariable("openId") String openId) {
        // System.out.println("openId: " + openId);
        User user = userService.findByOpenId(openId);
        if (user != null) {
            return ResponseJSON.success("success", user);
        } else {
            return ResponseJSON.error500("查询为空");
        }
    }
}
