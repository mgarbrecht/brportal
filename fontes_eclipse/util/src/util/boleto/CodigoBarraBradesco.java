package util.boleto;

import util.consultas.Query;

public class CodigoBarraBradesco {

	public static String getCodigoBarra(String base) {
		String baseDigitoVerificador = base.replace("X", "");
		String baseDV = baseDigitoVerificador.substring(0, 43);
		String codigoBarra = (base.substring(0, 44)).replace("X", getMod11(baseDV)+"");
		return codigoBarra;
	}
	
	public static String getLinhaDigitavel(String base) {
		String bb = base.replace("X", "");
		String baseCodigoBarra = bb.substring(0, 24) + bb.substring(24, 43);
		int dvCampo1;
		int dvCampo2;
		int dvCampo3;
		String campo1;
		String campo2;
		String campo3;
		String campo4;
		String campo5;
		StringBuilder linhaDigitavel = new StringBuilder();
		campo1 = base.substring(0,3) +  base.substring(3,4) + base.substring(19,20) + "." + base.substring(20,24);

		dvCampo1 = getMod10(base.substring(0,3) + base.substring(3,4) + base.substring(19,20)+ base.substring(20,24));
		
		campo2 = base.substring(24,29) +"." + base.substring(29,34);
		dvCampo2 = getMod10(base.substring(24,29) + base.substring(29,34));
	
		campo3 = base.substring(34,39) + "." + base.substring(39,44);
		dvCampo3 = getMod10(base.substring(34,40) + base.substring(40,44));
	
		campo4 = getMod11(baseCodigoBarra)+"";
		campo5 = base.substring(5,19);
		linhaDigitavel.append(campo1);
		linhaDigitavel.append(dvCampo1);
		linhaDigitavel.append(" ");
		linhaDigitavel.append(campo2);
		linhaDigitavel.append(dvCampo2);
		linhaDigitavel.append(" ");
		linhaDigitavel.append(campo3);
		linhaDigitavel.append(dvCampo3);
		linhaDigitavel.append(" ");
		linhaDigitavel.append(campo4);
		linhaDigitavel.append(" ");
		linhaDigitavel.append(campo5);
		return linhaDigitavel.toString();
	}

	private static int getMod10(String idWithoutCheckdigit) {
		idWithoutCheckdigit = idWithoutCheckdigit.trim().toUpperCase();
		int sum = 0;
		for (int i = 0; i < idWithoutCheckdigit.length(); i++) {
			char ch = idWithoutCheckdigit.charAt(idWithoutCheckdigit.length() - i - 1);
			int digit = (int) ch - 48;
			int weight;
			if (i % 2 == 0) {
				weight = (2 * digit) - (int) (digit / 5) * 9;
			} else {
				weight = digit;
			}
			sum += weight;
		}
		sum = Math.abs(sum) + 10;
		return (10 - (sum % 10)) % 10;
	}

	private static int getMod11(String num) {
		int total = 0;
		int peso = 2;
		for (int i = 0; i < 43; i++) {
			try {
				total += (num.charAt(42 - i) - '0') * peso;
			} catch (StringIndexOutOfBoundsException e) {
				e.printStackTrace(System.out);
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