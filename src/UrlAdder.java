import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * Created by Sourish on 02-05-2017.
 */
public class UrlAdder {
    public static void main(String[] args) throws IOException
    {
        ArrayList<String> urlSet = new ArrayList<>();
        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter size of url dataset: ");
        long size = Long.parseLong(obj.readLine());
        BufferedReader urlStream = new BufferedReader(new FileReader("files/urls.txt"));
        String urls[] = urlStream.readLine().split(" ");
        for(int i = 0; i < size; i++)
            urlSet.add(urls[i]);

        System.out.print("Enter number of urls to be added in each file: ");
        int number = Integer.parseInt(obj.readLine());
        System.out.print("Enter number of files: ");
        long n = Long.parseLong(obj.readLine());
        FileOutputStream outStream = null;

        while(n != 0) {
            try {
                File outfile = new File("files/inputFiles/input" + n + ".txt");
                outStream = new FileOutputStream(outfile, true);
                for(int i = 0; i < number; i++) {
                    int urlNo = (int) (Math.random() * (size - 1));
                    String url = " " + urlSet.get(urlNo);
                    outStream.write(url.getBytes(StandardCharsets.UTF_8), 0, url.length());
                }
                outStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            n--;
        }
    }
}
