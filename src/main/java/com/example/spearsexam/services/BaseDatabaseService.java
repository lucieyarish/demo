package com.example.spearsexam.services;

import com.example.spearsexam.repositories.ClimberRepository;
import com.example.spearsexam.repositories.MountainRepository;
import org.springframework.beans.factory.annotation.Autowired;
@SuppressWarnings("SpringJavaAutowiredMembersInspection")

abstract public class BaseDatabaseService {
    protected final ClimberRepository climberRepository;
    protected final MountainRepository mountainRepository;

    @Autowired
    public BaseDatabaseService(ClimberRepository climberRepository,
                               MountainRepository mountainRepository) {
        this.climberRepository = climberRepository;
        this.mountainRepository = mountainRepository;
    }
}
