package cn.bizfocus.myapplication;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private int[] imageRes = {R.mipmap.p1,R.mipmap.p2,R.mipmap.p3,R.mipmap.p4,R.mipmap.p5};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        ImageView[] imageViews = new ImageView[5];
        for (int i = 0;i<5;i++){
            imageViews[i] = new ImageView(this);
            imageViews[i].setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageViews[i].setImageResource(imageRes[i]);
        }
        vp.setAdapter(new MyAdapter(imageViews));
    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
    }

    private class MyAdapter extends PagerAdapter {
        private final ImageView[] imageViews;

        public MyAdapter(ImageView[] imageViews) {
            this.imageViews = imageViews;
        }

        @Override
        public int getCount() {
            return imageViews.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = imageViews[position];
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
