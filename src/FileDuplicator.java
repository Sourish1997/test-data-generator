/**
 * Created by Sourish on 01-05-2017.
 */
import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileDuplicator
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter number of duplicate files needed: ");
        long n = Long.parseLong(obj.readLine());
        FileInputStream inStream = null;
        FileOutputStream outStream = null;
        FileOutputStream nameStream = new FileOutputStream(new File("files/names.txt"));

        while(n != 0) {
            try {
                File infile = new File("files/file.txt");
                File outfile = new File("files/inputFiles/input" + n + ".txt");

                if(n != 1)
                    nameStream.write(new String("input" + n + ".txt ").getBytes(StandardCharsets.UTF_8), 0, new String("input" + n + ".txt ").length());
                inStream = new FileInputStream(infile);
                outStream = new FileOutputStream(outfile);

                byte[] buffer = new byte[1024];

                int length;
                while ((length = inStream.read(buffer)) > 0) {
                    outStream.write(buffer, 0, length);
                }

                inStream.close();
                outStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            n--;
        }
        nameStream.write(new String("input1.txt").getBytes(StandardCharsets.UTF_8), 0, new String("input" + n + ".txt").length());
        nameStream.close();
    }
}
