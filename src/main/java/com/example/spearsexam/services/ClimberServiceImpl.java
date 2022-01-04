package com.example.spearsexam.services;

import com.example.spearsexam.models.Climber;
import com.example.spearsexam.repositories.ClimberRepository;
import com.example.spearsexam.repositories.MountainRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@NoArgsConstructor
public class ClimberServiceImpl extends BaseDatabaseService implements ClimberService {

    private final ClimberRepository climberRepository;

    @Autowired
    public ClimberServiceImpl(ClimberRepository climberRepository,
                              MountainRepository mountainRepository) {
        super(climberRepository, mountainRepository);
        this.climberRepository = climberRepository;
        //this.mountainService = mountainService;
    }

    @Override
    public List<Climber> findAll() {
        return climberRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }
}
