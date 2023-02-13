package util.rand;
import java.util.UUID;

public class Palavra {
    

	public static String geraPalavra(){
	    return UUID.randomUUID().toString().replace("-", "");
	}
	
	public static String geraNovaSenha(){
	    return UUID.randomUUID().toString().replace("-", "");
	}	
	
}
