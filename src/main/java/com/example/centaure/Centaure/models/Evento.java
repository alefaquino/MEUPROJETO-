package com.example.centaure.Centaure.models;

import com.example.centaure.Centaure.enums.Sexo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nomeEvento;

    @Column(nullable = false, unique = true)
    private String local;

    @Column(nullable = false)
    private String celular;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataEvento;

    @Column(nullable = false, unique = true)
    private String observacoes;

 

    private String codVerificar;

    
    @OneToMany(mappedBy = "evento")
    List<Usuario> usuario;


	public String getNomeEvento() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getDataEvento() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getLocalEvento() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getObservacoes() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getEvento() {
		// TODO Auto-generated method stub
		return null;
	}


	public void setSenha(Object criptografarSenha) {
		// TODO Auto-generated method stub
		
	}


	

     



  

}
