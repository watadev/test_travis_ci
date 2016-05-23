package bbbkakashi.bt12_1442061;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {

    Context context;
    List headlines;
    List links;
    MyTask myTask;
    ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
            Lấy các thông số cần thiết để truyền cho hàm khởi tạo của async task
         */
        context = getApplication().getBaseContext();
        headlines = new ArrayList();
        links = new ArrayList();
        listView = (ListView) findViewById(android.R.id.list);

        /*
            Khởi tạo một async task phục vụ cho việc load rss
         */
        myTask = new MyTask(getApplicationContext(),listView,links,headlines);
        myTask.execute();


    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Uri uri = Uri.parse((String) links.get(position));
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

}
