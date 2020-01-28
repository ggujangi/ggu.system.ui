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

<br/>

INDEX
-----
- Dimming the System Bars
- Hiding the Status Bar
- Hiding the Navigation Bar
- Using Immersive Full-Screen Mode

<br/>

## 1. Dimming the System Bars

<img align="right" src="https://user-images.githubusercontent.com/25583321/72768168-d2766b80-3c39-11ea-8a34-9b35e3a3938f.gif"/>

### Dim the Status and Navigation Bars
- Available in Android 4.0 (API level 14) and higher
- You can dim the status and notification bars using the `SYSTEM_UI_FLAG_LOW_PROFILE` flag
- As soon as the user touches the status or navigation bar, the flag is cleared

### Reveal the Status and Navigation Bars
- Calling `setSystemUiVisibility()` with `SYSTEM_UI_FLAG_VISIBLE` flag clears all flags
- As soon as the user touches the status or navigation bar, the flag is cleared

```Java
View mDecorView = getActivity().getWindow().getDecorView();
int mOption = View.SYSTEM_UI_FLAG_LOW_PROFILE;
mDecorView.setSystemUiVisibility(mOption);
// clear all flags
mDecorView.setSystemUiVisibility(SYSTEM_UI_FLAG_VISIBLE);
```
<br/>

## 2. Hiding the Status Bar

### Hide the Status Bar on Android 4.0 and Lower

<img align="right" src="https://user-images.githubusercontent.com/25583321/72768422-c63ede00-3c3a-11ea-9346-7cc2b7422556.gif"/>

- #### Setting an activity theme
``` xml
  <application
    ...
    android:theme="@android:style/Theme.Holo.NoActionBar.Fullscreen">
    ...
  </application>
```

- #### Setting `WindowManager` flags
  - When you set `WindowManager` flags, the flags remain in effect unless your app clears them
  - You can use `FLAG_LAYOUT_IN_SCREEN` to set your activity layout to use the same screen area that's available when you've enabled `FLAG_FULL_SCREEN`
  
```Java
  getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
```

<br/>
 

### Hide the Status Bar on Android 4.1 and Higher

<img align="right" src="https://user-images.githubusercontent.com/25583321/72768445-d5259080-3c3a-11ea-95ca-a70c3f4d409c.gif"/>

- #### Setting UI Flags
  - Calling `setSystemUiVisibility()` with `SYSTEM_UI_FLAG_FULLSCREEN` flag hides the status bar

```Java
  View mDecorView = getActivity().getWindow().getDecorView();
  int mOption = View.SYSTEM_UI_FLAG_FULLSCREEN;
  mDecorView.setSystemUiVisibility(mOption);
```
- #### Responding to UI Visibility Changes
  - When the user reopens the activity, `onCreate()` won't get called, so if you want system UI changes to persist, set UI flags in `onResume()` of `onWindowFocusChanged()`
  
<br/>

### Make Content Appear Behind the Status Bar
- Available in Android 4.1 (API level 16) and higher
- If you use `SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION`, the content will not be resized when the navigation bar is hidden and visible.
- `SYSTEM_UI_FLAG_LAYOUT_STABLE` helps your app maintain a stable layout.
- `android:fitsSystemWindows` adjusts the padding of the parent `ViewGroup` and if set to true the app's UI will not be covered by the system bar

<br/><br/>

## 3. Hiding the Navigation Bar

<img align="right" src="https://user-images.githubusercontent.com/25583321/72768382-95f73f80-3c3a-11ea-96ad-a9a4598c7426.gif"/>

### Hide the Navigation Bar
- Calling `setSystemUiVisibility()` with `SYSTEM_UI_FLAG_HIDE_NAVIGATION` flag hides the navigation bar
- You can also hide the status bar by using the `SYSTEM_UI_FLAG_FULLSCREEN` flag together. This works the same as `Lean back` in Full screen Options

```Java
View mDecorView = getActivity().getWindow().getDecorView();
int mOption = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
// Hide both the navigation bar and the status bar
int bothOption = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
              | View.SYSTEM_UI_FLAG_FULLSCREEN;
mDecorView.setSystemUiVisibility(mOption);
```

### Make Content Appear Behind the Navigation Bar
- Available in Android 4.1 (API level 16) and higher
- If you use `SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION`, the content will not be resized when the navigation bar is hidden and visible
- `SYSTEM_UI_FLAG_LAYOUT_STABLE` helps your app maintain a stable layout
<br/>

## 4. Using Immersive Full-Screen Mode

### [Lean Back](https://developer.android.com/training/system-ui/immersive.html#leanback)

<img align="right" src="https://user-images.githubusercontent.com/25583321/72768382-95f73f80-3c3a-11ea-96ad-a9a4598c7426.gif"/>

- The lean back mode is for fullscreen experiences in which users won't be interacting heavily with the screen
- For example, watching a video.
- When the user taps anywhere on the screen, the status bar appears
- Calling `setSystemUiVisibility()` with `SYSTEM_UI_FLAG_FULLSCREEN` and `SYSTEM_UI_FLAG_HIDE_NAVIGATION`
- When the system bars re-appear, you can receive a callback to make other appropriate updates to your UI

```Java
View mDecorView = getActivity().getWindow().getDecorView();
int mOption = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
          | View.SYSTEM_UI_FLAG_FULLSCREEN;
mDecorView.setSystemUiVisibility(mOption);
```

<br/><br/><br/>

### [Immersive](https://developer.android.com/training/system-ui/immersive.html#immersive)

<img align="right" src="https://user-images.githubusercontent.com/25583321/72768503-f2f2f580-3c3a-11ea-9b35-de79a33541cd.gif"/>

- The lean back mode is for fullscreen experiences in which users won't be interacting heavily with the screen
- For example, watching a video.
- When the user taps anywhere on the screen, the status bar appears
- Calling `setSystemUiVisibility()` with `SYSTEM_UI_FLAG_FULLSCREEN` and `SYSTEM_UI_FLAG_HIDE_NAVIGATION`
- When the system bars re-appear, you can receive a callback to make other appropriate updates to your UI

```Java
View mDecorView = getActivity().getWindow().getDecorView();
int mOption = View.SYSTEM_UI_FLAG_IMMERSIVE
          | View.SYSTEM_UI_FLAG_FULLSCREEN
          | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
mDecorView.setSystemUiVisibility(mOption);
```

<br/><br/><br/>

### [Sticky Immersive](https://developer.android.com/training/system-ui/immersive.html#sticky-immersive)

<img align="right" src="https://user-images.githubusercontent.com/25583321/72768530-0736f280-3c3b-11ea-9cef-45a2e6906915.gif"/>

```Java
View mDecorView = getActivity().getWindow().getDecorView();
int mOption =  View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
          | View.SYSTEM_UI_FLAG_FULLSCREEN
          | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
mDecorView.setSystemUiVisibility(mOption);
```

<br/><br/><br/>

