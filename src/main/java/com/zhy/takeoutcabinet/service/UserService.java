package com.zhy.takeoutcabinet.service;

import com.zhy.takeoutcabinet.entity.PageInfo;
import com.zhy.takeoutcabinet.entity.User;

import java.util.List;

public interface UserService {

    User findUserByUsername(String username);

    /**
     * 分页查询
     * @param startIndex 开始索引
     * @param pageSize 每页数量
     * @return 分页用户列表
     */
    PageInfo findAllByPage(int startIndex, int pageSize, Object keywords);

    /**
     * 根据 id 查询用户
     * @param userId 用户 id
     * @return 用户
     */
    User findById(int userId);

    /**
     * 查询总数
     * @return 总数
     */
    int findTotal();

    /**
     * 添加用户
     * @param user 用户
     */
    void insertUser(User user);

    /**
     * 修改用户
     * @param user 用户
     * @return 1
     */
    int updateUserById(User user);

    /**
     * 根据id删除用户
     * @param id 用户id
     * @return 1
     */
    int deleteUserById(Integer id);

    User findByOpenId(String openId);

    /**
     * 查询所有用户
     * @return 集合
     */
    List<User> queryAllUsers();
}
