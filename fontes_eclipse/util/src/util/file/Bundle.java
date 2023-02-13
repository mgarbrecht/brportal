package util.file;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Bundle {

	public static String getKey(String arquivo, String chave) {
		String descricao = null;
		try {
			ResourceBundle resources = java.util.ResourceBundle.getBundle(arquivo);
			descricao = resources.getString(chave);
		} catch (MissingResourceException mre) {
			descricao = "";
		}
		return descricao;
	}
}
