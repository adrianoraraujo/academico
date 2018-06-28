package br.ucsal.bes20181.testequalidade.academico.business;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.ucsal.bes20181.testequalidade.academico.domain.Aluno;
import br.ucsal.bes20181.testequalidade.academico.domain.AlunoBuilder;
import br.ucsal.bes20181.testequalidade.academico.enums.SituacaoAcademica;
import br.ucsal.bes20181.testequalidade.academico.persistence.MatriculaDAO;
import br.ucsal.bes20181.testequalidade.academico.util.DateUtil;

public class MatriculaBOTest
{

	
	@Mock
	MatriculaDAO matriculaDAOMock;

	@Mock
	DateUtil dateUtilMock;

	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void calcularIdadeMedia3AlunosAtivos()
	{
		MatriculaBO matriculaBO = new MatriculaBO(matriculaDAOMock, dateUtilMock);
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		AlunoBuilder aluno1 = new AlunoBuilder();
		aluno1.comSituacaoAtivo().com18Anos();
		AlunoBuilder aluno2 = new AlunoBuilder();
		aluno2.comSituacaoAtivo().com20Anos();
		AlunoBuilder aluno3 = new AlunoBuilder();
		aluno3.comSituacaoAtivo().com22Anos();
		alunos.add(aluno1.build());
		alunos.add(aluno2.build());
		alunos.add(aluno3.build());
		when(matriculaDAOMock.findBySituacaoAcademica(SituacaoAcademica.ATIVO)).thenReturn(alunos);
		for (int i = 0; i < alunos.size(); i++)
			when(dateUtilMock.calcularIdade(alunos.get(i).getDataNascimento())).thenReturn(18 + 2 * i);
		Integer idadeMedia = matriculaBO.calcularIdadeMediaAlunosAtivos();
		verify(matriculaDAOMock).findBySituacaoAcademica(SituacaoAcademica.ATIVO);
		Assert.assertEquals(20, idadeMedia.intValue());

	}

}
