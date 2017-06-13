/**
 * Copyright (c) 2017 Ichiji

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all
 copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 SOFTWARE.
 */

package com.ichijisoftware;

import com.ichijisoftware.R;

import java.util.ArrayList;

/**
 * Created by Ichiji on 6/9/2017.
 */

public interface ThemeUpdateListener
{
    void onThemeChange();
}


public class ThemeManagera
{

    public static Integer _currentTheme = R.style.NightTheme;
    public static ArrayList<ThemeUpdateListener> subscribers = new ArrayList<ThemeUpdateListener>();

    public static void changeTheme(int themeToUse)
    {
        for(ThemeUpdateListener subscriber : subscribers)
        {
            switch (themeToUse)
            {
                case R.style.NightTheme:
                    ThemeManager._currentTheme = R.style.NightTheme;
                    subscriber.onThemeChange();
                    break;

                case R.style.LightTheme:
                    ThemeManager._currentTheme = R.style.LightTheme;
                    subscriber.onThemeChange();
                    break;

                default:
                    break;
            }
        }
    }

    private static ArrayList<Integer> getComponentColors()
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        switch (ThemeManager._currentTheme)
        {
            // The order in which the colors are added are important
            case R.style.NightTheme:
                list.add(R.color.colorNightButton);
                list.add(R.color.colorNightThemeText);
                list.add(R.color.colorNightAccent);
                list.add(R.color.colorNightActivityBackground);
                list.add(R.color.colorNightAppTitleBackground);
                list.add(R.color.colorNightSideMenuBackground);
                list.add(R.color.colorNightSideMenuDivider);
                list.add(R.color.colorNightNotificationBar);
                break;

            case R.style.LightTheme:
                list.add(R.color.colorLightButton);
                list.add(R.color.colorLightThemeText);
                list.add(R.color.colorLightAccent);
                list.add(R.color.colorLightActivityBackground);
                list.add(R.color.colorLightAppTitleBackground);
                list.add(R.color.colorLightSideMenuBackground);
                list.add(R.color.colorLightSideMenuDivider);
                list.add(R.color.colorLightNotificationBar);
                break;
        }
        return list;
    }

    public static void subscribe(ThemeUpdateListener subscriber)
    {
        subscribers.add(subscriber);
    }

    public static int getButtonColor()
    {
        ArrayList<Integer> componentColors = getComponentColors();
        return componentColors.get(0);
    }

    public static int getTextColor()
    {
        ArrayList<Integer> componentColors = getComponentColors();
        return componentColors.get(1);
    }

    public static int getAccentColor()
    {
        ArrayList<Integer> componentColors = getComponentColors();
        return componentColors.get(2);
    }

    public static int getBackgroundColor()
    {
        ArrayList<Integer> componentColors = getComponentColors();
        return componentColors.get(3);
    }

    public static int getAppTitleBackgroundColor()
    {
        ArrayList<Integer> componentColors = getComponentColors();
        return componentColors.get(4);
    }

    public static int getSideMenuBackgroundColor()
    {
        ArrayList<Integer> componentColors = getComponentColors();
        return componentColors.get(5);
    }

    public static int getSideMenuDividerColor()
    {
        ArrayList<Integer> componentColors = getComponentColors();
        return componentColors.get(6);
    }

    public static int getNotificationBarColor()
    {
        ArrayList<Integer> componentColors = getComponentColors();
        return componentColors.get(7);
    }
}
