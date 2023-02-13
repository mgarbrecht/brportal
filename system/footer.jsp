<% 
  String titulo = null;
  String mensagem = null;
  String foco = null;
  if(session.getAttribute("foco")!=null){
	foco = (String)session.getAttribute("foco");
  }
  if(session.getAttribute("mensagem")!=null){
     mensagem = (String)session.getAttribute("mensagem");
	 titulo = (String)session.getAttribute("titulo");
%>


<LINK rel=stylesheet type=text/css href="../css/dlg.css">
<SCRIPT type=text/javascript src="../script/jquery-1.4.2.min.js"></SCRIPT>
<SCRIPT type=text/javascript src="../script/jquery.dlg.min.js"></SCRIPT>
<SCRIPT type=text/javascript src="../script/jquery.easing.js"></SCRIPT>
<SCRIPT type=text/javascript src="../script/jquery.ui.all.js"></SCRIPT>

<SCRIPT language=javascript>

$(document).ready(function(){
  
  $(function(){
      $.dlg({
        content: '<%= mensagem %>',
        title: '<%= titulo %>',
        drag: true,
		speedIn : 1,
		speedOut : 1,
		onComplete: function(response){
		<% if(session.getAttribute("foco")!=null){ %>
			$('#<%= foco %>').focus();
	    <% } %>
        }
      });
   });
  
 /* $('.confirm').dlg({
        type: 'confirm',
        content: 'Confirm test :D',
        title: 'Confirm',
        drag: true,
        onComplete: function(response)
        {
            alert(response)
        }
    });
    
    $('.prompt').dlg({
        type: 'prompt',
        content: 'Tell me your name:',
        title: 'Prompt test :D',
        drag: true,
        onComplete: function(response)
        {
            alert('hello ' + response);
        }
    });  
  */
  
});
</script>
<% 
  session.removeAttribute("mensagem");
  session.removeAttribute("titulo");
  session.removeAttribute("foco");
  }
%>
