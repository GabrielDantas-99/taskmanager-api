package com.esigsoftware.taskmanager.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esigsoftware.taskmanager.domain.Responsavel;
import com.esigsoftware.taskmanager.domain.Tarefa;
import com.esigsoftware.taskmanager.repositories.ResponsavelRepository;
import com.esigsoftware.taskmanager.repositories.TarefaRepository;

@Service
public class DBService {
	
	// Camada de acesso aos dados
	@Autowired
	private ResponsavelRepository responsavelRepository;
	@Autowired
	private TarefaRepository tarefaRepository;

	public void instanciandoBD() {
		
		Responsavel r1 = new Responsavel(null, "Gabriel", "Full-Stack");
		Responsavel r2 = new Responsavel(null, "Felipe", "Back-End");
		Responsavel r3 = new Responsavel(null, "Daniel", "Front-End");
				
		Tarefa t1 = new Tarefa(null, "Criar", "Criar algo", "Alta", "22/05/2022", r1);
		Tarefa t2 = new Tarefa(null, "Editar", "Editar algo", "Média", "22/05/2022", r3);
		Tarefa t3 = new Tarefa(null, "Deletar", "Deletar algo", "Baixa", "22/05/2022", r2);
		Tarefa t4 = new Tarefa(null, "Ler", "Ler algo", "Alta", "22/05/2022", r1);
		Tarefa t5 = new Tarefa(null, "CRUD", "CRUD taskmanager", "Alta", "22/05/2022", r2);
		
		r1.getTarefas().addAll(Arrays.asList(t1, t4));
		r2.getTarefas().addAll(Arrays.asList(t3, t5));
		r3.getTarefas().addAll(Arrays.asList(t2));
		
		this.responsavelRepository.saveAll(Arrays.asList(r1, r2, r3));
		this.tarefaRepository.saveAll(Arrays.asList(t1, t2, t3, t4, t5));
		
	}
	
}
