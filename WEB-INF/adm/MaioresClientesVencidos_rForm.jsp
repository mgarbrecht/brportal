<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Consulta de Maiores Clientes Vencidos
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

            <html:form action="adm/MaioresClientesVencidos_rForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <html:hidden property="consulta"/>
              </table>

            </html:form>
            <%
            //---------------------------------------------------------------------------------------
            // Autor             : Mateus Garbrecht (TechnoCorp)
            // Data de Criação   : 10/04/2006
            // Objetivo          : Relatório com os registros retornados pela consulta da tela:
            //                     /adm/MaioresClientesVencidosForm.jsp
            //----------------------------------------------------------------------------------------
            // Data de Alteração :
            // Descrição         :
            //----------------------------------------------------------------------------------------
            %>
            <%
            boolean mostraObservacao = false;
            acesso.Sessao sessao = new acesso.Sessao(session);
            if((sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL")) || (sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE EXPORTACAO"))){
              mostraObservacao = false;
            }

            portalbr.adm.MaioresClientesVencidos_rActionForm MaioresClientesVencidos_rActionForm = (portalbr.adm.MaioresClientesVencidos_rActionForm)session.getAttribute("MaioresClientesVencidos_rActionForm");
            %>
            <table id="TRbl_report_Jw_maiores_clientes_vencidos" class="reportTable" style=width:99%;  border=1  frame=box>
              <tr class="reportHeader2"  >
                <td align="center">
                  <big>
                    <%= MaioresClientesVencidos_rActionForm.getConsulta() %>
                    <br>
                    Atualizada em :
                    <%= com.egen.util.text.FormatDate.getTimestamp() %>
                  </big>
                </td>
              </tr>
            </table>
            <table id="TRbl_report_Jw_maiores_clientes_vencidos" class="reportTable" style=width:99%;  border=1  frame=box>
              <%
              int counterbl_report_Jw_maiores_clientes_vencidos=0;
              double total = 0;
              try{
                portalbr.dbobj.view.Jw_maiores_clientes_vencidos t_jw_maiores_clientes_vencidos = new portalbr.dbobj.view.Jw_maiores_clientes_vencidos();
                java.util.Vector res_Jw_maiores_clientes_vencidos = (java.util.Vector)session.getAttribute("res_Jw_maiores_clientes_vencidos");
                if (res_Jw_maiores_clientes_vencidos!=null && res_Jw_maiores_clientes_vencidos.size()>0) {
                  java.lang.String codigo                       =  null;
                  java.lang.String cliente                      =  null;
                  java.lang.String fone                         =  null;
                  java.lang.String ecl_cdad                     =  null;
                  java.lang.String dias                         =  null;
                  java.lang.String observacao                   =  null;
                  java.lang.String grupo_economico              =  null;
                  int i_bl_report_Jw_maiores_clientes_vencidos  =  0;
                  double valor                                  =  0;
                  int codigo_regional = 0;
                  int contador =0;

                  t_jw_maiores_clientes_vencidos = (portalbr.dbobj.view.Jw_maiores_clientes_vencidos)res_Jw_maiores_clientes_vencidos.elementAt(i_bl_report_Jw_maiores_clientes_vencidos);
                  codigo    = t_jw_maiores_clientes_vencidos.getCodigo()==null?"":t_jw_maiores_clientes_vencidos.getCodigo();
                  cliente   = t_jw_maiores_clientes_vencidos.getCliente()==null?"":t_jw_maiores_clientes_vencidos.getCliente();
                  fone      = t_jw_maiores_clientes_vencidos.getFone()==null?"":t_jw_maiores_clientes_vencidos.getFone();
                  ecl_cdad  = t_jw_maiores_clientes_vencidos.getEcl_cdad()==null?"":t_jw_maiores_clientes_vencidos.getEcl_cdad();
                  dias      = t_jw_maiores_clientes_vencidos.getDias()==null?"":t_jw_maiores_clientes_vencidos.getDias();
                  valor     = t_jw_maiores_clientes_vencidos.getValor();
                  grupo_economico = t_jw_maiores_clientes_vencidos.getGrupo_economico()==null?"":t_jw_maiores_clientes_vencidos.getGrupo_economico();
                  observacao      = t_jw_maiores_clientes_vencidos.getObservacao()==null?"":t_jw_maiores_clientes_vencidos.getObservacao();
                  codigo_regional = t_jw_maiores_clientes_vencidos.getCodigo_regional();

                  total += valor;
                  %>
                  <tr class="reportHeader" >
                    <td class="columnTdHeader" style="text-align:left;">
                      Nr.
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Regional
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Grupo Econômico
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Código
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Cliente
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Fone
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Cidade
                    </td>
                    <td class="columnTdHeader" style="text-align:center;">
                      Dias
                    </td>
                    <td class="columnTdHeader" style="text-align:right;">
                      Valor
                    </td>

                    <%
                    if(mostraObservacao) {
                      %>
                      <td class="columnTdHeader" style="text-align:left;">
                        Observação
                      </td>
                      <%
                    }
                    %>
                  </tr>
                  <%
                  while (i_bl_report_Jw_maiores_clientes_vencidos<res_Jw_maiores_clientes_vencidos.size()){
                    counterbl_report_Jw_maiores_clientes_vencidos++;
                    String style="";
                    if (!((i_bl_report_Jw_maiores_clientes_vencidos%2)!=0)) {
                      style="class=rowColor";
                    } else {
                      style="class=rowBlank";
                    }
                    %>
                    <tr <%= style %> id='TRbl_report_Jw_maiores_clientes_vencidos<%=counterbl_report_Jw_maiores_clientes_vencidos%>' >
                      <td class="reportColumn" style="text-align:left;">
                        <%
                        contador++;
                        %>
                        <%= contador %>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <%= codigo_regional %>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <%= grupo_economico %>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <%= codigo %>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <%= cliente %>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <%
                        if(!(request.getParameter("excel")+"").equals("true")){
                          %>
                          <%= fone %>
                          <%
                        } else {
                          %>
                          <%= fone %>
                           
                          <%
                        }
                        %>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <%= ecl_cdad %>
                      </td>
                      <td class="reportColumn" style="text-align:center;">
                        <%= dias %>
                      </td>
                      <td class="reportColumn" style="text-align:right;">
                        <%= com.egen.util.text.FormatNumber.format(valor, "##,##0.00") %>
                      </td>
                      <%
                      if(mostraObservacao) {
                        %>
                        <td class="reportColumn" style="text-align:left;">
                          <%= observacao %>
                        </td>
                        <%
                      }
                      %>
                    </tr>
                    <%
                    if (++i_bl_report_Jw_maiores_clientes_vencidos >= res_Jw_maiores_clientes_vencidos.size()) {
                      break;
                    }
                    t_jw_maiores_clientes_vencidos = (portalbr.dbobj.view.Jw_maiores_clientes_vencidos)res_Jw_maiores_clientes_vencidos.elementAt(i_bl_report_Jw_maiores_clientes_vencidos);
                    codigo    = t_jw_maiores_clientes_vencidos.getCodigo()==null?"":t_jw_maiores_clientes_vencidos.getCodigo();
                    cliente   = t_jw_maiores_clientes_vencidos.getCliente()==null?"":t_jw_maiores_clientes_vencidos.getCliente();
                    fone      = t_jw_maiores_clientes_vencidos.getFone()==null?"":t_jw_maiores_clientes_vencidos.getFone();
                    ecl_cdad  = t_jw_maiores_clientes_vencidos.getEcl_cdad()==null?"":t_jw_maiores_clientes_vencidos.getEcl_cdad();
                    dias      = t_jw_maiores_clientes_vencidos.getDias()==null?"":t_jw_maiores_clientes_vencidos.getDias();
                    valor     = t_jw_maiores_clientes_vencidos.getValor();
                    codigo_regional = t_jw_maiores_clientes_vencidos.getCodigo_regional();
                    grupo_economico = t_jw_maiores_clientes_vencidos.getGrupo_economico()==null?"":t_jw_maiores_clientes_vencidos.getGrupo_economico();
                    observacao      = t_jw_maiores_clientes_vencidos.getObservacao()==null?"":t_jw_maiores_clientes_vencidos.getObservacao();
                    total     += valor;

                  }
                }
              } catch (Exception e){
                session.setAttribute("exception",com.egen.util.system.Error.getDescription(e));
              } finally {
              }
              %>
              <tr>
                <td colspan=8; style="text-align:right;">
                  <big>
                    <b>
                      Total :
                    </b>
                  </big>
                </td>
                <td style="text-align:right;">
                  <big>
                    <b>
                      <%= com.egen.util.text.FormatNumber.format(total, "##,##0.00") %>
                    </b>
                  </big>
                </td>
              </tr>
            </table>
            <html:form action="adm/MaioresClientesVencidos_rForm.do" method="post" styleClass="baseForm">
              <table class="buttonTable" style='width:;'>
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
