# ProgressView_v1.4

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
	        implementation 'com.github.lucien3344:ProgressView:v1.4'
	}
  
  

 第三步：在xml中使用如下：

      <!--圆形进度--->
     <com.lucien3344.progress_view.widget.ProgressCircleView
            android:id="@+id/circleProgressBar"
            android:layout_width="230dp"
            android:layout_height="230dp"
            android:layout_centerInParent="true"
            android:layout_gravity="center_horizontal"
            android:layout_marginTop="15dp"
            android:visibility="visible"
            app:MaxProgress="100"
            app:Progress="0"
            app:RoundColor="@color/bmColor"
            app:RoundProgressColor="@color/color"
            app:RoundText=""
            app:RoundTextColor="@color/color_text"
            app:RoundTextSize="45sp"
            app:RoundWidth="17dp" />


     <!--线形进度 1--->
     <com.lucien3344.progress_view.widget.ProgessLineView
           android:id="@+id/progresline_sys"
           android:layout_width="match_parent"
           android:layout_height="55dp"
           android:layout_gravity="center_horizontal"
           android:layout_marginLeft="15dp"
           android:layout_marginRight="15dp"
           android:layout_marginTop="18dp"
           app:ProgressLine_MaxProgress="100"
           app:ProgressLine_Progress="0"
           app:ProgressLine_RText="0%"
           app:ProgressLine_RTextColor="@color/color_text"
           app:ProgressLine_RTextSize="15sp"
           app:ProgressLine_Text="说一说"
           app:ProgressLine_TextColor="@color/color_text"
           app:ProgressLine_TextSize="15sp"
           app:ProgressLine_bmColor="@color/bmColor"
           app:ProgressLine_bmHight="13dp"
           app:ProgressLine_color="@color/color"
           app:ProgressLine_hight="13dp" />

     <!--线形进度--->
     <com.lucien3344.progress_view.widget.ProgessLineView
           android:id="@+id/progresline_xyx"
           android:layout_width="match_parent"
           android:layout_height="55dp"
           android:layout_marginLeft="15dp"
           android:layout_marginRight="15dp"
           android:layout_marginTop="15dp"
           app:ProgressLine_MaxProgress="100"
           app:ProgressLine_Progress="0"
           app:ProgressLine_RText=""
           app:ProgressLine_RTextColor="@color/color_text"
           app:ProgressLine_RTextSize="15sp"
           app:ProgressLine_Text=""
           app:ProgressLine_TextColor="@color/color_text"
           app:ProgressLine_TextSize="15sp"
           app:ProgressLine_bmColor="@color/bmColor"
           app:ProgressLine_bmHight="13dp"
           app:ProgressLine_color="@color/color"
           app:ProgressLine_hight="13dp" />

  
 第四步： 使用

          circleProgressBar.setDoProgress(50f, "分")
          progresline_sys.setDoProgress("说一说", 80.0f, "%")
          progresline_xyx.setProgress(25.0f, "MB/100MB")


 效果图：

 ![ProgressView_v1.4](https://github.com/lucien3344/ProgressView/blob/16c77a86ab333c2685bc52b679484fe1b63ae369/sample_image.png)


 v1.4更新说明：       新增设置最大进度



 关于我：  邮箱：lsh_2012@qq.com


















