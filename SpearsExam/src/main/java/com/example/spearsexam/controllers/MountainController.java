package com.example.spearsexam.controllers;

import com.example.spearsexam.models.Mountain;
import com.example.spearsexam.services.ClimberService;
import com.example.spearsexam.services.MountainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mountains")
public class MountainController extends BaseController {

    @Autowired
    public MountainController(ClimberService climberService,
                              MountainService mountainService) {
        super(climberService, mountainService);
    }

    @GetMapping("/{id}")
    public String show(Model model, @PathVariable String id) {
        Mountain mountain = mountainService.findById(id);
        model.addAttribute("mountain", mountain);

        if(mountain == null) {
            model.addAttribute("errorMessage", "Error: Mountain not found!");
        }
        else {
            model.addAttribute("climbers", mountain.getClimbers());
        }
        return "mountains/show";
    }
}
