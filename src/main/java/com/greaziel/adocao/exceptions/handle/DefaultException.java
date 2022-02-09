package com.greaziel.adocao.exceptions.handle;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DefaultException {

    private Integer status;
    private String mensagem;
    private LocalDateTime dataHora;
}
