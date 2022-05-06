package com.zhy.takeoutcabinet.controller.uniapp;

import com.zhy.takeoutcabinet.entity.Comment;
import com.zhy.takeoutcabinet.entity.Order;
import com.zhy.takeoutcabinet.entity.OrderOperate;
import com.zhy.takeoutcabinet.service.CommentService;
import com.zhy.takeoutcabinet.service.OrderOperateService;
import com.zhy.takeoutcabinet.service.OrderService;
import com.zhy.takeoutcabinet.utils.ResponseJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/uni")
public class UniCommentController {
    
    @Resource
    CommentService commentService;
    @Resource
    OrderService orderService;
    @Resource
    OrderOperateService operateService;


    @PostMapping("/comment/insert/{username}/{orderId}")
    public Map<String, Object> insertComment(@RequestBody Comment comment,
                                             @PathVariable("username") String username,
                                             @PathVariable("orderId") int orderId) {
        Order order = orderService.findOrderById(orderId);
        order.setOrderStatus(order.getOrderStatus() + 1);
        order.setOrderId(orderId);
        order.setOrderFinishTime(new Date());
        int finish = orderService.finishOrder(order);
        OrderOperate orderOperate = new OrderOperate();
        orderOperate.setOperateMan(username);
        orderOperate.setOperateTime(new Date());
        orderOperate.setBeforeStatus(order.getOrderStatus());
        orderOperate.setAfterStatus(order.getOrderStatus() + 1);
        orderOperate.setNote("用户完成评价");
        orderOperate.setOrder(order);
        if (finish > 0) {
            int effect = commentService.evaluateOrder(comment);
            if (effect > 0) {
                operateService.insertOperate(orderOperate);
                return ResponseJSON.success("success");
            }
            else return ResponseJSON.error500("error");
        } else {
            return ResponseJSON.error500("error");
        }
    }
}
