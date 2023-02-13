<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:640;'>
        <tr class="mainTr">
          <td class="mainTd">
            <%
            {
              java.util.Vector res_NecessidadeLiquida = (java.util.Vector)session.getAttribute("res_NecessidadeLiquida");
              portalbr.com.NecessidadeLiquidaPDFActionForm NecessidadeLiquidaPDFActionForm = (portalbr.com.NecessidadeLiquidaPDFActionForm)session.getAttribute("NecessidadeLiquidaPDFActionForm");
              util.consultas.Parametros parametros = new util.consultas.Parametros();
              if (res_NecessidadeLiquida!=null && res_NecessidadeLiquida.size()>0) {
                try {
                  acesso.Usuario u = new acesso.Usuario();
                  String usuario="admin";
                  u = (acesso.Usuario)session.getAttribute("User");
                  acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
                  if(!(u.getEntidadeNegocio()==null)){
                    ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();
                    usuario = ent.getChave()+"";
                  }
                  java.util.Date data = new java.util.Date();
                  java.util.Map parameters = new java.util.HashMap();
                  String file_jasper = "";
                  if(NecessidadeLiquidaPDFActionForm.getTipo().equals("s")){
                    file_jasper = parametros.retornaParametro("diretorio_jasper")+"necessidade.jasper";
                  } else {
                    file_jasper = parametros.retornaParametro("diretorio_jasper")+"necessidade_analitico.jasper";
                  }
                  //----- randômico ------
                  Random rand = new Random();
                  String palavra = "";
                  for(int y=0;y<10;y++){
                    int num=0;
                    num=rand.nextInt(255);
                    if((num>=65 && num<=90)||(num>=97 && num<=122)){
                      palavra+=(char)num;
                    }else {
                      palavra+=num;
                    }
                  }
                  String arquivo= "gef"+palavra+"_"+usuario+".pdf";
                  //-----------------------
                  String file_dest = parametros.retornaParametro("diretorio_pdf") + arquivo;
                  String file_link = parametros.retornaParametro("diretorio_link_pdf") + arquivo;

                  net.sf.jasperreports.engine.JRDataSource jrb = new net.sf.jasperreports.engine.data.JRBeanArrayDataSource(res_NecessidadeLiquida.toArray());
                  net.sf.jasperreports.engine.JasperRunManager.runReportToPdfFile(file_jasper,file_dest,parameters,jrb);

                  String url=request.getRequestURI();
                  %>
                  <center>
                    <table class='jasperTable'>
                      <tr class='jasperTr'>
                        <td class='jasperTd'>
                          <script>
                            window.open('<%= file_link %>','_self');
                          </script>
                        </td>
                      </tr>
</table        </center>        <%     } catch (Exception e){         session.setAttribute("exception",com.egen.util.system.Error.getDescription(e));         %> <jsp:forward page="/system/ErrorPage.jsp"/> <%    }  } }  %> <html:form action="com/NecessidadeLiquidaPDFReport.do" method="post" styleClass="baseForm">   <table class="bannerTable" style="width:640;">     <tr class="bannerTr">       <td class="bannerTd">        </td>     </tr>   </table>    <table class="messageTable" style='width:640;'>     <tr class="messageTr" >       <td class="messageTd">         <bean:message key="div.campos*"/>         <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form"/>       </td>     </tr>   </table>    <table class="itemTable"  style="width:640;">     <html:hidden property="tipo"/>   </table>    <table class="buttonTable" style='width:640;'>     <tr class="buttonTr">       <td class="buttonTd">         <html:submit accesskey="p" value="pop" styleClass="myhidden" property="pop_action">         </html:submit>       </td>     </tr>   </table>  </html:form> </td>  </tr> </table>  </body> </center> </html> 
