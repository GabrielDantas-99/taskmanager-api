package com.esigsoftware.taskmanager.dtos;

import java.io.Serializable;

import com.esigsoftware.taskmanager.domain.Tarefa;

public class TarefaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String titulo;

	public TarefaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TarefaDTO(Tarefa obj) {
		super();
		this.id = obj.getId();
		this.titulo = obj.getTitulo();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
