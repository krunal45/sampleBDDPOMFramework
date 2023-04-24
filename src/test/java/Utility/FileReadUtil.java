package Utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FileReadUtil {
    private static FileReader reader;
    private static Properties properties;

    public static void loadPropertiesFile() throws IOException {
        reader = new FileReader("config.properties");
        properties = new Properties();
        properties.load(reader);
    }

    public static String getProperty(String key) {
        return (String) properties.get(key);
    }

    public static String getCSVData(String key) {
        String csvFile = ConfigProperties.CSVFilePath;
        String line = "";
        String csvSplitBy = ",";
        Map<String, String> dataMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            int len = (int) br.lines().count();
            BufferedReader br1 = new BufferedReader(new FileReader(csvFile));
            line = br1.readLine();
            String[] headers = line.split(csvSplitBy);
            for (int i = 0; i < len - 1; i++) {
                line = br1.readLine();
                String[] data = line.split(csvSplitBy);
                for (int j = 0; j < headers.length; j++) {
                    dataMap.put(headers[j], data[j]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataMap.get(key);
    }
}