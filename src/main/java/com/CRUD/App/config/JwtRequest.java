package com.CRUD.App.config;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class JwtRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String username;
    private String password;

}
