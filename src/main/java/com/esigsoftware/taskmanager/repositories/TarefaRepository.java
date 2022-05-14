package com.esigsoftware.taskmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esigsoftware.taskmanager.domain.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {

}
