package com.CRUD.App.Service.impl;

import com.CRUD.App.Model.Usuario;
import com.CRUD.App.Model.dto.UsuarioDTO;
import com.CRUD.App.Repository.UsuarioRepository;
import com.CRUD.App.Service.UsuarioService;
import com.CRUD.App.config.JwtRequest;
import com.CRUD.App.config.JwtResponse;
import com.CRUD.App.config.security.JwtAuthenticationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtAuthenticationConfig jwtAuthtenticationConfig;



    @Override
    public String crearUsuario(UsuarioDTO usuario) {
        Usuario user = new Usuario();
        user.setUsername(usuario.getUsername());
        user.setPassword(usuario.getPassword());
        user.setEmail(usuario.getEmail());
        user.setApiKey(usuario.getApiKey());
        usuarioRepository.save(user);
        return "Usuario creado";
    }

    @Override
    public String autenticarUsuario(JwtRequest authRequest, String apiKey) {
        Usuario user = findByUsernameANDPasword(authRequest, apiKey);
        return jwtAuthtenticationConfig.getJwToken(user);
    }

    private Usuario findByUsernameANDPasword(JwtRequest authRequest, String apiKey) {
        return usuarioRepository.findByUsernameAndPasswordAndApiKey(authRequest.getUsername(), authRequest.getPassword(), apiKey);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
    }

    public static Long getCurrentUserId() {
        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        return (Long) authentication.getDetails();
    }
}
