import java.io.*;

public class FileCopyComparison {

    // Constants
    private static final int BUFFER_SIZE = 4096; // 4KB

    // Copy using unbuffered streams
    public static void copyUsingUnbufferedStreams(String source, String destination) throws IOException {
        FileInputStream fis = new FileInputStream(source);
        FileOutputStream fos = new FileOutputStream(destination);
        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead;
        while ((bytesRead = fis.read(buffer)) != -1) {
            fos.write(buffer, 0, bytesRead);
        }
        fis.close();
        fos.close();
    }

    // Copy using buffered streams
    public static void copyUsingBufferedStreams(String source, String destination) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination));
        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead;
        while ((bytesRead = bis.read(buffer)) != -1) {
            bos.write(buffer, 0, bytesRead);
        }
        bis.close();
        bos.close();
    }

    public static void main(String[] args) {
        String sourceFile = "largefile.dat";           // Replace with your 100MB file path
        String unbufferedDest = "unbuffered_copy.dat";
        String bufferedDest = "buffered_copy.dat";

        try {
            // Unbuffered
            long startUnbuffered = System.nanoTime();
            copyUsingUnbufferedStreams(sourceFile, unbufferedDest);
            long endUnbuffered = System.nanoTime();
            System.out.println("Unbuffered Stream Time: " + (endUnbuffered - startUnbuffered) / 1_000_000 + " ms");

            // Buffered
            long startBuffered = System.nanoTime();
            copyUsingBufferedStreams(sourceFile, bufferedDest);
            long endBuffered = System.nanoTime();
            System.out.println("Buffered Stream Time: " + (endBuffered - startBuffered) / 1_000_000 + " ms");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

