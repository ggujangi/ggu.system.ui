<h1 align="center">Control the System UI Visibility:penguin:</h1>

<p align="center">
  Let's practice how to control the System UI by referring to the 
  <b><a href="https://developer.android.com/training/system-ui" target="_blank">Android documentation</a></b>
  <br/><br/>
<img src="https://user-images.githubusercontent.com/25583321/72859909-ad9cf980-3d08-11ea-9e4b-789d1dc164d2.PNG" 
     width="520px" height="292.5px" href="https://github.com/ggujangi/ggu.system.ui/files/4094927/System.UI.Visibility.ppt.pptx"/>
</p>
<p align="center">
    👆👆
  <br/> <br/>
  <b>Download PPT</b> : https://github.com/ggujangi/ggu.system.ui/files/4094927/System.UI.Visibility.ppt.pptx
</p>


INDEX
-----
- Dimming the System Bars
- Hiding the Status Bar
- Hiding the Navigation Bar
- Using Immersive Full-Screen Mode

<br/>

## 1. Dimming the System Bars

![Dimming the System bars](https://user-images.githubusercontent.com/25583321/72768168-d2766b80-3c39-11ea-8a34-9b35e3a3938f.gif)

### 🍮Code
```Java
int mOption = View.SYSTEM_UI_FLAG_VISIBLE; // Default Flag

mOption = View.SYSTEM_UI_FLAG_LOW_PROFILE;
mDecorView.setSystemUiVisibility(mOption);
```

## 2. Hiding the Status Bar

- version 4.0 and Lower

![Hide The Status Bar (LOW)](https://user-images.githubusercontent.com/25583321/72768422-c63ede00-3c3a-11ea-9346-7cc2b7422556.gif)

### 🍮Code
```Java
getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                      WindowManager.LayoutParams.FLAG_FULLSCREEN);
```


- version 4.1 and higher

![Hide The Status Bar (HIGH)](https://user-images.githubusercontent.com/25583321/72768445-d5259080-3c3a-11ea-95ca-a70c3f4d409c.gif)

### 🍮Code
```Java
int mOption = View.SYSTEM_UI_FLAG_VISIBLE; // Default Flag

mOption = View.SYSTEM_UI_FLAG_FULLSCREEN;
mDecorView.setSystemUiVisibility(mOption);
```


<br/>

## 3. Hiding the Navigation Bar

- only navigation

![Hide The Navigation Bar](https://user-images.githubusercontent.com/25583321/72768382-95f73f80-3c3a-11ea-96ad-a9a4598c7426.gif)

### 🍮Code
```Java
int mOption = View.SYSTEM_UI_FLAG_VISIBLE; // Default Flag

mOption = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
mDecorView.setSystemUiVisibility(mOption);
```

- navigation and status bar<br/>

![Hiding the Navigation Bar both](https://user-images.githubusercontent.com/25583321/72768388-9ee81100-3c3a-11ea-849e-0b7929a68ba9.gif)<br/>
This works the same as [Lean Back](https://developer.android.com/training/system-ui/immersive.html#leanback)

### 🍮Code
```Java
int mOption = View.SYSTEM_UI_FLAG_VISIBLE; // Default Flag

mOption = SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN
mDecorView.setSystemUiVisibility(mOption);
```

<br/>

## 4. Using Immersive Full-Screen Mode

- [Lean Back](https://developer.android.com/training/system-ui/immersive.html#leanback)

![Immersive_Leanback](https://user-images.githubusercontent.com/25583321/72768522-000fe480-3c3b-11ea-9887-0f8c2490e59f.gif)

### 🍮Code
```Java
int mOption = View.SYSTEM_UI_FLAG_VISIBLE; // Default Flag

mOption = SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN
mDecorView.setSystemUiVisibility(mOption);
```

- [Immersive](https://developer.android.com/training/system-ui/immersive.html#immersive)

![Immersive](https://user-images.githubusercontent.com/25583321/72768503-f2f2f580-3c3a-11ea-9b35-de79a33541cd.gif)

### 🍮Code
```Java
int mOption = View.SYSTEM_UI_FLAG_VISIBLE; // Default Flag

mOption = View.SYSTEM_UI_FLAG_IMMERSIVE
          | View.SYSTEM_UI_FLAG_FULLSCREEN
          | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
mDecorView.setSystemUiVisibility(mOption);
```

- [Sticky Immersive](https://developer.android.com/training/system-ui/immersive.html#sticky-immersive)

![Immersive_sticky](https://user-images.githubusercontent.com/25583321/72768530-0736f280-3c3b-11ea-9cef-45a2e6906915.gif)

```Java
int mOption = View.SYSTEM_UI_FLAG_VISIBLE; // Default Flag

mOption = View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
          | View.SYSTEM_UI_FLAG_FULLSCREEN
          | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
mDecorView.setSystemUiVisibility(mOption);
```

