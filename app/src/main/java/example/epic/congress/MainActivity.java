package example.epic.congress;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

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
                        Log.d("RESPONSE", responseData);
                    }
                });

               // Toast.makeText(MainActivity.this, sunlightUrl, Toast.LENGTH_LONG).show();
            }
        });



    }






}
