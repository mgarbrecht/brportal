<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Relatório de Normas de Venda
    </title>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:99%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <table class="headerTable" style="width:99%" >
              <tr>

                <td class="td10">
                  <%@ include file="../system/header.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(9999)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <%
            {
              com.egen.util.jdbc.JdbcUtil j = null;
              try
              {
                j = new com.egen.util.jdbc.JdbcUtil("loja","loja","jdbc:oracle:thin:@10.0.0.30:1521:orasco","oracle.jdbc.driver.OracleDriver");
                util.consultas.Query query = new util.consultas.Query();
                %>

                <%
                java.util.Vector res_Jw_relatorio_normas = null;
                portalbr.com.RelatorioNormasVenda_cActionForm RelatorioNormasVenda_cActionForm = (portalbr.com.RelatorioNormasVenda_cActionForm)session.getAttribute("RelatorioNormasVenda_cActionForm");
                if(true){
                  portalbr.dbobj.view.Jw_relatorio_normas t_jw_relatorio_normas = new portalbr.dbobj.view.Jw_relatorio_normas();
                  String[][] select = {{"codigo_marca",null},{"descricao_marca",null},{"lin_cdgo",null},{"lin_nome",null},};
                  Object[][] where = null;
                  where = new Object[][]{{"lin_cdgo","=",RelatorioNormasVenda_cActionForm.getLin_cdgo()},{"codigo_marca","=",RelatorioNormasVenda_cActionForm.getCodigo_marca()}};
                  String[] groupby =  null;
                  String[] having =  null;
                  String[] order = {"codigo_marca","lin_cdgo"};
                  res_Jw_relatorio_normas = j.select(t_jw_relatorio_normas,select,where,groupby,having,order);
                } else {
                  res_Jw_relatorio_normas = null;
                }
                %>

                <form  name="bl_report_Jw_relatorio_normas" id="bl_report_Jw_relatorio_normas" class="baseForm" method="post" >

                  <%
                  if (res_Jw_relatorio_normas!=null && res_Jw_relatorio_normas.size()>0) {
                    %>
                    <img src="../img/normas_beira_rio.jpg">
                    <table id="TRbl_report_Jw_relatorio_normas"  class="reportTable"   style="width:99%;" table="1"  >
                      <%
                      int codigo_marca =  0;
                      java.lang.String descricao_marca =  null;
                      int lin_cdgo =  0;
                      java.lang.String lin_nome =  null;
                      String _b0_control = "__";
                      int i_bl_report_Jw_relatorio_normas = 0;
                      while (i_bl_report_Jw_relatorio_normas<res_Jw_relatorio_normas.size()) {
                        portalbr.dbobj.view.Jw_relatorio_normas t_jw_relatorio_normas = (portalbr.dbobj.view.Jw_relatorio_normas)res_Jw_relatorio_normas.elementAt(i_bl_report_Jw_relatorio_normas);
                        codigo_marca = t_jw_relatorio_normas.getCodigo_marca();
                        descricao_marca = t_jw_relatorio_normas.getDescricao_marca()==null?"":t_jw_relatorio_normas.getDescricao_marca();
                        lin_cdgo = t_jw_relatorio_normas.getLin_cdgo();
                        lin_nome = t_jw_relatorio_normas.getLin_nome()==null?"":t_jw_relatorio_normas.getLin_nome();
                        String _b0_value = com.egen.util.text.FormatNumber.format(codigo_marca);
                        if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                          %>
                          <tr class="reportHeader">
                            <td colspan="1">
                              <span class="columnTdHeader" style="text-align:right;" >
                                Marca :
                                <%= codigo_marca %>
                                -
                                <%= descricao_marca %>
                              </span>
                            </td>
                          </tr>
                          <%
                          %>
                          <!--
                            <tr class="reportTr"> <td class="columnTdHeader" style="text-align:left;" > Linha </td> </tr>
                          -->

                          <%
                        }
                        String style_bl_report_Jw_relatorio_normas="";
                        if (!((i_bl_report_Jw_relatorio_normas%2)!=0)) {
                          style_bl_report_Jw_relatorio_normas="rowColor";
                        } else {
                          style_bl_report_Jw_relatorio_normas="rowBlank";
                        }
                        %>

                        <tr class='<%= style_bl_report_Jw_relatorio_normas %>' id="TRbl_report_Jw_relatorio_normas<%=i_bl_report_Jw_relatorio_normas%>" >
                          <td class="reportColumn" style="text-align:left;" >
                            Linha :
                            <%= lin_cdgo %>
                            -
                            <%= lin_nome %>
                          </td>
                        </tr>

                        <tr>
                          <td>
                            <table border=1 width="100%">
                              <tr class="reportHeader2">
                                <%
                                java.sql.ResultSet rset = null;
                                java.sql.PreparedStatement pstm = null;
                                try {
                                  StringBuilder sb = new StringBuilder();
                                  sb.append(" SELECT DISTINCT  ");
                                  sb.append("        nvtc.descricao ");
                                  sb.append("      , li.id_coluna_material ");
                                  sb.append("   FROM nv_linha_materiais li ");
                                  sb.append("      , nv_coluna_materiais col ");
                                  sb.append("      , nv_item_norma_venda it ");
                                  sb.append("      , nv_norma_venda nv ");
                                  sb.append("      , nv_tipo_colunas nvtc ");
                                  sb.append("  WHERE li.id_coluna_material = col.id_coluna_material ");
                                  sb.append("    AND li.item_id = col.item_id ");
                                  sb.append("    AND li.id_norma_venda = col.id_norma_venda ");
                                  sb.append("    AND col.item_id = it.item_id ");
                                  sb.append("    AND col.id_norma_venda = it.id_norma_venda ");
                                  sb.append("    AND it.id_norma_venda = nv.id ");
                                  sb.append("    AND nvtc.id = col.id_tipos_colunas ");
                                  sb.append("    AND nv.codigo_marca = ? ");
                                  sb.append("    AND nv.lin_cdgo = ? ");
                                  sb.append("  ORDER BY id_coluna_material ");
                                  pstm = j.getConn().prepareStatement(sb.toString());
                                  pstm.setInt(1,codigo_marca);
                                  pstm.setInt(2,lin_cdgo);
                                  rset = pstm.executeQuery();
                                  while(rset.next()) {
                                    %>
                                    <td>
                                      <%= rset.getString(1) %>
                                    </td>
                                    <%
                                  }
                                } finally {
                                  if(rset!=null){
                                    rset.close();
                                  }
                                  if(pstm!=null){
                                    pstm.close();
                                  }
                                }
                                %>
                              </tr>

                              <%
                              String[] colunas = null;
                              String[] linhas = null;
                              try {
                                colunas = query.retorna(j,"SELECT brio.rowtocol ('SELECT DISTINCT li.id_coluna_material FROM nv_linha_materiais li, nv_coluna_materiais col, nv_item_norma_venda it , nv_norma_venda nv   , nv_tipo_colunas nvtc WHERE li.id_coluna_material = col.id_coluna_material   AND li.item_id = col.item_id   AND li.id_norma_venda = col.id_norma_venda   AND col.item_id = it.item_id   AND col.id_norma_venda = it.id_norma_venda   AND it.id_norma_venda = nv.id   AND nvtc.id = col.id_tipos_colunas   AND nv.codigo_marca = "+codigo_marca+"   AND nv.lin_cdgo = "+lin_cdgo+" order by 1 ') FROM dual").split(",");
                                linhas  = query.retorna(j,"SELECT brio.rowtocol ('SELECT DISTINCT li.seq_item FROM nv_linha_materiais li, nv_coluna_materiais col, nv_item_norma_venda it , nv_norma_venda nv   , nv_tipo_colunas nvtc WHERE li.id_coluna_material = col.id_coluna_material   AND li.item_id = col.item_id   AND li.id_norma_venda = col.id_norma_venda   AND col.item_id = it.item_id   AND col.id_norma_venda = it.id_norma_venda   AND it.id_norma_venda = nv.id   AND nvtc.id = col.id_tipos_colunas   AND nv.codigo_marca = "+codigo_marca+"   AND nv.lin_cdgo = "+lin_cdgo+" order by 1 ') FROM dual").split(",");
                                for(int y=0;y<linhas.length;y++){
                                  %>
                                  <tr>
                                    <%
                                    for(int x=0;x<colunas.length;x++){
                                      String t = query.retorna(j,"SELECT nvl(replace(rowtocol('SELECT NVL(li.descr_material, li.cor_cdgo || ''-'' || pck_cor.get_nome(li.cor_cdgo))  FROM nv_linha_materiais li, nv_coluna_materiais col, nv_item_norma_venda it , nv_norma_venda nv   , nv_tipo_colunas nvtc WHERE li.id_coluna_material = col.id_coluna_material   AND li.item_id = col.item_id   AND li.id_norma_venda = col.id_norma_venda   AND col.item_id = it.item_id   AND col.id_norma_venda = it.id_norma_venda   AND it.id_norma_venda = nv.id   AND nvtc.id = col.id_tipos_colunas   AND nv.codigo_marca = "+codigo_marca+"   AND nv.lin_cdgo = "+lin_cdgo+"    AND li.seq_item = "+linhas[y]+"   AND li.id_coluna_material = "+colunas[x]+" '),',','<br>'),'') FROM dual");
                                      %>
                                      <td>
                                        <%= t.equals("null")?"":t %>
                                      </td>
                                      <%
                                    }
                                    %>
                                  </tr>
                                  <%
                                }
                              }  catch (java.sql.SQLException e) {
                                e.printStackTrace();
                              }
                              %>



                            </table>
                          </td>
                        </tr>


                        <tr>
                          <td>
                            xxxx
                          </td>
                        </tr>

                        <%
                        _b0_control = _b0_value;
                        i_bl_report_Jw_relatorio_normas++;
                        if (i_bl_report_Jw_relatorio_normas<res_Jw_relatorio_normas.size()) {
                          t_jw_relatorio_normas = (portalbr.dbobj.view.Jw_relatorio_normas)res_Jw_relatorio_normas.elementAt(i_bl_report_Jw_relatorio_normas);
                          codigo_marca = t_jw_relatorio_normas.getCodigo_marca();
                          descricao_marca = t_jw_relatorio_normas.getDescricao_marca()==null?"":t_jw_relatorio_normas.getDescricao_marca();
                          lin_cdgo = t_jw_relatorio_normas.getLin_cdgo();
                          lin_nome = t_jw_relatorio_normas.getLin_nome()==null?"":t_jw_relatorio_normas.getLin_nome();
                          _b0_value = com.egen.util.text.FormatNumber.format(codigo_marca);
                        } else {
                          _b0_control = "__";
                        }
                      }
                      %>

                    </table>

                    <%
                  }
                  %>

                </form>
                <%
              } finally {
              if(j!=null){j.close();}
            }
          }
          %>

          <html:form action="com/RelatorioNormasVenda_cForm.do" method="post" styleClass="baseForm">

            <table class="itemTable"  style="width:99%;">
              <html:hidden property="lin_cdgo"/>
              <html:hidden property="codigo_marca"/>
            </table>

            <table class="buttonTable" style='width:99%;'>
              <tr class="buttonTr">
                <td class="buttonTd">
                  <html:submit accesskey="p" styleClass="myhidden" property="select_action">
                    <bean:message bundle="ApplicationResources" key="jsp.select"/>
                  </html:submit>
                  <html:submit accesskey="a" styleClass="baseButton" property="back_action">
                    <bean:message bundle="ApplicationResources" key="jsp.back"/>
                  </html:submit>
                </td>
              </tr>
            </table>

          </html:form>
        </td>
      </tr>
    </table>

  </body>
</center>
</html>
