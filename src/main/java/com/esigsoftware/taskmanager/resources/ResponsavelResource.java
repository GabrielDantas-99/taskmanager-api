package com.esigsoftware.taskmanager.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.esigsoftware.taskmanager.domain.Responsavel;
import com.esigsoftware.taskmanager.dtos.ResponsavelDTO;
import com.esigsoftware.taskmanager.service.ResponsavelService;

@RestController
@RequestMapping(value = "/responsaveis")
public class ResponsavelResource {

	@Autowired
	private ResponsavelService service;

	// Retornando responsaveis por id
	@GetMapping(value = "/{id}")
	public ResponseEntity<Responsavel> findById(@PathVariable Integer id) {
		Responsavel obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	// Retornando todos os responsaveis
	@GetMapping
	public ResponseEntity<List<ResponsavelDTO>> findAll() {
		List<Responsavel> list = service.findAll();
		List<ResponsavelDTO> listDTO = list.stream().map(obj -> new ResponsavelDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	// Criando responsavel
	@PostMapping
	public ResponseEntity<Responsavel> create(@RequestBody Responsavel obj){
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ResponsavelDTO> update(@PathVariable Integer id, @RequestBody ResponsavelDTO objDto) {
		Responsavel newObj = service.update(id, objDto);
		return ResponseEntity.ok().body(new ResponsavelDTO(newObj));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
} 
