package com.zhy.takeoutcabinet.controller.uniapp;

import com.zhy.takeoutcabinet.entity.Cabinet;
import com.zhy.takeoutcabinet.service.CabinetService;
import com.zhy.takeoutcabinet.utils.ResponseJSON;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/uni")
public class UniCabinetController {
    @Resource
    CabinetService cabinetService;

    @GetMapping("/cabinet/one")
    public Map<String, Object> queryOrderByCabinet(@RequestBody Cabinet cabinet) {
       System.out.println(cabinet);
        return ResponseJSON.success("success");
    }
}
