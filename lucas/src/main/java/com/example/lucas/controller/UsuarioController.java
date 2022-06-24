package com.example.lucas.controller;

import com.example.lucas.model.UsuarioModel;
import com.example.lucas.repository.UsuarioRepository;
import com.example.lucas.services.UsuarioService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller

public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private UsuarioService usuarioService;


   @RequestMapping(value = "/consultaBuscar", method = RequestMethod.GET)
   @ResponseBody
    public String buscar(@RequestParam(name = "nUsuario") String nome){

        List<UsuarioModel> usuariosEncontrados = usuarioService.getUserByNome(nome);
        JSONObject usuarioJson = null;
        if(!usuariosEncontrados.isEmpty()){
            usuarioJson = new JSONObject(usuariosEncontrados.get(0));
        }

        return !usuariosEncontrados.isEmpty() ? usuarioJson.toString() : "null";
    }

    @RequestMapping(value="/cadastroCriar", method = RequestMethod.GET)
    public String createGet() {

        return "cadastro";
    }

    @RequestMapping(value="/cadastroCriar", method=RequestMethod.POST)
    public String createPost( @RequestParam(name = "nUsuario") String nome,
                              @RequestParam(name = "nEmail") String email,
                              @RequestParam(name = "nCpf") String cpf,
                              @RequestParam(name = "nSenha") String senha,
                              @RequestParam(name = "nDtNasc") String dataNascimento,
                              @RequestParam(name = "nSexo") String sexo) throws ParseException {

     SimpleDateFormat formato = new SimpleDateFormat("yyyy-mm-dd");
        Date dataFormatada = formato.parse(dataNascimento);

        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setNome(nome);
        usuarioModel.setEmail(email);
        usuarioModel.setCpf(cpf);
        usuarioModel.setSenha(senha);
        usuarioModel.setDataNascimento(dataFormatada);
        usuarioModel.setSexo(sexo);

        usuarioRepository.save(usuarioModel);
        return "redirect:/cadastroCriar";
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(name = "nId") Long id){
       usuarioService.deleteById(id);
       return "redirect:/consulta";
    }

    @RequestMapping(value="/update", method=RequestMethod.POST)
    public String update(@RequestParam(name = "nIdUp") Long id,
                         @RequestParam(name = "nUsuarioUp") String nome,
                         @RequestParam(name = "nEmailUp") String email,
                         @RequestParam(name = "nSenhaUp") String senha)
  {

       UsuarioModel usuarioUpdate = usuarioRepository.findById(id).orElseThrow();

        usuarioUpdate.setNome(nome);
        usuarioUpdate.setEmail(email);
        usuarioUpdate.setSenha(senha);



        usuarioRepository.save(usuarioUpdate);
        return "redirect:/consulta";
    }

}


