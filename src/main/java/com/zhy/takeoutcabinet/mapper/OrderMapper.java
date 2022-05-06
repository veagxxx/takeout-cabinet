package com.zhy.takeoutcabinet.mapper;

import com.zhy.takeoutcabinet.entity.Order;
import com.zhy.takeoutcabinet.entity.OrderSetting;

import java.util.List;

public interface OrderMapper {
    /**
     * 分页查询所有订单
     * @param startIndex 开始索引
     * @param pageSize 分页大小
     * @return 订单集合
     */
    List<Order> findAll(int startIndex, int pageSize);

    /**
     * 根据 id 查询订单
     * @param orderId 订单 id
     * @return 订单
     */
    Order findById(int orderId);

    /**
     * 查询用户所有订单的总数
     * @return 订单总数
     */
    int findOrderTotalByUser(Integer userId);

    /**
     * 修改订单状态
     * @param order 修改订单
     */
    int updateStatusById(Order order);

    /**
     * 删除用户同时删除用户关联的订单
     * @param userId 用户 id
     * @return 影响行数
     */
    int deleteOrderByUserId(Integer userId);

    /**
     * 根据用户 id 查询订单
     * @param userId 用户id
     * @return 订单
     */
    List<Order> findOrderByOrderStatus(Integer userId, Integer orderStatus);

    /**
     * 分页查询用户订单
     * @param userId 用户id
     * @param orderStatus 订单状态
     * @param pageSize 分页大小
     * @return 集合
     */
    List<Order> findOrderByUserWithPage(Integer userId, Integer orderStatus, Integer pageSize);

    /**
     * 修改订单设置
     * @param orderSetting 设置参数
     * @return 影响行数
     */
    int updateSetting(OrderSetting orderSetting);

    /**
     * 分页+多条件搜索查询订单
     * @param startIndex 开始索引
     * @param pageSize 每页记录数
     * @param order 查询信息
     * @return 订单集合
     */
    List<Order> findByPageAndQuery(int startIndex, int pageSize, Order order);

    /**
     * 根据多条件搜索查询总数
     * @param order 查询信息
     * @return 总数
     */
    int findTotalBySearch(Order order);

    /**
     * 查询所有订单（无条件）
     * @return 集合
     */
    List<Order> queryAllOrders();

    /**
     * 添加订单
     * @param order 订单
     * @return 1
     */
    int insertOrder(Order order);

    /**
     * 根据订单 id 删除订单
     * @param orderId 订单 id
     * @return 1
     */
    int deleteOrderByOrderId(Integer orderId);
}
