package com.example.centaure.Centaure.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.centaure.Centaure.models.Evento;
import com.example.centaure.Centaure.repositores.EventoRepositores;

import extencao.EventoInvalid;



@Service
public class EventoService {
    
     @Autowired
    private EventoRepositores eventoRepositores; 

      public Evento criar(Evento evento) {
    	  
      return eventoRepositores.save(evento);
      
      }

   
      // Verifica se os inputs solicitados estão vazios
    public void salvar(Evento evento) throws EventoInvalid {
    
        if (evento.getNomeEvento().trim().isEmpty() ||
        evento.getDataEvento().trim().isEmpty() || 
        evento.getLocalEvento().trim().isEmpty() || 
        evento.getObservacoes().trim().isEmpty() 
        
                ){
            
        }
         if (this.eventoRepositores.existsByEvento(evento.getEvento()) ) {
            throw new EventoInvalid("Evento já cadastrado!");
        } 
        

    }


    public List<Evento> listar(Evento evento) {
        return eventoRepositores.findAll();
    }


    public String deletar(Integer id){
        eventoRepositores.deleteById(id);
        return "";
    }

     public Optional<Evento> editar(Integer id) {
        return eventoRepositores.findById(id);
    }


	public Object criptografarSenha(Evento evento) {
		// TODO Auto-generated method stub
		return null;
	}


	public void emailSender(Evento evento) {
		// TODO Auto-generated method stub
		
	}
  



}
