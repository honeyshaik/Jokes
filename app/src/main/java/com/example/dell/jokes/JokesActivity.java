package com.example.dell.jokes;

import android.app.LoaderManager;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JokesActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {
      RecyclerView rv;
      String count;
    int count1;
      String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);
        rv=findViewById(R.id.recycler);
        count=getIntent().getStringExtra("key");
        url="http://api.icndb.com/jokes/random/";
        Bundle bundle=new Bundle();
        bundle.putString("key",count);
        getLoaderManager().initLoader(1,bundle,this);
        if(getLoaderManager().getLoader(1)!=null){
            getLoaderManager().initLoader(1,bundle,this);
        }
    }

    @Override
    public Loader<String> onCreateLoader(int i, Bundle bundle) {
        return new JokesLoader(this,url+bundle.getString("key"));
    }

    @Override
    public void onLoadFinished(Loader<String> loader, String s) {
        Toast.makeText(this, ""+s, Toast.LENGTH_SHORT).show();
        count1=Integer.parseInt(count);
        ArrayList<String> list=new ArrayList<>();

        try {
            JSONObject jsonObject=new JSONObject(s);
            JSONArray array=jsonObject.getJSONArray("value");
            for (int i=0;i<array.length();i++)
            {
                JSONObject index=array.getJSONObject(i);
                /* jokes=index.getString("joke");*/
                list.add(index.getString("joke"));
            }
            JavaModal model=new JavaModal(list);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new MyAdapter(this,list,count1));

    }

    @Override
    public void onLoaderReset(Loader<String> loader) {

    }

}
