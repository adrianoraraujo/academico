package br.ucsal.bes20181.testequalidade.academico.domain;

import java.util.Calendar;
import java.util.Date;

import br.ucsal.bes20181.testequalidade.academico.enums.SituacaoAcademica;

public class AlunoBuilder
{

	private Integer matricula;
	private String nome;
	private SituacaoAcademica situacaoAcademica;
	private Date dataNascimento;

	public AlunoBuilder comSituacaoAtivo()
	{
		situacaoAcademica = SituacaoAcademica.ATIVO;
		return this;
	}

	public AlunoBuilder comSituacaoFormado()
	{
		situacaoAcademica = SituacaoAcademica.FORMADO;
		return this;
	}

	public AlunoBuilder comSituacaoTrancado()
	{
		situacaoAcademica = SituacaoAcademica.TRANCADO;
		return this;
	}

	public AlunoBuilder com18Anos()
	{
		Calendar calendar = Calendar.getInstance();
		calendar.set(2000, 5, 21);
		dataNascimento = calendar.getTime();
		return this;
	}

	public AlunoBuilder com20Anos()
	{
		Calendar calendar = Calendar.getInstance();
		calendar.set(1998, 5, 21);
		dataNascimento = calendar.getTime();
		return this;
	}

	public AlunoBuilder com22Anos()
	{
		Calendar calendar = Calendar.getInstance();
		calendar.set(1996, 5, 21);
		dataNascimento = calendar.getTime();
		return this;
	}

	public Aluno build()
	{
		return new Aluno(matricula, nome, situacaoAcademica, dataNascimento);
	}
}
