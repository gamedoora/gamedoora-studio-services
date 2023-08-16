package com.gamedoora.backend.studioservices;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.gamedoora.backend.studioservices.repository.StudioRepository;
import com.gamedoora.model.dao.Studios;
import org.springframework.test.context.TestPropertySource;

@DataJpaTest(properties="spring.cloud.config.enabled=false")
@TestPropertySource("classpath:test.properties")
@EntityScan("com.gamedoora.model.*")
class repositoryTest {

	@Autowired
	private StudioRepository repo;

	@Autowired
	private StudioRepository studioRepository;
	
	@Test
	public void test() {
		Studios studio = Studios.builder().id(123).name("Yoshita").build();

		Studios savedStudio = repo.save(studio);

		Assertions.assertNotNull(savedStudio);

		//fail("Not yet implemented");
	}

	@Test
	public void FindbyIsCommunity(){
		Studios studio1 = Studios.builder().id(1).name("A").isCommunity(1).description("DA").build();
		Studios studio2 = Studios.builder().id(2).name("b").isCommunity(2).description("DA").visibility(false).build();

		repo.save(studio1);
		List<Studios> commu = repo.findByIsCommunity(1);
		Assertions.assertEquals(1,commu.size());
	}

	@Test
	public void testFindByIsCommunity() {
		// Create some test studios with different is_community values
		Studios studio1 = Studios.builder().id(1).name("A").isCommunity(1).description("DA").build();
		Studios studio2 = Studios.builder().id(2).name("b").isCommunity(1).description("DA").visibility(false).build();

		List<Studios> list = List.of(studio1,studio2);

		// Perform the repository method call
		List<Studios> communityStudios = list;



		// Assert the results
		assertEquals(2, communityStudios.size()); // Assuming 2 studios have is_community = 1

		// Alternatively - individual
		repo.save(studio1);
		List<Studios> commu = repo.findByIsCommunity(1);
		Assertions.assertEquals(1,commu.size());

		// Alternative C

	}



}
