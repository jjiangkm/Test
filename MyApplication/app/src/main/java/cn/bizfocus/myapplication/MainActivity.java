package cn.bizfocus.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Runnable {
    private static final int INTERVAL = 150;
    private ImageView iv_computer;
    private Random r = new Random();
    private int computer = 0;
    private Handler mHandler = new Handler() ;

    /**
     * 石头
     */
    private Button mBtn0;
    /**
     * 剪刀
     */
    private Button mBtn1;
    /**
     * 布
     */
    private Button mBtn2;
    private ImageView mIvPerson;
    private LinearLayout mActivityMain;
    private Button btn_reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mHandler.postDelayed(this,INTERVAL);

    }

    private int getPictureRes(int i) {
        if (i == 0) {
            return R.mipmap.icon_0;
        } else if (i == 1) {
            return R.mipmap.icon_1;
        } else if (i == 2) {
            return R.mipmap.icon_2;
        } else {
            throw new RuntimeException("");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacks(this);
    }

    private void initView() {
        mBtn0 = (Button) findViewById(R.id.btn_0);
        mBtn1 = (Button) findViewById(R.id.btn_1);
        mBtn2 = (Button) findViewById(R.id.btn_2);
        mIvPerson = (ImageView) findViewById(R.id.iv_person);
        mActivityMain = (LinearLayout) findViewById(R.id.activity_main);
        iv_computer = (ImageView) findViewById(R.id.iv_computer);
        btn_reset = (Button)findViewById(R.id.btn_reset);
        btn_reset.setOnClickListener(this);
        mBtn0.setOnClickListener(this);
        mBtn1.setOnClickListener(this);
        mBtn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        mHandler.removeCallbacks(this);
        computer = r.nextInt(3);
        iv_computer.setImageResource(getPictureRes(computer));
        int id = v.getId();
        switch(id){
            case R.id.btn_0:
                mIvPerson.setImageResource(getPictureRes(0));
                break;
            case R.id.btn_1:
                mIvPerson.setImageResource(getPictureRes(1));
                break;
            case R.id.btn_2:
                mIvPerson.setImageResource(getPictureRes(2));
                break;
            case R.id.btn_reset:
                mIvPerson.setImageResource(R.mipmap.ic_launcher);
                mHandler.postDelayed(this,INTERVAL);
                break;
        }
    }

    @Override
    public void run() {
        computer = r.nextInt(3);
        iv_computer.setImageResource(getPictureRes(computer));
        mHandler.postDelayed(this,INTERVAL);
    }
}
