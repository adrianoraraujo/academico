package br.ucsal.bes20181.testequalidade.academico.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class DateUtil {

	public Integer calcularIdade(Date dataNascimento) {
		LocalDate dataAtual = LocalDate.now();
		return Period.between(dataNascimento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), dataAtual).getYears();
	}


	public static Date toDate(String data) {
		return Date.from(LocalDate.parse(data).atStartOfDay(ZoneId.systemDefault()).toInstant());
	}
}
