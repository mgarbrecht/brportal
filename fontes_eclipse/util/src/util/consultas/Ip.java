package util.consultas;

import java.util.*;  
import java.io.*;  
import java.net.*;  
   
public class Ip {  
  
	public static String retorna(String ip){
		StringBuilder sb = new StringBuilder();
    try {  
      Properties systemSettings = System.getProperties();  
      systemSettings.put("http.proxyHost","10.0.0.115") ;  
      systemSettings.put("http.proxyPort", "8080") ;  
      URL ur = new URL("http://iplocationtools.com/ip_query.php?ip="+ip);
      HttpURLConnection con = (HttpURLConnection) ur.openConnection();
      String encodedUserPwd = null;  
      con.setRequestProperty("Proxy-Authorization", "Basic " + encodedUserPwd);  
      BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));  
      String inputLine;
      while ( (inputLine = in.readLine()) != null)  {
    	  sb.append("<div align=\"center\">");
    	  if(inputLine.indexOf("Ip")!=-1){
    		  sb.append (inputLine.replaceAll("<Ip>","<big><b>IP:</b> ").replaceAll("</Ip>","<br>").trim());
    	  } else if(inputLine.indexOf("Status")!=-1){
    		  sb.append (inputLine.replaceAll("<Status>","<b>Status:</b> ").replaceAll("</Status>","<br>").trim());  
    	  } else if(inputLine.indexOf("<CountryCode>")!=-1){
    		  sb.append (inputLine.replaceAll("<CountryCode>","<b>Código País:</b> ").replaceAll("</CountryCode>","<br>").trim());  
    	  } else if(inputLine.indexOf("<CountryName>")!=-1){
    		  sb.append (inputLine.replaceAll("<CountryName>","<b>País:</b> ").replaceAll("</CountryName>","<br>").trim());    	  
    	  } else if(inputLine.indexOf("<RegionCode>")!=-1){
    		  sb.append (inputLine.replaceAll("<RegionCode>","<b>Código Região:</b> ").replaceAll("</RegionCode>","<br>").trim());
    	  } else if(inputLine.indexOf("<RegionName>")!=-1){
    		  sb.append (inputLine.replaceAll("<RegionName>","<b>Região:</b> ").replaceAll("</RegionName>","<br>").trim());
    	  } else if(inputLine.indexOf("<City>")!=-1){
    		  sb.append (inputLine.replaceAll("<City>","<b>Cidade:</b> ").replaceAll("</City>","<br>").trim());
    	  } else if(inputLine.indexOf("<Latitude>")!=-1){
    		  sb.append (inputLine.replaceAll("<Latitude>","<b>Latitude:</b> ").replaceAll("</Latitude>","<br>").trim());
    	  } else if(inputLine.indexOf("<Longitude>")!=-1){
    		  sb.append (inputLine.replaceAll("<Longitude>","<b>Longitude:</b> ").replaceAll("</Longitude>","</big><br>").trim());
    	  }
      }
   	  in.close();
      sb.append("</div>");
    }  
    catch (MalformedURLException me) {  
      me.printStackTrace();  
    }  
    catch (IOException ioe) {  
      ioe.printStackTrace();  
    }  
    return(sb.toString());
  }  
}  