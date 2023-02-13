package util.consultas;

import java.io.Reader;
import java.sql.*;

public class Comunicacao {

	public String retornaDescricao(Clob clob) throws Exception {
		int t = 0;
		char cbuf[] = new char[1024];
		Reader cin = clob.getCharacterStream();
		StringBuffer cout = new StringBuffer(1024);
		while ((t = cin.read(cbuf)) != -1) {
			cout.append(cbuf, 0, t);
		}
		cin.close();
		return cout.toString();
	}

	public static String retornaDescricaoReport(Clob clob) throws Exception {
		int t = 0;
		char cbuf[] = new char[1024];
		Reader cin = clob.getCharacterStream();
		StringBuffer cout = new StringBuffer(1024);
		while ((t = cin.read(cbuf)) != -1) {
			cout.append(cbuf, 0, t);
		}
		cin.close();
		return cout.toString();
	}
}
