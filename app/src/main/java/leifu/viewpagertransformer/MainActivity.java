package leifu.viewpagertransformer;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import leifu.viewpagertransfomerlibrary.transformer.AccordionPageTransformer;
import leifu.viewpagertransfomerlibrary.transformer.AlphaPageTransformer;
import leifu.viewpagertransfomerlibrary.transformer.CubePageTransformer;
import leifu.viewpagertransfomerlibrary.transformer.DepthPageTransformer;
import leifu.viewpagertransfomerlibrary.transformer.FadePageTransformer;
import leifu.viewpagertransfomerlibrary.transformer.FlipPageTransformer;
import leifu.viewpagertransfomerlibrary.transformer.RotatePageTransformer;
import leifu.viewpagertransfomerlibrary.transformer.ZoomCenterPageTransformer;
import leifu.viewpagertransfomerlibrary.transformer.ZoomFadePageTransformer;
import leifu.viewpagertransfomerlibrary.transformer.ZoomOutPagerTransformer;
import leifu.viewpagertransfomerlibrary.transformer.ZoomPageTransformer;


public class MainActivity extends AppCompatActivity {

    private ViewPager banner_main_Multiple, banner_main_ZoomOut, banner_main_alpha,banner_main_rotate,banner_main_cube,
            banner_main_accordion,banner_main_flip,banner_main_depth,banner_main_fade,banner_main_zoomFade
            ,banner_main_zoomCenter,banner_main_zoom;


    int arrayImgs[] = {R.mipmap.image1, R.mipmap.image2, R.mipmap.image3, R.mipmap.image4, R.mipmap.image5};


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        banner_main_Multiple = (ViewPager) findViewById(R.id.banner_main_Multiple);
        banner_main_ZoomOut = (ViewPager) findViewById(R.id.banner_main_ZoomOut);
        banner_main_alpha = (ViewPager) findViewById(R.id.banner_main_alpha);
        banner_main_rotate = (ViewPager) findViewById(R.id.banner_main_rotate);
        banner_main_cube = (ViewPager) findViewById(R.id.banner_main_cube);
        banner_main_accordion = (ViewPager) findViewById(R.id.banner_main_accordion);
        banner_main_flip = (ViewPager) findViewById(R.id.banner_main_flip);
        banner_main_depth = (ViewPager) findViewById(R.id.banner_main_depth);
        banner_main_fade = (ViewPager) findViewById(R.id.banner_main_fade);
        banner_main_zoomFade = (ViewPager) findViewById(R.id.banner_main_zoomFade);

        banner_main_zoomCenter = (ViewPager) findViewById(R.id.banner_main_zoomCenter);
        banner_main_zoom = (ViewPager) findViewById(R.id.banner_main_zoom);
        //处理只能点击中间范围viewpage才能滑动,点击左右两边的viewpage也可以滑动,注意要设置LinearLayout的clickable="true"
        findViewById(R.id.ll_Multiple).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                banner_main_Multiple.onTouchEvent(event);
                return false;
            }
        });
        //一屏显示多个子页面
        banner_main_Multiple.setPageMargin(DensityUtil.dip2px(getApplicationContext(), 10));//设置viewpage两个页面间距
        banner_main_Multiple.setOffscreenPageLimit(3);//提前预加载3个,数量最好大于3个
        banner_main_Multiple.setAdapter(new ViewPagerAdpter(getData()));

        //画廊展示效果
        banner_main_ZoomOut.setPageMargin(-DensityUtil.dip2px(getApplicationContext(), 10));//设置viewpage两个页面间距,要使间距变小请设置负值或者在Adpter中重写getPageWidth
        banner_main_ZoomOut.setOffscreenPageLimit(3);//提前预加载3个,数量最好大于3个
        banner_main_ZoomOut.setPageTransformer(false, new ZoomOutPagerTransformer(0.7f));
        banner_main_ZoomOut.setAdapter(new ViewPagerAdpter(getData()));
        //渐变
        banner_main_alpha.setPageTransformer(false, new AlphaPageTransformer(0.2f));
        banner_main_alpha.setAdapter(new ViewPagerAdpter(getData()));
        //旋转
        banner_main_rotate.setPageTransformer(false, new RotatePageTransformer());
        banner_main_rotate.setAdapter(new ViewPagerAdpter(getData()));
        //立方体
        banner_main_cube.setPageTransformer(false, new CubePageTransformer());
        banner_main_cube.setAdapter(new ViewPagerAdpter(getData()));
        //可折叠的
        banner_main_accordion.setPageTransformer(false, new AccordionPageTransformer());
        banner_main_accordion.setAdapter(new ViewPagerAdpter(getData()));

        //急速
        banner_main_flip.setPageTransformer(false, new FlipPageTransformer());
        banner_main_flip.setAdapter(new ViewPagerAdpter(getData()));

        //前背景和后背景渐变,后背景有个放大缩小效果
        banner_main_depth.setPageTransformer(false, new DepthPageTransformer());
        banner_main_depth.setAdapter(new ViewPagerAdpter(getData()));

        //前背景和后背景渐变
        banner_main_fade.setPageTransformer(false, new FadePageTransformer());
        banner_main_fade.setAdapter(new ViewPagerAdpter(getData()));

        //前背景和后背景缩放并渐变
        banner_main_zoomFade.setPageTransformer(false, new ZoomFadePageTransformer());
        banner_main_zoomFade.setAdapter(new ViewPagerAdpter(getData()));

        //前背景和后背景直接缩放
        banner_main_zoomCenter.setPageTransformer(false, new ZoomCenterPageTransformer());
        banner_main_zoomCenter.setAdapter(new ViewPagerAdpter(getData()));
        //左右滑动缩放
        banner_main_zoom.setPageTransformer(false, new ZoomPageTransformer());
        banner_main_zoom.setAdapter(new ViewPagerAdpter(getData()));
    }

    private List<ImageView> getData() {
        List<ImageView> imgList = new ArrayList<>();
        for (int i = 0; i < arrayImgs.length; i++) {
            ImageView imageView = new ImageView(getApplicationContext());
            imageView.setImageResource(arrayImgs[i]);
            imgList.add(imageView);
        }
        return imgList;
    }


}
