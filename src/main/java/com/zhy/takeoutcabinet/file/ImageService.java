package com.zhy.takeoutcabinet.file;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface ImageService {
    /**
     * 上传图片
     * @param file 文件
     * @return 图片地址
     */
    String uploadImage(MultipartFile file, HttpServletRequest request);
}
