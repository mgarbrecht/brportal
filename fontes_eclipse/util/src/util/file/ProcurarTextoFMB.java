package util.file;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

public class ProcurarTextoFMB {

	protected int minLength = 4;

	protected boolean isStringChar(char ch) {
		if (ch >= 'a' && ch <= 'z')
			return true;
		if (ch >= 'A' && ch <= 'Z')
			return true;
		if (ch >= '0' && ch <= '9')
			return true;
		switch (ch) {
		case '/':
		case '-':
		case ':':
		case '.':
		case ',':
		case '_':
		case '$':
		case '%':
		case '\'':
		case '(':
		case ')':
		case '[':
		case ']':
		case '<':
		case '>':
			return true;
		}
		return false;
	}

	/** Process one file */
	protected boolean process(String fileName, InputStream inStream,
			String objeto) {
		boolean achou = false;
		try {
			int i;
			char ch;
			BufferedInputStream is = new BufferedInputStream(inStream);
			StringBuffer sb = new StringBuffer();
			while ((i = is.read()) != -1) {
				ch = (char) i;
				if (isStringChar(ch) || (sb.length() > 0 && ch == ' '))
					sb.append(ch);
				else {
					if (sb.length() == 0)
						continue;
					if (sb.length() >= minLength) {
						if (sb.indexOf(objeto) != -1) {
							achou = true;
						}
					}
					sb.setLength(0);
				}
			}
			is.close();
		} catch (IOException e) {
			System.out.println("IOException: " + e);
		}
		return achou;
	}

	public static void main(String args[]) {

	
		ProcurarTextoFMB o = new ProcurarTextoFMB();
		o.processar();
		
		
		// try {
		// o.process("c:/sbr436.rdf", new FileInputStream("c:/sbr436.rdf"));
		// } catch (FileNotFoundException e) {
		// System.err.println(e);
		// }
	}

	protected void report(String fName, StringBuffer theString) {
		System.out.println(fName + ": " + theString);
	}

	private Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@10.0.0.31:1521:orabrio", "wbrio",
					"wbrio");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	private void processar() {
		FileWriter arq = null;
		try {
			arq = new FileWriter("c:/encontrados.txt");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		PrintWriter gravarArq = new PrintWriter(arq); 
		java.sql.Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT object_name ");
			sb.append("   FROM all_objects o ");
			sb.append("  WHERE object_type IN ('PACKAGE', 'PACKAGE BODY', 'FUNCTION', 'PROCEDURE', 'SYNONYM') ");
			sb.append("    AND owner IN ('WBRIO') ");
			sb.append("    AND NOT EXISTS (SELECT NULL ");
			sb.append("                      FROM all_dependencies r ");
			sb.append("                     WHERE r.referenced_owner = o.owner ");
			sb.append("                       AND r.referenced_name = o.object_name) ");

			conn = getConnection();
			pstm = conn.prepareStatement(sb.toString());
			rset = pstm.executeQuery();
			while (rset.next()) {
				String objeto = rset.getString("object_name");
				System.out.println("Procurando objeto: " + objeto);
				processarDiretorios(objeto, gravarArq);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			try {
				if (!conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		try {
			arq.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private void processarDiretorios(String objeto, PrintWriter gravarArq) {
		boolean achou = false;
		List<String> listaDiretorios = new ArrayList<String>();
		listaDiretorios.add("c:/fontes/adm/");
		listaDiretorios.add("c:/fontes/ind/");
		listaDiretorios.add("c:/fontes/com/");
		for (String diretorio : listaDiretorios) {
			try {
				File f = new File(diretorio);
				if (f.isDirectory()) {
					File[] lista = f.listFiles();
					for (int x = 0; x < lista.length; x++) {
						String ext = lista[x].getName().substring(lista[x].getName().indexOf(".") + 1,lista[x].getName().length()).toLowerCase();
						if (ext.equalsIgnoreCase("RDF") || ext.equalsIgnoreCase("FMB")) {
							if (process(lista[x].getPath(),new FileInputStream(lista[x].getPath()),objeto)) {
								if(!achou){
									gravarArq.printf("Procurando objeto: " + objeto);
									gravarArq.write("\n");
								}
								gravarArq.printf("-> Encontrado no arquivo: "+ lista[x].getName());
								gravarArq.write("\n");
								achou = true;
							}
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
