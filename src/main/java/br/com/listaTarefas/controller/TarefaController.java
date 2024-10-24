package br.com.listaTarefas.controller;

import br.com.listaTarefas.service.TarefasService;
import br.com.listaTarefas.dto.TarefaDTO;
import br.com.listaTarefas.entity.Tarefa;
import br.com.listaTarefas.model.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tarefa")
public class TarefaController extends BaseController {

    @Autowired
    private TarefasService service;

    @GetMapping()
    public @ResponseBody ResponseEntity<ResponseData> getTasks() throws Exception {
        List<Tarefa> tarefasEntityList = service.getTarefas();
        return this.success(tarefasEntityList);
    }

    @PostMapping()
    public @ResponseBody ResponseEntity<ResponseData> createTask(@RequestBody TarefaDTO tarefaDTO) throws Exception {
        Tarefa newTarefa = service.createTarefa(tarefaDTO);
        return this.success(newTarefa);
    }

    @PutMapping()
    public @ResponseBody ResponseEntity<ResponseData> updateTask(@RequestBody TarefaDTO tarefaDTO) throws Exception {
        Tarefa updatedTask = service.updateTarefa(tarefaDTO);
        return this.success(updatedTask);
    }


    @DeleteMapping("{idTask}")
    public @ResponseBody ResponseEntity<ResponseData> deleteTask(@PathVariable Long idTask) throws Exception {
        service.deleteTask(idTask);
        return this.success("Deleted");
    }

    @DeleteMapping("deleteAllTasks")
    public @ResponseBody ResponseEntity<ResponseData> deleteAllTask() throws Exception {
        service.deleteAllTask();
        return this.success("Deleted all tasks");
    }
}
