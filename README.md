# ProgressView
ProgressView_v1.1



Step 1. Add the JitPack repository to your build file

gradle

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.lucien3344:ProgressView:v1.1'
	}
  
  

  用法如下：


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

  

        circleProgressBar.setProgress(56f, "分");
        progresline_sys.setDoProgress("说一说", 82.0f, "%");