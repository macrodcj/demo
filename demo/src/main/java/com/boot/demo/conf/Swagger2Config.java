package com.boot.demo.conf;

import com.google.common.base.Predicate;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.AllowableListValues;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * @Description:swg-ui配置类
 * @author:dcj
 * @time:2017年7月22日 上午10:53:05
 */
@Configuration
@EnableSwagger2
@ConditionalOnProperty(name = "swagger.enabled")
public class Swagger2Config {
	@Bean("api")
	public Docket createAppRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.useDefaultResponseMessages(false)
				.apiInfo(apiInfo())
				.groupName("api")
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.boot.demo.controller"))
				.paths(appPaths()).build();
	}

	
	/**
	 * 需要拦截的URl
	 * @author:dcj
	 * @time:2017年7月22日 上午11:15:23
	 */
	@SuppressWarnings("unchecked")
	private Predicate<String> appPaths() {
		return or(regex("/swg/api.*"),
				regex("/user.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("API文档").version("1.0").build();
	}
}
