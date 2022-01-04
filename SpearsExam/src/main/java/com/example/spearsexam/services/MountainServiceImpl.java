package com.example.spearsexam.services;

import com.example.spearsexam.models.Mountain;
import com.example.spearsexam.repositories.ClimberRepository;
import com.example.spearsexam.repositories.MountainRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MountainServiceImpl extends BaseDatabaseService implements MountainService {
    private final MountainRepository mountainRepository;

    @Autowired
    public MountainServiceImpl(MountainRepository mountainRepository,
                               ClimberRepository climberRepository) {
        super(climberRepository, mountainRepository);
        this.mountainRepository = mountainRepository;
    }

    @Override
    public List<Mountain> findAll() {
        return mountainRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    @Override
    public Mountain findById(String id) {
        try {
            Optional<Mountain> optionalMountain = mountainRepository.findById(Long.parseLong(id));
        }
        catch (Exception ignored) {}
        return null;
    }
}
