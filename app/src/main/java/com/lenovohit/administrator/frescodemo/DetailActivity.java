package com.lenovohit.administrator.frescodemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by Administrator on 2017-06-30.
 */

public class DetailActivity extends Activity {
    SimpleDraweeView view;
    private Uri imageUri;
    private Uri errorUri;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_detail);
        initView();

    }
    public void initView(){
        view= (SimpleDraweeView) findViewById(R.id.view);
        imageUri = Uri.parse("https://y.gtimg.cn/music/photo_new/T002R300x300M000002qBBpu2q0vL3.jpg?max_age=2592000");
        errorUri = Uri.parse("https://y.gtnnmg");
        int index = getIntent().getIntExtra("index",0);
        setFrecso(index);
    }
    public void setFrecso(int index){
        switch (index){
            case 0:
                view.setImageURI(imageUri);
                break;
            case 1:
                view.setImageURI(errorUri);
                break;
            case 2:
                AbstractDraweeController build = Fresco.newDraweeControllerBuilder().setUri(errorUri).setTapToRetryEnabled(true)
                        .setOldController(view.getController()).build();
                view.setController(build);
                break;
        }
    }
    public static void startDetailActivity(Context context,int index){
        Intent intent=new Intent(context,DetailActivity.class);
        intent.putExtra("index",index);
        context.startActivity(new Intent(context,DetailActivity.class));
    }
}
