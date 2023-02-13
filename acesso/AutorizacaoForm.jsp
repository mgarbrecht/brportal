<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page  extends='acesso.web.HttpJspSessao' %>
<html>
  <head>
    <title>
      Autorização
    </title>

    <bean:message key="page.css"/>
    <bean:message key="page.script"/>

<!--
<link rel="StyleSheet" type="text/css" /><script type="text/javascript" src="../script/dtree.js">
<script type="text/javascript" src="../script/jquery-1.4.2.min.js">
-->
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:99%;' >
        <tr>
          <td>
            <table   class="headerTable" style="width:99%" >
              <tr>
                <td class='td10'>
                  <%@ include file="../system/header_sem_ajuda.jsp" %>
                </td>
              </tr>
            </table>

<%
if(!user.isSuperUsuario() && !user.isAutorizado(40)){
   response.sendRedirect("../system/Error.jsp");
}
%>              

            <table class="positionTable" width="100%" border="0">
              <tr class="positionTr">
                
                <td align="left" valign="top" width="0%" >
                  <html:form action="acesso/NavegacaoForm.do" method="POST" styleClass="baseForm">

                  </html:form>
                </td>
                
                <td class="positionTd">
                  <html:form action="acesso/AutorizacaoForm.do" method="POST" styleClass="baseForm" target="_self">
                    <table   style='width:99%;'>
                      <tr>
                        <td class=noHeader>
                        </td>
                      </tr>
                    </table>
                    <table class="messageTable" style='width:99%;'>
                      <tr class="messageTr">
                        <td class="messageTd">
                          <bean:message key="div.campos*"/>
                          <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form"/>
                        </td>
                      </tr>
                    </table>
                    <table class="itemTable" style='width:99%;'>
                    <html:hidden property="id"/>
                      <tr>
                        <td class="formLabel">
                          <span class="spamFormLabel" >
                            Documento
                          </span>
                          <bean:message key="jsp.fieldnotnull"/>
                        </td>
                        <td class="formField">
                          <html:text property="doin_id" onblur="if(this.value==''){doin_nome.value='';}" styleClass="baseField" size="10" maxlength="10"/>
                          <input type="button" class="lovButton" value="..." onclick="window.open('../lov/LvDocumentoInterfaceLov.do?resetfull_action=&returnBlock=1&return0=doin_id&return1=doin_nome','','scrollbars,height=510,width=730,top=0,left=0,')"/>
                          <span class="spamFormLabel" >
                          </span>
                          <html:text property="doin_nome" styleClass="disabled" readonly="true" size="40" maxlength="60"/>
                        </td>
                      </tr>
                      <tr>
                        <td class="formLabel">
                          <span class="spamFormLabel" >
                            Dias Consulta<br>Retroativa
                          </span>
                        </td>
                        <td class="formField">
                          <html:text property="dias_consulta_retroativa" styleClass="baseField" size="5" maxlength="5"/>
                         <span class="spamFormLabel" >
                          </span>
                        </td>
                      </tr>
                      <tr>
                        <td class="formLabel">
                          <span class="spamFormLabel" >
                            Tipo
                          </span>
                        <bean:message key="jsp.fieldnotnull"/>
                        </td>
                        <td class="formField">
                          <html:select property="tipo" onchange="refresh_action.click();" styleClass="baseField" size="1">
                            <html:option styleClass="baseOption" value="1">
                              --Selecione--
                            </html:option>
                            <html:option styleClass="baseOption" value="tipo_entidade">
                              Tipo Entidade
                            </html:option>
                            <html:option styleClass="baseOption" value="entidade">
                              Entidade
                            </html:option>
                            <html:option styleClass="baseOption" value="usuario">
                              Usuário
                            </html:option>
                          </html:select>
                        </td>
                      </tr>
             
                      <%
                      portalbr.acesso.AutorizacaoActionForm autorizacaoActionForm = (portalbr.acesso.AutorizacaoActionForm) session.getAttribute("AutorizacaoActionForm");

                      String tipo  = autorizacaoActionForm.getTipo()+"";

                      if(tipo.equals("usuario")){
                        %>
                        <tr>
                          <td class="formLabel">
                            <span class="spamFormLabel" >
                              Usuário
                            </span>
                            <bean:message key="jsp.fieldnotnull"/>
                          </td>
                          <td class="formField">
                            <html:text property="usua_id" onblur="if(this.value==''){usua_nome.value='';}" styleClass="baseField" size="10" maxlength="10"/>
                            <input type="button" class="lovButton" value="..." onclick="window.open('../lov/LvUsuarioLov.do?resetfull_action=&returnBlock=1&return0=usua_id&return1=usua_nome','','scrollbars,height=510,width=730,top=0,left=0,')"/>
                            <span class="spamFormLabel" >
                            </span>
                            <html:text property="usua_nome" styleClass="disabled" readonly="true" size="40" maxlength="40"/>
                          </td>
                        </tr>
                        <tr>
                          <td class="formLabel">
                            <span class="spamFormLabel" >
                              Negar Acesso
                            </span>
                          </td>
                          <td class="formField">
                            <html:checkbox property="negar_acesso" styleClass="baseField" value="S"/>
                          </td>
                        </tr>
                        <%}  if(tipo.equals("tipo_entidade")){ %>
                          <tr>
                            <td class="formLabel">
                              <span class="spamFormLabel" >
                                Tipo Entidade
                              </span>
                              <bean:message key="jsp.fieldnotnull"/>
                            </td>
                            <td class="formField">
                              <html:text property="tien_id" onblur="if(this.value==''){tien_tipo.value='';}" styleClass="baseField" size="10" maxlength="10"/>
                              <input type="button" class="lovButton" value="..." onclick="window.open('../lov/LvTipoEntidadeNegocioLov.do?resetfull_action=&returnBlock=1&return0=tien_id&return1=tien_tipo','','scrollbars,height=510,width=730,top=0,left=0,')"/>
                              <span class="spamFormLabel" >
                              </span>
                              <html:text property="tien_tipo" styleClass="disabled" readonly="true" size="40"/>
                            </td>
                          </tr>
                          <%}  if(tipo.equals("entidade")){ %>
                            <tr>
                              <td class="formLabel">
                                <span class="spamFormLabel" >
                                  Entidade
                                </span>
                                <bean:message key="jsp.fieldnotnull"/>
                              </td>
                              <td class="formField">
                                <html:text property="enne_id" onblur="if(this.value==''){enne_descricao.value='';}" styleClass="baseField" size="10" maxlength="10"/>
                                <input type="button" class="lovButton" value="..." onclick="window.open('../lov/LvEntidadeNegocioLov.do?resetfull_action=&returnBlock=1&return0=enne_id&return1=enne_descricao','','scrollbars,height=510,width=730,top=0,left=0,')"/>
                                <span class="spamFormLabel" >
                                </span>
                                <html:text property="enne_descricao" styleClass="disabled" readonly="true" size="40" maxlength="255"/>
                              </td>
                            </tr>

                            <% } %>

                            </table>
                            <table class="buttonTable" style='width:99%;'>
                              <tr class="buttonTr">
                                <td class="buttonTd">
                                  <html:submit accesskey="r" styleClass="baseButton" property="refresh_action">
                                     Ver Autorizações
                                  </html:submit>
                                  <html:submit accesskey="p" value="pop" styleClass="myhidden" property="pop_action">
                                  </html:submit>
                                  <html:submit value="Gerar Autorizações" accesskey="g" styleClass="myhidden" property="gerar_action">
                                  </html:submit>
                                  <html:submit accesskey="d" styleClass="myhidden" property="delete_action">
                                    <bean:message bundle="ApplicationResources" key="jsp.delete"/>
                                  </html:submit>
                                  <html:submit accesskey="i" styleClass="baseButton" property="insert_action">
                                    <bean:message bundle="ApplicationResources" key="jsp.insert"/>
                                  </html:submit>
                                  <html:submit accesskey="r" styleClass="baseButton" property="resetfull_action">
                                    <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                                  </html:submit>
                                  <html:button value="Gerar Autorizações" onclick="this.disabled=true;gerar_action.click();" styleClass="baseButton" property="gerar1_action"></html:button>
                                </td>
                              </tr>
                            </table>
<%
 portalbr.dbobj.view.Jw_acessos_usuarios t_usuarios = new portalbr.dbobj.view.Jw_acessos_usuarios();
 portalbr.acesso.AutorizacaoActionForm AutorizacaoActionForm = (portalbr.acesso.AutorizacaoActionForm)session.getAttribute("AutorizacaoActionForm");
 Vector usuarios = null;
 if(AutorizacaoActionForm!=null && (AutorizacaoActionForm.getUsua_id()!=null && AutorizacaoActionForm.getUsua_id().length()>0)) {
   com.egen.util.jdbc.JdbcUtil j = null;
   try {
      j = new com.egen.util.jdbc.JdbcUtil();
      String[][] select =  null;
      Object[][] where = null;
      where = new Object[][] {{"acus_usua_id","=",com.egen.util.text.FormatNumber.toInteger(AutorizacaoActionForm.getUsua_id())}};
      String[] order = {"doin_nome"};
      usuarios = j.select(t_usuarios,select,where,null,null,order);
      } catch (Exception e){
            usuarios = null;
      } finally {
          if(j!=null){
               j.close();
               j = null;
          }
        }
 }


if(usuarios!=null && usuarios.size()>0){

%>
<table class="separatorTable">
  <tr class="separatorTr">
    <td colspan="2" class="separatorTd">
    </td>
  </tr>
                        <tr>
                          <td class="formLabel">
                            <span class="spamFormLabel" >
                              Usuário
                            </span>
                            <bean:message key="jsp.fieldnotnull"/>
                          </td>
                          <td class="formField">
                            <html:text property="usua_id_novo" styleClass="baseField" size="10" maxlength="10"/>
                            <input type="button" class="lovButton" value="..." onclick="window.open('../lov/LvUsuarioLov.do?resetfull_action=&returnBlock=1&return0=usua_id_novo&return1=usua_nome_novo','','scrollbars,height=510,width=730,top=0,left=0,')"/>

                            <span class="spamFormLabel" >
                            </span>
                            <html:text property="usua_nome_novo" styleClass="disabled" readonly="true" size="40" maxlength="40"/>
                            <html:submit value="Copiar Aut." styleClass="baseButton" property="copiar_action" onclick="copiar_action.click();"></html:submit>

                          </td>
                        </tr>
</table>
<% } %>




<%

   portalbr.dbobj.view.Jw_acessos_entidades_negocio t_jw_acessos_entidades_negocio = new portalbr.dbobj.view.Jw_acessos_entidades_negocio();
   java.util.Vector res_Jw_acessos_entidades_negocio = null;
   if(AutorizacaoActionForm!=null && (AutorizacaoActionForm.getEnne_id()!=null && AutorizacaoActionForm.getEnne_id().length()>0)) {
     com.egen.util.jdbc.JdbcUtil j = null;
     try {
       j = new com.egen.util.jdbc.JdbcUtil();
       String[][] select =  null;
       Object[][] where = null;
       where = new Object[][] {{"acen_enne_id","=",com.egen.util.text.FormatNumber.toInteger(AutorizacaoActionForm.getEnne_id())}};
       String[] order = {"doin_nome"};
       res_Jw_acessos_entidades_negocio = j.select(t_jw_acessos_entidades_negocio,select,where,null,null,order);
     } catch (Exception e){
       res_Jw_acessos_entidades_negocio = null;
     } finally {
     if(j!=null){
          j.close();
          j = null;
     }
   }
 } else {
   res_Jw_acessos_entidades_negocio = null;
 }
 if (res_Jw_acessos_entidades_negocio!=null && res_Jw_acessos_entidades_negocio.size()>0) {

%>
<table class="separatorTable">
  <tr class="separatorTr">
    <td colspan="2" class="separatorTd">
    </td>
  </tr>
  <tr>
    <td class="formLabel">
      <span class="spamFormLabel" >
        Entidade
      </span>
      <bean:message key="jsp.fieldnotnull"/>
    </td>
    <td class="formField">
      <html:text property="enne_id_novo" onblur="if(this.value==''){enne_descricao_novo.value='';}" styleClass="baseField" size="10" maxlength="10"/>
      <input type="button" class="lovButton" value="..." onclick="window.open('../lov/LvEntidadeNegocioLov.do?resetfull_action=&returnBlock=1&return0=enne_id_novo&return1=enne_descricao_novo','','scrollbars,height=510,width=730,top=0,left=0,')"/>
      <span class="spamFormLabel" >
      </span>
      <html:text property="enne_descricao_novo" styleClass="disabled" readonly="true" size="40" maxlength="255"/>
            <html:submit value="Copiar Aut." styleClass="baseButton" property="copiar_entidade_action" onclick="copiar_entidade_action.click();"></html:submit>

    </td>
  </tr>
</table>
<% } %>







<%

  portalbr.dbobj.view.Jw_acessos_tipos_entidade_negocio t_jw_acessos_tipos_entidade_negocio = new portalbr.dbobj.view.Jw_acessos_tipos_entidade_negocio();
     java.util.Vector res_Jw_acessos_tipos_entidade_negocio = null;
     if(AutorizacaoActionForm!=null && (AutorizacaoActionForm.getTien_id()!=null && AutorizacaoActionForm.getTien_id().length()>0)) {
       com.egen.util.jdbc.JdbcUtil j = null;
       try {
         j = new com.egen.util.jdbc.JdbcUtil();
         String[][] select =  null;
         Object[][] where = null;
         where = new Object[][] {{"aten_tien_id","=",com.egen.util.text.FormatNumber.toInteger(AutorizacaoActionForm.getTien_id())}};
         String[] order = {"doin_nome"};
         res_Jw_acessos_tipos_entidade_negocio = j.select(t_jw_acessos_tipos_entidade_negocio,select,where,null,null,order);
       } catch (Exception e){
         res_Jw_acessos_tipos_entidade_negocio = null;
       } finally {
       if(j!=null){
            j.close();
            j = null;
       }
     }
   } else {
     res_Jw_acessos_tipos_entidade_negocio = null;
   }
   if (res_Jw_acessos_tipos_entidade_negocio!=null && res_Jw_acessos_tipos_entidade_negocio.size()>0) {

%>
<table class="separatorTable">
  <tr class="separatorTr">
    <td colspan="2" class="separatorTd">
    </td>
  </tr>
   <tr>
     <td class="formLabel">
       <span class="spamFormLabel" >
         Tipo Entidade
       </span>
       <bean:message key="jsp.fieldnotnull"/>
     </td>
     <td class="formField">
       <html:text property="tien_id_novo" onblur="if(this.value==''){tien_tipo_novo.value='';}" styleClass="baseField" size="10" maxlength="10"/>
       <input type="button" class="lovButton" value="..." onclick="window.open('../lov/LvTipoEntidadeNegocioLov.do?resetfull_action=&returnBlock=1&return0=tien_id_novo&return1=tien_tipo_novo','','scrollbars,height=510,width=730,top=0,left=0,')"/>
       <span class="spamFormLabel" >
       </span>
       <html:text property="tien_tipo_novo" styleClass="disabled" readonly="true" size="40"/>
       <html:submit value="Copiar Aut." styleClass="baseButton" property="copiar_tipo_action" onclick="copiar_tipo_action.click();"></html:submit>
     </td>
   </tr>
</table>
<% } %>





                          </html:form>
                          <script type="text/javascript" language="JavaScript">
                            <!--
                            var focusControl = document.forms[1].elements["doin_id"];
                            if (focusControl.type != "hidden") {
                              focusControl.focus();
                            }
                          // -->
                          </script>

                          <%
                          {
                            %>
                            <form class="baseForm" >
                             
                              <table id="TRbl_report_Jw_acessos_entidades_negocio" class="reportTable" style=width:99%; border=1; >
                                <%
                                int counterbl_report_Jw_acessos_entidades_negocio=0;
                                %>
                                <%
                                {
                                  portalbr.dbobj.view.Jw_acessos_entidades_negocio t_jw_acessos_entidades_negocio = new portalbr.dbobj.view.Jw_acessos_entidades_negocio();
                                  java.util.Vector res_Jw_acessos_entidades_negocio = null;
                                  portalbr.acesso.AutorizacaoActionForm AutorizacaoActionForm = (portalbr.acesso.AutorizacaoActionForm)session.getAttribute("AutorizacaoActionForm");
                                  if(AutorizacaoActionForm!=null && (AutorizacaoActionForm.getEnne_id()!=null && AutorizacaoActionForm.getEnne_id().length()>0)) {
                                    com.egen.util.jdbc.JdbcUtil j = null;
                                    try {
                                      j = new com.egen.util.jdbc.JdbcUtil();
                                      String[][] select =  null;
                                      Object[][] where = null;
                                      where = new Object[][] {{"acen_enne_id","=",com.egen.util.text.FormatNumber.toInteger(AutorizacaoActionForm.getEnne_id())}};
                                      String[] order = {"doin_nome"};
                                      res_Jw_acessos_entidades_negocio = j.select(t_jw_acessos_entidades_negocio,select,where,null,null,order);
                                    } catch (Exception e){
                                      res_Jw_acessos_entidades_negocio = null;

                                    } finally {
                                         if(j!=null){
                                            j.close();
                                            j = null;
                                         }
                                      }
                                } else {
                                  res_Jw_acessos_entidades_negocio = null;
                                }
                                if (res_Jw_acessos_entidades_negocio!=null && res_Jw_acessos_entidades_negocio.size()>0) {
                                  java.lang.Integer acen_id =  null;
                                  java.lang.Integer acen_enne_id =  null;
                                  java.lang.Integer acen_doin_id =  null;
                                  java.lang.Integer acen_dias_consulta_retroativa =  null;
                                  java.lang.String doin_nome =  null;
                                  java.lang.String doin_descricao =  null;
                                  int i_bl_report_Jw_acessos_entidades_negocio = 0;
                                  t_jw_acessos_entidades_negocio = (portalbr.dbobj.view.Jw_acessos_entidades_negocio)res_Jw_acessos_entidades_negocio.elementAt(i_bl_report_Jw_acessos_entidades_negocio);
                                  acen_id = t_jw_acessos_entidades_negocio.getAcen_id();
                                  acen_dias_consulta_retroativa = t_jw_acessos_entidades_negocio.getAcen_dias_consulta_retroativa();
                                  acen_enne_id = t_jw_acessos_entidades_negocio.getAcen_enne_id();
                                  acen_doin_id = t_jw_acessos_entidades_negocio.getAcen_doin_id();
                                  doin_nome = t_jw_acessos_entidades_negocio.getDoin_nome()==null?"":t_jw_acessos_entidades_negocio.getDoin_nome();
                                  doin_descricao = t_jw_acessos_entidades_negocio.getDoin_descricao()==null?"":t_jw_acessos_entidades_negocio.getDoin_descricao();
                                  %>
                                <tr class="reportHeader2">
                                  <td colspan="100%">
                                     Documentos/Interface
                                  </td>
                                </tr>
                                  <tr class="reportHeader" >
                                    <td class="columnTdHeader" style="text-align:center;" width=1;>
                                       ID 
                                    </td>
                                    <td class="columnTdHeader" style="text-align:left;">
                                      Nome
                                    </td>
                                    <td class="columnTdHeader" style="text-align:left;">
                                       Descrição
                                    </td>
                                    <td class="columnTdHeader" style="text-align:center;">
                                       Dias Retroat.
                                    </td>
                                    <td class="columnTdHeader" style="text-align:center;" width=2; >
                                       Excluir 
                                    </td>

                                  </tr>
                                  <%
                                  while (i_bl_report_Jw_acessos_entidades_negocio<res_Jw_acessos_entidades_negocio.size()){
                                    counterbl_report_Jw_acessos_entidades_negocio++;
                                    String style="";
                                    if (!((i_bl_report_Jw_acessos_entidades_negocio%2)!=0)) {
                                      style="rowColor";
                                    } else {
                                      style="rowBlank";
                                    }
                                    %>
                                    <tr class=<%= style %> id='TRbl_report_Jw_acessos_entidades_negocio<%=counterbl_report_Jw_acessos_entidades_negocio%>' >
                                      <td class="reportColumn" style="text-align:center;">
                                          <%= acen_id %>
                                        </a>
                                      </td>
                                      <td class="reportColumn" style="text-align:left;">
                                           <%= doin_nome %>
                                        </a>
                                      </td>
                                      <td class="reportColumn" style="text-align:left;">
                                         <%= doin_descricao %>
                                      </td>
                                      <td class="columnTdHeader" style="text-align:center;">
                                         <% if(acen_dias_consulta_retroativa!=null){ %>
                                            <%= acen_dias_consulta_retroativa %>
                                         <% } %>
                                      </td>
                                      <td class="reportColumn" style="text-align:center;">
                                         <a  onclick="if(!(confirm('Confirma Exclusão?'))){return false;}"  href="../acesso/AutorizacaoForm.do?delete_action=&id=<%= acen_id %>&tipo=entidade&enne_id=<%= acen_enne_id %>" target=_self STYLE=cursor:hand>
                                             <img border=0 src="../img/delete.jpg" name="imagem" onmouseover="this.src='../img/delete_s.jpg'" onmouseout="this.src='../img/delete.jpg'">
                                         </a>
                                      </td>
                                    </tr>
                                    <%
                                    if (++i_bl_report_Jw_acessos_entidades_negocio >= res_Jw_acessos_entidades_negocio.size()) {
                                      break;
                                    }
                                    t_jw_acessos_entidades_negocio = (portalbr.dbobj.view.Jw_acessos_entidades_negocio)res_Jw_acessos_entidades_negocio.elementAt(i_bl_report_Jw_acessos_entidades_negocio);
                                    acen_id = t_jw_acessos_entidades_negocio.getAcen_id();
                                    acen_dias_consulta_retroativa = t_jw_acessos_entidades_negocio.getAcen_dias_consulta_retroativa();
                                    acen_enne_id = t_jw_acessos_entidades_negocio.getAcen_enne_id();
                                    acen_doin_id = t_jw_acessos_entidades_negocio.getAcen_doin_id();
                                    doin_nome = t_jw_acessos_entidades_negocio.getDoin_nome()==null?"":t_jw_acessos_entidades_negocio.getDoin_nome();
                                    doin_descricao = t_jw_acessos_entidades_negocio.getDoin_descricao()==null?"":t_jw_acessos_entidades_negocio.getDoin_descricao();
                                  }
                                }
                              }
                              %>
                            </table>
                          </form>
                          <%
                        }
                        %>
                        <%
                        {
                          %>
                          <form class="baseForm" >
                          
                            <table id="TRbl_report_Jw_acessos_tipos_entidade_negocio" class="reportTable" style=width:99%; border=1; >
                              <%
                              int counterbl_report_Jw_acessos_tipos_entidade_negocio=0;
                              %>
                              <%
                              {
                                portalbr.dbobj.view.Jw_acessos_tipos_entidade_negocio t_jw_acessos_tipos_entidade_negocio = new portalbr.dbobj.view.Jw_acessos_tipos_entidade_negocio();
                                java.util.Vector res_Jw_acessos_tipos_entidade_negocio = null;
                                portalbr.acesso.AutorizacaoActionForm AutorizacaoActionForm = (portalbr.acesso.AutorizacaoActionForm)session.getAttribute("AutorizacaoActionForm");
                                if(AutorizacaoActionForm!=null && (AutorizacaoActionForm.getTien_id()!=null && AutorizacaoActionForm.getTien_id().length()>0)) {
                                  com.egen.util.jdbc.JdbcUtil j = null;
                                  try {
                                    j = new com.egen.util.jdbc.JdbcUtil();
                                    String[][] select =  null;
                                    Object[][] where = null;
                                    where = new Object[][] {{"aten_tien_id","=",com.egen.util.text.FormatNumber.toInteger(AutorizacaoActionForm.getTien_id())}};
                                    String[] order = {"doin_nome"};
                                    res_Jw_acessos_tipos_entidade_negocio = j.select(t_jw_acessos_tipos_entidade_negocio,select,where,null,null,order);
                                  } catch (Exception e){
                                         res_Jw_acessos_tipos_entidade_negocio = null;
                                  } finally {
                                  if(j!=null){
                                       j.close();
                                       j = null;
                                  }
                                }
                              } else {
                                res_Jw_acessos_tipos_entidade_negocio = null;
                              }
                              if (res_Jw_acessos_tipos_entidade_negocio!=null && res_Jw_acessos_tipos_entidade_negocio.size()>0) {
                                java.lang.Integer aten_id =  null;
                                java.lang.Integer aten_tien_id =  null;
                                java.lang.Integer aten_doin_id =  null;
                                java.lang.Integer aten_dias_consulta_retroativa =  null;
                                java.lang.String doin_nome1 =  null;
                                java.lang.String doin_descricao1 =  null;
                                int i_bl_report_Jw_acessos_tipos_entidade_negocio = 0;
                                t_jw_acessos_tipos_entidade_negocio = (portalbr.dbobj.view.Jw_acessos_tipos_entidade_negocio)res_Jw_acessos_tipos_entidade_negocio.elementAt(i_bl_report_Jw_acessos_tipos_entidade_negocio);
                                aten_id = t_jw_acessos_tipos_entidade_negocio.getAten_id();
                                aten_dias_consulta_retroativa = t_jw_acessos_tipos_entidade_negocio.getAten_dias_consulta_retroativa();
                                aten_tien_id = t_jw_acessos_tipos_entidade_negocio.getAten_tien_id();
                                aten_doin_id = t_jw_acessos_tipos_entidade_negocio.getAten_doin_id();
                                doin_nome1 = t_jw_acessos_tipos_entidade_negocio.getDoin_nome()==null?"":t_jw_acessos_tipos_entidade_negocio.getDoin_nome();
                                doin_descricao1 = t_jw_acessos_tipos_entidade_negocio.getDoin_descricao()==null?"":t_jw_acessos_tipos_entidade_negocio.getDoin_descricao();
                                %>
                                <tr class="reportHeader2">
                                  <td colspan="100%">
                                     Documentos/Interface
                                  </td>
                                </tr>
                                <tr class="reportHeader" >
                                  <td class="columnTdHeader" style="text-align:center;" width=1;>
                                       ID 
                                  </td>
                                  <td class="columnTdHeader" style="text-align:left;">
                                     Nome
                                  </td>
                                  <td class="columnTdHeader" style="text-align:left;">
                                     Descrição
                                  </td>
                                  <td class="columnTdHeader" style="text-align:center;">
                                     Dias Retroat.

                                  </td>
                                  <td class="columnTdHeader" style="text-align:center;" width=2;>
                                     Excluir 
                                  </td>

                                </tr>
                                <%
                                while (i_bl_report_Jw_acessos_tipos_entidade_negocio<res_Jw_acessos_tipos_entidade_negocio.size()){
                                  counterbl_report_Jw_acessos_tipos_entidade_negocio++;
                                  String style="";
                                  if (!((i_bl_report_Jw_acessos_tipos_entidade_negocio%2)!=0)) {
                                    style="rowColor";
                                  } else {
                                    style="rowBlank";
                                  }
                                  %>
                                  <tr class=<%= style %> id='TRbl_report_Jw_acessos_tipos_entidade_negocio<%=counterbl_report_Jw_acessos_tipos_entidade_negocio%>' >
                                    <td class="reportColumn" style="text-align:center;">
                                         <%= aten_id %>
                                       </a>
                                    </td>

                                    <td class="reportColumn" style="text-align:left;">
                                         <%= doin_nome1 %>
                                      </a>
                                    </td>
                                    <td class="reportColumn" style="text-align:left;">
                                       <%= doin_descricao1 %>
                                    </td>
                                    <td class="columnTdHeader" style="text-align:center;">
                                       <% if(aten_dias_consulta_retroativa!=null){ %>
                                       <%= aten_dias_consulta_retroativa %>
                                       <% } %>
                                    </td>
                                    <td class="reportColumn" style="text-align:center;">
                                       <a  onclick="if(!(confirm('Confirma Exclusão?'))){return false;}"  href="../acesso/AutorizacaoForm.do?delete_action=&id=<%= aten_id %>&tipo=tipo_entidade&tien_id=<%= aten_tien_id %>" target=_self STYLE=cursor:hand>
                                          <img border=0 src="../img/delete.jpg" name="imagem" onmouseover="this.src='../img/delete_s.jpg'" onmouseout="this.src='../img/delete.jpg'">
                                       </a>
                                    </td>
                                  </tr>
                                  <%
                                  if (++i_bl_report_Jw_acessos_tipos_entidade_negocio >= res_Jw_acessos_tipos_entidade_negocio.size()) {
                                    break;
                                  }
                                  t_jw_acessos_tipos_entidade_negocio = (portalbr.dbobj.view.Jw_acessos_tipos_entidade_negocio)res_Jw_acessos_tipos_entidade_negocio.elementAt(i_bl_report_Jw_acessos_tipos_entidade_negocio);
                                  aten_id = t_jw_acessos_tipos_entidade_negocio.getAten_id();
                                  aten_dias_consulta_retroativa = t_jw_acessos_tipos_entidade_negocio.getAten_dias_consulta_retroativa();
                                  aten_tien_id = t_jw_acessos_tipos_entidade_negocio.getAten_tien_id();
                                  aten_doin_id = t_jw_acessos_tipos_entidade_negocio.getAten_doin_id();
                                  doin_nome1 = t_jw_acessos_tipos_entidade_negocio.getDoin_nome()==null?"":t_jw_acessos_tipos_entidade_negocio.getDoin_nome();
                                  doin_descricao1 = t_jw_acessos_tipos_entidade_negocio.getDoin_descricao()==null?"":t_jw_acessos_tipos_entidade_negocio.getDoin_descricao();
                                }
                              }
                            }
                            %>
                          </table>
                        </form>
                        <%
                      }
                      %>
                      <%
                      {
                        %>
                        <form class="baseForm" >
                          <table id="TRbl_report_Jw_acessos_usuarios" class="reportTable" style=width:99%; border=1;  >
                            <%
                            int counterbl_report_Jw_acessos_usuarios=0;
                            %>
                            <%
                            {
                              portalbr.dbobj.view.Jw_acessos_usuarios t_jw_acessos_usuarios = new portalbr.dbobj.view.Jw_acessos_usuarios();
                              java.util.Vector res_Jw_acessos_usuarios = null;
                              portalbr.acesso.AutorizacaoActionForm AutorizacaoActionForm = (portalbr.acesso.AutorizacaoActionForm)session.getAttribute("AutorizacaoActionForm");
                              if(AutorizacaoActionForm!=null && (AutorizacaoActionForm.getUsua_id()!=null && AutorizacaoActionForm.getUsua_id().length()>0)) {
                                com.egen.util.jdbc.JdbcUtil j = null;
                                try {
                                  j = new com.egen.util.jdbc.JdbcUtil();
                                  String[][] select =  null;
                                  Object[][] where = null;
                                  where = new Object[][] {{"acus_usua_id","=",com.egen.util.text.FormatNumber.toInteger(AutorizacaoActionForm.getUsua_id())}};
                                  String[] order = {"doin_nome"};
                                  res_Jw_acessos_usuarios = j.select(t_jw_acessos_usuarios,select,where,null,null,order);
                                } catch (Exception e){
                                       res_Jw_acessos_usuarios = null;
                                } finally {
                                if(j!=null){
                                     j.close();
                                     j = null;
                                }
                              }
                            } else {
                              res_Jw_acessos_usuarios = null;
                            }
                            if (res_Jw_acessos_usuarios!=null && res_Jw_acessos_usuarios.size()>0){
                              java.lang.Integer acus_id =  null;
                              java.lang.Integer acus_usua_id =  null;
                              java.lang.Integer acus_doin_id =  null;
                              java.lang.Integer acus_dias_consulta_retroativa =  null;
                              java.lang.String doin_nome2 =  null;
                              String style="";
                              String negar="";
                              java.lang.String doin_descricao2 =  null;
                              java.lang.String acus_negar_acesso =  null;
                              int i_bl_report_Jw_acessos_usuarios = 0;
                              t_jw_acessos_usuarios = (portalbr.dbobj.view.Jw_acessos_usuarios)res_Jw_acessos_usuarios.elementAt(i_bl_report_Jw_acessos_usuarios);
                              acus_id = t_jw_acessos_usuarios.getAcus_id();
                              acus_dias_consulta_retroativa = t_jw_acessos_usuarios.getAcus_dias_consulta_retroativa();
                              acus_usua_id = t_jw_acessos_usuarios.getAcus_usua_id();
                              acus_doin_id = t_jw_acessos_usuarios.getAcus_doin_id();
                              doin_nome2 = t_jw_acessos_usuarios.getDoin_nome()==null?"":t_jw_acessos_usuarios.getDoin_nome();
                              doin_descricao2 = t_jw_acessos_usuarios.getDoin_descricao()==null?"":t_jw_acessos_usuarios.getDoin_descricao();
                              acus_negar_acesso = t_jw_acessos_usuarios.getAcus_negar_acesso()==null?"":t_jw_acessos_usuarios.getAcus_negar_acesso();
                              negar = t_jw_acessos_usuarios.getAcus_negar_acesso()==null?"":t_jw_acessos_usuarios.getAcus_negar_acesso();

                              if(acus_negar_acesso.equals("S")){
                                    acus_negar_acesso = "<img border=0 src=../img/cancel.gif>";
                              } else {
                                    acus_negar_acesso = "";
                              }


                              %>
                                <tr class="reportHeader2">
                                  <td colspan="100%">
                                     Documentos/Interface
                                  </td>
                                </tr>

                              <tr class="reportHeader" >
                                <td class="columnTdHeader" style="text-align:center;" width=1;>
                                       ID 
                                </td>
                                <td class="columnTdHeader" style="text-align:left;">
                                   Nome
                                </td>
                                <td class="columnTdHeader" style="text-align:left;">
                                   Descrição
                                </td>
                                <td class="columnTdHeader" style="text-align:center;">
                                   Dias Retroat.
                                </td>
                                <td class="columnTdHeader" style="text-align:center;">
                                   Negar Acesso
                                </td>
                                <td class="columnTdHeader" style="text-align:center;" width=2;>
                                   Excluir 
                                </td>

                              </tr>
                              <%
                              while (i_bl_report_Jw_acessos_usuarios<res_Jw_acessos_usuarios.size()){
                                counterbl_report_Jw_acessos_usuarios++;
                                
                                if (!((i_bl_report_Jw_acessos_usuarios%2)!=0)) {
                                  style="rowColor";
                                } else {
                                  style="rowBlank";
                                }
                                if(negar.equals("S")){
                                     style="rowRed";
                                 }
  
                                %>
                                <tr class=<%= style %> id='TRbl_report_Jw_acessos_usuarios<%=counterbl_report_Jw_acessos_usuarios%>' >
                                  <td class="reportColumn" style="text-align:center;">
                                          <%= acus_id %>
                                        </a>
                                  </td>

                                  <td class="reportColumn" style="text-align:left;">
                                       <%= doin_nome2 %>
                                    </a>
                                  </td>
                                  <td class="reportColumn" style="text-align:left;">
                                     <%= doin_descricao2 %>
                                  </td>
                                  <td class="columnTdHeader" style="text-align:center;">
                                  <% if(acus_dias_consulta_retroativa!=null){ %>   
                                  <%= acus_dias_consulta_retroativa %>
                                  <% } %>
                                  </td>
                                  <td class="reportColumn" style="text-align:center;">
                                    <%= acus_negar_acesso %>
                                  </td>
                                  <td class="reportColumn" style="text-align:center;">
                                     <a  onclick="if(!(confirm('Confirma Exclusão?'))){return false;}"  href="../acesso/AutorizacaoForm.do?delete_action=&id=<%= acus_id %>&tipo=usuario&usua_id=<%= acus_usua_id %>" target=_self STYLE=cursor:hand>
                                         <img border=0 src="../img/delete.jpg" name="imagem" onmouseover="this.src='../img/delete_s.jpg'" onmouseout="this.src='../img/delete.jpg'">
                                     </a>
                                  </td>
                                </tr>
                                <%
                                if (++i_bl_report_Jw_acessos_usuarios >= res_Jw_acessos_usuarios.size()) {
                                  break;
                                }
                                t_jw_acessos_usuarios = (portalbr.dbobj.view.Jw_acessos_usuarios)res_Jw_acessos_usuarios.elementAt(i_bl_report_Jw_acessos_usuarios);
                                acus_id = t_jw_acessos_usuarios.getAcus_id();
                                acus_dias_consulta_retroativa = t_jw_acessos_usuarios.getAcus_dias_consulta_retroativa();
                                acus_usua_id = t_jw_acessos_usuarios.getAcus_usua_id();
                                acus_doin_id = t_jw_acessos_usuarios.getAcus_doin_id();
                                doin_nome2 = t_jw_acessos_usuarios.getDoin_nome()==null?"":t_jw_acessos_usuarios.getDoin_nome();
                                doin_descricao2 = t_jw_acessos_usuarios.getDoin_descricao()==null?"":t_jw_acessos_usuarios.getDoin_descricao();
                                acus_negar_acesso = t_jw_acessos_usuarios.getAcus_negar_acesso()==null?"":t_jw_acessos_usuarios.getAcus_negar_acesso();
                                negar = t_jw_acessos_usuarios.getAcus_negar_acesso()==null?"":t_jw_acessos_usuarios.getAcus_negar_acesso();
                                if(acus_negar_acesso.equals("S")){
                                      acus_negar_acesso = "<img border=0 src=../img/cancel.gif>";
                                } else {
                                      acus_negar_acesso = "";
                                }
                              }
                            }
                          }
                          %>
                        </table>
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