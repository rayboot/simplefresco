package com.rayboot.simplefresco;

import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.facebook.common.util.UriUtil;
import com.facebook.drawee.view.SimpleDraweeView;
import com.rayboot.fresco.builder.RFresco;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    SimpleDraweeView imageview1;
    SimpleDraweeView imageview;
    String imageUrl = "http://www.timeface.cn/uploads/times/2015/06/12/15/5028_vUxHRl.jpg";
    int imageRes = R.drawable.test;
    String imageFile = "/mnt/sdcard/1.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RFresco.init(this, ImagePipelineConfigFactory.getImagePipelineConfig(this));
        setContentView(R.layout.activity_main);

        imageview = (SimpleDraweeView) findViewById(R.id.imageview);
        imageview1 = (SimpleDraweeView) findViewById(R.id.imageview1);

//        imageview1.setImageURI(Uri.parse("res://" + imageRes));

        RFresco.load(imageRes)
                .centerInside()
                .circle()
                .into(imageview);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
