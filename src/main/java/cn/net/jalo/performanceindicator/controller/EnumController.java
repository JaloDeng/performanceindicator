package cn.net.jalo.performanceindicator.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.net.jalo.performanceindicator.enums.ActiveStatus;
import cn.net.jalo.performanceindicator.result.Result;

@RestController
@RequestMapping("/enum")
public class EnumController {

	@GetMapping("/active")
	public Result<List<Map<String, Object>>> getActiveStatus(HttpServletRequest request, HttpServletResponse response) {
		return new Result<List<Map<String,Object>>>(ActiveStatus.getList());
	}
	
}
