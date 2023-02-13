package util.boleto;

import util.consultas.Query;

public class CodigoBarraBanrisul {

    public static String getCodigoBarra(String empEmpresa, String filFilial, String tipCodigo, String titCodigo) {
    	Query query = new Query();
    	String codigoBarra = null;
    	try {
    		codigoBarra = query.retorna("SELECT fct_ctr_codigo_barra_banri('"+empEmpresa+"', '"+filFilial+"', '"+tipCodigo+"', '"+titCodigo+"') FROM DUAL");
    	} catch (Exception e) {
    	} 
    	return codigoBarra;
    }
    
    public static String getLinhaDigitavel(String empEmpresa, String filFilial, String tipCodigo, String titCodigo) {
    	Query query = new Query();
    	String linhaDigitavel = null;
    	try {
    		linhaDigitavel = query.retorna("SELECT fct_ctr_gera_linha_digitavel(fct_ctr_codigo_barra_banri('"+empEmpresa+"', '"+filFilial+"', '"+tipCodigo+"', '"+titCodigo+"')) FROM DUAL");
    	} catch (Exception e) {
    	}
    	return linhaDigitavel;
    }
    
    public static String getCodigoBarra(com.egen.util.jdbc.JdbcUtil j, String empEmpresa, String filFilial, String tipCodigo, String titCodigo) {
    	Query query = new Query();
    	String codigoBarra = null;
    	try {
    		codigoBarra = query.retorna(j, "SELECT fct_ctr_codigo_barra_banri('"+empEmpresa+"', '"+filFilial+"', '"+tipCodigo+"', '"+titCodigo+"') FROM DUAL");
    	} catch (Exception e) {
    	} 
    	return codigoBarra;
    }
    
    public static String getLinhaDigitavel(com.egen.util.jdbc.JdbcUtil j, String empEmpresa, String filFilial, String tipCodigo, String titCodigo) {
    	Query query = new Query();
    	String linhaDigitavel = null;
    	try {
    		linhaDigitavel = query.retorna(j, "SELECT fct_ctr_gera_linha_digitavel(fct_ctr_codigo_barra_banri('"+empEmpresa+"', '"+filFilial+"', '"+tipCodigo+"', '"+titCodigo+"')) FROM DUAL");
    	} catch (Exception e) {
    	}
    	return linhaDigitavel;
    }    
    
	public static String getCodigoBarra(String base) {
		String baseCodigoBarra = "21" + base.substring(5,23)+"041";
		int dv1 = getMod10(baseCodigoBarra);
		int dv2 = getMod11NossoNumero(baseCodigoBarra+(dv1+1));
		StringBuilder sb = new StringBuilder();
		sb.append(base.substring(0,4)).append("X");
		sb.append(base.substring(27,41));
		sb.append("21");
		sb.append(base.substring(5, 8));
		sb.append(base.substring(8,15));
		sb.append(base.substring(15,23));
		sb.append("040");
		sb.append(dv1+""+dv2);
		int dac = getDac(sb.toString().replace("X", ""));
		String retorno = sb.toString().replace("X",  dac+"");
		return retorno;
	}
	
	public static String getLinhaDigitavel(String base) {
		String baseCodigoBarra = "21" + base.substring(5,23)+"041";
		StringBuilder sb = new StringBuilder();
		int dv1 = getMod10(baseCodigoBarra);
		int dv2 = getMod11NossoNumero(baseCodigoBarra+(dv1+1));
		sb.append(base.substring(0,4)).append("X");
		sb.append(base.substring(26,40));
		sb.append("21");
		sb.append(base.substring(5, 8));
		sb.append(base.substring(8,15));
		sb.append(base.substring(15,23));
		sb.append("041");
		sb.append(dv1+""+dv2);
		int dac = getDac(sb.toString().replace("X", ""));
		int dvCampo2;
		int dvCampo3;
		String campo1;
		String campo2;
		String campo3;
		String campo4;
		StringBuilder linhaDigitavel = new StringBuilder();
		campo1 = "04192.12909";
		dvCampo2 = getMod10("0478830" + base.substring(15,18));
		campo2 = "04788.30" + base.substring(15,18) + dvCampo2;
		dvCampo3 = getMod10(base.substring(18,23)+"041"+dv1+""+dv2);
		campo3 = base.substring(18,23)+".041"+dv1 + ""+ dv2 + dvCampo3;
		campo4 = base.substring(26,40);
		linhaDigitavel.append(campo1);
		linhaDigitavel.append("  ");
		linhaDigitavel.append(campo2);
		linhaDigitavel.append("  ");
		linhaDigitavel.append(campo3);
		linhaDigitavel.append("  ");
		linhaDigitavel.append(dac);
		linhaDigitavel.append(" ");
		linhaDigitavel.append(campo4);
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
	
	private static int getMod11NossoNumero(String num) {
		int total = 0;
		int peso = 2;
		for (int i = 0; i < 22; i++) {
			try {
				total += (num.charAt(23 - i) - '0') * peso;
			} catch (StringIndexOutOfBoundsException e) {
				e.printStackTrace(System.out);
				throw e;
			}
			peso++;
			if (peso == 8) {
				peso = 2;
			}
		}
		int resto = total % 11;
		return (resto == 0 || resto == 1 || resto == 10) ? 1 : (11 - resto);
	}	
	
	private static int getDac(String num) {
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