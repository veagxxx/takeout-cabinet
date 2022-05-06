package com.zhy.takeoutcabinet.service;

import com.zhy.takeoutcabinet.entity.Menu;

import java.util.List;

public interface MenuService {

    /**
     * 查询所有菜单
     * @return list
     */
    List<Menu> queryAllMenu();
}
