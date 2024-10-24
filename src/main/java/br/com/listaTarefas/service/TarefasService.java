package br.com.listaTarefas.service;

import br.com.listaTarefas.dto.TarefaDTO;
import br.com.listaTarefas.entity.Tarefa;
import br.com.listaTarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefasService {

    @Autowired
    private TarefaRepository respository;

    public List<Tarefa> getTarefas(){
        return respository.findAll();
    }

    public Tarefa createTarefa(TarefaDTO tarefaDTO) {
        return respository.save(mapDtoToEntity(tarefaDTO));
    }

    public Tarefa updateTarefa(TarefaDTO tarefaDTO) {
        return respository.save(mapDtoToEntity(tarefaDTO));
    }

    public void deleteTask(Long idTask) {
        respository.deleteById(idTask);
    }

    public void deleteAllTask() {
        respository.deleteAll();
    }

    private Tarefa mapDtoToEntity(TarefaDTO tarefaDTO){
        return Tarefa.builder()
                .id(tarefaDTO.id())
                .value(tarefaDTO.value())
                .checked(mapBooleanToInt(tarefaDTO.checked()))
                .build();
    }

    private Tarefa mapDtoToEntityToUpdate(TarefaDTO tarefaDTO){
        return Tarefa.builder()
                .id(tarefaDTO.id())
                .value(tarefaDTO.value())
                .checked(mapBooleanToInt(tarefaDTO.checked()))
                .build();
    }

    private boolean mapIntToBoolean(int integer){
        return integer == 1;
    }

    private int mapBooleanToInt(boolean bool) {
        if (bool) {
            return 1;
        } else return 0;
    }

}
