import java.io.FileInputStream;
import java.io.IOException;

/*
This program displays the contents of a text file
 */
public class Main {
    public static void main(String[] args) {
        String filename = "/home/netrunner/Downloads/banana.txt";
        StringBuilder contents = new StringBuilder();

        try {
            FileInputStream file = new FileInputStream(filename);

            while(true) {
                int next_byte = file.read();
                if (next_byte == -1) {
                    break;
                }

                contents.append((char) next_byte);
            }

            System.out.println(contents);
            file.close();
        } catch (IOException e) {
            System.out.printf("error reading file contents; %s\n", e.getMessage());
            System.exit(1);
        }
    }
}


