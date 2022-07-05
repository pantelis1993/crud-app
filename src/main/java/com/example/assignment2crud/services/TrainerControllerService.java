/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.assignment2crud.services;

import com.example.assignment2crud.models.Trainer;
import com.example.assignment2crud.repos.TrainerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author plogo
 */
@Service
public class TrainerControllerService implements TrainerControllerI{

    @Autowired
    TrainerRepository trainerRepository;
    
    @Override
    public void create(Trainer trainer) {
       // trainer.setTrainerId(0);
        trainerRepository.save(trainer);
    }

    @Override
    public List<Trainer> getTrainers() {
      return (trainerRepository.findAllByOrderByLastNameAsc());
    }

    @Override
    public Trainer findById(Integer id) {
       Optional<Trainer> result_trainer = trainerRepository.findById(id);
       Trainer trainer = null;
       if(result_trainer.isPresent()) {
           trainer = result_trainer.get();
       }
       else{
           throw new RuntimeException("Trainer with id: " + id + " not found.");
       }
       return trainer;
    }

    @Override
    public void deleteById(Integer id) {
        trainerRepository.deleteById(id);
    }
    
}
