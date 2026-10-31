package Binance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class xrp {
    public static void main(String[] args) throws IOException, InterruptedException {
        //https://api.binance.com/api/v3/ticker/price?symbol=XRPUSDT

        URL url = new URL("https://api.binance.com/api/v3/ticker/price?symbol=XRPUSDT");
        URLConnection yc = url.openConnection();
        System.out.println("Connected!");

        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream() ) );


        String json ="";
        String jaison = """
                {
                "symbol" : "XRPUSDT",
                "price" : "1500.00"
                }
                """;
        Tracker data;
        //while ((inputLine = in.readLine()) != null) {
        System.out.println("XRP");
        int j = 0;
        //String inputLine;
//        String inputLine = in.readLine();
//        data = new Gson().fromJson(inputLine, Tracker.class);
        while (j < 5 ) {
//            if (inputLine == null) {
//                break;
//            }
            //System.out.println(data.getPrice());

            //yc.wait(1500);
            if (in.ready() !=false) {
                String inputLine = in.readLine();
                System.out.println(inputLine);
            }
            //data =  new Gson().fromJson(inputLine, Tracker.class);

//            String symbol = data.getSymbol();
//            System.out.println(symbol);
            //String price = data.getPrice();
            j++;
            in.mark(j+1);


            //in.reset();

        }
        System.out.println(j);
        //}



    }
}
