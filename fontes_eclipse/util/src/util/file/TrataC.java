package util.file;

import java.io.File;

public class TrataC {

	public static void main(String args[]) {
		TrataC trata = new TrataC();
		trata.renomeia("//srvfs/fotos/PROD/");
		trata.renomeia("i:/imagens/");
	}
  
	public void renomeia(String arquivo) {
		try {
			File f = new File(arquivo);
			if (f.isDirectory()) {
				File[] lista = f.listFiles();
				for (int x = 0; x < lista.length; x++) {
					if (lista[x].getAbsolutePath().indexOf("ç") != -1) {
						File novo = new File((lista[x].getAbsolutePath().replaceAll("ç", "c")));
						lista[x].renameTo(novo);
					} 
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}

}
