package util.ws.boa_vista;

import java.util.ArrayList;
import java.util.List;

public class ScpcTelefones {

	private Long cnpjCpfBase;
	private int seqConsulta;
	private List<String> listaTelefones;
	
	ScpcTelefones(){
		this.listaTelefones = new ArrayList<String>();
	}

	public Long getCnpjCpfBase() {
		return cnpjCpfBase;
	}

	public void setCnpjCpfBase(Long cnpjCpfBase) {
		this.cnpjCpfBase = cnpjCpfBase;
	}

	public int getSeqConsulta() {
		return seqConsulta;
	}

	public void setSeqConsulta(int seqConsulta) {
		this.seqConsulta = seqConsulta;
	}

	public List<String> getListaTelefones() {
		return listaTelefones;
	}

	public void setListaTelefones(List<String> listaTelefones) {
		this.listaTelefones = listaTelefones;
	}

}
