import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

@WebServlet(urlPatterns={"/patients"},loadOnStartup = 1)

public class elianne extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setContentType("text/html");
        resp.getWriter().write("Hello, world!\n");
        resp.getWriter().write("Elianne");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {


    }

    makeGetRequest()
    {
        URL myURL = new URL("http://imperial.ac.uk");
        HttpURLConnection conn = (HttpURLConnection) my URL.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "txt/html");
        conn.setRequestProperty("charset", "utf-8");

        BufferedReader in = new BufferedReader(new InputStreamReader(myURL.openStream())); //openstream reads contents of url

        String inputLine; //Reads the body of the response
        while ((inputLine = in.readLine()) != null)
        {
            System.out.println(inputLine);
        }
        in.close();
    }
}
