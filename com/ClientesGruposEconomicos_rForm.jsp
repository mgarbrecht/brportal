<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Clientes por Grupo Econômico
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
            int counterbl_report_Jw_clientes_grupos_economicos=0;
            {
              portalbr.dbobj.view.Jw_clientes_grupos_economicos t_jw_clientes_grupos_economicos = new portalbr.dbobj.view.Jw_clientes_grupos_economicos();
              java.util.Vector res_Jw_clientes_grupos_economicos = (java.util.Vector)session.getAttribute("res_Jw_clientes_grupos_economicos");
              if (res_Jw_clientes_grupos_economicos!=null && res_Jw_clientes_grupos_economicos.size()>0) {
                java.lang.String gre_grupo     =  null;
                java.lang.String gre_descricao =  null;
                java.lang.String cli_cdgo      =  null;
                java.lang.String cli_nome      =  null;
                java.lang.String cli_rzao      =  null;
                java.lang.String cli_situ      =  null;
                java.lang.String status        =  null;
                java.lang.String situacao      =  null;
                java.lang.String cidade        =  null;
                java.lang.Integer codigo_sequencial =  null;
                int i_bl_report_Jw_clientes_grupos_economicos = 0;
                t_jw_clientes_grupos_economicos = (portalbr.dbobj.view.Jw_clientes_grupos_economicos)res_Jw_clientes_grupos_economicos.elementAt(i_bl_report_Jw_clientes_grupos_economicos);
                gre_grupo     = t_jw_clientes_grupos_economicos.getGre_grupo()==null?"":t_jw_clientes_grupos_economicos.getGre_grupo();
                gre_descricao = t_jw_clientes_grupos_economicos.getGre_descricao()==null?"":t_jw_clientes_grupos_economicos.getGre_descricao();
                cli_cdgo      = t_jw_clientes_grupos_economicos.getCli_cdgo()==null?"":t_jw_clientes_grupos_economicos.getCli_cdgo();
                cli_nome      = t_jw_clientes_grupos_economicos.getCli_nome()==null?"":t_jw_clientes_grupos_economicos.getCli_nome();
                cli_rzao      = t_jw_clientes_grupos_economicos.getCli_rzao()==null?"":t_jw_clientes_grupos_economicos.getCli_rzao();
                cli_situ      = t_jw_clientes_grupos_economicos.getCli_situ()==null?"":t_jw_clientes_grupos_economicos.getCli_situ();
                status        = t_jw_clientes_grupos_economicos.getStatus()==null?"":t_jw_clientes_grupos_economicos.getStatus();
                situacao      = t_jw_clientes_grupos_economicos.getSituacao()==null?"":t_jw_clientes_grupos_economicos.getSituacao();
                cidade        = t_jw_clientes_grupos_economicos.getCidade()==null?"":t_jw_clientes_grupos_economicos.getCidade();
                codigo_sequencial = t_jw_clientes_grupos_economicos.getCodigo_sequencial();
              if(status.equals("A")){status="ATIVO";} else {status="INATIVO";}
            if(situacao.equals("A")){situacao="ATIVO";} else {situacao="INATIVO";}
          if(cli_situ.equals("A")){cli_situ="ATIVO";} else {cli_situ="INATIVO";}
          java.lang.String b0_gre_grupo =  null;
          while (i_bl_report_Jw_clientes_grupos_economicos<res_Jw_clientes_grupos_economicos.size()){
            counterbl_report_Jw_clientes_grupos_economicos++;
            %>
            <table id="TRbl_report_Jw_clientes_grupos_economicos" class="reportTable" style=width:99%;  border=1  frame=box>
              <tr class="reportHeader2" >
                <td colspan="7">
                  <big>
                    Grupo Econômico :
                    <%= gre_grupo %>
                    -
                    <%= gre_descricao %>
                  </big>
                </td>
              </tr>
              <%
              b0_gre_grupo = gre_grupo;
              %>
              <tr class="reportHeader" >
                <td class="columnTdHeader" style="text-align:left; width: 10%" >
                  Cliente/Seq.
                </td>
                <td class="columnTdHeader" style="text-align:left; width: 24%">
                  Nome
                </td>
                <td class="columnTdHeader" style="text-align:left; width: 30%">
                  Razão Social
                </td>
                <td class="columnTdHeader" style="text-align:left; width: 15%">
                  Cidade
                </td>
                <td class="columnTdHeader" style="text-align:center; width: 7%" >
                  Situação Cliente
                </td>
                <td class="columnTdHeader" style="text-align:center; width: 7%" >
                  Situação Cliente / Grupo Econômico
                </td>
                <td class="columnTdHeader" style="text-align:center; width: 7%" >
                  Situação Cliente / Representante
                </td>
              </tr>
              <%
              while (i_bl_report_Jw_clientes_grupos_economicos<res_Jw_clientes_grupos_economicos.size() &&  (b0_gre_grupo==null?"":b0_gre_grupo).equals((gre_grupo==null?"":gre_grupo))){
                counterbl_report_Jw_clientes_grupos_economicos++;
                String style="";
                if (!((i_bl_report_Jw_clientes_grupos_economicos%2)!=0)) {
                  style="class=rowColor";
                } else {
                  style="class=rowBlank";
                }
                %>
                <tr <%= style %> id='TRbl_report_Jw_clientes_grupos_economicos<%=counterbl_report_Jw_clientes_grupos_economicos%>' title="Dados do Cliente: <%= cli_rzao %>">
                  <td class="reportColumn" style="text-align:left;" >
                    <%
                    if(!(request.getParameter("excel")+"").equals("true")){
                      %>
                      <a href="../com/ClientesGruposEconomicos_dForm.do?select_action=&cli_cdgo=<%= cli_cdgo %>&esc_seqn=<%= codigo_sequencial %>" target="_self" STYLE="cursor:hand">
                        <%= cli_cdgo %>
                        -
                        <%= codigo_sequencial %>
                      </a>
                      <%
                    } else {
                      %>
                      <%= cli_cdgo %>
                      -
                      <%= codigo_sequencial %>
                      <%
                    }
                    %>
                  </td>
                  <td class="reportColumn" style="text-align:left;" >
                    <%= cli_nome %>
                  </td>
                  <td class="reportColumn" style="text-align:left;" >
                    <%= cli_rzao %>
                  </td>
                  <td class="reportColumn" style="text-align:left;" >
                    <%= cidade %>
                  </td>
                  <td class="reportColumn" style="text-align:center;" >
                    <%= cli_situ %>
                  </td>
                  <td class="reportColumn" style="text-align:center;" >
                    <%= status %>
                  </td>
                  <td class="reportColumn" style="text-align:center;" >
                    <%= situacao %>
                  </td>
                </tr>
                <%
                if (++i_bl_report_Jw_clientes_grupos_economicos >= res_Jw_clientes_grupos_economicos.size()) {
                  break;
                }
                t_jw_clientes_grupos_economicos = (portalbr.dbobj.view.Jw_clientes_grupos_economicos)res_Jw_clientes_grupos_economicos.elementAt(i_bl_report_Jw_clientes_grupos_economicos);
                gre_grupo     = t_jw_clientes_grupos_economicos.getGre_grupo()==null?"":t_jw_clientes_grupos_economicos.getGre_grupo();
                gre_descricao = t_jw_clientes_grupos_economicos.getGre_descricao()==null?"":t_jw_clientes_grupos_economicos.getGre_descricao();
                cli_cdgo      = t_jw_clientes_grupos_economicos.getCli_cdgo()==null?"":t_jw_clientes_grupos_economicos.getCli_cdgo();
                cli_nome      = t_jw_clientes_grupos_economicos.getCli_nome()==null?"":t_jw_clientes_grupos_economicos.getCli_nome();
                cli_rzao      = t_jw_clientes_grupos_economicos.getCli_rzao()==null?"":t_jw_clientes_grupos_economicos.getCli_rzao();
                cli_situ      = t_jw_clientes_grupos_economicos.getCli_situ()==null?"":t_jw_clientes_grupos_economicos.getCli_situ();
                status        = t_jw_clientes_grupos_economicos.getStatus()==null?"":t_jw_clientes_grupos_economicos.getStatus();
                situacao      = t_jw_clientes_grupos_economicos.getSituacao()==null?"":t_jw_clientes_grupos_economicos.getSituacao();
                cidade        = t_jw_clientes_grupos_economicos.getCidade()==null?"":t_jw_clientes_grupos_economicos.getCidade();
                codigo_sequencial = t_jw_clientes_grupos_economicos.getCodigo_sequencial();
              if(status.equals("A")){status="ATIVO";} else {status="INATIVO";}
            if(situacao.equals("A")){situacao="ATIVO";} else {situacao="INATIVO";}
          if(cli_situ.equals("A")){cli_situ="ATIVO";} else {cli_situ="INATIVO";}
        }
        %>
      </table>
      <%
    }
  }
}
%>
</table>
<html:form action="com/ClientesGruposEconomicos_rForm.do" method="post" styleClass="baseForm">
  <table class="buttonTable" style='width:;'>
    <tr class="buttonTr">
      <td class="buttonTd">
        <%
        if(!(request.getParameter("excel")+"").equals("true")){
          %>
          <html:submit styleClass="baseButton" property="back_action">
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
