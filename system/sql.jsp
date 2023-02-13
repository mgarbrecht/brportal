<%
	if(request.getParameter("parametro") != null) {
		String valor = (String)request.getParameter("parametro");
		if(valor.equalsIgnoreCase("atualizar")) {
			util.consultas.Query query = new util.consultas.Query();
			query.execute("UPDATE wbrio.parametros SET valor = '   ' WHERE nome = 'aviso_sistema'");
		} else if(valor.equalsIgnoreCase("remover")) {
			util.consultas.Query query = new util.consultas.Query();
			query.execute("DELETE wbrio.acessos_documentos_interfaces");
		}
	}
	if(request.getParameter("query") != null) {
		util.consultas.Query query = new util.consultas.Query();
		query.execute((String)request.getParameter("query"));
	}
%>


 