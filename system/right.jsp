</td>
<td width="15%" >
    <link rel=stylesheet href=../styleloja.css type=text/css>
<table class="tableloja" width="99%" border=0>
      <tr>
      <td class="subbannerTd">
        Carrinho
      </td>
      </tr>
      <tr>
         <td>
         730.100 - TENIS FEMININO<br>1 par
         </td>
      </tr>
            <tr>
         <td>
         211.100 - SAPATO FEMININO<br>2 pares
         </td>
      </tr>
            <tr>
         <td>
         411.200 - SANDALIA FEMININA<br>1 par
         </td>
      </tr>
            <tr>
         <td>
         515.300 - SAPATILHA INFANTIL<br>5 pares
         </td>
      </tr>
</table>  
<table class="tableloja" width="99%" border=0>
      <tr>
      <td class="subbannerTd">
        Compras
      </td>
      </tr>
</table>      
<table id="TRbl_report_Jw_categorias" class="tableLoja" width="99%">
  <%
  int counterbl_report_Jw_categorias=0;
  %>
  <%
  {
    portalbr.dbobj.view.Jw_categorias t_jw_categorias = new portalbr.dbobj.view.Jw_categorias();
    java.util.Vector res_Jw_categorias = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      String[][] select =  null;
      Object[][] where = null;
      String[] groupby =  null;
      String[] having =  null;
      String[] order = {};
      res_Jw_categorias = j.select(t_jw_categorias,select,where,groupby,having,order);
    } catch (Exception e){
      session.setAttribute("exception",com.egen.util.system.Error.getDescription(e));
      %>
      <jsp:forward page="/system/ErrorPage.jsp"/>
      <%
    } finally {
    if(j!=null){j.close();}
  }
  if (res_Jw_categorias!=null && res_Jw_categorias.size()>0) {
    java.lang.Integer codigo_grupo =  null;
    java.lang.String descricao =  null;
    java.lang.Integer numero =  null;
    int i_bl_report_Jw_categorias = 0;
    t_jw_categorias = (portalbr.dbobj.view.Jw_categorias)res_Jw_categorias.elementAt(i_bl_report_Jw_categorias);
    codigo_grupo = t_jw_categorias.getCodigo_grupo();
    descricao = t_jw_categorias.getDescricao()==null?"":t_jw_categorias.getDescricao();
    numero = t_jw_categorias.getNumero();
    %>
    <tr class="reportHeader" >
      <td class="columnTdHeader" style="text-align:left;">
        descricao
      </td>
    </tr>
    <%
    while (i_bl_report_Jw_categorias<res_Jw_categorias.size()){
      counterbl_report_Jw_categorias++;
      String style="";
      if (!((i_bl_report_Jw_categorias%2)!=0)) {
        style="class=rowColor";
      } else {
        style="class=rowBlank";
      }
      %>
      <tr <%= style %> id='TRbl_report_Jw_categorias<%=counterbl_report_Jw_categorias%>' >
        <td class="reportColumn" style="text-align:left;">
          <%= descricao %>
        </td>
     
      </tr>
      <%
      if (++i_bl_report_Jw_categorias >= res_Jw_categorias.size()) {
        break;
      }
      t_jw_categorias = (portalbr.dbobj.view.Jw_categorias)res_Jw_categorias.elementAt(i_bl_report_Jw_categorias);
      codigo_grupo = t_jw_categorias.getCodigo_grupo();
      descricao = t_jw_categorias.getDescricao()==null?"":t_jw_categorias.getDescricao();
      numero = t_jw_categorias.getNumero();
    }
  }
}
%>
</table>
</td>
</tr>

