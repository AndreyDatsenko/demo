package com.example.demo.controller;

import com.example.demo.service.GeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/generator")
public class GeneratorController {

    private final GeneratorService generatorService;

    @Autowired
    public GeneratorController(GeneratorService generatorService) {
        this.generatorService = generatorService;
    }

    @PostMapping
    public String digitGenerate(@RequestParam("limit") Integer limit) {
        generatorService.digitGenerate(limit);
        return "index";
    }
}
