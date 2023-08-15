package com.gamedoora.backend.studioservices.repository;

import com.gamedoora.model.dao.Studios;
import com.gamedoora.model.dao.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudioRepository extends JpaRepository<Studios , Long> {

    List<Studios> findByName(String name);
    List<Studios> findByIsCommunity(int isCommunity); //isCommunity
    List<Studios> findByRegistration(boolean registration);
    List<Studios> findByVisibility(boolean visibility);
    List<Studios>  findById(long userId);
    //List User is registered by a particular Studio or not, param-Studio ID

    //Hang-On till we reach aggregator part
}
