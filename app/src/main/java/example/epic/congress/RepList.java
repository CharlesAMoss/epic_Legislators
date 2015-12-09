package example.epic.congress;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;


public class RepList extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reps_view);

        String[] someWords = new String[] {"one", "two", "three"};

        ArrayAdapter <String> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, someWords);
        setListAdapter(arrayAdapter);

    }



}
