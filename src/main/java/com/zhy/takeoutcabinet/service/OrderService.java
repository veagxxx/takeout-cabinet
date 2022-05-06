package com.zhy.takeoutcabinet.service;

import com.zhy.takeoutcabinet.entity.Order;
import com.zhy.takeoutcabinet.entity.OrderSetting;
import org.aspectj.weaver.ast.Or;

import java.util.List;

public interface OrderService {

    /**
     * 根据 id 查询订单
     * @param orderId 订单 id
     * @return 订单
     */
    Order findOrderById(int orderId);

    /**
     * 查询所有订单
     * @return 订单总数
     */
    int findUserOrderCount(Integer userId);

    /**
     * 完成订单
     * @param order 修改状态
     */
    int finishOrder(Order order);

    /**
     * 删除用户同时删除用户关联的订单
     * @param userId 用户 id
     * @return 影响行数
     */
    int deleteOrderByUserId(Integer userId);

    /**
     * 小程序根据用户 id 分页查询待取订单
     * @param userId 用户id
     * @return 订单
     */
    List<Order> findNotPickByUserIdByPage(Integer userId, Integer orderStatus, int pageSize);

    /**
     * 修改订单设置
     * @param orderSetting 设置参数
     * @return 影响行数
     */
    int updateOrderSetting(OrderSetting orderSetting);

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
     * 查询所有订单（作数据统计）
     * @return 订单
     */
    List<Order> queryOrderForChart();

    /**
     * 管理员添加订单
     * @param order 订单信息
     * @return 1
     */
    int adminInsertOrder(Order order);

    /**
     * 根据用户id查询订单
     * @param userId 用户id
     * @return orders
     */
    List<Order> findAllOrderWithUserIdByPage(Integer userId, int pageSize);

    /**
     * 根据订单状态查询订单
     * @param orderStatus 订单状态
     * @return orders
     */
    List<Order> findOrderByOrderStatus(Integer orderStatus);
    /**
     * 订单已取
     * @param order 订单状态
     * @return 1
     */
    int pickOrder(Order order);

    /**
     * 根据id删除订单
     * @param orderId 订单id
     * @return 1
     */
    int deleteOrderByOrderId(Integer orderId);
}
