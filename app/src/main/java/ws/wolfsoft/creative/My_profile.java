package ws.wolfsoft.creative;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class My_profile extends AppCompatActivity {

    EditText uname,email,pass,mob;
    TextView update,home;

    String uname1,email1,pass1,mob1;
    ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        pDialog=new ProgressDialog(My_profile.this);
        uname= (EditText) findViewById(R.id.uname);
        email= (EditText) findViewById(R.id.email);
        pass= (EditText) findViewById(R.id.pass);
        mob= (EditText) findViewById(R.id.mob);

        update= (TextView) findViewById(R.id.update);
        home= (TextView) findViewById(R.id.home);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                uname1=uname.getText().toString().trim();
                email1=email.getText().toString().trim();
                pass1=pass.getText().toString().trim();
                mob1=mob.getText().toString().trim();

                call_api();

            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(My_profile.this,Main2Activity.class);
                startActivity(i);
                finish();
            }
        });
    }


    private void call_api() {
        pDialog.show();



        String url = "http://uniquedesign.in/riddhistudent/karan/register.php/Add_users";
        StringRequest strReq = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("i",response);
                pDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                pDialog.dismiss();
                Toast.makeText(My_profile.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                VolleyLog.d("i", "Error: " + error.getMessage());
                Log.d("i", "Error: " + error.getMessage());
            }
        }){
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();


             /*   params.put("email_id", "masummodi@gmail.com");
                params.put("pin", "8890");
                params.put("otp", "5522");
                params.put("msg", "hello");
             */
                params.put("user_name",uname1 );

                params.put("email_id",email1 );
                params.put("pin", pass1);
                params.put("mobile", mob1);

                return params;
            }
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/x-www-form-urlencoded");

                headers.put("Authorization", "Basic YWRtaW46MTIz");
                return headers;
            }
        };
        AppController.getInstance().addToRequestQueue(strReq);
    }


}
