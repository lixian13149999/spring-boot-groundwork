package com.bcdbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * SpringBoot的主启动文件
 */
/*
 * 注解表明这是spring的主配置文件
 */
@SpringBootApplication
public class SpringBootGroundworkApplication {

	/**
	 * 用于启动项目的main方法
	 * 注: 一般不需要调整
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringBootGroundworkApplication.class, args);
	}
}
