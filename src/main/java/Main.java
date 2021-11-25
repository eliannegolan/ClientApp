import java.io.IOException;

public class Main
{
    public static void main(String[] args)
    {
        elianne el = new elianne();
        el.makeGetRequest();
        try {
            el.makePostRequest();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
