# WithBackgroundTextView
## 一、简介
* 支持textView背景色、边框、圆角度动态变更，减少drawable资源文件的生成


#### 2、使用
* 项目内加入 WithBackgroundTextView类
* attrs文件中加入
  <declare-styleable name="WithBackgroundTextView">
        <attr name="radius" format="dimension" />
        <attr name="withTopLeftRadius" format="dimension" />
        <attr name="withTopRightRadius" format="dimension" />
        <attr name="withBottomLeftRadius" format="dimension" />
        <attr name="withBottomRightRadius" format="dimension" />
        <attr name="withLeftRadius" format="dimension" />
        <attr name="withRightRadius" format="dimension" />
        <attr name="withBackgroundColor" format="color" />
        <attr name="withStrokeWidth" format="dimension" />
        <attr name="withStrokeColor" format="color" />

    </declare-styleable>
*


* xml

```
 <com.eastine.tutu.customerView.WithBackgroundTextView
        android:layout_width="match_parent"
        android:layout_height="44dp"
        android:layout_marginLeft="24dp"
        android:layout_marginRight="24dp"
        android:layout_marginTop="29dp"
        android:gravity="center"
        android:text="@string/tv_login"
        android:textColor="@color/red_F4253E"
        android:textSize="16dp"
        app:radius="22dp"
        app:withStrokeColor="@color/red_F4253E"
        app:withStrokeWidth="0.1dp" />

 对应属性请查看注解！  有任何问题可以邮件给我
```

#### 3、 作者
* eastine_tutu   邮箱：519510228@qq.com