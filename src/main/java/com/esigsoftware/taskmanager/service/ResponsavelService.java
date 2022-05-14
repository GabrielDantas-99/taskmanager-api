package com.esigsoftware.taskmanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esigsoftware.taskmanager.domain.Responsavel;
import com.esigsoftware.taskmanager.dtos.ResponsavelDTO;
import com.esigsoftware.taskmanager.repositories.ResponsavelRepository;
import com.esigsoftware.taskmanager.service.exceptions.ObjectNotFoundException;

@Service
public class ResponsavelService {

	// Camada de acesso aos dados
	@Autowired
	private ResponsavelRepository repository;

	public Responsavel findById(Integer id) {
		Optional<Responsavel> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Responsavel.class.getName()));
	}

	public List<Responsavel> findAll() {
		return repository.findAll();
	}
	// Criando Responsavel
	public Responsavel create(Responsavel obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	// Atualizando reponsavel
	public Responsavel update(Integer id, ResponsavelDTO objDto) {
		Responsavel obj = findById(id);
		obj.setNome(objDto.getNome());
		obj.setDescricao(objDto.getDescricao());
		return repository.save(obj);
	}
}
