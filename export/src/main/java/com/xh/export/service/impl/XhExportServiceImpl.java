package com.xh.export.service.impl;

import com.xh.export.pojo.Lansen;
import com.xh.export.service.XhExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * @author xt
 * @date 2020/8/10
 */
@Service
public class XhExportServiceImpl implements XhExportService {


    private final MongoTemplate mongoTemplate;

    @Autowired
    public  XhExportServiceImpl(MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public String test() {
        Lansen lansen= new Lansen();
        lansen.setName("lansen1");
        lansen.setZjb("xll1");
        mongoTemplate.save(lansen);
        return "XhExportServiceImpl";
    }
}
