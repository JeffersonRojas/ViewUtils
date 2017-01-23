#ViewUtils Library
[![Build](https://api.travis-ci.org/JeffersonRojas/ViewUtils.svg?branch=master)](https://travis-ci.org/JeffersonRojas/ViewUtils)
[![API](https://img.shields.io/badge/API-10%2B-blue.svg)](https://android-arsenal.com/api?level=10)
[![Download](https://api.bintray.com/packages/fejerson108/maven/viewutils/images/download.svg)](https://bintray.com/fejerson108/maven/viewutils/_latestVersion) 
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0)


The ViewUtils is a library for android which helps you to custom a some views more easily.

##Download ViewUtils to your project
Add the following code to your module's build.gradle file:
```xml
dependencies {
    compile 'com.github.jeffersonrojas:viewutils:1.0.4'
}
```
## Vector Support Compound Drawables
Add Vector Compound Drawables since api 10, and specify the tint color.

### Usage
1. first configure your project for use the library support vectors, if you do not know how to configure you can follow this [tutorial](https://developer.android.com/studio/write/vector-asset-studio.html)
2. set your vector compound drawables
```xml
 <com.github.jeffersonrojas.viewutils.library.EditText
        app:tintCompound="@color/colorAccent"
        app:drawableStart="@drawable/ic_your_vector"
        app:drawableTop="@drawable/ic_your_vector"
        app:drawableEnd="@drawable/ic_your_vector"
        app:drawableBottom="@drawable/ic_your_vector"
        ... />

 <com.github.jeffersonrojas.viewutils.library.EditText
        app:tintDrawableStart="@color/blue"
        app:drawableStart="@drawable/ic_your_vector"
        app:tintDrawableTop="@color/red"
        app:drawableTop="@drawable/ic_your_vector"
        app:tintDrawableEnd="@color/green"
        app:drawableEnd="@drawable/ic_your_vector"
        app:tintDrawableBottom="@color/yellow"
        app:drawableBottom="@drawable/ic_your_vector"
        ... />
```
### Examples of use using styles
```xml
<style name="MyStyle">
    <item name="android:layout_width">wrap_content</item>
    <item name="android:layout_height">wrap_content</item>
    <item name="tintCompound">@color/colorAccent</item>
    <item name="drawableStart">@drawable/ic_your_vector</item>
</style>
```
```xml
<com.github.jeffersonrojas.viewutils.library.TextView
    android:text="Hello world!"
    style="@style/MyStyle" />

<com.github.jeffersonrojas.viewutils.library.Button
    android:text="Hello world!"
    style="@style/MyStyle" />

<com.github.jeffersonrojas.viewutils.library.EditText
    android:text="Hello world!"
    style="@style/MyStyle" />
```

## Fonts
Add your fonts without java.

### Usage
1. Create the `assets/fonts` folder, if you do not know how to create the assets folder you can follow this [tutorial](http://abhiandroid.com/androidstudio/create-assets-folder-android-studio-html-files.html)
2. Add your custom fonts to Android Studio like this, and you can start to use ViewUtils
![screenshot](https://github.com/JeffersonRojas/ViewUtils/blob/master/FontsFolderExample.png "Fonts Folder Example")
3. Set your custom font in xml or from styles, if your font is in format `.ttf` just add `app:font="amazing font"`, for other formarts you need add `app:fontType="otf"`

### Examples of use
```xml
<!-- Font format .otf -->
<com.github.jeffersonrojas.viewutils.library.TextView
    android:layout_height="wrap_content"
    android:layout_width="wrap_content"
    android:text="Hello world!"
    app:font="amazing font"
    app:fontType="otf" />

<!-- Font for EditText -->
<com.github.jeffersonrojas.viewutils.library.EditText
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:text="Hello world!"
    android:hint="Hi"
    app:font="amazing font" />

<!-- Font for Button -->
<com.github.jeffersonrojas.viewutils.library.Button
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Button"
    app:font="amazing font" />
```
### Examples of use using styles
```xml
<style name="MyStyle">
    <item name="android:layout_width">wrap_content</item>
    <item name="android:layout_height">wrap_content</item>
    <item name="font">amazing font</item>
    <item name="fontType">otf</item>
</style>
```
```xml
<!-- Font from style -->
<com.github.jeffersonrojas.viewutils.library.TextView
    android:text="Hello world!"
    style="@style/MyStyle" />
```

## Developer
[Jefferson Rojas](mailto:fejerson108@gmail.com)


##License

    Copyright 2017 Jefferson Rojas

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
