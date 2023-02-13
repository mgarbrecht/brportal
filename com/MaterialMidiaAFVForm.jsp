<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Material Mídia AFV
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(196)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/MaterialMidiaAFVForm.do" enctype="multipart/form-data" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="codtipomarketing"/>
                    <html:errors property="marca"/>
                    <html:errors property="titulo"/>
                    <html:errors property="descricao"/>
                    <html:errors property="tipo_arquivo"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_afv_marketing"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <html:hidden property="codmarketing"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Tipo
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:select property="codtipomarketing" styleId="codtipomarketing" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="1">
                        Institucional
                      </html:option>
                      <html:option styleClass="baseOption" value="2">
                        Midia
                      </html:option>
                      <html:option styleClass="baseOption" value="3">
                        Materiais PDV
                      </html:option>
                      <html:option styleClass="baseOption" value="4">
                        Editoriais de Moda
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Marca
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:select property="marca" styleId="marca" styleClass="baseField" size="1">
                      <html:options property="marcaList" labelProperty="marcaLabelList" styleClass="baseOptions"/>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Título
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="titulo" styleId="titulo" styleClass="baseField" size="100" maxlength="100"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Descrição
                    </span>
                  </td>
                  <td class="formField">
                    <html:textarea property="descricao" styleId="descricao" styleClass="baseField" cols="100" rows="4"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Tipo Arquivo
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="tipo_arquivo" styleId="tipo_arquivo" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="I">
                        Arquivos Ícones
                      </html:option>
                      <html:option styleClass="baseOption" value="G">
                        Arquivos Grandes
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Arquivo
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:file property="arquivo" styleId="arquivo" styleClass="baseField">
                    </html:file>
                  </td>
                </tr>

              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit value="Upload" styleClass="baseButton" property="blank_action">
                    </html:submit>
                    <html:submit accesskey="l" styleClass="baseButton" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
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
