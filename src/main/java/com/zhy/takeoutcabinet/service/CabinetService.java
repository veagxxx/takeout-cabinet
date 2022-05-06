package com.zhy.takeoutcabinet.service;

import com.zhy.takeoutcabinet.entity.Cabinet;
import com.zhy.takeoutcabinet.entity.Mode;

import java.util.List;

public interface CabinetService {
    /**
     * 查询所有
     * @return 集合
     */
    List<Cabinet> findAll(int startIndex, int pageSize);

    /**
     * 查询总数
     * @return 总数
     */
    int findTotal();
    /**
     * 查询所有模式
     * @return 集合
     */
    List<Mode> findAllMode();

    /**
     * 获取所有使用的取餐柜
     * @return list
     */
    List<Cabinet> queryUsingCabinets();
    /**
     * 根据 id 查询订单及取餐柜
     * @param cabinetId id
     * @return 取餐柜
     */
    Cabinet findCabinetWithOrderByCabinetId(Integer cabinetId);

    /**
     * 修改取餐柜状态
     * @param cabinet Cabinet对象
     * @return 1
     */
    int updateCabinetStatusById(Cabinet cabinet);

    /**
     * 根据地址查询取餐柜
     * @param cabinet 取餐柜信息
     * @return true / false
     */
    Boolean findCabinetsByPosition(Cabinet cabinet);

    /**
     * 添加取餐柜
     * @param cabinet 取餐柜信息
     * @return 1
     */
    int addCabinet(Cabinet cabinet);
}
