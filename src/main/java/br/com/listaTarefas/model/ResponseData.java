package br.com.listaTarefas.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseData {

    private boolean accepted;
    private Object data;

    public ResponseData(Object data, boolean accepted){
        this.data = data;
        this.accepted = accepted;
    }
}
