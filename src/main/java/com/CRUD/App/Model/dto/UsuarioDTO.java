package com.CRUD.App.Model.dto;

import lombok.Data;

@Data
public class UsuarioDTO {

    private String username;
    private String password;
    private String email;
    private String apiKey;
}
