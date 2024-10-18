package com.CRUD.App.Service;

import com.CRUD.App.Model.Usuario;
import com.CRUD.App.Model.dto.UsuarioDTO;
import com.CRUD.App.config.JwtRequest;
import com.CRUD.App.config.JwtResponse;

public interface UsuarioService {
    String crearUsuario(UsuarioDTO usuario);
    String autenticarUsuario(JwtRequest jwtRequest, String apiKey);

}
