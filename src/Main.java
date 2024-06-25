import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/*
This program copies the contents of a text file
from source to destination
 */
public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static Path enterFilepath(String prompt, boolean ensure_exists) {
        Path fpath;

        while(true) {
            System.out.print(prompt);
            String fname = scanner.nextLine();
            fpath = Paths.get(fname);

            if(ensure_exists) {
                if(Files.exists(fpath)) {
                    break;
                }
                System.out.printf("%s (No such file or directory)\n", fpath);
            } else {
                break;
            }
        }

        return fpath;
    }

    public static void main(String[] args) {
        Path in_fpath = enterFilepath("Enter source file: ", true);
        Path out_fpath = enterFilepath("Enter destination file: ", false);

        FileInputStream in_file;
        FileOutputStream out_file;

        try {
            in_file = new FileInputStream(in_fpath.toString());
            out_file = new FileOutputStream(out_fpath.toString());

            while(true) {
                int next_byte = in_file.read();
                if (next_byte == -1) {
                    break;
                }

                out_file.write((char) next_byte);
            }

            System.out.printf("done copying contents of file %s to file %s\n", in_fpath, out_fpath);
            in_file.close();
            out_file.close();
        } catch (IOException e) {
            System.out.printf("error reading file contents; %s\n", e.getMessage());
        }

        scanner.close();
    }
}


