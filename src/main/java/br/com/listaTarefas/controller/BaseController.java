package br.com.listaTarefas.controller;

import br.com.listaTarefas.model.ResponseData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BaseController {

    public ResponseEntity<ResponseData> success(Object data){
        return ResponseEntity.ok(new ResponseData(data, true));
    }

    public ResponseEntity<ResponseData> error(String errorMessage){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseData(errorMessage, false));
    }

    public ResponseEntity<ResponseData> error(String errorMessage, HttpStatus statusCode){
        return ResponseEntity.status(statusCode).body(new ResponseData(errorMessage, false));
    }
}
