package com.aredu.secretaria.dtos;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;

public class AlunoDTO {
	private Long id;
	private String nome;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataNasc;

	private String cpf;
	private String mae;

	public AlunoDTO() {

	}

	public AlunoDTO(Long id, String nome, LocalDate dataNasc, String cpf, String mae) {
		this.id = id;
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.cpf = cpf;
		this.mae = mae;
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

	public String getMae() {
		return mae;
	}

	public void setMae(String mae) {
		this.mae = mae;
	}
    
    
    
   
	
   

   
}
