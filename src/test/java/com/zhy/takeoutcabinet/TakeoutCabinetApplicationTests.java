package com.zhy.takeoutcabinet;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.zhy.takeoutcabinet.entity.Menu;
import com.zhy.takeoutcabinet.service.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class TakeoutCabinetApplicationTests {

    @Resource
    MenuService menuService;

    @Test
    void contextLoads() {
        List<Menu> menus = menuService.queryAllMenu();
        System.out.println(menus);
    }

}
