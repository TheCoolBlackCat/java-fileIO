public class Main {
  public static void main(String[] args) {
    File f1 = new File("test.txt"); // Create file test.txt

    // Read from file
    String[] txt = f1.read();

    for (String line: txt)
      System.out.println(line);

    // Write to file
    String[] toAdd = {"Hello World!", "I'm", "a", "file"};
    f1.write(toAdd);


    // Write bytes to file
    byte[] b = {72, 101, 108, 108, 111, ' ', 87, 111, 114, 108, 100, '\n'};
    File f2 = new File("bytes.txt"); // Create file test.txt
    f2.write(b);
  }
}
