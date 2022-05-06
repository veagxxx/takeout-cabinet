package com.zhy.takeoutcabinet.service.impl;

import com.zhy.takeoutcabinet.entity.SettingInfo;
import com.zhy.takeoutcabinet.mapper.SettingMapper;
import com.zhy.takeoutcabinet.service.SettingService;

import com.zhy.takeoutcabinet.utils.ResponseJSON;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SettingServiceImpl implements SettingService {
    @Resource
    SettingMapper settingMapper;
    @Override
    public List<SettingInfo> querySettingInfo() {
        return settingMapper.querySettingInfo();
    }

    @Override
    public SettingInfo querySettingIsUsing() {
        List<SettingInfo> infos = settingMapper.queryOneSettingInfo();
        if (infos.isEmpty()) {
            return null;
        }
        return infos.get(0);
    }

    @Override
    public int updateSettingInfoById(SettingInfo settingInfo) {
        if (settingInfo == null) {
            return 0;
        }
        return settingMapper.updateSetting(settingInfo);
    }

    @Override
    public int updateLoginPageBgImage(SettingInfo settingInfo) {
        if (settingInfo == null) {
            return 0;
        }
        return settingMapper.updateSetting(settingInfo);
    }

    @Override
    public Map<String, Object> insertSettingInfo(SettingInfo settingInfo) {
        if (settingInfo == null) {
            return ResponseJSON.error400("设置信息为空");
        }
        int info = settingMapper.insertSettingInfo(settingInfo);
        if (info == 0) {
            return ResponseJSON.error500("添加失败");
        }
        return ResponseJSON.success("success");
    }
}
