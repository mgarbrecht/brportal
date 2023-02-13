<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Listagem dos Representantes do Cliente
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
                </td>

              </tr>

            </table>

            <table id="TRbl_report_Jw_clientes_representantes" class="reportTable" style=width:99%;>
              <%
              int counterbl_report_Jw_clientes_representantes=0;
              com.egen.util.jdbc.JdbcUtil j = null;
              try{
                j = new com.egen.util.jdbc.JdbcUtil();
                portalbr.dbobj.view.Jw_clientes_representantes t_jw_clientes_representantes = new portalbr.dbobj.view.Jw_clientes_representantes();
                java.util.Vector res_Jw_clientes_representantes = null;
                String chave = "0";
                acesso.Usuario u = new acesso.Usuario();
                u = (acesso.Usuario)session.getAttribute("User");
                acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
                acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();
                if(!(u.getEntidadeNegocio()==null)){
                  ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();
                  chave = ent.getChave()+"";
                }
                String[][] select =  null;
                String[]    order = {"representante"};
                Object[][]  where = {
                {"codigo_cliente","=",chave}
                };
                res_Jw_clientes_representantes = j.select(t_jw_clientes_representantes,select,where,null,null,order);

                if (res_Jw_clientes_representantes!=null && res_Jw_clientes_representantes.size()>0) {
                  java.lang.String codigo_cliente        =  null;
                  java.lang.String codigo_representante  =  null;
                  java.lang.String representante         =  null;
                  java.lang.String rep_nome              =  null;
                  java.lang.String marca                 =  null;
                  java.lang.String telefone              =  null;
                  int i_bl_report_Jw_clientes_representantes = 0;
                  t_jw_clientes_representantes = (portalbr.dbobj.view.Jw_clientes_representantes)res_Jw_clientes_representantes.elementAt(i_bl_report_Jw_clientes_representantes);
                  codigo_cliente       = t_jw_clientes_representantes.getCodigo_cliente()==null?"":t_jw_clientes_representantes.getCodigo_cliente();
                  codigo_representante = t_jw_clientes_representantes.getCodigo_representante()==null?"":t_jw_clientes_representantes.getCodigo_representante();
                  representante        = t_jw_clientes_representantes.getRepresentante()==null?"":t_jw_clientes_representantes.getRepresentante();
                  rep_nome             = t_jw_clientes_representantes.getRep_nome()==null?"":t_jw_clientes_representantes.getRep_nome();
                  marca                = t_jw_clientes_representantes.getMarca()==null?"":t_jw_clientes_representantes.getMarca();
                  telefone             = t_jw_clientes_representantes.getTelefone()==null?"":t_jw_clientes_representantes.getTelefone();


                  portalbr.dbobj.view.Jw_telefones_representantes cr_db_object2 = new portalbr.dbobj.view.Jw_telefones_representantes();
                  //------------- Telefones do Representante --------------
                  portalbr.dbobj.view.Jw_telefones_representantes cr_db_object = new portalbr.dbobj.view.Jw_telefones_representantes();
                  Object[][] where2 = {
                  {"rep_cdgo","=",codigo_representante}
                  };
                  java.util.Vector results = j.select(cr_db_object, where2, null);
                  if (results!=null && results.size()>0) {
                    cr_db_object = (portalbr.dbobj.view.Jw_telefones_representantes)results.elementAt(0);
                    telefone = ((cr_db_object.getFone()!=null)?cr_db_object.getFone():"");
                  }
                  //-------------------------------------------------------
                  java.lang.String b0_representante =  null;
                  while (i_bl_report_Jw_clientes_representantes<res_Jw_clientes_representantes.size()){
                    counterbl_report_Jw_clientes_representantes++;
                    b0_representante = representante;
                    while (i_bl_report_Jw_clientes_representantes<res_Jw_clientes_representantes.size() &&  (b0_representante==null?"":b0_representante).equals((representante==null?"":representante))){
                      counterbl_report_Jw_clientes_representantes++;
                      String style="";
                      if (!((i_bl_report_Jw_clientes_representantes%2)!=0)) {
                        style="class=rowColor";
                      } else {
                        style="class=rowBlank";
                      }
                      %>
                      <table id="TRbl_report_Jw_clientes_representantes" class="reportTable" style=width:99%; border=1; >
                        <tr class="reportHeader" >
                          <td colspan=3>
                            <%= representante %>
                          </td>
                        </tr>

                        <tr <%= style %> id='TRbl_report_Jw_clientes_representantes<%=counterbl_report_Jw_clientes_representantes%>' >
                          <td class="reportColumn" style="text-align:left;">
                            <b>
                              Nome:
                            </b>
                            <%= rep_nome %>
                            <br>
                            <b>
                              Marca:
                            </b>
                            <%= marca %>
                            <br>
                            <b>
                              Telefone:
                            </b>
                            <%= telefone %>
                            <br>
                            <b>
                              Email:
                            </b>
                            <a href="mailto:brrep<%= codigo_representante %>@beirario.com.br">
                              brrep
                              <%= codigo_representante %>
                              @beirario.com.br
                            </a>
                          </tr>
                        </table>
                        <%
                        if (++i_bl_report_Jw_clientes_representantes >= res_Jw_clientes_representantes.size()) {
                          break;
                        }
                        t_jw_clientes_representantes = (portalbr.dbobj.view.Jw_clientes_representantes)res_Jw_clientes_representantes.elementAt(i_bl_report_Jw_clientes_representantes);
                        codigo_cliente       = t_jw_clientes_representantes.getCodigo_cliente()==null?"":t_jw_clientes_representantes.getCodigo_cliente();
                        codigo_representante = t_jw_clientes_representantes.getCodigo_representante()==null?"":t_jw_clientes_representantes.getCodigo_representante();
                        representante        = t_jw_clientes_representantes.getRepresentante()==null?"":t_jw_clientes_representantes.getRepresentante();
                        rep_nome             = t_jw_clientes_representantes.getRep_nome()==null?"":t_jw_clientes_representantes.getRep_nome();
                        marca                = t_jw_clientes_representantes.getMarca()==null?"":t_jw_clientes_representantes.getMarca();
                        telefone             = t_jw_clientes_representantes.getTelefone()==null?"":t_jw_clientes_representantes.getTelefone();
                        //------------- Telefones do Representante --------------
                        Object[][] where3 = {
                        {"rep_cdgo","=",codigo_representante}
                        };
                        java.util.Vector results2 = j.select(cr_db_object2, where3, null);
                        if (results2!=null && results2.size()>0) {
                          cr_db_object2 = (portalbr.dbobj.view.Jw_telefones_representantes)results2.elementAt(0);
                          telefone = ((cr_db_object2.getFone()!=null)?cr_db_object2.getFone():"");
                        }
                        //-------------------------------------------------------
                      }
                    }
                  }
                } finally {
                  if(j!=null) {
                    j.close();
                    j = null;
                  }
                }
                %>
              </table>
              <html:form action="com/ClientesRepresentantesForm.do" method="post" styleClass="baseForm">
              </html:form>
            </td>
          </tr>
        </table>

      </body>
    </center>
  </html>
