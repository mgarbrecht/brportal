<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Manutenção de Arquivos - AFV
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
                  <%@ include file="../system/header_sem_ajuda.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(131)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/ManutencaoArquivosAFVForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <td colspan="2">
                  <%@ page import="java.io.*,java.util.Date" %>
                  <%
                  java.text.SimpleDateFormat fData2 = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                  %>
                  <center>
                    <table cellpadding="1" border="3">
                      <td valign="top">
                        <table cellpadding="2" Border="2" BorderColor="#FFFFFF">
                          <tr align="center" BorderColor="#808080" BGColor="D3D3D3">
                            <th align="left" border="1">
                              Arquivo
                            </th>
                            <th border="1">
                              Tamanho
                            </th>
                            <th border="1">
                              Última Modificação
                            </th>
                            <th align="left" border="1">
                              Apagar
                            </th>
                          </tr>
                          <%
                          File dirObject = new  File(request.getRealPath("/") + "arquivos/afv" + java.io.File.separator);
                          File[] dirList = dirObject.listFiles();
                          for(int x=0; x < dirList.length; x++) {
                            if (dirList[x].isFile() && (!(dirList[x].getName().equals("index.html")))) {
                              %>
                              <tr BorderColor="#FFFFFF">
                                <td align="left">
                                  <font Face="Verdana" SIZE="2" COLOR="Blue">
                                    <%= dirList[x].getName() %>
                                  </font>
                                </td>
                                <td align="right">
                                  <font Face="Tahoma" SIZE="2" COLOR="DarkGreen">
                                    <%= dirList[x].length() %>
                                  </font>
                                </td>
                                <td align="center">
                                  <font Face="Tahoma" SIZE="2" COLOR="DarkGreen">
                                    <%= fData2.format(new Date(dirList[x].lastModified()))  %>
                                  </font>
                                </td>
                                <td align="center">
                                  <a onclick="if(!(confirm('Confirma Exclusão?'))){return false;}"  href="../com/ManutencaoArquivosAFVForm.do?delete_action=&arq=<%= dirList[x].getName() %>" target=_self STYLE=cursor:hand>
                                    <img Name="File" border=0 src="../img/editdelete.png" name="imagem" onmouseover="this.src='../img/editdelete_s.png'" onmouseout="this.src='../img/editdelete.png'">
                                  </a>
                                </td>
                              </tr>
                              <%
                            }
                          }
                          %>
                        </table>
                      </td>
                    </tr>
                  </table>
                </center>
              </td>
              <html:hidden property="arq"/>
            </table>

            <table class="buttonTable" style='width:99%;'>
              <tr class="buttonTr">
                <td class="buttonTd">
                  <html:submit accesskey="d" styleClass="myhidden" property="delete_action">
                    <bean:message bundle="ApplicationResources" key="jsp.delete"/>
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
