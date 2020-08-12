package com.xh.export.remote.impl;

import com.xh.export.remote.MessageFeignApi;
import com.xh.export.service.XhExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xt
 * @date 2020/8/12
 */

@RestController
public class MessageFeignImpl implements MessageFeignApi {

    private XhExportService xhExportService;

    @Autowired
    public MessageFeignImpl(XhExportService xhExportServic){
        this.xhExportService = xhExportServic;
    }

    @Override
    public String findExport(String id) {
        return xhExportService.test();
    }
}
