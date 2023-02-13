package util.boleto;

import util.consultas.Query;

public class CodigoBarra {

	public static String getCodigoBarra(String base) {
		String dvCodigoBarra;
		StringBuilder codigoBarra = new StringBuilder();
		dvCodigoBarra = getMod11(base) + "";
		codigoBarra.append(base.substring(0, 4)).append(dvCodigoBarra).append(base.substring(4, 8));
		codigoBarra.append(base.substring(8, 18));
		codigoBarra.append(base.substring(18, 29));
		codigoBarra.append(base.substring(29, 33));
		codigoBarra.append(base.substring(33, 43));
		return codigoBarra.toString();
	}

	public static String getLinhaDigitavel(String base) {
		int dvCodigoBarra;
		int dvCampo1;
		int dvCampo2;
		int dvCampo3;
		String campo1;
		String campo2;
		String campo3;
		StringBuilder linhaDigitavel = new StringBuilder();
		dvCodigoBarra = getMod11(base);
		String cbarra = base.substring(0, 5) + dvCodigoBarra + base.substring(4, 43);
		campo1 = cbarra.substring(0, 4) + cbarra.substring(20, 25);
		dvCampo1 = getMod10(campo1);
		campo2 = cbarra.substring(25, 35);
		dvCampo2 = getMod10(campo2);
		campo3 = cbarra.substring(35, 45);
		dvCampo3 = getMod10(campo3);
		// ---Campo 1---
		linhaDigitavel.append(cbarra.substring(0, 4)).append(cbarra.substring(20, 21));
		linhaDigitavel.append(".");
		linhaDigitavel.append(cbarra.substring(21, 25));
		linhaDigitavel.append(dvCampo1);
		linhaDigitavel.append(".");
		// ---Campo 2---
		linhaDigitavel.append(cbarra.substring(25, 30));
		linhaDigitavel.append(".");
		linhaDigitavel.append(cbarra.substring(30, 35));
		linhaDigitavel.append(dvCampo2);
		linhaDigitavel.append(".");
		// ---Campo 3---
		linhaDigitavel.append(cbarra.substring(35, 40));
		linhaDigitavel.append(".");
		linhaDigitavel.append(cbarra.substring(40, 45));
		linhaDigitavel.append(dvCampo3);
		linhaDigitavel.append(" ");
		linhaDigitavel.append(dvCodigoBarra);
		linhaDigitavel.append(" ");
		// ---Campo 4---
		linhaDigitavel.append(cbarra.substring(6, 20));
		return linhaDigitavel.toString();
	}

	private static int getMod10(String id) {
		id = id.trim().toUpperCase();
		int total = 0;
		for (int i = 0; i < id.length(); i++) {
			char ch = id.charAt(id.length() - i - 1);
			int digito = (int) ch - 48;
			int peso;
			if (i % 2 == 0) {
				peso = (2 * digito) - (int) (digito / 5) * 9;
			} else {
				peso = digito;
			}
			total += peso;
		}
		total = Math.abs(total) + 10;
		return (10 - (total % 10)) % 10;
	}

	private static int getMod11(String num) {
		int total = 0;
		int peso = 2;
		for (int i = 0; i < 43; i++) {
			try {
				total += (num.charAt(42 - i) - '0') * peso;
			} catch (StringIndexOutOfBoundsException e) {
				e.printStackTrace(System.err);
				throw e;
			}
			peso++;
			if (peso == 10) {
				peso = 2;
			}
		}
		int resto = total % 11;
		return (resto == 0 || resto == 1 || resto == 10) ? 1 : (11 - resto);
	}
	
	public String getLinhaDigitavelByTitulo(com.egen.util.jdbc.JdbcUtil j, String titulo) {
		Query query = new Query();
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT base ");
			sb.append("   FROM brconrec.base_boleto_vw ");
			sb.append("  WHERE tit_codigo = '").append(titulo).append("'");
			String base = query.retorna(j, sb.toString());
			return getLinhaDigitavel(base);
		} catch (Exception e) {
			return null;
		}
	}
	
	public String getLinhaDigitavelByTitulo(String titulo) {
		Query query = new Query();
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT base ");
			sb.append("   FROM brconrec.base_boleto_vw ");
			sb.append("  WHERE tit_codigo = '").append(titulo).append("'");
			String base = query.retorna(sb.toString());
			return getLinhaDigitavel(base);
		} catch (Exception e) {
			return null;
		}
	}

}