<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Títulos em CLD
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
            // Data de Criação   : 18/04/2006
            // Objetivo          : Relatório mostrando os registros retornados pela consulta da tela:
            //                     /adm/TitulosCLDForm.jsp
            //----------------------------------------------------------------------------------------
            // Data de Alteração :
            // Descrição         :
            //----------------------------------------------------------------------------------------
            %>
            <b>
              Período :
              <%= session.getAttribute("parametro1") %>
              -
              <%= session.getAttribute("parametro2") %>
            </b>
            <%
            int counterbl_report_Jw_titulos_cld=0;
            {
              portalbr.dbobj.view.Jw_titulos_cld t_jw_titulos_cld = new portalbr.dbobj.view.Jw_titulos_cld();
              java.util.Vector res_Jw_titulos_cld = (java.util.Vector)session.getAttribute("res_Jw_titulos_cld");
              if (res_Jw_titulos_cld!=null && res_Jw_titulos_cld.size()>0) {
                java.lang.String codigo_reg          =  null;
                java.lang.String nome_regional       =  null;
                java.lang.String codigo_analista     =  null;
                java.lang.String nome_analista       =  null;
                java.lang.String rep_cdgo            =  null;
                java.lang.String rep_rzao            =  null;
                java.lang.String cli_cdgo            =  null;
                java.lang.String cli_rzao            =  null;
                java.lang.String titulo              =  null;
                java.lang.String b0_codigo_reg       =  null;
                java.lang.String b1_codigo_analista  =  null;
                java.lang.String b2_rep_cdgo         =  null;
                java.lang.String b3_cli_cdgo         =  null;
                java.sql.Timestamp data_venc         =  null;
                java.sql.Timestamp data_emissao      =  null;
                double valor_cld                     =  0;
                double vlpcp                         =  0;
                double vldeb                         =  0;
                double saldo                         =  0;
                double total_cliente_valor_cld       =  0;
                double total_cliente_vlpcp           =  0;
                double total_cliente_vldeb           =  0;
                double total_cliente_saldo           =  0;
                double total_representante_valor_cld =  0;
                double total_representante_vlpcp     =  0;
                double total_representante_vldeb     =  0;
                double total_representante_saldo     =  0;
                double total_regional_valor_cld      =  0;
                double total_regional_vlpcp          =  0;
                double total_regional_vldeb          =  0;
                double total_regional_saldo          =  0;
                double recebido                      =  0;
                int i_bl_report_Jw_titulos_cld       =  0;
                t_jw_titulos_cld = (portalbr.dbobj.view.Jw_titulos_cld)res_Jw_titulos_cld.elementAt(i_bl_report_Jw_titulos_cld);
                codigo_reg       = t_jw_titulos_cld.getCodigo_reg()==null?"":t_jw_titulos_cld.getCodigo_reg();
                nome_regional    = t_jw_titulos_cld.getNome_regional()==null?"":t_jw_titulos_cld.getNome_regional();
                codigo_analista  = t_jw_titulos_cld.getCodigo_analista()==null?"":t_jw_titulos_cld.getCodigo_analista();
                nome_analista    = t_jw_titulos_cld.getNome_analista()==null?"":t_jw_titulos_cld.getNome_analista();
                rep_cdgo         = t_jw_titulos_cld.getRep_cdgo()==null?"":t_jw_titulos_cld.getRep_cdgo();
                rep_rzao         = t_jw_titulos_cld.getRep_rzao()==null?"":t_jw_titulos_cld.getRep_rzao();
                cli_cdgo         = t_jw_titulos_cld.getCli_cdgo()==null?"":t_jw_titulos_cld.getCli_cdgo();
                cli_rzao         = t_jw_titulos_cld.getCli_rzao()==null?"":t_jw_titulos_cld.getCli_rzao();
                titulo           = t_jw_titulos_cld.getTitulo()==null?"":t_jw_titulos_cld.getTitulo();
                data_venc        = (java.sql.Timestamp)t_jw_titulos_cld.getData_venc();
                data_emissao     = (java.sql.Timestamp)t_jw_titulos_cld.getData_emissao();
                valor_cld        = t_jw_titulos_cld.getValor_cld();
                vlpcp            = t_jw_titulos_cld.getVlpcp();
                vldeb            = t_jw_titulos_cld.getVldeb();
                saldo            = t_jw_titulos_cld.getSaldo();
                recebido         = vlpcp + vldeb;

                while (i_bl_report_Jw_titulos_cld<res_Jw_titulos_cld.size()){
                  counterbl_report_Jw_titulos_cld++;
                  %>
                  <table id="TRbl_report_Jw_titulos_cld" class="reportTable" style=width:99%;  border=1  frame=box>
                    <tr class="reportHeader3" >
                      <td colspan=6>
                        <big>
                          Regional :
                          <%= codigo_reg %>
                          -
                          <%= nome_regional %>
                        </big>
                      </td>
                    </tr>
                    <%
                    b0_codigo_reg = codigo_reg;
                    while (i_bl_report_Jw_titulos_cld<res_Jw_titulos_cld.size() &&  (b0_codigo_reg==null?"":b0_codigo_reg).equals((codigo_reg==null?"":codigo_reg))){
                      counterbl_report_Jw_titulos_cld++;
                      %>
                      <table id="TRbl_report_Jw_titulos_cld" class="reportTable" style=width:99%;  border=1  frame=box>
                        <tr class="reportHeader3" >
                          <td colspan=6>
                            Analista :
                            <%= codigo_analista %>
                            -
                            <%= nome_analista %>
                          </td>
                        </tr>
                        <%
                        b1_codigo_analista = codigo_analista;
                        while (i_bl_report_Jw_titulos_cld<res_Jw_titulos_cld.size() &&  (b0_codigo_reg==null?"":b0_codigo_reg).equals((codigo_reg==null?"":codigo_reg)) &&  (b1_codigo_analista==null?"":b1_codigo_analista).equals((codigo_analista==null?"":codigo_analista))){
                          counterbl_report_Jw_titulos_cld++;
                          %>
                          <table id="TRbl_report_Jw_titulos_cld" class="reportTable" style=width:99%;  border=1  frame=box>
                            <tr class="reportHeader2" >
                              <td colspan=6>
                                Representante :
                                <%= rep_cdgo %>
                                -
                                <%= rep_rzao %>
                              </td>
                            </tr>
                            <%
                            b2_rep_cdgo = rep_cdgo;
                            while (i_bl_report_Jw_titulos_cld<res_Jw_titulos_cld.size() &&  (b0_codigo_reg==null?"":b0_codigo_reg).equals((codigo_reg==null?"":codigo_reg)) &&  (b1_codigo_analista==null?"":b1_codigo_analista).equals((codigo_analista==null?"":codigo_analista)) &&  (b2_rep_cdgo==null?"":b2_rep_cdgo).equals((rep_cdgo==null?"":rep_cdgo))){
                              counterbl_report_Jw_titulos_cld++;
                              %>
                              <tr class="reportHeader" >
                                <td colspan=6>
                                  Cliente :
                                  <%= cli_cdgo %>
                                  -
                                  <%= cli_rzao %>
                                </td>
                              </tr>
                              <%
                              b3_cli_cdgo = cli_cdgo;
                              %>
                              <tr class="reportHeader" >
                                <td class="columnTdHeader" style="text-align:left;">
                                  Títulos
                                </td>
                                <td class="columnTdHeader" style="text-align:center;">
                                  Emissão
                                </td>
                                <td class="columnTdHeader" style="text-align:center;">
                                  Vencimento
                                </td>
                                <td class="columnTdHeader" style="text-align:right;">
                                  Valor
                                </td>
                                <td class="columnTdHeader" style="text-align:right;">
                                  Recebido
                                </td>
                                <td class="columnTdHeader" style="text-align:right;">
                                  Saldo
                                </td>
                              </tr>
                              <%
                              while (i_bl_report_Jw_titulos_cld<res_Jw_titulos_cld.size() &&  (b0_codigo_reg==null?"":b0_codigo_reg).equals((codigo_reg==null?"":codigo_reg)) &&  (b1_codigo_analista==null?"":b1_codigo_analista).equals((codigo_analista==null?"":codigo_analista)) &&  (b2_rep_cdgo==null?"":b2_rep_cdgo).equals((rep_cdgo==null?"":rep_cdgo)) &&  (b3_cli_cdgo==null?"":b3_cli_cdgo).equals((cli_cdgo==null?"":cli_cdgo))){
                                counterbl_report_Jw_titulos_cld++;
                                String style="";
                                if (!((i_bl_report_Jw_titulos_cld%2)!=0)) {
                                  style="class=rowColor";
                                } else {
                                  style="class=rowBlank";
                                }
                                //---------------
                                total_cliente_valor_cld        += valor_cld;
                                total_cliente_vlpcp            += vlpcp;
                                total_cliente_vldeb            += vldeb;
                                total_cliente_saldo            += saldo;
                                total_representante_valor_cld  += valor_cld;
                                total_representante_vlpcp      += vlpcp;
                                total_representante_vldeb      += vldeb;
                                total_representante_saldo      += saldo;
                                total_regional_valor_cld       += valor_cld;
                                total_regional_vlpcp           += vlpcp;
                                total_regional_vldeb           += vldeb;
                                total_regional_saldo           += saldo;
                                //---------------
                                %>
                                <tr <%= style %> id='TRbl_report_Jw_titulos_cld<%=counterbl_report_Jw_titulos_cld%>' >
                                  <td class="reportColumn" style="text-align:left;width:220;">
                                    <%= titulo %>
                                  </td>
                                  <td class="reportColumn" style="text-align:center;">
                                    <%= com.egen.util.text.FormatDate.format(data_emissao, "dd/MM/yyyy") %>
                                  </td>
                                  <td class="reportColumn" style="text-align:center;">
                                    <%= com.egen.util.text.FormatDate.format(data_venc, "dd/MM/yyyy") %>
                                  </td>
                                  <td class="reportColumn" style="text-align:right;width:150;">
                                    <%= com.egen.util.text.FormatNumber.format(valor_cld, "##,##0.00") %>
                                  </td>
                                  <td class="reportColumn" style="text-align:right;width:150;">
                                    <%= com.egen.util.text.FormatNumber.format(recebido, "##,##0.00") %>
                                  </td>
                                  <td class="reportColumn" style="text-align:right;width:150;">
                                    <%= com.egen.util.text.FormatNumber.format(saldo, "##,##0.00") %>
                                  </td>
                                </tr>
                                <%
                                if (++i_bl_report_Jw_titulos_cld >= res_Jw_titulos_cld.size()) {
                                  break;
                                }
                                t_jw_titulos_cld = (portalbr.dbobj.view.Jw_titulos_cld)res_Jw_titulos_cld.elementAt(i_bl_report_Jw_titulos_cld);
                                codigo_reg       = t_jw_titulos_cld.getCodigo_reg()==null?"":t_jw_titulos_cld.getCodigo_reg();
                                nome_regional    = t_jw_titulos_cld.getNome_regional()==null?"":t_jw_titulos_cld.getNome_regional();
                                codigo_analista  = t_jw_titulos_cld.getCodigo_analista()==null?"":t_jw_titulos_cld.getCodigo_analista();
                                nome_analista    = t_jw_titulos_cld.getNome_analista()==null?"":t_jw_titulos_cld.getNome_analista();
                                rep_cdgo         = t_jw_titulos_cld.getRep_cdgo()==null?"":t_jw_titulos_cld.getRep_cdgo();
                                rep_rzao         = t_jw_titulos_cld.getRep_rzao()==null?"":t_jw_titulos_cld.getRep_rzao();
                                cli_cdgo         = t_jw_titulos_cld.getCli_cdgo()==null?"":t_jw_titulos_cld.getCli_cdgo();
                                cli_rzao         = t_jw_titulos_cld.getCli_rzao()==null?"":t_jw_titulos_cld.getCli_rzao();
                                titulo           = t_jw_titulos_cld.getTitulo()==null?"":t_jw_titulos_cld.getTitulo();
                                data_venc        = (java.sql.Timestamp)t_jw_titulos_cld.getData_venc();
                                data_emissao     = (java.sql.Timestamp)t_jw_titulos_cld.getData_emissao();
                                valor_cld        = t_jw_titulos_cld.getValor_cld();
                                vlpcp            = t_jw_titulos_cld.getVlpcp();
                                vldeb            = t_jw_titulos_cld.getVldeb();
                                saldo            = t_jw_titulos_cld.getSaldo();
                                recebido         = vlpcp + vldeb;
                              }
                              %>
                              <tr>
                                <td colspan=3; style="text-align:right">
                                  <b>
                                    Total do Cliente :
                                  </b>
                                </td>
                                <td class="reportColumn" style="text-align:right;width:150;">
                                  <%= com.egen.util.text.FormatNumber.format(total_cliente_valor_cld, "##,##0.00") %>
                                </td>
                                <td class="reportColumn" style="text-align:right;width:150;">
                                  <%= com.egen.util.text.FormatNumber.format(total_cliente_vlpcp + total_cliente_vldeb, "##,##0.00") %>
                                </td>
                                <td class="reportColumn" style="text-align:right;width:150;">
                                  <%= com.egen.util.text.FormatNumber.format(total_cliente_saldo, "##,##0.00") %>
                                </td>
                              </tr>
                              <%
                              total_cliente_valor_cld = 0;
                              total_cliente_vlpcp     = 0;
                              total_cliente_vldeb     = 0;
                              total_cliente_saldo     = 0;
                            }
                            %>
                            <tr>
                              <td colspan=3; style="text-align:right">
                                <b>
                                  Total do Representante :
                                </b>
                              </td>
                              <td class="reportColumn" style="text-align:right;width:150;">
                                <%= com.egen.util.text.FormatNumber.format(total_representante_valor_cld, "##,##0.00") %>
                              </td>
                              <td class="reportColumn" style="text-align:right;width:150;">
                                <%= com.egen.util.text.FormatNumber.format(total_representante_vlpcp + total_representante_vldeb , "##,##0.00") %>
                              </td>
                              <td class="reportColumn" style="text-align:right;width:150;">
                                <%= com.egen.util.text.FormatNumber.format(total_representante_saldo, "##,##0.00") %>
                              </td>
                            </tr>
                            <%
                            total_representante_valor_cld = 0;
                            total_representante_vlpcp     = 0;
                            total_representante_vldeb     = 0;
                            total_representante_saldo     = 0;

                          }
                        }
                        %>
                        <tr>
                          <td colspan=3; style="text-align:right">
                            <b>
                              Total da Regional :
                            </b>
                          </td>
                          <td class="reportColumn" style="text-align:right;width:150;">
                            <b>
                              <%= com.egen.util.text.FormatNumber.format(total_regional_valor_cld, "##,##0.00") %>
                            </b>
                          </td>
                          <td class="reportColumn" style="text-align:right;width:150;">
                            <b>
                              <%= com.egen.util.text.FormatNumber.format(total_regional_vlpcp + total_regional_vldeb, "##,##0.00") %>
                            </b>
                          </td>
                          <td class="reportColumn" style="text-align:right;width:150;">
                            <b>
                              <%= com.egen.util.text.FormatNumber.format(total_regional_saldo, "##,##0.00") %>
                            </b>
                          </td>
                        </tr>
                        <%
                        total_regional_valor_cld = 0;
                        total_regional_vlpcp     = 0;
                        total_regional_vldeb     = 0;
                        total_regional_saldo     = 0;
                        %>
                        <table>
                          <tr>
                            <td>
                              <br>
                              <br>
                              <br>
                              <br>
                              <br>
                            </td>
                          </tr>
                        </table>
                        <%
                      }

                    }
                  }
                  %>
                </table>
                <html:form action="adm/TitulosCLD_rForm.do" method="post" styleClass="baseForm">
                  <table class="buttonTable" style='width:;'>
                    <tr class="buttonTr">
                      <td class="buttonTd">
                        <html:button onclick="history.go(-1);" styleClass="baseButton" property="back_action">
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
