package com.esigsoftware.taskmanager;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.esigsoftware.taskmanager.domain.Responsavel;
import com.esigsoftware.taskmanager.domain.Tarefa;
import com.esigsoftware.taskmanager.repositories.ResponsavelRepository;
import com.esigsoftware.taskmanager.repositories.TarefaRepository;

@SpringBootApplication
public class TaskmanagerApplication implements CommandLineRunner{

	// Camada de acesso aos dados
	@Autowired
	private ResponsavelRepository responsavelRepository;
	@Autowired
	private TarefaRepository tarefaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(TaskmanagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Responsavel r1 = new Responsavel(null, "Gabriel", "Full-Stack");
				
		Tarefa t1 = new Tarefa(null, "Criar", "Criar algo", "Alta", "22/05/2022", r1);
		
		r1.getTarefas().addAll(Arrays.asList(t1));
		
		this.responsavelRepository.saveAll(Arrays.asList(r1));
		this.tarefaRepository.saveAll(Arrays.asList(t1));
		
	}

}
