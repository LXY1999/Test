package com.example.liaoxinying.notec;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    private FloatingActionButton bt_add;
    private Button bt_search;
    private DatabaseHelper databaseHelper;
    private ArrayList<Note> items;
    private ListView list;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHelper = new DatabaseHelper(this, "Note1.db", null, 1);
        list = (ListView) findViewById(R.id.list);
        show("");

        list.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu menu, View v,
                                            ContextMenu.ContextMenuInfo menuInfo) {
                menu.add(0, 0, 0, "查看");
                menu.add(0, 1, 0, "删除");
            }
        });
        bt_add = (FloatingActionButton) findViewById(R.id.add);
        bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Addnote.class);
                startActivity(intent);
            }
        });
        editText = (EditText) findViewById(R.id.search_content);
        bt_search = (Button) findViewById(R.id.search);
        bt_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editText.getText().toString();
                ArrayList < Note > al = query(str);
                if (al.size() > 0) {
                    QueryAdapter queryAdapter = new
                            QueryAdapter(MainActivity.this, al);
                    list.setAdapter(queryAdapter);
                } else {
                    Toast.makeText(MainActivity.this, "查找不到相关内容 ", Toast.LENGTH_SHORT).show();
                    show("");
                    editText.setText("");
                }
            }
        });
    }

    public ArrayList < Note > query(String str) {
        ArrayList < Note > list = new ArrayList < > ();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        Cursor cursor;
        if (str.equals(""))
            cursor = db.rawQuery("select * from note order by date desc", null);
        else { //模糊查找关键字
            cursor = db.rawQuery("select * from note where content like '%" +
                    str + "%' or date like '%" + str + "%' order by date desc", null);
            Log.d("db", "sql is " + "select * from note where content like '%" +
                    str + "%'or date like '%" + str + "%' order by date desc");
        }

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String title = cursor.getString(cursor.getColumnIndex("title"));
            String content =
                    cursor.getString(cursor.getColumnIndex("content"));
            String date = cursor.getString(cursor.getColumnIndex("date"));
            String uri = cursor.getString(cursor.getColumnIndex("uri"));
            Note note = new Note(id, title, content, date, uri);
            list.add(note);
        }
        cursor.close();
        db.close();
        return list;
    }
    public void show(String str) {
        items = query(str);
        QueryAdapter queryAdapter = new QueryAdapter(MainActivity.this, items);
        list.setAdapter(queryAdapter);
    }

    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case 0:
                detail(items.get(info.position));
                return true;
            case 1:
                deleteData(items.get(info.position));
                show("");
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    private void detail(Note note) {
        Intent intent = new Intent(MainActivity.this, Addnote.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("note", note);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void deleteData(Note note) {
        String sql = "delete from note where id = ?";
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        db.execSQL(sql, new Integer[] {
                note.getId()
        });
    }
}