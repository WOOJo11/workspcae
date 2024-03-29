package edu.kh.project.common.config;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.kh.project.common.filter.LoginFilter;
import edu.kh.project.common.filter.BoardFilter;

@Configuration
public class FilterConfig {
	   @Bean
	   public FilterRegistrationBean<LoginFilter> loginFilter(){
	      
	      FilterRegistrationBean<LoginFilter> resiRegistrationBean = new FilterRegistrationBean<LoginFilter>();
	      
	      resiRegistrationBean.setFilter(new LoginFilter());
	      
	      String[] url = {"/myPage/*", "/board2/*"};
	      resiRegistrationBean.setUrlPatterns(Arrays.asList(url)); // url 패턴 여러 개 지정
	      resiRegistrationBean.setName("loginFilter"); // 이름
	      resiRegistrationBean.setOrder(1); // 여러 필터가 있을 때 순서
	      return resiRegistrationBean;
	   }
	   @Bean
	   public FilterRegistrationBean<BoardFilter> boardFilter(){
		   
		   FilterRegistrationBean<BoardFilter> resiRegistrationBean = new FilterRegistrationBean<BoardFilter>();
		   
		   resiRegistrationBean.setFilter(new BoardFilter());
		  
		   String[] url = {"/board/*", "/board2/*"};
		   resiRegistrationBean.setUrlPatterns(Arrays.asList(url)); // url 패턴 여러 개 지정
		   resiRegistrationBean.setName("BoardFilter"); // 이름
		   resiRegistrationBean.setOrder(2); // 여러 필터가 있을 때 순서
		   return resiRegistrationBean;
	   }
	   
	   
	   
}
