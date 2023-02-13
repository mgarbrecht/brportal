<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/EnvioEdiTransportadorasActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = EnvioEdiTransportadorasActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("tipo","Tipo Geração");
    hashMapLabel.set("data_retroativa","Data Retroativa");
    hashMapLabel.set("fil_filial","Filial");
    hashMapLabel.set("fil_razsoc","");
    hashMapLabel.set("p_erro","");
    var reportColumns = new Array(new Array("transportadora","qtd_notas"));
  </script>
  <bean:message key="page.ajaxscript"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Envio de Edi's para Transportadoras
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(187)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/EnvioEdiTransportadorasForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="tipo"/>
                    <html:errors property="data_retroativa"/>
                    <html:errors property="fil_filial"/>
                    <html:errors property="fil_razsoc"/>
                    <html:errors property="p_erro"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Parametros"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Tipo Geração
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="tipo" styleId="tipo" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="edi">
                        Arquivos EDI
                      </html:option>
                      <html:option styleClass="baseOption" value="uni5">
                        Uni5
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data Retroativa
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="data_retroativa" styleId="data_retroativa" styleClass="baseField" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_retroativa']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Filial
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="fil_filial" styleId="fil_filial" onblur="fillFields(0,new Array('fil_filial'),'EnvioEdiTransportadorasActionForm.getFil_razsoc_Ajax',new Array('fil_razsoc'));" styleClass="baseField" size="4"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_fil_filial()"  >
                    <script type="text/javascript">
                      function lov_open_fil_filial() {
                        window.open('..//lov/LvFilialLov.do?resetfull_action=&returnBlock=0&return0=fil_filial&return1=fil_razsoc','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="fil_razsoc" styleId="fil_razsoc" styleClass="disabled" tabindex="-1" readonly="true" size="50"/>
                  </td>
                </tr>

                <%
                if(session.getAttribute("erro") != null) {
                  %>

                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Aviso:
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="p_erro" styleId="p_erro" styleClass="disabled" tabindex="-1" readonly="true" size="60"/>
                    </td>
                  </tr>

                  <%
                }
                %>
              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:button accesskey="p" onclick="resetfull1_action.disabled=true;bloqueia();this.disabled=true;document.forms[0].execute_action.click();" styleClass="baseButton" property="execute1_action">
                      Enviar
                    </html:button>
                    <script>
                      function getKeySite(keyStroke) {
                        isNetscape=(document.layers);
                        eventChooser = (isNetscape) ? keyStroke.which : event.keyCode;
                        which = String.fromCharCode(eventChooser).toLowerCase();
                        keyBuffer = which;
                        if(eventChooser == 13){
                        if(document.forms[0].execute1_action.disabled==true){return false;}
                        document.forms[0].execute1_action.disabled=true;
                        document.forms[0].resetfull1_action.disabled=true;
                        bloqueia();
                        document.forms[0].execute_action.click();
                      }
                    }
                  </script>
                  <SCRIPT>
                    document.onkeypress = getKeySite;
                    </SCRIPT>
                    <html:button accesskey="l" onclick="resetfull_action.click();" styleClass="baseButton" property="resetfull1_action">
                    <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:button>
                    <html:submit styleClass="myhidden" property="execute_action">
                    <bean:message bundle="ApplicationResources" key="jsp.execute"/>
                    </html:submit>
                    <html:submit styleClass="myhidden" property="resetfull_action">
                    <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                    </td>
                    </tr>
                    </table>

                    <script type="text/javascript">
                    jQuery(document).ready(function($) {
                      $("#data_retroativa").mask("99/99/9999");
                      });
                    </script>
                  </html:form>
                  <%
                  if(session.getAttribute("ok") != null )
                  {
                    %>

                    <%
                    java.util.Vector res_Jw_envio_edi_notas = null;
                    com.egen.util.jdbc.JdbcUtil j = null;
                    try {
                      j = new com.egen.util.jdbc.JdbcUtil();
                      portalbr.dbobj.view.Jw_envio_edi_notas t_jw_envio_edi_notas = new portalbr.dbobj.view.Jw_envio_edi_notas();
                      String[][] select = {{"transportadora",null},{"qtd_notas",null},};
                      Object[][] where = null;
                      String[] groupby =  null;
                      String[] having =  null;
                      String[] order =  null;
                      res_Jw_envio_edi_notas = j.select(t_jw_envio_edi_notas,select,where,groupby,having,order);
                    } catch (Exception e){
                      session.setAttribute("exception",com.egen.util.system.Error.getDescription(e));
                      %>
                      <jsp:forward page="/system/ErrorPage.jsp"/>
                      <%
                    } finally {
                    if(j!=null){j.close();}
                  }
                  %>

                  <form  name="bl_report_Jw_envio_edi_notas" id="bl_report_Jw_envio_edi_notas" class="baseForm" method="post" >
                    <table class="bannerTable" style="width:99%;">
                      <tr class="bannerTr">
                        <td class="bannerTd">
                          Notas
                        </td>
                      </tr>
                    </table>

                    <%
                    if (res_Jw_envio_edi_notas!=null && res_Jw_envio_edi_notas.size()>0) {
                      %>

                      <table id="TRbl_report_Jw_envio_edi_notas"  class="reportTable"   style="width:99%; "  >
                        <%
                        java.lang.String transportadora =  null;
                        double qtd_notas =  0;
                        %>

                        <tr class="reportTr">
                          <td class="columnTdHeader" style="text-align:left;" >
                            Transportadora
                          </td>

                          <td class="columnTdHeader" style="text-align:right;" >
                            Notas
                          </td>

                        </tr>

                        <%
                        int i_bl_report_Jw_envio_edi_notas = 0;
                        while (i_bl_report_Jw_envio_edi_notas<res_Jw_envio_edi_notas.size()) {
                          portalbr.dbobj.view.Jw_envio_edi_notas t_jw_envio_edi_notas = (portalbr.dbobj.view.Jw_envio_edi_notas)res_Jw_envio_edi_notas.elementAt(i_bl_report_Jw_envio_edi_notas);
                          transportadora = t_jw_envio_edi_notas.getTransportadora()==null?"":t_jw_envio_edi_notas.getTransportadora();
                          qtd_notas = t_jw_envio_edi_notas.getQtd_notas();
                          String style_bl_report_Jw_envio_edi_notas="";
                          if (!((i_bl_report_Jw_envio_edi_notas%2)!=0)) {
                            style_bl_report_Jw_envio_edi_notas="rowColor";
                          } else {
                            style_bl_report_Jw_envio_edi_notas="rowBlank";
                          }
                          %>

                          <tr class='<%= style_bl_report_Jw_envio_edi_notas %>' id="TRbl_report_Jw_envio_edi_notas<%=i_bl_report_Jw_envio_edi_notas%>" >
                            <td class="reportColumn" style="text-align:left;" >
                              <%= transportadora %>
                            </td>

                            <td class="reportColumn" style="text-align:right;" >
                              <%= com.egen.util.text.FormatNumber.format(qtd_notas, "0") %>
                            </td>

                          </tr>

                          <%
                          i_bl_report_Jw_envio_edi_notas++;
                          if (i_bl_report_Jw_envio_edi_notas<res_Jw_envio_edi_notas.size()) {
                            t_jw_envio_edi_notas = (portalbr.dbobj.view.Jw_envio_edi_notas)res_Jw_envio_edi_notas.elementAt(i_bl_report_Jw_envio_edi_notas);
                            transportadora = t_jw_envio_edi_notas.getTransportadora()==null?"":t_jw_envio_edi_notas.getTransportadora();
                            qtd_notas = t_jw_envio_edi_notas.getQtd_notas();
                          } else {
                          }
                        }
                        %>

                      </table>

                      <%
                    }
                    %>

                  </form>
                  <%
                }
                %>

              </td>
            </tr>
          </table>

        </body>
      </center>
    </html>
