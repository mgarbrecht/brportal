package util.text;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Teste2 {

	public static void main(String args[]) {
		Teste2 t = new Teste2();
		t.delete("c:/ficha_cadastral");
	}

	public void delete(String arquivo) {
		List<String> listaArquivos = new ArrayList<String>();
		listaArquivos.add("849");
		listaArquivos.add("850");
		listaArquivos.add("851");
		listaArquivos.add("852");
		

		try {
			File f = new File(arquivo);
			if (f.isDirectory()) {
				File[] lista = f.listFiles();
				for (int x = 0; x < lista.length; x++) {
					System.out.println(lista[x].getName());
					if (lista[x].isDirectory()) {
						if (listaArquivos.contains(lista[x].getName())) {
							File[] lst = lista[x].listFiles();
							for(File arq : lst){
								arq.delete();
							}
							lista[x].delete();
						}
					} 
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("fim");
		}
	}
}
