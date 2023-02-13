<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  PLUS Clientes
</head>
<center>
  <body>
    <table class="mainTable" style='width:99%;'>
      <tr class="mainTr">
        <td class="mainTd">
          <table class="headerTable" style="width:99%" >
            <tr>

              <td class="td10">
                <%@ include file="../system/header_sem_ajuda.jsp" %>
                <%
                if(!user.isSuperUsuario() && !user.isAutorizado(80)){
                  response.sendRedirect("../system/Error.jsp");
                }
                %>
              </td>

            </tr>

          </table>

          <table id="TRbl_report_Jw_plus_clientes_sequenciais" class="reportTable" style=width:99%;  border=1  frame=box>
            <%
            int counterbl_report_Jw_plus_clientes_sequenciais=0;
            {
              portalbr.dbobj.view.Jw_plus_clientes_sequenciais t_jw_plus_clientes_sequenciais = new portalbr.dbobj.view.Jw_plus_clientes_sequenciais();
              java.util.Vector res_Jw_plus_clientes_sequenciais = (java.util.Vector)session.getAttribute("res_Jw_plus_clientes_sequenciais");
              if (res_Jw_plus_clientes_sequenciais!=null && res_Jw_plus_clientes_sequenciais.size()>0) {
                java.lang.String codigo       =  null;
                java.lang.String razao_social =  null;
                java.lang.String cidade_uf    =  null;
                java.lang.String seqn         =  null;
                java.lang.String cod          =  null;
                int i_bl_report_Jw_plus_clientes_sequenciais = 0;
                t_jw_plus_clientes_sequenciais = (portalbr.dbobj.view.Jw_plus_clientes_sequenciais)res_Jw_plus_clientes_sequenciais.elementAt(i_bl_report_Jw_plus_clientes_sequenciais);
                codigo       = t_jw_plus_clientes_sequenciais.getCodigo()==null?"":t_jw_plus_clientes_sequenciais.getCodigo();
                razao_social = t_jw_plus_clientes_sequenciais.getRazao_social()==null?"":t_jw_plus_clientes_sequenciais.getRazao_social();
                cidade_uf    = t_jw_plus_clientes_sequenciais.getCidade_uf()==null?"":t_jw_plus_clientes_sequenciais.getCidade_uf();
                seqn         = t_jw_plus_clientes_sequenciais.getSeqn()==null?"":t_jw_plus_clientes_sequenciais.getSeqn();
                cod          = t_jw_plus_clientes_sequenciais.getCod()==null?"":t_jw_plus_clientes_sequenciais.getCod();
                %>
                <tr class="reportHeader" >
                  <td class="columnTdHeader" style="text-align:left;">
                    Código
                  </td>
                  <td class="columnTdHeader" style="text-align:left;">
                    Razão Social
                  </td>
                  <td class="columnTdHeader" style="text-align:left;">
                    Cidade/UF
                  </td>
                </tr>
                <%
                while (i_bl_report_Jw_plus_clientes_sequenciais<res_Jw_plus_clientes_sequenciais.size()){
                  counterbl_report_Jw_plus_clientes_sequenciais++;
                  String style="";
                  if (!((i_bl_report_Jw_plus_clientes_sequenciais%2)!=0)) {
                    style="rowColor";
                  } else {
                    style="rowBlank";
                  }
                  %>
                  <tr class=<%= style %> id='TRbl_report_Jw_plus_clientes_sequenciais<%=counterbl_report_Jw_plus_clientes_sequenciais%>' >
                    <td title="Dados do Cliente" class="reportColumn" style="text-align:left;">
                      <a href="../com/PlusClientes_dForm.do?select_action=&esc_seqn=<%= seqn %>&cli_cdgo=<%= cod %>" target="_self" STYLE="cursor:hand" onclick="bloqueia();">
                        <%= codigo %>
                      </a>
                    </td>
                    <td class="reportColumn" style="text-align:left;">
                      <%= razao_social %>
                    </td>
                    <td class="reportColumn" style="text-align:left;">
                      <%= cidade_uf %>
                    </td>
                  </tr>
                  <%
                  if (++i_bl_report_Jw_plus_clientes_sequenciais >= res_Jw_plus_clientes_sequenciais.size()) {
                    break;
                  }
                  t_jw_plus_clientes_sequenciais = (portalbr.dbobj.view.Jw_plus_clientes_sequenciais)res_Jw_plus_clientes_sequenciais.elementAt(i_bl_report_Jw_plus_clientes_sequenciais);
                  codigo       = t_jw_plus_clientes_sequenciais.getCodigo()==null?"":t_jw_plus_clientes_sequenciais.getCodigo();
                  razao_social = t_jw_plus_clientes_sequenciais.getRazao_social()==null?"":t_jw_plus_clientes_sequenciais.getRazao_social();
                  cidade_uf    = t_jw_plus_clientes_sequenciais.getCidade_uf()==null?"":t_jw_plus_clientes_sequenciais.getCidade_uf();
                  seqn         = t_jw_plus_clientes_sequenciais.getSeqn()==null?"":t_jw_plus_clientes_sequenciais.getSeqn();
                  cod          = t_jw_plus_clientes_sequenciais.getCod()==null?"":t_jw_plus_clientes_sequenciais.getCod();
                }
              }
            }
            %>
          </table>
          <html:form action="com/PlusClientes_rForm.do" method="post" styleClass="baseForm">
            <table class="itemTable"  style=" width:;">
              <html:hidden property="cod"/>
              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit styleClass="baseButton" property="back_action">
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
