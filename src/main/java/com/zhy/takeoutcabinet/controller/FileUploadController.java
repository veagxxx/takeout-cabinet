package com.zhy.takeoutcabinet.controller;

import com.zhy.takeoutcabinet.utils.ResponseJSON;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.*;

@RestController
@RequestMapping("/upload")
public class FileUploadController {
    //项目文件的resources文件夹的static文件夹中的image目录
    private static final String path =
            "E:/spring-learn/takeout-cabinet/src/main/resources/static/image";
    @PostMapping("/avatar")
    public Object upload(@RequestParam MultipartFile file,
                         HttpServletRequest request) {
        //获取文件名称
        String fileName = file.getOriginalFilename();
        //获取文件名后缀
        //Calendar currTime = Calendar.getInstance();
        //String time = String.valueOf(currTime.get(Calendar.YEAR))+String.valueOf((currTime.get(Calendar.MONTH)+1));
        //获取文件名后缀
        assert fileName != null;
        String suffix = fileName.substring(file.getOriginalFilename().lastIndexOf("."));
        suffix = suffix.toLowerCase();
        if(suffix.equals(".jpg") || suffix.equals(".jpeg") || suffix.equals(".png")/* || suffix.equals(".gif")*/){
            fileName = UUID.randomUUID().toString() + suffix;
            File targetFile = new File(path, fileName);
            if(!targetFile.getParentFile().exists()){    //注意，判断父级路径是否存在
                targetFile.getParentFile().mkdirs();
            }
            //保存
            try {
                file.transferTo(targetFile);
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseJSON.error500("上传失败！");
            }
            //项目url，这里可以使用常量或者去数据字典获取相应的url前缀；
            String fileUrl="http://localhost:8090";
            //文件获取路径
            fileUrl = fileUrl + request.getContextPath() +
                    "/spring-learn/takeout-cabinet/src/main/resources/static/image/" + fileName;
            System.out.println("fileUrl:" + fileUrl);
            return ResponseJSON.success("fileUrl", fileUrl);
        } else {
            return ResponseJSON.error500("图片格式有误，请上传.jpg、.png、.jpeg格式的文件");
        }
    }
}
