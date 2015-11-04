# AutoFitEditText
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-AutoFitEditText-green.svg?style=true)](https://android-arsenal.com/details/1/2728)

<img src="https://github.com/ViksaaSkool/AutoFitEditText/blob/master/rpics/ic_launcher.png" width="96" height="96"/>

Auto Resizable EditText

<img src="https://github.com/ViksaaSkool/AutoFitEditText/blob/master/rpics/hit_gif.gif" width="210" height="380"/>


# Prerequisites/Credits

This library is based on:
- [AutoFitTextView](http://is.gd/vzqIWV)

For more details see [this blog post](http://is.gd/0l3Gxx)


# Usage

Add this to your build.grade:
```javascript
	repositories {
	//...
        maven { url "https://jitpack.io" }
    }
```
and then in dependencies:
```javascript
	dependencies {
	        compile 'com.github.ViksaaSkool:AutoFitEditText:53238e2d29'
	}
```
In your respective .xml layout something like:
```xml


<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:layout_behavior="@string/appbar_scrolling_view_behavior"
    tools:context=".MainActivity"
    tools:showIn="@layout/activity_main">

    <FrameLayout
        android:id="@+id/container"
        android:layout_width="match_parent"
        android:layout_height="333dp"
        android:layout_centerInParent="true"
        android:background="@color/primary" >

        <com.autofit.et.lib.AutoFitEditText
            android:id="@+id/rET"
            android:layout_height="match_parent"
            android:layout_width="match_parent"
            android:background="@color/primary"
            android:focusable="true"
            android:focusableInTouchMode="true"
            android:gravity="center_vertical|center_horizontal"
            android:hint="@string/hint"
            android:isScrollContainer="false"
            android:inputType="textMultiLine|textNoSuggestions"
            android:maxLength="240"
            android:textColor="@android:color/white"
            android:textColorHint="@android:color/white"
            android:textSize="90sp" />
    </FrameLayout>
</RelativeLayout>
```

In Java code something like: 

```java
//use ButterKnife!
@Bind(R.id.rET)
AutoFitEditText mAutoFitEditText;

        //in onCreate in Activity/Fragment
        mAutoFitEditText.setEnabled(true);
        mAutoFitEditText.setFocusableInTouchMode(true);
        mAutoFitEditText.setFocusable(true);
        mAutoFitEditText.setEnableSizeCache(false);
        //might cause crash on some devices
        mAutoFitEditText.setMovementMethod(null);
        // can be added after layout inflation;
        mAutoFitEditText.setMaxHeight(330);
        //don't forget to add min text size programmatically
        mAutoFitEditText.setMinTextSize(60f);

        AutoFitEditTextUtil.setNormalization(this, mRootView, mAutoFitEditText);
```


License
--------

    The MIT License (MIT)

    Copyright (c) 2015 Viktor Arsovski
    
    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:
    
    The above copyright notice and this permission notice shall be included in
    all copies or substantial portions of the Software.
    
    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
    THE SOFTWARE.
