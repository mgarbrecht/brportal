package util.file;

import java.io.File;

public class Deltree {

	public static void delete(String arquivo) {
		try {
			File f = new File(arquivo);
			if (f.isDirectory()) {
				File[] lista = f.listFiles();
				for (int x = 0; x < lista.length; x++) {
					if (lista[x].isDirectory()) {
						delete(lista[x].toString());
						lista[x].delete();
					} else {
						lista[x].delete();
					}
				}
			}
			f.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
