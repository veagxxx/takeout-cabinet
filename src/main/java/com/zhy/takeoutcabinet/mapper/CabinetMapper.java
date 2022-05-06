package com.zhy.takeoutcabinet.mapper;

import com.zhy.takeoutcabinet.entity.Cabinet;
import com.zhy.takeoutcabinet.entity.Mode;

import java.util.List;

public interface CabinetMapper {
    /**
     * 查询所有取餐柜
     * @return list
     */
    List<Cabinet> findAll(int startIndex, int pageSize);

    /**
     * 无条件查询所有
     * @return list
     */
    List<Cabinet> queryAll();
    /**
     * 查询总数
     * @return int
     */
    int findTotal();
    /**
     * 一对多查询，根据id查询取餐柜的信息
     * @param cabinetId cabinetId
     * @return Cabinet 对象
     */
    Cabinet findCabinetWithOrderByCabinetId(Integer cabinetId);

    /**
     * 根据 id 修改取餐柜状态
     * @param cabinet cabinet
     * @return 影响行数
     */
    int updateCabinetById(Cabinet cabinet);

    /**
     * 获取所有模式
     * @return 集合
     */
    List<Mode> queryModes();

    /**
     * 根据地址查询取餐柜
     * @param position 地址
     * @return 集合
     */
    List<Cabinet> findCabinetsByPosition(String position);

    /**
     * 添加取餐柜
     * @param cabinet cabinet
     * @return 1
     */
    int insertCabinet(Cabinet cabinet);
}
