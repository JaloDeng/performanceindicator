package cn.net.jalo.performanceindicator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableTransactionManagement
@EnableSwagger2
@MapperScan({ "cn.net.jalo.performanceindicator.mapper" })
@SpringBootApplication
public class PerformanceindicatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PerformanceindicatorApplication.class, args);
	}

}
