# Viewpager各种效果

#### 效果图
![](https://github.com/leifu1107/ViewpagerTransformer/raw/master/art/1.gif) 
![](https://github.com/leifu1107/ViewpagerTransformer/raw/master/art/2.gif) 
![](https://github.com/leifu1107/ViewpagerTransformer/raw/master/art/3.gif) 
![](https://github.com/leifu1107/ViewpagerTransformer/raw/master/art/4.gif) 
![](https://github.com/leifu1107/ViewpagerTransformer/raw/master/art/5.gif) 
---------
## 自定义的ViewpagerTransformer说明
|动画|类	
|---|---|	
|基类| BasePageTransformer	
|渐变| AlphaPageTransformer	
|旋转| RotatePageTransformer
|立方体| CubePageTransformer	
|可折叠的| AccordionPageTransformer	
|急速| FlipPageTransformer
|前背景和后背景渐变,后背景有个放大缩小效果| DepthPageTransformer	
|前背景和后背景渐变| ZoomFadePageTransformer	
|前背景和后背景直接缩放| ZoomCenterPageTransformer
|左右滑动缩放| ZoomPageTransformer
|画廊展示效果| ZoomOutPagerTransformer

---------
## 使用步骤

#### Step 1.添加依赖<br>
项目的 build.gradle 添加
```java
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  ```
 /app/build.gradle
  ```java
  	dependencies {
	        compile 'com.github.leifu1107:ViewpagerTransformer:V1.0'
	}
```
#### Step 2.在布局文件中添加ViewPager<br>
```java
<android.support.v4.view.ViewPager
            android:id="@+id/banner_main_cube"
            android:layout_width="match_parent"
            android:layout_height="120dp"/>
```
#### Step 3.在Activity中直接调用setPageTransformer方法即可(一屏显示多个子页面\画廊效果不适合,还需要增加代码)<br>
```java	    
  //立方体效果
  banner_main_cube.setPageTransformer(false, new CubePageTransformer());//也可自定义动画范围大小new CubePageTransformer(90f)
  banner_main_cube.setAdapter(new ViewPagerAdpter(getData()));
```
#### Step 4.一屏显示多个子页面和画廊效果需要额外配置<br>

布局文件(ViewPager和父布局都需要添加clipChildren="false")
```java

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:clickable="true"
            android:clipChildren="false">

            <android.support.v4.view.ViewPager
                android:id="@+id/banner_main_ZoomOut"
                android:layout_width="match_parent"
                android:layout_height="120dp"
                android:layout_marginLeft="80dp"
                android:layout_marginRight="80dp"
                android:clipChildren="false"
                />
        </LinearLayout>
```
Activity中代码(setPageMargin设置负值边距才能调整合适)
```java
 //画廊展示效果
        banner_main_ZoomOut.setPageMargin(-DensityUtil.dip2px(getApplicationContext(), 10));//设置viewpage两个页面间距,要使间距变小请设置负值或者在Adpter中重写getPageWidth
        banner_main_ZoomOut.setOffscreenPageLimit(3);//提前预加载3个,数量最好大于3个
        banner_main_ZoomOut.setPageTransformer(false, new ZoomOutPagerTransformer(0.7f));
        banner_main_ZoomOut.setAdapter(new ViewPagerAdpter(getData()));
```

##### 一屏显示3个页面后,viewpager滚动活动中间的页面才能左右滑动,滑动左右两边的页面没有效果(可通过事件分发处理)
##### ll_Multiple为ViewPager的父布局,不要忘记父布局添加clickable="true"
```java
//处理只能点击中间范围viewpage才能滑动,点击左右两边的viewpage也可以滑动,注意要设置LinearLayout的clickable="true"
        findViewById(R.id.ll_Multiple).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                banner_main_Multiple.onTouchEvent(event);
                return false;
            }
        });
```
 ## APK文件

扫描二维码 或者 点击二维码 下载

[![ViewpagerTransformer](https://github.com/leifu1107/ViewpagerTransformer/raw/master/art/zrcode.png)](https://github.com/leifu1107/ViewpagerTransformer/raw/master/art/app-release.apk)
