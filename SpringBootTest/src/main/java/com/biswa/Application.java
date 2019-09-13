package com.biswa;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@SpringBootApplication
@ComponentScan({ "com.biswa.admin", "com.biswa.login" })
public class Application implements CommandLineRunner {
	@Autowired
	private JavaMailSender javaMailSender;

	public static void main(String arr[]) {
		// Application is bootstraped
		SpringApplication.run(Application.class, arr);
	}

	@Override
	public void run(String... args) throws MessagingException, IOException {
		System.out.println("Sending Email...");
		sendEmail();
		// sendEmailWithAttachment();
		System.out.println("Done");
	}

	void sendEmail() {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo("bmohapatra1983@gmail.com");
		msg.setSubject("Testing from Spring Boot");
		String otp = "878787";
		msg.setText("Hello World \nSpring Boot Email\nYour OTP is: " + otp);
		javaMailSender.send(msg);
	}
	// ----------------------------

	void sendEmailWithAttachment() throws MessagingException, IOException {
		MimeMessage msg = javaMailSender.createMimeMessage();

		// true = multipart message
		MimeMessageHelper helper = new MimeMessageHelper(msg, true);
		helper.setTo("1@gmail.com");

		helper.setSubject("Testing from Spring Boot");

		// default = text/plain
		// helper.setText("Check attachment for image!");

		// true = text/html
		helper.setText("<h1>Check attachment for image!</h1>", true);

		// FileSystemResource file = new FileSystemResource(new
		// File("classpath:android.png"));

		// Resource resource = new ClassPathResource("android.png");
		// InputStream input = resource.getInputStream();

		// ResourceUtils.getFile("classpath:android.png");

		helper.addAttachment("my_photo.png", new ClassPathResource("android.png"));

		javaMailSender.send(msg);

	}
}
