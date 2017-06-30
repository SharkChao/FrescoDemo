package com.lenovohit.administrator.frescodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.lenovohit.administrator.frescodemo.R.id.btn1;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(btn1)
     Button button1;
    @BindView(R.id.btn2)
    Button button2;
    @BindView(R.id.btn3)
    Button button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
                DetailActivity.startDetailActivity(MainActivity.this,0);
                break;
            case R.id.btn2:
                DetailActivity.startDetailActivity(MainActivity.this,1);
                break;
            case R.id.btn3:
                DetailActivity.startDetailActivity(MainActivity.this,2);
                break;
        }
    }
}
