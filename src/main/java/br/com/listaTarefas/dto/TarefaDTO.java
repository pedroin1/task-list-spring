package br.com.listaTarefas.dto;

public record TarefaDTO(
        Long id,
        String value,
        boolean checked
) {
}
