package util.validate;

import java.util.regex.Pattern;

public class Validacao {

	public boolean validaEmail(String email) {
		boolean emailValido = false;
		try {
			if (email.matches("[-0-9a-zA-Z.+_]+@[-0-9a-zA-Z.+_]+\\.[a-zA-Z]{2,4}")) {
				emailValido = true;
			}
		} catch (Exception e) {
		}
		return emailValido;
	}

	public boolean validaCnpj(String cnpj) {

		class Aux {
			public int parseCharToInt(char c) {
				return Integer.parseInt(Character.toString(c));
			}

			public final String lpadS(String valueToPad, String filler, int size) {
				StringBuilder builder = new StringBuilder();

				while (builder.length() + valueToPad.length() < size) {
					builder.append(filler);
				}
				builder.append(valueToPad);
				return builder.toString();
			}
		}

		char[] aCnpj;
		cnpj = new Aux().lpadS(cnpj, "0", 14);
		cnpj = cnpj.replaceAll(Pattern.compile("\\s").toString(), "");
		cnpj = cnpj.replaceAll(Pattern.compile("\\D").toString(), "");

		int soma = 0;

		if (cnpj.length() != 14) {
			return false;
		}

		aCnpj = cnpj.toCharArray();

		soma += (new Aux().parseCharToInt(aCnpj[0]) * 5);
		soma += (new Aux().parseCharToInt(aCnpj[1]) * 4);
		soma += (new Aux().parseCharToInt(aCnpj[2]) * 3);
		soma += (new Aux().parseCharToInt(aCnpj[3]) * 2);
		soma += (new Aux().parseCharToInt(aCnpj[4]) * 9);
		soma += (new Aux().parseCharToInt(aCnpj[5]) * 8);
		soma += (new Aux().parseCharToInt(aCnpj[6]) * 7);
		soma += (new Aux().parseCharToInt(aCnpj[7]) * 6);
		soma += (new Aux().parseCharToInt(aCnpj[8]) * 5);
		soma += (new Aux().parseCharToInt(aCnpj[9]) * 4);
		soma += (new Aux().parseCharToInt(aCnpj[10]) * 3);
		soma += (new Aux().parseCharToInt(aCnpj[11]) * 2);

		int d1 = soma % 11;
		d1 = d1 < 2 ? 0 : 11 - d1;

		soma = 0;
		soma += (new Aux().parseCharToInt(aCnpj[0]) * 6);
		soma += (new Aux().parseCharToInt(aCnpj[1]) * 5);
		soma += (new Aux().parseCharToInt(aCnpj[2]) * 4);
		soma += (new Aux().parseCharToInt(aCnpj[3]) * 3);
		soma += (new Aux().parseCharToInt(aCnpj[4]) * 2);
		soma += (new Aux().parseCharToInt(aCnpj[5]) * 9);
		soma += (new Aux().parseCharToInt(aCnpj[6]) * 8);
		soma += (new Aux().parseCharToInt(aCnpj[7]) * 7);
		soma += (new Aux().parseCharToInt(aCnpj[8]) * 6);
		soma += (new Aux().parseCharToInt(aCnpj[9]) * 5);
		soma += (new Aux().parseCharToInt(aCnpj[10]) * 4);
		soma += (new Aux().parseCharToInt(aCnpj[11]) * 3);
		soma += (new Aux().parseCharToInt(aCnpj[12]) * 2);

		int d2 = soma % 11;
		d2 = d2 < 2 ? 0 : 11 - d2;

		if (new Aux().parseCharToInt(aCnpj[12]) == d1 && new Aux().parseCharToInt(aCnpj[13]) == d2) {
			return true;
		} else {
			return false;
		}

	}

}
