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
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.util.Log;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static com.github.jeffersonrojas.viewutils.library.CustomFont.getMyCustomFont;

/**
 * Created by Jefferson Rojas on 18/01/2017.
 */

@SuppressWarnings("unused")
public class Button extends AppCompatButton {

    public Button(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public Button(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        setTypeface(getMyCustomFont(context, attrs));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            setRipple(context, attrs);
        else
            setColorStates(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setRipple(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.app);
        int rippleColor = typedArray.getColor(R.styleable.app_pressedColor, 0);
        int backgroundColor = typedArray.getColor(R.styleable.app_normalColor, 0);
        if (backgroundColor != 0) {
            if (rippleColor != 0)
                setRippleColors(backgroundColor, rippleColor);
            else
                setRippleNormalColor(backgroundColor);
        } else if (rippleColor != 0) {
            setRippleAnimColor(rippleColor);
        }
        typedArray.recycle();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void setRippleAnimColor(int color) {
        if (getBackground() instanceof RippleDrawable) {
            RippleDrawable rippleDrawable = (RippleDrawable) getBackground();
            rippleDrawable.setColor(ColorStateList.valueOf(color));
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void setRippleNormalColor(int color) {
        if (getBackground() instanceof RippleDrawable) {
            RippleDrawable rippleDrawable = (RippleDrawable) getBackground();
            if (rippleDrawable.getDrawable(0) instanceof GradientDrawable) {
                GradientDrawable gradientDrawable = (GradientDrawable) rippleDrawable.getDrawable(0);
                gradientDrawable.setColor(color);
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void setRippleColors(int colorBackgroud, int colorRipple) {
        if (getBackground() instanceof RippleDrawable) {
            RippleDrawable rippleDrawable = (RippleDrawable) getBackground();
            rippleDrawable.setColor(ColorStateList.valueOf(colorRipple));
            if (rippleDrawable.getDrawable(0) instanceof GradientDrawable) {
                GradientDrawable gradientDrawable = (GradientDrawable) rippleDrawable.getDrawable(0);
                gradientDrawable.setColor(colorBackgroud);
            }
        }
    }

    public void setColorsStates(int colorNormal, int colorPressed) {
        if (getBackground() instanceof StateListDrawable) {
            StateListDrawable stateListDrawable = (StateListDrawable) getBackground();
            try {
                int[] pressedState = new int[]{android.R.attr.state_pressed};
                int[] normalState = stateListDrawable.getState();
                Method getStateDrawableIndex = StateListDrawable.class.getMethod("getStateDrawableIndex", int[].class);
                Method getStateDrawable = StateListDrawable.class.getMethod("getStateDrawable", int.class);
                int pressed = (int) getStateDrawableIndex.invoke(stateListDrawable, (Object) pressedState);
                int normal = (int) getStateDrawableIndex.invoke(stateListDrawable, (Object) normalState);
                if (getStateDrawable.invoke(stateListDrawable, pressed) instanceof GradientDrawable) {
                    GradientDrawable gradientDrawable = (GradientDrawable) getStateDrawable.invoke(stateListDrawable, pressed);
                    gradientDrawable.setColor(colorPressed);
                }
                if (getStateDrawable.invoke(stateListDrawable, normal) instanceof GradientDrawable) {
                    GradientDrawable gradientDrawableNormal = (GradientDrawable) getStateDrawable.invoke(stateListDrawable, normal);
                    gradientDrawableNormal.setColor(colorNormal);
                }
            } catch (IllegalAccessException e) {
                Log.e(getClass().getSimpleName(), "Error IllegalAccessException : ", e);
            } catch (InvocationTargetException e) {
                Log.e(getClass().getSimpleName(), "Error InvocationTargetException : ", e);
            } catch (NoSuchMethodException e) {
                Log.e(getClass().getSimpleName(), "Error NoSuchMethodException : ", e);
            }
        }
    }

    public void setColorNormal(int colorNormal) {
        if (getBackground() instanceof StateListDrawable) {
            StateListDrawable stateListDrawable = (StateListDrawable) getBackground();
            if (stateListDrawable.getCurrent() instanceof GradientDrawable) {
                GradientDrawable gradientDrawableNormal = (GradientDrawable) stateListDrawable.getCurrent();
                gradientDrawableNormal.setColor(colorNormal);
            }
        }
    }

    public void setColorPressed(int colorPressed) {
        if (getBackground() instanceof StateListDrawable) {
            StateListDrawable stateListDrawable = (StateListDrawable) getBackground();
            int[] pressedState = new int[]{android.R.attr.state_pressed};
            try {
                Method getStateDrawableIndex = StateListDrawable.class.getMethod("getStateDrawableIndex", int[].class);
                Method getStateDrawable = StateListDrawable.class.getMethod("getStateDrawable", int.class);
                int pressed = (int) getStateDrawableIndex.invoke(stateListDrawable, (Object) pressedState);
                if (getStateDrawable.invoke(stateListDrawable, pressed) instanceof GradientDrawable) {
                    GradientDrawable gradientDrawable = (GradientDrawable) getStateDrawable.invoke(stateListDrawable, pressed);
                    gradientDrawable.setColor(colorPressed);
                }
            } catch (IllegalAccessException e) {
                Log.e(getClass().getSimpleName(), "Error IllegalAccessException : ", e);
            } catch (InvocationTargetException e) {
                Log.e(getClass().getSimpleName(), "Error InvocationTargetException : ", e);
            } catch (NoSuchMethodException e) {
                Log.e(getClass().getSimpleName(), "Error NoSuchMethodException : ", e);
            }
        }
    }

    private void setColorStates(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.app);
        int normalColor = typedArray.getColor(R.styleable.app_normalColor, 0);
        int pressedColor = typedArray.getColor(R.styleable.app_pressedColor, 0);
        if (normalColor != 0) {
            if (pressedColor != 0)
                setColorsStates(normalColor, pressedColor);
            else
                setColorNormal(normalColor);
        } else if (pressedColor != 0)
            setColorPressed(pressedColor);
        typedArray.recycle();
    }

    /*private int saturar (ColorDrawable colorDrawable, float scale) {
        float[] hsv = new float[3];
        Color.colorToHSV(colorDrawable.getColor(),hsv);
        hsv[1] *= scale;
        return Color.HSVToColor(hsv);
    }*/

}
