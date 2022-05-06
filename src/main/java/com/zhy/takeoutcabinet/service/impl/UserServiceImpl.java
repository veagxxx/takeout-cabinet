package com.zhy.takeoutcabinet.service.impl;

import com.zhy.takeoutcabinet.entity.PageInfo;
import com.zhy.takeoutcabinet.entity.User;
import com.zhy.takeoutcabinet.mapper.UserMapper;
import com.zhy.takeoutcabinet.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    public UserMapper userMapper;
    @Override
    public User findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }

    @Override
    public PageInfo findAllByPage(int startIndex, int pageSize, Object keywords) {
        List<User> users = userMapper.findAll(startIndex, pageSize);
        PageInfo pageInfo = new PageInfo();
        if (!users.isEmpty()) {
            users = users.stream().filter(user ->
                    user.getUsername().contains((String) keywords) ||
                            user.getPhone().contains((String) keywords))
                    .collect(Collectors.toList());
            int total = userMapper.findTotal();
            pageInfo.setList(users);
            pageInfo.setTotal(total);
        } else {
            pageInfo.setList(new ArrayList<>());
            pageInfo.setTotal(0);
        }
        return pageInfo;
    }

    @Override
    public User findById(int userId) {
        return userMapper.findById(userId);
    }

    @Override
    public int findTotal() {
        return userMapper.findTotal();
    }

    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public int updateUserById(User user) {
        return userMapper.updateUserById(user);
    }

    @Override
    public int deleteUserById(Integer id) {
        return userMapper.deleteUserById(id);
    }

    @Override
    public User findByOpenId(String openId) {
        return userMapper.findByOpenId(openId);

    }

    @Override
    public List<User> queryAllUsers() {
        List<User> users = userMapper.queryAllUsers();
        if (users.isEmpty())  {
            return null;
        }
        return users;
    }
}
