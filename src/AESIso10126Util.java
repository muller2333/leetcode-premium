import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.security.SecureRandom;

public class AESIso10126Util {
    public static byte[] iso10126Pad(byte[] data, int blockSize) {
        int padLen = blockSize - (data.length % blockSize);
        if (padLen == 0)
            padLen = blockSize;
        byte[] padded = new byte[data.length + padLen];
        System.arraycopy(data, 0, padded, 0, data.length);
        SecureRandom rnd = new SecureRandom();
        // 随机填充 padLen - 1 个字节
        byte[] rand = new byte[padLen - 1];
        rnd.nextBytes(rand);
        System.arraycopy(rand, 0, padded, data.length, padLen - 1);
        padded[padded.length - 1] = (byte) padLen;
        return padded;
    }

    public static String encryptToBase64(String keyStr, String plaintext) throws Exception {
        byte[] keyBytes = keyStr.getBytes("UTF-8");
        SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding"); // 使用 NoPadding，因为我们手动 pad
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] padded = iso10126Pad(plaintext.getBytes("UTF-8"), 16);
        byte[] ct = cipher.doFinal(padded);
        return Base64.getEncoder().encodeToString(ct);
    }

    public static void main(String[] args) throws Exception {
        String key = "ce8a7105998875ef";
        String email = "2364@qq.com";
        String result = encryptToBase64(key, email);
        System.out.println("加密后 Base64 = " + result);
    }
}