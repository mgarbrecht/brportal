<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <base target=_self>
    <title>
      <bean:message key="page.title"/>
    </title>

    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:500;'>
        <tr class="mainTr">
          <td class="mainTd">
            <table class="headerTable">
              <tr class="headerTr">
                <td class="headerTd">
                  <bean:message key="page.title"/>
                </td>
              </td>
            </tr>
          </table>

          <html:form action="lov/LvItemLov.do" method="post" styleClass="baseForm">
            <table class="bannerTable" style="width:500;">
              <tr class="bannerTr">
                <td class="bannerTd">
                  Lista de Valores
                </td>
              </tr>
            </table>

            <table class="messageTable" style='width:500;'>
              <tr class="messageTr" >
                <td class="messageTd">
                  <bean:message key="div.campos*"/>
                  <html:errors property="codigo"/>
                  <html:errors property="descricao"/>
                  <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Dom_item_estoque"/>
                </td>
              </tr>
            </table>

            <table class="itemTable"  style="width:500;">
              <html:hidden property="return0" value="<%= request.getParameter("return0") %>"/>
              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Código
                  </span>
                  <bean:message key="jsp.fieldnotnull"/>
                </td>
                <td class="formField">
                  <html:text property="codigo" styleId="codigo" styleClass="baseField" size="15" maxlength="15"/>
                </td>
              </tr>

              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Descrição
                  </span>
                </td>
                <td class="formField">
                  <html:text property="descricao" styleId="descricao" styleClass="baseField" size="100" maxlength="100"/>
                </td>
              </tr>

            </table>

            <table class="buttonTable" style='width:500;'>
              <tr class="buttonTr">
                <td class="buttonTd">
                  <html:submit accesskey="s" styleClass="baseButton" property="select_action">
                    <bean:message bundle="ApplicationResources" key="jsp.select"/>
                  </html:submit>
                  <html:submit accesskey="r" styleClass="baseButton" property="resetfull_action">
                    <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                  </html:submit>
                </td>
              </tr>
            </table>

          </html:form>
          <%
          {
            %>

            <%
            java.util.Vector res_Dom_item_estoque = null;
            portalbr.lov.LvItemActionForm LvItemActionForm = (portalbr.lov.LvItemActionForm)session.getAttribute("LvItemActionForm");
            if(LvItemActionForm!=null && (LvItemActionForm.getCodigo()!=null && LvItemActionForm.getCodigo().length()>0)) {
              com.egen.util.jdbc.JdbcUtil j = null;
              try {
                j = new com.egen.util.jdbc.JdbcUtil();
                portalbr.dbobj.table.Dom_item_estoque t_dom_item_estoque = new portalbr.dbobj.table.Dom_item_estoque();
                String[][] select = {{"codigo",null},{"descricao",null},};
                Object[][] where = null;
                where = new Object[][]{{"codigo","=",com.egen.util.text.FormatNumber.toInt(LvItemActionForm.getCodigo())}};
                String[] groupby =  null;
                String[] having =  null;
                String[] order =  null;
                res_Dom_item_estoque = j.select(t_dom_item_estoque,select,where,groupby,having,order);
              } catch (Exception e){
                res_Dom_item_estoque = null;
              } finally {
              if(j!=null){j.close();}
            }
          } else {
            res_Dom_item_estoque = null;
          }
          %>

          <form  name="bl_report_Dom_item_estoque" id="bl_report_Dom_item_estoque" class="baseForm" method="post" >
            <table class="bannerTable" style="width:500;">
              <tr class="bannerTr">
                <td class="bannerTd">
                  Itens
                </td>
              </tr>
            </table>

            <%
            if (res_Dom_item_estoque!=null && res_Dom_item_estoque.size()>0) {
              %>

              <table id="TRbl_report_Dom_item_estoque"  class="reportTable"   style="width:500; "  >
                <%
                int codigo =  0;
                java.lang.String descricao =  null;
                %>

                <tr class="reportTr">
                  <td class="columnTdHeader" style="text-align:right;" >
                    Código
                  </td>

                  <td class="columnTdHeader" style="text-align:left;" >
                    Descrição
                  </td>

                </tr>

                <%
                int i_bl_report_Dom_item_estoque = 0;
                while (i_bl_report_Dom_item_estoque<res_Dom_item_estoque.size()) {
                  portalbr.dbobj.table.Dom_item_estoque t_dom_item_estoque = (portalbr.dbobj.table.Dom_item_estoque)res_Dom_item_estoque.elementAt(i_bl_report_Dom_item_estoque);
                  codigo = t_dom_item_estoque.getCodigo();
                  descricao = t_dom_item_estoque.getDescricao()==null?"":t_dom_item_estoque.getDescricao();
                  String style_bl_report_Dom_item_estoque="";
                  if (!((i_bl_report_Dom_item_estoque%2)!=0)) {
                    style_bl_report_Dom_item_estoque="rowColor";
                  } else {
                    style_bl_report_Dom_item_estoque="rowBlank";
                  }
                  %>

                  <tr class='<%= style_bl_report_Dom_item_estoque %>' id="TRbl_report_Dom_item_estoque<%=i_bl_report_Dom_item_estoque%>" >
                    <td class="reportColumn" style="text-align:right;" >
                      <%= codigo %>
                    </td>

                    <td class="reportColumn" style="text-align:left;" >
                      <%= descricao %>
                    </td>

                  </tr>

                  <%
                  i_bl_report_Dom_item_estoque++;
                  if (i_bl_report_Dom_item_estoque<res_Dom_item_estoque.size()) {
                    t_dom_item_estoque = (portalbr.dbobj.table.Dom_item_estoque)res_Dom_item_estoque.elementAt(i_bl_report_Dom_item_estoque);
                    codigo = t_dom_item_estoque.getCodigo();
                    descricao = t_dom_item_estoque.getDescricao()==null?"":t_dom_item_estoque.getDescricao();
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

        <table class="footerTable">
          <tr class="footerTr">
            <td class="footerTd">
              <bean:message key="div.print"/>
            </td>
          </tr>

        </table>

      </td>
    </tr>
  </table>

</body>
</center>
</html>
