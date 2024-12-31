import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import javazoom.jl.converter.Converter;
import javazoom.jl.decoder.JavaLayerException;

public class Mini {
    public static void main(String[] args) 
    {

    }
}
public class Mini {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the text you want to convert to MP3:");
        String text = scanner.nextLine();
        scanner.close();

        try {
            // Create a temporary text file
            File tempTextFile = File.createTempFile("tempText", ".txt");
            FileOutputStream fos = new FileOutputStream(tempTextFile);
            fos.write(text.getBytes());
            fos.close();

            // Convert the text file to MP3
            String mp3FilePath = "output.mp3";
            convertTextToMp3(tempTextFile.getAbsolutePath(), mp3FilePath);

            System.out.println("MP3 file created at: " + mp3FilePath);
        } catch (IOException | JavaLayerException e) {
            e.printStackTrace();
        }
    }

    private static void convertTextToMp3(String textFilePath, String mp3FilePath) throws JavaLayerException, IOException {
        // Use a text-to-speech library to convert text to audio
        // For example, using FreeTTS or any other TTS library
        // Here, we assume the text-to-speech conversion is done and we have an audio file

        // Convert the audio file to MP3 using JLayer
        Converter converter = new Converter();
        converter.convert(textFilePath, mp3FilePath);
    }
}