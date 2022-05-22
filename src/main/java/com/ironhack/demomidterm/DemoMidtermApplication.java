package com.ironhack.demomidterm;

import com.ironhack.demomidterm.model.*;
import com.ironhack.demomidterm.services.impl.AccountService;
import com.ironhack.demomidterm.services.impl.UserService;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;


@SpringBootApplication
public class DemoMidtermApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoMidtermApplication.class, args);
	}
	/*@Autowired
	public Environment environment;*/
	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	@Bean
	CommandLineRunner run(UserService userService, AccountService accountService){
		return args -> {
			//if(!Arrays.asList(environment.getActiveProfiles()).contains("test")){
				userService.saveRole(new Role(null, "ROLE_ACCOUNT_HOLDER"));
				userService.saveRole(new Role(null, "ROLE_ADMIN"));
				//userService.saveRole(new Role(null, "ROLE_THIRD-PARTY"));
				Address add1 = new Address("¨Teststreet","¨testCity","¨TestCountry",123);

				userService.saveUser(new AccountHolder( "John Doe", "john", "1234", new ArrayList<>(), LocalDate.now(),add1,add1));
				userService.saveUser(new AccountHolder("James Smith", "james", "1234", new ArrayList<>(), LocalDate.now(),add1,add1));
				userService.saveUser(new AccountHolder("Jane Carry", "jane", "1234", new ArrayList<>(), LocalDate.now(),add1,add1));
				userService.saveUser(new AccountHolder("Chris Anderson", "chris", "1234", new ArrayList<>(), LocalDate.now(),add1,add1));


				userService.addRoleToUser("john", "ROLE_ACCOUNT_HOLDER");
				userService.addRoleToUser("james", "ROLE_ADMIN");
				userService.addRoleToUser("jane", "ROLE_ACCOUNT_HOLDER");
				userService.addRoleToUser("chris", "ROLE_ADMIN");
				userService.addRoleToUser("chris", "ROLE_ACCOUNT_HOLDER");

			/*accountService.saveAccount(new Account(73.27,new AccountHolder("James Smith", "james","1234", new ArrayList<>(), "1996-05-14","xcvb","xrct rd",32),null,32.65));
			accountService.saveAccount(new Account("Jonas Schmidt"));
			accountService.saveAccount(new Account("Cas Van Dijk"));*/

			/*blogPostService.saveBlogPost(new BlogPost(1L, "Boost Your Productivity with 10 Easy Tips", "Productivity - we all want it but it seems ..."));
			blogPostService.saveBlogPost(new BlogPost(2L, "How to Focus", "Do you ever sit down to work and find yourself ..."));
			blogPostService.saveBlogPost(new BlogPost(3L, "Learn to Speed Read in 30 Days", "Knowledge, not ability, is the great determiner of ..."));*/
			//}

		};
	}

}
