<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Agenda de Visitas
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
                  <%@ include file="../system/header.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(60)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/AgendaVisitasClientesForm.do" method="post" styleClass="baseForm" target="_self">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="agvi_rep_cdgo"/>
                    <html:errors property="rep_rzao"/>
                    <html:errors property="agvi_dt_inicial"/>
                    <html:errors property="agvi_dt_final"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_agenda_visitas_clientes"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Representante
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="agvi_rep_cdgo" styleClass="disabled" tabindex="-1" readonly="true" value="<%= request.getParameter("agvi_rep_cdgo") %>" size="5" maxlength="5"/>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="rep_rzao" styleClass="disabled" tabindex="-1" readonly="true" value="<%= request.getParameter("rep_rzao") %>" size="40"/>
                  </td>
                </tr>

                <html:hidden property="agvc_id"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data Inicial
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="agvi_dt_inicial" onkeypress="FormataData(this,event);" styleClass="baseField" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['agvi_dt_inicial']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data Final
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="agvi_dt_final" onkeypress="FormataData(this,event);" styleClass="baseField" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['agvi_dt_final']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <html:hidden property="agvi_id"/>
                <html:hidden property="agvc_agvi_id"/>
                <html:hidden property="pos"/>
                <html:hidden property="agvc_dt_exclusao"/>
              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="u" styleClass="baseButton" property="update_action">
                      <bean:message bundle="ApplicationResources" key="jsp.update"/>
                    </html:submit>
                    <html:submit value="Inserir Visita" styleClass="baseButton" property="insert_action">
                    </html:submit>
                    <html:submit accesskey="b" styleClass="baseButton" property="back_action">
                      <bean:message bundle="ApplicationResources" key="jsp.back"/>
                    </html:submit>
                    <html:submit accesskey="s" styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit styleClass="myhidden" property="delete_action">
                      <bean:message bundle="ApplicationResources" key="jsp.delete"/>
                    </html:submit>
                  </td>
                </tr>
              </table>

            </html:form>
            <script type="text/javascript">
              var focusControl = document.forms[0].elements["agvi_dt_inicial"];
              if (focusControl.type != "hidden"){
                focusControl.focus();
              }
            </script>

            <table id="TRbl_report_Jw_agenda_visitas_clientes" class="reportTable" style=width:99%;  border=1  frame=box>
              <%
              int counterbl_report_Jw_agenda_visitas_clientes=0;
              {
                portalbr.dbobj.view.Jw_agenda_visitas_clientes t_jw_agenda_visitas_clientes = new portalbr.dbobj.view.Jw_agenda_visitas_clientes();
                portalbr.com.AgendaVisitasClientesActionForm AgendaVisitasClientesActionForm = (portalbr.com.AgendaVisitasClientesActionForm)session.getAttribute("AgendaVisitasClientesActionForm");
                java.util.Vector res_Jw_agenda_visitas_clientes = (java.util.Vector)session.getAttribute("res_Jw_agenda_visitas_clientes");
                if (res_Jw_agenda_visitas_clientes!=null && res_Jw_agenda_visitas_clientes.size()>0) {
                  java.lang.Integer agvc_id           =  null;
                  java.lang.Integer agvc_agvi_id      =  null;
                  java.lang.Integer agvc_cli_cdgo     =  null;
                  java.lang.String cli_rzao           =  null;
                  java.lang.Integer agvc_esc_seqn     =  null;
                  java.lang.String agvc_tipo          =  null;
                  java.sql.Timestamp agvc_dt_exclusao =  null;
                  java.lang.String motivo             =  null;
                  java.lang.String excluir            =  null;
                  int i_bl_report_Jw_agenda_visitas_clientes = 0;

                  t_jw_agenda_visitas_clientes = (portalbr.dbobj.view.Jw_agenda_visitas_clientes)res_Jw_agenda_visitas_clientes.elementAt(i_bl_report_Jw_agenda_visitas_clientes);
                  agvc_id          = t_jw_agenda_visitas_clientes.getAgvc_id();
                  agvc_agvi_id     = t_jw_agenda_visitas_clientes.getAgvc_agvi_id();
                  agvc_cli_cdgo    = t_jw_agenda_visitas_clientes.getAgvc_cli_cdgo();
                  cli_rzao         = t_jw_agenda_visitas_clientes.getCli_rzao()==null?"":t_jw_agenda_visitas_clientes.getCli_rzao();
                  agvc_esc_seqn    = t_jw_agenda_visitas_clientes.getAgvc_esc_seqn();
                  agvc_tipo        = t_jw_agenda_visitas_clientes.getAgvc_tipo()==null?"":t_jw_agenda_visitas_clientes.getAgvc_tipo();
                  agvc_dt_exclusao = (java.sql.Timestamp)t_jw_agenda_visitas_clientes.getAgvc_dt_exclusao();
                  motivo           = t_jw_agenda_visitas_clientes.getMotivo()==null?"":t_jw_agenda_visitas_clientes.getMotivo();
                  excluir          = excluir="<a href=../com/AgendaVisitasClientesForm.do target=_self STYLE=cursor:hand><font color=red style=bold><b>X</b></font></a>";

                  ;
                  %>
                  <tr class="reportHeader" >
                    <td class="columnTdHeader" style="text-align:right;">
                      Cliente
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Motivo
                    </td>
                    <td class="columnTdHeader" style="text-align:center;">
                      Excluir
                    </td>
                  </tr>
                  <%
                  while (i_bl_report_Jw_agenda_visitas_clientes<res_Jw_agenda_visitas_clientes.size()){
                    counterbl_report_Jw_agenda_visitas_clientes++;
                    String style="";
                    if (!((i_bl_report_Jw_agenda_visitas_clientes%2)!=0)) {
                      style="class=rowColor";
                    } else {
                      style="class=rowBlank";
                    }
                    %>
                    <tr <%= style %> id='TRbl_report_Jw_agenda_visitas_clientes<%=counterbl_report_Jw_agenda_visitas_clientes%>' >
                      <td class="reportColumn" style="text-align:right;">
                        <%= ((agvc_cli_cdgo!=null)?agvc_cli_cdgo.toString():"") %>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <%= cli_rzao %>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <%= motivo %>
                      </td>
                      <td class="reportColumn" style="text-align:center;">
                        <a onclick="if(!(confirm('Confirma Exclusão?'))){return false;}" href="../com/AgendaVisitasClientesForm.do?delete_action=&pos=<%=i_bl_report_Jw_agenda_visitas_clientes %>&agvc_id=<%= agvc_id %>&agvc_agvi_id=<%= agvc_agvi_id %>&agvi_rep_cdgo=<%= AgendaVisitasClientesActionForm.getAgvi_rep_cdgo() %>&rep_rzao=<%= AgendaVisitasClientesActionForm.getRep_rzao() %>&agvi_dt_inicial=<%= AgendaVisitasClientesActionForm.getAgvi_dt_inicial() %>&agvi_dt_final=<%= AgendaVisitasClientesActionForm.getAgvi_dt_final() %>" target="_self" STYLE="cursor:hand">
                          <img border=0 src="../img/delete.jpg" name="imagem" onmouseover="this.src='../img/delete_s.jpg'" onmouseout="this.src='../img/delete.jpg'">

                        </td>
                      </tr>
                      <%
                      if (++i_bl_report_Jw_agenda_visitas_clientes >= res_Jw_agenda_visitas_clientes.size()) {
                        break;
                      }
                      t_jw_agenda_visitas_clientes = (portalbr.dbobj.view.Jw_agenda_visitas_clientes)res_Jw_agenda_visitas_clientes.elementAt(i_bl_report_Jw_agenda_visitas_clientes);
                      agvc_id          = t_jw_agenda_visitas_clientes.getAgvc_id();
                      agvc_agvi_id     = t_jw_agenda_visitas_clientes.getAgvc_agvi_id();
                      agvc_cli_cdgo    = t_jw_agenda_visitas_clientes.getAgvc_cli_cdgo();
                      cli_rzao         = t_jw_agenda_visitas_clientes.getCli_rzao()==null?"":t_jw_agenda_visitas_clientes.getCli_rzao();
                      agvc_esc_seqn    = t_jw_agenda_visitas_clientes.getAgvc_esc_seqn();
                      agvc_tipo        = t_jw_agenda_visitas_clientes.getAgvc_tipo()==null?"":t_jw_agenda_visitas_clientes.getAgvc_tipo();
                      agvc_dt_exclusao = (java.sql.Timestamp)t_jw_agenda_visitas_clientes.getAgvc_dt_exclusao();
                      motivo           = t_jw_agenda_visitas_clientes.getMotivo()==null?"":t_jw_agenda_visitas_clientes.getMotivo();
                      excluir          = excluir="<a href=../com/AgendaVisitasClientesForm.do target=_self STYLE=cursor:hand><font color=red style=bold><b>X</b></font></a>";
                      ;
                    }
                  }
                }
                %>
              </table>
            </td>
          </tr>
        </table>

      </body>
    </center>
  </html>
