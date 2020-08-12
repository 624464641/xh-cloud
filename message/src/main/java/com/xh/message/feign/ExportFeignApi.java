package com.xh.message.feign;

import com.xh.export.remote.MessageFeignApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author xt
 * @date 2020/8/12
 */
@FeignClient(value = "xh-export" )
public interface ExportFeignApi  extends MessageFeignApi {

}
