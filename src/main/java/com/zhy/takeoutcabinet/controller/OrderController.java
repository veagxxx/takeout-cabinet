package com.zhy.takeoutcabinet.controller;

import com.zhy.takeoutcabinet.email.SendEmailService;
import com.zhy.takeoutcabinet.entity.Order;
import com.zhy.takeoutcabinet.entity.OrderSetting;
import com.zhy.takeoutcabinet.entity.PageInfo;
import com.zhy.takeoutcabinet.service.OrderService;
import com.zhy.takeoutcabinet.service.UserService;
import com.zhy.takeoutcabinet.utils.ResponseJSON;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    OrderService orderService;
    @Resource
    UserService userService;
    @Resource
    SendEmailService sendEmailService;
    /**
     * 分页+多条件查询订单
     * @param pageNum 当前页
     * @param pageSize 每页记录数
     * @param order 查询信息
     * @return 分页结果
     */
    @PostMapping("/orders/{pageNum}/{pageSize}")
    public PageInfo findAllOrder(@PathVariable("pageNum") int pageNum,
                                 @PathVariable("pageSize") int pageSize,
                                 @RequestBody Order order) {
        int total = orderService.findTotalBySearch(order);
        // int total = orderService.findOrderTotal();
        List<Order> orders = orderService.findByPageAndQuery((pageNum - 1) * pageSize, pageSize, order);
        PageInfo pageInfo = new PageInfo();
        pageInfo.setList(orders);
        pageInfo.setTotal(total);
        return pageInfo;
    }
    /**
     * 取餐提醒
     * @param orderId 订单id
     * @return json
     */
    @GetMapping("/remind/{orderId}")
    public Object remind(@PathVariable("orderId") int orderId) {
        Order order = orderService.findOrderById(orderId);
//        System.out.println(order);
        if (order.getUser().getEmail() == null) {
            return ResponseJSON.error400("用户邮箱为空");
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String text = "用户你好，你的取餐时间为: " +
                simpleDateFormat.format(order.getOrderPickTime())
                + "，请及时到指定地点取餐。"
                + "取餐地点为: " + order.getCabinet().getCabinetPosition()
                + "，取餐码为：" + order.getOrderCode() + "。谢谢配合!";
        boolean email = sendEmailService.sendEmail(order.getUser(), "智能外卖取餐柜取餐提醒", text);
        if (email) {
            return ResponseJSON.success("success");
        } else {
            return ResponseJSON.error500("发送失败");
        }
    }

    /**
     * 完成订单
     * @param order 订单
     * @return json
     */
    @PutMapping("/finish")
    public Object finishOrder(@RequestBody Order order) {
        int effect = orderService.finishOrder(order);
        if (effect > 0) return ResponseJSON.success("success");
        else return ResponseJSON.error500("error");
    }

    /**
     * 根据 id 删除订单
     * @param orderId 订单 id
     * @return 状态码和消息
     */
    @DeleteMapping("/delete/{orderId}")
    public Object deleteOrder(@PathVariable("orderId") int orderId) {
//        System.out.println(orderId);
        int effect = orderService.deleteOrderByOrderId(orderId);
        if (effect > 0) {
            return ResponseJSON.success("删除成功");
        } else {
            return ResponseJSON.error400("删除失败");
        }
    }

    /**
     * 修改订单设置
     * @param setting 设置参数
     * @return code + message
     */
    @PutMapping("/setting")
    public Object updateOrderSetting(@RequestBody OrderSetting setting) {
        // System.out.println(setting);
        int effect = orderService.updateOrderSetting(setting);
        if (effect > 0) {
            return ResponseJSON.success("修改成功");
        } else {
            return ResponseJSON.error500("修改失败");
        }
    }

    @GetMapping("/orders")
    public Map<String, Object> queryForChart() {
        List<Order> orders = orderService.queryOrderForChart();
        return ResponseJSON.success("success", orders);
    }

    @PostMapping("/insert")
    public Map<String, Object> insertOrder(@RequestBody Order order) {
        // System.out.println(order);
        int effect = orderService.adminInsertOrder(order);
        if (effect > 0) {
            return ResponseJSON.success("success");
        } else {
            return ResponseJSON.error500("error");
        }
    }
}
