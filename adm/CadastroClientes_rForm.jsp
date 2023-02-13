<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Cadastro de Clientes
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
            //---------------------------------------------------------------------------------------
            // Autor             : Mateus Garbrecht (TechnoCorp)
            // Data de Criação   : 03/04/2006
            // Objetivo          : Mostra os registros selecionados através da tela de filtro:
            //                     /adm/CadastroClientesForm.jsp
            //----------------------------------------------------------------------------------------
            // Data de Alteração :
            // Descrição         :
            //----------------------------------------------------------------------------------------
            %>
            <table id="TRbl_report_Jw_clientes_cad" class="reportTable" style=width:99%;  border=1  frame=box>
              <%
              int counterbl_report_Jw_clientes_cad=0;
              {
                portalbr.dbobj.view.Jw_clientes_cad t_jw_clientes_cad = new portalbr.dbobj.view.Jw_clientes_cad();
                java.util.Vector res_Jw_clientes_cad = (java.util.Vector)session.getAttribute("res_Jw_clientes_cad");
                if (res_Jw_clientes_cad!=null && res_Jw_clientes_cad.size()>0) {
                  java.lang.String cli_cdgo        =  null;
                  java.lang.String esc_seqn        =  null;
                  java.lang.String cli_rzao        =  null;
                  java.lang.String cli_nome        =  null;
                  java.lang.String ecl_cdad        =  null;
                  java.lang.String est_unifed      =  null;
                  java.lang.String rep_cdgo        =  null;
                  java.lang.String rep_rzao        =  null;
                  java.lang.String codigo_regional =  null;
                  java.lang.String nome_regional   =  null;
                  java.lang.String esc_cgc =  null;
                  int i_bl_report_Jw_clientes_cad  =  0;
                  t_jw_clientes_cad = (portalbr.dbobj.view.Jw_clientes_cad)res_Jw_clientes_cad.elementAt(i_bl_report_Jw_clientes_cad);
                  cli_cdgo        = t_jw_clientes_cad.getCli_cdgo()==null?"":t_jw_clientes_cad.getCli_cdgo();
                  esc_seqn        = t_jw_clientes_cad.getEsc_seqn()==null?"":t_jw_clientes_cad.getEsc_seqn();
                  esc_cgc         = t_jw_clientes_cad.getEsc_cgc()==null?"":t_jw_clientes_cad.getEsc_cgc();
                  cli_rzao        = t_jw_clientes_cad.getCli_rzao()==null?"":t_jw_clientes_cad.getCli_rzao();
                  cli_nome        = t_jw_clientes_cad.getCli_nome()==null?"":t_jw_clientes_cad.getCli_nome();
                  ecl_cdad        = t_jw_clientes_cad.getEcl_cdad()==null?"":t_jw_clientes_cad.getEcl_cdad();
                  est_unifed      = t_jw_clientes_cad.getEst_unifed()==null?"":t_jw_clientes_cad.getEst_unifed();
                  rep_cdgo        = t_jw_clientes_cad.getRep_cdgo()==null?"":t_jw_clientes_cad.getRep_cdgo();
                  rep_rzao        = t_jw_clientes_cad.getRep_rzao()==null?"":t_jw_clientes_cad.getRep_rzao();
                  codigo_regional = t_jw_clientes_cad.getCodigo_regional()==null?"":t_jw_clientes_cad.getCodigo_regional();
                  nome_regional   = t_jw_clientes_cad.getNome_regional()==null?"":t_jw_clientes_cad.getNome_regional();
                  %>
                  <tr class="reportHeader" >
                    <td class="columnTdHeader" style="text-align:left;">
                      Código
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Razão Social
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Cidade - UF
                    </td>
                    <td class="columnTdHeader" style="text-align:center;">
                      CNPJ
                    </td>
                  </tr>
                  <%
                  while (i_bl_report_Jw_clientes_cad<res_Jw_clientes_cad.size()){
                    counterbl_report_Jw_clientes_cad++;
                    String style="";
                    if (!((i_bl_report_Jw_clientes_cad%2)!=0)) {
                      style="rowColor";
                    } else {
                      style="rowBlank";
                    }
                    %>
                    <tr class=<%= style %> id='TRbl_report_Jw_clientes_cad<%=counterbl_report_Jw_clientes_cad%>' >
                      <td class="reportColumn" style="text-align:left;" title="Dados do Cliente: <%= cli_rzao %>">
                        <%
                        if(!(request.getParameter("excel")+"").equals("true")){
                          %>
                          <a href="../adm/CadastroClientes_dForm.do?select_action=&cli_cdgo=<%= cli_cdgo %>&esc_seqn=<%= esc_seqn %>" target="_self" STYLE="cursor:hand" onclick="bloqueia();">
                            <%= cli_cdgo %>
                            -
                            <%= esc_seqn %>
                          </a>
                          <%
                        } else {
                          %>
                          <%= cli_cdgo %>
                          -
                          <%= esc_seqn %>
                          <%
                        }
                        %>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <%= cli_rzao %>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <%= ecl_cdad %>
                        -
                        <%= est_unifed %>
                      </td>
                      <td class="reportColumn" style="text-align:center;">
                        <%= esc_cgc %>
                      </td>
                    </tr>
                    <%
                    if (++i_bl_report_Jw_clientes_cad >= res_Jw_clientes_cad.size()) {
                      break;
                    }
                    t_jw_clientes_cad = (portalbr.dbobj.view.Jw_clientes_cad)res_Jw_clientes_cad.elementAt(i_bl_report_Jw_clientes_cad);
                    cli_cdgo        = t_jw_clientes_cad.getCli_cdgo()==null?"":t_jw_clientes_cad.getCli_cdgo();
                    esc_seqn        = t_jw_clientes_cad.getEsc_seqn()==null?"":t_jw_clientes_cad.getEsc_seqn();
                    esc_cgc         = t_jw_clientes_cad.getEsc_cgc()==null?"":t_jw_clientes_cad.getEsc_cgc();
                    cli_rzao        = t_jw_clientes_cad.getCli_rzao()==null?"":t_jw_clientes_cad.getCli_rzao();
                    cli_nome        = t_jw_clientes_cad.getCli_nome()==null?"":t_jw_clientes_cad.getCli_nome();
                    ecl_cdad        = t_jw_clientes_cad.getEcl_cdad()==null?"":t_jw_clientes_cad.getEcl_cdad();
                    est_unifed      = t_jw_clientes_cad.getEst_unifed()==null?"":t_jw_clientes_cad.getEst_unifed();
                    rep_cdgo        = t_jw_clientes_cad.getRep_cdgo()==null?"":t_jw_clientes_cad.getRep_cdgo();
                    rep_rzao        = t_jw_clientes_cad.getRep_rzao()==null?"":t_jw_clientes_cad.getRep_rzao();
                    codigo_regional = t_jw_clientes_cad.getCodigo_regional()==null?"":t_jw_clientes_cad.getCodigo_regional();
                    nome_regional   = t_jw_clientes_cad.getNome_regional()==null?"":t_jw_clientes_cad.getNome_regional();
                  }
                }
              }
              %>
            </table>
            <html:form action="/adm/CadastroClientes_rForm.do" method="post" styleClass="baseForm">
              <table class="buttonTable" style='width:;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
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
