package com.example.centaure.Centaure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.centaure.Centaure.models.Evento;
import com.example.centaure.Centaure.service.EventoService;

import extencao.EventoInvalid;

@Controller
public class EventoCadastroController {


    @Autowired
    private EventoService eventoService;

    // Referente ao cadastro
    @GetMapping("/cadastro/evento")
    public String cadastroEvento() {
        return "evento_html/cadastro_evento";
    }

    @PostMapping("/cadastro/evento")
    public String criar(Evento evento, RedirectAttributes ra){

        try {
            eventoService.salvar(evento);
            evento.setSenha(eventoService.criptografarSenha(evento));
            eventoService.criar(evento);
            eventoService.emailSender(evento);
            ra.addFlashAttribute("msgSucess", "Conta criada com sucesso!");
            ra.addFlashAttribute("style","margin-left: 120px; color: green;");
            return "redirect:/cadastro/evento";

        } catch (EventoInvalid e ){
            ra.addFlashAttribute("msgError", e.getMessage() );
            ra.addFlashAttribute("style","margin-left: 150px; color: red;");
        }
        return "redirect:/cadastro/motorista";
    }
    //--------------
}
