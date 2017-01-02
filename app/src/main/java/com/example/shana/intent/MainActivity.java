package com.example.shana.intent;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et_url,et_phone;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_url= (EditText) findViewById(R.id.url);
        et_phone= (EditText) findViewById(R.id.phone);
        textView= (TextView) findViewById(R.id.textView);
    }

    public void componentname(View v){
        ComponentName componentName=new ComponentName(this,Main2Activity.class);
        Intent i1=new Intent();
        i1.setComponent(componentName);
        startActivity(i1);
    }

    public void  intentfiter(View v){
        String action="com.edu.shana";
        Intent i2=new Intent();
        i2.setAction(action);
        startActivity(i2);
    }
    public void view(View v){
        Intent i3=new Intent();
        i3.setAction(Intent.ACTION_VIEW);
        Uri uri= Uri.parse(et_url.getText().toString());
        i3.setData(uri);
        startActivity(i3);
    }
    public void dial(View v){
        Intent i3=new Intent();
        Uri uri= Uri.parse("tel:"+et_phone.getText().toString());
        i3.setData(uri);
        startActivity(i3);
    }

    public void startActivityForResult(View v){
        Bundle bundle=new Bundle();
        bundle.putString("value",et_url.getText().toString());
        Intent intent=new Intent(MainActivity.this,Main2Activity.class);
        intent.putExtras(bundle);
        startActivityForResult(intent,10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 10:
                Bundle bundle=data.getExtras();
                textView.setText(bundle.getString("result"));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
