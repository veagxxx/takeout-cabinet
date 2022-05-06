package com.zhy.takeoutcabinet.service.impl;

import com.zhy.takeoutcabinet.entity.Menu;
import com.zhy.takeoutcabinet.mapper.MenuMapper;
import com.zhy.takeoutcabinet.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    MenuMapper menuMapper;
    @Override
    public List<Menu> queryAllMenu() {
        return menuMapper.queryAllMenu();
    }
}
