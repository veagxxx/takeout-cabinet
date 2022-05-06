package com.zhy.takeoutcabinet.mapper;

import com.zhy.takeoutcabinet.entity.User;

import java.util.List;

public interface UserMapper {
    /**
     * 根据用户名查询
     * @param username username
     * @return User
     */
    User findUserByUsername(String username);

    /**
     * 分页查询
     * @param startIndex 开始索引
     * @param pageSize 分页大小
     * @return list 集合
     */
    List<User> findAll(int startIndex, int pageSize);

    /**
     * 根据 id 查询用户
     * @param userId 用户 id
     * @return User 对象
     */
    User findById(int userId);

    /**
     * 根据 openId 查询用户
     * @param openId openId
     * @return 用户
     */
    User findByOpenId(String openId);
    /**
     * 查询总数
     * @return 总数
     */
    int findTotal();

    /**
     * 添加用户
     * @param user 用户对象
     */
    void insertUser(User user);

    /**
     * 根据 id 修改用户
     * @param user 用户对象
     * @return 影响行数
     */
    int updateUserById(User user);

    /**
     * 根据 id 删除用户
     * @param id id
     * @return 影响行数
     */
    int deleteUserById(Integer id);

    /**
     * 查询所有用户
     * @return 集合
     */
    List<User> queryAllUsers();
}
