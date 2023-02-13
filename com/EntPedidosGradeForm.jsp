<%
  int qtde_registros = 0;
  java.util.Vector res_Emula_itens_faturas_proformas = (java.util.Vector)session.getAttribute("res_Emula_itens_faturas_proformas");
  if (res_Emula_itens_faturas_proformas!=null && res_Emula_itens_faturas_proformas.size()>0) {
    qtde_registros = res_Emula_itens_faturas_proformas.size();
  }
  acesso.Sessao se = new acesso.Sessao(session);
  String cliente = "";
  if(se.getTipoEntidadeNegocio().equals("CLIENTE MERCADO EXTERNO")){
     cliente = se.getChave();
  }
%>

<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<% 
  response.setHeader("Cache-Control","no-cache");
  response.setDateHeader ("Expires", 0);
%>			
<html>
  <head>
    <bean:message key="page.css"/>
  </head>
<style type="text/css">	
.disabledSum {
	background-color:#d8d8d8;
	border-color:gray;
	cursor:default;
}
</style>	

  <center>
    <body>
      <table width="100%" align="center" border=0;>
        <tr>
          <td align="center">
            <%
            portalbr.com.EntPedidosGradeActionForm EntPedidosGradeActionForm = (portalbr.com.EntPedidosGradeActionForm)session.getAttribute("EntPedidosGradeActionForm");
            String tamanho_grade = (String)session.getAttribute("tamanho_grade");
            if(!cliente.equals("")){tamanho_grade = (Integer.parseInt(tamanho_grade)+1)+"";}
            String grade = (String)session.getAttribute("grade");
            String status_pedido = "O";
            if(session.getAttribute("status_pedido")!=null){
               status_pedido = (String)session.getAttribute("status_pedido");
            }
            %>

            <html:form action="com/EntPedidosGradeForm.do" method="post" >

             <% if(((String)session.getAttribute("tamanho_grade")).equals("0")){ %>
              <table border=2 width="35%" cellspacing=0 cellpadding=2 bordercolor="gray">
                <tr style="background-color:red" align="center">
             <% } else { %>
              <table border=2 width="5%" cellspacing=0 cellpadding=2 bordercolor="gray">
                <tr style="background-color:lightblue" align="center">
             <% } %>

                  <td colspan="<%= tamanho_grade %>" align="center">
                    <% if(((String)session.getAttribute("tamanho_grade")).equals("0")){ %>
                       <font color="white"><bean:message bundle="ComercialResources" key="EntPedidosForm.grade"/><%= ((String)session.getAttribute("tamanho_grade")).equals("0")?" Inválida":"" %></font>
                    <% } else { %>
                       <bean:message bundle="ComercialResources" key="EntPedidosForm.grade"/><%= ((String)session.getAttribute("tamanho_grade")).equals("0")?" Inválida":"" %>
                    <% } %>
                  </td>
                  <td>
                    <b>Total</b>
                  </td>

                </tr>

                <tr>

                  <%
                  if((EntPedidosGradeActionForm.getTam1()+"").equals("null")){
                    %>
                    <html:hidden property="tam1"/>
                    <html:hidden property="par1"/>
                    <%
                  } else {
                    %>
                    <% if(!cliente.equals("")){ %> 
                      <td valign="top">
                         <img src="../img/brasil.gif" width="20" height="13">
                      </td>
                    <% } %>
                    <td>
                      <html:text property="tam1" styleId="tam1" style="text-align:center" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                      <% if(!cliente.equals("")){ %>
                         <html:text property="tamex1" styleId="tamex1" style="text-align:center" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>                      
                      <% } %>
                      <% if((grade.equals("99")) && (status_pedido.equals("O"))){ %>
                      <html:text property="par1" styleId="par1" onkeypress="mascara(this,soNumeros);" onblur="mascara(this,soNumeros);" style="text-align:center" styleClass="tamanhos" onchange="trataChrome();"   size="5" maxlength="5"/>
                        <%
                      } else {
                        %>
                         <html:text property="par1" styleId="par1" style="text-align:center" tabindex="-1" readonly="true" styleClass="disabledSum" size="5" maxlength="5"/>
                        <%
                      }
                      %>
                    </td>
                    <%
                  }
                  %>

                  <%
                  if((EntPedidosGradeActionForm.getTam2()+"").equals("null")){
                    %>
                    <html:hidden property="tam2"/>
                    <html:hidden property="par2"/>
                    <%
                  } else {
                    %>
                    <td>
                      <html:text property="tam2" styleId="tam2" style="text-align:center" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                      <% if(!cliente.equals("")){ %>
                         <html:text property="tamex2" styleId="tamex2" style="text-align:center" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>                      
                      <% } %>
                      <% if((grade.equals("99")) && (status_pedido.equals("O"))){ %>
                        <html:text property="par2" styleId="par2" onkeypress="mascara(this,soNumeros);" onblur="mascara(this,soNumeros);" style="text-align:center" styleClass="tamanhos" onchange="trataChrome();"  size="5" maxlength="5"/>
                        <%
                      } else {
                        %>
                        <html:text property="par2" styleId="par2" style="text-align:center" tabindex="-1" readonly="true" styleClass="disabledSum" size="5" maxlength="5"/>
                        <%
                      }
                      %>
                    </td>
                    <%
                  }
                  %>

                  <%
                  if((EntPedidosGradeActionForm.getTam3()+"").equals("null")){
                    %>
                    <html:hidden property="tam3"/>
                    <html:hidden property="par3"/>
                    <%
                  } else {
                    %>
                    <td>
                      <html:text property="tam3" styleId="tam3" style="text-align:center" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                      <% if(!cliente.equals("")){ %>
                         <html:text property="tamex3" styleId="tamex3" style="text-align:center" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>                      
                      <% } %>
                      <% if((grade.equals("99")) && (status_pedido.equals("O"))){ %>
                        <html:text property="par3" styleId="par3" onkeypress="mascara(this,soNumeros);" onblur="mascara(this,soNumeros);" style="text-align:center" styleClass="tamanhos" onchange="trataChrome();"  size="5" maxlength="5"/>
                        <%
                      } else {
                        %>
                        <html:text property="par3" styleId="par3" style="text-align:center" tabindex="-1" readonly="true" styleClass="disabledSum" size="5" maxlength="5"/>
                        <%
                      }
                      %>
                    </td>
                    <%
                  }
                  %>

                  <%
                  if((EntPedidosGradeActionForm.getTam4()+"").equals("null")){
                    %>
                    <html:hidden property="tam4"/>
                    <html:hidden property="par4"/>
                    <%
                  } else {
                    %>
                    <td>
                      <html:text property="tam4" styleId="tam4" style="text-align:center" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                      <% if(!cliente.equals("")){ %>
                         <html:text property="tamex4" styleId="tamex4" style="text-align:center" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>                      
                      <% } %>
                      <% if((grade.equals("99")) && (status_pedido.equals("O"))){ %>
                        <html:text property="par4" styleId="par4" onkeypress="mascara(this,soNumeros);" onblur="mascara(this,soNumeros);" style="text-align:center" styleClass="tamanhos" onchange="trataChrome();"  size="5" maxlength="5"/>
                        <%
                      } else {
                        %>
                        <html:text property="par4" styleId="par4" style="text-align:center" tabindex="-1" readonly="true" styleClass="disabledSum" size="5" maxlength="5"/>
                        <%
                      }
                      %>
                    </td>
                    <%
                  }
                  %>

                  <%
                  if((EntPedidosGradeActionForm.getTam5()+"").equals("null")){
                    %>
                    <html:hidden property="tam5"/>
                    <html:hidden property="par5"/>
                    <%
                  } else {
                    %>
                    <td>
                      <html:text property="tam5" styleId="tam5" style="text-align:center" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                      <% if(!cliente.equals("")){ %>
                         <html:text property="tamex5" styleId="tamex5" style="text-align:center" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>                      
                      <% } %>
                      <% if((grade.equals("99")) && (status_pedido.equals("O"))){ %>
                        <html:text property="par5" styleId="par5" onkeypress="mascara(this,soNumeros);" onblur="mascara(this,soNumeros);" style="text-align:center" styleClass="tamanhos" onchange="trataChrome();"  size="5" maxlength="5"/>
                        <%
                      } else {
                        %>
                        <html:text property="par5" styleId="par5" style="text-align:center" tabindex="-1" readonly="true" styleClass="disabledSum" size="5" maxlength="5"/>
                        <%
                      }
                      %>
                    </td>
                    <%
                  }
                  %>

                  <%
                  if((EntPedidosGradeActionForm.getTam6()+"").equals("null")){
                    %>
                    <html:hidden property="tam6"/>
                    <html:hidden property="par6"/>
                    <%
                  } else {
                    %>
                    <td>
                      <html:text property="tam6" styleId="tam6" style="text-align:center" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                      <% if(!cliente.equals("")){ %>
                         <html:text property="tamex6" styleId="tamex6" style="text-align:center" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>                      
                      <% } %>
                      <% if((grade.equals("99")) && (status_pedido.equals("O"))){ %>
                        <html:text property="par6" styleId="par6" onkeypress="mascara(this,soNumeros);" onblur="mascara(this,soNumeros);" style="text-align:center" styleClass="tamanhos" onchange="trataChrome();"  size="5" maxlength="5"/>
                        <%
                      } else {
                        %>
                        <html:text property="par6" styleId="par6" style="text-align:center" tabindex="-1" readonly="true" styleClass="disabledSum" size="5" maxlength="5"/>
                        <%
                      }
                      %>
                    </td>
                    <%
                  }
                  %>

                  <%
                  if((EntPedidosGradeActionForm.getTam7()+"").equals("null")){
                    %>
                    <html:hidden property="tam7"/>
                    <html:hidden property="par7"/>
                    <%
                  } else {
                    %>
                    <td>
                      <html:text property="tam7" styleId="tam7" style="text-align:center" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                      <% if(!cliente.equals("")){ %>
                         <html:text property="tamex7" styleId="tamex7" style="text-align:center" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>                      
                      <% } %>
                      <% if((grade.equals("99")) && (status_pedido.equals("O"))){ %>
                        <html:text property="par7" styleId="par7" onkeypress="mascara(this,soNumeros);" onblur="mascara(this,soNumeros);" style="text-align:center" styleClass="tamanhos" onchange="trataChrome();"  size="5" maxlength="5"/>
                        <%
                      } else {
                        %>
                        <html:text property="par7" styleId="par7" style="text-align:center" tabindex="-1" readonly="true" styleClass="disabledSum" size="5" maxlength="5"/>
                        <%
                      }
                      %>
                    </td>
                    <%
                  }
                  %>

                  <%
                  if((EntPedidosGradeActionForm.getTam8()+"").equals("null")){
                    %>
                    <html:hidden property="tam8"/>
                    <html:hidden property="par8"/>
                    <%
                  } else {
                    %>
                    <td>
                      <html:text property="tam8" styleId="tam8" style="text-align:center" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                      <% if(!cliente.equals("")){ %>
                         <html:text property="tamex8" styleId="tamex8" style="text-align:center" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                      <% } %>
                      <% if((grade.equals("99")) && (status_pedido.equals("O"))){ %>
                        <html:text property="par8" styleId="par8" onkeypress="mascara(this,soNumeros);" onblur="mascara(this,soNumeros);" style="text-align:center" styleClass="tamanhos" onchange="trataChrome();"  size="5" maxlength="5"/>
                        <%
                      } else {
                        %>
                        <html:text property="par8" styleId="par8" style="text-align:center" tabindex="-1" readonly="true" styleClass="disabledSum" size="5" maxlength="5"/>
                        <%
                      }
                      %>
                    </td>
                    <%
                  }
                  %>

                  <%
                  if((EntPedidosGradeActionForm.getTam9()+"").equals("null")){
                    %>
                    <html:hidden property="tam9"/>
                    <html:hidden property="par9"/>
                    <%
                  } else {
                    %>
                    <td>
                      <html:text property="tam9" styleId="tam9" style="text-align:center" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                      <% if(!cliente.equals("")){ %>
                         <html:text property="tamex9" styleId="tamex9" style="text-align:center" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                      <% } %>
                      <% if((grade.equals("99")) && (status_pedido.equals("O"))){ %>
                        <html:text property="par9" styleId="par9" onkeypress="mascara(this,soNumeros);" onblur="mascara(this,soNumeros);" style="text-align:center" styleClass="tamanhos" onchange="trataChrome();"  size="5" maxlength="5"/>
                        <%
                      } else {
                        %>
                        <html:text property="par9" styleId="par9" style="text-align:center" tabindex="-1" readonly="true" styleClass="disabledSum" size="5" maxlength="5"/>
                        <%
                      }
                      %>
                    </td>
                    <%
                  }
                  %>

                  <%
                  if((EntPedidosGradeActionForm.getTam10()+"").equals("null")){
                    %>
                    <html:hidden property="tam10"/>
                    <html:hidden property="par10"/>
                    <%
                  } else {
                    %>
                    <td>
                      <html:text property="tam10" styleId="tam10" style="text-align:center" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                      <% if(!cliente.equals("")){ %>
                         <html:text property="tamex10" styleId="tamex10" style="text-align:center" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                      <% } %>
                      <% if((grade.equals("99")) && (status_pedido.equals("O"))){ %>
                        <html:text property="par10" styleId="par10" onkeypress="mascara(this,soNumeros);" onblur="mascara(this,soNumeros);" style="text-align:center" styleClass="tamanhos" onchange="trataChrome();"  size="5" maxlength="5"/>
                        <%
                      } else {
                        %>
                        <html:text property="par10" styleId="par10" style="text-align:center" tabindex="-1" readonly="true" styleClass="disabledSum" size="5" maxlength="5"/>
                        <%
                      }
                      %>
                    </td>
                    <%
                  }
                  %>

                  <%
                  if((EntPedidosGradeActionForm.getTam11()+"").equals("null")){
                    %>
                    <html:hidden property="tam11"/>
                    <html:hidden property="par11"/>
                    <%
                  } else {
                    %>
                    <td>
                      <html:text property="tam11" styleId="tam11" style="text-align:center" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                      <% if(!cliente.equals("")){ %>
                         <html:text property="tamex11" styleId="tamex11" style="text-align:center" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                      <% } %>
                      <% if((grade.equals("99")) && (status_pedido.equals("O"))){ %>
                        <html:text property="par11" styleId="par11" onkeypress="mascara(this,soNumeros);" onblur="mascara(this,soNumeros);" style="text-align:center" styleClass="tamanhos" onchange="trataChrome();"  size="5" maxlength="5"/>
                        <%
                      } else {
                        %>
                        <html:text property="par11" styleId="par11" style="text-align:center" tabindex="-1" readonly="true" styleClass="disabledSum" size="5" maxlength="5"/>
                        <%
                      }
                      %>
                    </td>
                    <%
                  }
                  %>

                  <%
                  if((EntPedidosGradeActionForm.getTam12()+"").equals("null")){
                    %>
                    <html:hidden property="tam12"/>
                    <html:hidden property="par12"/>
                    <%
                  } else {
                    %>
                    <td>
                      <html:text property="tam12" styleId="tam12" style="text-align:center" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                      <% if(!cliente.equals("")){ %>
                         <html:text property="tamex12" styleId="tamex12" style="text-align:center" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                      <% } %>
                      <% if((grade.equals("99")) && (status_pedido.equals("O"))){ %>
                        <html:text property="par12" styleId="par12" onkeypress="mascara(this,soNumeros);" onblur="mascara(this,soNumeros);" style="text-align:center" styleClass="tamanhos" onchange="trataChrome();"  size="5" maxlength="5"/>
                        <%
                      } else {
                        %>
                        <html:text property="par12" styleId="par12" style="text-align:center" tabindex="-1" readonly="true" styleClass="disabledSum" size="5" maxlength="5"/>
                        <%
                      }
                      %>
                    </td>
                    <%
                  }
                  %>

                  <%
                  if((EntPedidosGradeActionForm.getTam13()+"").equals("null")){
                    %>
                    <html:hidden property="tam13"/>
                    <html:hidden property="par13"/>
                    <%
                  } else {
                    %>
                    <td>
                      <html:text property="tam13" styleId="tam13" style="text-align:center" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                      <% if(!cliente.equals("")){ %>
                         <html:text property="tamex13" styleId="tamex13" style="text-align:center" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                      <% } %>
                      <% if((grade.equals("99")) && (status_pedido.equals("O"))){ %>
                        <html:text property="par13" styleId="par13" onkeypress="mascara(this,soNumeros);" onblur="mascara(this,soNumeros);" style="text-align:center" styleClass="tamanhos" onchange="trataChrome();"  size="5" maxlength="5"/>
                        <%
                      } else {
                        %>
                        <html:text property="par13" styleId="par13" style="text-align:center" tabindex="-1" readonly="true" styleClass="disabledSum" size="5" maxlength="5"/>
                        <%
                      }
                      %>
                    </td>
                    <%
                  }
                  %>

                  <%
                  if((EntPedidosGradeActionForm.getTam14()+"").equals("null")){
                    %>
                    <html:hidden property="tam14"/>
                    <html:hidden property="par14"/>
                    <%
                  } else {
                    %>
                    <td>
                      <html:text property="tam14" styleId="tam14" style="text-align:center" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                      <% if(!cliente.equals("")){ %>
                         <html:text property="tamex14" styleId="tamex14" style="text-align:center" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                      <% } %>
                      <% if((grade.equals("99")) && (status_pedido.equals("O"))){ %>
                        <html:text property="par14" styleId="par14" onkeypress="mascara(this,soNumeros);" onblur="mascara(this,soNumeros);" style="text-align:center" styleClass="tamanhos" onchange="trataChrome();"  size="5" maxlength="5"/>
                        <%
                      } else {
                        %>
                        <html:text property="par14" styleId="par14" style="text-align:center" tabindex="-1" readonly="true" styleClass="disabledSum" size="5" maxlength="5"/>
                        <%
                      }
                      %>
                    </td>
                    <%
                  }
                  %>

                  <%
                  if((EntPedidosGradeActionForm.getTam15()+"").equals("null")){
                    %>
                    <html:hidden property="tam15"/>
                    <html:hidden property="par15"/>
                    <%
                  } else {
                    %>
                    <td>
                      <html:text property="tam15" styleId="tam15" style="text-align:center" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                      <% if(!cliente.equals("")){ %>
                         <html:text property="tamex15" styleId="tamex15" style="text-align:center" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                      <% } %>
                      <% if((grade.equals("99")) && (status_pedido.equals("O"))){ %>
                        <html:text property="par15" styleId="par15" onkeypress="mascara(this,soNumeros);" onblur="mascara(this,soNumeros);" style="text-align:center" styleClass="tamanhos" onchange="trataChrome();"  size="5" maxlength="5"/>
                        <%
                      } else {
                        %>
                        <html:text property="par15" styleId="par15" style="text-align:center" tabindex="-1" readonly="true" styleClass="disabledSum" size="5" maxlength="5"/>
                        <%
                      }
                      %>
                    </td>
                    <%
                  }
                  %>

                  <%
                  if((EntPedidosGradeActionForm.getTam16()+"").equals("null")){
                    %>
                    <html:hidden property="tam16"/>
                    <html:hidden property="par16"/>
                    <%
                  } else {
                    %>
                    <td>
                      <html:text property="tam16" styleId="tam16" style="text-align:center" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                      <% if(!cliente.equals("")){ %>
                         <html:text property="tamex16" styleId="tamex16" style="text-align:center" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                      <% } %>
                      <% if((grade.equals("99")) && (status_pedido.equals("O"))){ %>
                        <html:text property="par16" styleId="par16" onkeypress="mascara(this,soNumeros);" onblur="mascara(this,soNumeros);" style="text-align:center" styleClass="tamanhos" onchange="trataChrome();"  size="5" maxlength="5"/>
                        <%
                      } else {
                        %>
                        <html:text property="par16" styleId="par16" style="text-align:center" tabindex="-1" readonly="true" styleClass="disabledSum" size="5" maxlength="5"/>
                        <%
                      }
                      %>
                    </td>
                    <%
                  }
                  %>

                  <%
                  if((EntPedidosGradeActionForm.getTam17()+"").equals("null")){
                    %>
                    <html:hidden property="tam17"/>
                    <html:hidden property="par17"/>
                    <%
                  } else {
                    %>
                    <td>
                      <html:text property="tam17" styleId="tam17" style="text-align:center" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                      <% if(!cliente.equals("")){ %>
                         <html:text property="tamex17" styleId="tamex17" style="text-align:center" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                      <% } %>
                      <% if((grade.equals("99")) && (status_pedido.equals("O"))){ %>
                        <html:text property="par17" styleId="par17" onkeypress="mascara(this,soNumeros);" onblur="mascara(this,soNumeros);" style="text-align:center" styleClass="tamanhos" onchange="trataChrome();"  size="5" maxlength="5"/>
                        <%
                      } else {
                        %>
                        <html:text property="par17" styleId="par17" style="text-align:center" tabindex="-1" readonly="true" styleClass="disabledSum" size="5" maxlength="5"/>
                        <%
                      }
                      %>
                    </td>
                    <%
                  }
                  %>

                  <%
                  if((EntPedidosGradeActionForm.getTam18()+"").equals("null")){
                    %>
                    <html:hidden property="tam18"/>
                    <html:hidden property="par18"/>
                    <%
                  } else {
                    %>
                    <td>
                      <html:text property="tam18" styleId="tam18" style="text-align:center" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                      <% if(!cliente.equals("")){ %>
                         <html:text property="tamex18" styleId="tamex18" style="text-align:center" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                      <% } %>
                      <% if((grade.equals("99")) && (status_pedido.equals("O"))){ %>
                        <html:text property="par18" styleId="par18" onkeypress="mascara(this,soNumeros);" onblur="mascara(this,soNumeros);" style="text-align:center" styleClass="tamanhos" onchange="trataChrome();"  size="5" maxlength="5"/>
                        <%
                      } else {
                        %>
                        <html:text property="par18" styleId="par18" style="text-align:center" tabindex="-1" readonly="true" styleClass="disabledSum" size="5" maxlength="5"/>
                        <%
                      }
                      %>
                    </td>
                    <%
                  }
                  %>

                  <%
                  if((EntPedidosGradeActionForm.getTam19()+"").equals("null")){
                    %>
                    <html:hidden property="tam19"/>
                    <html:hidden property="par19"/>
                    <%
                  } else {
                    %>
                    <td>
                      <html:text property="tam19" styleId="tam19" style="text-align:center" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                      <% if(!cliente.equals("")){ %>
                         <html:text property="tamex19" styleId="tamex19" style="text-align:center" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                      <% } %>
                      <% if((grade.equals("99")) && (status_pedido.equals("O"))){ %>
                        <html:text property="par19" styleId="par19" onkeypress="mascara(this,soNumeros);" onblur="mascara(this,soNumeros);" style="text-align:center" styleClass="tamanhos" onchange="trataChrome();"  size="5" maxlength="5"/>
                        <%
                      } else {
                        %>
                        <html:text property="par19" styleId="par19" style="text-align:center" tabindex="-1" readonly="true" styleClass="disabledSum" size="5" maxlength="5"/>
                        <%
                      }
                      %>
                    </td>
                    <%
                  }
                  %>

                  <%
                  if((EntPedidosGradeActionForm.getTam20()+"").equals("null")){
                    %>
                    <html:hidden property="tam20"/>
                    <html:hidden property="par20"/>
                    <%
                  } else {
                    %>
                    <td>
                      <html:text property="tam20" styleId="tam20" style="text-align:center" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                      <% if(!cliente.equals("")){ %>
                         <html:text property="tamex20" styleId="tamex1" style="text-align:center" styleClass="disabled" tabindex="-1" readonly="true" size="5" maxlength="5"/>
                      <% } %>
                      <% if((grade.equals("99")) && (status_pedido.equals("O"))){ %>
                        <html:text property="par20" styleId="par20" onkeypress="mascara(this,soNumeros);" onblur="mascara(this,soNumeros);" style="text-align:center" styleClass="tamanhos" onchange="trataChrome();"  size="5" maxlength="5"/>
                        <%
                      } else {
                        %>
                        <html:text property="par20" styleId="par20" style="text-align:center" tabindex="-1" readonly="true" styleClass="disabledSum" size="5" maxlength="5"/>
                        <%
                      }
                      %>
                    </td>
                    <%
                  }
                  %>

                  <td valign="bottom">


<% if(grade.equals("99")){ %>
<div id="duplicar">

<html:button onclick="duplicar();" styleClass="baseButton" property="copiar_grade"><bean:message bundle="ComercialResources" key="EntPedidosForm.copiar_grade"/></html:button>

<input type="button" value="Grade Anterior"  />
</div>
<% } %>

                     <html:text property="total" styleId="total" style="text-align:center" tabindex="-1" readonly="true" styleClass="disabled" size="5" maxlength="5"/>
                  </td>

                </tr>

              </table>


              <table style='width:100%;'>
                <tr >
                  <td >
                    <html:submit accesskey="p" styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit accesskey="l" styleClass="myhidden" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                    <html:submit accesskey="a" styleClass="myhidden" property="update_action">
                      <bean:message bundle="ApplicationResources" key="jsp.update"/>
                    </html:submit>
                    <html:submit accesskey="a" styleClass="myhidden" property="duplicar_action">
                    </html:submit>
                  </td>
                </tr>
              </table>


              <script>
                jQuery('.tamanhos').change(function() {
                  jQuery.post('EntPedidosGradeForm.do?update_action=&tam1='+jQuery('#tam1').val()+'&par1='+jQuery('#par1').val()+'&tam2='+jQuery('#tam2').val()+'&par2='+jQuery('#par2').val()+'&tam3='+jQuery('#tam3').val()+'&par3='+jQuery('#par3').val()+'&tam4='+jQuery('#tam4').val()+'&par4='+jQuery('#par4').val()+'&tam5='+jQuery('#tam5').val()+'&par5='+jQuery('#par5').val()+'&tam6='+jQuery('#tam6').val()+'&par6='+jQuery('#par6').val()+'&tam7='+jQuery('#tam7').val()+'&par7='+jQuery('#par7').val()+'&tam8='+jQuery('#tam8').val()+'&par8='+jQuery('#par8').val()+'&tam9='+jQuery('#tam9').val()+'&par9='+jQuery('#par9').val()+'&tam10='+jQuery('#tam10').val()+'&par10='+jQuery('#par10').val()+'&tam11='+jQuery('#tam11').val()+'&par11='+jQuery('#par11').val()+'&tam12='+jQuery('#tam12').val()+'&par12='+jQuery('#par12').val()+'&tam13='+jQuery('#tam13').val()+'&par13='+jQuery('#par13').val()+'&tam14='+jQuery('#tam14').val()+'&par14='+jQuery('#par14').val()+'&tam15='+jQuery('#tam15').val()+'&par15='+jQuery('#par15').val()+'&tam16='+jQuery('#tam16').val()+'&par16='+jQuery('#par16').val()+'&tam17='+jQuery('#tam17').val()+'&par17='+jQuery('#par17').val()+'&tam18='+jQuery('#tam18').val()+'&par18='+jQuery('#par18').val()+'&tam19='+jQuery('#tam19').val()+'&par19='+jQuery('#par19').val()+'&tam20='+jQuery('#tam20').val()+'&par20='+jQuery('#par20').val());
                  somaQuantidades();
                });

                function trataChrome(){
                  jQuery.post('EntPedidosGradeForm.do?update_action=&tam1='+jQuery('#tam1').val()+'&par1='+jQuery('#par1').val()+'&tam2='+jQuery('#tam2').val()+'&par2='+jQuery('#par2').val()+'&tam3='+jQuery('#tam3').val()+'&par3='+jQuery('#par3').val()+'&tam4='+jQuery('#tam4').val()+'&par4='+jQuery('#par4').val()+'&tam5='+jQuery('#tam5').val()+'&par5='+jQuery('#par5').val()+'&tam6='+jQuery('#tam6').val()+'&par6='+jQuery('#par6').val()+'&tam7='+jQuery('#tam7').val()+'&par7='+jQuery('#par7').val()+'&tam8='+jQuery('#tam8').val()+'&par8='+jQuery('#par8').val()+'&tam9='+jQuery('#tam9').val()+'&par9='+jQuery('#par9').val()+'&tam10='+jQuery('#tam10').val()+'&par10='+jQuery('#par10').val()+'&tam11='+jQuery('#tam11').val()+'&par11='+jQuery('#par11').val()+'&tam12='+jQuery('#tam12').val()+'&par12='+jQuery('#par12').val()+'&tam13='+jQuery('#tam13').val()+'&par13='+jQuery('#par13').val()+'&tam14='+jQuery('#tam14').val()+'&par14='+jQuery('#par14').val()+'&tam15='+jQuery('#tam15').val()+'&par15='+jQuery('#par15').val()+'&tam16='+jQuery('#tam16').val()+'&par16='+jQuery('#par16').val()+'&tam17='+jQuery('#tam17').val()+'&par17='+jQuery('#par17').val()+'&tam18='+jQuery('#tam18').val()+'&par18='+jQuery('#par18').val()+'&tam19='+jQuery('#tam19').val()+'&par19='+jQuery('#par19').val()+'&tam20='+jQuery('#tam20').val()+'&par20='+jQuery('#par20').val());
                  somaQuantidades();
                }

              </script>


                 <% if((grade.equals("99")) && (status_pedido.equals("O"))){ %>
                     <script>jQuery('#par1').focus();</script>
                 <% } %>

                </html:form>

<% if(((String)session.getAttribute("atualiza")+"").equals("s")){ %>
             <script>
               function somaQuantidades(){
                  var total = 0;   
                  if(total==0){jQuery('#duplicar').show();}else{jQuery('#duplicar').hide();}
                  jQuery(".tamanhos").each( function(){
                     total += parseInt(jQuery(this).val());
                  });
                  jQuery(".disabledSum").each( function(){
                     total += parseInt(jQuery(this).val());
                  });
                  jQuery('#total').val(total);
                  <% if(qtde_registros==1){ %>
                     document.forms[1].quantidade_pares.value=total;
                  <% } else { %>
                     document.forms[1].quantidade_pares[<%= (String)session.getAttribute("indice") %>].value=total;
                  <% } %>
               }

               jQuery(document).ready(function() {
                  somaQuantidades();     
               });
   
             </script>
<% } else { %>

             <script>
               function somaQuantidades(){
                  if(total==0){jQuery('#duplicar').show();}else{jQuery('#duplicar').hide();}
                  var total = 0;   
                  jQuery(".tamanhos").each( function(){
                     total += parseInt(jQuery(this).val());
                  });
                  jQuery(".disabledSum").each( function(){
                     total += parseInt(jQuery(this).val());
                  });
                  jQuery('#total').val(total);

                  <% if(qtde_registros==1){ %>
                     document.forms[1].quantidade_pares.value=total;
                  <% } else { %>
                     document.forms[1].quantidade_pares[<%= (String)session.getAttribute("indice") %>].value=total;
                  <% } %>

               }

               jQuery(document).ready(function() {
                  somaQuantidades();     
               });
   
             </script>

<% } %>


              </td>
            </tr>
          </table>
 

        </body>
      </center>
    </html>


<script>
function duplicar(){
   jQuery.post('EntPedidosGradeForm.do?resetfull1_action=&numero_item=<%= EntPedidosGradeActionForm.getNumero_item() %>',function(){
       jQuery('#grade<%= EntPedidosGradeActionForm.getIndice() %>').load('EntPedidosGradeForm.do?select_action=&atualiza=n&numero_item=<%= EntPedidosGradeActionForm.getNumero_item() %>&lin_cdgo=<%= EntPedidosGradeActionForm.getLin_cdgo() %>&ref_cdgo=<%= EntPedidosGradeActionForm.getRef_cdgo() %>&gde_cdgo=<%= grade %>&indice=<%= EntPedidosGradeActionForm.getIndice() %>',function(){}).fadeIn('slow');
   });
}
</script>



