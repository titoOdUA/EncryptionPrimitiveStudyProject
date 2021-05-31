package encryptdecrypt;

import encryptdecrypt.algorithms.ShiftCryptoAlgorithm;
import encryptdecrypt.algorithms.UnicodeCryptoAlgorithm;
import encryptdecrypt.algorithms.CryptoAlgorithm;

/*
Сердце программы. Управляет тем что будет происходить в рантайме.
В зависимости от аргументов создает нужный экземпляр алгоритма и запускает нужный метод
 */

public class EncryptionManager {

    CryptoMode mode;
    int key;
    String rawData;
    private String processedData;
    CryptoAlgorithm algorithm;

    public EncryptionManager(CryptoMode mode, int key, String rawData, String algName) {
        this.mode = mode;
        this.key = key;
        this.rawData = rawData;
        chooseAlgorithm(algName);
    }

    private void chooseAlgorithm(String algName) {
        switch (algName) {
            case "unicode" :
                this.algorithm = new UnicodeCryptoAlgorithm();
                break;
            case "shift":
                this.algorithm = new ShiftCryptoAlgorithm();
                break;
            default: this.algorithm = null;
        }
    }

    public void startProcess() {
        switch (mode) {
            case ENC:
                processedData = algorithm.encode(rawData, key);
                break;
            case DEC:
                processedData = algorithm.decode(rawData, key);
                break;
        }
    }

    public String getProcessedData() {
        return processedData;
    }
}
