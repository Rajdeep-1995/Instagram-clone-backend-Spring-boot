package com.instagramclone;

import com.cloudinary.Cloudinary;
import com.cloudinary.SingletonManager;
import com.cloudinary.utils.ObjectUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.id.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.support.incrementer.OracleSequenceMaxValueIncrementer;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;


@SpringBootApplication
public class InstagramCloneApplication {

	public static void main(String[] args) {

		final int SHORT_ID_LENGTH = 12;

// all possible unicode characters
		String shortId = RandomStringUtils.randomAlphanumeric(SHORT_ID_LENGTH);
		System.out.println(shortId);

		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "dyp7mhniv",
				"api_key", "485242983469229",
				"api_secret", "ldd4JQsiEX3FC09JFg0EbM-74cM",
				"secure", true));

		SingletonManager manager = new SingletonManager();
		manager.setCloudinary(cloudinary);
		manager.init();

		SpringApplication.run(InstagramCloneApplication.class, args);
	}


}

