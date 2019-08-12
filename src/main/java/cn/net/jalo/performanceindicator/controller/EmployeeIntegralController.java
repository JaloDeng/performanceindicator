package cn.net.jalo.performanceindicator.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;

import cn.net.jalo.performanceindicator.entity.EmployeeIntegral;
import cn.net.jalo.performanceindicator.model.EmployeeIntegralModel;
import cn.net.jalo.performanceindicator.result.Result;
import cn.net.jalo.performanceindicator.service.EmployeeIntegralService;

@RestController
@RequestMapping("/employee/integral")
public class EmployeeIntegralController {
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeIntegralController.class);

	@Autowired
	private EmployeeIntegralService employeeIntegralService;
	
	@DeleteMapping("/{id}")
	public Result<Integer> delete(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response) {
		try {
			return new Result<Integer>(employeeIntegralService.delete(id), "删除成功", true);
		} catch (Exception e) {
			log.error(e.toString());
			return new Result<Integer>(0, "删除失败：" + e.getMessage(), false);
		}
	}
	
	@PutMapping
	public Result<Integer> save(@RequestBody EmployeeIntegral employeeIntegral, HttpServletRequest request, HttpServletResponse response) {
		try {
			return new Result<Integer>(employeeIntegralService.save(employeeIntegral), "保存成功", true);
		} catch (Exception e) {
			log.error(e.toString());
			return new Result<Integer>(0, "保存失败：" + e.getMessage(), false);
		}
	}
	
	@GetMapping
	public Result<Page<EmployeeIntegralModel>> selectModel(@RequestParam(required = false) Integer[] employeeIds,
			@RequestParam(required = false) String employeeStatus,
			@RequestParam(required = false) Integer[] integralIds,
			@RequestParam(required = false) String integralStartTime,
			@RequestParam(required = false) String integralEndTime, 
			@RequestParam(required = false, defaultValue = "1") Integer pageNum,
			@RequestParam(required = false, defaultValue = "100") Integer pageSize,
			@RequestParam(required = false) String orderBy, 
			HttpServletRequest request, HttpServletResponse response) {
		Page<EmployeeIntegralModel> employeeIntegrals = employeeIntegralService.selectModel(employeeIds, employeeStatus, integralIds, 
				integralStartTime, integralEndTime, pageNum, pageSize, orderBy);
		return new Result<>(employeeIntegrals, employeeIntegrals.getPageNum(), employeeIntegrals.getPageSize(),
				employeeIntegrals.getTotal(), employeeIntegrals.getPages());
	}
	
	@GetMapping("/{id}")
	public Result<EmployeeIntegralModel> selectModelById(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response) {
		return new Result<>(employeeIntegralService.selectModelById(id));
	}
}
