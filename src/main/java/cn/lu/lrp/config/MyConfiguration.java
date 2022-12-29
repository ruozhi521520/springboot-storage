package cn.lu.lrp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: cn.lu.inventory.config.MyMvcConfig
 * @author: lull lull@shuto.cn
 * @create: 2021-01-18
 * @version: <p> 2021-01-18 22:15 1、   lull
 **/
@Configuration
public class MyConfiguration implements WebMvcConfigurer {

    /**
     * 注册拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加拦截的请求，并排除几个不拦截的请求
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/login.do", "/login", "/css/**", "/admin/images/**", "/font/**", "/admin/css/**", "/component/**");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    }
}

