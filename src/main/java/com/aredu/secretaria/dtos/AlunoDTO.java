package com.aredu.secretaria.dtos;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;

public class AlunoDTO {
	private Long id;
	private String nome;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataNasc;

	private String cpf;
	private String filiacao;

	private String pastaId;

	public AlunoDTO() {

	}

	public AlunoDTO(Long id, String nome, LocalDate dataNasc, String cpf, String filiacao, String pastaId) {
		this.id = id;
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.cpf = cpf;
		this.filiacao = filiacao;
		this.pastaId = pastaId;
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

	public LocalDate getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getFiliacao() {
		return filiacao;
	}

	public void setFiliacao(String filiacao) {
		this.filiacao = filiacao;
	}

	public String getPastaId() {
		return pastaId;
	}

	public void setPastaId(String pastaId) {
		this.pastaId = pastaId;
	}
}
