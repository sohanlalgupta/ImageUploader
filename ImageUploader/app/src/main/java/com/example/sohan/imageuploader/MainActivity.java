package com.example.sohan.imageuploader;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.cloudinary.Cloudinary;
import com.cloudinary.Url;

import org.getmyparking.adapter.GridViewAdapter;
import org.getmyparking.model.ImageModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class MainActivity extends Activity {

    private static final String TAG="MainActivity";
    private  final int SELECT_IMAGE=1;
    private RecyclerView mImageRecylerView;
    private GridViewAdapter mGridViewAdapter;
    private List<ImageModel> mImageList;
    private FloatingActionButton plusButton;
    ExecutorService executor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageList=  new ArrayList<ImageModel>();
        mGridViewAdapter= new GridViewAdapter(this,mImageList);
        plusButton=(FloatingActionButton)findViewById(R.id.fab);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,3);
        mImageRecylerView=(RecyclerView)findViewById(R.id.image_recyler_view);
        mImageRecylerView.setLayoutManager(gridLayoutManager);
       executor = Executors.newFixedThreadPool(5);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);//
                startActivityForResult(Intent.createChooser(intent, "Select Picture"),SELECT_IMAGE);
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d(TAG, "requestCode:" + requestCode + " resultCode:" + resultCode);
        if (resultCode == RESULT_OK && requestCode == SELECT_IMAGE) {
            if (data != null) {
                executor.execute(new ImageUploader(data));


                if (mImageRecylerView != null && mImageRecylerView.getAdapter() != null) {
                    mImageRecylerView.notify();
                }

            }
        }
    }




}
