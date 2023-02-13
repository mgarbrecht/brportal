package util.file;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CopiaDiretorios {

	public static void main (String args[]){
		SimpleDateFormat fData = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		File f = new File("I:/interno/fontes/adm/Cobranca_Novo/forms/customizados/CBR3003.fmx");
		File f2 = new File("I:/interno/fontes/adm/Cobranca_Novo/forms/customizados/CBR3003.fmb");
		System.out.println(fData.format(new Date(f.lastModified())));
		System.out.println(fData.format(new Date(f2.lastModified())));
	}
}
