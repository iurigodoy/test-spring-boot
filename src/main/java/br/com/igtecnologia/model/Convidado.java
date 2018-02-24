package br.com.igtecnologia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Convidado extends Historico {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotEmpty(message="{convidado.nome.notEmpty}")
	private String nome;
	
	@Min(message="{convidado.quantidadeAcompanhantes.min}", value = 0)
	private Integer quantidadeAcompanhantes;
	
	public Convidado() {
	}
	
	public Convidado(String nome, int quantidadeAcompanhantes) {
		this.nome = nome;
		this.quantidadeAcompanhantes = quantidadeAcompanhantes;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getQuantidadeAcompanhantes() {
		return quantidadeAcompanhantes;
	}
	public void setQuantidadeAcompanhantes(Integer quantidadeAcompanhantes) {
		this.quantidadeAcompanhantes = quantidadeAcompanhantes;
	}
	
}