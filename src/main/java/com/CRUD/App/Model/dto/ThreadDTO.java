package com.CRUD.App.Model.dto;

import lombok.Data;

@Data
public class ThreadDTO {


    private String title;
    private String message;
    private Long userId;
    private Long publicationId;
}
