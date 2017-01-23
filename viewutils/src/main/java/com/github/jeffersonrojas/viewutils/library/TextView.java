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
import android.util.AttributeSet;

import static com.github.jeffersonrojas.viewutils.library.CustomView.initView;

/**
 * Created by Jefferson Rojas on 18/01/2017.
 */

@SuppressWarnings("unused")
public class TextView extends android.widget.TextView {

    public TextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(this,attrs);
    }

    public TextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(this,attrs);
    }

}
