<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Limite de Crédito
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

            <%
            int counterbl_report_Jw_limite_credito=0;
            {
              portalbr.dbobj.view.Jw_limite_credito t_jw_limite_credito = new portalbr.dbobj.view.Jw_limite_credito();
              java.util.Vector res_Jw_limite_credito = (java.util.Vector)session.getAttribute("res_Jw_limite_credito");
              if (res_Jw_limite_credito!=null && res_Jw_limite_credito.size()>0) {
                java.lang.Integer codigo_regional =  null;
                java.lang.String nome_regional    =  null;
                java.lang.String rep_cdgo         =  null;
                java.lang.String rep_rzao         =  null;
                java.lang.Integer cli_cdgo        =  null;
                java.lang.String cli_rzao         =  null;
                double limite                     =  0;
                java.lang.String situacao         =  null;
                java.lang.String situacao_cr      =  null;
                java.lang.String novo_limite      =  null;
                java.lang.String rubrica          =  null;
                int i_bl_report_Jw_limite_credito = 0;
                t_jw_limite_credito = (portalbr.dbobj.view.Jw_limite_credito)res_Jw_limite_credito.elementAt(i_bl_report_Jw_limite_credito);
                codigo_regional = t_jw_limite_credito.getCodigo_regional();
                nome_regional   = t_jw_limite_credito.getNome_regional()==null?"":t_jw_limite_credito.getNome_regional();
                rep_cdgo        = t_jw_limite_credito.getRep_cdgo()==null?"":t_jw_limite_credito.getRep_cdgo();
                rep_rzao        = t_jw_limite_credito.getRep_rzao()==null?"":t_jw_limite_credito.getRep_rzao();
                cli_cdgo        = t_jw_limite_credito.getCli_cdgo();
                cli_rzao        = t_jw_limite_credito.getCli_rzao()==null?"":t_jw_limite_credito.getCli_rzao();
                limite          = t_jw_limite_credito.getLimite();
                situacao        = t_jw_limite_credito.getSituacao()==null?"":t_jw_limite_credito.getSituacao();
                situacao_cr     = t_jw_limite_credito.getSituacao_cr()==null?"":t_jw_limite_credito.getSituacao_cr();
                novo_limite = novo_limite="";;
                rubrica = rubrica="";;
              if(situacao.equals("A")){situacao = "Ativo";}
            if(situacao.equals("I")){situacao = "Inativo";}
          if(situacao.equals("S")){situacao = "Suspenso";}
          if(situacao_cr.equals("A")){
            situacao_cr = "Ativo";
          } else {
            situacao_cr = "Inativo";
          }
          java.lang.String b0_nome_regional =  null;
          java.lang.String b1_rep_rzao =  null;
          while (i_bl_report_Jw_limite_credito<res_Jw_limite_credito.size()){
            counterbl_report_Jw_limite_credito++;
            %>
            <table id="TRbl_report_Jw_limite_credito" class="reportTable" style=width:99%;  border=1  frame=box>
              <tr class="reportHeader3" >
                <td colspan=7>
                  <big>
                    Regional :
                    <%= ((codigo_regional!=null)?codigo_regional.toString():"") %>
                    -
                    <%= nome_regional %>
                  </big>
                </td>
              </tr>
              <%
              b0_nome_regional = nome_regional;
              while (i_bl_report_Jw_limite_credito<res_Jw_limite_credito.size() &&  (b0_nome_regional==null?"":b0_nome_regional).equals((nome_regional==null?"":nome_regional))){
                counterbl_report_Jw_limite_credito++;
                %>
                <table id="TRbl_report_Jw_limite_credito" class="reportTable" style=width:99%;  border=1  frame=box>
                  <tr class="reportHeader2" >
                    <td colspan=7>
                      Representante :
                      <%= rep_cdgo %>
                      -
                      <%= rep_rzao %>
                    </td>
                  </tr>
                  <%
                  b1_rep_rzao = rep_rzao;
                  %>
                  <tr class="reportHeader" >
                    <td class="columnTdHeader" style="text-align:right;" width="10%">
                      Código
                    </td>
                    <td class="columnTdHeader" style="text-align:left;" width="50%">
                      Razão Social
                    </td>
                    <td class="columnTdHeader" style="text-align:right;">
                      Limite Atual
                    </td>
                    <td class="columnTdHeader" style="text-align:center;">
                      Situação
                    </td>
                    <td class="columnTdHeader" style="text-align:center;">
                      Sit. Cli/Rep.
                    </td>
                    <td class="columnTdHeader" style="text-align:center;">
                      Novo Limite
                    </td>
                    <td class="columnTdHeader" style="text-align:center;">
                      Rubrica
                    </td>
                  </tr>
                  <%
                  while (i_bl_report_Jw_limite_credito<res_Jw_limite_credito.size() &&  (b0_nome_regional==null?"":b0_nome_regional).equals((nome_regional==null?"":nome_regional)) &&  (b1_rep_rzao==null?"":b1_rep_rzao).equals((rep_rzao==null?"":rep_rzao))){
                    counterbl_report_Jw_limite_credito++;
                    String style="";
                    if (!((i_bl_report_Jw_limite_credito%2)!=0)) {
                      style="class=rowColor";
                    } else {
                      style="class=rowBlank";
                    }
                    %>
                    <tr <%= style %> id='TRbl_report_Jw_limite_credito<%=counterbl_report_Jw_limite_credito%>' >
                      <td class="reportColumn" style="text-align:right;">
                        <%= ((cli_cdgo!=null)?cli_cdgo.toString():"") %>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <%= cli_rzao %>
                      </td>
                      <td class="reportColumn" style="text-align:right;">
                        <%= com.egen.util.text.FormatNumber.format(limite, "##,##0.00") %>
                      </td>
                      <td class="reportColumn" style="text-align:center;">
                        <%= situacao %>
                      </td>
                      <td class="reportColumn" style="text-align:center;">
                        <%= situacao_cr %>
                      </td>
                      <td class="reportColumn" style="text-align:center;">
                        <%= novo_limite %>
                      </td>
                      <td class="reportColumn" style="text-align:center;">
                        <%= rubrica %>
                      </td>
                    </tr>
                    <%
                    if (++i_bl_report_Jw_limite_credito >= res_Jw_limite_credito.size()) {
                      break;
                    }
                    t_jw_limite_credito = (portalbr.dbobj.view.Jw_limite_credito)res_Jw_limite_credito.elementAt(i_bl_report_Jw_limite_credito);
                    codigo_regional = t_jw_limite_credito.getCodigo_regional();
                    nome_regional   = t_jw_limite_credito.getNome_regional()==null?"":t_jw_limite_credito.getNome_regional();
                    rep_cdgo        = t_jw_limite_credito.getRep_cdgo()==null?"":t_jw_limite_credito.getRep_cdgo();
                    rep_rzao        = t_jw_limite_credito.getRep_rzao()==null?"":t_jw_limite_credito.getRep_rzao();
                    cli_cdgo        = t_jw_limite_credito.getCli_cdgo();
                    cli_rzao        = t_jw_limite_credito.getCli_rzao()==null?"":t_jw_limite_credito.getCli_rzao();
                    limite          = t_jw_limite_credito.getLimite();
                    situacao        = t_jw_limite_credito.getSituacao()==null?"":t_jw_limite_credito.getSituacao();
                    situacao_cr     = t_jw_limite_credito.getSituacao_cr()==null?"":t_jw_limite_credito.getSituacao_cr();
                    novo_limite = novo_limite="";;
                    rubrica = rubrica="";;
                  if(situacao.equals("A")){situacao = "Ativo";}
                if(situacao.equals("I")){situacao = "Inativo";}
              if(situacao.equals("S")){situacao = "Suspenso";}
              if(situacao_cr.equals("A")){
                situacao_cr = "Ativo";
              } else {
                situacao_cr = "Inativo";
              }
            }
          }
          %>
        </table>
        <%
      }
      %>
    </table>
    <%
  }
  %>
</table>
<%
}
%>
</table>
<html:form action="adm/LimiteCredito_rForm.do" method="post" styleClass="baseForm">
  <table class="buttonTable" style='width:;'>
    <tr class="buttonTr">
      <td class="buttonTd">
        <html:button accesskey="v" onclick="history.go(-1);" styleClass="baseButton" property="back_action">
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
