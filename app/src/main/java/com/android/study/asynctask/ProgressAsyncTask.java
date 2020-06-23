package com.android.study.asynctask;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProgressAsyncTask extends AsyncTask<Void,Integer,Boolean> {

    //定义进度条控件
    private ProgressBar pb_test;

    //定义文本控件
    private TextView tv_test;

    public ProgressAsyncTask(ProgressBar pb_test,TextView tv_test){
        super();
        this.pb_test = pb_test;
        this.tv_test = tv_test;
    }

    /**
     * 这个方法会在后台任务开始执行之间调用，用于进行一些界面上的初始化操作，
     * 比如显示一个进度条对话框等。
     *
     * 不要手动调用
     */
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }



    @Override
    protected Boolean doInBackground(Void... voids) {
      for(int i=0;i<100;i++){
          try{
              //耗时模拟操作
              Thread.sleep(100);
              publishProgress(i);
          } catch (InterruptedException e) {
              e.printStackTrace();
              return  false;
          }
      }
      return true ;
    }


    /**
     * 当在后台任务中调用了publishProgress(Progress...)方法后，这个方法就很快会被调用，
     * 方法中携带的参数就是在后台任务中传递过来的。在这个方法中可以对UI进行操作，利用参
     * 数中的数值就可以对界面元素进行相应的更新。
     */

    @Override
    protected void onProgressUpdate(Integer... values) {
        int value = values[0];
        pb_test.setProgress(value);
        tv_test.setText(value+"");
    }


    /**
     * 当后台任务执行完毕并通过return语句进行返回时，这个方法就很快会被调用。返回的数据
     * 会作为参数传递到此方法中，可以利用返回的数据来进行一些UI操作，比如说提醒任务执行
     * 的结果，以及关闭掉进度条对话框等。
     */
    @Override
    protected void onPostExecute(Boolean aBoolean) {
        tv_test.setText("进度条加载完毕！");
    }

}
