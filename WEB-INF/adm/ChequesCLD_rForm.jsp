<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Relatório de Cheques em CLD
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
            // Data de Criação   : 11/04/2006
            // Objetivo          : Relatório com os registros retornados pela consulta da tela:
            //                     /adm/ChequesCLDForm.jsp
            //----------------------------------------------------------------------------------------
            // Data de Alteração :
            // Descrição         :
            //----------------------------------------------------------------------------------------
            %>
            <b>
              Período :
              <%= session.getAttribute("parametros")+"" %>
            </b>
            <%
            request.setAttribute("dt_final", request.getParameter("dt_final"));
            request.setAttribute("dt_inicial", request.getParameter("dt_inicial"));
            int counterbl_report_Jw_cheques_cld=0;
            {
              portalbr.dbobj.view.Jw_cheques_cld t_jw_cheques_cld = new portalbr.dbobj.view.Jw_cheques_cld();
              java.util.Vector res_Jw_cheques_cld = (java.util.Vector)session.getAttribute("res_Jw_cheques_cld");
              if (res_Jw_cheques_cld!=null && res_Jw_cheques_cld.size()>0) {
                java.lang.String cod_repres      =  null;
                java.lang.String rep_razao       =  null;
                java.lang.String b0_rep_razao    =  null;
                java.lang.String codigo_regional =  null;
                java.lang.String nome_regional   =  null;
                java.lang.String numero          =  null;
                java.lang.String agencia         =  null;
                java.lang.String portador        =  null;
                java.lang.String cliente         =  null;
                java.lang.String nome2           =  null;
                java.lang.String tipo            =  null;
                java.lang.String codigo_gerente  =  null;
                double valor_pcp                 =  0;
                double valor_deb                 =  0;
                double saldo                     =  0;
                double valor_pcp_total           =  0;
                double valor_deb_total           =  0;
                double saldo_total               =  0;
                double valor_pcp_rep             =  0;
                double valor_deb_rep             =  0;
                double saldo_rep                 =  0;
                int i_bl_report_Jw_cheques_cld   =  0;
                t_jw_cheques_cld = (portalbr.dbobj.view.Jw_cheques_cld)res_Jw_cheques_cld.elementAt(i_bl_report_Jw_cheques_cld);
                cod_repres       = t_jw_cheques_cld.getCod_repres()==null?"":t_jw_cheques_cld.getCod_repres();
                rep_razao        = t_jw_cheques_cld.getRep_razao()==null?"":t_jw_cheques_cld.getRep_razao();
                codigo_regional  = t_jw_cheques_cld.getCodigo_regional()==null?"":t_jw_cheques_cld.getCodigo_regional();
                nome_regional    = t_jw_cheques_cld.getNome_regional()==null?"":t_jw_cheques_cld.getNome_regional();
                numero           = t_jw_cheques_cld.getNumero()==null?"":t_jw_cheques_cld.getNumero();
                agencia          = t_jw_cheques_cld.getAgencia()==null?"":t_jw_cheques_cld.getAgencia();
                portador         = t_jw_cheques_cld.getPortador()==null?"":t_jw_cheques_cld.getPortador();
                cliente          = t_jw_cheques_cld.getCliente()==null?"":t_jw_cheques_cld.getCliente();
                nome2            = t_jw_cheques_cld.getNome()==null?"":t_jw_cheques_cld.getNome();
                tipo             = t_jw_cheques_cld.getTipo()==null?"":t_jw_cheques_cld.getTipo();
                codigo_gerente   = t_jw_cheques_cld.getCodigo_gerente()==null?"":t_jw_cheques_cld.getCodigo_gerente();
                valor_pcp        = t_jw_cheques_cld.getValor_pcp();
                valor_deb        = t_jw_cheques_cld.getValor_deb();
                saldo            = t_jw_cheques_cld.getSaldo();
                while (i_bl_report_Jw_cheques_cld <  res_Jw_cheques_cld.size()){
                  counterbl_report_Jw_cheques_cld++;
                  %>
                  <table id="TRbl_report_Jw_cheques_cld" class="reportTable" style=width:99%; border=1 frame=box>
                    <tr class="reportHeader2" >
                      <td colspan=9>
                        Representante :
                        <%= cod_repres %>
                        -
                        <%= rep_razao %>
                      </td>
                    </tr>
                    <%
                    b0_rep_razao = rep_razao;
                    %>
                    <tr class="reportHeader" >
                      <td class="columnTdHeader" style="text-align:center;">
                        Número
                      </td>
                      <td class="columnTdHeader" style="text-align:center;">
                        Agência
                      </td>
                      <td class="columnTdHeader" style="text-align:center;">
                        Portador
                      </td>
                      <td class="columnTdHeader" style="text-align:center;">
                        Cliente
                      </td>
                      <td class="columnTdHeader" style="text-align:left;">
                        Nome
                      </td>
                      <td class="columnTdHeader" style="text-align:center;">
                        Tipo
                      </td>
                      <td class="columnTdHeader" style="text-align:right;">
                        Valor
                      </td>
                      <td class="columnTdHeader" style="text-align:right;">
                        Pago
                      </td>
                      <td class="columnTdHeader" style="text-align:right;">
                        Saldo
                      </td>
                    </tr>
                    <%
                    while (i_bl_report_Jw_cheques_cld<res_Jw_cheques_cld.size() &&  (b0_rep_razao==null?"":b0_rep_razao).equals((rep_razao==null?"":rep_razao))){
                      counterbl_report_Jw_cheques_cld++;
                      valor_pcp_rep += valor_pcp;
                      valor_deb_rep += valor_deb;
                      saldo_rep     += saldo;
                      String style="";
                      if (!((i_bl_report_Jw_cheques_cld%2)!=0)) {
                        style="class=rowColor";
                      } else {
                        style="class=rowBlank";
                      }
                      %>
                      <tr <%= style %> id='TRbl_report_Jw_cheques_cld<%=counterbl_report_Jw_cheques_cld%>' >
                        <td class="reportColumn" style="text-align:center;width:80;">
                          <%= numero %>
                        </td>
                        <td class="reportColumn" style="text-align:center;width:80;">
                          <%= agencia %>
                        </td>
                        <td class="reportColumn" style="text-align:center;width:80;">
                          <%= portador %>
                        </td>
                        <td class="reportColumn" style="text-align:center;width:80;">
                          <%= cliente %>
                        </td>
                        <td class="reportColumn" style="text-align:left;width:300;">
                          <%= nome2 %>
                        </td>
                        <td class="reportColumn" style="text-align:center;width:60;">
                          <%= tipo %>
                        </td>
                        <td class="reportColumn" style="text-align:right;width:90;">
                          <%= com.egen.util.text.FormatNumber.format(valor_pcp, "##,##0.00") %>
                        </td>
                        <td class="reportColumn" style="text-align:right;width:90;">
                          <%= com.egen.util.text.FormatNumber.format(valor_deb, "##,##0.00") %>
                        </td>
                        <td class="reportColumn" style="text-align:right;width:90;">
                          <%= com.egen.util.text.FormatNumber.format(saldo, "##,##0.00") %>
                        </td>
                      </tr>
                      <%
                      if (++i_bl_report_Jw_cheques_cld >= res_Jw_cheques_cld.size()) {
                        break;
                      }
                      t_jw_cheques_cld = (portalbr.dbobj.view.Jw_cheques_cld)res_Jw_cheques_cld.elementAt(i_bl_report_Jw_cheques_cld);
                      cod_repres       = t_jw_cheques_cld.getCod_repres()==null?"":t_jw_cheques_cld.getCod_repres();
                      rep_razao        = t_jw_cheques_cld.getRep_razao()==null?"":t_jw_cheques_cld.getRep_razao();
                      codigo_regional  = t_jw_cheques_cld.getCodigo_regional()==null?"":t_jw_cheques_cld.getCodigo_regional();
                      nome_regional    = t_jw_cheques_cld.getNome_regional()==null?"":t_jw_cheques_cld.getNome_regional();
                      numero           = t_jw_cheques_cld.getNumero()==null?"":t_jw_cheques_cld.getNumero();
                      agencia          = t_jw_cheques_cld.getAgencia()==null?"":t_jw_cheques_cld.getAgencia();
                      portador         = t_jw_cheques_cld.getPortador()==null?"":t_jw_cheques_cld.getPortador();
                      cliente          = t_jw_cheques_cld.getCliente()==null?"":t_jw_cheques_cld.getCliente();
                      nome2            = t_jw_cheques_cld.getNome()==null?"":t_jw_cheques_cld.getNome();
                      tipo             = t_jw_cheques_cld.getTipo()==null?"":t_jw_cheques_cld.getTipo();
                      codigo_gerente   = t_jw_cheques_cld.getCodigo_gerente()==null?"":t_jw_cheques_cld.getCodigo_gerente();
                      valor_pcp        = t_jw_cheques_cld.getValor_pcp();
                      valor_deb        = t_jw_cheques_cld.getValor_deb();
                      saldo            = t_jw_cheques_cld.getSaldo();
                    }
                    valor_pcp_total  += valor_pcp_rep;
                    valor_deb_total  += valor_deb_rep;
                    saldo_total      += saldo_rep;
                    %>
                    <tr>
                      <td colspan=6; style="text-align:right";>
                        <b>
                          Total Representante :
                        </b>
                      </td>
                      <td class="reportColumn" style="text-align:right;width:90;">
                        <%= com.egen.util.text.FormatNumber.format(valor_pcp_rep, "##,##0.00") %>
                      </td>
                      <td class="reportColumn" style="text-align:right;width:90;">
                        <%= com.egen.util.text.FormatNumber.format(valor_deb_rep, "##,##0.00") %>
                      </td>
                      <td class="reportColumn" style="text-align:right;width:90;">
                        <%= com.egen.util.text.FormatNumber.format(saldo_rep, "##,##0.00") %>
                      </td>
                    </tr>

                    <%
                    valor_pcp_rep = 0;
                    valor_deb_rep = 0;
                    saldo_rep     = 0;
                  }
                  %>
                  <tr>
                    <td colspan=6; style="text-align:right";>
                      <b>
                        Total Geral :
                      </b>
                    </td>
                    <td class="reportColumn" style="text-align:right;width:90;">
                      <b>
                        <%= com.egen.util.text.FormatNumber.format(valor_pcp_total, "##,##0.00") %>
                      </b>
                    </td>
                    <td class="reportColumn" style="text-align:right;width:90;">
                      <b>
                        <%= com.egen.util.text.FormatNumber.format(valor_deb_total, "##,##0.00") %>
                      </b>
                    </td>
                    <td class="reportColumn" style="text-align:right;width:90;">
                      <b>
                        <%= com.egen.util.text.FormatNumber.format(saldo_total, "##,##0.00") %>
                      </b>
                    </td>
                  </tr>
                  <%
                }
              }
              %>
            </table>
            <html:form action="adm/ChequesCLD_rForm.do" method="post" styleClass="baseForm">
              <table class="buttonTable" style='width:;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <%
                    if(!(request.getParameter("excel")+"").equals("true")){
                      %>
                      <html:submit accesskey="a" styleClass="baseButton" property="back_action">
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
