package com.gamedoora.backend.studioservices;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.gamedoora.backend.studioservices.repository.StudioRepository;
import com.gamedoora.model.dao.*;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;


@DataJpaTest(properties="spring.cloud.config.enabled=false")
@TestPropertySource("classpath:test.properties")
@EntityScan("com.gamedoora.model.*")	// Scanning the model(s)
class repositoryTest {

	@Autowired
	private StudioRepository repo;


	@Autowired
	private TestEntityManager entityManager;

	// Can Use @BeforeEach annotation


	@Test
	public void test() {
		// Checking object creation and its storing

		Studios studio = Studios.builder().id(123).name("Yoshita").build();

		Studios savedStudio = repo.save(studio);

		Assertions.assertNotNull(savedStudio);

		//fail("Not yet implemented");
	}

	@Test
	public void findByIsCommunity(){
		// single checking for IsCommunity

		// To use for IsCommunity - 0 or 1 as True - False

		Studios studio1 = Studios.builder().id(1).name("A").isCommunity(1).description("DA").build();
		Studios studio2 = Studios.builder().id(2).name("b").isCommunity(0).description("DA").visibility(false).build();
		Studios studio3 = Studios.builder().id(3).name("b").isCommunity(1).description("DA").visibility(false).build();

		// check 1
		repo.save(studio1);
		List<Studios> commu = repo.findByIsCommunity(1);
		Assertions.assertEquals(1,commu.size());

		Assertions.assertEquals("A",commu.get(0).getName());

		// check 1 Extended
		repo.save(studio2);
		repo.save(studio3);
		//repo.save(studio2);	// sequence changing affects below assertions

		commu = repo.findByIsCommunity(1);
		Assertions.assertEquals(2,commu.size());
		Assertions.assertEquals("A",commu.get(0).getName());
		Assertions.assertEquals("b",commu.get(1).getName());
	}

	@Test
	public void testFindByIsCommunity() {
		// Create some test studios with different is_community values

		// To use for IsCommunity - 0 or 1 as True - False

		Studios studio1 = Studios.builder().id(1).name("A").isCommunity(1).description("DA").build();
		Studios studio2 = Studios.builder().id(2).name("A").isCommunity(0).description("DA").visibility(false).build();

		List<Studios> list = List.of(studio1,studio2);
		repo.saveAll(list);
		// Perform the repository method call
		List<Studios> communityStudios = repo.findByIsCommunity(1);

		assertEquals(1,communityStudios.size());
		for(int i=0; i<communityStudios.size();i++)
		assertEquals("A",(communityStudios.get(i)).getName()); // works well with for loops

		//assertThat(communityStudios).hasSize(1).contains(studio1);  // Uses ArrayList

	}

	// To use TestEntityManager instead of EntityManager for testing environment

	// Below Shows detached state error for TestEntityManager.persist(_object_)

//	@Test
//	public void findByUsersSet_Name()
//	{
//		Studios studio1 = Studios.builder().id(1).name("A").isCommunity(1).description("DA").build();
//		Studios studio2 = Studios.builder().id(1).name("b").isCommunity(2).description("DA").visibility(false).build();
//
//		List<Studios> list = List.of(studio1,studio2);
//		List<Studios> lis = repo.saveAll(list);
//
//		Assertions.assertNotNull(lis);
//
//		Users user1 = Users.builder().id(1).providerToken("").email("yo").build();
//		entityManager.persist(user1);
//
//		List<Studios> com = repo.findByUsersSet_Name("A");
//
//		Assertions.assertEquals(1,com.size());
//
//	}



}
