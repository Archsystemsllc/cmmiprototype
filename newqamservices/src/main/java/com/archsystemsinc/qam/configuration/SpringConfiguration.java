package com.archsystemsinc.qam.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan({"com.archsystemsinc.qam","com.archsystemsinc.qam.service.domain","com.archsystems"})
public class SpringConfiguration extends WebMvcConfigurerAdapter{
	
}