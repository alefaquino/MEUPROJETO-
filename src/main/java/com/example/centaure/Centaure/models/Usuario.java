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
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true , nullable = true)
    private String cpf;

    @Column(nullable = false)
    private String numero;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataNascimento;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    private String codVerificar;

	public String getSenha() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getNome() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getNumero() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCpf() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setCodVerificar(String verificador) {
		// TODO Auto-generated method stub
		
	}

	public Object getCodVerificar() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setSenha(String hashpw) {
		// TODO Auto-generated method stub
		
	}

	
     
}