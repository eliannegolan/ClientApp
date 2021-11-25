import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;



public class elianne {

    protected void makeGetRequest() {
        try {
            URL myURL = new URL("https://elianneservlet.herokuapp.com/patients");
            HttpURLConnection conn = (HttpURLConnection) myURL.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "txt/html");
            conn.setRequestProperty("charset", "utf-8");

            BufferedReader in = new BufferedReader(new InputStreamReader(myURL.openStream())); //openstream reads contents of url

            String inputLine; //Reads the body of the response
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            in.close();
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }

    protected void makePostRequest() throws IOException {
        String message = "Hello servlet";
        byte[] body = message.getBytes(StandardCharsets.UTF_8);
        URL myURL = new URL(" http://localhost:8080/elianneServlet/patients");
        HttpURLConnection conn = null;
        conn = (HttpURLConnection) myURL.openConnection();
// Set up the header
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Accept", "text/html");
        conn.setRequestProperty("charset", "utf-8");
        conn.setRequestProperty("Content-Length", Integer.toString(body.length));
        conn.setDoOutput(true);
// Write the body of the request
        try (OutputStream outputStream = conn.getOutputStream()) {
            outputStream.write(body, 0, body.length);
        }
        BufferedReader bufferedReader = new BufferedReader(new
                InputStreamReader(conn.getInputStream(), "utf-8"));
        String inputLine;
// Read the body of the response
        while ((inputLine = bufferedReader.readLine()) != null) {
            System.out.println(inputLine);
        }
        bufferedReader.close();


    }
}
