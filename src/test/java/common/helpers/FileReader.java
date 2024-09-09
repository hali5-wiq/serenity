package common.helpers;

import java.io.BufferedReader;
import java.io.IOException;

public class FileReader {

    public String readFile(String file) {
        try {
            BufferedReader reader = new BufferedReader(new java.io.FileReader(file));
            String line = null;
            StringBuilder stringBuilder = new StringBuilder();
            String ls = System.getProperty("line.separator");

            try {
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
                }
                return stringBuilder.toString();
            } finally {
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
