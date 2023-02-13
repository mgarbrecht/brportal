<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Consulta Entrada Origem
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(76)){
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
              java.util.Vector res_Jw_entrada_origem = null;
              com.egen.util.jdbc.JdbcUtil j = null;
              try {
                j = new com.egen.util.jdbc.JdbcUtil();
                portalbr.dbobj.view.Jw_entrada_origem t_jw_entrada_origem = new portalbr.dbobj.view.Jw_entrada_origem();
                String[][] select = {{"dt_digitacao",null},{"dt_cad_situacao",null},{"ped_nmro",null},{"pedido_origem",null},{"maquina",null},{"representante",null},{"regional",null},{"pares",null},};
                Object[][] where = null;
                String[] groupby =  null;
                String[] having =  null;
                String[] order =  null;
                res_Jw_entrada_origem = j.select(t_jw_entrada_origem,select,where,groupby,having,order);
              } catch (Exception e){
                session.setAttribute("exception",com.egen.util.system.Error.getDescription(e));
                %>
                <jsp:forward page="/system/ErrorPage.jsp"/>
                <%
              } finally {
              if(j!=null){j.close();}
            }
            %>

            <form  name="bl_report_Jw_entrada_origem" id="bl_report_Jw_entrada_origem" class="baseForm" method="post" >
              <%
              if (res_Jw_entrada_origem!=null && res_Jw_entrada_origem.size()>0) {
                if ( ((String)request.getParameter("_ordered"))!=null && ((String)request.getParameter("_ordered")).length()>0 ) {
                  boolean reverse = false;
                  if ( ((String)request.getParameter("_reverse"))!=null && ((String)request.getParameter("_reverse")).equals("true") ){
                    reverse = true;
                  }
                  try {
                    res_Jw_entrada_origem = com.egen.util.text.Sort.execute(res_Jw_entrada_origem,((String)request.getParameter("_ordered")),reverse);
                  } catch (Exception e) {}
                }
                %>

                <table id="TRbl_report_Jw_entrada_origem"  class="reportTable"   style="width:99%; "  border="1" >
                  <%
                  java.sql.Timestamp dt_digitacao =  null;
                  java.lang.String dt_cad_situacao =  null;
                  java.lang.Integer ped_nmro =  null;
                  java.lang.String pedido_origem =  null;
                  java.lang.String maquina =  null;
                  java.lang.String representante =  null;
                  java.lang.String regional =  null;
                  java.lang.Integer pares =  null;
                  %>

                  <tr class="reportTr">
                    <td class="columnTdHeader" style="text-align:center;" >
                      Data Digitação
                      <%
                      if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                        %>
                        <a href='ConsultaEntradaOrigemForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","dt_digitacao")%>' class="reportOrder">
                          <bean:message key="report.orderedasc"/>
                        </a>
                        <%
                      } else {
                        %>
                        <a href='ConsultaEntradaOrigemForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","dt_digitacao")%>' class="reportOrder">
                          <bean:message key="report.ordereddesc"/>
                        </a>
                        <%
                      }
                      %>
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Dt. Cad. Situação
                      <%
                      if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                        %>
                        <a href='ConsultaEntradaOrigemForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","dt_cad_situacao")%>' class="reportOrder">
                          <bean:message key="report.orderedasc"/>
                        </a>
                        <%
                      } else {
                        %>
                        <a href='ConsultaEntradaOrigemForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","dt_cad_situacao")%>' class="reportOrder">
                          <bean:message key="report.ordereddesc"/>
                        </a>
                        <%
                      }
                      %>
                    </td>

                    <td class="columnTdHeader" style="text-align:right;" >
                      Pedido
                      <%
                      if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                        %>
                        <a href='ConsultaEntradaOrigemForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","ped_nmro")%>' class="reportOrder">
                          <bean:message key="report.orderedasc"/>
                        </a>
                        <%
                      } else {
                        %>
                        <a href='ConsultaEntradaOrigemForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","ped_nmro")%>' class="reportOrder">
                          <bean:message key="report.ordereddesc"/>
                        </a>
                        <%
                      }
                      %>
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Pedido Origem
                      <%
                      if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                        %>
                        <a href='ConsultaEntradaOrigemForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","pedido_origem")%>' class="reportOrder">
                          <bean:message key="report.orderedasc"/>
                        </a>
                        <%
                      } else {
                        %>
                        <a href='ConsultaEntradaOrigemForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","pedido_origem")%>' class="reportOrder">
                          <bean:message key="report.ordereddesc"/>
                        </a>
                        <%
                      }
                      %>
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Máquina
                      <%
                      if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                        %>
                        <a href='ConsultaEntradaOrigemForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","maquina")%>' class="reportOrder">
                          <bean:message key="report.orderedasc"/>
                        </a>
                        <%
                      } else {
                        %>
                        <a href='ConsultaEntradaOrigemForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","maquina")%>' class="reportOrder">
                          <bean:message key="report.ordereddesc"/>
                        </a>
                        <%
                      }
                      %>
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Representante
                      <%
                      if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                        %>
                        <a href='ConsultaEntradaOrigemForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","representante")%>' class="reportOrder">
                          <bean:message key="report.orderedasc"/>
                        </a>
                        <%
                      } else {
                        %>
                        <a href='ConsultaEntradaOrigemForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","representante")%>' class="reportOrder">
                          <bean:message key="report.ordereddesc"/>
                        </a>
                        <%
                      }
                      %>
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Regional
                      <%
                      if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                        %>
                        <a href='ConsultaEntradaOrigemForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","regional")%>' class="reportOrder">
                          <bean:message key="report.orderedasc"/>
                        </a>
                        <%
                      } else {
                        %>
                        <a href='ConsultaEntradaOrigemForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","regional")%>' class="reportOrder">
                          <bean:message key="report.ordereddesc"/>
                        </a>
                        <%
                      }
                      %>
                    </td>

                    <td class="columnTdHeader" style="text-align:right;" >
                      Pares
                      <%
                      if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                        %>
                        <a href='ConsultaEntradaOrigemForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","pares")%>' class="reportOrder">
                          <bean:message key="report.orderedasc"/>
                        </a>
                        <%
                      } else {
                        %>
                        <a href='ConsultaEntradaOrigemForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","pares")%>' class="reportOrder">
                          <bean:message key="report.ordereddesc"/>
                        </a>
                        <%
                      }
                      %>
                    </td>

                  </tr>

                  <%
                  int i_bl_report_Jw_entrada_origem = 0;
                  while (i_bl_report_Jw_entrada_origem<res_Jw_entrada_origem.size()) {
                    portalbr.dbobj.view.Jw_entrada_origem t_jw_entrada_origem = (portalbr.dbobj.view.Jw_entrada_origem)res_Jw_entrada_origem.elementAt(i_bl_report_Jw_entrada_origem);
                    dt_digitacao = (java.sql.Timestamp)t_jw_entrada_origem.getDt_digitacao();
                    dt_cad_situacao = t_jw_entrada_origem.getDt_cad_situacao()==null?"":t_jw_entrada_origem.getDt_cad_situacao();
                    ped_nmro = t_jw_entrada_origem.getPed_nmro();
                    pedido_origem = t_jw_entrada_origem.getPedido_origem()==null?"":t_jw_entrada_origem.getPedido_origem();
                    maquina = t_jw_entrada_origem.getMaquina()==null?"":t_jw_entrada_origem.getMaquina();
                    representante = t_jw_entrada_origem.getRepresentante()==null?"":t_jw_entrada_origem.getRepresentante();
                    regional = t_jw_entrada_origem.getRegional()==null?"":t_jw_entrada_origem.getRegional();
                    pares = t_jw_entrada_origem.getPares();
                    String style_bl_report_Jw_entrada_origem="";
                    if (!((i_bl_report_Jw_entrada_origem%2)!=0)) {
                      style_bl_report_Jw_entrada_origem="rowColor";
                    } else {
                      style_bl_report_Jw_entrada_origem="rowBlank";
                    }
                    %>

                    <tr class='<%= style_bl_report_Jw_entrada_origem %>' id="TRbl_report_Jw_entrada_origem<%=i_bl_report_Jw_entrada_origem%>" >
                      <td class="reportColumn" style="text-align:center;" >
                        <%= com.egen.util.text.FormatDate.format(dt_digitacao, "dd/MM/yyyy HH:mm:ss") %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= dt_cad_situacao %>
                      </td>

                      <td class="reportColumn" style="text-align:right;" >
                        <%= ((ped_nmro!=null)?ped_nmro.toString():"") %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= pedido_origem %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= maquina %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= representante %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= regional %>
                      </td>

                      <td class="reportColumn" style="text-align:right;" >
                        <%= ((pares!=null)?pares.toString():"") %>
                      </td>

                    </tr>

                    <%
                    i_bl_report_Jw_entrada_origem++;
                    if (i_bl_report_Jw_entrada_origem<res_Jw_entrada_origem.size()) {
                      t_jw_entrada_origem = (portalbr.dbobj.view.Jw_entrada_origem)res_Jw_entrada_origem.elementAt(i_bl_report_Jw_entrada_origem);
                      dt_digitacao = (java.sql.Timestamp)t_jw_entrada_origem.getDt_digitacao();
                      dt_cad_situacao = t_jw_entrada_origem.getDt_cad_situacao()==null?"":t_jw_entrada_origem.getDt_cad_situacao();
                      ped_nmro = t_jw_entrada_origem.getPed_nmro();
                      pedido_origem = t_jw_entrada_origem.getPedido_origem()==null?"":t_jw_entrada_origem.getPedido_origem();
                      maquina = t_jw_entrada_origem.getMaquina()==null?"":t_jw_entrada_origem.getMaquina();
                      representante = t_jw_entrada_origem.getRepresentante()==null?"":t_jw_entrada_origem.getRepresentante();
                      regional = t_jw_entrada_origem.getRegional()==null?"":t_jw_entrada_origem.getRegional();
                      pares = t_jw_entrada_origem.getPares();
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

        </td>
      </tr>
    </table>

  </body>
</center>
</html>
