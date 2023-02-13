package util.consultas;

import javax.servlet.http.HttpSession;

public class Usuario {

	public static String getTipo(HttpSession se) {
		StringBuilder retorno = new StringBuilder("");
		acesso.Usuario u = new acesso.Usuario();
		u = (acesso.Usuario) se.getAttribute("User");
		acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
		acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();
		if (!(u.getEntidadeNegocio() == null)) {
			ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();
			tipoent = (acesso.TipoEntidadeNegocio) ent.getTipoEntidadeNegocio();
			retorno.append(tipoent.getTipo() + "");
		}
		return retorno.toString();
	}
}
