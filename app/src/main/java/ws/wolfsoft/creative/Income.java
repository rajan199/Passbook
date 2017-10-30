package ws.wolfsoft.creative;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class Income extends AppCompatActivity {


    EditText in_title,in_amt;
    TextView Add,home;

    String amt_title,amt;
    ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);

        pDialog=new ProgressDialog(Income.this);

        in_title= (EditText) findViewById(R.id.in_title);
        in_amt= (EditText) findViewById(R.id.in_amt);
        Add= (TextView) findViewById(R.id.Add);
        home= (TextView) findViewById(R.id.Home);

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                amt_title=in_title.getText().toString().trim();
                amt=in_amt.getText().toString().trim();
                call_api();

            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Income.this,Main2Activity.class);
                startActivity(i);
                finish();
            }
        });


    }

    @Override
    public void onBackPressed() {

    }

    private void call_api() {
        pDialog.show();



        String url = "http://uniquedesign.in/riddhistudent/karan/register.php/Add_income";
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
                Toast.makeText(Income.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
                params.put("income_title",amt_title );

                params.put("income_amt",amt );

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
