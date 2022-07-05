/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.assignment2crud.controller;


import com.example.assignment2crud.models.Trainer;
import com.example.assignment2crud.services.TrainerControllerI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 *
 * @author plogo
 */
@Controller
@RequestMapping("/trainers")
public class TrainerController {
    
    @Autowired
    private TrainerControllerI trainerService;
    
        @GetMapping("/list")
        public String listOfTrainers(Model model) {
            List<Trainer> trainers = trainerService.getTrainers();
            model.addAttribute("trainers",trainers);
            return "list-of-trainers";
        }
        
        @GetMapping("/showAddForm")
        public String addNewTrainer(Model model) {
            Trainer trainer = new Trainer();
            model.addAttribute("newTrainer",trainer);
            return "addForm";
        }
        
        @PostMapping("/save")
        public String saveTrainer(@ModelAttribute("newTrainer") Trainer trainer) {
            trainerService.create(trainer);
            return "redirect:/trainers/list";
        }
        
        @GetMapping("/updateForm")
        public String update(@RequestParam("trainerId") Integer id , Model model) {
            Trainer trainer = trainerService.findById(id);
            model.addAttribute("newTrainer", trainer);
            return "addForm";
        }
        
        @GetMapping("/delete")
        public String delete(@RequestParam("trainerId") Integer id) {
            trainerService.deleteById(id);
            return "redirect:/trainers/list";
        }
    }
    

