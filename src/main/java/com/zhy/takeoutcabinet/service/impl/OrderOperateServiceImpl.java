package com.zhy.takeoutcabinet.service.impl;

import com.zhy.takeoutcabinet.entity.OrderOperate;
import com.zhy.takeoutcabinet.mapper.OrderOperateMapper;
import com.zhy.takeoutcabinet.service.OrderOperateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderOperateServiceImpl implements OrderOperateService {
    @Resource
    OrderOperateMapper orderOperateMapper;

    @Override
    public List<OrderOperate> findAllOperationByOrderId(Integer orderId) {
        return orderOperateMapper.findAllOperationByOrderId(orderId);
    }

    @Override
    public int insertOperate(OrderOperate operate) {
        if (operate == null) {
            return 0;
        }
        return orderOperateMapper.insertOperate(operate);
    }
}
