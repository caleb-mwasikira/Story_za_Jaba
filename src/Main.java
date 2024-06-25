import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter lines of text, 'stop' to quit");

        do {
            line = br.readLine();
            System.out.println(line);
        } while (!line.trim().equals("stop"));
    }
}


