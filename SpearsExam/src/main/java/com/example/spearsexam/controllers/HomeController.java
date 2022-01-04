package com.example.spearsexam.controllers;

import com.example.spearsexam.models.Climber;
import com.example.spearsexam.models.Mountain;
import com.example.spearsexam.services.ClimberService;
import com.example.spearsexam.services.MountainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping({"", "/"})
public class HomeController extends BaseController {

    private final ClimberService climberService;
    private final MountainService mountainService;

    @Autowired
    public HomeController(ClimberService climberService, MountainService mountainService, ClimberService climberService1, MountainService mountainService1) {
        super(climberService, mountainService);
        this.climberService = climberService1;
        this.mountainService = mountainService1;
    }

    @GetMapping
    public String index(Model model){

        List<Climber> climbers = climberService.findAll();
        List<Mountain> mountains = mountainService.findAll();

        model.addAttribute("climbers", climbers);
        model.addAttribute("mountains", mountains);
        return "index";
    }
}