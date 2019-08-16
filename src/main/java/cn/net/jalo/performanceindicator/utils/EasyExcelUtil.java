package cn.net.jalo.performanceindicator.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;

public class EasyExcelUtil {
	
	public static void exportToXLSX(List<? extends BaseRowModel> data, String fileName, Sheet sheet, HttpServletResponse response) {
		ServletOutputStream out = null;
		try {
			out = response.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, true);
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName + ".xlsx", "utf-8"));
			writer.write(data, sheet);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} finally {
			writer.finish();
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
