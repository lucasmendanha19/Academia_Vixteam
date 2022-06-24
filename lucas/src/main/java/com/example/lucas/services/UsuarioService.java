package com.example.lucas.services;

import com.example.lucas.model.UsuarioModel;
import com.example.lucas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService{
    @Autowired
    private UsuarioRepository usuarioRepository;



    public List<UsuarioModel> getUserByNome(String nome) {
        return usuarioRepository.findByNome(nome);
    }

    public void deleteById(Long id){
        if (usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
        }
    }

}
