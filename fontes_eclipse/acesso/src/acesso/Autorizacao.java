package acesso;

/**
 *
 * @author mateus_garbrecht
 */
public class Autorizacao {

	private Integer usuaId;
	private Integer doinId;
	private Integer diasConsultaRetroativa;
	private String negarAcesso;

	public Autorizacao(Integer usuaId, Integer doinId, Integer diasConsultaRetroativa, String negarAcesso) {
		this.usuaId = usuaId;
		this.doinId = doinId;
		this.diasConsultaRetroativa = diasConsultaRetroativa;
		this.negarAcesso = negarAcesso;
	}

	public Integer getUsuaId() {
		return usuaId;
	}

	public void setUsuaId(Integer usuaId) {
		this.usuaId = usuaId;
	}

	public Integer getDoinId() {
		return doinId;
	}

	public void setDoinId(Integer doinId) {
		this.doinId = doinId;
	}

	public Integer getDiasConsultaRetroativa() {
		return diasConsultaRetroativa;
	}

	public void setDiasConsultaRetroativa(Integer diasConsultaRetroativa) {
		this.diasConsultaRetroativa = diasConsultaRetroativa;
	}

	public String getNegarAcesso() {
		return negarAcesso;
	}

	public void setNegarAcesso(String negarAcesso) {
		this.negarAcesso = negarAcesso;
	}
}
