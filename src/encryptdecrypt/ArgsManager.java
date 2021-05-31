package encryptdecrypt;

import java.util.HashMap;
import java.util.Map;

/*
Менеджит переданные при запуске аргументы. Парсит их и сохраняет состояния.
Эти параметры использует в последствии EncryptionManager класс.
 */

public class ArgsManager {

    private static CryptoMode mode;
    private static int key;
    private static String rawData;
    private static boolean outputToFile = false;
    private static String outputFilePath;
    private static Map<String, String> params;
    private static String algorithm;

    public static void parseArgs(String[] args) {
        params = new HashMap<>();
        for (int i = 0; i < args.length; i += 2) {
            params.put(args[i], args[i + 1]);
        }
        setMode();
        setKey();
        setRawData();
        setOutputToFile();
        setAlgorithm();
    }

    private static void setAlgorithm() {
        if (params.containsKey("-alg")) {
            algorithm = params.get("-alg").toLowerCase();
            return;
        }
        algorithm = "shift";
    }

    private static void setMode() {
        mode = CryptoMode.valueOf(params.getOrDefault("-mode", "enc").toUpperCase());
    }

    private static void setKey() {
        key = Integer.parseInt(params.getOrDefault("-key", "0"));
    }

    private static void setRawData() {
        if (params.containsKey("-in")) {
            rawData = FileHelper.read(params.get("-in"));
            return;
        }
        rawData = params.getOrDefault("-data", "");
    }

    public static CryptoMode getMode() {
        return mode;
    }

    public static int getKey() {
        return key;
    }

    public static String getRawData() {
        return rawData;
    }


    public static boolean isOutputToFile() {
        return outputToFile;
    }

    public static void setOutputToFile() {
        if (params.containsKey("-out")) {
            outputFilePath = params.get("-out");
            outputToFile = true;
        }
    }

    public static String getOutputFilePath() {
        return outputFilePath;
    }

    public static String getAlgorithm() {
        return algorithm;
    }
}
