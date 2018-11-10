public class Main {
  public static void main(String[] args) {
    File f = new File("test.txt"); // Create file test.txt

    // Read from file
    String[] txt = f.read();

    for (String line: txt)
      System.out.println(line);

    // Write to file
    String[] toAdd = {"Hello World!", "I'm", "a", "file"};
    f.write(toAdd);
  }
}
