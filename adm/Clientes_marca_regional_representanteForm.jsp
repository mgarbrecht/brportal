<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Sumário de Clientes
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
                  <%@ include file="../system/header_data.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(58)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <table id="TRbl_report_Clientes_marca_regional_representante" class="reportTable" style=width:99%; frame=box; border=1; >
              <%
              int counterbl_report_Clientes_marca_regional_representante=0;
              try {

                portalbr.dbobj.view.Clientes_marca_regional_representante t_clientes_marca_regional_representante = new portalbr.dbobj.view.Clientes_marca_regional_representante();
                java.util.Vector res_Clientes_marca_regional_representante = (java.util.Vector)session.getAttribute("res_Clientes_marca_regional_representante");
                if (res_Clientes_marca_regional_representante!=null && res_Clientes_marca_regional_representante.size()>0) {
                  util.consultas.TotaisClientesAtendidos total = new util.consultas.TotaisClientesAtendidos(session,"null","null");
                  util.consultas.TotaisClientesAtendidos totalRegional = null;
                  util.consultas.TotaisClientesAtendidos totalMarca = null;
                  java.lang.String marca                   =  null;
                  java.lang.String codigo_marca            =  null;
                  java.lang.String codigo_regional         =  null;
                  java.lang.String regional                =  null;
                  java.lang.String rep_cdgo                =  null;
                  java.lang.String rep_nome                =  null;
                  java.lang.Integer grupos_ativos          =  null;
                  java.lang.Integer grupos_atendidos       =  null;
                  java.lang.Integer grupos_nao_atendidos   =  null;
                  java.lang.Integer clientes_ativos        =  null;
                  java.lang.Integer clientes_atendidos     =  null;
                  java.lang.Integer clientes_nao_atendidos =  null;
                  java.lang.Integer cidades_ativas         =  null;
                  java.lang.Integer cidades_atendidas      =  null;
                  java.lang.Integer cidades_nao_atendidas  =  null;
                  int total_geral_pares                    =  0;
                  double total_geral_valor                 =  0;
                  int pares                                =  0;
                  double valor                             =  0;
                  int contador                             =  0;
                  int i_bl_report_Clientes_marca_regional_representante = 0;

                  t_clientes_marca_regional_representante = (portalbr.dbobj.view.Clientes_marca_regional_representante)res_Clientes_marca_regional_representante.elementAt(i_bl_report_Clientes_marca_regional_representante);
                  marca = t_clientes_marca_regional_representante.getMarca()==null?"":t_clientes_marca_regional_representante.getMarca();
                  codigo_marca           = t_clientes_marca_regional_representante.getCodigo_marca()==null?"":t_clientes_marca_regional_representante.getCodigo_marca();
                  codigo_regional        = t_clientes_marca_regional_representante.getCodigo_regional()==null?"":t_clientes_marca_regional_representante.getCodigo_regional();
                  regional               = t_clientes_marca_regional_representante.getRegional()==null?"":t_clientes_marca_regional_representante.getRegional();
                  rep_cdgo               = t_clientes_marca_regional_representante.getRep_cdgo()==null?"":t_clientes_marca_regional_representante.getRep_cdgo();
                  rep_nome               = t_clientes_marca_regional_representante.getRep_nome()==null?"":t_clientes_marca_regional_representante.getRep_nome();
                  grupos_ativos          = t_clientes_marca_regional_representante.getGrupos_ativos()==null?0:t_clientes_marca_regional_representante.getGrupos_ativos();
                  grupos_atendidos       = t_clientes_marca_regional_representante.getGrupos_atendidos()==null?0:t_clientes_marca_regional_representante.getGrupos_atendidos();
                  grupos_nao_atendidos   = t_clientes_marca_regional_representante.getGrupos_nao_atendidos()==null?0:t_clientes_marca_regional_representante.getGrupos_nao_atendidos();
                  clientes_ativos        = t_clientes_marca_regional_representante.getClientes_ativos()==null?0:t_clientes_marca_regional_representante.getClientes_ativos();
                  clientes_atendidos     = t_clientes_marca_regional_representante.getClientes_atendidos()==null?0:t_clientes_marca_regional_representante.getClientes_atendidos();
                  clientes_nao_atendidos = t_clientes_marca_regional_representante.getClientes_nao_atendidos()==null?0:t_clientes_marca_regional_representante.getClientes_nao_atendidos();
                  cidades_ativas         = t_clientes_marca_regional_representante.getCidades_ativas()==null?0:t_clientes_marca_regional_representante.getCidades_ativas();
                  cidades_atendidas      = t_clientes_marca_regional_representante.getCidades_atendidas()==null?0:t_clientes_marca_regional_representante.getCidades_atendidas();
                  cidades_nao_atendidas  = t_clientes_marca_regional_representante.getCidades_nao_atendidas()==null?0:t_clientes_marca_regional_representante.getCidades_nao_atendidas();
                  pares                  = Integer.parseInt(t_clientes_marca_regional_representante.getPares()+"");
                  valor                  = Double.parseDouble(t_clientes_marca_regional_representante.getValor()+"");

                  java.lang.String b0_marca    =  null;
                  java.lang.String b1_regional =  null;


                  while (i_bl_report_Clientes_marca_regional_representante<res_Clientes_marca_regional_representante.size()){

                    counterbl_report_Clientes_marca_regional_representante++;
                    %>
                    <%if(counterbl_report_Clientes_marca_regional_representante>

                      1){ %>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <tr>
                      </tr>
                      <%
                    }
                    %>
                    <tr class="reportHeader3">
                      <td colspan=100%>
                        <font size=4>
                          Marca :
                          <%= marca %>
                        </font>
                        <%
                        totalMarca = new util.consultas.TotaisClientesAtendidos(session,codigo_marca+"","null");
                        %>
                      </td>
                    </tr>
                    <%
                    int total_pares    =  0;
                    double total_valor =  0;
                    b0_marca           =  marca;
                    while (i_bl_report_Clientes_marca_regional_representante<res_Clientes_marca_regional_representante.size() &&  (b0_marca==null?"":b0_marca).equals((marca==null?"":marca))){
                      counterbl_report_Clientes_marca_regional_representante++;
                      %>
                      <tr class="reportHeader2" >
                        <td colspan=100%>
                          Regional :
                          <%= regional %>
                          <%
                          totalRegional = new util.consultas.TotaisClientesAtendidos(session,codigo_marca+"",codigo_regional+"");
                          %>
                        </td>
                      </tr>
                      <%
                      int sum_pares_1 = 0;
                      double sum_valor_1 = 0;
                      b1_regional = regional;
                      %>
                      <tr class="reportHeader" valign="top">
                        <td class="columnTdHeader" style="text-align:left;">
                          Representante
                        </td>

                        <%
                        if(session.getAttribute("ca_consulta_grupos")=="S"){
                          %>

                          <td class="columnTdHeader" style="text-align:center;">
                            <%
                            if(contador==0) {
                              %>
                              <%
                              if(!(request.getParameter("excel")+"").equals("true")){
                                %>
                                <img style=cursor:pointer src=../img/ballhelp.gif border=0 onmouseout="this.src='../img/ballhelp.gif'" onmouseover="this.src='../img/ballhelp_c.gif'" onclick="javascript:window.open('../lov/HelpForm.jsp?help=Total de grupos econômicos <b>ativos</b> do representante.','def','scrollbars,height=400,width=340,TOP=0,LEFT=0')">
                                <%
                              }
                              %>
                              <br>
                              <%
                            }
                            %>
                            Grupos
                            <br>
                            Ativos
                          </td>
                          <td class="columnTdHeader" style="text-align:center;">
                            <%
                            if(contador==0) {
                              %>
                              <%
                              if(!(request.getParameter("excel")+"").equals("true")){
                                %>
                                <img style=cursor:pointer src=../img/ballhelp.gif border=0 onmouseout="this.src='../img/ballhelp.gif'" onmouseover="this.src='../img/ballhelp_c.gif'" onclick="javascript:window.open('../lov/HelpForm.jsp?help=Total de grupos econômicos <b>ativos</b> do representante que foram atendidos dentro do período, marca e linha informados. (Período com base na data de digitação dos pedidos).','def','scrollbars,height=400,width=340,TOP=0,LEFT=0')">
                                <%
                              }
                              %>
                              <br>
                              <%
                            }
                            %>
                            Grupos
                            <br>
                            Atendidos
                          </td>
                          <td class="columnTdHeader" style="text-align:center;">
                            <%
                            if(contador==0) {
                              %>
                              <%
                              if(!(request.getParameter("excel")+"").equals("true")){
                                %>
                                <img style=cursor:pointer src=../img/ballhelp.gif border=0 onmouseout="this.src='../img/ballhelp.gif'" onmouseover="this.src='../img/ballhelp_c.gif'" onclick="javascript:window.open('../lov/HelpForm.jsp?help=Total de grupos econômicos <b>ativos</b> do representante que não foram atendidos dentro do período, marca e linha informados. (Período com base na data de digitação dos pedidos).','def','scrollbars,height=400,width=340,TOP=0,LEFT=0')">
                                <%
                              }
                              %>
                              <br>
                              <%
                            }
                            %>
                            Grupos
                            <br>
                            Não Atendidos
                          </td>

                          <%
                        }
                        %>


                        <%
                        if(session.getAttribute("ca_consulta_clientes")=="S"){
                          %>

                          <td class="columnTdHeader" style="text-align:center;">
                            <%
                            if(contador==0) {
                              %>
                              <%
                              if(!(request.getParameter("excel")+"").equals("true")){
                                %>
                                <img style=cursor:pointer src=../img/ballhelp.gif border=0 onmouseout="this.src='../img/ballhelp.gif'" onmouseover="this.src='../img/ballhelp_c.gif'" onclick="javascript:window.open('../lov/HelpForm.jsp?help=Total de clientes <b>ativos</b> do representante.','def','scrollbars,height=400,width=340,TOP=0,LEFT=0')">
                                <%
                              }
                              %>
                              <br>
                              <%
                            }
                            %>
                            Clientes
                            <br>
                            Ativos
                          </td>
                          <td class="columnTdHeader" style="text-align:center;">
                            <%
                            if(contador==0) {
                              %>
                              <%
                              if(!(request.getParameter("excel")+"").equals("true")){
                                %>
                                <img style=cursor:pointer src=../img/ballhelp.gif border=0 onmouseout="this.src='../img/ballhelp.gif'" onmouseover="this.src='../img/ballhelp_c.gif'" onclick="javascript:window.open('../lov/HelpForm.jsp?help=Total de clientes <b>ativos</b> do representante que foram atendidos dentro do período, marca e linha informados. (Período com base na data de digitação dos pedidos).','def','scrollbars,height=400,width=340,TOP=0,LEFT=0')">
                                <%
                              }
                              %>
                              <br>
                              <%
                            }
                            %>
                            Clientes
                            <br>
                            Atendidos
                          </td>


                          <td class="columnTdHeader" style="text-align:center;">
                            <%
                            if(contador==0) {
                              %>
                              <%
                              if(!(request.getParameter("excel")+"").equals("true")){
                                %>
                                <img style=cursor:pointer src=../img/ballhelp.gif border=0 onmouseout="this.src='../img/ballhelp.gif'" onmouseover="this.src='../img/ballhelp_c.gif'" onclick="javascript:window.open('../lov/HelpForm.jsp?help=Total de clientes <b>ativos</b> do representante que não foram atendidos dentro do período, marca e linha informados. (Período com base na data de digitação dos pedidos).','def','scrollbars,height=400,width=340,TOP=0,LEFT=0')">
                                <%
                              }
                              %>
                              <br>
                              <%
                            }
                            %>
                            Clientes
                            <br>
                            Não Atendidos
                          </td>

                          <%
                        }
                        %>


                        <%
                        if(session.getAttribute("ca_consulta_cidades")=="S"){
                          %>

                          <td class="columnTdHeader" style="text-align:center;">
                            <%
                            if(contador==0) {
                              %>
                              <%
                              if(!(request.getParameter("excel")+"").equals("true")){
                                %>
                                <img style=cursor:pointer src=../img/ballhelp.gif border=0 onmouseout="this.src='../img/ballhelp.gif'" onmouseover="this.src='../img/ballhelp_c.gif'" onclick="javascript:window.open('../lov/HelpForm.jsp?help=Total de cidades <b>ativas</b> do representante.','def','scrollbars,height=400,width=340,TOP=0,LEFT=0')">
                                <%
                              }
                              %>
                              <br>
                              <%
                            }
                            %>
                            Cidades
                            <br>
                            Ativas
                          </td>
                          <td class="columnTdHeader" style="text-align:center;">
                            <%
                            if(contador==0) {
                              %>
                              <%
                              if(!(request.getParameter("excel")+"").equals("true")){
                                %>
                                <img style=cursor:pointer src=../img/ballhelp.gif border=0 onmouseout="this.src='../img/ballhelp.gif'" onmouseover="this.src='../img/ballhelp_c.gif'" onclick="javascript:window.open('../lov/HelpForm.jsp?help=Total de cidades <b>ativas</b> do representante que foram atendidas dentro do período, marca e linha informados. (Período com base na data de digitação dos pedidos).','def','scrollbars,height=400,width=340,TOP=0,LEFT=0')">
                                <%
                              }
                              %>
                              <br>
                              <%
                            }
                            %>
                            Cidades
                            <br>
                            Atendidas
                          </td>
                          <td class="columnTdHeader" style="text-align:center;">
                            <%
                            if(contador==0) {
                              %>
                              <%
                              if(!(request.getParameter("excel")+"").equals("true")){
                                %>
                                <img style=cursor:pointer src=../img/ballhelp.gif border=0 onmouseout="this.src='../img/ballhelp.gif'" onmouseover="this.src='../img/ballhelp_c.gif'" onclick="javascript:window.open('../lov/HelpForm.jsp?help=Total de cidades <b>ativas</b> do representante que não foram atendidas dentro do período, marca e linha informados. (Período com base na data de digitação dos pedidos).','def','scrollbars,height=400,width=340,TOP=0,LEFT=0')">
                                <%
                              }
                              %>
                              <br>
                              <%
                              } contador++;
                              %>
                              Cidades
                              <br>
                              Não Atendidas
                            </td>

                            <%
                          }
                          %>


                          <td class="columnTdHeader" style="text-align:right;">
                            Pares
                          </td>
                          <td class="columnTdHeader" style="text-align:right;">
                            Valor
                          </td>
                        </tr>
                        <%
                        while (i_bl_report_Clientes_marca_regional_representante<res_Clientes_marca_regional_representante.size() &&  (b0_marca==null?"":b0_marca).equals((marca==null?"":marca)) &&  (b1_regional==null?"":b1_regional).equals((regional==null?"":regional))){
                          counterbl_report_Clientes_marca_regional_representante++;
                          total_pares        += pares;
                          total_valor        += valor;
                          sum_pares_1        += pares;
                          sum_valor_1        += valor;
                          total_geral_pares  += pares;
                          total_geral_valor  += valor;
                          String style="";
                          if (!((i_bl_report_Clientes_marca_regional_representante%2)!=0)) {
                            style="rowColor";
                          } else {
                            style="rowBlank";
                          }
                          %>
                          <tr class=<%= style %> id='TRbl_report_Clientes_marca_regional_representante<%=counterbl_report_Clientes_marca_regional_representante%>'  >
                            <td class="reportColumn" style="text-align:left;">
                              <%= rep_cdgo %>
                              -
                              <%= rep_nome %>
                            </td>

                            <%
                            if(session.getAttribute("ca_consulta_grupos")=="S"){
                              %>

                              <td class="reportColumn" style="text-align:center;" title="Grupos Ativos do Representante: <%= rep_cdgo %>-<%= rep_nome %>">
                                <%
                                if(Integer.parseInt(grupos_ativos+"")>0) {
                                  %>
                                  <%
                                  if(!(request.getParameter("excel")+"").equals("true")){
                                    %>
                                    <a href="../adm/GruposAtivosForm.do?select_action=&cod_marca=<%= codigo_marca %>&cod_regional=<%= codigo_regional %>&cod_rep=<%= rep_cdgo %>&grupo=do Representante : <%= rep_nome.replace('&','*') %>" target="_self" STYLE="cursor:hand" onclick="bloqueia();">
                                      <%= com.egen.util.text.FormatNumber.format(grupos_ativos, "##,##0.##")  %>
                                    </a>
                                    <%
                                  } else {
                                    %>
                                    <%= com.egen.util.text.FormatNumber.format(grupos_ativos, "##,##0.##")  %>
                                    <%
                                  }
                                  %>
                                  <%
                                } else {
                                  %>
                                  <font color="gray">
                                    0
                                  </font>
                                  <%
                                }
                                %>
                              </td>
                              <td class="reportColumn" style="text-align:center;" title="Grupos Atendidos do Representante: <%= rep_cdgo %>-<%= rep_nome %>">
                                <%
                                if(Integer.parseInt(grupos_atendidos+"")>0) {
                                  %>
                                  <%
                                  if(!(request.getParameter("excel")+"").equals("true")){
                                    %>
                                    <a href="../adm/GruposAtendidosForm.do?select_action=&cod_marca=<%= codigo_marca %>&cod_regional=<%= codigo_regional %>&cod_rep=<%= rep_cdgo %>&grupo=do Representante : <%= rep_nome.replace('&','*') %>" target="_self" STYLE="cursor:hand" onclick="bloqueia();">
                                      <%= com.egen.util.text.FormatNumber.format(grupos_atendidos, "##,##0.##")  %>
                                    </a>
                                    <%
                                  } else {
                                    %>
                                    <%= com.egen.util.text.FormatNumber.format(grupos_atendidos, "##,##0.##")  %>
                                    <%
                                  }
                                  %>
                                  <%
                                } else {
                                  %>
                                  <font color="gray">
                                    0
                                  </font>
                                  <%
                                }
                                %>
                              </td>
                              <td class="reportColumn" style="text-align:center;" title="Grupos Não Atendidos do Representante: <%= rep_cdgo %>-<%= rep_nome %>">
                                <%
                                if(Integer.parseInt(grupos_nao_atendidos+"")>0) {
                                  %>
                                  <%
                                  if(!(request.getParameter("excel")+"").equals("true")){
                                    %>
                                    <a href="../adm/GruposNaoAtendidosForm.do?select_action=&cod_marca=<%= codigo_marca %>&cod_regional=<%= codigo_regional %>&cod_rep=<%= rep_cdgo %>&grupo=do Representante : <%= rep_nome.replace('&','*') %>" target="_self" STYLE="cursor:hand" onclick="bloqueia();">
                                      <%= com.egen.util.text.FormatNumber.format(grupos_nao_atendidos, "##,##0.##")  %>
                                    </a>
                                    <%
                                  } else {
                                    %>
                                    <%= com.egen.util.text.FormatNumber.format(grupos_nao_atendidos, "##,##0.##")  %>
                                    <%
                                  }
                                  %>
                                  <%
                                } else {
                                  %>
                                  <font color="gray">
                                    0
                                  </font>
                                  <%
                                }
                                %>
                              </td>

                              <%
                            }
                            %>


                            <%
                            if(session.getAttribute("ca_consulta_clientes")=="S"){
                              %>

                              <td class="reportColumn" style="text-align:center;" title="Clientes Ativos do Representante: <%= rep_cdgo %>-<%= rep_nome %>">
                                <%
                                if(Integer.parseInt(clientes_ativos+"")>0) {
                                  %>
                                  <%
                                  if(!(request.getParameter("excel")+"").equals("true")){
                                    %>
                                    <a href="../adm/Clientes_ativosForm.do?select_action=&codigo_marca=<%= codigo_marca %>&codigo_regional=<%= codigo_regional %>&rep_cdgo=<%= rep_cdgo %>&cab=do Representante : <%= rep_nome.replace('&','*') %>" target="_self" STYLE="cursor:hand" onclick="bloqueia();">
                                      <%= com.egen.util.text.FormatNumber.format(clientes_ativos, "##,##0.##")  %>
                                    </a>
                                    <%
                                  } else {
                                    %>
                                    <%= com.egen.util.text.FormatNumber.format(clientes_ativos, "##,##0.##")  %>
                                    <%
                                  }
                                  %>
                                  <%
                                } else {
                                  %>
                                  <font color="gray">
                                    0
                                  </font>
                                  <%
                                }
                                %>
                              </td>

                              <td class="reportColumn" style="text-align:center;" title="Clientes Atendidos do Representante: <%= rep_cdgo %>-<%= rep_nome %>">
                                <%
                                if(!(request.getParameter("excel")+"").equals("true")){
                                  %>
                                  <a href="../adm/Clientes_atendForm.do?select_action=&codigo_marca=<%= codigo_marca %>&codigo_regional=<%= codigo_regional %>&rep_cdgo=<%= rep_cdgo %>&cab=do Representante : <%= rep_nome.replace('&','*') %>" target="_self" STYLE="cursor:hand" onclick="bloqueia();">
                                    <%= com.egen.util.text.FormatNumber.format(clientes_atendidos, "##,##0.##")  %>
                                  </a>
                                  <%
                                } else {
                                  %>
                                  <%= com.egen.util.text.FormatNumber.format(clientes_atendidos, "##,##0.##")  %>
                                  <%
                                }
                                %>
                              </td>




                              <td class="reportColumn" style="text-align:center;" title="Clientes Não Atendidos do Representante: <%= rep_cdgo %>-<%= rep_nome %>">
                                <%
                                if(Integer.parseInt(clientes_nao_atendidos+"")>0) {
                                  %>
                                  <%
                                  if(!(request.getParameter("excel")+"").equals("true")){
                                    %>
                                    <a href="../adm/Clientes_nao_atendidosForm.do?select_action=&codigo_marca=<%= codigo_marca %>&codigo_regional=<%= codigo_regional %>&rep_cdgo=<%= rep_cdgo %>&cab=do Representante : <%= rep_nome.replace('&','*') %>" target="_self" STYLE="cursor:hand" onclick="bloqueia();">
                                      <%= com.egen.util.text.FormatNumber.format(clientes_nao_atendidos, "##,##0.##")  %>
                                    </a>
                                    <%
                                  } else {
                                    %>
                                    <%= com.egen.util.text.FormatNumber.format(clientes_nao_atendidos, "##,##0.##")  %>
                                    <%
                                  }
                                  %>
                                  <%
                                } else {
                                  %>
                                  <font color="gray">
                                    0
                                  </font>
                                  <%
                                }
                                %>
                              </td>

                              <%
                            }
                            %>


                            <%
                            if(session.getAttribute("ca_consulta_cidades")=="S"){
                              %>

                              <td class="reportColumn" style="text-align:center;" title="Cidades Ativas do Representante: <%= rep_cdgo %>-<%= rep_nome %>">
                                <%
                                if(Integer.parseInt(cidades_ativas+"")>0)   {
                                  %>
                                  <%
                                  if(!(request.getParameter("excel")+"").equals("true")){
                                    %>
                                    <a href="../adm/Cidades_ativasForm.do?select_action=&codigo_regional=<%= codigo_regional %>&codigo_marca=<%= codigo_marca %>&rep_cdgo=<%= rep_cdgo %>&cab_cidade=do Representante : <%= rep_nome.replace('&','*') %>&chamador=/adm/Clientes_marca_regional_representanteForm.jsp" target="_self" STYLE="cursor:hand" onclick="bloqueia();">
                                      <%= cidades_ativas %>
                                    </a>
                                    <%
                                  } else {
                                    %>
                                    <%= cidades_ativas %>
                                    <%
                                  }
                                  %>
                                  <%
                                } else {
                                  %>
                                  <font color="gray">
                                    0
                                  </font>
                                  <%
                                }
                                %>
                              </td>
                              <td class="reportColumn" style="text-align:center;" title="Cidades Atendidas do Representante: <%= rep_cdgo %>-<%= rep_nome %>">
                                <%
                                if(!(request.getParameter("excel")+"").equals("true")){
                                  %>
                                  <a href="../adm/Cidades_atendidasForm.do?select_action=&codigo_regional=<%= codigo_regional %>&codigo_marca=<%= codigo_marca %>&rep_cdgo=<%= rep_cdgo %>&cab_cidade=do Representante : <%= rep_nome.replace('&','*') %>&chamador=/adm/Clientes_marca_regional_representanteForm.jsp" target="_self" STYLE="cursor:hand" onclick="bloqueia();">
                                    <%= cidades_atendidas %>
                                  </a>
                                  <%
                                } else {
                                  %>
                                  <%= cidades_atendidas %>
                                  <%
                                }
                                %>
                              </td>
                              <td class="reportColumn" style="text-align:center;" title="Cidades Não Atendidos do Representante: <%= rep_cdgo %>-<%= rep_nome %>">
                                <%
                                if(Integer.parseInt(cidades_nao_atendidas+"")>0){
                                  %>
                                  <%
                                  if(!(request.getParameter("excel")+"").equals("true")){
                                    %>
                                    <a href="../adm/Cidades_nao_atendidasForm.do?select_action=&codigo_regional=<%= codigo_regional %>&codigo_marca=<%= codigo_marca %>&rep_cdgo=<%= rep_cdgo %>&cab_cidade=do Representante : <%= rep_nome.replace('&','*') %>&chamador=/adm/Clientes_marca_regional_representanteForm.jsp" target="_self" STYLE="cursor:hand" onclick="bloqueia();">
                                      <%= cidades_nao_atendidas %>
                                    </a>
                                    <%
                                  } else {
                                    %>
                                    <%= cidades_nao_atendidas %>
                                    <%
                                  }
                                  %>
                                  <%
                                }else{
                                  %>
                                  <font color="gray">
                                    0
                                  </font>
                                  <%
                                }
                                %>
                              </td>

                              <%
                            }
                            %>
                            <td class="reportColumn" style="text-align:right;">
                              <%= com.egen.util.text.FormatNumber.format(pares, "##,##0.##")  %>
                            </td>
                            <td class="reportColumn" style="text-align:right;">
                              <%= com.egen.util.text.FormatNumber.format(valor, "##,##0.00") %>
                            </td>
                          </tr>
                          <%
                          if (++i_bl_report_Clientes_marca_regional_representante >= res_Clientes_marca_regional_representante.size()) {
                            break;
                          }
                          t_clientes_marca_regional_representante = (portalbr.dbobj.view.Clientes_marca_regional_representante)res_Clientes_marca_regional_representante.elementAt(i_bl_report_Clientes_marca_regional_representante);
                          marca = t_clientes_marca_regional_representante.getMarca()==null?"":t_clientes_marca_regional_representante.getMarca();
                          codigo_marca           = t_clientes_marca_regional_representante.getCodigo_marca()==null?"":t_clientes_marca_regional_representante.getCodigo_marca();
                          codigo_regional        = t_clientes_marca_regional_representante.getCodigo_regional()==null?"":t_clientes_marca_regional_representante.getCodigo_regional();
                          regional               = t_clientes_marca_regional_representante.getRegional()==null?"":t_clientes_marca_regional_representante.getRegional();
                          rep_cdgo               = t_clientes_marca_regional_representante.getRep_cdgo()==null?"":t_clientes_marca_regional_representante.getRep_cdgo();
                          rep_nome               = t_clientes_marca_regional_representante.getRep_nome()==null?"":t_clientes_marca_regional_representante.getRep_nome();
                          grupos_ativos          = t_clientes_marca_regional_representante.getGrupos_ativos()==null?0:t_clientes_marca_regional_representante.getGrupos_ativos();
                          grupos_atendidos       = t_clientes_marca_regional_representante.getGrupos_atendidos()==null?0:t_clientes_marca_regional_representante.getGrupos_atendidos();
                          grupos_nao_atendidos   = t_clientes_marca_regional_representante.getGrupos_nao_atendidos()==null?0:t_clientes_marca_regional_representante.getGrupos_nao_atendidos();
                          clientes_ativos        = t_clientes_marca_regional_representante.getClientes_ativos()==null?0:t_clientes_marca_regional_representante.getClientes_ativos();
                          clientes_atendidos     = t_clientes_marca_regional_representante.getClientes_atendidos()==null?0:t_clientes_marca_regional_representante.getClientes_atendidos();
                          clientes_nao_atendidos = t_clientes_marca_regional_representante.getClientes_nao_atendidos()==null?0:t_clientes_marca_regional_representante.getClientes_nao_atendidos();
                          cidades_ativas         = t_clientes_marca_regional_representante.getCidades_ativas()==null?0:t_clientes_marca_regional_representante.getCidades_ativas();
                          cidades_atendidas      = t_clientes_marca_regional_representante.getCidades_atendidas()==null?0:t_clientes_marca_regional_representante.getCidades_atendidas();
                          cidades_nao_atendidas  = t_clientes_marca_regional_representante.getCidades_nao_atendidas()==null?0:t_clientes_marca_regional_representante.getCidades_nao_atendidas();
                          pares                  = Integer.parseInt(t_clientes_marca_regional_representante.getPares()+"");
                          valor                  = Double.parseDouble(t_clientes_marca_regional_representante.getValor()+"");
                        }
                        %>
                        <tr class="totalColumn">
                          <td class="totalTdColumn"  style="text-align:right;">
                            <b>
                              Total Distinto Regional:
                              <b>
                              </td>

                              <%
                              if(session.getAttribute("ca_consulta_grupos")=="S"){
                                %>

                                <td class="totalTdColumn"  style="text-align:center;">
                                  <b>
                                    <%= com.egen.util.text.FormatNumber.format(totalRegional.getTotalGruposAtivos(), "#,##0.##") %>
                                  </b>
                                </td>
                                <td class="totalTdColumn"  style="text-align:center;">
                                  <b>
                                    <%= com.egen.util.text.FormatNumber.format(totalRegional.getTotalGruposAtendidos(), "#,##0.##") %>
                                  </b>
                                </td>
                                <td class="totalTdColumn"  style="text-align:center;">
                                  <b>
                                    <%= com.egen.util.text.FormatNumber.format(totalRegional.getTotalGruposNaoAtendidos(), "#,##0.##") %>
                                  </b>
                                </td>

                                <%
                              }
                              %>

                              <%
                              if(session.getAttribute("ca_consulta_clientes")=="S"){
                                %>

                                <td class="totalTdColumn"  style="text-align:center;">
                                  <b>
                                    <%= com.egen.util.text.FormatNumber.format(totalRegional.getTotalClientesAtivos(), "#,##0.##") %>
                                  </b>
                                </td>
                                <td class="totalTdColumn"  style="text-align:center;">
                                  <b>
                                    <%= com.egen.util.text.FormatNumber.format(totalRegional.getTotalClientesAtendidos(),  "#,##0.##") %>
                                  </b>
                                </td>
                                <td class="totalTdColumn"  style="text-align:center;">
                                  <b>
                                    <%= com.egen.util.text.FormatNumber.format(totalRegional.getTotalClientesNaoAtendidos(),  "#,##0.##") %>
                                  </b>
                                </td>

                                <%
                              }
                              %>

                              <%
                              if(session.getAttribute("ca_consulta_cidades")=="S"){
                                %>

                                <td class="totalTdColumn"  style="text-align:center;">
                                  <b>
                                    <%= com.egen.util.text.FormatNumber.format(totalRegional.getTotalCidadesAtivas(),  "#,##0.##") %>
                                  </b>
                                </td>
                                <td class="totalTdColumn"  style="text-align:center;">
                                  <b>
                                    <%= com.egen.util.text.FormatNumber.format(totalRegional.getTotalCidadesAtendidas(), "#,##0.##") %>
                                  </b>
                                </td>
                                <td class="totalTdColumn"  style="text-align:center;">
                                  <b>
                                    <%= com.egen.util.text.FormatNumber.format(totalRegional.getTotalCidadesNaoAtendidas(), "#,##0.##") %>
                                  </b>
                                </td>

                                <%
                              }
                              %>

                              <td class="totalTdColumn"  style="text-align:right;">
                                <b>
                                  <%= com.egen.util.text.FormatNumber.format(sum_pares_1, "#,##0.##") %>
                                </b>
                              </td>
                              <td class="totalTdColumn"  style="text-align:right;">
                                <b>
                                  <%= com.egen.util.text.FormatNumber.format(sum_valor_1, "##,##0.00") %>
                                </b>
                              </td>
                            </tr>
                            <%
                          }
                          %>
                          <tr class="totalColumn">
                            <td class="totalTdColumn"  style="text-align:right;">
                              <b>
                                Total Distinto Marca:
                                <b>
                                </td>

                                <%
                                if(session.getAttribute("ca_consulta_grupos")=="S"){
                                  %>

                                  <td class="totalTdColumn"  style="text-align:center;">
                                    <b>
                                      <%= com.egen.util.text.FormatNumber.format(totalMarca.getTotalGruposAtivos(), "#,##0.##") %>
                                    </b>
                                  </td>
                                  <td class="totalTdColumn"  style="text-align:center;">
                                    <b>
                                      <%= com.egen.util.text.FormatNumber.format(totalMarca.getTotalGruposAtendidos(), "#,##0.##") %>
                                    </b>
                                  </td>
                                  <td class="totalTdColumn"  style="text-align:center;">
                                    <b>
                                      <%= com.egen.util.text.FormatNumber.format(totalMarca.getTotalGruposNaoAtendidos(), "#,##0.##") %>
                                    </b>
                                  </td>

                                  <%
                                }
                                %>


                                <%
                                if(session.getAttribute("ca_consulta_clientes")=="S"){
                                  %>

                                  <td class="totalTdColumn"  style="text-align:center;">
                                    <b>
                                      <%= com.egen.util.text.FormatNumber.format(totalMarca.getTotalClientesAtivos(), "#,##0.##") %>
                                    </b>
                                  </td>
                                  <td class="totalTdColumn"  style="text-align:center;">
                                    <b>
                                      <%= com.egen.util.text.FormatNumber.format(totalMarca.getTotalClientesAtendidos(), "#,##0.##") %>
                                    </b>
                                  </td>
                                  <td class="totalTdColumn"  style="text-align:center;">
                                    <b>
                                      <%= com.egen.util.text.FormatNumber.format(totalMarca.getTotalClientesNaoAtendidos(), "#,##0.##") %>
                                    </b>
                                  </td>

                                  <%
                                }
                                %>


                                <%
                                if(session.getAttribute("ca_consulta_cidades")=="S"){
                                  %>

                                  <td class="totalTdColumn"  style="text-align:center;">
                                    <b>
                                      <%= com.egen.util.text.FormatNumber.format(totalMarca.getTotalCidadesAtivas(), "#,##0.##") %>
                                    </b>
                                  </td>
                                  <td class="totalTdColumn"  style="text-align:center;">
                                    <b>
                                      <%= com.egen.util.text.FormatNumber.format(totalMarca.getTotalCidadesAtendidas(), "#,##0.##") %>
                                    </b>
                                  </td>
                                  <td class="totalTdColumn"  style="text-align:center;">
                                    <b>
                                      <%= com.egen.util.text.FormatNumber.format(totalMarca.getTotalCidadesNaoAtendidas(), "#,##0.##") %>
                                    </b>
                                  </td>

                                  <%
                                }
                                %>


                                <td class="totalTdColumn"  style="text-align:right;">
                                  <b>
                                    <%= com.egen.util.text.FormatNumber.format(total_pares, "#,##0.##") %>
                                  </b>
                                </td>
                                <td class="totalTdColumn"  style="text-align:right;">
                                  <b>
                                    <%= com.egen.util.text.FormatNumber.format(total_valor, "##,##0.00") %>
                                  </b>
                                </td>
                              </tr>
                              <%
                            }
                            %>
                            <tr class="totalColumn">
                              <td class="totalTdColumn"  style="text-align:right;">
                                <b>
                                  Total Distinto Geral:
                                  <b>
                                  </td>

                                  <%
                                  if(session.getAttribute("ca_consulta_grupos")=="S"){
                                    %>

                                    <td class="totalTdColumn"  style="text-align:center;" >
                                      <b>
                                        <%= com.egen.util.text.FormatNumber.format(total.getTotalGruposAtivos(), "#,##0.##") %>
                                      </b>
                                    </td>
                                    <td class="totalTdColumn"  style="text-align:center;" >
                                      <b>
                                        <%= com.egen.util.text.FormatNumber.format(total.getTotalGruposAtendidos(), "#,##0.##") %>
                                      </b>
                                    </td>
                                    <td class="totalTdColumn"  style="text-align:center;" >
                                      <b>
                                        <%= com.egen.util.text.FormatNumber.format(total.getTotalGruposNaoAtendidos(), "#,##0.##") %>
                                      </b>
                                    </td>

                                    <%
                                  }
                                  %>


                                  <%
                                  if(session.getAttribute("ca_consulta_clientes")=="S"){
                                    %>

                                    <td class="totalTdColumn"  style="text-align:center;">
                                      <b>
                                        <%= com.egen.util.text.FormatNumber.format(total.getTotalClientesAtivos(), "#,##0.##") %>
                                      </b>
                                    </td>
                                    <td class="totalTdColumn"  style="text-align:center;">
                                      <b>
                                        <%= com.egen.util.text.FormatNumber.format(total.getTotalClientesAtendidos(), "#,##0.##") %>
                                      </b>
                                    </td>
                                    <td class="totalTdColumn"  style="text-align:center;">
                                      <b>
                                        <%= com.egen.util.text.FormatNumber.format(total.getTotalClientesNaoAtendidos(), "#,##0.##") %>
                                      </b>
                                    </td>

                                    <%
                                  }
                                  %>


                                  <%
                                  if(session.getAttribute("ca_consulta_cidades")=="S"){
                                    %>

                                    <td class="totalTdColumn"  style="text-align:center;">
                                      <b>
                                        <%= com.egen.util.text.FormatNumber.format(total.getTotalCidadesAtivas(), "#,##0.##") %>
                                      </b>
                                    </td>
                                    <td class="totalTdColumn"  style="text-align:center;">
                                      <b>
                                        <%= com.egen.util.text.FormatNumber.format(total.getTotalCidadesAtendidas(), "#,##0.##") %>
                                      </b>
                                    </td>
                                    <td class="totalTdColumn"  style="text-align:center;">
                                      <b>
                                        <%= com.egen.util.text.FormatNumber.format(total.getTotalCidadesNaoAtendidas(), "#,##0.##") %>
                                      </b>
                                    </td>

                                    <%
                                  }
                                  %>
                                  <td class="totalTdColumn"  style="text-align:right;">
                                    <b>
                                      <%= com.egen.util.text.FormatNumber.format(total_geral_pares, "#,##0.##") %>
                                    </b>
                                  </td>
                                  <td class="totalTdColumn"  style="text-align:right;">
                                    <b>
                                      <%= com.egen.util.text.FormatNumber.format(total_geral_valor, "##,##0.00") %>
                                    </b>
                                  </td>
                                </tr>
                                <%
                              }
                            } catch (Exception e) {
                              session.setAttribute("exception",com.egen.util.system.Error.getDescription(e));
                            } finally {
                            }
                            %>
                          </table>
                          <%
                          if(session.getAttribute("ca_consulta_segmentos")=="S")
                          {
                            %>

                            <%
                            java.util.Vector res_Jw_clientes_atendidos_segmentos = (java.util.Vector)session.getAttribute("res_Jw_clientes_atendidos_segmentos");
                            %>

                            <form  name="bl_report_Jw_clientes_atendidos_segmentos" id="bl_report_Jw_clientes_atendidos_segmentos" class="baseForm" method="post" >


                              <%
                              if (res_Jw_clientes_atendidos_segmentos!=null && res_Jw_clientes_atendidos_segmentos.size()>0) {
                                %>

                                <table id="TRbl_report_Jw_clientes_atendidos_segmentos"  class="reportTable"   style="width:99%; " border=1; >
                                  <%
                                  int seg_cdgo =  0;
                                  java.lang.String seg_desc =  null;
                                  int pequenos =  0;
                                  int medios =  0;
                                  int grandes =  0;
                                  int todos =  0;
                                  int sum_pequenos = 0;
                                  int sum_medios = 0;
                                  int sum_grandes = 0;
                                  int sum_todos = 0;
                                  %>


                                  <tr class="reportHeader3">
                                    <td colspan="5" align="center">
                                      <big>
                                        Segmento/Limite Crédito
                                      </big>
                                    </td>
                                  </tr>

                                  <tr class="reportTr">
                                    <td class="columnTdHeader" style="text-align:left;" >
                                      Clientes Atendidos
                                    </td>

                                    <td class="columnTdHeader" style="text-align:right;" >
                                      Pequeno
                                    </td>

                                    <td class="columnTdHeader" style="text-align:right;" >
                                      Médio
                                    </td>

                                    <td class="columnTdHeader" style="text-align:right;" >
                                      Grande
                                    </td>

                                    <td class="columnTdHeader" style="text-align:right;" >
                                      Geral
                                    </td>

                                  </tr>

                                  <tr class="reportTr">
                                    <td class="columnTdHeader" style="text-align:left;" >
                                      Segmento
                                    </td>

                                    <td class="columnTdHeader" style="text-align:right;" >
                                      Até 50.000
                                    </td>

                                    <td class="columnTdHeader" style="text-align:right;" >
                                      De 50.001,00 a 200.000,00
                                    </td>

                                    <td class="columnTdHeader" style="text-align:right;" >
                                      Acima de 200.000,00
                                    </td>

                                    <td class="columnTdHeader" style="text-align:right;" >
                                      Total MI Ativo
                                    </td>

                                  </tr>

                                  <%
                                  int i_bl_report_Jw_clientes_atendidos_segmentos = 0;
                                  while (i_bl_report_Jw_clientes_atendidos_segmentos<res_Jw_clientes_atendidos_segmentos.size()) {
                                    portalbr.dbobj.view.Jw_clientes_atendidos_segmentos t_jw_clientes_atendidos_segmentos = (portalbr.dbobj.view.Jw_clientes_atendidos_segmentos)res_Jw_clientes_atendidos_segmentos.elementAt(i_bl_report_Jw_clientes_atendidos_segmentos);
                                    seg_cdgo = t_jw_clientes_atendidos_segmentos.getSeg_cdgo();
                                    seg_desc = t_jw_clientes_atendidos_segmentos.getSeg_desc()==null?"":t_jw_clientes_atendidos_segmentos.getSeg_desc();
                                    pequenos = t_jw_clientes_atendidos_segmentos.getPequenos();
                                    medios = t_jw_clientes_atendidos_segmentos.getMedios();
                                    grandes = t_jw_clientes_atendidos_segmentos.getGrandes();
                                    todos = t_jw_clientes_atendidos_segmentos.getTodos();

                                    sum_pequenos += pequenos;
                                    sum_medios += medios;
                                    sum_grandes += grandes;
                                    sum_todos += todos;

                                    String style_bl_report_Jw_clientes_atendidos_segmentos="";
                                    if (!((i_bl_report_Jw_clientes_atendidos_segmentos%2)!=0)) {
                                      style_bl_report_Jw_clientes_atendidos_segmentos="rowColor";
                                    } else {
                                      style_bl_report_Jw_clientes_atendidos_segmentos="rowBlank";
                                    }
                                    %>

                                    <tr class='<%= style_bl_report_Jw_clientes_atendidos_segmentos %>' id="TRbl_report_Jw_clientes_atendidos_segmentos<%=i_bl_report_Jw_clientes_atendidos_segmentos%>" >

                                      <td class="reportColumn" style="text-align:left;" >
                                        <%= seg_desc %>
                                      </td>

                                      <td class="reportColumn" style="text-align:right;" >
                                        <%
                                        if(pequenos>0){
                                          %>
                                          <a href="../adm/Clientes_atendForm.do?select_action=&cab=do Segmento : <%= seg_desc %>&limite=p&segmento=<%= seg_cdgo %>" target="_self" STYLE="cursor:hand" onclick="bloqueia();">
                                            <%= com.egen.util.text.FormatNumber.format(pequenos, "##,##0.##") %>
                                          </a>
                                          <%
                                        } else {
                                          %>
                                          0
                                          <%
                                        }
                                        %>
                                      </td>

                                      <td class="reportColumn" style="text-align:right;" >
                                        <%
                                        if(medios>0){
                                          %>
                                          <a href="../adm/Clientes_atendForm.do?select_action=&cab=do Segmento : <%= seg_desc %>&limite=m&segmento=<%= seg_cdgo %>" target="_self" STYLE="cursor:hand" onclick="bloqueia();">
                                            <%= com.egen.util.text.FormatNumber.format(medios, "##,##0.##") %>
                                          </a>
                                          <%
                                        } else {
                                          %>
                                          0
                                          <%
                                        }
                                        %>
                                      </td>

                                      <td class="reportColumn" style="text-align:right;" >
                                        <%
                                        if(grandes>0){
                                          %>
                                          <a href="../adm/Clientes_atendForm.do?select_action=&cab=do Segmento : <%= seg_desc %>&limite=g&segmento=<%= seg_cdgo %>" target="_self" STYLE="cursor:hand" onclick="bloqueia();">
                                            <%= com.egen.util.text.FormatNumber.format(grandes, "##,##0.##") %>
                                          </a>
                                          <%
                                        } else {
                                          %>
                                          0
                                          <%
                                        }
                                        %>
                                      </td>

                                      <td class="reportColumn" style="text-align:right;" >
                                        <%
                                        if(todos>0){
                                          %>
                                          <a href="../adm/Clientes_atendForm.do?select_action=&cab=do Segmento : <%= seg_desc %>&limite=&segmento=<%= seg_cdgo %>" target="_self" STYLE="cursor:hand" onclick="bloqueia();">
                                            <%= com.egen.util.text.FormatNumber.format(todos, "##,##0.##") %>
                                          </a>
                                          <%
                                        } else {
                                          %>
                                          0
                                          <%
                                        }
                                        %>
                                      </td>

                                    </tr>

                                    <%
                                    i_bl_report_Jw_clientes_atendidos_segmentos++;
                                    if (i_bl_report_Jw_clientes_atendidos_segmentos<res_Jw_clientes_atendidos_segmentos.size()) {
                                      t_jw_clientes_atendidos_segmentos = (portalbr.dbobj.view.Jw_clientes_atendidos_segmentos)res_Jw_clientes_atendidos_segmentos.elementAt(i_bl_report_Jw_clientes_atendidos_segmentos);
                                      seg_cdgo = t_jw_clientes_atendidos_segmentos.getSeg_cdgo();
                                      seg_desc = t_jw_clientes_atendidos_segmentos.getSeg_desc()==null?"":t_jw_clientes_atendidos_segmentos.getSeg_desc();
                                      pequenos = t_jw_clientes_atendidos_segmentos.getPequenos();
                                      medios = t_jw_clientes_atendidos_segmentos.getMedios();
                                      grandes = t_jw_clientes_atendidos_segmentos.getGrandes();
                                      todos = t_jw_clientes_atendidos_segmentos.getTodos();
                                      //            sum_pequenos += pequenos;
                                      //            sum_medios += medios;
                                      //            sum_grandes += grandes;
                                      //            sum_todos += todos;
                                    } else {
                                    }
                                  }
                                  %>

                                  <tr class="totalColumn">

                                    <td class="reportColumn" style="text-align:left;" >
                                      <b>
                                        Total :
                                      </b>
                                    </td>

                                    <td class="reportColumn" style="text-align:right;" >
                                      <b>
                                        <%= com.egen.util.text.FormatNumber.format(sum_pequenos, "##,##0.##") %>
                                      </b>

                                    </td>

                                    <td class="reportColumn" style="text-align:right;" >
                                      <b>
                                        <%= com.egen.util.text.FormatNumber.format(sum_medios, "##,##0.##") %>
                                      </b>
                                    </td>

                                    <td class="reportColumn" style="text-align:right;" >
                                      <b>
                                        <%= com.egen.util.text.FormatNumber.format(sum_grandes, "##,##0.##") %>
                                      </b>
                                    </td>

                                    <td class="reportColumn" style="text-align:right;" >
                                      <b>
                                        <%= com.egen.util.text.FormatNumber.format(sum_todos, "##,##0.##") %>
                                      </b>
                                    </td>

                                  </tr>

                                </table>

                                <%
                              }
                              %>

                            </form>
                            <%
                          }
                          %>

                          <%
                          if(session.getAttribute("ca_consulta_segmentos")=="S")
                          {
                            %>

                            <%
                            java.util.Vector res_Jw_clientes_atendidos_segmentos = (java.util.Vector)session.getAttribute("res_Jw_clientes_nao_atendidos_segmentos");
                            %>

                            <form  name="bl_report_Jw_clientes_atendidos_segmentos" id="bl_report_Jw_clientes_atendidos_segmentos" class="baseForm" method="post" >


                              <%
                              if (res_Jw_clientes_atendidos_segmentos!=null && res_Jw_clientes_atendidos_segmentos.size()>0) {
                                %>

                                <table id="TRbl_report_Jw_clientes_atendidos_segmentos"  class="reportTable"   style="width:99%; " border=1; >
                                  <%
                                  int seg_cdgo =  0;
                                  java.lang.String seg_desc =  null;
                                  int pequenos =  0;
                                  int medios =  0;
                                  int grandes =  0;
                                  int todos =  0;
                                  int sum_pequenos = 0;
                                  int sum_medios = 0;
                                  int sum_grandes = 0;
                                  int sum_todos = 0;
                                  %>


                                  <tr class="reportHeader3">
                                    <td colspan="5" align="center">

                                    </td>
                                  </tr>

                                  <tr class="reportTr">
                                    <td class="columnTdHeader" style="text-align:left;" >
                                      Clientes Não Atendidos
                                    </td>

                                    <td class="columnTdHeader" style="text-align:right;" >
                                      Pequeno
                                    </td>

                                    <td class="columnTdHeader" style="text-align:right;" >
                                      Médio
                                    </td>

                                    <td class="columnTdHeader" style="text-align:right;" >
                                      Grande
                                    </td>

                                    <td class="columnTdHeader" style="text-align:right;" >
                                      Geral
                                    </td>

                                  </tr>

                                  <tr class="reportTr">
                                    <td class="columnTdHeader" style="text-align:left;" >
                                      Segmento
                                    </td>

                                    <td class="columnTdHeader" style="text-align:right;" >
                                      Até 50.000
                                    </td>

                                    <td class="columnTdHeader" style="text-align:right;" >
                                      De 50.001,00 a 200.000,00
                                    </td>

                                    <td class="columnTdHeader" style="text-align:right;" >
                                      Acima de 200.000,00
                                    </td>

                                    <td class="columnTdHeader" style="text-align:right;" >
                                      Total MI Ativo
                                    </td>

                                  </tr>

                                  <%
                                  int i_bl_report_Jw_clientes_atendidos_segmentos = 0;
                                  while (i_bl_report_Jw_clientes_atendidos_segmentos<res_Jw_clientes_atendidos_segmentos.size()) {
                                    portalbr.dbobj.view.Jw_clientes_nao_atendidos_segmentos t_jw_clientes_atendidos_segmentos = (portalbr.dbobj.view.Jw_clientes_nao_atendidos_segmentos)res_Jw_clientes_atendidos_segmentos.elementAt(i_bl_report_Jw_clientes_atendidos_segmentos);
                                    seg_cdgo = t_jw_clientes_atendidos_segmentos.getSeg_cdgo();
                                    seg_desc = t_jw_clientes_atendidos_segmentos.getSeg_desc()==null?"":t_jw_clientes_atendidos_segmentos.getSeg_desc();
                                    pequenos = t_jw_clientes_atendidos_segmentos.getPequenos();
                                    medios = t_jw_clientes_atendidos_segmentos.getMedios();
                                    grandes = t_jw_clientes_atendidos_segmentos.getGrandes();
                                    todos = t_jw_clientes_atendidos_segmentos.getTodos();

                                    sum_pequenos += pequenos;
                                    sum_medios += medios;
                                    sum_grandes += grandes;
                                    sum_todos += todos;

                                    String style_bl_report_Jw_clientes_atendidos_segmentos="";
                                    if (!((i_bl_report_Jw_clientes_atendidos_segmentos%2)!=0)) {
                                      style_bl_report_Jw_clientes_atendidos_segmentos="rowColor";
                                    } else {
                                      style_bl_report_Jw_clientes_atendidos_segmentos="rowBlank";
                                    }
                                    %>

                                    <tr class='<%= style_bl_report_Jw_clientes_atendidos_segmentos %>' id="TRbl_report_Jw_clientes_atendidos_segmentos<%=i_bl_report_Jw_clientes_atendidos_segmentos%>" >

                                      <td class="reportColumn" style="text-align:left;" >
                                        <%= seg_desc %>
                                      </td>

                                      <td class="reportColumn" style="text-align:right;" >
                                        <%
                                        if(pequenos>0){
                                          %>
                                          <a href="../adm/Clientes_nao_atendidosForm.do?select_action=&cab=do Segmento : <%= seg_desc %>&limite=p&segmento=<%= seg_cdgo %>" target="_self" STYLE="cursor:hand" onclick="bloqueia();">
                                            <%= com.egen.util.text.FormatNumber.format(pequenos, "##,##0.##") %>
                                          </a>
                                          <%
                                        } else {
                                          %>
                                          0
                                          <%
                                        }
                                        %>
                                      </td>

                                      <td class="reportColumn" style="text-align:right;" >
                                        <%
                                        if(medios>0){
                                          %>
                                          <a href="../adm/Clientes_nao_atendidosForm.do?select_action=&cab=do Segmento : <%= seg_desc %>&limite=m&segmento=<%= seg_cdgo %>" target="_self" STYLE="cursor:hand" onclick="bloqueia();">
                                            <%= com.egen.util.text.FormatNumber.format(medios, "##,##0.##") %>
                                          </a>
                                          <%
                                        } else {
                                          %>
                                          0
                                          <%
                                        }
                                        %>
                                      </td>

                                      <td class="reportColumn" style="text-align:right;" >
                                        <%
                                        if(grandes>0){
                                          %>
                                          <a href="../adm/Clientes_nao_atendidosForm.do?select_action=&cab=do Segmento : <%= seg_desc %>&limite=g&segmento=<%= seg_cdgo %>" target="_self" STYLE="cursor:hand" onclick="bloqueia();">
                                            <%= com.egen.util.text.FormatNumber.format(grandes, "##,##0.##") %>
                                          </a>
                                          <%
                                        } else {
                                          %>
                                          0
                                          <%
                                        }
                                        %>
                                      </td>

                                      <td class="reportColumn" style="text-align:right;" >
                                        <%
                                        if(todos>0){
                                          %>
                                          <a href="../adm/Clientes_nao_atendidosForm.do?select_action=&cab=do Segmento : <%= seg_desc %>&limite=&segmento=<%= seg_cdgo %>" target="_self" STYLE="cursor:hand" onclick="bloqueia();">
                                            <%= com.egen.util.text.FormatNumber.format(todos, "##,##0.##") %>
                                          </a>
                                          <%
                                        } else {
                                          %>
                                          0
                                          <%
                                        }
                                        %>
                                      </td>

                                    </tr>

                                    <%
                                    i_bl_report_Jw_clientes_atendidos_segmentos++;
                                    if (i_bl_report_Jw_clientes_atendidos_segmentos<res_Jw_clientes_atendidos_segmentos.size()) {
                                      t_jw_clientes_atendidos_segmentos = (portalbr.dbobj.view.Jw_clientes_nao_atendidos_segmentos)res_Jw_clientes_atendidos_segmentos.elementAt(i_bl_report_Jw_clientes_atendidos_segmentos);
                                      seg_cdgo = t_jw_clientes_atendidos_segmentos.getSeg_cdgo();
                                      seg_desc = t_jw_clientes_atendidos_segmentos.getSeg_desc()==null?"":t_jw_clientes_atendidos_segmentos.getSeg_desc();
                                      pequenos = t_jw_clientes_atendidos_segmentos.getPequenos();
                                      medios = t_jw_clientes_atendidos_segmentos.getMedios();
                                      grandes = t_jw_clientes_atendidos_segmentos.getGrandes();
                                      todos = t_jw_clientes_atendidos_segmentos.getTodos();
                                      //            sum_pequenos += pequenos;
                                      //            sum_medios += medios;
                                      //            sum_grandes += grandes;
                                      //            sum_todos += todos;
                                    } else {
                                    }
                                  }
                                  %>

                                  <tr class="totalColumn">

                                    <td class="reportColumn" style="text-align:left;" >
                                      <b>
                                        Total :
                                      </b>
                                    </td>

                                    <td class="reportColumn" style="text-align:right;" >
                                      <b>
                                        <%= com.egen.util.text.FormatNumber.format(sum_pequenos, "##,##0.##") %>
                                      </b>

                                    </td>

                                    <td class="reportColumn" style="text-align:right;" >
                                      <b>
                                        <%= com.egen.util.text.FormatNumber.format(sum_medios, "##,##0.##") %>
                                      </b>
                                    </td>

                                    <td class="reportColumn" style="text-align:right;" >
                                      <b>
                                        <%= com.egen.util.text.FormatNumber.format(sum_grandes, "##,##0.##") %>
                                      </b>
                                    </td>

                                    <td class="reportColumn" style="text-align:right;" >
                                      <b>
                                        <%= com.egen.util.text.FormatNumber.format(sum_todos, "##,##0.##") %>
                                      </b>
                                    </td>

                                  </tr>

                                </table>

                                <%
                              }
                              %>

                            </form>
                            <%
                          }
                          %>


                          <%
                          if(session.getAttribute("ca_consulta_regionais")=="S") {
                            %>
                            <%
                            {
                              %>

                              <%
                              java.util.Vector res_Jw_clientes_segmentos_regional = (java.util.Vector)session.getAttribute("res_Jw_clientes_segmentos_regional");
                              %>

                              <form  name="bl_report_Jw_clientes_segmentos_regional" id="bl_report_Jw_clientes_segmentos_regional" class="baseForm" method="post" >

                                <%
                                if (res_Jw_clientes_segmentos_regional!=null && res_Jw_clientes_segmentos_regional.size()>0) {
                                  %>

                                  <table id="TRbl_report_Jw_clientes_segmentos_regional"  class="reportTable" border=1;  style="width:99%; "  >
                                    <tr class="reportHeader3">
                                      <td colspan="5" align="center">
                                        <big>
                                          Regionais/Limite Crédito
                                        </big>
                                      </td>
                                    </tr>
                                    <%
                                    int codigo_regional =  0;
                                    java.lang.String nome =  null;
                                    java.lang.String situacao =  null;
                                    int pequenos2 =  0;
                                    int medios2 =  0;
                                    int grandes2 =  0;
                                    int todos2 =  0;
                                    String _b0_control = "__";
                                    int sum_pequenos2_0 = 0;
                                    int sum_pequenos2_1 = 0;
                                    int sum_medios2_0 = 0;
                                    int sum_medios2_1 = 0;
                                    int sum_grandes2_0 = 0;
                                    int sum_grandes2_1 = 0;
                                    int sum_todos2_0 = 0;
                                    int sum_todos2_1 = 0;
                                    int i_bl_report_Jw_clientes_segmentos_regional = 0;
                                    while (i_bl_report_Jw_clientes_segmentos_regional<res_Jw_clientes_segmentos_regional.size()) {
                                      portalbr.dbobj.view.Jw_clientes_segmentos_regional t_jw_clientes_segmentos_regional = (portalbr.dbobj.view.Jw_clientes_segmentos_regional)res_Jw_clientes_segmentos_regional.elementAt(i_bl_report_Jw_clientes_segmentos_regional);
                                      codigo_regional = t_jw_clientes_segmentos_regional.getCodigo_regional();
                                      nome = t_jw_clientes_segmentos_regional.getNome()==null?"":t_jw_clientes_segmentos_regional.getNome();
                                      situacao = t_jw_clientes_segmentos_regional.getSituacao()==null?"":t_jw_clientes_segmentos_regional.getSituacao();
                                      pequenos2 = t_jw_clientes_segmentos_regional.getPequenos();
                                      medios2 = t_jw_clientes_segmentos_regional.getMedios();
                                      grandes2 = t_jw_clientes_segmentos_regional.getGrandes();
                                      todos2 = t_jw_clientes_segmentos_regional.getTodos();
                                      sum_pequenos2_0 += pequenos2;
                                      sum_pequenos2_1 += pequenos2;
                                      sum_medios2_0 += medios2;
                                      sum_medios2_1 += medios2;
                                      sum_grandes2_0 += grandes2;
                                      sum_grandes2_1 += grandes2;
                                      sum_todos2_0 += todos2;
                                      sum_todos2_1 += todos2;
                                      String _b0_value = com.egen.util.text.FormatNumber.format(codigo_regional);
                                      if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                                        %>
                                        <tr class="reportHeader">
                                          <td colspan="5">
                                            Regional :
                                            <%= codigo_regional %>
                                            -
                                            <%= nome %>
                                          </td>
                                        </tr>
                                        <%
                                        %>

                                        <tr class="reportTr">
                                          <td class="columnTdHeader" style="text-align:left;" >

                                          </td>

                                          <td class="columnTdHeader" style="text-align:right;" >
                                            Pequenos
                                          </td>

                                          <td class="columnTdHeader" style="text-align:right;" >
                                            Médios
                                          </td>

                                          <td class="columnTdHeader" style="text-align:right;" >
                                            Grandes
                                          </td>

                                          <td class="columnTdHeader" style="text-align:right;" >
                                            Todos
                                          </td>

                                        </tr>

                                        <%
                                      }
                                      String style_bl_report_Jw_clientes_segmentos_regional="";
                                      if (!((i_bl_report_Jw_clientes_segmentos_regional%2)!=0)) {
                                        style_bl_report_Jw_clientes_segmentos_regional="rowColor";
                                      } else {
                                        style_bl_report_Jw_clientes_segmentos_regional="rowBlank";
                                      }
                                      %>

                                      <tr class='<%= style_bl_report_Jw_clientes_segmentos_regional %>' id="TRbl_report_Jw_clientes_segmentos_regional<%=i_bl_report_Jw_clientes_segmentos_regional%>" >
                                        <td class="reportColumn" style="text-align:left;" >
                                          <%= situacao %>
                                        </td>

                                        <td class="reportColumn" style="text-align:right;" >
                                          <%= com.egen.util.text.FormatNumber.format(pequenos2, "##,##0.##") %>
                                        </td>

                                        <td class="reportColumn" style="text-align:right;" >
                                          <%= com.egen.util.text.FormatNumber.format(medios2, "##,##0.##") %>
                                        </td>

                                        <td class="reportColumn" style="text-align:right;" >
                                          <%= com.egen.util.text.FormatNumber.format(grandes2, "##,##0.##") %>
                                        </td>

                                        <td class="reportColumn" style="text-align:right;" >
                                          <%= com.egen.util.text.FormatNumber.format(todos2, "##,##0.##") %>
                                        </td>

                                      </tr>

                                      <%
                                      _b0_control = _b0_value;
                                      i_bl_report_Jw_clientes_segmentos_regional++;
                                      if (i_bl_report_Jw_clientes_segmentos_regional<res_Jw_clientes_segmentos_regional.size()) {
                                        t_jw_clientes_segmentos_regional = (portalbr.dbobj.view.Jw_clientes_segmentos_regional)res_Jw_clientes_segmentos_regional.elementAt(i_bl_report_Jw_clientes_segmentos_regional);
                                        codigo_regional = t_jw_clientes_segmentos_regional.getCodigo_regional();
                                        nome = t_jw_clientes_segmentos_regional.getNome()==null?"":t_jw_clientes_segmentos_regional.getNome();
                                        situacao = t_jw_clientes_segmentos_regional.getSituacao()==null?"":t_jw_clientes_segmentos_regional.getSituacao();
                                        pequenos2 = t_jw_clientes_segmentos_regional.getPequenos();
                                        medios2 = t_jw_clientes_segmentos_regional.getMedios();
                                        grandes2 = t_jw_clientes_segmentos_regional.getGrandes();
                                        todos2 = t_jw_clientes_segmentos_regional.getTodos();
                                        _b0_value = com.egen.util.text.FormatNumber.format(codigo_regional);
                                      } else {
                                        _b0_control = "__";
                                      }
                                      if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                                        %>

                                        <tr class="totalColumn">
                                          <td>
                                            <b>
                                              Total Regional:
                                            </b>
                                          </td>
                                          <td class="totalTdColumn"  style="text-align:right;" >
                                            <b>
                                              <%= com.egen.util.text.FormatNumber.format(sum_pequenos2_1, "##,##0.##") %>
                                            </b>
                                          </td>
                                          <td class="totalTdColumn"  style="text-align:right;" >
                                            <b>
                                              <%= com.egen.util.text.FormatNumber.format(sum_medios2_1, "##,##0.##") %>
                                            </b>
                                          </td>
                                          <td class="totalTdColumn"  style="text-align:right;" >
                                            <b>
                                              <%= com.egen.util.text.FormatNumber.format(sum_grandes2_1, "##,##0.##") %>
                                            </b>
                                          </td>
                                          <td class="totalTdColumn"  style="text-align:right;" >
                                            <b>
                                              <%= com.egen.util.text.FormatNumber.format(sum_todos2_1, "##,##0.##") %>
                                            </b>
                                          </td>
                                        </tr>

                                        <%
                                        sum_pequenos2_1 = 0;
                                        sum_medios2_1 = 0;
                                        sum_grandes2_1 = 0;
                                        sum_todos2_1 = 0;
                                      }
                                    }
                                    %>

                                    <tr class="totalColumn">
                                      <td>
                                        <b>
                                          Total Geral:
                                        </b>
                                      </td>
                                      <td class="totalTdColumn"  style="text-align:right;" >
                                        <b>
                                          <%= com.egen.util.text.FormatNumber.format(sum_pequenos2_0, "##,##0.##") %>
                                        </b>
                                      </td>
                                      <td class="totalTdColumn"  style="text-align:right;" >
                                        <b>
                                          <%= com.egen.util.text.FormatNumber.format(sum_medios2_0, "##,##0.##") %>
                                        </b>
                                      </td>
                                      <td class="totalTdColumn"  style="text-align:right;" >
                                        <b>
                                          <%= com.egen.util.text.FormatNumber.format(sum_grandes2_0, "##,##0.##") %>
                                        </b>
                                      </td>
                                      <td class="totalTdColumn"  style="text-align:right;" >
                                        <b>
                                          <%= com.egen.util.text.FormatNumber.format(sum_todos2_0, "##,##0.##") %>
                                        </b>
                                      </td>
                                    </tr>

                                    <%
                                    %>

                                  </table>

                                  <%
                                }
                                %>

                              </form>
                              <%
                            }
                            %>

                            <%
                          }
                          %>
                          <html:form action="adm/Clientes_marca_regional_representanteForm.do" method="post" styleClass="baseForm">
                            <table class="messageTable" style='width:99%;'>
                              <tr class="messageTr" >
                                <td class="messageTd">
                                  <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Clientes_marca_regional_representante"/>
                                </td>
                              </tr>
                            </table>

                            <table class="buttonTable" style='width:99%;'>
                              <tr class="buttonTr">
                                <td class="buttonTd">
                                  <%
                                  if(!(request.getParameter("excel")+"").equals("true")){
                                    %>
                                    <html:submit accesskey="s" styleClass="myhidden" property="select_action">
                                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                                    </html:submit>
                                    <%
                                  }
                                  %>
                                  <%
                                  if(!(request.getParameter("excel")+"").equals("true")){
                                    %>
                                    <html:submit accesskey="r" styleClass="baseButton" property="resetfull_action">
                                      <bean:message bundle="ApplicationResources" key="jsp.back"/>
                                    </html:submit>
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
