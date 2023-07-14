package edu.kh.project.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import edu.kh.project.common.interceptor.BoardTypeInterceptor;

@Configuration

public class InterceptorConfig implements WebMvcConfigurer {

	@Bean
	public BoardTypeInterceptor boardTypeInterceptor() {
		
		return new BoardTypeInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		// Bean으로 등록된 boardTypeInterceptor를 얻어와 인터셉터로 등록
		registry.addInterceptor(boardTypeInterceptor())
		.addPathPatterns("/**") // 가로챌 경로 지정
		.excludePathPatterns("/css/**","/image/**","/js/**");
	}

	
	
}
