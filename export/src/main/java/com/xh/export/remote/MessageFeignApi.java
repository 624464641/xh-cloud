package com.xh.export.remote;

import org.springframework.web.bind.annotation.*;

/**
 * @author xt
 * @date 2020/8/12
 */

public interface MessageFeignApi {

    @GetMapping("/feign/export/{id}")
    String findExport(@PathVariable("id") String id);
}
