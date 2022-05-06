package com.zhy.takeoutcabinet.mapper;

import com.zhy.takeoutcabinet.entity.SettingInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SettingMapper {
    /**
     * 查询所有系统设置的信息
     * @return 集合
     */
    List<SettingInfo> querySettingInfo();

    /**
     * 条件查询设置
     * @return 集合
     */
    List<SettingInfo> queryOneSettingInfo();

    /**
     * 根据id修改设置信息
     * @param settingInfo 修改的设置信息
     * @return 影响行数
     */
    int updateSetting(SettingInfo settingInfo);

    /**
     * 添加设置信息
     * @param settingInfo 设置信息
     * @return 1
     */
    int insertSettingInfo(SettingInfo settingInfo);
}
