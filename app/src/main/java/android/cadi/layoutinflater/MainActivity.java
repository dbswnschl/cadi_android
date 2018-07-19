package android.cadi.layoutinflater;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //    LinearLayout layout;
//    ListView list_main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_add = (Button) findViewById(R.id.btn_add);
        final EditText editText = (EditText) findViewById(R.id.edit_input);
        final EditText edit_index = (EditText) findViewById(R.id.edit_index);
        Button btn_delete = (Button) findViewById(R.id.btn_delete);
        final ListView listView = (ListView) findViewById(R.id.list_main);
        final ArrayList<String> arrayList = new ArrayList<String>();
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().length() > 0) {
                    String inputStr = editText.getText().toString();
                    arrayList.add(inputStr);
                    arrayAdapter.notifyDataSetChanged();
                }
            }
        });
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (Integer.parseInt(edit_index.getText().toString()) > -1) {
                        arrayList.remove(Integer.parseInt(edit_index.getText().toString()));
                        arrayAdapter.notifyDataSetChanged();
                    }
                } catch (IndexOutOfBoundsException indexException) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("알림");
                    builder.setMessage("항목의 개수를 초과하였습니다.");
                    builder.setNegativeButton("확인", null);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });

//        setContentView(R.layout.activity_main);
//        layout = (LinearLayout) findViewById(R.id.container);
//        Button button = (Button) findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//                inflater.inflate(R.layout.sublayout, layout, true);
//                CheckBox checkBox = (CheckBox) layout.findViewById(R.id.checkBox);
//                checkBox.setText("로딩되었어요");
//
//            }
//        });
//        Button btn_tmp = (Button) findViewById(R.id.btn_temp);
//        btn_tmp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setDialog();
//            }
//        });
//        list_main = (ListView)findViewById(R.id.list_main);
    }

    @Override
    protected void onStart() {
        super.onStart();


    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    }


    void setDialog() {
        Toast.makeText(this, "ddd", Toast.LENGTH_LONG).show();
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("나가기");
        builder.setMessage("종료?");
        builder.setPositiveButton("거절", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "취소", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("나가기", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertDialog msgDialog = builder.create();
        msgDialog.show();

    }
}
