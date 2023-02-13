package util.email;


import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmailUtil {

    private String emailRemetente = "ti@beirario.com.br";
    private String emailDestinatario;
    private String remetente = "BR Portal";
    private String assunto;
    private List<String> listaCC;
    private List<String> linhasEmail;
    private StringBuilder email;

    public EmailUtil() {
        listaCC = new ArrayList<String>();
        linhasEmail = new ArrayList<String>();
    }     

    public List<String> getLinhasEmail() {
        return linhasEmail;
    }

    public void setLinhasEmail(List<String> linhasEmail) {
        this.linhasEmail = linhasEmail;
    }

    public StringBuilder getEmail() {
        return email;
    }

    public void setEmail(StringBuilder email) {
        this.email = email;
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getEmailDestinatario() {
        return emailDestinatario;
    }

    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }

    public String getEmailRemetente() {
        return emailRemetente;
    }

    public void setEmailRemetente(String emailRemetente) {
        this.emailRemetente = emailRemetente;
    }

    public List<String> getListaCC() {
        return listaCC;
    }

    public void setListaCC(List<String> listaCC) {
        this.listaCC = listaCC;
    }

    public void enviarEmail() {
        montaEmail();
        try {
			enviaEmail();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    private void montaEmail() {
        email = new StringBuilder();
        email.append("begin ");
        email.append("pck_envio_email.inicializa_conexao; ");
        email.append("pck_envio_email.set_email_remetente('").append(emailRemetente).append("'); ");
        email.append("pck_envio_email.set_email_destinatario('").append(emailDestinatario).append("'); ");
        for (String cc : this.listaCC) {
            email.append("pck_envio_email.add_cc('").append(cc).append("'); ");
        }
        email.append("pck_envio_email.set_cabecalho('").append(remetente).append("', '").append(emailDestinatario).append("', '").append(assunto).append("', NULL, 'HTML'); ");
        for (String linha : this.linhasEmail) {
             email.append("pck_envio_email.add_linha_email('").append(linha).append("'); ");
        }        
        email.append("pck_envio_email.finaliza_conexao; ");
        email.append("end;");
    }

    private void enviaEmail() throws Exception {
        CallableStatement stmt;
		com.egen.util.jdbc.JdbcUtil j = null;
		try {
			j = new com.egen.util.jdbc.JdbcUtil();
            stmt = j.getConn().prepareCall(email.toString());
            stmt.execute();
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
        } finally {
    		if (j != null) {
				j.close();
			}
        }
    }

    public void inicializa() {
        emailRemetente = "ti@beirario.com.br";
        remetente = "BR Portal";
        emailDestinatario = null;
        assunto = null;
        listaCC = new ArrayList<String>();
        linhasEmail = new ArrayList<String>(); 
        email = new StringBuilder();
    }
    
    public void adicionaCC(String cc){
        this.listaCC.add(cc);
    }
    
    public void adicionaLinha(String linha){
        this.linhasEmail.add(linha);
    }    
}

