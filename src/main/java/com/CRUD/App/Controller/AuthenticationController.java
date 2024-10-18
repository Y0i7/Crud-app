package com.CRUD.App.Controller;

import com.CRUD.App.Model.Usuario;
import com.CRUD.App.Model.dto.UsuarioDTO;
import com.CRUD.App.Repository.UsuarioRepository;
import com.CRUD.App.Service.UsuarioService;
import com.CRUD.App.config.JwtRequest;
import com.CRUD.App.config.JwtResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autenticar")
@Slf4j
public class AuthenticationController {

    @Autowired
    private UsuarioService usuarioService;



    @PostMapping("/login")
    public ResponseEntity<JwtResponse> autenticarUsuario(@RequestBody JwtRequest authRequest, @RequestHeader("ApiKey") String ApiKey)
            throws Exception {

        log.info(authRequest.getUsername());
        log.info(authRequest.getPassword());
        log.info(ApiKey);

        String token = usuarioService.autenticarUsuario(authRequest, ApiKey);


        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping("/registrar")
    public ResponseEntity<String> crearUsuario(@RequestBody UsuarioDTO dto) {
        return ResponseEntity.ok(usuarioService.crearUsuario(dto));
    }
}
