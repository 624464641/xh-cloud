package com.xh.message.api;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xh.common.responses.R;
import com.xh.message.feign.ExportFeignApi;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xt
 * @date 2020/8/12
 */
@RestController("/mes")
public class Test {

    private final ExportFeignApi exportFeignApi;

    @Autowired
    public Test(ExportFeignApi exportFeignApi){
        this.exportFeignApi = exportFeignApi;
    }

    @GetMapping("/say")
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    @GlobalTransactional
    public R say(){
        System.out.println("message====进来了！" +exportFeignApi.findExport("123") );
        return R.ok().data(exportFeignApi.findExport("123") );
    }

    public  R fallbackMethod(){
        System.out.println("微服务启动中。。。。1111111111");
        return R.error("微服务启动中。。。。");
    }
}
