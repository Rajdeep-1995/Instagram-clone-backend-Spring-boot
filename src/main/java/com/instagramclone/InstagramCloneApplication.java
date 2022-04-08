package com.instagramclone;

import com.cloudinary.Cloudinary;
import com.cloudinary.SingletonManager;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class InstagramCloneApplication {

	public static void main(String[] args) {

		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "your cloud name",
				"api_key", "your api key",
				"api_secret", "your api secret",
				"secure", true));

		SingletonManager manager = new SingletonManager();
		manager.setCloudinary(cloudinary);
		manager.init();

		SpringApplication.run(InstagramCloneApplication.class, args);
	}


}

