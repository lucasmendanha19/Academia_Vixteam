package com.example.lucas.services;
import com.example.lucas.model.UsuarioModel;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IUsuarioService {
    List<UsuarioModel> getUserByNome(String nome);
    void deleteById(Long id);
}
