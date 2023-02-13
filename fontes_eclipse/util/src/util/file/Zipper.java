package util.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import util.rand.Palavra;

public class Zipper {

	public void addDirectory(ZipOutputStream zout, File fileSource) {
		File[] files = fileSource.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory()) {
				addDirectory(zout, files[i]);
				continue;
			}
			try {
				byte[] buffer = new byte[1024];
				FileInputStream fin = new FileInputStream(files[i]);
				zout.putNextEntry(new ZipEntry(files[i].getName()));
				int length;
				while ((length = fin.read(buffer)) > 0) {
					zout.write(buffer, 0, length);
				}
				zout.closeEntry();
				fin.close();
			} catch (IOException ioe) {
				ioe.printStackTrace(System.out);
			}
		}
	}

	public void compactarArquivos(ZipOutputStream zout, List<File> listaArquivos) {
		for (File file : listaArquivos) {
			try {
				byte[] buffer = new byte[1024];
				FileInputStream fin = new FileInputStream(file);
				zout.putNextEntry(new ZipEntry(file.getName()));
				int length;
				while ((length = fin.read(buffer)) > 0) {
					zout.write(buffer, 0, length);
				}
				zout.closeEntry();
				fin.close();
			} catch (IOException ioe) {
				ioe.printStackTrace(System.out);
			}
		}
	}

	public String compactarArquivo(File arquivo, String diretorioGeracao) {
		String arquivoGerado = null;
		try {
			String arq = Palavra.geraPalavra() + ".zip";
			FileOutputStream fout = new FileOutputStream(diretorioGeracao + java.io.File.separator + arq );
			ZipOutputStream zout = new ZipOutputStream(fout);
			byte[] buffer = new byte[1024];
			FileInputStream fin = new FileInputStream(arquivo);
			zout.putNextEntry(new ZipEntry(arquivo.getName()));
			int length;
			while ((length = fin.read(buffer)) > 0) {
				zout.write(buffer, 0, length);
			}
			zout.closeEntry();
			fin.close();
			zout.close();
			arquivoGerado = arq;
		} catch (IOException ioe) {
			ioe.printStackTrace(System.out);
		}
		return arquivoGerado;
	}
	
	 public void zip(List<File> fonte, String saida) {
	        String zipFile;
	        try {
	            zipFile = saida;
	            FileOutputStream fout = new FileOutputStream(zipFile);
	            ZipOutputStream zout = new ZipOutputStream(fout);
	            for (File f : fonte) {
	                try {
	                    byte[] buffer = new byte[1024];
	                    FileInputStream fin = new FileInputStream(f);
	                    zout.putNextEntry(new ZipEntry(f.getName()));
	                    int length;
	                    while ((length = fin.read(buffer)) > 0) {
	                        zout.write(buffer, 0, length);
	                    }
	                    zout.closeEntry();
	                    fin.close();
	                } catch (IOException ioe) {
	                    ioe.printStackTrace(System.err);
	                }
	            }
	            zout.close();
	        } catch (Exception e) {
	            e.printStackTrace(System.err);
	        }
	    }
}
