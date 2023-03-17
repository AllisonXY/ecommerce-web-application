package com.shopio.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.shopio.common.entity.Role;
import com.shopio.common.entity.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE) //test on original dataset
@Rollback(false)
public class UserRepositoryTest {

	// inject dependencies
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUser() {
		
		Role roleAdmin = entityManager.find(Role.class,1);
		User userAlicia = new User("alicaflorrick@law.com","willicia","Alicia","Florrick");
		userAlicia.addRole(roleAdmin);
		
		User savedUser = repo.save(userAlicia);
		assertThat(savedUser.getId()).isGreaterThan(0);
	}
	
	
	@Test
	public void testCreateUserWithTwoRoles() {
		
		User userWill = new User("willgardner@law.com","willicia","Will","Gardner");
		Role roleEditor = new Role(3);  //need roles in db
		Role roleAssistant = new Role(5);
		
		userWill.addRole(roleEditor);
		userWill.addRole(roleAssistant);
		
		User savedUser = repo.save(userWill);
		assertThat(savedUser.getId()).isGreaterThan(0);
	}
	
	
	@Test
	public void testListAllUsers() {
		
		Iterable<User> listUsers = repo.findAll();
		listUsers.forEach(user -> System.out.println(user));
		
	}
	
	@Test
	public void testGetUserById() {
		User userAlicia = repo.findById(1).get();
		assertThat(userAlicia).isNotNull();
	}
	
	@Test
	public void testUpdateUserDetails() {
		
		User userAlicia = repo.findById(1).get();
		userAlicia.setEnabled(true);
		userAlicia.setEmail("af@florricklaw.com");
		repo.save(userAlicia);
	}
	
	@Test
	public void testUpdateUserRoles() {
		
		User userWill = repo.findById(2).get();
		Role roleEditor = new Role(3);  //need roles in db
		Role salesPerson = new Role(2);  //need roles in db

		userWill.getRoles().remove(roleEditor);
		userWill.addRole(salesPerson);

		repo.save(userWill);
	}
	
	@Test
	public void testDeleteUser() {
		Integer userId = 2;
		repo.deleteById(userId);
	}
	
}
