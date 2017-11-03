package com.example.systemlife.nearbyplaces;

import android.content.Intent;
import android.content.SharedPreferences;
import android.location.LocationListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.systemlife.nearbyplaces.Adapters.NearAdapter;
import com.example.systemlife.nearbyplaces.DataModels.NearModel;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

import static com.example.systemlife.nearbyplaces.SignUp.SHARED_PREF_NAME;

public class Search extends AppCompatActivity {
    private static final String TAG =Search.class.getName() ;
    ListView fav;
    ListView near;
    ImageView logout;
    ImageView favor;
    ImageView searsh;
    EditText searshTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Intent i = getIntent();
        Intent i2 = getIntent();
        Intent i3 = getIntent();

        fav = (ListView) findViewById(R.id.listView);
        near = (ListView) findViewById(R.id.near);

        logout = (ImageView) findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("email");
                editor.remove("password");
                editor.remove("birthdate");
                editor.remove("username");
                editor.apply();
                Intent intent = new Intent(Search.this, SingIn.class);
                startActivity(intent);
                finish();
            }
        });
        favor = (ImageView) findViewById(R.id.favor);
        favor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Search.this, Favorite.class);
                startActivity(intent);
            }
        });
        searshTxt = (EditText) findViewById(R.id.editText);
        searsh = (ImageView) findViewById(R.id.imageView2);
        searsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String type = searshTxt.getText().toString();
                String url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=-33.8670522,151.1957362&radius=500&type=" + type + "&keyword=cruise&key=AIzaSyA0lnpD55lQP6OE7UltnxNskewWcbfB4aE";
                executeWebService(url);
            }
        });
    }
    void executeWebService(String url) {
        Log.d(TAG, "executeWebService: "+url);
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("results");
                            Log.d("ooo", "onResponse: "+jsonArray);
                            final NearModel[] nearModels;
                            nearModels = new Gson().fromJson(jsonArray.toString(), NearModel[].class);
                            NearAdapter nearAdapter = new NearAdapter(Search.this, nearModels);
                            near.setAdapter(nearAdapter);
                            near.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                                    Intent intent = new Intent(Search.this, Details.class);
                                    intent.putExtra("nearModels", (Serializable) nearModels[i]);
                                    startActivity(intent);
                                    finish();
                                }
                            });
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Search.this, "that didn't work ", Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(stringRequest);
    }
}