package zakaria.com.samplelistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    ArrayList<String> nameList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        nameList = new ArrayList<>();
        nameList.add("Rahat");
        nameList.add("Shohid");
        nameList.add("Shohan");
        nameList.add("Tauhid");
        nameList.add("Nazim");
        nameList.add("Shakerul");
        nameList.add("Belal");
        nameList.add("Jahid");
        nameList.add("Tushar");
        nameList.add("Muktar");
        nameList.add("Aumy");

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.custom_row, R.id.nameTv, nameList);


        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                /*String iteamClicked = nameList.get(position);
                Toast.makeText(MainActivity.this, iteamClicked, Toast.LENGTH_SHORT).show();
*/
                int itemPosition = position;
                // ListView Clicked item value
                //String  itemValue    = (String)listView.getItemAtPosition(position);
                String clickIteam=nameList.get(position);

                // Show Alert
                Toast.makeText(getApplicationContext(),
                        "Position :" + itemPosition + "  ListItem : " + clickIteam, Toast.LENGTH_LONG)
                        .show();

               /* nameList.remove(position);
                adapter.notifyDataSetChanged();
*/

            }
        });



        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                String clickIteam=nameList.get(position);
                nameList.remove(position);
                adapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(), clickIteam + " Removed ",Toast.LENGTH_LONG).show();
                return false;
            }
        });



    }
}
