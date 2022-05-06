package com.zhy.takeoutcabinet.service;

import com.zhy.takeoutcabinet.entity.OrderOperate;

import java.util.List;

public interface OrderOperateService {

    List<OrderOperate> findAllOperationByOrderId(Integer orderId);

    int insertOperate(OrderOperate operate);
}
