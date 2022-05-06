package com.zhy.takeoutcabinet.schedule;

import com.zhy.takeoutcabinet.entity.Order;
import com.zhy.takeoutcabinet.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@EnableScheduling
@Component
public class OrderSchedule {

    private OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * cron ="0 0 0,6,12,18,21 * * " 每天的0点，6点，12点，18点都执行一次
     */
    @Scheduled(cron = "0 0 0,6,12,18 * * ?")
    public void OrderNoEvaluateTask() {
        List<Order> orders = orderService.findOrderByOrderStatus(2);
        if (orders.isEmpty()) return;
        for (Order order : orders) {
            if (((new Date().getTime() - order.getActualPickTime().getTime()) / (1000 * 3600 * 24)) >= 3) {
                System.out.println("超时未评价订单，订单id为：" + order.getOrderId());
//                orderService.finishOrder(order);
            }
        }
    }
    @Scheduled(cron = "0 0 0,6,12,18 * * ?")
    public void OrderNoPickTask() {
        List<Order> orders = orderService.findOrderByOrderStatus(1);
        if (orders.isEmpty()) return;
        for (Order order : orders) {
            if (((new Date().getTime() - order.getOrderPickTime().getTime()) / (1000 * 3600 * 24)) >= 1) {
                System.out.println("超时未取订单，订单号为：" + order.getOrderNo());
//                orderService.pickOrder(order);
            }
        }
    }
}
