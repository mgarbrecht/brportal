<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Limite de Crédito Disponível
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
                </td>

              </tr>

            </table>

            <table id="TRbl_report_Jw_limite_credito_disponivel" class="reportTable" style=width:99%;  border=1  frame=box>
              <%
              int counterbl_report_Jw_limite_credito_disponivel=0;
              {
                portalbr.dbobj.view.Jw_limite_credito_disponivel t_jw_limite_credito_disponivel = new portalbr.dbobj.view.Jw_limite_credito_disponivel();
                java.util.Vector res_Jw_limite_credito_disponivel = (java.util.Vector)session.getAttribute("res_Jw_limite_credito_disponivel");
                //  res_Jw_limite_credito_disponivel = com.egen.util.text.Sort.execute(res_Jw_limite_credito_disponivel,"valor_saldo",true);
                if (res_Jw_limite_credito_disponivel!=null && res_Jw_limite_credito_disponivel.size()>0) {
                  java.lang.String rep_cdgo        =  null;
                  java.lang.String rep_rzao        =  null;
                  java.lang.String codigo_regional =  null;
                  java.lang.String nome_regional   =  null;
                  java.lang.String cli_codigo      =  null;
                  java.lang.String cli_rzao        =  null;
                  java.lang.String grupo_economico =  null;
                  double valor_analista            =  0;
                  double valor_saldo               =  0;
                  double disponivel                =  0;
                  double perc                      =  0;
                  int i_bl_report_Jw_limite_credito_disponivel = 0;
                  t_jw_limite_credito_disponivel = (portalbr.dbobj.view.Jw_limite_credito_disponivel)res_Jw_limite_credito_disponivel.elementAt(i_bl_report_Jw_limite_credito_disponivel);
                  cli_codigo      = t_jw_limite_credito_disponivel.getCli_codigo()==null?"":t_jw_limite_credito_disponivel.getCli_codigo();
                  cli_rzao        = t_jw_limite_credito_disponivel.getCli_rzao()==null?"":t_jw_limite_credito_disponivel.getCli_rzao();
                  valor_analista  = t_jw_limite_credito_disponivel.getValor_analista();
                  valor_saldo     = t_jw_limite_credito_disponivel.getValor_saldo();
                  disponivel      = t_jw_limite_credito_disponivel.getDisponivel();
                  perc            = t_jw_limite_credito_disponivel.getPerc();
                  rep_cdgo        = t_jw_limite_credito_disponivel.getRep_cdgo()==null?"":t_jw_limite_credito_disponivel.getRep_cdgo();
                  rep_rzao        = t_jw_limite_credito_disponivel.getRep_rzao()==null?"":t_jw_limite_credito_disponivel.getRep_rzao();
                  grupo_economico = t_jw_limite_credito_disponivel.getGrupo_economico()==null?"":t_jw_limite_credito_disponivel.getGrupo_economico();
                  codigo_regional = t_jw_limite_credito_disponivel.getCodigo_regional()==null?"":t_jw_limite_credito_disponivel.getCodigo_regional();
                  nome_regional   = t_jw_limite_credito_disponivel.getNome_regional()==null?"":t_jw_limite_credito_disponivel.getNome_regional();
                  %>
                  <%
                  if(!codigo_regional.equals("")){
                    %>
                    <tr class="reportHeader2" >
                      <td class="columnTdHeader" style="text-align:left;" colspan=7;>
                        Regional :
                        <%= codigo_regional %>
                        -
                        <%= nome_regional %>
                      </td>
                    </tr>
                    <%
                  }
                  %>
                  <%
                  if(!rep_cdgo.equals("")){
                    %>
                    <tr class="reportHeader2" >
                      <td class="columnTdHeader" style="text-align:left;" colspan=7;>
                        Representante :
                        <%= rep_cdgo %>
                        -
                        <%= rep_rzao %>
                      </td>
                    </tr>
                    <%
                  }
                  %>
                  <tr class="reportHeader" >
                    <td class="columnTdHeader" style="text-align:left;" width="5%">
                      Código
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Razão Social
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Grupo Econômico
                    </td>
                    <td class="columnTdHeader" style="text-align:right;">
                      Valor Analista
                    </td>
                    <td class="columnTdHeader" style="text-align:right;">
                      Limite Usado
                    </td>
                    <td class="columnTdHeader" style="text-align:right;">
                      Valor Disponível
                    </td>
                    <td class="columnTdHeader" style="text-align:right;">
                      % Usado
                    </td>
                  </tr>
                  <%
                  while (i_bl_report_Jw_limite_credito_disponivel<res_Jw_limite_credito_disponivel.size()){
                    counterbl_report_Jw_limite_credito_disponivel++;
                    String style="";
                    if (!((i_bl_report_Jw_limite_credito_disponivel%2)!=0)) {
                      style="class=rowColor";
                    } else {
                      style="class=rowBlank";
                    }
                    %>
                    <tr <%= style %> id='TRbl_report_Jw_limite_credito_disponivel<%=counterbl_report_Jw_limite_credito_disponivel%>' >
                      <td class="reportColumn" style="text-align:left;" width="5%">
                        <%= cli_codigo %>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <%= cli_rzao %>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <%= grupo_economico %>
                      </td>
                      <td class="reportColumn" style="text-align:right;">
                        <%= com.egen.util.text.FormatNumber.format(valor_analista, "##,##0.00") %>
                      </td>
                      <td class="reportColumn" style="text-align:right;">
                        <%= com.egen.util.text.FormatNumber.format(valor_saldo, "##,##0.00") %>
                      </td>
                      <td class="reportColumn" style="text-align:right;">
                        <%= com.egen.util.text.FormatNumber.format(disponivel, "##,##0.00") %>
                      </td>
                      <td class="reportColumn" style="text-align:right;">
                        <%= com.egen.util.text.FormatNumber.format(perc, "##,##0.00") %>
                      </td>
                    </tr>
                    <%
                    if (++i_bl_report_Jw_limite_credito_disponivel >= res_Jw_limite_credito_disponivel.size()) {
                      break;
                    }
                    t_jw_limite_credito_disponivel = (portalbr.dbobj.view.Jw_limite_credito_disponivel)res_Jw_limite_credito_disponivel.elementAt(i_bl_report_Jw_limite_credito_disponivel);
                    cli_codigo      = t_jw_limite_credito_disponivel.getCli_codigo()==null?"":t_jw_limite_credito_disponivel.getCli_codigo();
                    cli_rzao        = t_jw_limite_credito_disponivel.getCli_rzao()==null?"":t_jw_limite_credito_disponivel.getCli_rzao();
                    grupo_economico = t_jw_limite_credito_disponivel.getGrupo_economico()==null?"":t_jw_limite_credito_disponivel.getGrupo_economico();
                    valor_analista  = t_jw_limite_credito_disponivel.getValor_analista();
                    valor_saldo     = t_jw_limite_credito_disponivel.getValor_saldo();
                    disponivel      = t_jw_limite_credito_disponivel.getDisponivel();
                    perc            = t_jw_limite_credito_disponivel.getPerc();

                  }
                }
              }
              %>
            </table>
            <html:form action="adm/LimiteCreditoDisponivel_rForm.do" method="post" styleClass="baseForm">
              <table class="buttonTable" style='width:;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <%
                    if(!(request.getParameter("excel")+"").equals("true")){
                      %>
                      <html:submit accesskey="b" styleClass="baseButton" property="back1_action">
                        <bean:message bundle="ApplicationResources" key="jsp.back"/>
                      </html:submit>
                      <%
                    }
                    %>
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
