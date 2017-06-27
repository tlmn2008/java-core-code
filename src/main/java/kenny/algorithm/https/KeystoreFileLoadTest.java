package kenny.algorithm.https;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyStore;

public class KeystoreFileLoadTest {

    private static final String KEY = "jaas is the way";

    // test function
    public static void main(String[] args) {

        String password = "embms1234";
        String passwordEncode = encode(password);
        // test result: passwordEncode = "32f817e700033d974686a773aa4001eb"

        //下面的这个文件在resources文件夹中，密码是embms1234
        KeyStore keyStore = loadKeyStore("src/main/java/kenny/lang/https/up_session.truststore","32f817e700033d974686a773aa4001eb");
    }

    private static KeyStore loadKeyStore(String path, String passwd) {
        KeyStore tmpKeyStore = null;
        FileInputStream keyStoreIn = null;
        try {
            keyStoreIn = new FileInputStream(new File(path));
        } catch (FileNotFoundException e) {
            return null;
        }
        try {
            tmpKeyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            String password = decode(passwd);
            tmpKeyStore.load(keyStoreIn, password.toCharArray());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                keyStoreIn.close();
            } catch (IOException e) {
            }
        }

        return tmpKeyStore;
    }

    // encode
    public static String encode(String password) {

        try {
            byte[] kbytes = KEY.getBytes();
            SecretKeySpec key = new SecretKeySpec(kbytes, "Blowfish");

            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(1, key);
            byte[] encoding = cipher.doFinal(password.getBytes());
            BigInteger n = new BigInteger(encoding);
            return n.toString(16);

        } catch(Exception e) {
            return password;
        }
    }

    // decode
    public static String decode(String password) {

        if (password == null || password.isEmpty()) {
            return "";
        }

        try {
            byte[] kbytes = KEY.getBytes();
            SecretKeySpec key = new SecretKeySpec(kbytes, "Blowfish");

            BigInteger n = new BigInteger(password, 16);
            byte[] encoding = n.toByteArray();

            if (encoding.length % 8 != 0)
            {
                int length = encoding.length;
                int newLength = (length / 8 + 1) * 8;
                int pad = newLength - length;
                byte[] old = encoding;
                encoding = new byte[newLength];
                for (int i = old.length - 1; i >= 0; --i)
                {
                    encoding[(i + pad)] = old[i];
                }
            }

            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(2, key);
            byte[] decode = cipher.doFinal(encoding);
            return new String(decode);
        } catch(Exception e) {
            return "";
        }
    }


}
