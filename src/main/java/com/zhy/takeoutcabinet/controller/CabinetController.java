package com.zhy.takeoutcabinet.controller;

import com.zhy.takeoutcabinet.entity.Cabinet;
import com.zhy.takeoutcabinet.entity.CabinetInfo;
import com.zhy.takeoutcabinet.entity.Mode;
import com.zhy.takeoutcabinet.service.CabinetService;
import com.zhy.takeoutcabinet.utils.ResponseJSON;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cabinet")
public class CabinetController {
    @Resource
    CabinetService cabinetService;

    @GetMapping("/list/{pageNum}/{pageSize}")
    public CabinetInfo getCabinetInfo(@PathVariable("pageNum") int pageNum,
                                      @PathVariable("pageSize") int pageSize) {
        //System.out.println(pageNum + ":" + pageSize);
        List<Cabinet> cabinets = cabinetService.findAll((pageNum - 1) * pageSize, pageSize);
        List<Mode> modes = cabinetService.findAllMode();
        int total = cabinetService.findTotal();
        CabinetInfo cabinetInfo = new CabinetInfo();
        cabinetInfo.setCabinets(cabinets);
        cabinetInfo.setModes(modes);
        cabinetInfo.setCabinetTotal(total);
        return cabinetInfo;
    }
    @GetMapping("/cabinets")
    public CabinetInfo getAllCabinets() {
        List<Cabinet> cabinets = cabinetService.queryUsingCabinets();
        List<Mode> modes = cabinetService.findAllMode();
        CabinetInfo cabinetInfo = new CabinetInfo();
        cabinetInfo.setCabinets(cabinets);
        cabinetInfo.setModes(modes);
        return cabinetInfo;
    }
    @GetMapping("/one/{cabinetId}")
    public Cabinet getCabinetInfoById(@PathVariable("cabinetId") int cabinetId) {
        //System.out.println(cabinetId);
        //System.out.println(cabinetWithOrder);
        //System.out.println(cabinetId);
        return cabinetService.findCabinetWithOrderByCabinetId(cabinetId);
    }

    @PutMapping("/update")
    public Map<String, Object> updateCabinetStatus(@RequestBody Cabinet cabinet) {
        //System.out.println(cabinet);
        int effect = cabinetService.updateCabinetStatusById(cabinet);
        if (effect > 0) {
            return ResponseJSON.success("success");
        } else {
            return ResponseJSON.error500("error");
        }
    }

    @PostMapping("/insert")
    public Map<String, Object> insertCabinet(@RequestBody Cabinet cabinet) {
        Boolean flag = cabinetService.findCabinetsByPosition(cabinet);
        if (flag) {
            // 添加
            int effect = cabinetService.addCabinet(cabinet);
            if (effect > 0) return ResponseJSON.success("success");
        }
        return ResponseJSON.error400("添加失败，取餐柜重复了");
    }
}
