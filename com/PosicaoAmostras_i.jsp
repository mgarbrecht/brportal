<script type="text/javascript" src="../script/jquery-1.4.2.min.js"></script>  
<script>$.noConflict();</script> 
<%
util.consultas.Query.execute("UPDATE brio.ped_amostra_situacoes_estagios s SET observacao = '"+(String)request.getParameter("newvalue")+"' WHERE ped_nmro = "+(String)request.getParameter("elementid")+" AND estagio = (SELECT max(estagio) FROM brio.ped_amostra_situacoes_estagios e WHERE e.ped_nmro = s.ped_nmro)");
%>
<script>
jQuery("#"+'<%= request.getParameter("elementid")%>').hide();
jQuery("#"+'<%= request.getParameter("elementid")%>hidden').removeClass('myhidden');
jQuery("#"+'<%= request.getParameter("elementid")%>hidden').html('<%= request.getParameter("newvalue") %>');
alert('Observação salva com sucesso!');
</script>
<%= request.getParameter("newvalue") %>
