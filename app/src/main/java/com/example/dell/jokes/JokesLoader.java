package com.example.dell.jokes;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JokesLoader extends AsyncTaskLoader<String>{
       Context context1;
       String key1;

    public JokesLoader(Context context,String key) {
        super(context);
        context1=context;
        key1=key;
    }

    @Override
    public String loadInBackground() {
        try {
            URL url1=new URL(key1);
            HttpURLConnection connection= (HttpURLConnection) url1.openConnection();
            InputStream is=connection.getInputStream();
            BufferedReader reader=new BufferedReader(new InputStreamReader(is));
            String line="";
            StringBuilder builder=new StringBuilder();
            while ((line=reader.readLine())!=null)
            {
                builder.append(line+"\n");
            }
            return builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}
