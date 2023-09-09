package com.gamedoora.backend.studioservices.assembler;

import com.gamedoora.backend.studioservices.repository.StudioRepository;
import com.gamedoora.model.mapper.StudiosMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudioUsersAssembler {
    private StudioRepository studioRepository;

    private StudiosMapper studiosMapper;

    private StudioRepository getStudioRepository(){return studioRepository;}

    @Autowired
    public void setStudioRepository(StudioRepository studioRepository) {this.studioRepository=studioRepository;}

    public StudiosMapper getStudiosMapper() {
        return studiosMapper;
    }

   @Autowired
    public void setStudiosMapper(StudiosMapper studiosMapper){this.studiosMapper=studiosMapper;}
}
