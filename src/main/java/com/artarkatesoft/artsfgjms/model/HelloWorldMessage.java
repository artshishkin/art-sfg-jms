package com.artarkatesoft.artsfgjms.model;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class HelloWorldMessage implements Serializable {

    private static final long serialVersionUID = 9131247799733856565L;

    private UUID id;
    private String message;
}
