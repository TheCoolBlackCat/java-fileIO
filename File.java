/* File I/O for Java
 * Timothy Clark, 2018
 */

import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

import java.io.FileOutputStream;

import java.io.FileNotFoundException;
import java.io.IOException;

public class File {
    private String path;

    /**
     * @param path Path to the file (including file name and extension)
     * */
    public File (String path) {
        this.path = path;
    }

    /**
     * Read text from file
     * @return Output of the file, stored line by line in an array
     * */
    public String[] read () {
        ArrayList<String> output = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path)); // File Reader
            String line = br.readLine(); // Read first line

            int count = 0;
            while(line != null) { // Iterate lines
                output.add(line);
                line = br.readLine(); // Read next line
                count++;
            }

            br.close(); // Close file

        // Exception Handling
        } catch (FileNotFoundException e) {
            System.err.println("File at \""+path+ "\" not found! Creating an empty file");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output.toArray(new String[output.size()]);
    }

    /**
     * Write text to file
     * @param text Array of lines to write into file
     * */
    public void write (String[] text) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path, false)); // File (Over)Writer

            for (String line: text) {
                bw.write(line); // Write line
                bw.newLine(); // Followed by moving to new line
            }

            bw.close(); // Close file
        // Exception Handling
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Write byte array to file
     * @param bytes Array of bytes to write into file
     * */
    public void write (byte[] bytes) {
      FileOutputStream s = null;
        try {
            s = new FileOutputStream(path);
        } catch (FileNotFoundException e) {
            System.err.println("File at \""+path+ "\" not found!");
        }

        if (s != null) {
            try {
                for (byte b: bytes)
                    s.write(b);
                s.close();
            // Exception Handling
            } catch (IOException e) {
              e.printStackTrace();
            }
       }
  }
}
