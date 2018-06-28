package br.ucsal.bes20181.testequalidade.academico.domain;

import java.util.Date;

import br.ucsal.bes20181.testequalidade.academico.enums.SituacaoAcademica;

public class Aluno {

	private Integer matricula;

	private String nome;

	private SituacaoAcademica situacaoAcademica;

	private Date dataNascimento;

	public Aluno(Integer matricula, String nome, SituacaoAcademica situacaoAcademica, Date dataNascimento) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.situacaoAcademica = situacaoAcademica;
		this.dataNascimento = dataNascimento;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public SituacaoAcademica getSituacaoAcademica() {
		return situacaoAcademica;
	}

	public void setSituacaoAcademica(SituacaoAcademica situacaoAcademica) {
		this.situacaoAcademica = situacaoAcademica;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
