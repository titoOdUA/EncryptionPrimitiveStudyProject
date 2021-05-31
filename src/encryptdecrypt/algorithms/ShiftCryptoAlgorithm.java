package encryptdecrypt.algorithms;

public class ShiftCryptoAlgorithm implements CryptoAlgorithm {
    @Override
    public String encode(String data, int key) {
        char[] chars = data.toCharArray();
        char aLetter = 'a';
        char zLetter = 'z';

        for (int i = 0; i < chars.length; i++) {
            char letter = chars[i];
            if (letter >= aLetter && letter <= zLetter) {
                for (int j = 0; j < key; j++) {
                    letter++;
                    if (letter > zLetter) {
                        letter = aLetter;
                    }
                }
                chars[i] = letter;
            }
        }
        return String.valueOf(chars);
    }


    @Override
    public String decode(String data, int key) {
        char[] chars = data.toCharArray();
        char aLetter = 'a';
        char zLetter = 'z';

        for (int i = 0; i < chars.length; i++) {
            char letter = chars[i];
            if (letter >= aLetter && letter <= zLetter) {
                for (int j = 0; j < key; j++) {
                    letter--;
                    if (letter < aLetter) {
                        letter = zLetter;
                    }
                }
                chars[i] = letter;
            }
        }
        return String.valueOf(chars);
    }
}

