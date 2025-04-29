import java.io.*;

public class PipedStreamCommunication {

    public static void main(String[] args) {
        try {
            // Create piped input and output streams
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos); // Connect input to output

            // Writer thread
            Thread writer = new Thread(() -> {
                try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(pos))) {
                    String[] messages = {
                        "Hello from writer thread!",
                        "This is a message through pipe.",
                        "Goodbye!"
                    };
                    for (String msg : messages) {
                        bw.write(msg);
                        bw.newLine(); // Important for reader to read line by line
                        bw.flush();   // Ensure data is pushed
                        Thread.sleep(500); // Simulate processing delay
                    }
                } catch (IOException | InterruptedException e) {
                    System.out.println("Writer error:");
                    e.printStackTrace();
                }
            });

            // Reader thread
            Thread reader = new Thread(() -> {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(pis))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        System.out.println("Reader received: " + line);
                    }
                } catch (IOException e) {
                    System.out.println("Reader error:");
                    e.printStackTrace();
                }
            });

            // Start threads
            reader.start();
            writer.start();

            // Wait for threads to finish
            writer.join();
            reader.join();

        } catch (IOException | InterruptedException e) {
            System.out.println("Setup error:");
            e.printStackTrace();
        }
    }
}

