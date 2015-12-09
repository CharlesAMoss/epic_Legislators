package example.epic.congress;


import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;



/**
 * Created by Guest on 12/9/15.
 */
public class LoadFeedData {

        public void getZip (String zipCode, Callback callback ) {
                String apiKey = "50e61a614db3429396fe0baca4191a0e";
                String sunlightUrl = "https://congress.api.sunlightfoundation.com" + "/"
                        + "legislators/locate?zip=" + zipCode + "&apikey=" + apiKey;

                OkHttpClient client = new OkHttpClient();

                Request request = new Request.Builder()
                        .url(sunlightUrl)
                        .build();

            client.newCall(request).enqueue(callback);

//                Response response = client.newCall(request).execute();

//        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
//
//                Headers responseHeaders = response.headers();
//                for (int i = 0; i < responseHeaders.size(); i++) {
//                        System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
//                }
//
//               System.out.println(response.body().string());
//
//
//                        return "hello";


             }

}