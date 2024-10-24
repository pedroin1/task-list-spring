package br.com.listaTarefas.entity;

import br.com.listaTarefas.dto.TarefaDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_tarefas")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarefa")
    private Long id;

    @Column(name = "ds_tarefa")
    private String value;

    @Column(name = "bt_concluida")
    private int checked;
}
