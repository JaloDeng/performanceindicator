package cn.net.jalo.performanceindicator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Swagger2Config {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(new ApiInfoBuilder()
						.title("API文档")
						.version("1.0")
						.build())
				.select()
				.apis(RequestHandlerSelectors.basePackage("cn.net.jalo.performanceindicator"))
				.paths(PathSelectors.any())
				.build();
	}
}
