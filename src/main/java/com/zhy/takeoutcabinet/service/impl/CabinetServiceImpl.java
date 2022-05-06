package com.zhy.takeoutcabinet.service.impl;

import com.zhy.takeoutcabinet.entity.Cabinet;
import com.zhy.takeoutcabinet.entity.Mode;
import com.zhy.takeoutcabinet.entity.Order;
import com.zhy.takeoutcabinet.mapper.CabinetMapper;
import com.zhy.takeoutcabinet.service.CabinetService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CabinetServiceImpl implements CabinetService {

    @Resource
    private CabinetMapper cabinetMapper;
    @Override
    public List<Cabinet> findAll(int startIndex, int pageSize) {
        return cabinetMapper.findAll(startIndex, pageSize);
    }

    @Override
    public int findTotal() {
        return cabinetMapper.findTotal();
    }

    @Override
    public List<Mode> findAllMode() {
        return cabinetMapper.queryModes();
    }

    @Override
    public List<Cabinet> queryUsingCabinets() {
        return cabinetMapper.queryAll();
    }

    @Override
    public Cabinet findCabinetWithOrderByCabinetId(Integer cabinetId) {
        Cabinet cabinet = cabinetMapper.findCabinetWithOrderByCabinetId(cabinetId);
        if (!cabinet.getOrders().isEmpty()) {
            List<Order> orders = cabinet.getOrders();
            orders = orders.stream().filter(order ->
                    order.getOrderStatus() == 1)
                    .collect(Collectors.toList());
            cabinet.setOrders(orders);
        }
        return cabinet;
    }

    @Override
    public int updateCabinetStatusById(Cabinet cabinet) {
        return cabinetMapper.updateCabinetById(cabinet);
    }

    @Override
    public Boolean findCabinetsByPosition(Cabinet insertCabinet) {
        List<Cabinet> cabinets = cabinetMapper.findCabinetsByPosition(insertCabinet.getCabinetPosition());
        boolean flag = true;
        if (!cabinets.isEmpty()) {
            for (Cabinet cabinet : cabinets) {
                if (cabinet.getCabinetNo().equals(insertCabinet.getCabinetNo())) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    @Override
    public int addCabinet(Cabinet cabinet) {
        return cabinetMapper.insertCabinet(cabinet);
    }
}
