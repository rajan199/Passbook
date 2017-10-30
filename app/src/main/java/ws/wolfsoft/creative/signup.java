package ws.wolfsoft.creative;

import android.app.ProgressDialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;

import static android.R.string.no;

public class signup extends AppCompatActivity {

    TextView signinhere, signup2,signup1;
    ProgressDialog pDialog;
    EditText mobile, otp;
    Typeface fonts1;
    Sesion s;
    String mob, otp1,val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        s=new Sesion(getApplicationContext());
        signinhere = (TextView) findViewById(R.id.signinhere);

        pDialog=new ProgressDialog(signup.this);
        mobile = (EditText) findViewById(R.id.mobile);

        signup1 = (TextView) findViewById(R.id.signup1);

        otp = (EditText) findViewById(R.id.otp);
        signup2 = (TextView) findViewById(R.id.signup2);

        otp.setVisibility(View.INVISIBLE);
        signup2.setVisibility(View.INVISIBLE);
        signup1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mobile.setVisibility(View.INVISIBLE);
                signup1.setVisibility(View.INVISIBLE);
                otp.setVisibility(View.VISIBLE);
                signup2.setVisibility(View.VISIBLE);
                mob = mobile.getText().toString().trim();


                int randomPIN = (int) (Math.random() * 9000) + 1000;
                 val = randomPIN + "";

                s.set_Otp("1234");
               /* pDialog.setMessage("Loading...");
                pDialog.setCancelable(false);
                pDialog.show();
                String url = "https://control.msg91.com/api/sendhttp.php?authkey=180812A6KwIJEPu659f182e0&mobiles="+mob+"&message=OTP"+val+"&sender=ABCDEF&route=4&country=0";

*//*
                String url = "https://control.msg91.com/api/sendhttp.php?authkey=175689ARSL8HDM9mT59c34f9d&mobiles="+no+"&message=Your Otp for verification is "+val+"&sender=ABCDEF&route=4&country=0";
*//*

                Log.d("msg", url);
                StringRequest sr = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("abc", response);
                        pDialog.dismiss();
                        Toast.makeText(signup.this, response, Toast.LENGTH_SHORT).show();
                *//*try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("server_responce");
                    JSONObject jsonObject1 = jsonArray.getJSONObject(0);
                    String status = jsonObject1.getString("status");
                    String message = jsonObject1.getString("message");
                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                    if (status.equals("1")) {
                        Constant.fragment = 5;
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }*//*
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        pDialog.dismiss();
                        Toast.makeText(getApplicationContext(), "Please try again...", Toast.LENGTH_SHORT).show();
                        VolleyLog.d("abc", "Error: " + error.getMessage());
                        Log.d("abc", "" + error.getMessage() + "," + error.toString());
                    }
                });

                sr.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
                AppController.getInstance().addToRequestQueue(sr);*/
            }


        });


        signup2.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View view) {

                    otp1=otp.getText().toString().trim();

                if(otp1.equals(s.get_Otp()))
                {
                    Intent i=new Intent(signup.this,Main2Activity.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(signup.this, "Not a valid mobile number", Toast.LENGTH_SHORT).show();
                }
                   }
        });

    }
}

