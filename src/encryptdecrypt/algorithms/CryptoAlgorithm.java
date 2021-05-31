package encryptdecrypt.algorithms;

/*
Интерфейс потомки которого являються конкретными реализациями того или иного алгоритма
шифрования и содержат конкретную реализацию методов
 */

public interface CryptoAlgorithm {
    String encode(String data, int key);
    String decode(String data, int key);
}
