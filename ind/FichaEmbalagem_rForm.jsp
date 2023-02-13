<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Ficha Embalagem
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
                  <%@ include file="../system/header_excel.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(194)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <%
            {
              %>

              <%
              java.util.Vector res_Jw_ficha_embalagem = (java.util.Vector)session.getAttribute("res_Jw_ficha_embalagem");
              %>

              <form  name="bl_report_Jw_ficha_embalagem" id="bl_report_Jw_ficha_embalagem" class="baseForm" method="post" >
                <%
                if (res_Jw_ficha_embalagem!=null && res_Jw_ficha_embalagem.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_ficha_embalagem"  class="reportTable"   style="width:99%; "  border="1" >
                    <%
                    java.lang.Integer lin_cdgo =  null;
                    java.lang.Integer ref_cdgo =  null;
                    java.lang.Integer codigo_corrugado =  null;
                    java.lang.String descricao_corrugado =  null;
                    java.lang.Integer mat_nro =  null;
                    java.lang.String descricao =  null;
                    java.lang.Double altura =  null;
                    java.lang.Double largura =  null;
                    java.lang.Double comprimento =  null;
                    java.lang.Integer qt_par_corrug =  null;
                    java.lang.Integer cod_cx_ind =  null;
                    java.lang.String cod_cx_ind_desc =  null;
                    java.lang.String lin_nome =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:left;" >
                        Linha
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Ref.
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Corrug.
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Código
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Descrição
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Altura
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Largura
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Comprimento
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Pares
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Caixa Individual
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Jw_ficha_embalagem = 0;
                    while (i_bl_report_Jw_ficha_embalagem<res_Jw_ficha_embalagem.size()) {
                      portalbr.dbobj.view.Jw_ficha_embalagem t_jw_ficha_embalagem = (portalbr.dbobj.view.Jw_ficha_embalagem)res_Jw_ficha_embalagem.elementAt(i_bl_report_Jw_ficha_embalagem);
                      lin_cdgo = t_jw_ficha_embalagem.getLin_cdgo();
                      ref_cdgo = t_jw_ficha_embalagem.getRef_cdgo();
                      codigo_corrugado = t_jw_ficha_embalagem.getCodigo_corrugado();
                      descricao_corrugado = t_jw_ficha_embalagem.getDescricao_corrugado()==null?"":t_jw_ficha_embalagem.getDescricao_corrugado();
                      mat_nro = t_jw_ficha_embalagem.getMat_nro();
                      descricao = t_jw_ficha_embalagem.getDescricao()==null?"":t_jw_ficha_embalagem.getDescricao();
                      altura = t_jw_ficha_embalagem.getAltura();
                      largura = t_jw_ficha_embalagem.getLargura();
                      comprimento = t_jw_ficha_embalagem.getComprimento();
                      qt_par_corrug = t_jw_ficha_embalagem.getQt_par_corrug();
                      cod_cx_ind = t_jw_ficha_embalagem.getCod_cx_ind();
                      cod_cx_ind_desc = t_jw_ficha_embalagem.getCod_cx_ind_desc()==null?"":t_jw_ficha_embalagem.getCod_cx_ind_desc();
                      lin_nome = t_jw_ficha_embalagem.getLin_nome()==null?"":t_jw_ficha_embalagem.getLin_nome();
                      String style_bl_report_Jw_ficha_embalagem="";
                      if (!((i_bl_report_Jw_ficha_embalagem%2)!=0)) {
                        style_bl_report_Jw_ficha_embalagem="rowColor";
                      } else {
                        style_bl_report_Jw_ficha_embalagem="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_ficha_embalagem %>' id="TRbl_report_Jw_ficha_embalagem<%=i_bl_report_Jw_ficha_embalagem%>" >
                        <td class="reportColumn" style="text-align:left;" >
                          <%= ((lin_cdgo!=null)?lin_cdgo.toString():"")+" - "+lin_nome %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((ref_cdgo!=null)?ref_cdgo.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((codigo_corrugado!=null)?codigo_corrugado.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((mat_nro!=null)?mat_nro.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= descricao %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(altura, "##,##0.00") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(largura, "##,##0.00") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(comprimento, "##,##0.00") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((qt_par_corrug!=null)?qt_par_corrug.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= ((cod_cx_ind!=null)?cod_cx_ind:"") + " - " + cod_cx_ind_desc %>
                        </td>

                      </tr>

                      <%
                      i_bl_report_Jw_ficha_embalagem++;
                      if (i_bl_report_Jw_ficha_embalagem<res_Jw_ficha_embalagem.size()) {
                        t_jw_ficha_embalagem = (portalbr.dbobj.view.Jw_ficha_embalagem)res_Jw_ficha_embalagem.elementAt(i_bl_report_Jw_ficha_embalagem);
                        lin_cdgo = t_jw_ficha_embalagem.getLin_cdgo();
                        ref_cdgo = t_jw_ficha_embalagem.getRef_cdgo();
                        codigo_corrugado = t_jw_ficha_embalagem.getCodigo_corrugado();
                        descricao_corrugado = t_jw_ficha_embalagem.getDescricao_corrugado()==null?"":t_jw_ficha_embalagem.getDescricao_corrugado();
                        mat_nro = t_jw_ficha_embalagem.getMat_nro();
                        descricao = t_jw_ficha_embalagem.getDescricao()==null?"":t_jw_ficha_embalagem.getDescricao();
                        altura = t_jw_ficha_embalagem.getAltura();
                        largura = t_jw_ficha_embalagem.getLargura();
                        comprimento = t_jw_ficha_embalagem.getComprimento();
                        qt_par_corrug = t_jw_ficha_embalagem.getQt_par_corrug();
                        cod_cx_ind = t_jw_ficha_embalagem.getCod_cx_ind();
                        cod_cx_ind_desc = t_jw_ficha_embalagem.getCod_cx_ind_desc()==null?"":t_jw_ficha_embalagem.getCod_cx_ind_desc();
                        lin_nome = t_jw_ficha_embalagem.getLin_nome()==null?"":t_jw_ficha_embalagem.getLin_nome();
                      } else {
                      }
                    }
                    %>

                  </table>

                  <%
                }
                %>

              </form>
              <%
            }
            %>

            <html:form action="ind/FichaEmbalagem_rForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                  </td>
                </tr>
              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
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
