package util.mensagem;

import javax.servlet.http.HttpSession;

public class Aviso {

	public static void mostra (HttpSession session, String titulo, String mensagem, String foco){
		session.setAttribute("titulo", titulo);
		session.setAttribute("mensagem", mensagem);
		session.setAttribute("foco", foco);
	}
	
	public static void mostra (HttpSession session, String titulo, String mensagem){
		session.setAttribute("titulo", titulo);
		session.setAttribute("mensagem", mensagem);
		session.removeAttribute("foco");
	}	
}
