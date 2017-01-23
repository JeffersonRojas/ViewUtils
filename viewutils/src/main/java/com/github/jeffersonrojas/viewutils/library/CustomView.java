/*
 * Copyright 2017 Jefferson Rojas
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.jeffersonrojas.viewutils.library;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Jefferson Rojas on 18/01/2017.
 */

class CustomView {

    private static final String FontFolder = "fonts/";
    private static final String FontTypeDefault = "ttf";

    static void initView(View view, AttributeSet attrs) {
        if (attrs == null) {
            return;
        }
        Context context = view.getContext();
        Drawable drawableStart = createDrawableFromVector(context,attrs,R.styleable.app_drawableStart,R.styleable.app_tintDrawableStart);
        Drawable drawableTop = createDrawableFromVector(context,attrs,R.styleable.app_drawableTop,R.styleable.app_tintDrawableTop);
        Drawable drawableEnd = createDrawableFromVector(context,attrs,R.styleable.app_drawableEnd,R.styleable.app_tintDrawableEnd);
        Drawable drawableBottom = createDrawableFromVector(context,attrs,R.styleable.app_drawableBottom,R.styleable.app_tintDrawableBottom);
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            textView.setTypeface(getMyCustomFont(context,attrs));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawableStart,drawableTop,drawableEnd,drawableBottom);
            } else {
                textView.setCompoundDrawablesWithIntrinsicBounds(drawableStart,drawableTop,drawableEnd,drawableBottom);
            }
        } else if (view instanceof EditText) {
            EditText editText = (EditText) view;
            editText.setTypeface(getMyCustomFont(context,attrs));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                editText.setCompoundDrawablesRelativeWithIntrinsicBounds(drawableStart, drawableTop, drawableEnd, drawableBottom);
            } else {
                editText.setCompoundDrawablesWithIntrinsicBounds(drawableStart, drawableTop, drawableEnd, drawableBottom);
            }
        } else if (view instanceof Button) {
            Button button = (Button) view;
            button.setTypeface(getMyCustomFont(context,attrs));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                button.setCompoundDrawablesRelativeWithIntrinsicBounds(drawableStart, drawableTop, drawableEnd, drawableBottom);
            } else {
                button.setCompoundDrawablesWithIntrinsicBounds(drawableStart, drawableTop, drawableEnd, drawableBottom);
            }
        }
    }

    private static Typeface getMyCustomFont(Context context, AttributeSet attrs) {
        String fontPath = FontFolder;
        String fontType = FontTypeDefault;

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.app);
        if (typedArray.getString(R.styleable.app_font) != null)
            fontPath += typedArray.getString(R.styleable.app_font);
        if (typedArray.getString(R.styleable.app_fontType) != null)
            fontType = typedArray.getString(R.styleable.app_fontType);
        typedArray.recycle();

        if (!fontPath.equals(FontFolder)) {
            fontPath += "." + fontType;
            AssetManager assetManager = context.getAssets();
            try {
                return Typeface.createFromAsset(assetManager, fontPath);
            } catch (RuntimeException e) {
                Log.e(context.getClass().getSimpleName(), "Error loadig the font ", e);
            }
        }
        return Typeface.DEFAULT;
    }

    private static Drawable createDrawableFromVector(Context context, AttributeSet attrs, int drawableAttrsId, int drawableTintId) {
        TypedArray attributeArray = context.obtainStyledAttributes(attrs, R.styleable.app);
        int tint;
        if (attributeArray.getColor(drawableTintId,0) == 0) {
            tint = attributeArray.getColor(R.styleable.app_tintCompound, 0);
        } else {
            tint = attributeArray.getColor(drawableTintId,0);
        }
        Drawable drawableReturn = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            drawableReturn = attributeArray.getDrawable(drawableAttrsId);
            if (drawableReturn != null && tint != 0) {
                drawableReturn.setTint(tint);
            }
        } else {
            final int drawableReturnId = attributeArray.getResourceId(drawableAttrsId, -1);
            if (drawableReturnId != -1) {
                drawableReturn = AppCompatResources.getDrawable(context, drawableReturnId);
                final Drawable wrappedDrawable;
                if (drawableReturn != null && tint != 0) {
                    wrappedDrawable = DrawableCompat.wrap(drawableReturn);
                    DrawableCompat.setTintList(wrappedDrawable, ColorStateList.valueOf(tint));
                }
            }
        }
        attributeArray.recycle();
        return drawableReturn;
    }

}
