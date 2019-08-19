package cn.net.jalo.performanceindicator.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;

import cn.net.jalo.performanceindicator.entity.Integral;
import cn.net.jalo.performanceindicator.model.IntegralModel;
import cn.net.jalo.performanceindicator.result.Result;
import cn.net.jalo.performanceindicator.service.IntegralService;

@RestController
@RequestMapping("/integral")
public class IntegralController {

	private static final Logger log = LoggerFactory.getLogger(IntegralController.class);
	
	@Autowired
	private IntegralService integralService;
	
	@DeleteMapping("/{id}")
	public Result<Integer> delete(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response) {
		try {
			return new Result<Integer>(integralService.delete(id), "删除成功", true);
		} catch (Exception e) {
			log.error(e.toString());
			return new Result<Integer>(0, "删除失败：" + e.getMessage(), false);
		}
	}
	
	@PutMapping
	public Result<Integer> save(@RequestBody Integral integral, HttpServletRequest request, HttpServletResponse response) {
		try {
			return new Result<Integer>(integralService.save(integral), "保存成功", true);
		} catch (Exception e) {
			log.error(e.toString());
			return new Result<Integer>(0, "保存失败：" + e.getMessage(), false);
		}
	}
	
	@PostMapping
	public Result<Page<Integral>> select(@RequestBody IntegralModel integralModel, HttpServletRequest request, HttpServletResponse response) {
		Page<Integral> integrals = integralService.select(integralModel);
		return new Result<>(integrals, integrals.getPageNum(), integrals.getPageSize(), integrals.getTotal(), integrals.getPages());
	}
	
	@GetMapping("/{id}")
	public Result<Integral> selectById(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response) {
		return new Result<>(integralService.selectById(id));
	}
}
