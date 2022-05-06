package com.zhy.takeoutcabinet.controller.uniapp;

import com.zhy.takeoutcabinet.entity.Order;
import com.zhy.takeoutcabinet.entity.OrderOperate;
import com.zhy.takeoutcabinet.entity.User;
import com.zhy.takeoutcabinet.service.OrderOperateService;
import com.zhy.takeoutcabinet.service.OrderService;
import com.zhy.takeoutcabinet.service.UserService;
import com.zhy.takeoutcabinet.utils.ResponseJSON;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("uni")
public class UniOrderController {

    @Resource
    OrderService orderService;
    @Resource
    OrderOperateService operateService;

    @GetMapping("/notPickOrders/{userId}/{pageSize}")
    public Object findOrderByUserId(@PathVariable("userId") int userId,
                                    @PathVariable("pageSize") int pageSize) {
        List<Order> orders = orderService.findNotPickByUserIdByPage(userId, 1, pageSize);
        return ResponseJSON.success("success", orders);
    }

    @GetMapping("/orders/total/{userId}")
    public Map<String, Object> getTotal(@PathVariable("userId") int userId) {
        int total = orderService.findUserOrderCount(userId);
        return ResponseJSON.success("success", total);
    }

    @GetMapping("/orders/{userId}/{count}")
    public Map<String, Object> findAllOrderByUserId(@PathVariable("userId") int userId,
                                                    @PathVariable("count") int count) {
        List<Order> orders = orderService.findAllOrderWithUserIdByPage(userId, count);
        if (orders.isEmpty()) {
            return ResponseJSON.error500("查询为空");
        }
        return ResponseJSON.success("success", orders);
    }

    @PutMapping("/order/pick")
    public Map<String, Object> pickOrder(@RequestBody Order order) {
        order.setActualPickTime(new Date());
        Order orderById = orderService.findOrderById(order.getOrderId());
        OrderOperate orderOperate = new OrderOperate();
        orderOperate.setBeforeStatus(order.getOrderStatus() - 1);
        orderOperate.setOperateMan(orderById.getUser().getUsername());
        orderOperate.setOperateTime(order.getActualPickTime());
        orderOperate.setNote("用户已取订单");
        orderOperate.setOrder(order);
        orderOperate.setAfterStatus(order.getOrderStatus());
        // 添加一条操作信息
        operateService.insertOperate(orderOperate);
        int effect = orderService.pickOrder(order);
        if (effect > 0) return ResponseJSON.success("success");
        else return ResponseJSON.error500("error");
        // return ResponseJSON.success("success");
    }

    @DeleteMapping("/order/delete/{orderId}")
    public Map<String, Object> deleteOrder(@PathVariable("orderId") int orderId) {
        System.out.println(orderId);
        return ResponseJSON.success("success");
    }

    @PostMapping("/order/insert")
    public Map<String, Object> insertOrder(@RequestBody Order order) {
        //System.out.println(order);
        int effect = orderService.adminInsertOrder(order);
        if (effect > 0) {
            return ResponseJSON.success("success");
        } else {
            return ResponseJSON.error500("error");
        }
        //return ResponseJSON.success("success");
    }
}
