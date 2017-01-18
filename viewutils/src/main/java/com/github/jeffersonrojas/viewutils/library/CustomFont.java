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
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;

/**
 * Created by Jefferson Rojas on 18/01/2017.
 */

class CustomFont {

    private static final String AtributeFont = "font";
    private static final String AtributeFontType = "fontType";
    private static final String FontFolder = "fonts/";
    private static final String FontTypeDefault = "ttf";

    static Typeface getMyCustomFont(Context context, AttributeSet attrs) {
        String fontPath = FontFolder;
        String fontType = FontTypeDefault;
        for (int i = 0; i < attrs.getAttributeCount(); i++) {
            if (attrs.getAttributeName(i).equals(AtributeFontType))
                fontType = attrs.getAttributeValue(i);
            if (attrs.getAttributeName(i).equals(AtributeFont))
                fontPath += attrs.getAttributeValue(i);
        }
        if (!fontPath.equals(FontFolder)) {
            fontPath += "." + fontType;
            AssetManager assetManager = context.getAssets();
            try {
                return Typeface.createFromAsset(assetManager, fontPath);
            } catch (RuntimeException e) {
                Log.e(context.getClass().getSimpleName(), "Error al cargar la fuente", e);
            }
        }
        return Typeface.DEFAULT;
    }

}