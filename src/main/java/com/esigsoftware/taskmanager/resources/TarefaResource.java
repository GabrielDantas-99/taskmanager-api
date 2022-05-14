package com.esigsoftware.taskmanager.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esigsoftware.taskmanager.domain.Tarefa;
import com.esigsoftware.taskmanager.service.TarefaService;

@RestController
@RequestMapping(value = "/tarefas")
public class TarefaResource {
	
	@Autowired
	private TarefaService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Tarefa> findById(@PathVariable Integer id) {
		Tarefa obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
