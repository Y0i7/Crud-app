package com.CRUD.App.config;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class JwtResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 2L;

    private String jwToken;

    public JwtResponse(String jwToken) {
        this.jwToken = jwToken;
    }

}
