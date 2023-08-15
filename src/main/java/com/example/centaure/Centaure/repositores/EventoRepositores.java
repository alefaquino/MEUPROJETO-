package com.example.centaure.Centaure.repositores;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.centaure.Centaure.models.Evento;




@Component
public interface EventoRepositores extends JpaRepository<Evento, Integer> {

    
    // Método para procurar um evento pelo nome
    public Optional<Evento> findByEvento(String nome);

   
    boolean existsByEvento(String nome);
    

   
    

    

   
}
