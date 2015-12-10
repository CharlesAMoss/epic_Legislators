package example.epic.congress;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.zipCode) TextView mZipCode;
    private Button mSubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mZipCode = (EditText)findViewById(R.id.zipCode);
        mSubmitButton = (Button)findViewById(R.id.buttonSubmit);


        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String zipCode = mZipCode.getText().toString();
                LoadFeedData loadFeedData = new LoadFeedData();
                loadFeedData.getZip(zipCode, new Callback() {
                    @Override
                    public void onFailure(Request request, IOException e) {

                    }

                    @Override
                    public void onResponse(Response response) throws IOException {
                        final String responseData = response.body().string();

                        try {

                            JSONObject obj = new JSONObject(responseData);
                            Iterator x = obj.keys();
                            JSONArray jsonArray = new JSONArray();

                            while (x.hasNext()) {
                                String key = (String) x.next();
                                jsonArray.put(obj.get(key));
                            }




                            Log.d("Seems to work", jsonArray.toString());

                        } catch (Throwable t) {
                            Log.d("fuck this shit", "news is bad");
                        }




                        Log.d("RESPONSE", responseData);


                    }
                });
               // Toast.makeText(MainActivity.this, responseData, Toast.LENGTH_LONG).show();
            }
        });


    }


}
