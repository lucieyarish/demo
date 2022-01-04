package com.example.spearsexam.services;

import com.example.spearsexam.models.Mountain;

import java.util.List;

public interface MountainService {
    List<Mountain> findAll();
    Mountain findById(String id);
}
