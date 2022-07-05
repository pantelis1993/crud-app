/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.assignment2crud.repos;

import com.example.assignment2crud.models.Trainer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author plogo
 */
public interface TrainerRepository extends JpaRepository<Trainer, Integer>{
    
    public List<Trainer> findAllByOrderByLastNameAsc();
}
