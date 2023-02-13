<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Prazos de Entrega por Município
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(11)){
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
              java.util.Vector res_Jw_prazos_municipios = (java.util.Vector)session.getAttribute("res_Jw_prazos_municipios");
              %>

              <form  name="bl_report_Jw_prazos_municipios" id="bl_report_Jw_prazos_municipios" class="baseForm" method="post" >
                <%
                if (res_Jw_prazos_municipios!=null && res_Jw_prazos_municipios.size()>0) {
                  if ( ((String)request.getParameter("_ordered"))!=null && ((String)request.getParameter("_ordered")).length()>0 ) {
                    boolean reverse = false;
                    if ( ((String)request.getParameter("_reverse"))!=null && ((String)request.getParameter("_reverse")).equals("true") ){
                      reverse = true;
                    }
                    try {
                      res_Jw_prazos_municipios = com.egen.util.text.Sort.execute(res_Jw_prazos_municipios,((String)request.getParameter("_ordered")),reverse);
                      session.setAttribute("res_Jw_prazos_municipios", res_Jw_prazos_municipios);
                    } catch (Exception e) {}
                  }
                  %>

                  <table id="TRbl_report_Jw_prazos_municipios"  class="reportTable"   style="width:99%; "  border="1" >
                    <%
                    java.lang.Integer codigo =  null;
                    java.lang.String est_descri =  null;
                    java.lang.String descricao =  null;
                    java.lang.String distrito =  null;
                    java.lang.String codigo_ibge =  null;
                    java.lang.String est_unifed =  null;
                    java.lang.Integer prazo_entrega =  null;
                    java.lang.String sigla_transportadora =  null;
                    java.lang.String segunda =  null;
                    java.lang.String terca =  null;
                    java.lang.String quarta =  null;
                    java.lang.String quinta =  null;
                    java.lang.String sexta =  null;
                    java.lang.String sabado =  null;
                    java.lang.String domingo =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:right;" >
                        Código
                        <%
                        if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                          %>
                          <a href='MunicipiosPrazos_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","codigo")%>' class="reportOrder">
                            <bean:message key="report.orderedasc"/>
                          </a>
                          <%
                        } else {
                          %>
                          <a href='MunicipiosPrazos_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","codigo")%>' class="reportOrder">
                            <bean:message key="report.ordereddesc"/>
                          </a>
                          <%
                        }
                        %>
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Município
                        <%
                        if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                          %>
                          <a href='MunicipiosPrazos_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","descricao")%>' class="reportOrder">
                            <bean:message key="report.orderedasc"/>
                          </a>
                          <%
                        } else {
                          %>
                          <a href='MunicipiosPrazos_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","descricao")%>' class="reportOrder">
                            <bean:message key="report.ordereddesc"/>
                          </a>
                          <%
                        }
                        %>
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Distrito
                        <%
                        if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                          %>
                          <a href='MunicipiosPrazos_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","distrito")%>' class="reportOrder">
                            <bean:message key="report.orderedasc"/>
                          </a>
                          <%
                        } else {
                          %>
                          <a href='MunicipiosPrazos_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","distrito")%>' class="reportOrder">
                            <bean:message key="report.ordereddesc"/>
                          </a>
                          <%
                        }
                        %>
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        IBGE
                        <%
                        if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                          %>
                          <a href='MunicipiosPrazos_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","codigo_ibge")%>' class="reportOrder">
                            <bean:message key="report.orderedasc"/>
                          </a>
                          <%
                        } else {
                          %>
                          <a href='MunicipiosPrazos_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","codigo_ibge")%>' class="reportOrder">
                            <bean:message key="report.ordereddesc"/>
                          </a>
                          <%
                        }
                        %>
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        UF
                        <%
                        if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                          %>
                          <a href='MunicipiosPrazos_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","est_unifed")%>' class="reportOrder">
                            <bean:message key="report.orderedasc"/>
                          </a>
                          <%
                        } else {
                          %>
                          <a href='MunicipiosPrazos_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","est_unifed")%>' class="reportOrder">
                            <bean:message key="report.ordereddesc"/>
                          </a>
                          <%
                        }
                        %>
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Prazo Entrega
                        <%
                        if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                          %>
                          <a href='MunicipiosPrazos_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","prazo_entrega")%>' class="reportOrder">
                            <bean:message key="report.orderedasc"/>
                          </a>
                          <%
                        } else {
                          %>
                          <a href='MunicipiosPrazos_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","prazo_entrega")%>' class="reportOrder">
                            <bean:message key="report.ordereddesc"/>
                          </a>
                          <%
                        }
                        %>
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Segunda
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Terça
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Quarta
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Quinta
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Sexta
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Sábado
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Domingo
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Jw_prazos_municipios = 0;
                    while (i_bl_report_Jw_prazos_municipios<res_Jw_prazos_municipios.size()) {
                      portalbr.dbobj.view.Jw_prazos_municipios t_jw_prazos_municipios = (portalbr.dbobj.view.Jw_prazos_municipios)res_Jw_prazos_municipios.elementAt(i_bl_report_Jw_prazos_municipios);
                      codigo = t_jw_prazos_municipios.getCodigo();
                      est_descri = t_jw_prazos_municipios.getEst_descri()==null?"":t_jw_prazos_municipios.getEst_descri();
                      descricao = t_jw_prazos_municipios.getDescricao()==null?"":t_jw_prazos_municipios.getDescricao();
                      distrito = t_jw_prazos_municipios.getDistrito()==null?"":t_jw_prazos_municipios.getDistrito();
                      codigo_ibge = t_jw_prazos_municipios.getCodigo_ibge()==null?"":t_jw_prazos_municipios.getCodigo_ibge();
                      est_unifed = t_jw_prazos_municipios.getEst_unifed()==null?"":t_jw_prazos_municipios.getEst_unifed();
                      prazo_entrega = t_jw_prazos_municipios.getPrazo_entrega();
                      sigla_transportadora = t_jw_prazos_municipios.getSigla_transportadora()==null?"":t_jw_prazos_municipios.getSigla_transportadora();
                      segunda = t_jw_prazos_municipios.getSegunda()==null?"":t_jw_prazos_municipios.getSegunda();
                      terca = t_jw_prazos_municipios.getTerca()==null?"":t_jw_prazos_municipios.getTerca();
                      quarta = t_jw_prazos_municipios.getQuarta()==null?"":t_jw_prazos_municipios.getQuarta();
                      quinta = t_jw_prazos_municipios.getQuinta()==null?"":t_jw_prazos_municipios.getQuinta();
                      sexta = t_jw_prazos_municipios.getSexta()==null?"":t_jw_prazos_municipios.getSexta();
                      sabado = t_jw_prazos_municipios.getSabado()==null?"":t_jw_prazos_municipios.getSabado();
                      domingo = t_jw_prazos_municipios.getDomingo()==null?"":t_jw_prazos_municipios.getDomingo();
                      String style_bl_report_Jw_prazos_municipios="";
                      if (!((i_bl_report_Jw_prazos_municipios%2)!=0)) {
                        style_bl_report_Jw_prazos_municipios="rowColor";
                      } else {
                        style_bl_report_Jw_prazos_municipios="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_prazos_municipios %>' id="TRbl_report_Jw_prazos_municipios<%=i_bl_report_Jw_prazos_municipios%>" >
                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((codigo!=null)?codigo.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= descricao %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= distrito %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= codigo_ibge %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= est_unifed %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((prazo_entrega!=null)?prazo_entrega.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%
                          if(segunda.equalsIgnoreCase("X")){
                            %>
                            <%
                            if(!(request.getParameter("excel")+"").equals("true")){
                              %>
                              <img src="../img/mark.gif" >
                            </img>
                            <%
                          } else {
                            %>
                            X
                            <%
                          }
                          %>
                          <%
                        }
                        %>

                      </td>
                      <td class="reportColumn" style="text-align:center;" >
                        <%
                        if(terca.equalsIgnoreCase("X")){
                          %>
                          <%
                          if(!(request.getParameter("excel")+"").equals("true")){
                            %>
                            <img src="../img/mark.gif" >
                          </img>
                          <%
                        } else {
                          %>
                          X
                          <%
                        }
                        %>
                        <%
                      }
                      %>

                    </td>
                    <td class="reportColumn" style="text-align:center;" >
                      <%
                      if(quarta.equalsIgnoreCase("X")){
                        %>
                        <%
                        if(!(request.getParameter("excel")+"").equals("true")){
                          %>
                          <img src="../img/mark.gif" >
                        </img>
                        <%
                      } else {
                        %>
                        X
                        <%
                      }
                      %>
                      <%
                    }
                    %>

                  </td>
                  <td class="reportColumn" style="text-align:center;" >
                    <%
                    if(quinta.equalsIgnoreCase("X")){
                      %>
                      <%
                      if(!(request.getParameter("excel")+"").equals("true")){
                        %>
                        <img src="../img/mark.gif" >
                      </img>
                      <%
                    } else {
                      %>
                      X
                      <%
                    }
                    %>
                    <%
                  }
                  %>

                </td>
                <td class="reportColumn" style="text-align:center;" >
                  <%
                  if(sexta.equalsIgnoreCase("X")){
                    %>
                    <%
                    if(!(request.getParameter("excel")+"").equals("true")){
                      %>
                      <img src="../img/mark.gif" >
                    </img>
                    <%
                  } else {
                    %>
                    X
                    <%
                  }
                  %>
                  <%
                }
                %>

              </td>
              <td class="reportColumn" style="text-align:center;" >
                <%
                if(sabado.equalsIgnoreCase("X")){
                  %>
                  <%
                  if(!(request.getParameter("excel")+"").equals("true")){
                    %>
                    <img src="../img/mark.gif" >
                  </img>
                  <%
                } else {
                  %>
                  X
                  <%
                }
                %>
                <%
              }
              %>

            </td>
            <td class="reportColumn" style="text-align:center;" >
              <%
              if(domingo.equalsIgnoreCase("X")){
                %>
                <%
                if(!(request.getParameter("excel")+"").equals("true")){
                  %>
                  <img src="../img/mark.gif" >
                </img>
                <%
              } else {
                %>
                X
                <%
              }
              %>
              <%
            }
            %>

          </td>
        </tr>

        <%
        i_bl_report_Jw_prazos_municipios++;
        if (i_bl_report_Jw_prazos_municipios<res_Jw_prazos_municipios.size()) {
          t_jw_prazos_municipios = (portalbr.dbobj.view.Jw_prazos_municipios)res_Jw_prazos_municipios.elementAt(i_bl_report_Jw_prazos_municipios);
          codigo = t_jw_prazos_municipios.getCodigo();
          est_descri = t_jw_prazos_municipios.getEst_descri()==null?"":t_jw_prazos_municipios.getEst_descri();
          descricao = t_jw_prazos_municipios.getDescricao()==null?"":t_jw_prazos_municipios.getDescricao();
          distrito = t_jw_prazos_municipios.getDistrito()==null?"":t_jw_prazos_municipios.getDistrito();
          codigo_ibge = t_jw_prazos_municipios.getCodigo_ibge()==null?"":t_jw_prazos_municipios.getCodigo_ibge();
          est_unifed = t_jw_prazos_municipios.getEst_unifed()==null?"":t_jw_prazos_municipios.getEst_unifed();
          prazo_entrega = t_jw_prazos_municipios.getPrazo_entrega();
          sigla_transportadora = t_jw_prazos_municipios.getSigla_transportadora()==null?"":t_jw_prazos_municipios.getSigla_transportadora();
          segunda = t_jw_prazos_municipios.getSegunda()==null?"":t_jw_prazos_municipios.getSegunda();
          terca = t_jw_prazos_municipios.getTerca()==null?"":t_jw_prazos_municipios.getTerca();
          quarta = t_jw_prazos_municipios.getQuarta()==null?"":t_jw_prazos_municipios.getQuarta();
          quinta = t_jw_prazos_municipios.getQuinta()==null?"":t_jw_prazos_municipios.getQuinta();
          sexta = t_jw_prazos_municipios.getSexta()==null?"":t_jw_prazos_municipios.getSexta();
          sabado = t_jw_prazos_municipios.getSabado()==null?"":t_jw_prazos_municipios.getSabado();
          domingo = t_jw_prazos_municipios.getDomingo()==null?"":t_jw_prazos_municipios.getDomingo();
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

<html:form action="com/MunicipiosPrazos_rForm.do" method="post" styleClass="baseForm">
<table class="messageTable" style='width:99%;'>
  <tr class="messageTr" >
    <td class="messageTd">
      <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form"/>
    </td>
  </tr>
</table>

<table class="buttonTable" style='width:99%;'>
  <tr class="buttonTr">
    <td class="buttonTd">
      <%
      if(!(request.getParameter("excel")+"").equals("true")){
        %>
        <html:submit accesskey="a" styleClass="baseButton" property="back_action">
          <bean:message bundle="ApplicationResources" key="jsp.back"/>
        </html:submit>
        <%
      } else {
        %>
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
