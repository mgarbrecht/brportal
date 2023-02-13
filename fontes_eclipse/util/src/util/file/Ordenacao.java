package util.file;

import java.io.*;
import java.util.*;

public class Ordenacao extends File {

	private static final long serialVersionUID = 1L;

	public Ordenacao(String f) {
		super(f);
	}

	public File[] listFiles() {
		File[] fs = super.listFiles();
		Comparator<File> descendingOnModificationDate = new Comparator<File>() {
			public int compare(File f1, File f2) {
				long diff = f1.lastModified() - f2.lastModified();
				int returnValue;
				if (diff < 0L) {
					returnValue = -1;
				} else if (diff > 0L) {
					returnValue = +1;
				} else {
					assert diff == 0L;
					returnValue = 0;
				}
				return -returnValue;
			}
		};

		Arrays.sort(fs, descendingOnModificationDate);
		return fs;
	}
}
