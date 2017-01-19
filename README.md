#ViewUtils Library
[ ![Download](https://api.bintray.com/packages/fejerson108/maven/viewutils/images/download.svg) ](https://bintray.com/fejerson108/maven/viewutils/_latestVersion)

The ViewUtils is a library for android which helps you to custom a some views more easily.

##Download ViewUtils to your project
Add the following code to your module's build.gradle file:
```xml
repositories {
    maven { url 'https://dl.bintray.com/fejerson108/maven' }
}

dependencies {
    compile 'com.github.jeffersonrojas:viewutils:1.0.2'
}
```

##Fonts
Add your fonts without java.

![screenshot](https://github.com/JeffersonRojas/ViewUtils/blob/master/Screenshot.png "Font Samples")

###Usage
1. Create the `assets/` folder  
![screenshot](https://github.com/JeffersonRojas/ViewUtils/blob/master/CreateAssetsFolder.png "Create Assets Folder")
2. Create a subdirectory `fonts/` in assets
![screenshot](https://github.com/JeffersonRojas/ViewUtils/blob/master/CreateSubdirectoyFonts.png "Create Subdirectoy Fonts")
3. Add your custom fonts to Android Studio like this, and you can start to use ViewUtils
![screenshot](https://github.com/JeffersonRojas/ViewUtils/blob/master/FontsFolderExample.png "Fonts Folder Example")
4. Set your custom font in xml or from styles, if your font is in format `.ttf` just add `app:font="amazing font"`, for other formarts you need add `app:fontType="otf"`

###Examples of use
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
###Examples of use using styles
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
    style="@style/TextView.Toolbar" />
```

##Developer
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
