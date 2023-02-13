package com.beirario.brportal.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 
 * @author mateus_garbrecht
 */
public class DateUtil {

	private String formato;

	public DateUtil(String formato) {
		this.formato = formato;
	}

	public DateUtil() {
		this.formato = "dd/MM/yyyy";
	}

	public Date parseDateByFormat(String periodo, String novoFormato) {
		SimpleDateFormat sdf = new SimpleDateFormat(novoFormato);
		Date mesAno = null;
		try {
			mesAno = sdf.parse(periodo);
		} catch (ParseException e) {
			e.printStackTrace(System.err);
		}
		return mesAno;
	}

	public String formatDateByFormat(Date data, String novoFormato) {
		SimpleDateFormat sdf = new SimpleDateFormat(novoFormato);
		String dataFormatada = null;
		dataFormatada = sdf.format(data);
		return dataFormatada;
	}

	public Date parseDate(String periodo) {
		SimpleDateFormat sdf = new SimpleDateFormat(this.formato);
		Date mesAno = null;
		try {
			mesAno = sdf.parse(periodo);
		} catch (ParseException e) {
			e.printStackTrace(System.err);
		}
		return mesAno;
	}

	public String formatDate(Date data) {
		SimpleDateFormat sdf = new SimpleDateFormat(this.formato);
		String dataFormatada = null;
		dataFormatada = sdf.format(data);
		return dataFormatada;
	}

	public String getDataAtual() {
		return formatDate(new java.util.Date());
	}

	public int diferencaHoras(Date dataInicial, Date dataFinal) {
		GregorianCalendar maior = new GregorianCalendar();
		maior.setTime(dataFinal);
		GregorianCalendar menor = new GregorianCalendar();
		menor.setTime(dataInicial);
		GregorianCalendar dif = new GregorianCalendar();
		dif.setTimeInMillis(maior.getTimeInMillis() - menor.getTimeInMillis());
		int diferencaHoras = dif.get(GregorianCalendar.HOUR);
		return diferencaHoras;
	}
	
	public int diferencaDias(Date dataInicial, Date dataFinal) {
		GregorianCalendar maior = new GregorianCalendar();
		maior.setTime(dataFinal);
		GregorianCalendar menor = new GregorianCalendar();
		menor.setTime(dataInicial);
		GregorianCalendar dif = new GregorianCalendar();
		dif.setTimeInMillis(maior.getTimeInMillis() - menor.getTimeInMillis());
		int diferencaDias = dif.get(GregorianCalendar.DAY_OF_MONTH);
		return diferencaDias;
	}

	public int diferencaSemanas(Date dataInicial, Date dataFinal) {
		GregorianCalendar maior = new GregorianCalendar();
		maior.setTime(dataFinal);
		GregorianCalendar menor = new GregorianCalendar();
		menor.setTime(dataInicial);
		GregorianCalendar dif = new GregorianCalendar();
		dif.setTimeInMillis(maior.getTimeInMillis() - menor.getTimeInMillis());
		int diferencaSemanas = dif.get(GregorianCalendar.WEEK_OF_YEAR);
		return diferencaSemanas;
	}

	public int diferencaMeses(Date dataInicial, Date dataFinal) {
		boolean dataIniMaior = false;
		int diferencaMeses = 0;
		GregorianCalendar g1 = new GregorianCalendar();
		g1.setTime(dataInicial);
		GregorianCalendar g2 = new GregorianCalendar();
		g2.setTime(dataFinal);
		int meses = 0;
		while (g1.before(g2)) {
			g1.add(Calendar.MONTH, 1);
			diferencaMeses = dataIniMaior ? --meses : ++meses;
		}
		return diferencaMeses;
	}

	public int diferencaDias(String dataInicial, String dataFinal) {
		GregorianCalendar maior = new GregorianCalendar();
		maior.setTime(parseDate(dataFinal));
		GregorianCalendar menor = new GregorianCalendar();
		menor.setTime(parseDate(dataInicial));
		GregorianCalendar dif = new GregorianCalendar();
		dif.setTimeInMillis(maior.getTimeInMillis() - menor.getTimeInMillis());
		int diferencaDias = dif.get(GregorianCalendar.DAY_OF_MONTH);
		return diferencaDias;
	}

	public int diferencaSemanas(String dataInicial, String dataFinal) {
		GregorianCalendar maior = new GregorianCalendar();
		maior.setTime(parseDate(dataFinal));
		GregorianCalendar menor = new GregorianCalendar();
		menor.setTime(parseDate(dataInicial));
		GregorianCalendar dif = new GregorianCalendar();
		dif.setTimeInMillis(maior.getTimeInMillis() - menor.getTimeInMillis());
		int diferencaSemanas = dif.get(GregorianCalendar.WEEK_OF_YEAR);
		return diferencaSemanas;
	}

	public int diferencaMeses(String dataInicial, String dataFinal) {
		boolean dataIniMaior = false;
		int diferencaMeses = 0;
		GregorianCalendar g1 = new GregorianCalendar();
		g1.setTime(parseDate(dataInicial));
		GregorianCalendar g2 = new GregorianCalendar();
		g2.setTime(parseDate(dataFinal));
		int meses = 0;
		while (g1.before(g2)) {
			g1.add(Calendar.MONTH, 1);
			diferencaMeses = dataIniMaior ? --meses : ++meses;
		}
		return diferencaMeses;
	}

}
