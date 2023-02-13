package util.cripto;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Criptografia {

    private final String CHAVE_INICIO = "{. §;'#~CH[]Ve {d E}. Q u3Br@! G*R8rEch+; '.#= ,1!{_1-a. B -$_}';§. }";
    private final String CHAVE_FIM = "%#  <1O a!A w! ] ,X.xZ@ [  3 L1 e ss S . 1, !} = . 5 W A z. 0oO ..;";

    public boolean validaSenha(String se, String senhaSalva) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String[] parts = senhaSalva.split(":");
        int iteracoes = Integer.parseInt(parts[0]);
        byte[] salt = deHex(parts[1]);
        byte[] hash = deHex(parts[2]);
        PBEKeySpec spec = new PBEKeySpec((this.CHAVE_INICIO.concat(se).concat(this.CHAVE_FIM)).toCharArray(), salt, iteracoes, hash.length * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] testHash = skf.generateSecret(spec).getEncoded();
        int diff = hash.length ^ testHash.length;
        for (int i = 0; i < hash.length && i < testHash.length; i++) {
            diff |= hash[i] ^ testHash[i];
        }
        return diff == 0;
    }

    public String gerarHashForte(String se) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String senha = this.CHAVE_INICIO.concat(se).concat(this.CHAVE_FIM);
        int iteracoes = 1000;
        char[] chars = senha.toCharArray();
        byte[] salt = getSalt().getBytes();

        PBEKeySpec spec = new PBEKeySpec(chars, salt, iteracoes, 64 * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = skf.generateSecret(spec).getEncoded();
        return iteracoes + ":" + toHex(salt) + ":" + toHex(hash);
    }
    
    private String getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt.toString();
    }

    private String toHex(byte[] array) throws NoSuchAlgorithmException {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        if (paddingLength > 0) {
            return String.format("%0" + paddingLength + "d", 0) + hex;
        } else {
            return hex;
        }
    }

    private byte[] deHex(String hex) throws NoSuchAlgorithmException {
        byte[] bytes = new byte[hex.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
        return bytes;
    }
}
