<%@ page import="java.util.Date, java.text.SimpleDateFormat, acesso.*"%>
<%
//------------------------------------------------
      java.util.Locale locale = null;
                locale = new java.util.Locale("pt","BR");
        Locale.setDefault(locale);
        session.setAttribute(org.apache.struts.Globals.LOCALE_KEY, locale);
//------------------------------------------------
  Date data = new Date();
  SimpleDateFormat fData = new SimpleDateFormat("dd/MM/yyyy");
  SimpleDateFormat fHora = new SimpleDateFormat("HH:mm:ss");
  Usuario user = (Usuario) session.getAttribute("User");
  EntidadeNegocio entidadeNegocio = user.getEntidadeNegocio();
  TipoEntidadeNegocio tipoEntidade = null;
  if (entidadeNegocio != null)
	  tipoEntidade = entidadeNegocio.getTipoEntidadeNegocio();
  if(user.getAcessos()==0){
  %><script>top.location='../acesso/TrocaSenhaForm.jsp';</script><%
  }	
  if(user.getSituacao().equals("I")){
  %><script>top.location='../system/Bloqueio.jsp';</script><%
  }  
 %> 

<link rel="stylesheet" href="../style.css" type="text/css">
<table width="100%" border=0>

	<tr> 
		<td width="10%"><img src="<%= request.getContextPath() %>/img/lg_SA.jpg">
		<td VALIGN=BOTTOM align=center>
	             <b><font color="#C40000" size=3><script>document.write(document.title);</script></font><b>
		</td>
		<td align="right" width="35%">
		<table>
			<tr>
				<th align="right"><font color="#8D0000" size=1>Data:</font></th>
				<td><font color="#8D0000" size=1><%= fData.format(data) %></font></td>
			</tr>
			<tr>
				<th align="right"><font color="#8D0000" size=1>Hora:</font></th>
				<td><font color="#8D0000" size=1><%= fHora.format(data) %></font></td>
			</tr>
			<tr>
				<th align="right"><font color="#8D0000" size=1>Usu�rio:</font></th>
				<td><font color="#8D0000" size=1><%= user.getNome() %></font></td>
			</tr>
			<% if (tipoEntidade != null) { %>
			<tr>
				<th align="right"><font color="#8D0000" size=0><%= tipoEntidade.getTipo() %>:</font></th>
				<td><font color="#8D0000" size=1><%= entidadeNegocio.getChave() %></font></td>
			</tr>
			<% } %>
                </tr>
		</table>

<tr><td colspan=3 style=border-color:white;border-top-style:solid;border-top-width:2;padding-top:5;font-size:11px;></td></tr>
<tr><td colspan=3 style=border-color:gray;border-top-style:solid;border-top-width:1;padding-top:5;font-size:11px;></td></tr>
<tr><td colspan=3 style=border-color:white;border-top-style:solid;border-top-width:2;padding-top:5;font-size:11px;></td></tr>
<tr><td><br><br></td></tr>
<tr><td colspan=3 style=border-color:white;border-top-style:solid;border-top-width:2;padding-top:5;font-size:11px;></td></tr>
<tr><td colspan=3 style=border-color:gray;border-top-style:solid;border-top-width:1;padding-top:5;font-size:11px;></td></tr>
<tr><td colspan=3 style=border-color:white;border-top-style:solid;border-top-width:2;padding-top:5;font-size:11px;></td></tr>
</table>
<script LANGUAGE="javascript" src="../script/coolmenus4.js"></script>

<script>
      var vleft = 185
      oCMenu=new makeCM("oCMenu") 
      oCMenu.frames = 0
      //Menu properties   
      oCMenu.pxBetween=2	
      if (screen.width==800) 
         vleft=72;
      else
         vleft=185;
      
      //oCMenu.fromLeft=185
      
      oCMenu.fromLeft=vleft
      oCMenu.fromTop=90   
      oCMenu.fromRight=150
      oCMenu.align="bottom"
      oCMenu.rows=1 
      oCMenu.menuPlacement="right"
                                                                   
      oCMenu.offlineRoot="/" 
      oCMenu.onlineRoot="" 
      oCMenu.resizeCheck=1 
      oCMenu.wait=1000 
      oCMenu.fillImg="cm_fill.gif"
      oCMenu.zIndex=0
      
      oCMenu.openOnClick=1
      oCMenu.closeOnClick=1
      
      //Background bar properties
      oCMenu.useBar=0
      oCMenu.barWidth="100%"
      oCMenu.barHeight="menu" 
      oCMenu.barClass="clBar"
      oCMenu.barX=1 
      oCMenu.barY=1
      oCMenu.barBorderX=1
      oCMenu.barBorderY=1
      oCMenu.barBorderClass=""
      
      //Level properties - ALL properties have to be spesified in level 0
      oCMenu.level[0]=new cm_makeLevel() //Add this for each new level
      oCMenu.level[0].width=110
      oCMenu.level[0].height=20 
      oCMenu.level[0].regClass="clLevel0"
      oCMenu.level[0].overClass="clLevel0over"
      oCMenu.level[0].borderX=1
      oCMenu.level[0].borderY=1
      oCMenu.level[0].borderClass="clLevel0border"
      oCMenu.level[0].offsetX=0
      oCMenu.level[0].offsetY=1
      oCMenu.level[0].rows=0
      oCMenu.level[0].arrow=0
      oCMenu.level[0].arrowWidth=0
      oCMenu.level[0].arrowHeight=0
      oCMenu.level[0].align="bottom"

    //Netscape 4 and Opera form work-around !! !! !! !! !!
    if(bw.ns4 || bw.op5 || bw.op6)
    {
      oCMenu.onshow="document.layers?document.layers.formLayer.visibility='hidden':document.getElementById('formDiv').style.visibility='hidden';"
      oCMenu.onhide="document.layers?document.layers.formLayer.visibility='visible':document.getElementById('formDiv').style.visibility='visible';"
    }
                
  <%
     String menu="";
     acesso.Usuario u2 = new acesso.Usuario();
     u2 = (acesso.Usuario)session.getAttribute("User");
     acesso.EntidadeNegocio ent2 = new acesso.EntidadeNegocio();
     acesso.TipoEntidadeNegocio tipoent2 = new acesso.TipoEntidadeNegocio();

  int counterbl_report_Jw_favoritos=0;
  {
    portalbr.dbobj.view.Jw_favoritos t_jw_favoritos = new portalbr.dbobj.view.Jw_favoritos();
    java.util.Vector res_Jw_favoritos = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      String[][] select =  null;
      Object[][] where = {{"Acdi_usua_id","=",u2.getId()+""}};
      String[] order = {"itme_texto"};
      res_Jw_favoritos = j.select(t_jw_favoritos,select,where,null,null,order);
    } finally {
    if(j!=null){j.close();}
  } 
  if (res_Jw_favoritos!=null && res_Jw_favoritos.size()>0) {
    %> 
    oCMenu.makeMenu('m1','',' <img src="../img/list_favoritos.gif" height="16">Favoritos','','',100)
    <%
    java.lang.String menu_nome =  null;
    java.lang.String acdi_usua_id =  null;
    java.lang.String itme_texto =  null;
    java.lang.String link =  null;
    int tamanho = 0;
    int i_bl_report_Jw_favoritos = 0;
    for(int tam=0; tam<res_Jw_favoritos.size(); tam++){
         t_jw_favoritos = (portalbr.dbobj.view.Jw_favoritos)res_Jw_favoritos.elementAt(tam);    
         itme_texto = t_jw_favoritos.getItme_texto()==null?"":t_jw_favoritos.getItme_texto();
         if(tamanho< itme_texto.length()){
            tamanho = itme_texto.length();
         }
    }
    tamanho -= 10;
    tamanho *=10;
    if(tamanho<280){
         tamanho=280;
    }
    for(int x=0; x<res_Jw_favoritos.size(); x++){
         t_jw_favoritos = (portalbr.dbobj.view.Jw_favoritos)res_Jw_favoritos.elementAt(x);
         menu_nome    = t_jw_favoritos.getMenu_nome()==null?"":t_jw_favoritos.getMenu_nome();
         acdi_usua_id = t_jw_favoritos.getAcdi_usua_id()==null?"":t_jw_favoritos.getAcdi_usua_id();
         itme_texto   = t_jw_favoritos.getItme_texto()==null?"":t_jw_favoritos.getItme_texto();
         link         = t_jw_favoritos.getLink()==null?"":t_jw_favoritos.getLink();
         menu         = "'x"+x+"','m1','"+itme_texto+"','"+link+"','','"+tamanho+"'";
         %>
         oCMenu.makeMenu(<%= menu %>)
         <%
    }
    
    }
    }
%>
oCMenu.makeMenu('m2','',' <img src="../img/menu.jpg" height="16"> Menu','../system/MainMenu.do?refresh_action=','',100)
oCMenu.makeMenu('m3','',' <img src="../img/ajuda.gif" height="16"> Ajuda','javascript:ajuda()','',100)
oCMenu.makeMenu('m4','',' <img src="../img/logout.jpg" height="16"> Sair','../system/MainMenu.do?logout_action=','',100)
oCMenu.construct()
</script>
<script>
<!-- 
function ajuda()
{
  wleft = (screen.width - 932) / 2;
  wtop = (screen.height - 496) / 2;
  var win = window.open('../doc<%= request.getServletPath() %>','_blank','width=932, height=496,left='+wleft+',top='+wtop+',location=no, menubar=no,status=no, toolbar=no, scrollbars=no, resizable=no');
  win.resizeTo(900, 496);
  win.moveTo(wleft, wtop);
  win.focus();
}
// -->
</script>