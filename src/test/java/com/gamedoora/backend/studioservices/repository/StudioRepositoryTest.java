package com.gamedoora.backend.studioservices.repository;
import com.gamedoora.model.dao.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
@DataJpaTest(properties = {"spring.cloud.config.enabled=false"})
public class StudioRepositoryTest {

    @Autowired
    public StudioRepository studioRepository;

    @Test
    public void testFindByRegistration() {
        Studios studio1 = Studios.builder().id(42).name("keera").registration(true).build();
        Studios studio2 = Studios.builder().id(43).name("john").registration(true).build();
        studioRepository.saveAll(List.of(studio1, studio2));

        List<Studios> registeredStudios = studioRepository.findByRegistration(true);
        assertThat(registeredStudios).isNotEmpty();
        assertEquals(2, registeredStudios.size());
    }

    @Test
    public void testFindByVisibility() {
        Studios studio1 = Studios.builder().id(14).name("hd").visibility(true).build();
        Studios studio2 = Studios.builder().id(15).name("smith").visibility(true).build();
        studioRepository.saveAll(List.of(studio1, studio2));

        List<Studios> visibleStudios = studioRepository.findByVisibility(true);
        assertThat(visibleStudios).isNotEmpty();
        assertEquals(2, visibleStudios.size());
    }

}
