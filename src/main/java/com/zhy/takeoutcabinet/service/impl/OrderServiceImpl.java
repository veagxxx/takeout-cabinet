package com.zhy.takeoutcabinet.service.impl;

import com.zhy.takeoutcabinet.entity.Order;
import com.zhy.takeoutcabinet.entity.OrderSetting;
import com.zhy.takeoutcabinet.mapper.OrderMapper;
import com.zhy.takeoutcabinet.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Resource
    OrderMapper orderMapper;

    /**
     * 分页+多条件搜索查询订单
     * @param startIndex 开始索引
     * @param pageSize 每页记录数
     * @param order 查询信息
     * @return 订单集合
     */
    @Override
    public List<Order> findByPageAndQuery(int startIndex, int pageSize, Order order) {
        return orderMapper.findByPageAndQuery(startIndex, pageSize, order);
    }

    /**
     * 分页加查询条件获取总数
     * @param order 查询信息
     * @return int
     */
    @Override
    public int findTotalBySearch(Order order) {
        if (order == null) return 0;
        return orderMapper.findTotalBySearch(order);
    }

    /**
     * 查询所有订单，数据统计
     * @return 订单集合
     */
    @Override
    public List<Order> queryOrderForChart() {
        List<Order> orders = orderMapper.queryAllOrders();
        if (!orders.isEmpty()) return orders;
        return new ArrayList<>();
    }

    /**
     * 管理员添加订单
     * @param order 订单信息
     * @return 1
     */
    @Override
    public int adminInsertOrder(Order order) {
        if (order == null) return 0;
        return orderMapper.insertOrder(order);
    }

    /**
     * 小程序分页查询用户的所有订单
     * @param userId 用户id
     * @return list
     */
    @Override
    public List<Order> findAllOrderWithUserIdByPage(Integer userId, int pageSize) {
        if (userId <= 0) return new ArrayList<>();
        List<Order> orders = orderMapper.findOrderByUserWithPage(userId, null, pageSize);
        if (!orders.isEmpty()) {
            return orders;
        }
        return new ArrayList<>();
    }

    /**
     * 根据订单状态查询订单
     * @param orderStatus 订单状态
     * @return orders
     */
    @Override
    public List<Order> findOrderByOrderStatus(Integer orderStatus) {
        if (orderStatus < 0) return new ArrayList<>();
        List<Order> orders = orderMapper.findOrderByOrderStatus(null, orderStatus);
        if (!orders.isEmpty()) {
            return orders;
        }
        return new ArrayList<>();
    }

    /**
     * 订单已取操作
     * @param order 订单状态
     * @return 1
     */
    @Override
    public int pickOrder(Order order) {
        if (order == null) {
            return 0;
        }
        return orderMapper.updateStatusById(order);
    }

    @Override
    public int deleteOrderByOrderId(Integer orderId) {
        if (orderId <= 0) return 0;
        return orderMapper.deleteOrderByOrderId(orderId);
    }

    /**
     * 查询用户订单总数
     * @Param userId 用户id
     * @return 数量
     */
    @Override
    public int findUserOrderCount(Integer userId) {
        if (userId <= 0) {
            return 0;
        } else {
            return orderMapper.findOrderTotalByUser(userId);
        }
    }

    /**
     * 根据订单id查询订单
     * @param orderId 订单 id
     * @return 订单
     */
    @Override
    public Order findOrderById(int orderId) {
        if (orderId <= 0) return null;
        return orderMapper.findById(orderId);
    }

    /**
     * 完成订单
     * @param order 修改状态
     * @return 1
     */
    @Override
    public int finishOrder(Order order) {
        if (order == null) {
            return 0;
        }
        return orderMapper.updateStatusById(order);
    }

    /**
     * 根据用户id删除订单
     * @param userId 用户 id
     * @return 1
     */
    @Override
    public int deleteOrderByUserId(Integer userId) {
        if (userId <= 0) return 0;
        return orderMapper.deleteOrderByUserId(userId);
    }

    /**
     * 小程序分页查询用户待取订单
     * @param userId 用户id
     * @param orderStatus 订单状态
     * @return list
     */
    @Override
    public List<Order> findNotPickByUserIdByPage(Integer userId, Integer orderStatus, int pageSize) {
        if (userId == 0) {
            return null;
        }
        List<Order> orders = orderMapper.findOrderByUserWithPage(userId, orderStatus, pageSize);
        if (orders.isEmpty()) {
            return null;
        }
        return orders;
    }

    /**
     * 修改订单设置
     * @param orderSetting 设置参数
     * @return 1
     */
    @Override
    public int updateOrderSetting(OrderSetting orderSetting) {
        return orderMapper.updateSetting(orderSetting);
    }

}
