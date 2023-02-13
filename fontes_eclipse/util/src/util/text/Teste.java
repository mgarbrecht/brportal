package util.text;

public class Teste {

	public static void main(String[] args) {

String pedidosEntrada = "   ";
		  if(pedidosEntrada!=""){
			  System.out.println("passo1");
		     String pedidos = pedidosEntrada.replaceAll("[^0-9]", " ").trim();
		     System.out.println("passo2");
		     pedidos = pedidos.replaceAll("\\s+", " ");
		     System.out.println("passo3");
		     pedidos = pedidos.replaceAll(" ", "\n");
		     System.out.println("passo4");
		     pedidos = pedidos.replaceAll("\\r\\n|\\r|\\n", ",");
		     System.out.println("passo5");
		     
		     if(pedidos.length()>0 &&( pedidos.charAt(pedidos.length()-1)+"").equalsIgnoreCase(",")){
		    	 
		        pedidos = pedidos.substring(0, pedidos.lastIndexOf(","));
		        
		     }
		     System.out.println("passo8");
		     System.out.println(pedidos);
		  }
		
	}

}
