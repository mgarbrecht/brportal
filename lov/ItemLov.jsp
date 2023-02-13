<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <link href="../css/stylelov.css" rel="stylesheet" type="text/css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body onload="if(opener.document.forms[0].fornecedor.value!='null'){document.forms[0].fornecedor.value=opener.document.forms[0].fornecedor.value}if(opener.document.forms[0].for_codigo.value!='null'){document.forms[0].fornecedor.value=opener.document.forms[0].for_codigo.value}">
      <table class="mainTable" style='width:500;'>
        <tr class="mainTr">
          <td class="mainTd">
            <html:form action="lov/ItemLov.do" method="post" styleClass="baseForm" target="_self">
              <table class="bannerTable" style="width:500;">
                <tr class="bannerTr">
                  <td class="bannerTd">
                    Lista de Valores de Itens
                  </td>
                </tr>
              </table>

              <table class="messageTable" style='width:500;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="codigo"/>
                    <html:errors property="descricao"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_ItemFornecedorView"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:500;">
                <%
                acesso.Usuario u = new acesso.Usuario();
                u = (acesso.Usuario)session.getAttribute("User");
                acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
                if(!(u.getEntidadeNegocio()==null)){
                  ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();
                }
                %>
                <html:hidden property="fornecedor"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Código
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="codigo" styleClass="baseField" size="21" maxlength="21"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Descrição
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="descricao" styleClass="baseField" size="50" maxlength="100"/>
                  </td>
                </tr>

                <html:hidden property="return0" value="<%= request.getParameter("return0") %>"/>
              </table>

              <table class="buttonTable" style='width:500;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:button accesskey="s" onclick="document.forms[0].select1_action.disabled=true;select_action.click();" styleClass="baseButton" property="select1_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:button>
                    <html:submit styleClass="myhidden" property="select_action">
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
              java.util.Vector res_Itemfornecedorview = (java.util.Vector)session.getAttribute("res_ItemFornecedorView");
              %>

              <form  name="bl_report_Itemfornecedorview" id="bl_report_Itemfornecedorview" class="baseForm" method="post" >
                <%
                if (res_Itemfornecedorview!=null && res_Itemfornecedorview.size()>0) {
                  %>

                  <pg:pager id="bl_report_Itemfornecedorview" items="<%=res_Itemfornecedorview.size()%>" index="center" maxPageItems="18" maxIndexPages="5" scope="request" export="offset,currentPageNumber=pageNumber" >
                    <table id="TRbl_report_Itemfornecedorview"  class="reportTable"   style="width:500; "  >
                      <%
                      double codigo =  0;
                      java.lang.String descricao =  null;
                      java.lang.String fornecedor =  null;
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
                      int i_bl_report_Itemfornecedorview = 0;
                      while (i_bl_report_Itemfornecedorview<res_Itemfornecedorview.size()) {
                        portalbr.dbobj.view.Itemfornecedorview t_itemfornecedorview = (portalbr.dbobj.view.Itemfornecedorview)res_Itemfornecedorview.elementAt(i_bl_report_Itemfornecedorview);
                        codigo = t_itemfornecedorview.getCodigo();
                        descricao = t_itemfornecedorview.getDescricao()==null?"":t_itemfornecedorview.getDescricao();
                        fornecedor = t_itemfornecedorview.getFornecedor()==null?"":t_itemfornecedorview.getFornecedor();
                        String style_bl_report_Itemfornecedorview="";
                        if (!((i_bl_report_Itemfornecedorview%2)!=0)) {
                          style_bl_report_Itemfornecedorview="rowColor";
                        } else {
                          style_bl_report_Itemfornecedorview="rowBlank";
                        }
                        %>

                        <pg:item>
                          <tr class='<%= style_bl_report_Itemfornecedorview %>' id="TRbl_report_Itemfornecedorview<%=i_bl_report_Itemfornecedorview%>" >
                            <td class="reportColumn" style="text-align:right;" >
                              <%= com.egen.util.text.FormatNumber.format(codigo, "0") %>
                            </td>

                            <td class="reportColumn" style="text-align:left;" >
                              <a href="javascript:setLov('<%= com.egen.util.text.FormatNumber.format(codigo, "0") %>','<%= descricao %>')" style="cursor:hand">
                                <%= descricao %>
                              </a>

                            </td>

                          </tr>

                        </pg:item>
                        <%
                        i_bl_report_Itemfornecedorview++;
                        if (i_bl_report_Itemfornecedorview<res_Itemfornecedorview.size()) {
                          t_itemfornecedorview = (portalbr.dbobj.view.Itemfornecedorview)res_Itemfornecedorview.elementAt(i_bl_report_Itemfornecedorview);
                          codigo = t_itemfornecedorview.getCodigo();
                          descricao = t_itemfornecedorview.getDescricao()==null?"":t_itemfornecedorview.getDescricao();
                          fornecedor = t_itemfornecedorview.getFornecedor()==null?"":t_itemfornecedorview.getFornecedor();
                        } else {
                        }
                      }
                      %>

                    </table>

                    <pg:index id="bl_report_Itemfornecedorview" >
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
                          session.setAttribute("ge_LovPage", "ItemLov");
                        } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("ItemLov")) {
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
