import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileSummaryReport {
    public static void main(String[] args) {
        // Create a file chooser dialog
        JFileChooser fileChooser = new JFileChooser();

        // Show the dialog and get the selected file
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            // Process the selected file
            processFile(selectedFile);
        } else {
            System.out.println("No file selected.");
        }
    }

    private static void processFile(File file) {
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lineCount++;
                charCount += line.length();

                // Split the line into words and count them
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }

            bufferedReader.close();

            // Print the summary report
            System.out.println("File Name: " + file.getName());
            System.out.println("Number of Lines: " + lineCount);
            System.out.println("Number of Words: " + wordCount);
            System.out.println("Number of Characters: " + charCount);
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}

