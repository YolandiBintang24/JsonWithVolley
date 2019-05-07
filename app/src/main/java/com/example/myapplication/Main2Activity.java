package com.example.myapplication;

import android.app.ProgressDialog;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    String id, name, email, alamat,nohp;
    private RecyclerView recyclerView;
    private JsonAdapter adapter;
    private KontakAdapter kontakAdapter;
    private ArrayList<Kontak> kontakArrayList;
    private Button btnGetData;
    private BufferedReader reader = null;
    private HttpURLConnection connection = null;
    ProgressDialog progressDialog;
    SwipeRefreshLayout mSwipeRefreshLayout;
    RequestQueue rq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view2);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeContainer2);
        btnGetData = (Button) findViewById(R.id.btnGetData2);
        rq = Volley.newRequestQueue(this);


        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                makeJsonObjectRequest();
            }
        });

        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeJsonObjectRequest();
            }
        });

    }

    public void makeJsonObjectRequest() {
        progressDialog = new ProgressDialog(Main2Activity.this);
        progressDialog.setMessage("Please wait");
        progressDialog.setCancelable(false);
        progressDialog.show();
        String reqUrl = "http://210.210.154.65/MyProject/public/kontak";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, reqUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                kontakArrayList = new ArrayList<>();
                try {
                    JSONArray values = response.getJSONArray("values");
                    for (int i = 0; i < values.length(); i++) {
                        JSONObject user = values.getJSONObject(i);
                        id = user.getString("id");
                        name = user.getString("nama");
                        email = user.getString("email");
                        alamat = user.getString("alamat");
                        nohp = user.getString("nohp");


                        kontakArrayList.add(new Kontak(id, name, email,alamat,nohp));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                mSwipeRefreshLayout.setRefreshing(false);
                progressDialog.dismiss();

                kontakAdapter = new KontakAdapter(kontakArrayList);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Main2Activity.this);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(kontakAdapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mSwipeRefreshLayout.setRefreshing(false);
                progressDialog.dismiss();

                Log.i("Volley error : ", String.valueOf(error));
            }
        });

        rq.add(jsonObjectRequest);
    }


    }
