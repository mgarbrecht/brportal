<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<!DOCTYPE HTML PUBLIC ' - //W3C//DTD HTML 3.2//EN'>
<link rel=stylesheet href="../style.css" type=text/css>
<html>
<title>Ajuda</title>
<table border=1 width="100%">
<tr align="center">
<td>
<h2>Ajuda</h2>
</td>
</tr>
<tr align="center">
<td>

<%
     String tipo="";
     acesso.Usuario u = new acesso.Usuario();
     u = (acesso.Usuario)session.getAttribute("User");
     acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
     acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();

     if(!(u.getEntidadeNegocio()==null)){
          ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();
          tipoent = (acesso.TipoEntidadeNegocio) ent.getTipoEntidadeNegocio();
          tipo = tipoent.getTipo()+"";
          if(tipo.equals("REGIONAL DE VENDA")){
              %><img src='../imagens-help/ConsultaPedidosForaNormas.PNG' /><%
          }
          if(tipo.equals("REPRESENTANTE COMERCIAL")){
              %><img src='../imagens-help/ConsultaPedidosForaNormas_rep.PNG' /><%          
          }
          

     }else{
              %><img src='../imagens-help/ConsultaPedidosForaNormas.PNG' /><%
          }
%>

</td>
</tr>
</table>
<table width="100%">
<tr align="center">
<td>
<input type="button" value="Fechar" onclick="window.close();">
</td>
</tr>
</table>
</html>
