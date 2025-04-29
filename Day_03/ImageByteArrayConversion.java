import java.io.*;
import java.nio.file.Files;

public class ImageByteArrayConversion {

    public static void main(String[] args) {
        String inputImagePath = "input.jpg";        
        String outputImagePath = "output.jpg";

        try {
            
            FileInputStream fis = new FileInputStream(inputImagePath);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            fis.close();

            byte[] imageBytes = baos.toByteArray();

           
            ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
            FileOutputStream fos = new FileOutputStream(outputImagePath);
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            fos.close();
            bais.close();

            System.out.println("Image successfully written to " + outputImagePath);

        
            long originalSize = Files.size(new File(inputImagePath).toPath());
            long newSize = Files.size(new File(outputImagePath).toPath());

            if (originalSize == newSize) {
                System.out.println("Verification passed: Files are identical in size.");
            } else {
                System.out.println("Verification failed: Files differ in size.");
            }

        } catch (IOException e) {
            System.out.println("An error occurred during file processing:");
            e.printStackTrace();
        }
    }
}

