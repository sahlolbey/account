package com.ing.test.account;

import com.ing.test.account.dao.UserRepository;
import com.ing.test.account.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class AccountApplication implements ApplicationRunner {

	@Autowired
	UserRepository userRepository;

	private static final Logger log = LoggerFactory.getLogger(AccountApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args){
		User user=new User();
		user.setId(1l);
		user.setUsername("ing1");
		BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder(11);
		user.setPassword(bCryptPasswordEncoder.encode("1ing"));
		userRepository.save(user);
		user=new User();
		user.setId(2l);
		user.setUsername("ing2");
		user.setPassword(bCryptPasswordEncoder.encode("2ing"));
		userRepository.save(user);



	}

}
