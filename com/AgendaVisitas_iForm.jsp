<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.scriptcalendar"/>
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

          <html:form action="com/AgendaVisitas_iForm.do" method="post" styleClass="baseForm" target="_self">
            <table class="messageTable" style='width:99%;'>
              <tr class="messageTr" >
                <td class="messageTd">
                  <bean:message key="div.campos*"/>
                  <html:errors property="agvi_rep_cdgo"/>
                  <html:errors property="rep_rzao"/>
                  <html:errors property="agvi_dt_inicial"/>
                  <html:errors property="agvi_dt_final"/>
                  <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Agenda_visitas"/>
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
                <html:hidden property="agvi_id"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Representante
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="agvi_rep_cdgo" styleClass="baseField" size="5" maxlength="5"/>
                    <input type="button" class="lovButton"  value="..."  onclick="javascript:lov_open_agvi_rep_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_agvi_rep_cdgo() {
                        window.open('../lov/LvRepresentanteLov.do?resetfull_action=&returnBlock=0&return0=agvi_rep_cdgo&return1=rep_rzao','','scrollbars=yes,height=510,width=730,top=0,left=0,');
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
                  <bean:message key="jsp.fieldnotnull"/>
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
                  <bean:message key="jsp.fieldnotnull"/>
                </td>
                <td class="formField">
                  <html:text property="agvi_dt_final" styleId="agvi_dt_final" styleClass="baseField" size="10" maxlength="10"/>
                  &nbsp;
                  <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['agvi_dt_final']); cal1.year_scroll = true; cal1.popup();">
                    <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                  </a>
                </td>
              </tr>

              <html:hidden property="agvi_dt_exclusao"/>
              <html:hidden property="codigo_representante" value="<%= codigo_representante %>"/>
              <html:hidden property="regional" value="<%= codigo_regional %>"/>
              <html:hidden property="dt_inicial" value="<%= (String)request.getParameter("dt_inicial") %>"/>
              <html:hidden property="dt_final" value="<%= (String)request.getParameter("dt_final") %>"/>
              <html:hidden property="rep_cdgo" value="<%= (String)request.getParameter("rep_cdgo") %>"/>
            </table>

            <table class="buttonTable" style='width:99%;'>
              <tr class="buttonTr">
                <td class="buttonTd">
                  <html:submit accesskey="i" styleClass="baseButton" property="insert_action">
                    <bean:message bundle="ApplicationResources" key="jsp.insert"/>
                  </html:submit>
                  <html:submit accesskey="r" styleClass="baseButton" property="resetfull_action">
                    <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                  </html:submit>
                  <html:submit accesskey="b" styleClass="baseButton" property="back_action">
                    <bean:message bundle="ApplicationResources" key="jsp.back"/>
                  </html:submit>
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

          </td>
        </tr>
      </table>

    </body>
  </center>
</html>
