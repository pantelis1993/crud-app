/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.assignment2crud.services;

import com.example.assignment2crud.models.Trainer;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author plogo
 */
public interface TrainerControllerI {
    
    //Create Trainer
    public void create(Trainer trainer);
    
    //Read all Trainers 
    public List<Trainer> getTrainers();
    
    //Find By Id
    public Trainer findById(Integer id);
    
    //delete By Id
    public void deleteById(Integer id);
}
