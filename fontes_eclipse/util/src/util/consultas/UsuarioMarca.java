package util.consultas;

import javax.servlet.http.HttpServletRequest;

public class UsuarioMarca {

	HttpServletRequest req;

	public UsuarioMarca(HttpServletRequest r) {
		this.req = r;
	}

	public boolean atende(String marca) {
		boolean retorno = false;
		String regional = "null";
		String representante = "null";
		String cliente = "null";
		try {
			util.consultas.Query query = new util.consultas.Query();
			acesso.Sessao sessao = new acesso.Sessao(this.req.getSession());
			if (sessao.getTipoEntidadeNegocio().equals("REGIONAL DE VENDA")) {
				regional = sessao.getChave();
			}
			if (sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL")) {
				representante = sessao.getChave();
			}
			if (sessao.getTipoEntidadeNegocio().equals("CLIENTE MERCADO INTERNO")
					|| sessao.getTipoEntidadeNegocio().equals("CLIENTE MERCADO EXTERNO")) {
				cliente = sessao.getChave();
			}

			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT 1 ");
			sb.append("   FROM marcas_produtos mp ");
			sb.append("	 WHERE mp.status = 'A' ");
			sb.append("	   AND mp.codigo_marca = " + marca);
			sb.append("	   AND EXISTS (SELECT 1 ");
			sb.append("	                 FROM representante_marca rm ");
			sb.append("	                    , rep r ");
			sb.append("	                    , cliente_representante cr ");
			sb.append("	                WHERE rm.marca_produto = mp.codigo_marca ");
			sb.append("	                  AND r.rep_cdgo = rm.codigo_representante ");
			sb.append("	                  AND cr.codigo_representante = r.rep_cdgo ");
			sb.append("	                  AND r.rep_cdgo = NVL(").append(representante).append(", r.rep_cdgo) ");
			sb.append("	                  AND r.codigo_regional = NVL(").append(regional).append(", r.codigo_regional) ");
			sb.append("	                  AND cr.codigo_cliente = NVL(").append(cliente).append(", cr.codigo_cliente) ");
			sb.append("	                  AND cr.situacao = 'A' ");
			sb.append("	                  AND rm.situacao = 'A') ");
			String existe = query.retorna(sb.toString());
			if (existe.equals("1")) {
				retorno = true;
			} else {
				retorno = false;
			}
		} catch (Exception e) {
			retorno = false;
		}
		return retorno;

	}
}
