package com.biswa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@ComponentScan({"com.biswa.admin","com.biswa.login"})
public class Application extends SpringBootServletInitializer {
	public static void main(String arr[])
	{
		//Application is bootstraped
	  SpringApplication.run(Application.class, arr);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return super.configure(builder);
	}
}
