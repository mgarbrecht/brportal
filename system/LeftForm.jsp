<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"    "http://www.w3.org/TR/html4/loose.dtd">
<%
if(true){
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JSP Page</title>
	<link rel="stylesheet" type="text/css" href="/brportal/css/theme/ponto/global.css" />
	<link rel="stylesheet" type="text/css" href="/brportal/css/theme/ponto/basic.css" />
	<link rel="stylesheet" type="text/css" href="/brportal/css/theme/ponto/accordion.css" />
	<link rel="stylesheet" type="text/css" href="/brportal/css/theme/ponto/treeview.css" />
	<link rel="stylesheet" type="text/css" href="/brportal/css/theme/ponto/tabs.css" />
	<link rel="stylesheet" type="text/css" href="/brportal/css/theme/ponto/toolbar.css" />
	<link rel="stylesheet" type="text/css" href="/brportal/css/theme/ponto/form.css" />
	<link rel="stylesheet" type="text/css" href="/brportal/css/theme/ponto/messages.css" />
	<link rel="stylesheet" type="text/css" href="/brportal/css/theme/ponto/grid.css" />

	<script src="/brportal/js/jquery.js" type="text/javascript"></script>
	<script src="/brportal/js/jquery.dimensions.js" type="text/javascript"></script>
	<script src="/brportal/js/jquery.accordion.js" type="text/javascript"></script>
	<script src="/brportal/js/jquery.treeview.js" type="text/javascript"></script>
	<script src="/brportal/js/jquery.cookie.js" type="text/javascript"></script>
	<script src="/brportal/js/jquery.groups.js" type="text/javascript"></script>
	
	<script type="text/javascript">
	    $(document).ready(function() {
		$("#menu").accordion({
		    header: 'a.head',
		    navigation: true,
		    fillSpace: true
		});
		
		$("ul.treeview").treeview({
		    animated: "fast",
		    persist: "cookie",
		    collapsed: true
		});
	    });
			
	    function accordionClose(o,e){
		$("div.menu").slideToggle("normal", function () {
		    $(this.parentNode.parentNode).toggleClass("column-close");
		});
	    }
   
	</script>
    </head>
    <body>
			
	<div class="columns">
	<div class="column column-navigation">
	<div class="menu">
	    <ul id="menu" class="accordion">
		<li>
		    <a class="head">Principal</a>
		    <div class="body">

			<ul class="treeview">
			  <%= acesso.web.GeraMenu.gera(request) %>
			</ul>

		    </div>
		</li>
		<li>
		    <a class="head">Favoritos</a>
		    <div class="body">
			Menu 02
		    </div>
		</li>
		<li>
		    <a class="head">Recentes</a>
		    <div class="body">
			Menu 02
		    </div>
		</li>
	    </ul>
	</div>
    </div>
	</div>
</body>
</html>
<% } %>







            