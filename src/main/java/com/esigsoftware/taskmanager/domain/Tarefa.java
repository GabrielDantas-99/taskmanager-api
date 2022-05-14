package com.esigsoftware.taskmanager.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="tabela_tarefas")
public class Tarefa implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "Campo Titulo requerido!")
	@Length(min = 3, max = 50, message = "O campo Titulo deve ter entre 3 e 50 caracteres")
	private String titulo;
	
	@NotEmpty(message = "Campo Descricao requerido!")
	@Length(min = 3, max = 200, message = "O campo Descricao deve ter entre 3 e 200 caracteres")
	private String descricao;
	
	@NotEmpty(message = "Campo Prioridade requerido!")
	@Length(min = 3, max = 50, message = "O campo Prioridade deve ter entre 3 e 50 caracteres")
	private String prioridade;
	
	@NotEmpty(message = "Campo Deadline requerido!")
	@Length(min = 3, max = 50, message = "O campo Deadline deve ter entre 3 e 50 caracteres")
	private String deadline;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "responsavel_id")
	private Responsavel responsavel;

	public Tarefa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tarefa(Integer id, String titulo, String descricao, String prioridade, String deadline, Responsavel responsavel) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.prioridade = prioridade;
		this.deadline = deadline;
		this.responsavel = responsavel;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarefa other = (Tarefa) obj;
		return Objects.equals(id, other.id);
	}

}
