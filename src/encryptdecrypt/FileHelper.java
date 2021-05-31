package encryptdecrypt;

import java.io.*;

/*
Инкапсулирует в себе методы работы с файлами.
Может писать и читать из файла.
 */

public class FileHelper {

    public static String read(String path) {
        StringBuilder result = new StringBuilder();
        File file = new File(path);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (reader.ready()) {
                result.append(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public static void write(String path, String source) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(source);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
