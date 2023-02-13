<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Consulta Romaneios Embarque / EDI - Romaneios em Aberto
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

            <table id="TRbl_report_Jw_romaneios_embarque" class="reportTable" style=width:99%;  border=1  frame=box>
              <%
              int counterbl_report_Jw_romaneios_embarque=0;
              {
                portalbr.dbobj.view.Jw_romaneios_embarque t_jw_romaneios_embarque = new portalbr.dbobj.view.Jw_romaneios_embarque();
                java.util.Vector res_Jw_romaneios_embarque = (java.util.Vector)session.getAttribute("res_Jw_romaneios_embarque");
                if (res_Jw_romaneios_embarque!=null && res_Jw_romaneios_embarque.size()>0) {
                  java.lang.String numero = null;
                  java.lang.String qtde_notas = null;
                  java.sql.Date data_emissao = null;
                  java.sql.Timestamp data_finalizacao = null;
                  java.lang.String tra_cdgo = null;
                  java.lang.String tra_nome = null;
                  java.lang.String usuario_inclusao = null;
                  java.lang.String transportadora = null;
                  java.lang.String filial = null;
                  java.lang.String situacao = null;
                  java.sql.Timestamp data_envio = null;
                  int i_bl_report_Jw_romaneios_embarque = 0;
                  t_jw_romaneios_embarque = (portalbr.dbobj.view.Jw_romaneios_embarque)res_Jw_romaneios_embarque.elementAt(i_bl_report_Jw_romaneios_embarque);
                  numero = t_jw_romaneios_embarque.getNumero()==null?"":t_jw_romaneios_embarque.getNumero();
                  qtde_notas = t_jw_romaneios_embarque.getQtde_notas()==null?"":t_jw_romaneios_embarque.getQtde_notas();
                  data_emissao = (java.sql.Date)t_jw_romaneios_embarque.getData_emissao();
                  data_finalizacao = (java.sql.Timestamp)t_jw_romaneios_embarque.getData_finalizacao();
                  tra_cdgo = t_jw_romaneios_embarque.getTra_cdgo()==null?"":t_jw_romaneios_embarque.getTra_cdgo();
                  tra_nome = t_jw_romaneios_embarque.getTra_nome()==null?"":t_jw_romaneios_embarque.getTra_nome();
                  usuario_inclusao = t_jw_romaneios_embarque.getUsuario_inclusao()==null?"":t_jw_romaneios_embarque.getUsuario_inclusao();
                  filial = t_jw_romaneios_embarque.getFilial()==null?"":t_jw_romaneios_embarque.getFilial();
                  situacao = t_jw_romaneios_embarque.getSituacao()==null?"":t_jw_romaneios_embarque.getSituacao();
                  data_envio = (java.sql.Timestamp)t_jw_romaneios_embarque.getData_envio();
                  transportadora = tra_cdgo + " - "+tra_nome;;
                  %>
                  <tr class="reportHeader" >
                    <td class="columnTdHeader" style="text-align:center;">
                      Usuário Inclusão
                    </td>
                    <td class="columnTdHeader" style="text-align:center;">
                      Número
                    </td>
                    <td class="columnTdHeader" style="text-align:center;">
                      Data Emissão
                    </td>
                    <td class="columnTdHeader" style="text-align:center;">
                      Data Finalização
                    </td>
                    <td class="columnTdHeader" style="text-align:center;">
                      Data Envio EDI
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Transportadora
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Filial
                    </td>
                    <td class="columnTdHeader" style="text-align:center;">
                      Situação
                    </td>
                    <td class="columnTdHeader" style="text-align:center;">
                      Qtde. Notas
                    </td>
                    <td class="columnTdHeader" style="text-align:center;">
                      Ver Notas
                    </td>
                    <td class="columnTdHeader" style="text-align:center;">
                      EDI
                    </td>
                  </tr>
                  <%
                  while (i_bl_report_Jw_romaneios_embarque<res_Jw_romaneios_embarque.size()){
                    counterbl_report_Jw_romaneios_embarque++;
                    String style="";
                    if (!((i_bl_report_Jw_romaneios_embarque%2)!=0)) {
                      style="class=rowColor";
                    } else {
                      style="class=rowBlank";
                    }
                    %>
                    <tr <%= style %> id='TRbl_report_Jw_romaneios_embarque<%=counterbl_report_Jw_romaneios_embarque%>' >
                      <td class="reportColumn" style="text-align:center;">
                        <%= usuario_inclusao %>
                      </td>
                      <td class="reportColumn" style="text-align:center;width:10%;">
                        <%= numero %>
                      </td>
                      <td class="reportColumn" style="text-align:center;width:10%;">
                        <%= com.egen.util.text.FormatDate.format(data_emissao, "dd/MM/yyyy") %>
                      </td>
                      <td class="reportColumn" style="text-align:center;width:10%;">
                        <%
                        if(data_finalizacao != null){
                          %>
                          <%= com.egen.util.text.FormatDate.format(data_finalizacao, "dd/MM/yyyy HH:mm:ss") %>
                          <%
                        }else{
                          %>
                          Não Finalizado!
                          <%
                        }
                        %>
                      </td>
                      <td class="reportColumn" style="text-align:center;width:10%;">
                        <%
                        if(data_envio != null){
                          %>
                          <%= com.egen.util.text.FormatDate.format(data_envio, "dd/MM/yyyy HH:mm:ss") %>
                          <%
                        }else{
                          %>
                          Não Enviado!
                          <%
                        }
                        %>
                      </td>
                      <td class="reportColumn" style="text-align:left;width:20%;">
                        <%= transportadora %>
                      </td>
                      <td class="reportColumn" style="text-align:left;width:20%;">
                        <%= filial %>
                      </td>
                      <td class="reportColumn" style="text-align:center;width:10%;">
                        <%= situacao %>
                      </td>
                      <td class="reportColumn" style="text-align:center;width:5%;">
                        <%= qtde_notas %>
                      </td>
                      <td class="reportColumn" style="text-align:center;" width="5%"; title="Ver Notas">
                        <img src="../img/viewmag.png" name="imagem" onmouseover="this.src='../img/viewmag_s.png'" onmouseout="this.src='../img/viewmag.png'" onclick="top.location='../com/ConsultaRomaneiosEmbarqueEDI_nForm.do?select_action=&nro_romaneio_embarque=<%= numero %>'" STYLE="cursor:hand">
                      </td>
                      <td class="reportColumn" style="text-align:center;" width="5%"; title="Ver Notas">
                        <img src="../img/180.gif" name="imagem" onmouseover="this.src='../img/180_s.gif'" onmouseout="this.src='../img/180.gif'" onclick="top.location='../com/BaixaArquivosTransportadorasForm.do?select_action=&codigo=<%= tra_cdgo %>&data_envio=<%= com.egen.util.text.FormatDate.format(data_envio, "dd/MM/yyyy") %>'" STYLE="cursor:hand">
                      </td>
                    </tr>
                    <%
                    if (++i_bl_report_Jw_romaneios_embarque >= res_Jw_romaneios_embarque.size()) {
                      break;
                    }
                    t_jw_romaneios_embarque = (portalbr.dbobj.view.Jw_romaneios_embarque)res_Jw_romaneios_embarque.elementAt(i_bl_report_Jw_romaneios_embarque);
                    numero = t_jw_romaneios_embarque.getNumero()==null?"":t_jw_romaneios_embarque.getNumero();
                    qtde_notas = t_jw_romaneios_embarque.getQtde_notas()==null?"":t_jw_romaneios_embarque.getQtde_notas();
                    data_emissao = (java.sql.Date)t_jw_romaneios_embarque.getData_emissao();
                    data_finalizacao = (java.sql.Timestamp)t_jw_romaneios_embarque.getData_finalizacao();
                    tra_cdgo = t_jw_romaneios_embarque.getTra_cdgo()==null?"":t_jw_romaneios_embarque.getTra_cdgo();
                    tra_nome = t_jw_romaneios_embarque.getTra_nome()==null?"":t_jw_romaneios_embarque.getTra_nome();
                    usuario_inclusao = t_jw_romaneios_embarque.getUsuario_inclusao()==null?"":t_jw_romaneios_embarque.getUsuario_inclusao();
                    filial = t_jw_romaneios_embarque.getFilial()==null?"":t_jw_romaneios_embarque.getFilial();
                    situacao = t_jw_romaneios_embarque.getSituacao()==null?"":t_jw_romaneios_embarque.getSituacao();
                    data_envio = (java.sql.Timestamp)t_jw_romaneios_embarque.getData_envio();
                    transportadora = tra_cdgo + " - "+tra_nome;;
                  }
                }
              }
              %>
            </table>
            <html:form action="com/ConsultaRomaneiosEmbarqueEDI_rForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                  </td>
                </tr>
              </table>

              <table class="buttonTable" style='width:99%;'>
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
