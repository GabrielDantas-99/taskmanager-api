package com.esigsoftware.taskmanager.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esigsoftware.taskmanager.domain.Responsavel;
import com.esigsoftware.taskmanager.service.ResponsavelService;

@RestController
@RequestMapping(value="/responsaveis")
public class ResponsavelResource {
	
	@Autowired
	private ResponsavelService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Responsavel> findById(@PathVariable Integer id) {
		Responsavel obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
