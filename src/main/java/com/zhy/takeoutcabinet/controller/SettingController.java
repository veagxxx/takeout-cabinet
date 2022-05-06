package com.zhy.takeoutcabinet.controller;

import com.zhy.takeoutcabinet.entity.SettingInfo;
import com.zhy.takeoutcabinet.file.ImageService;
import com.zhy.takeoutcabinet.service.SettingService;
import com.zhy.takeoutcabinet.utils.ResponseJSON;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/setting")
public class SettingController {

    @Resource
    SettingService settingService;
    @Resource
    ImageService imageService;

    @GetMapping("/query")
    public Map<String, Object> queryAll() {
        List<SettingInfo> settingInfos = settingService.querySettingInfo();
        if (settingInfos == null) {
            return ResponseJSON.error500("查询为空");
        }
        return ResponseJSON.success("success", settingInfos);
    }

    /**
     * 查询一条正在使用的设置
     * @return map
     */
    @GetMapping("/one")
    public Map<String, Object> queryByIsUse() {
        SettingInfo setting = settingService.querySettingIsUsing();
        // System.out.println(setting);
        return ResponseJSON.success("success", setting);
    }

    /**
     * 修改设置信息
     * @param settingInfo 设置信息
     * @return msg
     */
    @PutMapping("/update")
    public Map<String, Object> updateSetting(@RequestBody SettingInfo settingInfo) {
        //System.out.println(settingInfo);
        int effect = settingService.updateSettingInfoById(settingInfo);
        if (effect == 0) {
            return ResponseJSON.error500("修改失败");
        }
        return ResponseJSON.success("修改成功");
    }

    /**
     * 修改登录背景图
     * @param file 背景图
     * @param id 根据id修改
     * @param request request对象
     * @return map
     */
    @PostMapping("/updateBgImage")
    public Map<String, Object> upload(@RequestParam MultipartFile file,
                                      @RequestParam int id,
                                      HttpServletRequest request) {
        String imgUrl = imageService.uploadImage(file, request);
        if (imgUrl.equals("error")) {
            return ResponseJSON.error500("保存失败");
        }
        if (imgUrl.equals("")) {
            return ResponseJSON.error400("图片格式有误，请上传.jpg、.png、.jpeg格式的文件");
        }
        //System.out.println(imgUrl);
        SettingInfo settingInfo = new SettingInfo();
        settingInfo.setId(id);
        settingInfo.setLoginBgImage(imgUrl);
        int effect = settingService.updateSettingInfoById(settingInfo);
        if (effect == 0) {
            return ResponseJSON.error500("修改失败");
        }
        return ResponseJSON.success("修改成功，新的图片路径：" + imgUrl);
    }

    @PostMapping("/insert")
    public Map<String, Object> addSettingInfo(@RequestParam("image") MultipartFile file,
                                              @RequestParam("settingInfo") String info,
                                              HttpServletRequest request) {
        // 将 json 字符串转为 Bean 对象
        SettingInfo settingInfo = (SettingInfo) JSONObject.toBean(JSONObject.fromObject(info), SettingInfo.class);
        // System.out.println(settingInfo);
        // 上传图片并获取图片地址
        String image = imageService.uploadImage(file, request);
        settingInfo.setLoginBgImage(image);
        return settingService.insertSettingInfo(settingInfo);
    }
}
