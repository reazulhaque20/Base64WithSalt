import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import java.util.Date;
import java.util.Random;
import java.io.IOException;

public class Main {
    private static final Random rand = new Random((new Date()).getTime());

    public static void main(String[] args) {
        String st = "secrete";
        String enc = encrypt(st);
        System.out.println("Encrypted string :" + enc);
        System.out.println("Decrypted string :" + decrypt(enc));
    }
    public static String encrypt(String str) {
        BASE64Encoder encoder = new BASE64Encoder();
        byte[] salt = new byte[8];
        rand.nextBytes(salt);
        return encoder.encode(salt) + encoder.encode(str.getBytes());
    }

    public static String decrypt(String encStr) {
        if (encStr.length() > 12) {
            String cipher = encStr.substring(12);
            BASE64Decoder decoder = new BASE64Decoder();
            try {
                return new String(decoder.decodeBuffer(cipher));
            } catch (IOException e) {
                //  throw new InvalidImplementationException(
                //Fail
            }
        }
        return null;
    }
}