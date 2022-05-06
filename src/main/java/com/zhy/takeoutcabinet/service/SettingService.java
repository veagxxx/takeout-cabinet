package com.zhy.takeoutcabinet.service;

import com.zhy.takeoutcabinet.entity.SettingInfo;

import java.util.List;
import java.util.Map;

public interface SettingService {
    /**
     * 查询所有系统设置信息
     * @return 集合
     */
    List<SettingInfo> querySettingInfo();

    /**
     * 查询正在使用的设置
     * @return list
     */
    SettingInfo querySettingIsUsing();

    /**
     * 根据id修改设置信息
     * @param settingInfo 修改的设置信息
     * @return 1
     */

    int updateSettingInfoById(SettingInfo settingInfo);
    /**
     * 根据id修改登录背景图
     * @param settingInfo 修改的设置信息
     * @return 1
     */
    int updateLoginPageBgImage(SettingInfo settingInfo);

    /**
     * 添加设置信息
     * @param settingInfo settingInfo对象
     * @return 1
     */
    Map<String, Object> insertSettingInfo(SettingInfo settingInfo);
}
