package com.zhy.takeoutcabinet.controller;

import com.zhy.takeoutcabinet.entity.OrderOperate;
import com.zhy.takeoutcabinet.service.OrderOperateService;
import com.zhy.takeoutcabinet.utils.ResponseJSON;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/operate")
public class OrderOperateController {

    @Resource
    OrderOperateService operateService;

    @GetMapping("/operation/{orderId}")
    public List<OrderOperate> findOperationById(@PathVariable("orderId") int orderId) {
        return operateService.findAllOperationByOrderId(orderId);
    }

    @PostMapping("/insert")
    public Object insertOperate(@RequestBody OrderOperate operate) {
        int effect = operateService.insertOperate(operate);
        if (effect == 0) {
            return ResponseJSON.error500("error");
        }
        return ResponseJSON.success("success");
    }
}
