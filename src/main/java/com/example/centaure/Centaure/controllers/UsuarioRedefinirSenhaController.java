package com.example.centaure.Centaure.controllers;

import com.example.centaure.Centaure.models.Usuario;
import com.example.centaure.Centaure.service.UsuarioService;
import extencao.UserInvalid;
import extencao.UsuarioNoExistExtencao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller

public class UsuarioRedefinirSenhaController {

    @Autowired
    private UsuarioService usuarioServive;


    @GetMapping("/esqueceu/senha")
    public String esqueciSenha(){
        return "/usuario_html/esqueceu_senha_usuario";
    }

    @PostMapping("/esqueceu/senha")
    public  String esqueciSenha2(String email, RedirectAttributes ra){

        try {
            usuarioServive.pedidoAlterarSenha(email);
            return "/usuario_html/redefinindo_senha_usuario";

        } catch (UsuarioNoExistExtencao me){
            ra.addFlashAttribute("msgErroAdd", me.getMessage());
            ra.addFlashAttribute("style","margin-left: 140px; color: red;");
        }
        return "redirect:/esqueceu/senha";
    }

    @GetMapping("/redefinindo/senha")
    public String redefinirSenha(){
        return "/usuario_html/redefinindo_senha_usuario";
    }

    @PostMapping("/redefinindo/senha")
    public String redefinirSenha2(Usuario usuario, String validPassword, Model model, RedirectAttributes ra) throws UserInvalid {

        try {
            usuarioServive.validPassword(usuario, validPassword);
            Usuario u = usuarioServive.searchByCod(usuario.getCodVerificar());
            usuarioServive.validCod(u, usuario);
            usuarioServive.alterPassword(u, usuario.getSenha());
            ra.addFlashAttribute("msgSenhaAlterada","Senha alterada com sucesso");
            ra.addFlashAttribute("style","margin-left: 50px; color: green;");

            return "redirect:/redefinindo/senha";

        } catch (UserInvalid u) {
            ra.addFlashAttribute("msgError3");
            ra.addFlashAttribute("style","margin-left: 140px; color: red;");
        }
        return "redirect:/redefinindo/senha";
    }

}
