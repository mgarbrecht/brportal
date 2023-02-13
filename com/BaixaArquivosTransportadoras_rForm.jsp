<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Baixa de Arquivos Transportadoras
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(146)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <%
            {
              %>

              <%
              java.util.Vector res_Jw_arquivos_edi = (java.util.Vector)session.getAttribute("res_Jw_arquivos_edi");

              String transportadora="";
              String tipo = "";
              String data_envio_embarque_romaneio = "";
              acesso.Usuario u = new acesso.Usuario();
              u = (acesso.Usuario)session.getAttribute("User");
              acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
              acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();

              if(!(u.getEntidadeNegocio()==null)){
                ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();
                tipoent = (acesso.TipoEntidadeNegocio) ent.getTipoEntidadeNegocio();
                tipo = tipoent.getTipo()+"";
                if(tipo.equals("TRANSPORTADORA")){
                  transportadora = ent.getChave()+"";
                }
              }
              %>

              <form  name="bl_report_Jw_arquivos_edi" id="bl_report_Jw_arquivos_edi" class="baseForm" method="post" >
                <%
                if (res_Jw_arquivos_edi!=null && res_Jw_arquivos_edi.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_arquivos_edi"  class="reportTable"   style="width:99%; "  >
                    <%
                    java.lang.String arquivos =  null;
                    java.lang.String nOME =  null;
                    int cODIGO =  0;
                    java.lang.String cAMINHO =  null;
                    java.lang.String cAMINHO_LINK =  null;
                    %>

                    <tr class="reportTr">
                    </tr>

                    <%
                    int i_bl_report_Jw_arquivos_edi = 0;
                    while (i_bl_report_Jw_arquivos_edi<res_Jw_arquivos_edi.size()) {
                      portalbr.dbobj.view.Jw_arquivos_edi t_jw_arquivos_edi = (portalbr.dbobj.view.Jw_arquivos_edi)res_Jw_arquivos_edi.elementAt(i_bl_report_Jw_arquivos_edi);
                      nOME = t_jw_arquivos_edi.getNome()==null?"":t_jw_arquivos_edi.getNome();
                      cODIGO = t_jw_arquivos_edi.getCodigo();
                      cAMINHO = t_jw_arquivos_edi.getCaminho()==null?"":t_jw_arquivos_edi.getCaminho();
                      cAMINHO_LINK = t_jw_arquivos_edi.getCaminho_link()==null?"":t_jw_arquivos_edi.getCaminho_link();
                      String style_bl_report_Jw_arquivos_edi="";
                      style_bl_report_Jw_arquivos_edi="rowBlank";
                      %>

                      <tr class='<%= style_bl_report_Jw_arquivos_edi %>' id="TRbl_report_Jw_arquivos_edi<%=i_bl_report_Jw_arquivos_edi%>" >
                        <td colspan="2">
                          <%@ page import="java.io.*,java.util.Date" %>
                          <%
                          String arquivosEDI = t_jw_arquivos_edi.getCaminho()==null?"":t_jw_arquivos_edi.getCaminho();
                          String linkArquivosEDI = t_jw_arquivos_edi.getCaminho_link()==null?"":t_jw_arquivos_edi.getCaminho_link();
                          java.text.SimpleDateFormat fData2 = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                          java.text.SimpleDateFormat falcatrua = new java.text.SimpleDateFormat("dd/MM/yyyy");
                          if(session.getAttribute("data_envio_embarque_romaneio")!=null){
                            data_envio_embarque_romaneio = (String) session.getAttribute("data_envio_embarque_romaneio");
                          }
                          util.file.Ordenacao mf = new util.file.Ordenacao(arquivosEDI + java.io.File.separator);
                          File[] dirList = mf.listFiles();
                          if(dirList.length>0) {
                            %>
                            <center>
                              <table cellpadding="1" border="3" width="750">
                                <td valign="top">
                                  <table cellpadding="2" Border="2" BorderColor="#FFFFFF" width="750">
                                    <tr align="center" BorderColor="#808080" BGColor="D3D3D3">
                                      <%
                                      if(transportadora.equals("")) {
                                        %>
                                        <th align="left" border="1">
                                          Transportadora
                                        </th>
                                        <%
                                      }
                                      %>
                                      <th align="left" border="1">
                                        Arquivo
                                      </th>
                                      <th border="1">
                                        Tamanho
                                      </th>
                                      <th border="1">
                                        Última Modificação
                                      </th>
                                      <th align="center" border="1">
                                        Baixar
                                      </th>
                                    </tr>
                                    <%
                                    for(int x=0; x < dirList.length; x++) {
                                      if (dirList[x].isFile() && (!(dirList[x].getName().equals("index.html")))) {

                                        if( data_envio_embarque_romaneio !="" && data_envio_embarque_romaneio.equals((falcatrua.format(new Date(dirList[x].lastModified()))))){
                                          %>
                                          <tr BorderColor="#FFFFFF">
                                            <%
                                            if(transportadora.equals("")) {
                                              %>
                                              <td align="left">
                                                <font Face="Verdana" SIZE="2" COLOR="Blue">
                                                  <%= t_jw_arquivos_edi.getNome()==null?"":t_jw_arquivos_edi.getNome()%>
                                                </font>
                                              </td>
                                              <%
                                            }
                                            %>
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
                                              <a href="..<%= linkArquivosEDI %>/<%= dirList[x].getName() %>" target=_self STYLE=cursor:hand>
                                                <img Name="File" border=0 src="../img/inbox.png" name="imagem" onmouseover="this.src='../img/inbox_v.png'" onmouseout="this.src='../img/inbox.png'">
                                              </a>
                                            </td>
                                          </tr>
                                          <%
                                        } else if(data_envio_embarque_romaneio.equals("")){
                                          %>
                                          <tr BorderColor="#FFFFFF">
                                            <%
                                            if(transportadora.equals("")) {
                                              %>
                                              <td align="left">
                                                <font Face="Verdana" SIZE="2" COLOR="Blue">
                                                  <%= t_jw_arquivos_edi.getNome()==null?"":t_jw_arquivos_edi.getNome()%>
                                                </font>
                                              </td>
                                              <%
                                            }
                                            %>
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
                                              <a href="..<%= linkArquivosEDI %>/<%= dirList[x].getName() %>" target=_self STYLE=cursor:hand>
                                                <img Name="File" border=0 src="../img/inbox.png" name="imagem" onmouseover="this.src='../img/inbox_v.png'" onmouseout="this.src='../img/inbox.png'">
                                              </a>
                                            </td>
                                          </tr>
                                          <%
                                        }
                                      }
                                    }
                                    %>
                                  </table>
                                </td>
                              </tr>
                            </table>
                          </center>
                          <%
                        } else {
                          %>
                          <center>
                            <br>
                            <font color="red">
                              <h4>
                                <b>
                                  Nenhum arquivo disponivel !
                                </b>
                              </h4>
                            </font>
                          </center>
                          <%
                        }
                        %>
                      </td>
                    </tr>

                    <%
                    i_bl_report_Jw_arquivos_edi++;
                    if (i_bl_report_Jw_arquivos_edi<res_Jw_arquivos_edi.size()) {
                      t_jw_arquivos_edi = (portalbr.dbobj.view.Jw_arquivos_edi)res_Jw_arquivos_edi.elementAt(i_bl_report_Jw_arquivos_edi);
                      nOME = t_jw_arquivos_edi.getNome()==null?"":t_jw_arquivos_edi.getNome();
                      cODIGO = t_jw_arquivos_edi.getCodigo();
                      cAMINHO = t_jw_arquivos_edi.getCaminho()==null?"":t_jw_arquivos_edi.getCaminho();
                      cAMINHO_LINK = t_jw_arquivos_edi.getCaminho_link()==null?"":t_jw_arquivos_edi.getCaminho_link();
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
          <html:form action="com/BaixaArquivosTransportadoras_rForm.do" method="post" styleClass="baseForm">
            <table class="messageTable" style='width:99%;'>
              <tr class="messageTr" >
                <td class="messageTd">
                </td>
              </tr>
            </table>

            <table class="buttonTable" style='width:99%;'>
              <tr class="buttonTr">
                <td class="buttonTd">
                  <%
                  String transportadora="";
                  String tipo = "";
                  acesso.Usuario u = new acesso.Usuario();
                  u = (acesso.Usuario)session.getAttribute("User");
                  acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
                  acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();

                  if(!(u.getEntidadeNegocio()==null)){
                    ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();
                    tipoent = (acesso.TipoEntidadeNegocio) ent.getTipoEntidadeNegocio();
                    tipo = tipoent.getTipo()+"";
                    if(tipo.equals("TRANSPORTADORA")){
                      transportadora = ent.getChave()+"";
                    }
                  }

                  if(transportadora.equals("")){
                    %>

                    <html:button accesskey="a" styleClass="baseButton" property="back_action" onclick="history.go(-1)">
                      <bean:message bundle="ApplicationResources" key="jsp.back"/>
                    </html:button>

                    <%
                  }
                  %>
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
