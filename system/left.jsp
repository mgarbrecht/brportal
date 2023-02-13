<%
 com.egen.util.jdbc.JdbcUtil ja = null;
 try {
    ja = new com.egen.util.jdbc.JdbcUtil("root","web80br",util.rdb.ConnectionJDBC.getJdbcURL("loja"),util.rdb.ConnectionJDBC.getJdbcDriver("loja"));
%>
<link rel="stylesheet" href="../style.css" type="text/css">    
<table style="width:100%;" border=1 class="tableLoja"  >
  <tr valign="top" >
    <td WIDTH="16%" >

  <table class="tableLoja" width="100%">
         <tr>
      <td class="subbannerTd">
        Categoria
      </td>
      </tr>
  </table>
  <table id="TRbl_report_Jw_categorias" class="tableloja" style="width:100%;" valign="top">

 <%
  int counterbl_report_Jw_categorias=0;
  
  {
    portalbr.dbobj.view.Jw_categorias t_jw_categorias = new portalbr.dbobj.view.Jw_categorias();
    java.util.Vector res_Jw_categorias = null;
    try {
      String[][] select =  null;
      Object[][] where = null;
      String[] groupby =  null;
      String[] having =  null;
      String[] order = {};
      res_Jw_categorias = ja.select(t_jw_categorias,select,where,groupby,having,order);
    } catch (Exception e){
      session.setAttribute("exception",com.egen.util.system.Error.getDescription(e));
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
    descricao += "("+numero+")";
    while (i_bl_report_Jw_categorias<res_Jw_categorias.size()){
      counterbl_report_Jw_categorias++;
      String style="";
      if (!((i_bl_report_Jw_categorias%2)!=0)) {
        style="rowColor";
      } else {
        style="rowBlank";
      }
      %>
      <tr class=<%= style %> id='TRbl_report_Jw_categorias<%=counterbl_report_Jw_categorias%>' onMouseOver='this.className="highLightRow"' onMouseOut='this.className="<%=style%>"' onClick='this.className="clickRow"'  >
        <td class="reportColumn" style="text-align:left;">
          <a href="../loja/CatalogoForm.do?select_action=&codigo_grupo=<%= codigo_grupo %>">
          <%= descricao %>
          </a>
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
      descricao += "("+numero+")";
    }
  }
}
%>

</table>
  <table class="messageTable" width="100%">
         <tr>
      <td class="subbannerTd">
        Marca
      </td>
      </tr>
  </table>
<table>
<tr><td align="center"> 
<br> 
<%
    try {
      portalbr.dbobj.view.Jw_produtos_detalhes db_object = new portalbr.dbobj.view.Jw_produtos_detalhes();
      java.util.Vector results = ja.select(db_object, 
      "  SELECT distinct mar.codigo_marca, mar.descricao_marca "+
      " FROM ref, cor,cabedal cab, lin, grupo_posicao_fabrica gpf, marcas_produtos mar,  "+
      " dom_local_item_estoque dlie, dom_item_estoque die,  "+
      " (select substr(min(preco_mercado_interno) * 100,  1,  "+
      "               length(min(preco_mercado_interno) * 100) - 2) || '.' ||  "+
      "        substr(min(preco_mercado_interno) * 100,  "+
      "               length(min(preco_mercado_interno) * 100) - 1, 2) preco,  "+
      "        t.lin_cdgo, t.ref_cdgo  "+
      "   FROM tabela_precos t  "+
      "  WHERE t.liv_codigo = 28  "+
      "  GROUP BY t.lin_cdgo, t.ref_cdgo) tabela  "+
      " WHERE mar.codigo_marca = ref.codigo_marca  "+
      " AND gpf.codigo_grupo = ref.ref_grupo_posicao_fab  "+
      " AND tabela.lin_cdgo(+) = substr(dlie.ies_codigo, 1, 3)  "+
      " AND tabela.ref_cdgo(+) = substr(dlie.ies_codigo, 4, 3)  "+
      " AND ref.lin_cdgo = substr(dlie.ies_codigo, 1, 3)  "+
      " AND ref.ref_cdgo = substr(dlie.ies_codigo, 4, 3)  "+
      " AND dlie.qtde_atual > 0  "+
      " AND dlie.tes_codigo = 49  "+
      " AND les_codigo = 32  "+
      " AND die.lin_cdgo = substr(dlie.ies_codigo, 1, 3)  "+
      " and die.ref_cdgo = substr(dlie.ies_codigo, 4, 3)  "+
      " and die.cab_cdgo = substr(lpad(dlie.ies_codigo, 9, '0'), 7, 3)  "+
      " and die.cab_cdgo = cab.cab_cdgo  "+
      " and lin.lin_cdgo = die.lin_cdgo  "+
      " and dlie.cor_cdgo = cor.cor_cdgo  "+
      " AND tabela.lin_cdgo(+) = substr(dlie.ies_codigo, 1, 3)  "+
      " AND tabela.ref_cdgo(+) = substr(dlie.ies_codigo, 4, 3)  "+
      " GROUP BY die.lin_cdgo, lin_nome, die.ref_cdgo,  die.cab_cdgo, cab.cab_desc,  ref.ref_desc,  "+
      "         gpf.codigo_grupo,  gpf.descricao_grupo,  "+
      "         lpad(substr(dlie.ies_codigo, 1, 3), 3, '0') || '-' ||  "+
      "         lpad(substr(dlie.ies_codigo, 4, 3), 3, '0') || '.jpg', "+
      "         mar.codigo_marca, mar.descricao_marca, tabela.preco order by 2 ", null);
        
      %>
          <tr align="center">
              <td align="center">
                <select styleClass="baseField" size="1" onchange="top.location='../loja/CatalogoForm.do?select_action=&codigo_marca='+this.value;" >
                <option styleClass="baseOption" value="">---Selecione---</option>
      
      <%
      for (int i = 0; i < results.size(); i++) {
        db_object = (portalbr.dbobj.view.Jw_produtos_detalhes) results.elementAt(i);
        %>
          <option styleClass="baseOption" value="<%= db_object.getCodigo_marca() %>"><%= db_object.getDescricao_marca() %></option>
        <%
      }
      %>
                </select>
                <tr><td><br><br></td></tr>
            </td>
</tr>
      <%
    } catch (Exception e) {
    } 
    
    
    
 
    portalbr.dbobj.view.Jw_produtos t_jw_produtos = new portalbr.dbobj.view.Jw_produtos();
    java.util.Vector res_Jw_produtos = null;
    try {
      String[][] select =  null;
      Object[][] where = null;
      String[] groupby =  null;
      String[] having =  null;
      String[] order = {};
      res_Jw_produtos = ja.select(t_jw_produtos,select,where,groupby,having,order);
      java.util.Random rand = new java.util.Random();
      t_jw_produtos = (portalbr.dbobj.view.Jw_produtos)res_Jw_produtos.elementAt(rand.nextInt(res_Jw_produtos.size()));
      %>
      <tr>
      <td class="subbannerTd">
        Novidades
      </td>
      </tr>
      <tr>
         <td align="center">
            <br>
            <a href="../loja/ProdutoGrid.do?select_action=&lin_cdgo=<%= t_jw_produtos.getLin_cdgo() %>&ref_cdgo=<%= t_jw_produtos.getRef_cdgo() %>">
            <img src="../Imagens/<%= t_jw_produtos.getFit_imagem()==null?"":t_jw_produtos.getFit_imagem() %>" width=120 height=82 border=0 ></a>
            <br>
            <%= t_jw_produtos.getLin_cdgo() + "."+t_jw_produtos.getRef_cdgo() +"-"+t_jw_produtos.getRef_desc() %><br>
            R$ <%= t_jw_produtos.getPreco() %>
         </td>
      </tr>
      <%
    } catch (Exception e){
      session.setAttribute("exception",com.egen.util.system.Error.getDescription(e));
     
    } 
%>     
</td>
</tr>
</table>  

 
<table class="messageTable" width="100%">
         <tr>
      <td class="subbannerTd">
        Busca Rápida
      </td>
      </tr>
  </table>
<table width="100%">    
<tr align="center">
      <td align="center">
              <br>
              <input type="text" size=12 styleClass="baseField"/>
              <img src="../img/viewmag.png" onmouseover="this.src='../img/viewmag_s.png'" onmouseout="this.src='../img/viewmag.png'"  style="cursor:hand" onclick="window.open('PedidosSituacoesForm.do?select_action=&pedido_beira_rio='+document.forms[0].ped_beira_rio.value,'_self')"/>
              <br>
        Use palavras-chave<br>
        para encontrar o<br>
        produto que procura.
            </td>
          </tr>
<tr>
<td align="center">
<br>
<a href="../loja/BuscaAvancadaForm.jsp">
Busca Avançada
</a>
</td>
</tr>
</table>

<table class="messageTable" width="100%">
   <tr>
      <td class="subbannerTd">
         Informações
      </td>
   </tr>
   <tr align="center">
      <td>
         <br>
         <a href="../loja/EnvioDevolucaoForm.jsp">Envios e Devoluções</a>
         <br><br>
         <a href="../loja/FaleConoscoForm.jsp">Fale Conosco!</a>
      </td>
   </tr>      
</table>
   

           
                
<%
   } catch (Exception e){
     }   finally {
           if(ja!=null ){ja.close();}
        }
%>
