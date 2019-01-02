package com.example.macprosam.ytsmovies;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Acceuil extends AppCompatActivity {
    List<Movie> listm = new ArrayList<>();
    List<Movie> mmm = new ArrayList<>();
ActionBar bar;
Button b;
    RecyclerView mRecyclerView;
    int[] mPlaceList;
    MyAcceuilAdapter newmyAdapter ;

    String [] Moviesnames;
    //MyAdapter myAdapter = new MyAdapter(MainActivity.this, Moviesnames);
    String url = "https://yts.am/api/v2/list_movies.json?limit=10";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);
bar=getSupportActionBar();
bar.hide();
        mRecyclerView = findViewById(R.id.rv);
       /* GridLayoutManager mGridLayoutManager = new GridLayoutManager(Acceuil.this, 2);
        mRecyclerView.setLayoutManager(mGridLayoutManager);*/
        newmyAdapter = new MyAcceuilAdapter(Acceuil.this, listm);
        mRecyclerView.setAdapter(newmyAdapter);

b=findViewById(R.id.btnbrowse);
b.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent mIntent = new Intent(Acceuil.this, MainActivity.class);
        startActivity(mIntent);
    }
});


        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url,null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    List<Movie> maw = new ArrayList<>();
                    JSONObject jobj1 = response.getJSONObject("data");
                    //Toast.makeText(MainActivity.this, "res true", Toast.LENGTH_SHORT).show();

                    JSONArray jsarray=jobj1.getJSONArray("movies") ;
                    // Toast.makeText(MainActivity.this, ""+jsarray.toString(), Toast.LENGTH_SHORT).show();

                    for(int i=0;i<jsarray.length();i++) {

                        JSONObject jsa=jsarray.getJSONObject(i) ;

                        int  idMovie = Integer.parseInt(jsa.getString("id")) ;
                        //  Toast.makeText(MainActivity.this, "id"+idMovie, Toast.LENGTH_SHORT).show();

                        String  MovieName = jsa.getString("title") ;
                        //  Toast.makeText(MainActivity.this, "tile"+MovieName, Toast.LENGTH_SHORT).show();


                        String  imageVoiture = jsa.getString("background_image") ;
                        // Toast.makeText(MainActivity.this, "iv"+imageVoiture, Toast.LENGTH_SHORT).show();


                        String  overview = jsa.getString("summary") ;
                        //Toast.makeText(MainActivity.this, "summary"+overview, Toast.LENGTH_SHORT).show();

                        String  desc = jsa.getString("description_full") ;
                        //Toast.makeText(MainActivity.this, "desc"+desc, Toast.LENGTH_SHORT).show();

                        Double ratevalue = Double.parseDouble(jsa.getString("rating"));
                        int  year = Integer.parseInt(jsa.getString("year")) ;
                        String imageMovie = jsa.getString("medium_cover_image") ;
                        String  tags=jsa.getString("genres") ;
                        String tag =tags.replace("[","");
                        String tag2 =tag.replace("]","");
                        String tag3 =tag2.replace('"',' ');



                        //    Toast.makeText(MainActivity.this, ""+tag3, Toast.LENGTH_SHORT).show();


                        Movie m = new Movie();
                        m.setId(idMovie);
                        m.setDesc(desc);
                        m.setTitle(MovieName);
                        m.setOverview(overview);
                        m.setNomimage(imageMovie);
                        m.setTag(tag3);
                        m.setValuerate(ratevalue);
                        m.setYear(year);
                        //mmm= new ArrayList();
                        // Toast.makeText(MainActivity.this, "mov"+m.toString(), Toast.LENGTH_SHORT).show();
                        listm.add(m);
                        // Toast.makeText(MainActivity.this, "idneww"+m.getId(), Toast.LENGTH_SHORT).show();
                        //maw.add(m);
                    }
                    Log.d("list2",listm.toString());
                    newmyAdapter.notifyDataSetChanged();



                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(Acceuil.this);

        queue.add(request);







    }

}