<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Arquivos de Representantes
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
                  <%@ include file="../system/header_sem_ajuda.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(144)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <table id="TRbl_report_Links_dinamicos" class="reportTable" style=width:99%;  border=1  frame=box>
              <%
              int counterbl_report_Links_dinamicos=0;
              com.egen.util.jdbc.JdbcUtil j = null;
              try {
                j = new com.egen.util.jdbc.JdbcUtil();
                portalbr.dbobj.table.Links_dinamicos t_links_dinamicos = new portalbr.dbobj.table.Links_dinamicos();
                java.util.Vector res_Links_dinamicos = (java.util.Vector)session.getAttribute("res_Links_dinamicos");
                if (res_Links_dinamicos!=null && res_Links_dinamicos.size()>0) {
                  java.lang.String descricao_marca =  null;
                  java.lang.String lidi_titulo     =  null;
                  java.lang.String lidi_descricao  =  null;
                  java.lang.String lidi_caminho    =  null;
                  java.lang.String lidi_tipo       =  null;
                  java.lang.String tipo            =  null;
                  int lidi_id                      =  0;
                  int lidi_marca                   =  0;
                  int i_bl_report_Links_dinamicos  =  0;

                  t_links_dinamicos = (portalbr.dbobj.table.Links_dinamicos)res_Links_dinamicos.elementAt(i_bl_report_Links_dinamicos);
                  lidi_marca        = t_links_dinamicos.getLidi_marca();
                  lidi_titulo       = t_links_dinamicos.getLidi_titulo()==null?"":t_links_dinamicos.getLidi_titulo();
                  lidi_descricao    = t_links_dinamicos.getLidi_descricao()==null?"":t_links_dinamicos.getLidi_descricao();
                  lidi_caminho      = t_links_dinamicos.getLidi_caminho()==null?"":t_links_dinamicos.getLidi_caminho();
                  lidi_id           = t_links_dinamicos.getLidi_id();
                  lidi_marca        = t_links_dinamicos.getLidi_marca();
                  lidi_tipo         = t_links_dinamicos.getLidi_tipo();

                if(lidi_tipo.equals("N")){ tipo="Normal";}else{tipo="Clientes";}
                {
                  portalbr.dbobj.table.Marcas_produtos cr_db_object = new portalbr.dbobj.table.Marcas_produtos();
                  Object[][] where = {
                  {"codigo_marca","=",new Integer(lidi_marca)}
                  };
                  java.util.Vector results = j.select(cr_db_object, where, null);
                  if (results!=null && results.size()>0) {
                    cr_db_object = (portalbr.dbobj.table.Marcas_produtos)results.elementAt(0);
                    descricao_marca = cr_db_object.getDescricao_marca() + "";
                  }
                  };
                  %>
                  <tr class="reportHeader" >
                    <td class="columnTdHeader" style="text-align:left;" width="8%">
                      Marca
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Título
                    </td>
                    <td class="columnTdHeader" style="text-align:left;" >
                      Arquivo
                    </td>
                    <td class="columnTdHeader" style="text-align:center;">
                      Tipo
                    </td>
                    <td class="columnTdHeader" style="text-align:center;">
                      Exc
                    </td>
                  </tr>
                  <%
                  while (i_bl_report_Links_dinamicos<res_Links_dinamicos.size()){
                    counterbl_report_Links_dinamicos++;
                    String style="";
                    if (!((i_bl_report_Links_dinamicos%2)!=0)) {
                      style="class=rowColor";
                    } else {
                      style="class=rowBlank";
                    }
                    %>
                    <tr <%= style %> id='TRbl_report_Links_dinamicos<%=counterbl_report_Links_dinamicos%>' >
                      <td class="reportColumn" style="font-size:10;text-align:left;" width="8%">
                        <%= descricao_marca %>
                      </td>
                      <td title="Editar Norma" class="reportColumn" style="font-size:10;text-align:left;">
                        <a href="../com/ArquivosRepresentantes_aForm.do?pop_action=&pos=<%=i_bl_report_Links_dinamicos %>&lidi_id=<%= lidi_id %>&lidi_titulo=<%= lidi_titulo %>&lidi_descricao=<%= lidi_descricao %>&lidi_caminho=<%= lidi_caminho %>&lidi_marca=<%= lidi_marca %>" target="_self" STYLE="cursor:hand">
                          <%= lidi_titulo %>
                        </a>
                      </td>
                      <td class="reportColumn" style="font-size:9;text-align:left;">
                        <%= lidi_caminho.replace("/arquivos/representantes/","") %>
                      </td>
                      <td class="reportColumn" style="font-size:10;text-align:center;">
                        <%= tipo %>
                      </td>
                      <td class="reportColumn" style="font-size:10;text-align:center;">
                        <a onclick="if(!(confirm('Confirma Exclusão?'))){return false;}"  href="../com/ArquivosRepresentantes_rForm.do?delete_action=&pos=<%=i_bl_report_Links_dinamicos %>&lidi_id=<%= lidi_id %>&lidi_caminho=<%= lidi_caminho %>&arquivo=<%= lidi_caminho.replace("/arquivos/representantes/","") %>" target=_self STYLE=cursor:hand>
                          <img border=0 src="../img/delete.jpg" name="imagem" onmouseover="this.src='../img/delete_s.jpg'" onmouseout="this.src='../img/delete.jpg'">
                        </a>
                      </td>
                    </tr>
                    <%
                    if (++i_bl_report_Links_dinamicos >= res_Links_dinamicos.size()) {
                      break;
                    }
                    t_links_dinamicos = (portalbr.dbobj.table.Links_dinamicos)res_Links_dinamicos.elementAt(i_bl_report_Links_dinamicos);
                    lidi_marca        = t_links_dinamicos.getLidi_marca();
                    lidi_titulo       = t_links_dinamicos.getLidi_titulo()==null?"":t_links_dinamicos.getLidi_titulo();
                    lidi_descricao    = t_links_dinamicos.getLidi_descricao()==null?"":t_links_dinamicos.getLidi_descricao();
                    lidi_caminho      = t_links_dinamicos.getLidi_caminho()==null?"":t_links_dinamicos.getLidi_caminho();
                    lidi_id           = t_links_dinamicos.getLidi_id();
                    lidi_marca        = t_links_dinamicos.getLidi_marca();
                    lidi_tipo         = t_links_dinamicos.getLidi_tipo();

                  if(lidi_tipo.equals("N")){ tipo="Normal";}else{tipo="Clientes";}
                  {
                    portalbr.dbobj.table.Marcas_produtos cr_db_object = new portalbr.dbobj.table.Marcas_produtos();
                    Object[][] where = {
                    {"codigo_marca","=",new Integer(lidi_marca)}
                    };
                    java.util.Vector results = j.select(cr_db_object, where, null);
                    if (results!=null && results.size()>0) {
                      cr_db_object = (portalbr.dbobj.table.Marcas_produtos)results.elementAt(0);
                      descricao_marca = cr_db_object.getDescricao_marca() + "";
                    }
                    };
                  }
                }
              } catch (Exception e) {
              } finally {
              if(j!=null){j.close(); }
            }
            %>
          </table>

          <html:form action="com/ArquivosRepresentantes_rForm.do" method="post" styleClass="baseForm">
            <table class="itemTable"  style=" width:;">
              <html:hidden property="pos"/>
              <html:hidden property="lidi_id"/>
              <html:hidden property="lidi_caminho"/>
              <html:hidden property="arquivo"/>
              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="b" styleClass="baseButton" property="back_action">
                      <bean:message bundle="ApplicationResources" key="jsp.back"/>
                    </html:submit>
                    <html:submit styleClass="myhidden" property="delete_action">
                      <bean:message bundle="ApplicationResources" key="jsp.delete"/>
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
