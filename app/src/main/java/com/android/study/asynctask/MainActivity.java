package com.android.study.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //定义ProgressBar
    private ProgressBar pb_test;

    //定义文本控件
    private TextView tv_test;

    //定义按钮
    private Button btn_test;

    //定义创建AsyncTask的 ProgressAsyncTask子类对象
    private ProgressAsyncTask mProgressAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 初始化UI
        initUI();

        //点击事件
        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //定义对象 new 集成的子类，传入参数
                mProgressAsyncTask = new  ProgressAsyncTask(pb_test,tv_test);
                //调用 execute 方法
                mProgressAsyncTask.execute();
            }
        });
        
        
    }

    /**
     * 初始化UI
     */
    private void initUI() {
        pb_test = findViewById(R.id.pb_test);
        tv_test = findViewById(R.id.tv_test);
        btn_test = findViewById(R.id.btn_test);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //应用程序销毁时，关闭AsyncTask，防止内存泄漏
        mProgressAsyncTask.cancel(true);
    }
}
