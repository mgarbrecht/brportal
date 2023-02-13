<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Consulta de Pedidos
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
                </td>

              </tr>

            </table>

            <%
            //-------------------------------------------------------------------------------------------
            // Autor             : Mateus Garbrecht (TechnoCorp)
            // Data de Criação   : 07/03/2006
            // Objetivo          : Relatório com os clientes retornados pela consulta na tela:
            //                     /com/ConsultaPedidosForm.jsp
            //-------------------------------------------------------------------------------------------
            // Data de Alteração :
            // Descrição         :
            //-------------------------------------------------------------------------------------------
            %>
            <table id="TRbl_report_Jw_consulta_pedidos" class="reportTable" style=width:99%;  border=1  frame=box>
              <%
              int counterbl_report_Jw_consulta_pedidos=0;
              StringBuilder sb = new StringBuilder();
              session.removeAttribute("consulta_pedidos_filtro_clientes");
              {
                portalbr.dbobj.view.Jw_consulta_pedidos t_jw_consulta_pedidos = new portalbr.dbobj.view.Jw_consulta_pedidos();
                portalbr.com.ConsultaPedidos_rActionForm ConsultaPedidos_rActionForm = (portalbr.com.ConsultaPedidos_rActionForm)session.getAttribute("ConsultaPedidos_rActionForm");
                java.util.Vector res_Jw_consulta_pedidos = (java.util.Vector)session.getAttribute("res_Jw_consulta_pedidos");
                if (res_Jw_consulta_pedidos!=null && res_Jw_consulta_pedidos.size()>0) {
                  sb.append(" AND (b.cli_cdgo, b.esc_seqn) IN (");
                  java.lang.String codigo             =  null;
                  java.lang.String razao_social       =  null;
                  java.lang.String cid_uf             =  null;
                  java.lang.String eunifed            =  null;
                  java.lang.String ecidad             =  null;
                  java.lang.Integer seqn              =  null;
                  java.lang.Integer cod               =  null;
                  java.lang.String situacao           = ConsultaPedidos_rActionForm.getSituacao()+"";
                  java.lang.String dt_entrega         = ConsultaPedidos_rActionForm.getDt_entrega()+"";
                  java.lang.String dt_emissao         = ConsultaPedidos_rActionForm.getDt_emissao()+"";
                  java.lang.String codigo_sucessor       = null;
                  java.lang.String sequencial_sucessor   = null;
                  java.lang.String razao_social_sucessor = null;
                  java.lang.String cid_uf_sucessor       = null;

                  int i_bl_report_Jw_consulta_pedidos = 0;

                  t_jw_consulta_pedidos = (portalbr.dbobj.view.Jw_consulta_pedidos)res_Jw_consulta_pedidos.elementAt(i_bl_report_Jw_consulta_pedidos);
                  codigo                = t_jw_consulta_pedidos.getCodigo()==null?"":t_jw_consulta_pedidos.getCodigo();
                  razao_social          = t_jw_consulta_pedidos.getRazao_social()==null?"":t_jw_consulta_pedidos.getRazao_social();
                  cid_uf                = t_jw_consulta_pedidos.getCid_uf()==null?"":t_jw_consulta_pedidos.getCid_uf();
                  eunifed               = t_jw_consulta_pedidos.getEunifed()==null?"":t_jw_consulta_pedidos.getEunifed();
                  ecidad                = t_jw_consulta_pedidos.getEcidad()==null?"":t_jw_consulta_pedidos.getEcidad();
                  seqn                  = t_jw_consulta_pedidos.getSeqn();
                  cod                   = t_jw_consulta_pedidos.getCod();

                  codigo_sucessor       = t_jw_consulta_pedidos.getCodigo_sucessor()==null?"":t_jw_consulta_pedidos.getCodigo_sucessor();
                  sequencial_sucessor   = t_jw_consulta_pedidos.getSequencial_sucessor()==null?"":t_jw_consulta_pedidos.getSequencial_sucessor();
                  razao_social_sucessor = t_jw_consulta_pedidos.getRazao_social_sucessor()==null?"":t_jw_consulta_pedidos.getRazao_social_sucessor();
                  cid_uf_sucessor       = t_jw_consulta_pedidos.getCid_uf_sucessor()==null?"":t_jw_consulta_pedidos.getCid_uf_sucessor();
                  sb.append("("+cod+","+seqn+")");
                  %>
                  <tr class="reportHeader"  >
                    <td class="columnTdHeader" style="text-align:left;">
                      Código
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Razão Social
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Cidade - UF
                    </td>
                  </tr>
                  <%
                  while (i_bl_report_Jw_consulta_pedidos<res_Jw_consulta_pedidos.size()){
                    counterbl_report_Jw_consulta_pedidos++;
                    String style="";
                    if (!((i_bl_report_Jw_consulta_pedidos%2)!=0)) {
                      style="rowColor";
                    } else {
                      style="rowBlank";
                    }
                    %>
                    <tr class=<%= style %> id='TRbl_report_Jw_consulta_pedidos<%=counterbl_report_Jw_consulta_pedidos%>' >
                      <td class="reportColumn" style="text-align:left;" title="Pedidos do Cliente: <%= razao_social %>">
                        <%
                        if(!(request.getParameter("excel")+"").equals("true")){
                          %>

                          <%
                          if(codigo_sucessor.equals("")) {
                            %>
                            <a href="../com/ConsultaPedidos_pForm.do?select_action=&cod=<%= cod %>&seqn=<%= seqn %>&situacao=<%= situacao %>&dt_entrega=<%= dt_entrega%>&dt_emissao=<%= dt_emissao%>&codigo=<%= codigo %>&razao_social=<%= razao_social %>&cid_uf=<%= cid_uf %>&cliente=n&marca=<%= ConsultaPedidos_rActionForm.getMarca() %>&tipo_pedido=<%= ConsultaPedidos_rActionForm.getTipo_pedido() %>" target="_self" STYLE="cursor:hand" onclick="bloqueia();">
                              <%= codigo %>
                            </a>
                            <%
                          } else {
                            %>
                            <small>
                              <font color="red">
                                <a href="../com/ConsultaPedidos_pForm.do?select_action=&cod=<%= cod %>&seqn=<%= seqn %>&situacao=<%= situacao %>&dt_entrega=<%= dt_entrega%>&dt_emissao=<%= dt_emissao%>&codigo=<%= codigo %>&razao_social=<%= razao_social %>&cid_uf=<%= cid_uf %>&cliente=n&marca=<%= ConsultaPedidos_rActionForm.getMarca() %>&tipo_pedido=<%= ConsultaPedidos_rActionForm.getTipo_pedido() %>" target="_self" STYLE="cursor:hand" onclick="bloqueia();">
                                  <%= codigo %>
                                </a>
                              </font>


                              /
                            </small>
                            <a href="../com/ConsultaPedidos_pForm.do?select_action=&cod=<%= codigo_sucessor %>&seqn=<%= sequencial_sucessor %>&situacao=<%= situacao %>&dt_entrega=<%= dt_entrega%>&dt_emissao=<%= dt_emissao%>&codigo=<%= codigo_sucessor %>&razao_social=<%= razao_social_sucessor %>&cid_uf=<%= cid_uf_sucessor %>&cliente=n&marca=<%= ConsultaPedidos_rActionForm.getMarca() %>&tipo_pedido=<%= ConsultaPedidos_rActionForm.getTipo_pedido() %>" target="_self" STYLE="cursor:hand" onclick="bloqueia();">
                              <%= codigo_sucessor %>
                              -
                              <%= sequencial_sucessor %>
                            </a>
                            -
                            <%= razao_social_sucessor %>
                            ( Sucessor )
                            <%
                          }
                          %>
                          <%
                        } else {
                          %>
                          <%= codigo %>
                          <%
                        }
                        %>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <%
                        if(codigo_sucessor.equals("")) {
                          %>
                          <%= razao_social %>
                          <%
                        } else {
                          %>
                          <small>
                            <font color="red">
                              <s>
                                <%= razao_social %>
                              </s>
                            </font>
                          </small>
                          <%= razao_social_sucessor %>
                          (Sucessor)
                          <%
                        }
                        %>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <%
                        if(codigo_sucessor.equals("")) {
                          %>
                          <%= cid_uf %>
                          <%
                        } else {
                          %>
                          <small>
                            <font color="red">
                              <s>
                                <%= cid_uf %>
                              </s>
                            </font>
                          </small>
                          <%= cid_uf_sucessor %>
                          (Sucessor)
                          <%
                        }
                        %>

                      </td>
                    </tr>
                    <%
                    if (++i_bl_report_Jw_consulta_pedidos >= res_Jw_consulta_pedidos.size()) {
                      break;
                    }
                    t_jw_consulta_pedidos = (portalbr.dbobj.view.Jw_consulta_pedidos)res_Jw_consulta_pedidos.elementAt(i_bl_report_Jw_consulta_pedidos);
                    codigo       = t_jw_consulta_pedidos.getCodigo()==null?"":t_jw_consulta_pedidos.getCodigo();
                    razao_social = t_jw_consulta_pedidos.getRazao_social()==null?"":t_jw_consulta_pedidos.getRazao_social();
                    cid_uf       = t_jw_consulta_pedidos.getCid_uf()==null?"":t_jw_consulta_pedidos.getCid_uf();
                    eunifed      = t_jw_consulta_pedidos.getEunifed()==null?"":t_jw_consulta_pedidos.getEunifed();
                    ecidad       = t_jw_consulta_pedidos.getEcidad()==null?"":t_jw_consulta_pedidos.getEcidad();
                    seqn         = t_jw_consulta_pedidos.getSeqn();
                    cod          = t_jw_consulta_pedidos.getCod();

                    codigo_sucessor       = t_jw_consulta_pedidos.getCodigo_sucessor()==null?"":t_jw_consulta_pedidos.getCodigo_sucessor();
                    sequencial_sucessor   = t_jw_consulta_pedidos.getSequencial_sucessor()==null?"":t_jw_consulta_pedidos.getSequencial_sucessor();
                    razao_social_sucessor = t_jw_consulta_pedidos.getRazao_social_sucessor()==null?"":t_jw_consulta_pedidos.getRazao_social_sucessor();
                    cid_uf_sucessor       = t_jw_consulta_pedidos.getCid_uf_sucessor()==null?"":t_jw_consulta_pedidos.getCid_uf_sucessor();
                    sb.append(",("+cod+","+seqn+")");

                  }
                }
                sb.append(")");
                session.setAttribute("consulta_pedidos_filtro_clientes", sb.toString());
              }
              %>
            </table>
            <html:form action="com/ConsultaPedidos_rForm.do" method="post" styleClass="baseForm">
              <table class="itemTable"  style=" width:;">
                <html:hidden property="situacao"/>
                <html:hidden property="dt_entrega"/>
                <html:hidden property="dt_emissao"/>
                <html:hidden property="marca"/>
                <html:hidden property="tipo_pedido"/>
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
