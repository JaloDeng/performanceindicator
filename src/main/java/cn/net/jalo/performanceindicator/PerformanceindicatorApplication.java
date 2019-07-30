package cn.net.jalo.performanceindicator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan({ "cn.net.jalo.performanceindicator.mapper" })
@SpringBootApplication
@EnableTransactionManagement
public class PerformanceindicatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PerformanceindicatorApplication.class, args);
	}

}
