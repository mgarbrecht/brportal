<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      PLUS Produtos - Dados do Produto
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
                  <%@ include file="../system/header_sem_ajuda.jsp" %>
                </td>

              </tr>

            </table>

            <table id="TRbl_report_Jw_linha_ref" class="reportTable" style=width:99%;  border=1  frame=box>
              <%
              int counterbl_report_Jw_linha_ref=0;
              {
                portalbr.dbobj.view.Jw_linha_ref t_jw_linha_ref = new portalbr.dbobj.view.Jw_linha_ref();
                java.util.Vector res_Jw_linha_ref = (java.util.Vector)session.getAttribute("res_Jw_linha_ref");
                if (res_Jw_linha_ref!=null && res_Jw_linha_ref.size()>0) {
                  java.lang.String referencia =  null;
                  java.lang.String lin_cdgo =  null;
                  java.lang.String ref_cdgo =  null;
                  java.lang.String descricao =  null;
                  java.lang.String status =  null;
                  java.lang.String cod_filial =  null;
                  int i_bl_report_Jw_linha_ref = 0;
                  t_jw_linha_ref = (portalbr.dbobj.view.Jw_linha_ref)res_Jw_linha_ref.elementAt(i_bl_report_Jw_linha_ref);
                  referencia = t_jw_linha_ref.getReferencia()==null?"":t_jw_linha_ref.getReferencia();
                  lin_cdgo = t_jw_linha_ref.getLin_cdgo()==null?"":t_jw_linha_ref.getLin_cdgo();
                  ref_cdgo = t_jw_linha_ref.getRef_cdgo()==null?"":t_jw_linha_ref.getRef_cdgo();
                  descricao = t_jw_linha_ref.getDescricao()==null?"":t_jw_linha_ref.getDescricao();
                  status = t_jw_linha_ref.getStatus()==null?"":t_jw_linha_ref.getStatus();
                  cod_filial = t_jw_linha_ref.getCod_filial()==null?"":t_jw_linha_ref.getCod_filial();
                  %>
                  <tr class="reportHeader" >
                    <td class="columnTdHeader" style="text-align:left;">
                      Referência
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Descrição
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Status
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Filial
                    </td>
                  </tr>
                  <%
                  while (i_bl_report_Jw_linha_ref<res_Jw_linha_ref.size()){
                    counterbl_report_Jw_linha_ref++;
                    String style="";
                    if (!((i_bl_report_Jw_linha_ref%2)!=0)) {
                      style="rowColor";
                    } else {
                      style="rowBlank";
                    }
                    %>
                    <tr class=<%= style %> id='TRbl_report_Jw_linha_ref<%=counterbl_report_Jw_linha_ref%>' >
                      <td class="reportColumn" style="text-align:left;">
                        <a href="../com/PlusProdutosDadosForm.do?select_action=&lin_cdgo=<%= lin_cdgo %>&ref_cdgo=<%= ref_cdgo %>" target="_self" STYLE="cursor:hand" onclick="bloqueia();">
                          <%= referencia %>
                        </a>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <%= descricao %>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <%= status %>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <%= cod_filial %>
                      </td>
                    </tr>
                    <%
                    if (++i_bl_report_Jw_linha_ref >= res_Jw_linha_ref.size()) {
                      break;
                    }
                    t_jw_linha_ref = (portalbr.dbobj.view.Jw_linha_ref)res_Jw_linha_ref.elementAt(i_bl_report_Jw_linha_ref);
                    referencia = t_jw_linha_ref.getReferencia()==null?"":t_jw_linha_ref.getReferencia();
                    lin_cdgo = t_jw_linha_ref.getLin_cdgo()==null?"":t_jw_linha_ref.getLin_cdgo();
                    ref_cdgo = t_jw_linha_ref.getRef_cdgo()==null?"":t_jw_linha_ref.getRef_cdgo();
                    descricao = t_jw_linha_ref.getDescricao()==null?"":t_jw_linha_ref.getDescricao();
                    status = t_jw_linha_ref.getStatus()==null?"":t_jw_linha_ref.getStatus();
                    cod_filial = t_jw_linha_ref.getCod_filial()==null?"":t_jw_linha_ref.getCod_filial();
                  }
                }
              }
              %>
            </table>
            <html:form action="com/PlusProdutos_refForm.do" method="post" styleClass="baseForm">
              <table class="itemTable"  style=" width:;">
                <html:hidden property="lin_cdgo"/>
                <table class="buttonTable" style='width:99%;'>
                  <tr class="buttonTr">
                    <td class="buttonTd">
                      <html:submit accesskey="s" styleClass="myhidden" property="select_action">
                        <bean:message bundle="ApplicationResources" key="jsp.select"/>
                      </html:submit>
                      <html:button accesskey="b" onclick="history.go(-1);" styleClass="baseButton" property="back_action">
                        <bean:message bundle="ApplicationResources" key="jsp.back"/>
                      </html:button>
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
