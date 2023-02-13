<%

System.out.println("passo1");
		java.net.URL url;
		java.net.HttpURLConnection connection = null;
		try {
System.out.println("passo2");
			url = new java.net.URL("https://ecommerce.cbmp.com.br/servicos/ecommwsec.jsp");
			connection = (java.net.HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
System.out.println("passo3");
		} catch (Exception e) {
System.out.println("erro");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            if (connection != null) {
                connection.disconnect();
            }
		}

%>