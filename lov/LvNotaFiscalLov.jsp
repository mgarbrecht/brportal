<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <link href="../css/stylelov.css" rel="stylesheet" type="text/css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:780;'>
        <tr class="mainTr">
          <td class="mainTd">
            <html:form action="lov/LvNotaFiscalLov.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:780;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="emp_empresa"/>
                    <html:errors property="fil_filial"/>
                    <html:errors property="nfs_nmro"/>
                    <html:errors property="nfs_serie"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_nota_fiscal"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:780;">
                <html:hidden property="return0" value="<%= request.getParameter("return0") %>"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Empresa
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="emp_empresa" styleId="emp_empresa" styleClass="baseField" size="3" maxlength="3"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Filial
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="fil_filial" styleId="fil_filial" styleClass="baseField" size="4" maxlength="4"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Nota
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="nfs_nmro" styleId="nfs_nmro" styleClass="baseField" size="22" maxlength="22"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Série
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="nfs_serie" styleId="nfs_serie" styleClass="baseField" size="3" maxlength="3"/>
                  </td>
                </tr>

              </table>

              <table class="buttonTable" style='width:780;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="p" styleClass="baseButton" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit accesskey="l" styleClass="baseButton" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                  </td>
                </tr>
              </table>

            </html:form>
            <script type="text/javascript">
              var focusControl = document.forms[0].elements["emp_empresa"];
              if (focusControl.type != "hidden"){
                focusControl.focus();
              }
            </script>

            <%
            {
              %>

              <%
              java.util.Vector res_Jw_nota_fiscal = (java.util.Vector)session.getAttribute("res_Jw_nota_fiscal");
              %>

              <form  name="bl_report_Jw_nota_fiscal" id="bl_report_Jw_nota_fiscal" class="baseForm" method="post" >
                <%
                if (res_Jw_nota_fiscal!=null && res_Jw_nota_fiscal.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_nota_fiscal"  class="reportTable"   style="width:780; "  >
                    <%
                    java.lang.String emp_empresa =  null;
                    java.lang.String fil_filial =  null;
                    java.lang.Integer nfs_nmro =  null;
                    java.lang.String nfs_serie =  null;
                    java.lang.Integer cli_cdgo =  null;
                    java.lang.Integer esc_seqn =  null;
                    java.lang.String cli_rzao =  null;
                    java.lang.Double valor_total =  null;
                    java.sql.Date data_emissao =  null;
                    java.lang.Integer qtd_duplicatas =  null;
                    java.lang.Double ped_boni =  null;
                    java.lang.Double ped_comr =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:left;" >
                        Empresa
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Filial
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Nota
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Série
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Cliente
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Seq.
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Razão Social
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Valor
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Dt. Emissão
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Qtd. Duplicatas
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Jw_nota_fiscal = 0;
                    while (i_bl_report_Jw_nota_fiscal<res_Jw_nota_fiscal.size()) {
                      portalbr.dbobj.view.Jw_nota_fiscal t_jw_nota_fiscal = (portalbr.dbobj.view.Jw_nota_fiscal)res_Jw_nota_fiscal.elementAt(i_bl_report_Jw_nota_fiscal);
                      emp_empresa = t_jw_nota_fiscal.getEmp_empresa()==null?"":t_jw_nota_fiscal.getEmp_empresa();
                      fil_filial = t_jw_nota_fiscal.getFil_filial()==null?"":t_jw_nota_fiscal.getFil_filial();
                      nfs_nmro = t_jw_nota_fiscal.getNfs_nmro();
                      nfs_serie = t_jw_nota_fiscal.getNfs_serie()==null?"":t_jw_nota_fiscal.getNfs_serie();
                      cli_cdgo = t_jw_nota_fiscal.getCli_cdgo();
                      esc_seqn = t_jw_nota_fiscal.getEsc_seqn();
                      cli_rzao = t_jw_nota_fiscal.getCli_rzao()==null?"":t_jw_nota_fiscal.getCli_rzao();
                      valor_total = t_jw_nota_fiscal.getValor_total();
                      data_emissao = (java.sql.Date)t_jw_nota_fiscal.getData_emissao();
                      qtd_duplicatas = t_jw_nota_fiscal.getQtd_duplicatas();
                      ped_boni = t_jw_nota_fiscal.getPed_boni();
                      ped_comr = t_jw_nota_fiscal.getPed_comr();
                      String style_bl_report_Jw_nota_fiscal="";
                      if (!((i_bl_report_Jw_nota_fiscal%2)!=0)) {
                        style_bl_report_Jw_nota_fiscal="rowColor";
                      } else {
                        style_bl_report_Jw_nota_fiscal="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_nota_fiscal %>' id="TRbl_report_Jw_nota_fiscal<%=i_bl_report_Jw_nota_fiscal%>" >
                        <td class="reportColumn" style="text-align:left;" >
                          <%= emp_empresa %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= fil_filial %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <a href="javascript:setLov('<%= emp_empresa %>','<%= fil_filial %>','<%= nfs_nmro %>','<%= nfs_serie %>','<%= valor_total %>','<%= qtd_duplicatas %>','<%= ped_boni %>','<%= ped_comr %>')" style="cursor:hand">
                            <%= ((nfs_nmro!=null)?nfs_nmro.toString():"") %>
                          </a>

                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= nfs_serie %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((cli_cdgo!=null)?cli_cdgo.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= ((esc_seqn!=null)?esc_seqn.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= cli_rzao %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(valor_total, "##,##0.00") %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= com.egen.util.text.FormatDate.format(data_emissao, "dd/MM/yyyy") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((qtd_duplicatas!=null)?qtd_duplicatas.toString():"") %>
                        </td>

                      </tr>

                      <%
                      i_bl_report_Jw_nota_fiscal++;
                      if (i_bl_report_Jw_nota_fiscal<res_Jw_nota_fiscal.size()) {
                        t_jw_nota_fiscal = (portalbr.dbobj.view.Jw_nota_fiscal)res_Jw_nota_fiscal.elementAt(i_bl_report_Jw_nota_fiscal);
                        emp_empresa = t_jw_nota_fiscal.getEmp_empresa()==null?"":t_jw_nota_fiscal.getEmp_empresa();
                        fil_filial = t_jw_nota_fiscal.getFil_filial()==null?"":t_jw_nota_fiscal.getFil_filial();
                        nfs_nmro = t_jw_nota_fiscal.getNfs_nmro();
                        nfs_serie = t_jw_nota_fiscal.getNfs_serie()==null?"":t_jw_nota_fiscal.getNfs_serie();
                        cli_cdgo = t_jw_nota_fiscal.getCli_cdgo();
                        esc_seqn = t_jw_nota_fiscal.getEsc_seqn();
                        cli_rzao = t_jw_nota_fiscal.getCli_rzao()==null?"":t_jw_nota_fiscal.getCli_rzao();
                        valor_total = t_jw_nota_fiscal.getValor_total();
                        data_emissao = (java.sql.Date)t_jw_nota_fiscal.getData_emissao();
                        qtd_duplicatas = t_jw_nota_fiscal.getQtd_duplicatas();
                        ped_boni = t_jw_nota_fiscal.getPed_boni();
                        ped_comr = t_jw_nota_fiscal.getPed_comr();
                      } else {
                      }
                    }
                    %>

                  </table>

                  <%
                }
                %>

                <script type="text/javascript">
                  function setLov(EMP_EMPRESA,FIL_FILIAL,NFS_NMRO,NFS_SERIE,VALOR_TOTAL,QTD_DUPLICATAS,PED_BONI,PED_COMR) {
                    <% {
                      String returnBlock = "0";
                      String return0 = null;
                      String return1 = null;
                      String return2 = null;
                      String return3 = null;
                      String return4 = null;
                      String return5 = null;
                      String return6 = null;
                      String return7 = null;
                      if (request.getParameter("returnBlock")!=null) {
                        returnBlock = request.getParameter("returnBlock");
                        session.setAttribute("returnBlock",returnBlock);
                        return0 = ((request.getParameter("return0")!=null)?request.getParameter("return0"):null);
                        session.setAttribute("return0",return0);
                        return1 = ((request.getParameter("return1")!=null)?request.getParameter("return1"):null);
                        session.setAttribute("return1",return1);
                        return2 = ((request.getParameter("return2")!=null)?request.getParameter("return2"):null);
                        session.setAttribute("return2",return2);
                        return3 = ((request.getParameter("return3")!=null)?request.getParameter("return3"):null);
                        session.setAttribute("return3",return3);
                        return4 = ((request.getParameter("return4")!=null)?request.getParameter("return4"):null);
                        session.setAttribute("return4",return4);
                        return5 = ((request.getParameter("return5")!=null)?request.getParameter("return5"):null);
                        session.setAttribute("return5",return5);
                        return6 = ((request.getParameter("return6")!=null)?request.getParameter("return6"):null);
                        session.setAttribute("return6",return6);
                        return7 = ((request.getParameter("return7")!=null)?request.getParameter("return7"):null);
                        session.setAttribute("return7",return7);
                        session.setAttribute("ge_LovPage", "LvNotaFiscalLov");
                      } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvNotaFiscalLov")) {
                        returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                        return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                        return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                        return2 = ((session.getAttribute("return2")!=null)?(String)session.getAttribute("return2"):null);
                        return3 = ((session.getAttribute("return3")!=null)?(String)session.getAttribute("return3"):null);
                        return4 = ((session.getAttribute("return4")!=null)?(String)session.getAttribute("return4"):null);
                        return5 = ((session.getAttribute("return5")!=null)?(String)session.getAttribute("return5"):null);
                        return6 = ((session.getAttribute("return6")!=null)?(String)session.getAttribute("return6"):null);
                        return7 = ((session.getAttribute("return7")!=null)?(String)session.getAttribute("return7"):null);
                      }
                      %>
                      returnBlock = <%= returnBlock %>;
                      <% if (return0!=null && return0.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=EMP_EMPRESA; };
                      <%}%>
                      <% if (return1!=null && return1.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=FIL_FILIAL; };
                      <%}%>
                      <% if (return2!=null && return2.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return2%>!=null) { opener.document.forms[returnBlock].<%= return2 %>.value=NFS_NMRO; };
                      <%}%>
                      <% if (return3!=null && return3.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return3%>!=null) { opener.document.forms[returnBlock].<%= return3 %>.value=NFS_SERIE; };
                      <%}%>
                      <% if (return4!=null && return4.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return4%>!=null) { opener.document.forms[returnBlock].<%= return4 %>.value=VALOR_TOTAL; };
                      <%}%>
                      <% if (return5!=null && return5.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return5%>!=null) { opener.document.forms[returnBlock].<%= return5 %>.value=QTD_DUPLICATAS; };
                      <%}%>
                      <% if (return6!=null && return6.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return6%>!=null) { opener.document.forms[returnBlock].<%= return6 %>.value=PED_BONI; };
                      <%}%>
                      <% if (return7!=null && return7.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return7%>!=null) { opener.document.forms[returnBlock].<%= return7 %>.value=PED_COMR; };
                      <%}%>
                      window.close();
                    }
                    <% } %>
                  </script>

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
