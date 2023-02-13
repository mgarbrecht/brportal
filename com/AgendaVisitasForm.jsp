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
    <body onload="if(document.forms[0].regional.value!==''){document.forms[0].agvi_rep_cdgo.focus();}if(document.forms[0].codigo_representante.value==''){document.forms[0].agvi_rep_cdgo.focus();}">
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

            <html:form action="com/AgendaVisitasForm.do" method="post" styleClass="baseForm" target="_self">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="agvi_rep_cdgo"/>
                    <html:errors property="rep_rzao"/>
                    <html:errors property="agvi_dt_inicial"/>
                    <html:errors property="agvi_dt_final"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_agenda_visitas"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                String codigo_regional="";
                String codigo_representante="";
                String tipo="";
                acesso.Usuario u = new acesso.Usuario();
                u = (acesso.Usuario)session.getAttribute("User");
                acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
                acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();

                if(!(u.getEntidadeNegocio()==null)){
                  ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();
                  tipoent = (acesso.TipoEntidadeNegocio) ent.getTipoEntidadeNegocio();
                  tipo = tipoent.getTipo()+"";
                  if(tipo.equals("REGIONAL DE VENDA")){
                    codigo_regional = ent.getChave()+"";
                  }
                  if((tipo.equals("REPRESENTANTE COMERCIAL")) || (tipo.equals("REPRESENTANTE EXPORTACAO"))){
                    codigo_representante = ent.getChave()+"";
                  }

                }
                %>
                <%
                if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Representante
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="agvi_rep_cdgo" onblur="if(this.value==''){rep_rzao.value='';}" styleClass="baseField" size="5" maxlength="5"/>
                      <input type="button" class="lovButton"  value="..."  onclick="javascript:lov_open_agvi_rep_cdgo()"  >
                      <script type="text/javascript">
                        function lov_open_agvi_rep_cdgo() {
                          window.open('../lov/LvRepresentante2Lov.jsp?returnBlock=0&return0=agvi_rep_cdgo&return1=rep_rzao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                        }
                      </script>
                      <span class="spamFormLabel">
                      </span>
                      <html:text property="rep_rzao" styleClass="disabled" tabindex="-1" readonly="true" size="40" maxlength="40"/>
                    </td>
                  </tr>

                  <%
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data Inicial
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="agvi_dt_inicial" styleId="agvi_dt_inicial" styleClass="baseField" size="10" maxlength="10"/>
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
                  </td>
                  <td class="formField">
                    <html:text property="agvi_dt_final" styleId="agvi_dt_final" styleClass="baseField" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['agvi_dt_final']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <html:hidden property="codigo_representante" value="<%= codigo_representante %>"/>
                <html:hidden property="regional" value="<%= codigo_regional %>"/>
                <html:hidden property="pos"/>
                <html:hidden property="agvi_id"/>
                <html:hidden property="dt_inicial"/>
                <html:hidden property="dt_final"/>
              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:button accesskey="p" onclick="insert1_action.disabled=true;resetfull1_action.disabled=true;this.disabled=true;document.forms[0].select_action.click();" styleClass="baseButton" property="select1_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:button>
                    <script>
                      function getKeySite(keyStroke) {
                        isNetscape=(document.layers);
                        eventChooser = (isNetscape) ? keyStroke.which : event.keyCode;
                        which = String.fromCharCode(eventChooser).toLowerCase();
                        keyBuffer = which;
                        if(eventChooser == 13){
                        if(document.forms[0].select1_action.disabled==true){return false;}
                        document.forms[0].select1_action.disabled=true;
                        document.forms[0].resetfull1_action.disabled=true;
                        document.forms[0].insert1_action.disabled=true;
                        document.forms[0].select_action.click();
                      }
                    }
                  </script>
                  <SCRIPT>
                    document.onkeypress = getKeySite;
                    </SCRIPT><html:button accesskey="i" value="Inserir Agenda" onclick="insert_action.click();" styleClass="baseButton" property="insert1_action"></html:button>
                    <html:button accesskey="l" onclick="resetfull_action.click();" styleClass="baseButton" property="resetfull1_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:button>
                    <html:submit styleClass="myhidden" property="select_action"><bean:message bundle="ApplicationResources" key="jsp.select"/></html:submit>
                    <html:submit value="Inserir Agenda" styleClass="myhidden" property="insert_action"></html:submit>
                    <html:submit styleClass="myhidden" property="resetfull_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:submit>
                    <html:submit styleClass="myhidden" property="delete_action"><bean:message bundle="ApplicationResources" key="jsp.delete"/></html:submit>
                    </td>
                    </tr>
                    </table>

                    <script type="text/javascript">
                    jQuery(document).ready(function($) {
                      $("#agvi_dt_inicial").mask("99/99/9999");
                      $("#agvi_dt_final").mask("99/99/9999");
                      });
                    </script>
                  </html:form>
                  <script type="text/javascript">
                    var focusControl = document.forms[0].elements["agvi_dt_inicial"];
                    if (focusControl.type != "hidden"){
                      focusControl.focus();
                    }
                  </script>

                  <table id="TRbl_report_Jw_agenda_visitas" class="reportTable" style=width:99%;  border=1  frame=box>
                    <%
                    int counterbl_report_Jw_agenda_visitas=0;
                    {
                      portalbr.dbobj.view.Jw_agenda_visitas t_jw_agenda_visitas = new portalbr.dbobj.view.Jw_agenda_visitas();
                      portalbr.com.AgendaVisitasActionForm AgendaVisitasActionForm = (portalbr.com.AgendaVisitasActionForm)session.getAttribute("AgendaVisitasActionForm");
                      java.util.Vector res_Jw_agenda_visitas = (java.util.Vector)session.getAttribute("res_Jw_agenda_visitas");
                      if (res_Jw_agenda_visitas!=null && res_Jw_agenda_visitas.size()>0) {
                        java.lang.Integer agvi_id           =  null;
                        java.lang.String agvi_rep_cdgo      =  null;
                        java.lang.String rep_rzao           =  null;
                        java.sql.Timestamp agvi_dt_inicial  =  null;
                        java.sql.Timestamp agvi_dt_final    =  null;
                        java.sql.Timestamp agvi_dt_exclusao =  null;
                        int i_bl_report_Jw_agenda_visitas   =  0;
                        t_jw_agenda_visitas = (portalbr.dbobj.view.Jw_agenda_visitas)res_Jw_agenda_visitas.elementAt(i_bl_report_Jw_agenda_visitas);
                        agvi_id          = t_jw_agenda_visitas.getAgvi_id();
                        agvi_rep_cdgo    = t_jw_agenda_visitas.getAgvi_rep_cdgo()==null?"":t_jw_agenda_visitas.getAgvi_rep_cdgo();
                        rep_rzao         = t_jw_agenda_visitas.getRep_rzao()==null?"":t_jw_agenda_visitas.getRep_rzao();
                        agvi_dt_inicial  = (java.sql.Timestamp)t_jw_agenda_visitas.getAgvi_dt_inicial();
                        agvi_dt_final    = (java.sql.Timestamp)t_jw_agenda_visitas.getAgvi_dt_final();
                        agvi_dt_exclusao = (java.sql.Timestamp)t_jw_agenda_visitas.getAgvi_dt_exclusao();
                        %>
                        <tr class="reportHeader" >
                          <td class="columnTdHeader" style="text-align:right;">
                            Representante
                          </td>
                          <td class="columnTdHeader" style="text-align:left;">
                          </td>
                          <td class="columnTdHeader" style="text-align:center;">
                            Data Inicial
                          </td>
                          <td class="columnTdHeader" style="text-align:center;">
                            Data Final
                          </td>
                          <td class="columnTdHeader" style="text-align:center;">
                            Excluir
                          </td>
                        </tr>
                        <%
                        while (i_bl_report_Jw_agenda_visitas<res_Jw_agenda_visitas.size()){
                          counterbl_report_Jw_agenda_visitas++;
                          String style="";
                          if (!((i_bl_report_Jw_agenda_visitas%2)!=0)) {
                            style="class=rowColor";
                          } else {
                            style="class=rowBlank";
                          }
                          %>
                          <tr <%= style %> id='TRbl_report_Jw_agenda_visitas<%=counterbl_report_Jw_agenda_visitas%>' >
                            <td class="reportColumn" style="text-align:right;width:10%;">
                              <%= agvi_rep_cdgo %>
                            </td>
                            <td class="reportColumn" style="text-align:left;" title="Visitas do Representante: <%= rep_rzao %>">
                              <a href="../com/AgendaVisitasClientesForm.do?select_action=&pos=<%=i_bl_report_Jw_agenda_visitas %>&agvi_id=<%= agvi_id %>&agvi_rep_cdgo=<%= agvi_rep_cdgo %>&rep_rzao=<%= rep_rzao %>&agvi_dt_inicial=<%= com.egen.util.text.FormatDate.format(agvi_dt_inicial, "dd/MM/yyyy") %>&agvi_dt_final=<%= com.egen.util.text.FormatDate.format(agvi_dt_final, "dd/MM/yyyy") %>" target="_self" STYLE="cursor:hand">
                                <%= rep_rzao %>
                              </a>
                            </td>
                            <td class="reportColumn" style="text-align:center;">
                              <%= com.egen.util.text.FormatDate.format(agvi_dt_inicial, "dd/MM/yyyy") %>
                            </td>
                            <td class="reportColumn" style="text-align:center;">
                              <%= com.egen.util.text.FormatDate.format(agvi_dt_final, "dd/MM/yyyy") %>
                            </td>
                            <td class="reportColumn" style="text-align:center;">

                              <a onclick="if(!(confirm('Confirma Exclusão?'))){return false;}"  href="../com/AgendaVisitasForm.do?delete_action=&pos=<%=i_bl_report_Jw_agenda_visitas%>&agvi_id=<%= agvi_id %>&agvi_rep_cdgo=<%= AgendaVisitasActionForm.getAgvi_rep_cdgo() %>&rep_rzao=<%= AgendaVisitasActionForm.getRep_rzao() %>&agvi_dt_inicial=<%= AgendaVisitasActionForm.getAgvi_dt_inicial() %>&agvi_dt_final=<%= AgendaVisitasActionForm.getAgvi_dt_final() %>" target=_self STYLE=cursor:hand>
                                <img border=0 src="../img/delete.jpg" name="imagem" onmouseover="this.src='../img/delete_s.jpg'" onmouseout="this.src='../img/delete.jpg'">
                              </a>
                            </td>
                          </tr>
                          <%
                          if (++i_bl_report_Jw_agenda_visitas >= res_Jw_agenda_visitas.size()) {
                            break;
                          }
                          t_jw_agenda_visitas = (portalbr.dbobj.view.Jw_agenda_visitas)res_Jw_agenda_visitas.elementAt(i_bl_report_Jw_agenda_visitas);
                          agvi_id          = t_jw_agenda_visitas.getAgvi_id();
                          agvi_rep_cdgo    = t_jw_agenda_visitas.getAgvi_rep_cdgo()==null?"":t_jw_agenda_visitas.getAgvi_rep_cdgo();
                          rep_rzao         = t_jw_agenda_visitas.getRep_rzao()==null?"":t_jw_agenda_visitas.getRep_rzao();
                          agvi_dt_inicial  = (java.sql.Timestamp)t_jw_agenda_visitas.getAgvi_dt_inicial();
                          agvi_dt_final    = (java.sql.Timestamp)t_jw_agenda_visitas.getAgvi_dt_final();
                          agvi_dt_exclusao = (java.sql.Timestamp)t_jw_agenda_visitas.getAgvi_dt_exclusao();
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
