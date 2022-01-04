package com.example.spearsexam.controllers;

import com.example.spearsexam.services.ClimberService;
import com.example.spearsexam.services.MountainService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller

abstract public class BaseController {
    protected final ClimberService climberService;
    protected final MountainService mountainService;

    @Autowired
    public BaseController(ClimberService climberService, MountainService mountainService) {
        this.climberService = climberService;
        this.mountainService = mountainService;
    }
}
