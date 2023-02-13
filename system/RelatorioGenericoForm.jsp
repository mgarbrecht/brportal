<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      <%= ((String)session.getAttribute("titulo_relatorio"))+"" %>
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
                  <%@ include file="../system/header_excel.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(99)){
                    //   response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="system/RelatorioGenericoForm.do" method="post" styleClass="baseForm">

              <table class="itemTable"  style="width:99%;">
                <%@taglib prefix="sql2" uri="http://java.sun.com/jsp/jstl/sql"%>
                <%
                //session.setAttribute("query", "SELECT fct_mask_modelo(v.LIN_CDGO, v.REF_CDGO, v.CAB_CDGO)||' - '||v.REF_DESC \"Produto\", v.COR_CDGO||' - '||v.COR_DESC \"Cor\", v.QTDE_ATUAL \"Qtde\"  , v.CODIGO_GRUPO||' - '||v.DESCRICAO_GRUPO grupo, v.TAI_CODIGO \"Tamanho\", v.PRECO \"Preço\" from loja.detalhe_produto_vw v");
                //session.setAttribute("query", "select usua_id, usua_nome, usua_usuario, usua_senha from wbrio.usuarios");
                %>
                <HTML>
                  <HEAD>
                    <link rel="stylesheet" type="text/css" href="demo_page.css" />
                    <link rel="stylesheet" type="text/css" href="demo_table.css" />
                    <SCRIPT language=javascript type=text/javascript src="jquery.js">
        </SCRIPT>
        <SCRIPT language=javascript type=text/javascript src="jquery.dataTables.js">
        </SCRIPT>

        <SCRIPT type=text/javascript charset=utf-8>
          $('#dados').hide();
          $(document).ready(function() {
            $('#example').dataTable( {
              "bPaginate": false,
              "bLengthChange": true,
              "bFilter": true,
              "bSort": true,
              "bInfo": true,
              "bAutoWidth": true } );
              $('#carregando').hide();
              $('#example').show();

              } );
            </SCRIPT>

            <sql2:query var="result" dataSource="jdbc/Orasco">
              <%= (String)session.getAttribute("query") %>
            </sql2:query>

          </HEAD>
          <BODY id=dt_example class=ex_highlight_row>

<style type="text/css"> 
</style>

           <div id="carregando" styleClass="myhidden">
              Carregando informações<br>
              <img src="../img/loadingAnimation.gif" >
           </div>

            <DIV id=container>
              <DIV id=demo>
                <TABLE id=example class=display border=0 cellSpacing=0 cellPadding=0>
                  <THEAD>
                    <TR>
                      <c:forEach var="columnName" items="${result.columnNames}">
                        <th>
                          <c:out value="${columnName}"/>
                        </th>
                      </c:forEach>
                    </TR>
                  </THEAD>
                  <TBODY>
                    <c:forEach var="row" items="${result.rowsByIndex}">
                      <tr>
                        <c:forEach var="column" items="${row}">
                          <td>
                            <c:out value="${column}"/>
                          </td>
                        </c:forEach>
                      </tr>
                    </c:forEach>
                  </TBODY>
                  <TFOOT>
                    <TR>
                      <c:forEach var="columnName" items="${result.columnNames}">
                        <th>
                          <c:out value="${columnName}"/>
                        </th>
                      </c:forEach>
                    </TR>
                  </TFOOT>
                </TABLE>
              </DIV>
              <DIV class=spacer>
              </DIV>
            </DIV>



          </BODY>
        </HTML>
      </table>

      <table class="buttonTable" style='width:99%;'>
        <tr class="buttonTr">
          <td class="buttonTd">
            <html:button accesskey="b" onclick="history.go(-1);" styleClass="baseButton" property="back_action">
              <bean:message bundle="ApplicationResources" key="jsp.back"/>
            </html:button>
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
