package encryptdecrypt.algorithms;

public class UnicodeCryptoAlgorithm implements CryptoAlgorithm {
    @Override
    public String encode(String data, int key) {
        char[] chars = data.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] += key;
        }
        return String.valueOf(chars);
    }

    @Override
    public String decode(String data, int key) {
        char[] chars = data.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] -= key;
        }
        return String.valueOf(chars);
    }
}
