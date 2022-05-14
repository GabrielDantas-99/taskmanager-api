package com.esigsoftware.taskmanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esigsoftware.taskmanager.domain.Responsavel;
import com.esigsoftware.taskmanager.domain.Tarefa;
import com.esigsoftware.taskmanager.repositories.TarefaRepository;
import com.esigsoftware.taskmanager.service.exceptions.ObjectNotFoundException;

@Service
public class TarefaService {

	@Autowired
	private TarefaRepository repository; 
	
	@Autowired
	private ResponsavelService responsavelService; 

	public Tarefa findById(Integer id) {
		Optional<Tarefa> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Tarefa não encontrada! Id: " + id + ", Tipo: " + Tarefa.class.getName()));
	}

	public List<Tarefa> findAll(Integer id_resp) {
		responsavelService.findById(id_resp);
		return repository.findAllByResponsavel(id_resp);
	}

	public Tarefa update(Integer id, Tarefa obj) {
		Tarefa newObj = findById(id);
		updateData(newObj, obj);
		return repository.save(newObj);
	}

	private void updateData(Tarefa newObj, Tarefa obj) {
		newObj.setTitulo(obj.getTitulo());
		newObj.setDescricao(obj.getDescricao());
		newObj.setPrioridade(obj.getPrioridade());
		newObj.setDeadline(obj.getDeadline());
	}

	public Tarefa create(Integer id_resp, Tarefa obj) {
		obj.setId(null);
		Responsavel resp = responsavelService.findById(id_resp);
		obj.setResponsavel(resp);
		return repository.save(obj);
	}
}
