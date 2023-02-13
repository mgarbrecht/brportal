<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Necessidade de Insumos
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(256)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <%
            if(request.getAttribute("arquivo")!=null){
              %>
              <table style=width:100%;margin-top:10;>
                <tr>
                  <td class=columHeader style="text-align:center;">
                    <a href="<%= (String)request.getAttribute("arquivo") %>" target="_blank">
                      <bean:message key="report.downloadpdf"/>
                    </a>
                  </td>
                </tr>
              </table>
              <%
            }
            %>

            <html:form action="com/NecessidadeInsumos_rGrid.do" method="post" styleClass="baseForm">

              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="gridCheckField"/>
                    <html:errors property="numero"/>
                    <html:errors property="data_compra"/>
                    <html:errors property="emp_empresa"/>
                    <html:errors property="fil_filial"/>
                    <html:errors property="unn_codigo"/>
                    <html:errors property="forn_codigo"/>
                    <html:errors property="forn_razsoc"/>
                    <html:errors property="fen_seq"/>
                    <html:errors property="cpg_codigo"/>
                    <html:errors property="com_codigo"/>
                    <html:errors property="situacao"/>
                    <html:errors property="tra_cdgo"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_dom_ordem_compra"/>
                  </td>
                </tr>
              </table>


              <%
              java.util.Vector res_Jw_dom_ordem_compra = null;
              if(session.getAttribute("res_Jw_dom_ordem_compra")!=null){
                res_Jw_dom_ordem_compra = (java.util.Vector)session.getAttribute("res_Jw_dom_ordem_compra");
              }
              if(res_Jw_dom_ordem_compra != null && res_Jw_dom_ordem_compra.size()>0){
                %>


                <%
                if (((String)request.getParameter("_ordered"))!=null && ((String)request.getParameter("_ordered")).length()>0 ) {
                  boolean reverse = false;
                  if ( ((String)request.getParameter("_reverse"))!=null && ((String)request.getParameter("_reverse")).equals("true") ){
                    reverse = true;
                  }
                  try {
                    res_Jw_dom_ordem_compra = com.egen.util.text.Sort.execute(res_Jw_dom_ordem_compra,((String)request.getParameter("_ordered")),reverse);
                  } catch (Exception e) {}
                }
                %>

                <table class="reportTable" style=width:99%;  border=1  frame=box>
                  <tr class="reportHeader">
                    <td class="columnTdHeader">
                      <span class="spamFormLabel">
                      </span>
                    </td>


                    <td class="columnTdHeader" style="text-align: left;">
                      Ordem Compra
                      <%
                      if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                        %>
                        <a href='NecessidadeInsumos_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","numero")%>' class="reportOrder">
                          <bean:message key="report.orderedasc"/>
                        </a>
                        <%
                      } else {
                        %>
                        <a href='NecessidadeInsumos_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","numero")%>' class="reportOrder">
                          <bean:message key="report.ordereddesc"/>
                        </a>
                        <%
                      }
                      %>
                    </td>



                    <td class="columnTdHeader" style="text-align: center;">
                      Data
                      <%
                      if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                        %>
                        <a href='NecessidadeInsumos_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","data_compra")%>' class="reportOrder">
                          <bean:message key="report.orderedasc"/>
                        </a>
                        <%
                      } else {
                        %>
                        <a href='NecessidadeInsumos_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","data_compra")%>' class="reportOrder">
                          <bean:message key="report.ordereddesc"/>
                        </a>
                        <%
                      }
                      %>
                    </td>


                    <td class="columnTdHeader" style="text-align: center;">
                      Empresa
                      <%
                      if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                        %>
                        <a href='NecessidadeInsumos_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","emp_empresa")%>' class="reportOrder">
                          <bean:message key="report.orderedasc"/>
                        </a>
                        <%
                      } else {
                        %>
                        <a href='NecessidadeInsumos_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","emp_empresa")%>' class="reportOrder">
                          <bean:message key="report.ordereddesc"/>
                        </a>
                        <%
                      }
                      %>
                    </td>


                    <td class="columnTdHeader" style="text-align: center;">
                      Filial
                      <%
                      if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                        %>
                        <a href='NecessidadeInsumos_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","fil_filial")%>' class="reportOrder">
                          <bean:message key="report.orderedasc"/>
                        </a>
                        <%
                      } else {
                        %>
                        <a href='NecessidadeInsumos_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","fil_filial")%>' class="reportOrder">
                          <bean:message key="report.ordereddesc"/>
                        </a>
                        <%
                      }
                      %>
                    </td>


                    <td class="columnTdHeader" style="text-align: right;">
                      Fornecedor
                      <%
                      if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                        %>
                        <a href='NecessidadeInsumos_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","forn_codigo")%>' class="reportOrder">
                          <bean:message key="report.orderedasc"/>
                        </a>
                        <%
                      } else {
                        %>
                        <a href='NecessidadeInsumos_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","forn_codigo")%>' class="reportOrder">
                          <bean:message key="report.ordereddesc"/>
                        </a>
                        <%
                      }
                      %>
                    </td>


                    <td class="columnTdHeader" style="text-align: left;">
                      Razão Social
                      <%
                      if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                        %>
                        <a href='NecessidadeInsumos_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","forn_razsoc")%>' class="reportOrder">
                          <bean:message key="report.orderedasc"/>
                        </a>
                        <%
                      } else {
                        %>
                        <a href='NecessidadeInsumos_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","forn_razsoc")%>' class="reportOrder">
                          <bean:message key="report.ordereddesc"/>
                        </a>
                        <%
                      }
                      %>
                    </td>


                  </tr>


                  <%
                  String style="";
                  int contador = 0;
                  %>
                  <logic:iterate id="bl_form_Jw_dom_ordem_compra_lines" name="NecessidadeInsumos_rGridActionForm" property="bl_form_Jw_dom_ordem_compra_lines" indexId="indexId">
                    <%
                    Jw_dom_ordem_compra jwDomOrdemCompra = (Jw_dom_ordem_compra)res_Jw_dom_ordem_compra.elementAt(contador++);
                    if (!((contador%2)!=0)) {
                      style="rowColor";
                    } else {
                      style="rowBlank";
                    }
                    %>
                    <tr class=<%= style %> >
                      <td class="tdGridField" style="text-align: center;" >
                        <html:checkbox property="gridCheckField" styleId="gridCheckField" styleClass="baseField" value="true" name="bl_form_Jw_dom_ordem_compra_lines" indexed="true"/>
                      </td>

                      <td class="tdGridField" style="text-align: left;" >
                        <html:hidden property="numero" styleId="numero" name="bl_form_Jw_dom_ordem_compra_lines" indexed="true"/>
                        <%= jwDomOrdemCompra.getNumero() %>
                      </td>

                      <td class="tdGridField" style="text-align: center;">
                        <html:hidden property="data_compra" styleId="data_compra" name="bl_form_Jw_dom_ordem_compra_lines" indexed="true"/>
                        <%= com.egen.util.text.FormatDate.format(jwDomOrdemCompra.getData_compra(), "dd/MM/yyyy") %>
                      </td>

                      <td class="tdGridField" style="text-align: center;">
                        <html:hidden property="emp_empresa" styleId="emp_empresa" name="bl_form_Jw_dom_ordem_compra_lines" indexed="true"/>
                        <%= jwDomOrdemCompra.getEmp_empresa() %>
                      </td>

                      <td class="tdGridField" style="text-align: center;">
                        <html:hidden property="fil_filial" styleId="fil_filial" name="bl_form_Jw_dom_ordem_compra_lines" indexed="true"/>
                        <%= jwDomOrdemCompra.getFil_filial() %>
                      </td>


                      <td class="tdGridField" style="text-align: right;">
                        <html:hidden property="forn_codigo" styleId="forn_codigo" name="bl_form_Jw_dom_ordem_compra_lines" indexed="true"/>
                        <%= jwDomOrdemCompra.getForn_codigo() %>
                      </td>

                      <td class="tdGridField" style="text-align: left;">
                        <html:hidden property="forn_razsoc" styleId="forn_razsoc" name="bl_form_Jw_dom_ordem_compra_lines" indexed="true"/>
                        <%= jwDomOrdemCompra.getForn_razsoc() %>
                      </td>

                    </tr>

                  </logic:iterate>

                </table>

                <table class="buttonTable" style='width:99%;'>
                  <tr class="buttonTr">
                    <td class="buttonTd">
                      <html:submit accesskey="s" styleClass="myhidden" property="select_action">
                        <bean:message bundle="ApplicationResources" key="jsp.select"/>
                      </html:submit>
                      <html:submit accesskey="r" styleClass="myhidden" property="resetfull_action">
                        <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                      </html:submit>
                      <html:submit value="Marcar Todos" styleClass="baseButton" property="marcar_todos_action">
                      </html:submit>
                      <html:submit value="Desmarcar Todos" styleClass="baseButton" property="desmarcar_todos_action">
                      </html:submit>
                      <html:submit value="Gerar Arquivos" styleClass="baseButton" property="gerar_action">
                      </html:submit>
                      <html:submit accesskey="a" styleClass="baseButton" property="back_action">
                        Voltar
                      </html:submit>
                    </td>
                  </tr>
                </table>

                <%
              } else {
                %>


                <table class="buttonTable" style='width:99%;'>
                  <tr class="buttonTr">
                    <td class="buttonTd">
                      <html:submit accesskey="a" styleClass="baseButton" property="back_action">
                        Voltar
                      </html:submit>
                    </td>
                  </tr>
                </table>



                <%
              }
              %>

            </html:form>
          </td>
        </tr>
      </table>

    </body>
  </center>
</html>
