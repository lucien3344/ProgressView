# ProgressView
ProgressView_v1.1

  用法如下：

 第一步： 在项目根目录下的build.gradle中添加如下代码：

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

 第二步：项目在app目录下的build.gradle中添加如下代码：

	dependencies {
	        implementation 'com.github.lucien3344:ProgressView:v1.1'
	}
  
  

 第三步：在xml中使用如下：

    //圆形进度
    <com.lucien3344.progress_view.widget.ProgressCircleView
        android:id="@+id/circleProgressBar"
        android:layout_width="230dp"
        android:layout_height="230dp"
        android:layout_centerInParent="true"
        android:layout_gravity="center_horizontal"
        android:layout_marginTop="15dp"
        android:visibility="visible"
        app:RoundColor="@color/color_line"
        app:RoundProgressColor="@color/toolbar"
        app:RoundText=""
        app:RoundTextColor="@color/black_8a"
        app:RoundTextSize="45sp"
        app:RoundWidth="17dp" />


      // 线形进度
      <com.lucien3344.progress_view.widget.ProgessLineView
          android:id="@+id/progresline_sys"
          android:layout_width="match_parent"
          android:layout_height="55dp"
          android:layout_gravity="center_horizontal"
          android:layout_marginTop="18dp"
          app:ProgressLine_RTextColor="@color/color_text"
          app:ProgressLine_RTextSize="15sp"
          app:ProgressLine_Text="说一说"
          app:ProgressLine_TextColor="@color/color_text"
          app:ProgressLine_TextSize="15sp"
          app:ProgressLine_bmColor="@color/color_line"
          app:ProgressLine_bmHight="13dp"
          app:ProgressLine_color="@color/toolbar"
          app:ProgressLine_hight="13dp" />

  
 第四步： 使用

        circleProgressBar.setDoProgress(56f, "分");
        progresline_sys.setDoProgress("说一说", 82.0f, "%");




