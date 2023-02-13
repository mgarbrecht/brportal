<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Consulta dos Últimos Acessos dos Representantes
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(103)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/UltimoAcessoRepForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="situacao"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_ultimo_acesso_rep"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Situação
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="situacao" onchange="select_action.click();" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="null">
                        Todos
                      </html:option>
                      <html:option styleClass="baseOption" value="A">
                        Ativos
                      </html:option>
                      <html:option styleClass="baseOption" value="I">
                        Inativos
                      </html:option>
                    </html:select>
                  </td>
                </tr>

              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit onclick="bloqueia();" styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                  </td>
                </tr>
              </table>

            </html:form>
            <%
            int counterbl_report_Jw_ultimo_acesso_rep=0;
            {
              portalbr.dbobj.view.Jw_ultimo_acesso_rep t_jw_ultimo_acesso_rep = new portalbr.dbobj.view.Jw_ultimo_acesso_rep();
              java.util.Vector res_Jw_ultimo_acesso_rep = (java.util.Vector)session.getAttribute("res_Jw_ultimo_acesso_rep");

              if (res_Jw_ultimo_acesso_rep!=null && res_Jw_ultimo_acesso_rep.size()>0) {
                java.lang.Integer codigo_regional    =  null;
                java.lang.String nome_regional       =  null;
                java.lang.String codigo              =  null;
                java.lang.String nome2               =  null;
                java.sql.Timestamp usua_dt_ultimo_acesso =  null;
                java.lang.String rep_situ            =  null;
                java.lang.Integer b0_codigo_regional =  null;
                java.lang.String b0_nome_regional    =  null;
                int i_bl_report_Jw_ultimo_acesso_rep = 0;

                t_jw_ultimo_acesso_rep = (portalbr.dbobj.view.Jw_ultimo_acesso_rep)res_Jw_ultimo_acesso_rep.elementAt(i_bl_report_Jw_ultimo_acesso_rep);
                codigo_regional        = t_jw_ultimo_acesso_rep.getCodigo_regional();
                nome_regional          = t_jw_ultimo_acesso_rep.getNome_regional()==null?"":t_jw_ultimo_acesso_rep.getNome_regional();
                codigo                 = t_jw_ultimo_acesso_rep.getCodigo()==null?"":t_jw_ultimo_acesso_rep.getCodigo();
                nome2                  = t_jw_ultimo_acesso_rep.getNome()==null?"":t_jw_ultimo_acesso_rep.getNome();
                usua_dt_ultimo_acesso  = (java.sql.Timestamp)t_jw_ultimo_acesso_rep.getUsua_dt_ultimo_acesso();
                rep_situ               = t_jw_ultimo_acesso_rep.getRep_situ()==null?"":t_jw_ultimo_acesso_rep.getRep_situ();

                while (i_bl_report_Jw_ultimo_acesso_rep<res_Jw_ultimo_acesso_rep.size()){
                  counterbl_report_Jw_ultimo_acesso_rep++;
                  %>
                  <table id="TRbl_report_Jw_ultimo_acesso_rep" class="reportTable" style=width:99%;  border=1  frame=box>
                    <tr class="reportHeader2" >
                      <td colspan=7>
                        <big>
                          Regional :
                          <%= ((codigo_regional!=null)?codigo_regional.toString():"") %>
                          -
                          <%= nome_regional %>
                        </big>
                      </td>
                    </tr>
                    <%
                    b0_codigo_regional = codigo_regional;
                    b0_nome_regional = nome_regional;
                    %>
                    <tr class="reportHeader">
                      <td class="columnTdHeader" style="text-align:left;" width="10%">
                        Código
                      </td>
                      <td class="columnTdHeader" style="text-align:left;">
                        Nome
                      </td>
                      <td class="columnTdHeader" style="text-align:center;" width="20%">
                        Data Último Acesso
                      </td>
                      <td class="columnTdHeader" style="text-align:center;" width="10%">
                        Situação
                      </td>
                    </tr>
                    <%
                    while (i_bl_report_Jw_ultimo_acesso_rep<res_Jw_ultimo_acesso_rep.size() &&  (b0_codigo_regional==null?0:b0_codigo_regional.intValue())==(codigo_regional==null?0:codigo_regional.intValue()) &&  (b0_nome_regional==null?"":b0_nome_regional).equals((nome_regional==null?"":nome_regional))){
                      counterbl_report_Jw_ultimo_acesso_rep++;
                      String style="";
                      if (!((i_bl_report_Jw_ultimo_acesso_rep%2)!=0)) {
                        style="class=rowColor";
                      } else {
                        style="class=rowBlank";
                      }
                      %>
                      <tr <%= style %> id='TRbl_report_Jw_ultimo_acesso_rep<%=counterbl_report_Jw_ultimo_acesso_rep%>' >
                        <td class="reportColumn" style="text-align:left;" width="10%">
                          <%= codigo %>
                        </td>
                        <td class="reportColumn" style="text-align:left;">
                          <%= nome2 %>
                        </td>
                        <td class="reportColumn" style="text-align:center;" width="20%">
                          <%= com.egen.util.text.FormatDate.format(usua_dt_ultimo_acesso, "dd/MM/yyyy hh:mm:ss") %>
                        </td>
                        <td class="reportColumn" style="text-align:center;" width="10%">
                          <%= rep_situ %>
                        </td>
                      </tr>
                      <%
                      if (++i_bl_report_Jw_ultimo_acesso_rep >= res_Jw_ultimo_acesso_rep.size()) {
                        break;
                      }
                      t_jw_ultimo_acesso_rep = (portalbr.dbobj.view.Jw_ultimo_acesso_rep)res_Jw_ultimo_acesso_rep.elementAt(i_bl_report_Jw_ultimo_acesso_rep);
                      codigo_regional        = t_jw_ultimo_acesso_rep.getCodigo_regional();
                      nome_regional          = t_jw_ultimo_acesso_rep.getNome_regional()==null?"":t_jw_ultimo_acesso_rep.getNome_regional();
                      codigo                 = t_jw_ultimo_acesso_rep.getCodigo()==null?"":t_jw_ultimo_acesso_rep.getCodigo();
                      nome2                  = t_jw_ultimo_acesso_rep.getNome()==null?"":t_jw_ultimo_acesso_rep.getNome();
                      usua_dt_ultimo_acesso  = (java.sql.Timestamp)t_jw_ultimo_acesso_rep.getUsua_dt_ultimo_acesso();
                      rep_situ               = t_jw_ultimo_acesso_rep.getRep_situ()==null?"":t_jw_ultimo_acesso_rep.getRep_situ();

                    }
                    %>
                  </table>
                  <%
                }
              }
            }
            %>
          </table>
        </td>
      </tr>
    </table>

  </body>
</center>
</html>
