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
---------

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

 
