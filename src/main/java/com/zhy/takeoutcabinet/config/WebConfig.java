package com.zhy.takeoutcabinet.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import org.springframework.util.unit.DataSize;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private TokenInterceptor tokenInterceptor;
    //构造方法
    public WebConfig(TokenInterceptor tokenInterceptor){
        this.tokenInterceptor = tokenInterceptor;
    }
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer){
        configurer.setTaskExecutor(new ConcurrentTaskExecutor(Executors.newFixedThreadPool(3)));
        configurer.setDefaultTimeout(30000);
    }

    // 配置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> excludePath = new ArrayList<>();
        //排除拦截，除了注册登录(此时还没token)，其他都拦截
        excludePath.add("/register");  //登录
        excludePath.add("/login");     //注册
        excludePath.add("/captcha");
        excludePath.add("/image/**");  //静态资源
        excludePath.add("/setting/one");
        excludePath.add("/assets/**");  //静态资源
        excludePath.add("/uni/**"); // 小程序
        //excludePath.add("/image/**");
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(excludePath);
        WebMvcConfigurer.super.addInterceptors(registry);
    }

    /**
     * 在配置文件中配置的文件保存路径
     */
    @Value("${cbs.imagesPath}")
    private String mImagesPath;

    /**
     * 这里是映射文件路径的方法
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if(mImagesPath.equals("") || mImagesPath.equals("${cbs.imagesPath}")){
            String imagesPath = WebConfig.class.getClassLoader().getResource("").getPath();
            if(imagesPath.indexOf(".jar") > 0){
                imagesPath = imagesPath.substring(0, imagesPath.indexOf(".jar"));
            }else if(imagesPath.indexOf("classes")>0){
                imagesPath = "file:" + imagesPath.substring(0, imagesPath.indexOf("classes"));
            }
            imagesPath = imagesPath.substring(0, imagesPath.lastIndexOf("/")) +
                    "/spring-learn/takeout-cabinet/src/main/resources/static/image/";
            mImagesPath = imagesPath;
        }
        registry.addResourceHandler(
                "/image/**")
                .addResourceLocations(mImagesPath);
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }
}
