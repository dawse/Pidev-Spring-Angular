package tn.esprit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import tn.esprit.entities.Role;
import tn.esprit.entities.RoleName;
import tn.esprit.entities.User;
import tn.esprit.exception.AppException;
import tn.esprit.repository.RoleRepository;
import tn.esprit.repository.UserRepository;


@Component
public class CommandLister implements CommandLineRunner {
	
	@Autowired
   UserRepository appreo;
	@Autowired
	RoleRepository rolerepo;
	//@Autowired
   // private JavaMailSender javaMailSender;

    @Autowired
    PasswordEncoder passwordEncoder;
   /* void sendEmail() {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("ayoub.smayen@esprit.tn", "felfel.farouk@esprit.tn");

        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");

        javaMailSender.send(msg);

    }*/
	public void run(String... args) throws Exception {
		
		//sendEmail();
		
		/*Set<Role> roles = new 	HashSet<>();
		Role role  =new Role();
		
	
		role.setName(RoleName.ROLE_ADMIN);
		
		roles.add(role);
		
		//PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		String pwdCrypted  = passwordEncoder.encode("14785236911az1");
		
		User user = new User("farouk12333", "faroukk1232", "felfel11.farouk2@esprit.tn",pwdCrypted );

        user.setPassword(passwordEncoder.encode(user.getPassword()));

       

		rolerepo.save(role);
		
        user.setRoles(roles);

        User result = appreo.save(user);
        
        
        System.out.println(result);*/
		
		/*Set<Role> roles = new 	HashSet<>();
		Role role  =new Role();
		
	
		role.setName(RoleName.ROLE_EMPLOYEE);
		
		roles.add(role);
		
		//PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		String pwdCrypted  = passwordEncoder.encode("14785236911az1");
		
		User user = new User("farouk12333", "faroukk1232", "felfel11.farouk2@esprit.tn",pwdCrypted );

        user.setPassword(passwordEncoder.encode(user.getPassword()));

       

		rolerepo.save(role);
		
        user.setRoles(roles);

        User result = appreo.save(user);
        
        
        System.out.println(result);
		
		/*Set<Role> roles = new 	HashSet<>();
		Role role  =new Role();
		
	
		role.setName(RoleName.ROLE_ENTERPRISE);
		
		roles.add(role);
		
		//PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		String pwdCrypted  = passwordEncoder.encode("14785236911az1");
		
		User user = new User("farouk12333", "faroukk1232", "felfel11.farouk2@esprit.tn",pwdCrypted );

        user.setPassword(passwordEncoder.encode(user.getPassword()));

       

		rolerepo.save(role);
		
        user.setRoles(roles);

        User result = appreo.save(user);
        
        
        System.out.println(result);

		
	
		
		
	 ////////////////////////////////
		/*Set roles = new 	HashSet<>();
		Role role  =new Role();
		
	
		role.setName(RoleName.ROLE_ADMIN);
		//log.info("create role admin");
		
		roles.add(role);
		User  appUser = new User();
		rolerepo.save(role);
		
		
		String pwdCrypted  = passwordEncoder.encode("14785236911az1");
	
		User user = new User("farouk12333", "faroukk1232", "felfel11.farouk2@esprit.tn",pwdCrypted );
		 
		 
		//log.info("create user admin");
		appreo.save(appUser);*/
		
		
		////////////////////////////////
		/*Set roles1 = new 	HashSet<>();
		Role role1  =new Role();
		
	
		role1.setName(RoleName.ROLE_ADMIN);
		//log.info("create role admin");
		
		roles1.add(role1);
		User  appUser2 = new User();
		rolerepo.save(role1);
		
		
		
		appUser2.setName("farouk112");
		appUser2.setEmail("azerty12");*/
		
		//PasswordEncoder passwordEncoder1 = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		//String pwdCrypted1  = passwordEncoder.encode("147852369az1");
		/*appUser2.setPassword("147852369az1");

		appUser2.setUsername("senioradmin");
		//appUser2.setRoles(roles1);
		//log.info("create user admin");
		appreo.save(appUser2);
		///////////////////////////////////
		// TODO Auto-generated method stub
		/*Set roles2 = new HashSet<>();
		Role role2  =new Role();
		
	
		role2.setName("USER");
		log.info("create role");
		
		roles.add(role);
		AppUser  appUser3 = new AppUser();
		rolerepo.save(role);
		
		
		
		appUser3.setName("farouk");
		appUser3.setPrenom("azerty");
		
		PasswordEncoder passwordEncoder2 = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		String pwdCrypted2  = passwordEncoder.encode("147852369az");
		appUser2.setPassword(pwdCrypted);

		appUser3.setUsername("senior");
		appUser3.setRoles(roles2);
		log.info("create user");
		appreo.save(appUser3);
		*/
		
	}

}

