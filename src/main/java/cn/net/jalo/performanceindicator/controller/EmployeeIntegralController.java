package cn.net.jalo.performanceindicator.controller;

import java.util.Map;

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

import com.alibaba.excel.metadata.Sheet;
import com.github.pagehelper.Page;

import cn.net.jalo.performanceindicator.entity.EmployeeIntegral;
import cn.net.jalo.performanceindicator.model.EmployeeIntegralModel;
import cn.net.jalo.performanceindicator.model.excel.EmployeeIntegralExcelModel;
import cn.net.jalo.performanceindicator.result.Result;
import cn.net.jalo.performanceindicator.service.EmployeeIntegralService;
import cn.net.jalo.performanceindicator.utils.EasyExcelUtil;

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
	
	@PostMapping("/export/excel")
	public void exportToExcel(@RequestBody EmployeeIntegralModel employeeIntegralModel,
			HttpServletRequest request, HttpServletResponse response) {
		EasyExcelUtil.exportToXLSX(employeeIntegralService.selectExportToExcel(employeeIntegralModel), "pi", 
				new Sheet(1, 0, EmployeeIntegralExcelModel.class), response);
	}
	
	@PostMapping
	public Result<Page<EmployeeIntegralModel>> selectModel(@RequestBody EmployeeIntegralModel employeeIntegralModel,
			HttpServletRequest request, HttpServletResponse response) {
		Page<EmployeeIntegralModel> employeeIntegrals = employeeIntegralService.selectModel(employeeIntegralModel);
		return new Result<>(employeeIntegrals, employeeIntegrals.getPageNum(), employeeIntegrals.getPageSize(),
				employeeIntegrals.getTotal(), employeeIntegrals.getPages());
	}
	
	@GetMapping("/{id}")
	public Result<EmployeeIntegralModel> selectModelById(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response) {
		return new Result<>(employeeIntegralService.selectModelById(id));
	}
	
	@PostMapping("/statistics")
	public Result<Page<Map<String, Object>>> selectStatistics(@RequestBody EmployeeIntegralModel employeeIntegralModel, 
			HttpServletRequest request, HttpServletResponse response) {
		return new Result<>(employeeIntegralService.selectStatistics(employeeIntegralModel));
	}
}
