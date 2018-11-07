package com.example.liaoxinying.notec;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Addnote extends Activity {
    private Button bt_save;
    private Button bt_back;
    private TextView timeView;
    private EditText content;
    private EditText title;
    private Uri originalUri;
    private DatabaseHelper databaseHelper;
    private boolean exi = false;
    private int po = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnote);
        databaseHelper = new DatabaseHelper(this, "Note1.db", null, 1);
        title = (EditText) findViewById(R.id.ed_title);
        content = (EditText) findViewById(R.id.ed_content);
        timeView = (TextView) findViewById(R.id.time_text);
        bt_back = (Button) findViewById(R.id.back);
        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Addnote.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Intent intent = getIntent();
        if (intent.getSerializableExtra("note") != null) {
            Note note = (Note) intent.getSerializableExtra("note");
            exi = true;
            if (note != null) {
                title.setText(note.getTitle());
                Log.d("MYTAG", "note.getUri is " + note.getUri());
                if (note.getUri() != null) {
                    ContentResolver resolver = getContentResolver();
                    Uri u = Uri.parse(note.getUri());
                    String temp = note.getContent();
                } else
                    content.setText(note.getContent());
                timeView.setText(note.getDate());
                po = note.getId();
            }
        }
        bt_save = (Button) findViewById(R.id.save);
        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int res = saveContent(po);
                if (res == 0) {
                    Intent intent = new Intent(Addnote.this,
                            MainActivity.class);
                    startActivity(intent);
                } else
                    Toast.makeText(Addnote.this, "内容不得为空",
                            Toast.LENGTH_SHORT).show();
            }
        });
        timeView = (TextView) findViewById(R.id.time_text);
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        timeView.setText("  " + year + "年" + month + "月" + day + "日" + hour + ":" + minute + ":" + second);

    }


    private int saveContent(int id) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        String co_title = "";
        String co_content = "";
        String date = "";
        co_title = title.getText().toString();
        co_content = content.getText().toString();
        if (co_content.equals("") && co_title.equals("")) {
            return -1;
        }
        date = timeView.getText().toString();
        ContentValues values = new ContentValues();
        values.put("title", co_title);
        values.put("content", co_content);
        values.put("date", date);
        if (originalUri != null)
            values.put("uri", originalUri.toString());
        if (!exi) {
            db.insert("note", null, values);
            values.clear();
        } else {
            db.update("note", values, "id = ?", new String[] {
                    "" + po
            });
            values.clear();
        }
        db.close();
        return 0;
    }
}