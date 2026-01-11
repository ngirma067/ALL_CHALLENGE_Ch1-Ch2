
package chapter_one_challenge_one;

import java.io.*;  

class InvalidConfigVersionException extends Exception {
    public InvalidConfigVersionException(String message) {
        super(message);
    }
}

public class RobustFileConfigReader {
    public static void main(String[] args) {
        BufferedReader reader = null;

        try {
            
            File file = new File("config.txt");
            reader = new BufferedReader(new FileReader(file));

            String versionLine = reader.readLine();
            if (versionLine == null) {
                throw new IOException("Config file is empty!");
            }

            int version = Integer.parseInt(versionLine);

            if (version < 2) {
                throw new InvalidConfigVersionException("Config version too old!");
            }

            String filePath = reader.readLine();
            if (filePath == null) {
                throw new IOException("Missing file path in config!");
            }

            File pathFile = new File(filePath);
            if (!pathFile.exists()) {
                throw new IOException("File at given path does not exist: " + filePath);
            }

            System.out.println("Configuration loaded successfully!");
            System.out.println("Version: " + version);
            System.out.println("Path: " + filePath);

        } catch (FileNotFoundException e) {
            System.out.println("Error: config.txt file not found!");
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format in config version!");
        } catch (InvalidConfigVersionException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        } finally {
            System.out.println("Config read attempt finished.");
           
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing file reader.");
            }
        }
    }
}
