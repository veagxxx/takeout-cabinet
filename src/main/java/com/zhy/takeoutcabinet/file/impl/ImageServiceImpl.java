package com.zhy.takeoutcabinet.file.impl;

import com.zhy.takeoutcabinet.file.ImageService;
import com.zhy.takeoutcabinet.utils.ResponseJSON;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

@Service
public class ImageServiceImpl implements ImageService {
    @Override
    public String uploadImage(MultipartFile file, HttpServletRequest request) {
        //项目文件的resources文件夹的static文件夹中的image目录
        String path = "E:/spring-learn/takeout-cabinet/src/main/resources/static/image";
        //获取文件名称
        String fileName = file.getOriginalFilename();
        //获取文件名后缀
        assert fileName != null;
        String suffix = fileName.substring(file.getOriginalFilename().lastIndexOf("."));
        suffix = suffix.toLowerCase();
        if (suffix.equals(".jpg") || suffix.equals(".jpeg") || suffix.equals(".png")/* || suffix.equals(".gif")*/) {
            fileName = UUID.randomUUID().toString() + suffix;
            File targetFile = new File(path, fileName);
            if (!targetFile.getParentFile().exists()) {    //注意，判断父级路径是否存在
                targetFile.getParentFile().mkdirs();
            }
            //保存
            try {
                file.transferTo(targetFile);
            } catch (Exception e) {
                e.printStackTrace();
                return "error";
            }
            //项目url，这里可以使用常量或者去数据字典获取相应的url前缀；
            String fileUrl = "http://localhost:8090";
            //文件获取路径
            fileUrl = fileUrl + request.getContextPath() + "/image/" + fileName;
            return fileUrl;
        } else {
            return "";
        }
    }
}
