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
@EntityScan("com.gamedoora.model.*")
class repositoryTest {

	@Autowired
	private StudioRepository repo;

	@Autowired
	private StudioRepository studioRepository;

	@Autowired
	private TestEntityManager entityManager;

	
	@Test
	public void test() {
		Studios studio = Studios.builder().id(123).name("Yoshita").build();

		Studios savedStudio = repo.save(studio);

		Assertions.assertNotNull(savedStudio);

		//fail("Not yet implemented");
	}

	@Test
	public void findByIsCommunity(){
		Studios studio1 = Studios.builder().id(1).name("A").isCommunity(1).description("DA").build();
		Studios studio2 = Studios.builder().id(2).name("b").isCommunity(2).description("DA").visibility(false).build();

		repo.save(studio1);
		List<Studios> commu = repo.findByIsCommunity(1);
		Assertions.assertEquals(1,commu.size());
	}

	@Test
	public void testFindByIsCommunity() {
		// Create some test studios with different is_community values

		// IsCommunity takes only binary values - 0 or 1

		Studios studio1 = Studios.builder().id(1).name("A").isCommunity(1).description("DA").build();
		Studios studio2 = Studios.builder().id(2).name("A").isCommunity(1).description("DA").visibility(false).build();

		List<Studios> list = List.of(studio1,studio2);
		repo.saveAll(list);
		// Perform the repository method call
		List<Studios> communityStudios = repo.findByIsCommunity(1);

		assertEquals(2,communityStudios.size());
		for(int i=0; i<communityStudios.size();i++)
		assertEquals("A",(communityStudios.get(i)).getName());
		//assertThat(communityStudios).hasSize(1).contains(studio1);  // Uses ArrayList

	}

//	@Test
//	public void findByUsersSet_Id()
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
//		List<Studios> com = repo.findByUsersSet_Id(1);
//
//		Assertions.assertEquals(2,com.size());
//
//	}



}
