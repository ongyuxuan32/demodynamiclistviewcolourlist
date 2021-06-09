package sg.edu.rp.c346.id20042755.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etElement, etIndexElement;
    Button btnAdd,btnRmv,btnUpd;
    ListView lvColour;
    ArrayList<String> alColours;
    ArrayAdapter<String> aaColours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        etIndexElement = findViewById(R.id.editTextIndex);
        btnAdd = findViewById(R.id.buttonAdditem);
        lvColour = findViewById(R.id.listViewColour);
        btnRmv = findViewById(R.id.buttonRemoveitem);
        btnUpd = findViewById(R.id.buttonUpdateitem);

        alColours = new ArrayList<>();
        alColours.add("Red");
        alColours.add("Orange");

        aaColours = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,alColours);

        lvColour.setAdapter(aaColours);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newColour = etElement.getText().toString();
                int pos = Integer.parseInt( etIndexElement.getText().toString());
                alColours.add(pos, newColour);
                aaColours.notifyDataSetChanged();
                etElement.setText("");

            }
        });

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, alColours.get(position), Toast.LENGTH_LONG
                        ).show();
            }
        });

        btnRmv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Nothing to rmeove",
                        Toast.LENGTH_LONG).show();
                return;
            }
            int pos = Integer.parseInt((etIndexElement.getText().toString()));
            if(pos < alColours() - 1){
                Toast.makeText(MainActivity.this, "Nothing at that index to remove",
                        Toast.LENGTH_LONG).show();
                return;
            }

        });

    }
}