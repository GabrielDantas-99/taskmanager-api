package com.esigsoftware.taskmanager.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esigsoftware.taskmanager.domain.Tarefa;
import com.esigsoftware.taskmanager.repositories.TarefaRepository;
import com.esigsoftware.taskmanager.service.exceptions.ObjectNotFoundException;

@Service
public class TarefaService {

	@Autowired
	private TarefaRepository repository; 

	public Tarefa findById(Integer id) {
		Optional<Tarefa> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Tarefa não encontrada! Id: " + id + ", Tipo: " + Tarefa.class.getName()));
	}

}
