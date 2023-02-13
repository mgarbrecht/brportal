<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Consulta de Duplicatas
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(83)){
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
              java.util.Vector res_Jw_titulos_pedidos = (java.util.Vector)session.getAttribute("res_Jw_titulos_pedidos");
              %>

              <form  name="bl_report_Jw_titulos_pedidos" id="bl_report_Jw_titulos_pedidos" class="baseForm" method="post" >
                <%
                if (res_Jw_titulos_pedidos!=null && res_Jw_titulos_pedidos.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_titulos_pedidos"  class="reportTable"   style="width:99%; "  border="1" >
                    <%
                    java.lang.String emp_empresa =  null;
                    java.lang.String fil_filial =  null;
                    java.lang.String tip_codigo =  null;
                    java.lang.String tit_codigo =  null;
                    int ped_nmro =  0;
                    java.lang.String cliente =  null;
                    java.lang.String representante =  null;
                    java.lang.String nf =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:left;" >
                        Empresa
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Filial
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Tipo
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Título
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Pedido
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Cliente
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Representante
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        NF
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Jw_titulos_pedidos = 0;
                    while (i_bl_report_Jw_titulos_pedidos<res_Jw_titulos_pedidos.size()) {
                      portalbr.dbobj.view.Jw_titulos_pedidos t_jw_titulos_pedidos = (portalbr.dbobj.view.Jw_titulos_pedidos)res_Jw_titulos_pedidos.elementAt(i_bl_report_Jw_titulos_pedidos);
                      emp_empresa = t_jw_titulos_pedidos.getEmp_empresa()==null?"":t_jw_titulos_pedidos.getEmp_empresa();
                      fil_filial = t_jw_titulos_pedidos.getFil_filial()==null?"":t_jw_titulos_pedidos.getFil_filial();
                      tip_codigo = t_jw_titulos_pedidos.getTip_codigo()==null?"":t_jw_titulos_pedidos.getTip_codigo();
                      tit_codigo = t_jw_titulos_pedidos.getTit_codigo()==null?"":t_jw_titulos_pedidos.getTit_codigo();
                      ped_nmro = t_jw_titulos_pedidos.getPed_nmro();
                      cliente = t_jw_titulos_pedidos.getCliente()==null?"":t_jw_titulos_pedidos.getCliente();
                      representante = t_jw_titulos_pedidos.getRepresentante()==null?"":t_jw_titulos_pedidos.getRepresentante();
                      nf = t_jw_titulos_pedidos.getNf()==null?"":t_jw_titulos_pedidos.getNf();
                      String style_bl_report_Jw_titulos_pedidos="";
                      if (!((i_bl_report_Jw_titulos_pedidos%2)!=0)) {
                        style_bl_report_Jw_titulos_pedidos="rowColor";
                      } else {
                        style_bl_report_Jw_titulos_pedidos="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_titulos_pedidos %>' id="TRbl_report_Jw_titulos_pedidos<%=i_bl_report_Jw_titulos_pedidos%>" >
                        <td class="reportColumn" style="text-align:left;" >
                          <%= emp_empresa %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= fil_filial %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= tip_codigo %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <a href="../com/ConsultaDuplicataForm.do?select_action=&emp_empresa=<%= emp_empresa %>&fil_filial=<%= fil_filial %>&tip=<%= tip_codigo %>&titulo=<%= tit_codigo %>&duplicata=<%= tit_codigo %>&pedido=<%= ped_nmro %>&cliente=<%= cliente %>&rep=<%= representante %>&nf=<%= nf %>" style="cursor:hand">
                            <%= tit_codigo %>
                          </a>

                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ped_nmro %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= cliente %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= representante %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= nf %>
                        </td>

                      </tr>

                      <%
                      i_bl_report_Jw_titulos_pedidos++;
                      if (i_bl_report_Jw_titulos_pedidos<res_Jw_titulos_pedidos.size()) {
                        t_jw_titulos_pedidos = (portalbr.dbobj.view.Jw_titulos_pedidos)res_Jw_titulos_pedidos.elementAt(i_bl_report_Jw_titulos_pedidos);
                        emp_empresa = t_jw_titulos_pedidos.getEmp_empresa()==null?"":t_jw_titulos_pedidos.getEmp_empresa();
                        fil_filial = t_jw_titulos_pedidos.getFil_filial()==null?"":t_jw_titulos_pedidos.getFil_filial();
                        tip_codigo = t_jw_titulos_pedidos.getTip_codigo()==null?"":t_jw_titulos_pedidos.getTip_codigo();
                        tit_codigo = t_jw_titulos_pedidos.getTit_codigo()==null?"":t_jw_titulos_pedidos.getTit_codigo();
                        ped_nmro = t_jw_titulos_pedidos.getPed_nmro();
                        cliente = t_jw_titulos_pedidos.getCliente()==null?"":t_jw_titulos_pedidos.getCliente();
                        representante = t_jw_titulos_pedidos.getRepresentante()==null?"":t_jw_titulos_pedidos.getRepresentante();
                        nf = t_jw_titulos_pedidos.getNf()==null?"":t_jw_titulos_pedidos.getNf();
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

            <html:form action="adm/Titulos_sForm.do" method="post" styleClass="baseForm">
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
                    <html:submit accesskey="a" styleClass="baseButton" property="back_action">
                      <bean:message bundle="ApplicationResources" key="jsp.back"/>
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
