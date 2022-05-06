package com.zhy.takeoutcabinet.mapper;

import com.zhy.takeoutcabinet.entity.Menu;

import java.util.List;

public interface MenuMapper {
    /**
     * 查询所有菜单
     * @return list
     */
    List<Menu> queryAllMenu();
}
