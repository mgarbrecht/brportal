package util.text;

import java.text.Normalizer;

public class Caracteres {

	public static String removerAcentos(final String s) {
		return Normalizer.normalize(s, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}
	
	public static String retornaSomenteNumeros(final String s){
		return s.replaceAll("\\D+","");
	}
	
}
