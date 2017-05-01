import java.io.*;
import java.nio.charset.StandardCharsets;

public class UrlGenerator
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter number of urls needed: ");
        long n = Long.parseLong(obj.readLine());
        System.out.print("Enter length of each url: ");
        int len = Integer.parseInt(obj.readLine());

        FileOutputStream urlStream = new FileOutputStream(new File("files/urls.txt"));

        while(n != 0) {
            try {
                String url = "";
                for(int i = 0; i < len; i++) {
                    int val = 97 + (int) (Math.random() * 26);
                    url += (char) val;
                }

                if(n != 1)
                    url = "http://" + url + ".com ";
                else
                    url = "http://" + url + ".com";
                urlStream.write(url.getBytes(StandardCharsets.UTF_8), 0, url.length());
            } catch (IOException e) {
                e.printStackTrace();
            }
            n--;
        }
        urlStream.close();
    }
}