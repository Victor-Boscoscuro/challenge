package com.challenge.demo.models;

import lombok.Data;

@Data
public class ResponseModel { //No necesariamente se trata como Model, podría ser un util tambien
    private String msg;
    private String error;
    private Integer status;

    //Para evitar que en el response retoren por ej msg:null, se puede parsear a JsonObject y trabajarlo como tal
    public ResponseModel(String msg, String error, Integer status){
        this.msg=msg;
        this.error=error;
        this.status=status;
    }
}
