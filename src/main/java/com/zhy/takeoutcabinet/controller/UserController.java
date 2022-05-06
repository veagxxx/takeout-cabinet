package com.zhy.takeoutcabinet.controller;

import com.zhy.takeoutcabinet.entity.PageInfo;
import com.zhy.takeoutcabinet.entity.User;
import com.zhy.takeoutcabinet.file.ImageService;
import com.zhy.takeoutcabinet.service.OrderService;
import com.zhy.takeoutcabinet.service.UserService;
import com.zhy.takeoutcabinet.utils.ResponseJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    @Resource
    OrderService orderService;

    @Autowired
    ImageService imageService;

    // 获取所有用户
    @GetMapping("/list")
    public PageInfo findAllUsers(@RequestParam("keywords") Object keywords,
                                   @RequestParam("pageNum") int pageNum,
                                   @RequestParam("pageSize") int pageSize) {
        return userService.findAllByPage((pageNum - 1 )* pageSize, pageSize, keywords);
    }
    @GetMapping("/users")
    public Map<String, Object> queryAllUsers() {
        List<User> users = userService.queryAllUsers();
        System.out.println("users: " + users);
        return ResponseJSON.success("success", users);
    }
    // 添加用户
    @PostMapping("/insert")
    public Object insertUser(@RequestBody User user) {
        // System.out.println(user);
        if (user == null) {
            return ResponseJSON.error500("添加数据为空");
        }
        userService.insertUser(user);
        return ResponseJSON.success("SUCCESS");
    }

    /**
     * 修改用户
     * @param user user
     * @return json
     */
    @PutMapping("/update")
    public Object updateUser(@RequestBody User user) {
        System.out.println(user);
        int effect = userService.updateUserById(user);
        if (effect > 0) {
            return ResponseJSON.success("操作成功");
        } else {
            return ResponseJSON.error400("操作失败");
        }
    }

    /**
     * 删除用户
     * @param id 用户id
     * @return json
     */
    @DeleteMapping("/delete/{id}")
    public Object deleteUser(@PathVariable("id") int id) {
        // System.out.println(id);
        // 先删除用户关联的订单
        int count = orderService.deleteOrderByUserId(id);
        int effect = 0;
        // 后删除用户数据
        if (count >= 0) {
             effect = userService.deleteUserById(id);
        }
        if (effect > 0) {
            return ResponseJSON.success("删除成功");
        } else {
            return ResponseJSON.error500("删除失败");
        }
    }

    @GetMapping("/total")
    public Map<String, Object> queryUserCount() {
        int total = userService.findTotal();
        List<User> users = userService.queryAllUsers();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setTotal(total);
        pageInfo.setList(users);
        return ResponseJSON.success("success", pageInfo);
    }

    /**
     * 存储用户头像
     * @param avatarFile 头像文件
     * @param request request
     * @return url
     */
    @PostMapping("/avatar")
    public Map<String, Object> uploadUserAvatar(@RequestParam MultipartFile avatarFile,
                                                HttpServletRequest request) {
        String avatarUrl = imageService.uploadImage(avatarFile, request);
        if (avatarUrl.equals("error")) {
            return ResponseJSON.error500("保存失败");
        }
        if (avatarUrl.equals("")) {
            return ResponseJSON.error400("图片格式有误，请上传.jpg、.png、.jpeg格式的文件");
        }
        return ResponseJSON.success("success", avatarUrl);
    }
}
