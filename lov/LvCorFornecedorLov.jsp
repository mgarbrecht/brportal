<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <link href="../css/stylelov.css" rel="stylesheet" type="text/css"/>
  <bean:message key="page.script"/>
</head>
<center>
  <body onload="if(opener.document.forms[0].fornecedor.value!='null'){document.forms[0].fornecedor.value=opener.document.forms[0].fornecedor.value}if(opener.document.forms[0].for_codigo.value!='null'){document.forms[0].fornecedor.value=opener.document.forms[0].for_codigo.value}">
    <table class="mainTable" style='width:500;'>
      <tr class="mainTr">
        <td class="mainTd">
          <table class="headerTable" style="width:500" >
            <tr>

              <td class="td10">
              </td>

            </tr>

          </table>

          <html:form action="lov/LvCorFornecedorLov.do" method="post" styleClass="baseForm">
            <table class="bannerTable" style="width:500;">
              <tr class="bannerTr">
                <td class="bannerTd">
                  Lista de Valores - Cores
                </td>
              </tr>
            </table>

            <table class="messageTable" style='width:500;'>
              <tr class="messageTr" >
                <td class="messageTd">
                  <div style=font-size:11px;font-weight:normal;>
                    <div class\='div10l'>
                      Um dos campos com
                      <img src='../img/opcional.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>
                      deve ser preenchido.
                    </div>
                  </div>
                  <html:errors property="codigo"/>
                  <html:errors property="descricao"/>
                  <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Corfornecedorview"/>
                </td>
              </tr>
            </table>

            <table class="itemTable"  style="width:500;">
              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Código
                  </span>
                  <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                </td>
                <td class="formField">
                  <html:text property="codigo" styleId="codigo" styleClass="baseField" size="22" maxlength="22"/>
                </td>
              </tr>

              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Descrição
                  </span>
                  <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                </td>
                <td class="formField">
                  <html:text property="descricao" styleId="descricao" styleClass="baseField" size="30" maxlength="30"/>
                </td>
              </tr>

              <html:hidden property="fornecedor"/>
            </table>

            <table class="buttonTable" style='width:500;'>
              <tr class="buttonTr">
                <td class="buttonTd">
                  <html:submit accesskey="s" styleClass="baseButton" property="select_action">
                    <bean:message bundle="ApplicationResources" key="jsp.select"/>
                  </html:submit>
                  <html:submit accesskey="r" styleClass="baseButton" property="resetfull_action">
                    <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                  </html:submit>
                  <html:button accesskey="c" onclick="javascript:window.close();" styleClass="baseButton" property="close_action">
                    <bean:message bundle="ApplicationResources" key="jsp.close"/>
                  </html:button>
                </td>
              </tr>
            </table>

          </html:form>
          <script type="text/javascript">
            var focusControl = document.forms[0].elements["codigo"];
            if (focusControl.type != "hidden"){
              focusControl.focus();
            }
          </script>

          <%
          {
            %>

            <%
            java.util.Vector res_Corfornecedorview = (java.util.Vector)session.getAttribute("res_Corfornecedorview");
            %>

            <form  name="bl_report_Corfornecedorview" id="bl_report_Corfornecedorview" class="baseForm" method="post" >
              <%
              if (res_Corfornecedorview!=null && res_Corfornecedorview.size()>0) {
                %>

                <pg:pager id="bl_report_Corfornecedorview" items="<%=res_Corfornecedorview.size()%>" index="center" maxPageItems="18" maxIndexPages="5" scope="request" export="offset,currentPageNumber=pageNumber" >
                  <table id="TRbl_report_Corfornecedorview"  class="reportTable"   style="width:500; "  >
                    <%
                    double cODIGO =  0;
                    java.lang.String dESCRICAO =  null;
                    java.lang.String fORNECEDOR =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:right;" >
                        Código
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Descrição
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Corfornecedorview = 0;
                    while (i_bl_report_Corfornecedorview<res_Corfornecedorview.size()) {
                      portalbr.dbobj.view.Corfornecedorview t_corfornecedorview = (portalbr.dbobj.view.Corfornecedorview)res_Corfornecedorview.elementAt(i_bl_report_Corfornecedorview);
                      cODIGO = t_corfornecedorview.getCodigo();
                      dESCRICAO = t_corfornecedorview.getDescricao()==null?"":t_corfornecedorview.getDescricao();
                      fORNECEDOR = t_corfornecedorview.getFornecedor()==null?"":t_corfornecedorview.getFornecedor();
                      String style_bl_report_Corfornecedorview="";
                      if (!((i_bl_report_Corfornecedorview%2)!=0)) {
                        style_bl_report_Corfornecedorview="rowColor";
                      } else {
                        style_bl_report_Corfornecedorview="rowBlank";
                      }
                      %>

                      <pg:item>
                        <tr class='<%= style_bl_report_Corfornecedorview %>' id="TRbl_report_Corfornecedorview<%=i_bl_report_Corfornecedorview%>" >
                          <td class="reportColumn" style="text-align:right;" >
                            <%= com.egen.util.text.FormatNumber.format(cODIGO, "0") %>
                          </td>

                          <td class="reportColumn" style="text-align:left;" >
                            <a href="javascript:setLov('<%= com.egen.util.text.FormatNumber.format(cODIGO, "0") %>','<%= dESCRICAO %>')" style="cursor:hand">
                              <%= dESCRICAO %>
                            </a>

                          </td>

                        </tr>

                      </pg:item>
                      <%
                      i_bl_report_Corfornecedorview++;
                      if (i_bl_report_Corfornecedorview<res_Corfornecedorview.size()) {
                        t_corfornecedorview = (portalbr.dbobj.view.Corfornecedorview)res_Corfornecedorview.elementAt(i_bl_report_Corfornecedorview);
                        cODIGO = t_corfornecedorview.getCodigo();
                        dESCRICAO = t_corfornecedorview.getDescricao()==null?"":t_corfornecedorview.getDescricao();
                        fORNECEDOR = t_corfornecedorview.getFornecedor()==null?"":t_corfornecedorview.getFornecedor();
                      } else {
                      }
                    }
                    %>

                  </table>

                  <pg:index id="bl_report_Corfornecedorview" >
                    <table class="pageNavigatorTable" width="100%" cellpadding="2" cellspacing="0" border="0" bgcolor="#e3e9f8">
                      <tr class="pageNavigatorTr" >
                        <td class="pageNavigatorTd">
                          <font face="verdana" color="#aaaaaa" size="-1">
                            <pg:prev export="pageUrl" ifnull="<%= true %>">
                              <%
                              if (pageUrl == null) {
                                %>
                                <b>
                                  « Anterior
                                </b>
                                <%
                              } else {
                                %>
                                <font color="#ff0000">
                                  <b>
                                    «
                                  </b>
                                </font>
                                <a href="<%= pageUrl %>">
                                  <b>
                                    Anterior
                                  </b>
                                </a>
                                <%
                              }
                              %>
                            </pg:prev>
                             
                            <pg:pages export="pageUrl,firstItem,lastItem">
                              <a href="<%= pageUrl %>">
                                <b>
                                  <%= firstItem %>
                                  a
                                  <%= lastItem %>
                                </b>
                              </a>
                               
                            </pg:pages>
                             
                            <pg:next export="pageUrl" ifnull="<%= true %>">
                              <%
                              if (pageUrl == null) {
                                %>
                                <b>
                                  Next »
                                </b>
                                <%
                              } else {
                                %>
                                <a href="<%= pageUrl %>">
                                  <b>
                                    Próximo
                                  </b>
                                </a>
                                <font color="#ff0000">
                                  <b>
                                    »
                                  </b>
                                </font>
                                <%
                              }
                              %>
                            </pg:next>
                          </td>
                        </tr>
                      </table>

                    </pg:index>
                  </pg:pager>
                  <%
                }
                %>

                <script type="text/javascript">
                  function setLov(CODIGO,DESCRICAO) {
                    <% {
                      String returnBlock = "0";
                      String return0 = null;
                      String return1 = null;
                      if (request.getParameter("returnBlock")!=null) {
                        returnBlock = request.getParameter("returnBlock");
                        session.setAttribute("returnBlock",returnBlock);
                        return0 = ((request.getParameter("return0")!=null)?request.getParameter("return0"):null);
                        session.setAttribute("return0",return0);
                        return1 = ((request.getParameter("return1")!=null)?request.getParameter("return1"):null);
                        session.setAttribute("return1",return1);
                        session.setAttribute("ge_LovPage", "LvCorFornecedorLov");
                      } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvCorFornecedorLov")) {
                        returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                        return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                        return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                      }
                      %>
                      returnBlock = <%= returnBlock %>;
                      <% if (return0!=null && return0.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=CODIGO; };
                      <%}%>
                      <% if (return1!=null && return1.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=DESCRICAO; };
                      <%}%>
                      window.close();
                    }
                    <% } %>
                  </script>

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
