package com.example.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main3Activity extends AppCompatActivity {
    String nama, email, alamat,nohp;
    private RecyclerView recyclerView;
    private JsonAdapter adapter;
    private KontakAdapter kontakAdapter;
    private ArrayList<Kontak> kontakArrayList;
    private Button btnSaveData;
    public EditText txtInputNama,txtInputEmail,txtInputAlamat,txtInputNohp;
    private BufferedReader reader = null;
    private HttpURLConnection connection = null;
    ProgressDialog progressDialog;
    //SwipeRefreshLayout mSwipeRefreshLayout;
    RequestQueue rq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        //mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeContainer2);
        btnSaveData = (Button) findViewById(R.id.btnSaveData);
        txtInputNama = (EditText)findViewById(R.id.txtInputNama);
        txtInputEmail = (EditText)findViewById(R.id.txtInputEmail);
        txtInputAlamat = (EditText)findViewById(R.id.txtInputAlamat);
        txtInputNohp = (EditText)findViewById(R.id.txtInputNohp);
        rq = Volley.newRequestQueue(this);

        btnSaveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpanKontak();

            }
        });

    }

    public void simpanKontak(){
        progressDialog = new ProgressDialog(Main3Activity.this);
        progressDialog.setMessage("Please wait");
        progressDialog.setCancelable(false);
        progressDialog.show();
        JSONObject params = new JSONObject();
        try{
            params.put("nama",txtInputNama.getText().toString());
            params.put("email",txtInputEmail.getText().toString());
            params.put("nohp",txtInputAlamat.getText().toString());
            params.put("alamat",txtInputNohp.getText().toString());
            } catch(JSONException e){
            e.printStackTrace();
        }
        String url = "http://210.210.154.65/api/kontak/store";
        JsonObjectRequest req =new JsonObjectRequest(Request.Method.POST,url,params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    Toast.makeText( Main3Activity.this,response.getString("message"),Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                progressDialog.dismiss();
            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
            }
        });
        rq.add(req);
    }

    public void ngirimIntent(View v){

        Intent chat = new Intent(this, Main2Activity.class);
        Bundle data = new Bundle();
        chat.putExtras(data);
        startActivity(chat);
    }
}
