package util.file;

import java.io.File;
import java.util.Vector;

public class BuscaFMB_RDF {
	int qtdFmx = 0;
	int qtdRep = 0;
	Vector<String> telas = null;
	Vector<String> relatorios = null;

	public static void main(String args[]) {

		BuscaFMB_RDF t = new BuscaFMB_RDF();
		t.telas = new Vector<String>();
		t.relatorios = new Vector<String>();
		t.select("I:/interno/fontes/");
		System.out.println("Quantidade de FMB´s...: " + t.telas.size());
		System.out.println("Quantidade de RDF´s...: " + t.relatorios.size());
		System.out.println("Total.................: " + (t.telas.size() + t.relatorios.size())); ;
	}

	public void select(String arquivo) {
		try {
			File f = new File(arquivo);
			if (f.isDirectory()) {
				File[] lista = f.listFiles();
				for (int x = 0; x < lista.length; x++) {
					if (lista[x].isDirectory()) {
						select(lista[x].toString());
						if (lista[x].getName().toLowerCase().indexOf(".fmb") != -1) {
							if (validaNome(lista[x].getName())) {
								if (!this.telas.contains(lista[x].getName())) {
									this.telas.add(lista[x].getName());
									//System.out.println(lista[x].getName());
								}
							}
						}
						if (validaNome(lista[x].getName())) {
							if (lista[x].getName().toLowerCase().indexOf(".rdf") != -1) {
								if (!this.relatorios.contains(lista[x].getName())) {
									this.relatorios.add(lista[x].getName());
									//System.out.println(lista[x].getName());
								}
							}
						}

					} else {
						if (validaNome(lista[x].getName())) {
							if (lista[x].getName().toLowerCase().indexOf(".fmb") != -1) {
								if (!this.telas.contains(lista[x].getName())) {
									this.telas.add(lista[x].getName());
									//System.out.println(lista[x].getName());
								}
							}
						}

						if (validaNome(lista[x].getName())) {
							if (lista[x].getName().toLowerCase().indexOf(".rdf") != -1) {
								if (!this.relatorios.contains(lista[x].getName())) {
									this.relatorios.add(lista[x].getName());
									//System.out.println(lista[x].getName());
								}
							}
						}

					}
				}
			}

			if (validaNome(f.getName())) {
				if (f.getName().toLowerCase().indexOf("fmb") != -1) {
					if (!this.telas.contains(f.getName())) {
						this.telas.add(f.getName());
					}
				}
			}

			if (validaNome(f.getName())) {
				if (f.getName().toLowerCase().indexOf("rdf") != -1) {
					if (!this.relatorios.contains(f.getName())) {
						this.relatorios.add(f.getName());
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}

	public boolean validaNome(String nome) {
		boolean retorno = true;
		if ((nome.toLowerCase().indexOf("old") != -1)
				|| (nome.toLowerCase().indexOf("teste") != -1)
				|| (nome.toLowerCase().indexOf("cópia") != -1)) {
			retorno = false;
		}
		return retorno;
	}
}

