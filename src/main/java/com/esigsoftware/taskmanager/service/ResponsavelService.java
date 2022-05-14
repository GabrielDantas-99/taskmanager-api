package com.esigsoftware.taskmanager.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esigsoftware.taskmanager.domain.Responsavel;
import com.esigsoftware.taskmanager.repositories.ResponsavelRepository;

@Service
public class ResponsavelService {
	
	// Camada de acesso aos dados
	@Autowired
	private ResponsavelRepository repository;

	public Responsavel findById(Integer id) {
		Optional<Responsavel> obj = repository.findById(id);
		return obj.orElse(null);
	}
	
}
