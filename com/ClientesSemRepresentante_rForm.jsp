<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Clientes Ativos Sem Representante
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
            portalbr.com.ClientesSemRepresentante_rActionForm ClientesSemRepresentante_rActionForm = (portalbr.com.ClientesSemRepresentante_rActionForm)session.getAttribute("ClientesSemRepresentante_rActionForm");
            if(ClientesSemRepresentante_rActionForm.getEstado().equals("1")){

              int counterbl_report_Jw_clientes_sem_representante=0;
              {
                portalbr.dbobj.view.Jw_clientes_sem_representante t_jw_clientes_sem_representante = new portalbr.dbobj.view.Jw_clientes_sem_representante();
                java.util.Vector res_Jw_clientes_sem_representante = (java.util.Vector)session.getAttribute("res_Jw_clientes_sem_representante");
                if (res_Jw_clientes_sem_representante!=null && res_Jw_clientes_sem_representante.size()>0) {
                  java.lang.String uf         =  null;
                  java.lang.String est_descri =  null;
                  java.lang.String cli_cdgo   =  null;
                  java.lang.String esc_seqn   =  null;
                  java.lang.String cli_rzao   =  null;
                  java.lang.String endereco   =  null;
                  java.lang.String ecl_cdad   =  null;
                  java.lang.String bairro     =  null;
                  java.lang.String cep        =  null;
                  java.lang.String email      =  null;
                  int i_bl_report_Jw_clientes_sem_representante = 0;
                  t_jw_clientes_sem_representante = (portalbr.dbobj.view.Jw_clientes_sem_representante)res_Jw_clientes_sem_representante.elementAt(i_bl_report_Jw_clientes_sem_representante);
                  uf = t_jw_clientes_sem_representante.getUf()==null?"":t_jw_clientes_sem_representante.getUf();
                  est_descri = t_jw_clientes_sem_representante.getEst_descri()==null?"":t_jw_clientes_sem_representante.getEst_descri();
                  cli_cdgo   = t_jw_clientes_sem_representante.getCli_cdgo()==null?"":t_jw_clientes_sem_representante.getCli_cdgo();
                  esc_seqn   = t_jw_clientes_sem_representante.getEsc_seqn()==null?"":t_jw_clientes_sem_representante.getEsc_seqn();
                  cli_rzao   = t_jw_clientes_sem_representante.getCli_rzao()==null?"":t_jw_clientes_sem_representante.getCli_rzao();
                  endereco   = t_jw_clientes_sem_representante.getEndereco()==null?"":t_jw_clientes_sem_representante.getEndereco();
                  ecl_cdad   = t_jw_clientes_sem_representante.getEcl_cdad()==null?"":t_jw_clientes_sem_representante.getEcl_cdad();
                  bairro     = t_jw_clientes_sem_representante.getBairro()==null?"":t_jw_clientes_sem_representante.getBairro();
                  cep        = t_jw_clientes_sem_representante.getCep()==null?"":t_jw_clientes_sem_representante.getCep();
                  email      = t_jw_clientes_sem_representante.getEmail()==null?"":t_jw_clientes_sem_representante.getEmail();
                  java.lang.String b0_uf =  null;
                  while (i_bl_report_Jw_clientes_sem_representante<res_Jw_clientes_sem_representante.size()){
                    counterbl_report_Jw_clientes_sem_representante++;
                    %>
                    <table id="TRbl_report_Jw_clientes_sem_representante" class="reportTable" style=width:99%;  border=1  frame=box>
                      <tr class="reportHeader2" >
                        <td colspan=8>
                          <big>
                            <%= est_descri %>
                          </big>
                        </td>
                      </tr>
                      <%
                      b0_uf = uf;
                      %>
                      <tr class="reportHeader" >
                        <td class="columnTdHeader" style="text-align:left;" width="10%">
                          Código
                        </td>
                        <td class="columnTdHeader" style="text-align:left;" width="30%">
                          Razão Social
                        </td>
                        <td class="columnTdHeader" style="text-align:left;" width="20%">
                          Endereço
                        </td>
                        <td class="columnTdHeader" style="text-align:left;" width="15%">
                          Bairro
                        </td>
                        <td class="columnTdHeader" style="text-align:left;" width="17%">
                          Cidade
                        </td>
                        <td class="columnTdHeader" style="text-align:left;" width="8%">
                          CEP
                        </td>
                      </tr>
                      <%
                      while (i_bl_report_Jw_clientes_sem_representante<res_Jw_clientes_sem_representante.size() &&  (b0_uf==null?"":b0_uf).equals((uf==null?"":uf))){
                        counterbl_report_Jw_clientes_sem_representante++;
                        String style="";
                        if (!((i_bl_report_Jw_clientes_sem_representante%2)!=0)) {
                          style="class=rowColor";
                        } else {
                          style="class=rowBlank";
                        }
                        %>
                        <tr <%= style %> id='TRbl_report_Jw_clientes_sem_representante<%=counterbl_report_Jw_clientes_sem_representante%>' >
                          <td class="reportColumn" style="text-align:left;" width="10%">
                            <%= cli_cdgo %>
                            -
                            <%= esc_seqn %>
                          </td>
                          <td class="reportColumn" style="text-align:left;" width="30%">
                            <%= cli_rzao %>
                          </td>
                          <td class="reportColumn" style="text-align:left;" width="20%">
                            <%= endereco %>
                          </td>
                          <td class="reportColumn" style="text-align:left;" width="15%">
                            <%= bairro %>
                          </td>
                          <td class="reportColumn" style="text-align:left;" width="17%">
                            <%= ecl_cdad %>
                          </td>
                          <td class="reportColumn" style="text-align:left;" width="7%">
                            <%= cep %>
                          </td>
                        </tr>
                        <%
                        if (++i_bl_report_Jw_clientes_sem_representante >= res_Jw_clientes_sem_representante.size()) {
                          break;
                        }
                        t_jw_clientes_sem_representante = (portalbr.dbobj.view.Jw_clientes_sem_representante)res_Jw_clientes_sem_representante.elementAt(i_bl_report_Jw_clientes_sem_representante);
                        uf = t_jw_clientes_sem_representante.getUf()==null?"":t_jw_clientes_sem_representante.getUf();
                        est_descri = t_jw_clientes_sem_representante.getEst_descri()==null?"":t_jw_clientes_sem_representante.getEst_descri();
                        cli_cdgo   = t_jw_clientes_sem_representante.getCli_cdgo()==null?"":t_jw_clientes_sem_representante.getCli_cdgo();
                        esc_seqn   = t_jw_clientes_sem_representante.getEsc_seqn()==null?"":t_jw_clientes_sem_representante.getEsc_seqn();
                        cli_rzao   = t_jw_clientes_sem_representante.getCli_rzao()==null?"":t_jw_clientes_sem_representante.getCli_rzao();
                        endereco   = t_jw_clientes_sem_representante.getEndereco()==null?"":t_jw_clientes_sem_representante.getEndereco();
                        ecl_cdad   = t_jw_clientes_sem_representante.getEcl_cdad()==null?"":t_jw_clientes_sem_representante.getEcl_cdad();
                        bairro     = t_jw_clientes_sem_representante.getBairro()==null?"":t_jw_clientes_sem_representante.getBairro();
                        cep        = t_jw_clientes_sem_representante.getCep()==null?"":t_jw_clientes_sem_representante.getCep();
                        email      = t_jw_clientes_sem_representante.getEmail()==null?"":t_jw_clientes_sem_representante.getEmail();
                      }
                    }
                    %>
                  </table>
                  <%
                }
              }

            }
            %>

          </table>
          <%
          //  portalbr.com.ClientesSemRepresentante_rActionForm ClientesSemRepresentante_rActionForm = (portalbr.com.ClientesSemRepresentante_rActionForm)session.getAttribute("ClientesSemRepresentante_rActionForm");
          if(ClientesSemRepresentante_rActionForm.getEstado().equals("0")){
            %>

            <table id="TRbl_report_Jw_clientes_sem_representante_1" class="reportTable" style=width:99%;  border=1  frame=box>
              <%
              int counterbl_report_Jw_clientes_sem_representante_1=0;
              {
                portalbr.dbobj.view.Jw_clientes_sem_representante t_jw_clientes_sem_representante = new portalbr.dbobj.view.Jw_clientes_sem_representante();
                java.util.Vector res_Jw_clientes_sem_representante = (java.util.Vector)session.getAttribute("res_Jw_clientes_sem_representante");
                if (res_Jw_clientes_sem_representante!=null && res_Jw_clientes_sem_representante.size()>0) {
                  java.lang.String cli_cdgo1 =  null;
                  java.lang.String esc_seqn1 =  null;
                  java.lang.String cli_rzao1 =  null;
                  java.lang.String endereco1 =  null;
                  java.lang.String ecl_cdad1 =  null;
                  java.lang.String uf1 =  null;
                  java.lang.String bairro1 =  null;
                  java.lang.String cep1 =  null;
                  int i_bl_report_Jw_clientes_sem_representante_1 = 0;
                  t_jw_clientes_sem_representante = (portalbr.dbobj.view.Jw_clientes_sem_representante)res_Jw_clientes_sem_representante.elementAt(i_bl_report_Jw_clientes_sem_representante_1);
                  cli_cdgo1 = t_jw_clientes_sem_representante.getCli_cdgo()==null?"":t_jw_clientes_sem_representante.getCli_cdgo();
                  esc_seqn1 = t_jw_clientes_sem_representante.getEsc_seqn()==null?"":t_jw_clientes_sem_representante.getEsc_seqn();
                  cli_rzao1 = t_jw_clientes_sem_representante.getCli_rzao()==null?"":t_jw_clientes_sem_representante.getCli_rzao();
                  endereco1 = t_jw_clientes_sem_representante.getEndereco()==null?"":t_jw_clientes_sem_representante.getEndereco();
                  ecl_cdad1 = t_jw_clientes_sem_representante.getEcl_cdad()==null?"":t_jw_clientes_sem_representante.getEcl_cdad();
                  uf1 = t_jw_clientes_sem_representante.getUf()==null?"":t_jw_clientes_sem_representante.getUf();
                  bairro1 = t_jw_clientes_sem_representante.getBairro()==null?"":t_jw_clientes_sem_representante.getBairro();
                  cep1 = t_jw_clientes_sem_representante.getCep()==null?"":t_jw_clientes_sem_representante.getCep();
                  %>
                  <tr class="reportHeader" >
                    <td class="columnTdHeader" style="text-align:left;">
                      Código
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Razão Social
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Endereço
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Bairro
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Cidade/UF
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      CEP
                    </td>
                  </tr>
                  <%
                  while (i_bl_report_Jw_clientes_sem_representante_1<res_Jw_clientes_sem_representante.size()){
                    counterbl_report_Jw_clientes_sem_representante_1++;
                    String style="";
                    if (!((i_bl_report_Jw_clientes_sem_representante_1%2)!=0)) {
                      style="class=rowColor";
                    } else {
                      style="class=rowBlank";
                    }
                    %>
                    <tr <%= style %> id='TRbl_report_Jw_clientes_sem_representante_1<%=counterbl_report_Jw_clientes_sem_representante_1%>' >
                      <td class="reportColumn" style="text-align:left;">
                        <%= cli_cdgo1 %>
                        -
                        <%= esc_seqn1 %>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <%= cli_rzao1 %>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <%= endereco1 %>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <%= bairro1 %>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <%= ecl_cdad1 %>
                        -
                        <%= uf1 %>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <%= cep1 %>
                      </td>
                    </tr>
                    <%
                    if (++i_bl_report_Jw_clientes_sem_representante_1 >= res_Jw_clientes_sem_representante.size()) {
                      break;
                    }
                    t_jw_clientes_sem_representante = (portalbr.dbobj.view.Jw_clientes_sem_representante)res_Jw_clientes_sem_representante.elementAt(i_bl_report_Jw_clientes_sem_representante_1);
                    cli_cdgo1 = t_jw_clientes_sem_representante.getCli_cdgo()==null?"":t_jw_clientes_sem_representante.getCli_cdgo();
                    esc_seqn1 = t_jw_clientes_sem_representante.getEsc_seqn()==null?"":t_jw_clientes_sem_representante.getEsc_seqn();
                    cli_rzao1 = t_jw_clientes_sem_representante.getCli_rzao()==null?"":t_jw_clientes_sem_representante.getCli_rzao();
                    endereco1 = t_jw_clientes_sem_representante.getEndereco()==null?"":t_jw_clientes_sem_representante.getEndereco();
                    ecl_cdad1 = t_jw_clientes_sem_representante.getEcl_cdad()==null?"":t_jw_clientes_sem_representante.getEcl_cdad();
                    uf1 = t_jw_clientes_sem_representante.getUf()==null?"":t_jw_clientes_sem_representante.getUf();
                    bairro1 = t_jw_clientes_sem_representante.getBairro()==null?"":t_jw_clientes_sem_representante.getBairro();
                    cep1 = t_jw_clientes_sem_representante.getCep()==null?"":t_jw_clientes_sem_representante.getCep();
                  }
                }
              }
              %>
            </table>
            <%
          }
          %>
          <html:form action="com/ClientesSemRepresentante_rForm.do" method="post" styleClass="baseForm">
            <table class="itemTable"  style=" width:;">
              <html:hidden property="estado"/>
              <table class="buttonTable" style='width:99%;'>
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
