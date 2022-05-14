package com.esigsoftware.taskmanager.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.esigsoftware.taskmanager.domain.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {

	@Query("SELECT obj FROM tabela_tarefas obj WHERE obj.responsavel.id = :id_resp ORDER BY titulo")
	List<Tarefa> findAllByResponsavel(@Param(value = "id_resp") Integer id_resp);
	
}
