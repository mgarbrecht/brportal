package acesso.web;
import javax.servlet.http.*;
import java.io.File;
import java.sql.SQLException;

public class SessionListener implements HttpSessionListener, java.io.Serializable {

	private static final long serialVersionUID = 1L;

	public void sessionCreated(HttpSessionEvent se) {
	}
   
	public void sessionDestroyed(HttpSessionEvent se) {
		try {
			util.consultas.Parametros parametros = new util.consultas.Parametros();
			File dirObject = new File(parametros.retornaParametro("diretorio_pdf"));
			if (dirObject.exists()) {
				File[] dirList = dirObject.listFiles();
				for (int x = 0; x < dirList.length; x++) {
					if (dirList[x].isFile() && (!(dirList[x].getName().equals("index.html")))) {
						//if (!(dirList[x].getName().contains(".csv"))) {
							if ((new java.util.Date().getTime() - dirList[x].lastModified()) > 5000000) {
								dirList[x].delete();
							}
						//}
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.runFinalization();
      		System.gc();
		}
	}
} 










