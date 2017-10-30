package ws.wolfsoft.creative;

import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{

    TextView profile,balance,expense,income;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        profile= (TextView) findViewById(R.id.profile);
        profile.setOnClickListener(this);

        balance= (TextView) findViewById(R.id.balance);
        balance.setOnClickListener(this);

        expense= (TextView) findViewById(R.id.expense);
        expense.setOnClickListener(this);

        income= (TextView) findViewById(R.id.income);
        income.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {

        if(view==profile)
        {
            Intent i=new Intent(Main2Activity.this,My_profile.class);
            startActivity(i);
            finish();
        }
        else if(view==balance)
        {
            Intent i=new Intent(Main2Activity.this,Balance_sheet.class);
            startActivity(i);
            finish();
        }
        else if(view==expense)
        {
            Intent i=new Intent(Main2Activity.this,Expense.class);
            startActivity(i);
            finish();
         }
        else if(view==income)
        {
            Intent i=new Intent(Main2Activity.this,Income.class);
            startActivity(i);
            finish();
        }

    }

}
