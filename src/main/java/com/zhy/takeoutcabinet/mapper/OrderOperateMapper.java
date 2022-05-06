package com.zhy.takeoutcabinet.mapper;

import com.zhy.takeoutcabinet.entity.OrderOperate;

import java.util.List;

public interface OrderOperateMapper {

    List<OrderOperate> findAllOperationByOrderId(Integer orderId);

    int insertOperate(OrderOperate operate);
}
