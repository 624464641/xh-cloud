package com.xh.author.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author anders
 * @date 2019/3/4 11:26
 **/
@RestController
public class FallbackHandler {
	@RequestMapping("")
	public String index(){
		return "兄弟，这里什么都没有，去检查代码";
	}
	@GetMapping("/fallback")
	public R fallback() {
		return R.error(10000,"微服务启动中...");
	}
}
