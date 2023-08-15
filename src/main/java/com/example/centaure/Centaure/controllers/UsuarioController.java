package com.example.centaure.Centaure.controllers;

import com.example.centaure.Centaure.models.Usuario;
import com.example.centaure.Centaure.service.UsuarioService;
import extencao.UserInvalid;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import java.util.Optional;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioServive;


    // Página de cadastro de usuário
    @GetMapping("/cadastro/usuario")
    public String cadastro(){
        return "usuario_html/cadastro_usuario";
    }

    // Processa o cadastro de um novo usuário
    @PostMapping("/cadastro/usuario")
    public String criar( Usuario usuario,RedirectAttributes ra, Model model)  {

        try {
            // Criptografa a senha do usuário antes de salvá-lo no banco de dados
            usuario.setSenha(usuarioServive.encryptSenha(usuario));
            usuarioServive.salvando(usuario);
            usuarioServive.criar(usuario);
            usuarioServive.emailSenderUsuario(usuario);
            ra.addFlashAttribute("msgSucess", "Conta criada com sucesso!");
            ra.addFlashAttribute("style","margin-left: 120px; color: green;");
            return "redirect:/cadastro/usuario";
        }

        catch (UserInvalid e) {
            // Se ocorrer algum erro de validação, exibe a mensagem de erro e redireciona de volta para a página de cadastro
            ra.addFlashAttribute("msgError", e.getMessage());
        }
        return "redirect:/cadastro/usuario";
    }

    // Página para listar usuários
    @GetMapping("/usuario/listar")
    public String listar(Model model, Usuario usuario ){
        // Obtém a lista de usuários do banco de dados e a adiciona ao modelo para ser exibida na página
        model.addAttribute("usuario", this.usuarioServive.listar(usuario));
        return "listar_usuario";
    }

    // Página para editar um usuário específico
    @GetMapping("/usuario/editar/{id}")
    public String editar(@PathVariable Integer id, Model model){
        Optional<Usuario> usuario = this.usuarioServive.editar(id);
        model.addAttribute("usuario", usuario);
        return "usuario_html/editar_usuario";
    }

    // Processa a exclusão de um usuário específico
    @GetMapping("/usuario/deletar/{id}")
    public String deletar(@PathVariable Integer id){
        // Deleta o usuário do banco de dados com base no ID fornecido e redireciona para a página de listagem
        usuarioServive.deletar(id);
        return "redirect:/usuario/listar";
    }

}