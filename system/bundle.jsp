<%
  String arquivo = request.getParameter("arquivo");
  String chave   = request.getParameter("chave");
  {
	    java.util.ResourceBundle bundle = null; 
	    try {
	      bundle = java.util.ResourceBundle.getBundle(arquivo);
	    } catch (Exception ex) {
	    }
	    if ((chave != null) && (chave.length() > 0))
	      if (bundle != null) {
	        java.util.Enumeration<String> keys = bundle.getKeys();
	        while ((keys != null) && 
	          (keys.hasMoreElements())) {
	          String key = (String)keys.nextElement();
	          if (chave.indexOf(key) != -1) {
	            chave = bundle.getString(key);
	            break;
	          }
	        }

	      }
	    else if ((bundle != null) && (bundle.getString("error.unknow") != null) && (bundle.getString("error.unknow").length() > 0))
	      chave = bundle.getString("error.unknow") + "<br></br>";
	    else {
	      chave = "Unknown Error<br></br>";
	    }
	  }	
	  out.println(chave);
%>