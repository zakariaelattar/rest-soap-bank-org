package com.ensapay.bank;

import com.ensapay.bank.Security.controllers.AuthController;
import com.ensapay.bank.Security.models.ERole;
import com.ensapay.bank.Security.models.Role;
import com.ensapay.bank.Security.models.User;
import com.ensapay.bank.Security.payload.request.LoginRequest;
import com.ensapay.bank.Security.payload.request.SignupRequest;
import com.ensapay.bank.Security.repository.RoleRepository;
import com.ensapay.bank.Security.repository.UserRepository;
import com.ensapay.bank.entities.Client;
import com.ensapay.bank.entities.Product;
import com.ensapay.bank.repositories.ClientRepository;
import com.ensapay.bank.repositories.ProductRepository;
import com.ensapay.bank.soapApi.CheckBalanceClient;
import com.ensapay.bank.soapApi.CreateAccountClient;
import com.ensapay.bank.soapApi.CreditorClient;
import com.ensapay.bank.soapApi.PaymentClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class BankApplication implements CommandLineRunner {


	@Autowired
	RoleRepository roleRepository ;

	@Autowired
	ProductRepository productRepository;
	@Autowired
	ClientRepository clientRepository;
	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		Role role1 = new Role();
		Role role2 = new Role();
		Role role3 = new Role();
		role1.setName(ERole.ROLE_ADMIN);
		role2.setName(ERole.ROLE_USER);
		role3.setName(ERole.ROLE_AGENT);

		roleRepository.save(role1);
		roleRepository.save(role2);
		roleRepository.save(role3);

		/**********************************************/
		Product product1 = new Product();
		Product product2 = new Product();
		Product product3 = new Product();

		product1.setName("compte 500");
		product2.setName("compte 5 000");
		product3.setName("compte 20 0000");


		/**********************************************/
		Client client1 = new Client();
		Client client2 = new Client();
		Client client3 = new Client();
		Client client4 = new Client();

		client1.setCin("EE123456");
		client1.setFirst_name("Bouzid");
		client1.setLast_name("sara");
		client1.setPhone("0652632355");

		client2.setCin("EE125423");
		client2.setFirst_name("Omar");
		client2.setLast_name("Imai");
		client2.setPhone("0652214774");

		client3.setCin("EE123456");
		client3.setFirst_name("Khaoula");
		client3.setLast_name("khaled");
		client3.setPhone("0652369855");

		client4.setCin("EE123456");
		client4.setFirst_name("Atlas");
		client4.setLast_name("abdelghafour");
		client4.setPhone("0625413820");
		/****************************************/
		productRepository.save(product1);
		productRepository.save(product2);
		productRepository.save(product3);

		clientRepository.save(client1);
		clientRepository.save(client2);
		clientRepository.save(client3);
		clientRepository.save(client4);


		User user1 = new User();
		Set<Role> roles1 = new HashSet<Role>();

		roles1.add(role1);
		User user2 = new User();
		Set<Role> roles2 = new HashSet<Role>();

		roles2.add(role3);



		user1.setEmail("elattarz@yahoo.com");
		user1.setUsername("zakimaro");
		user1.setPassword("$2a$10$/S67lvzooRc3UzAFECEg1.7lBZMQdJVTyMiRVgtpDVl3KtgaDZrkK");
		user1.setRoles(roles1);

		userRepository.save(user1);

		user2.setEmail("atlas@yahoo.com");
		user2.setUsername("atlas");
		user2.setPassword("$2a$10$/S67lvzooRc3UzAFECEg1.7lBZMQdJVTyMiRVgtpDVl3KtgaDZrkK");
		user2.setRoles(roles2);

		userRepository.save(user2);





	}
}
