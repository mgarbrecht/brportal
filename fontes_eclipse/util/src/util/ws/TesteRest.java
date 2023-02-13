package util.ws;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class TesteRest {
	
	public static void main (String args[]){
		try {
    		URL url = new URL("https://api.instagram.com/v1/users/907405921/media/recent/?access_token=907405921.d404594.393e06d33106484aa00a1e8010bba7f2");
    		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    		connection.setRequestMethod("GET");
    		connection.connect();
    		InputStream responseBodyStream = connection.getInputStream();
    	    //FileOutputStream os = new FileOutputStream("/opt/tomcat/webapps/brportal/temp/"+arquivo);
    		java.io.InputStream is = connection.getInputStream();
            java.io.BufferedReader rd = new java.io.BufferedReader(new java.io.InputStreamReader(is));
            String line;
            while ((line = rd.readLine()) != null) {
            	System.out.println(line);
            }
    		connection.disconnect();
    		responseBodyStream.close();
		} catch (Exception e){
			e.printStackTrace();
		}finally {
		}
	}
}
