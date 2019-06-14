package com.biswa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@ComponentScan({"com.biswa.admin","com.biswa.login"})
public class Application {
	public static void main(String arr[])
	{
		//Application is bootstraped
	  SpringApplication.run(Application.class, arr);
	}
}
