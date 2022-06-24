package com.example.lucas.repository;

import com.example.lucas.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    List<UsuarioModel> findByNome(String nome);


}
