package com.xh.export.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xh.export.pojo.Lansen;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author xt
 * @date 2020/9/15
 */
@Repository
public interface XhExportMapper extends BaseMapper<Lansen> {


    /**
     * @param name
     * @return
     */
    Lansen getLanSen(@Param("name") String name);


}
