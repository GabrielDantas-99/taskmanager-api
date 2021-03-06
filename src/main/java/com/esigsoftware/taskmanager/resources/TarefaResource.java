package com.esigsoftware.taskmanager.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.esigsoftware.taskmanager.domain.Tarefa;
import com.esigsoftware.taskmanager.dtos.TarefaDTO;
import com.esigsoftware.taskmanager.service.TarefaService;

@CrossOrigin("*")
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
	
	@GetMapping
	public ResponseEntity<List<TarefaDTO>> findAll(@RequestParam(value = "responsavel", defaultValue = "0") Integer id_resp) {
		List<Tarefa> list = service.findAll(id_resp);
		List<TarefaDTO> listDTO = list.stream().map(obj -> new TarefaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	// Atualizando toda a tarefa
	@PutMapping(value = "/{id}")
	public ResponseEntity<Tarefa> update(@PathVariable Integer id, @Valid @RequestBody Tarefa obj) {
		Tarefa newObj = service.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}
	// Atualizando uma informa????o
	@PatchMapping(value = "/{id}")
	public ResponseEntity<Tarefa> updatePatch(@PathVariable Integer id, @Valid @RequestBody Tarefa obj) {
		Tarefa newObj = service.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	@PostMapping
	public ResponseEntity<Tarefa> create(@RequestParam(value = "responsavel", defaultValue = "0") Integer id_resp, @Valid @RequestBody Tarefa obj) {
		Tarefa newObj = service.create(id_resp, obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/tarefas/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
