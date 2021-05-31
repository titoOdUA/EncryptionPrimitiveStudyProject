package encryptdecrypt;
/*
Консольный шифратор дешифратор. Принимает некоторое количество аргументов на вход,
в зависимости от которых выбираеться алгоритм, шифруеться или дешифруеться сообщение,
выводиться в файл или в консоль.
 */

public class Main {
    public static void main(String[] args) {
        ArgsManager.parseArgs(args);

        EncryptionManager encryptionManager = new EncryptionManager(
                ArgsManager.getMode(),
                ArgsManager.getKey(),
                ArgsManager.getRawData(),
                ArgsManager.getAlgorithm());
        encryptionManager.startProcess();

        if (ArgsManager.isOutputToFile()) {
            FileHelper.write(ArgsManager.getOutputFilePath(),
                    encryptionManager.getProcessedData());
        } else {
            System.out.println(encryptionManager.getProcessedData());
        }
    }
}
