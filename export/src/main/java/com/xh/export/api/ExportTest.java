package com.xh.export.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xt
 * @date 2020/8/12
 */
@RestController("/export")
public class ExportTest {

    @GetMapping("/pt")
    public Object export(){
        System.out.println("export ++++++  进来了!");
        return "export";
    }
}
