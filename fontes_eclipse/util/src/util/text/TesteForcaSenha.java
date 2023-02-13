package util.text;

public class TesteForcaSenha {

	public static void main(String args[]) {

		String teste = "mateus_garbrecht@beirario.com.br#Qu3Br@!#continuacao";
		String t[] = teste.split("#Qu3Br@!#");
		System.out.println(t[0]);
		System.out.println(t[1]);

		String passwd = "";
		int intScore = 0;
		String strObservacao = "fraca";
		String strVerdict = "Fraca";
		if (passwd.length() < 5) {
			intScore = (intScore - 5);
		} else if (passwd.length() > 4 && passwd.length() < 8) {
			intScore = (intScore + 6);
		} else if (passwd.length() > 7 && passwd.length() < 16) {
			intScore = (intScore + 12);
		} else if (passwd.length() > 15) {
			intScore = (intScore + 18);
		}
		if (com.egen.util.text.Validate.isRegex(passwd, "[a-z]")) {
			intScore = (intScore + 1);
		}
		if (com.egen.util.text.Validate.isRegex(passwd, "[A-Z]")) {
			intScore = (intScore + 5);
		}
		if (com.egen.util.text.Validate.isRegex(passwd, "\\d+")) {
			intScore = (intScore + 5);
		}
		if (com.egen.util.text.Validate.isRegex(passwd, "(.*[0-9].*[0-9].*[0-9])")) {
			intScore = (intScore + 5);
		}
		if (com.egen.util.text.Validate.isRegex(passwd, ".[!,@,#,$,%,^,&,*,?,_,~]")) {
			intScore = (intScore + 5);
		}
		if (com.egen.util.text.Validate.isRegex(passwd, "(.*[!,@,#,$,%,^,&,*,?,_,~].*[!,@,#,$,%,^,&,*,?,_,~])")) {
			intScore = (intScore + 5);
		}
		if (com.egen.util.text.Validate.isRegex(passwd, "([a-z].*[A-Z])|([A-Z].*[a-z])")) {
			intScore = (intScore + 2);
		}
		if (com.egen.util.text.Validate.isRegex(passwd, "([a-zA-Z])")
				&& com.egen.util.text.Validate.isRegex(passwd, "([0-9])")) {
			intScore = (intScore + 2);
		}
		if (com.egen.util.text.Validate.isRegex(passwd, "moleca|beirario|molekinha|vizzano|modare/i")) {
			intScore = (intScore - 10);
		}
		if (com.egen.util.text.Validate.isRegex(passwd, "([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~])|([!,@,#,$,%,^,&,*,?,_,~].*[a-zA-Z0-9])")) {
			intScore = (intScore + 2);
		}
		if (intScore < 16) {
			strVerdict = "Muito Fraca";
			strObservacao = "Tente deixar a sua senha maior, adicionando letras maiúsculas, minúsculas e caracteres especiais.";
		} else if (intScore > 15 && intScore < 25) {
			strVerdict = "Fraca";
			strObservacao = "Tente deixar a sua senha maior, adicionando letras maiúsculas, minúsculas e caracteres especiais.";
		} else if (intScore > 24 && intScore < 35) {
			strVerdict = "Média";
			strObservacao = "";
		} else if (intScore > 34 && intScore < 45) {
			strVerdict = "Forte";
			strObservacao = "";
		} else {
			strVerdict = "Muito Forte";
			strObservacao = "";
		}
		System.out.println(intScore + " - " + strVerdict);
	}
}
