package br.ucsal.bes20181.testequalidade.academico.business;

import java.util.List;

import br.ucsal.bes20181.testequalidade.academico.domain.Aluno;
import br.ucsal.bes20181.testequalidade.academico.enums.SituacaoAcademica;
import br.ucsal.bes20181.testequalidade.academico.persistence.MatriculaDAO;
import br.ucsal.bes20181.testequalidade.academico.util.DateUtil;

public class MatriculaBO {

	private MatriculaDAO matriculaDAO;
	private DateUtil dateUtil;

	public MatriculaBO(MatriculaDAO matriculaDAO, DateUtil dateUtil) {
		this.matriculaDAO = matriculaDAO;
		this.dateUtil = dateUtil;
	}

	public Integer calcularIdadeMediaAlunosAtivos() {
		List<Aluno> alunos = matriculaDAO.findBySituacaoAcademica(SituacaoAcademica.ATIVO);
		if (alunos.size() == 0) {
			return 0;
		}
		Integer idadeTotal = 0;
		for (Aluno aluno : alunos) {
			idadeTotal += dateUtil.calcularIdade(aluno.getDataNascimento());
		}
		return idadeTotal / alunos.size();
	}

}
