<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"> 
	<title>jQuery UI Tabs - Simple manipulation</title> 
	<link type="text/css" href="../css/jquery-ui-1.7.1.custom.css" rel="stylesheet" /> 
	<script type="text/javascript" src="../script/jquery.js"></script> 
	<script type="text/javascript" src="../script/jquery.cookie.js"></script> 
	<script type="text/javascript" src="../script/jquery-ui-1.7.1.custom.min.js"></script> 
	<link type="text/css" href="../css/demos.css" rel="stylesheet" />

<head> 
<title>Untitled</title> 
<style type="text/css"> 

html, body { 
	height: 100%; 
	margin: 0; 
	overflow: hidden; 
	padding: 0; 
	width: 100%; 
	background: white; 
}


#header { 
	background: #DFE8F6; 
	height: 30px; 
	position: absolute; 
	top:0; 
	width:100%; 
}

#topnav { 
	background: #D0DDF1; 
	border: solid 1px; 
	border-color: #8DB2E3;
	height: 20px; 
	position: absolute; 
	top: 30px; 
	width: 100%; 
}

#main { 
	bottom: 0px; 
	left: 0; 
	position: absolute; 
	right: 0; 
	top: 50px; 
}

#sidenav { 
	background: lightgray;
	background: url(header-background.png) repeat-x;
	border: solid 1px; 
	border-color: #8DB2E3;
	height: 100%; 
	float: left; 
	/*width: auto;*/
	overflow: auto; 
	margin-top: 1px; 
}

#sidenav2 { 
	background: #D0DDF1; 
	border: solid 1px; 
	border-color: #8DB2E3;
	height: 100%; 
	float: left; 
	width: 15px; 
	overflow: auto; 
	margin-top: 1px; 
	margin-left: -1px;
}

#content { 
	height: 100%; 
	overflow: auto;
	margin-top: 1px;
	border: solid 1px; 
	border-color: #8DB2E3;
}

#footer { 
	background: blue;
	height: 20px; 
	margin-top: -20px; 
	position: absolute; 
	top: 100%; 
	width: 100%; 
} 
</style> 


<!--[if lt IE 7]> 
<style type="text/css"> 
html { 
padding: 50px 0 20px; 
}

#main { 
bottom: auto; 
left: auto; 
right: auto; 
top: auto; 
height: 100%; 
position: static; 
} 
</style> 
<![endif]--> 
</head> 
<body> 

 
    
	
 
</div><!-- End demo --> 

<div id="header">header</div> 
<div id="topnav">



 
</div> 

<div id="main">  
<div id="sidenav">
<button id="add_tab" onclick="$('#tabs').tabs('add', '#tabs-2', 'Consulta de Pedidos');">Add Tab</button> 
<a href="#" onclick="$('#tabs').tabs('add',{title:title,content:content,closable:true});">s</a>




<%@ page import="acesso.*, java.sql.*, util.rdb.ConnectionJDBC" %>
<%@ page extends="acesso.web.HttpJspSessao"%>
<%@ page errorPage="/err/errorpage.jsp"%>
<%
    Connection conn = null;
    try {
		conn = ConnectionJDBC.get("orasco", "wbrio", "wbrio");
%>
		<jsp:useBean id="treeMenuUsuario" scope="request" class="acesso.web.TreeMenuUsuarioBeanNovo">
			<jsp:setProperty name="treeMenuUsuario" property="connection" value="<%= conn %>" />
			<jsp:setProperty name="treeMenuUsuario" property="contextPath" value="<%= request.getContextPath() %>" />
			<jsp:setProperty name="treeMenuUsuario" property="usuario" value="<%= (Usuario) session.getAttribute("User") %>" />
		</jsp:useBean>
		<%= treeMenuUsuario %> 
		<%
        if((((String)session.getAttribute("abre_menu"))+"").equals("s")){
		%>
		   <script>d.openAll();</script>
		<%
		session.removeAttribute("abre_menu");
		}
		%>
		            
<%
   } finally {
		if(conn!=null){
			conn.close();
			conn = null;
		}
   }
%>




</div> 

<div id="sidenav2"><img src="seta_esquerda.png" onclick="if(this.src='seta_esquerda.png'){this.src='seta_direita.png'}else{this.src='seta_esquerda.png'};jQuery('#sidenav').toggle('fast');";></div>
<div id="content">
<div id="tabs">
	<ul>
		<li><a href="#tabs-1">Preloaded</a></li>
		<li><a href="../acesso/TesteFiltroForm.jsp">Filtro</a></li>
	</ul>
	<div id="tabs-1">
		<p>Proin elit arcu, rutrum commodo, vehicula tempus, commodo a, risus. Curabitur nec arcu. Donec sollicitudin mi sit amet mauris. Nam elementum quam ullamcorper ante. Etiam aliquet massa et lorem. Mauris dapibus lacus auctor risus. Aenean tempor ullamcorper leo. Vivamus sed magna quis ligula eleifend adipiscing. Duis orci. Aliquam sodales tortor vitae ipsum. Aliquam nulla. Duis aliquam molestie erat. Ut et mauris vel pede varius sollicitudin. Sed ut dolor nec orci tincidunt interdum. Phasellus ipsum. Nunc tristique tempus lectus.</p>
	</div>
</div>

</div> 

</body> 
</html>


<script type="text/javascript"> 
	$(function() {
		var $tab_title_input = $('#tab_title'), $tab_content_input = $('#tab_content');
		var tab_counter = 2;
 
		var $tabs = $('#tabs').tabs({ cache: true, 
			tabTemplate: '<li><a href="#{href}">#{label}</a> <span class="ui-icon ui-icon-close">Remove Tab</span></li>',
			add: function(event, ui) {
				var tab_content = $tab_content_input.val() || 'Tab '+tab_counter+' content.';
				$(ui.panel).append('<p>'+tab_content+'</p>');
				tab_counter = tab_counter + 1;
				$('#tabs').tabs( 'selected' , -1 )
                //$(".ui-tabs-selected").removeClass("ui-state-active").removeClass("ui-tabs-selected");
				$(".ui-tabs-selected").removeClass("ui-tabs-selected");
				$("#tabs").tabs("select", "'"+tab_counter+"'");
			}
			
		});
 
		$('#tabs span.ui-icon-close').live('click', function() {
			var index = $('li',$tabs).index($(this).parent());
			$tabs.tabs('remove', index);
			
		});
	});
	
	//$("#tabs").tabs().find(".ui-tabs-nav").sortable({axis:'x'});
	</script> 
