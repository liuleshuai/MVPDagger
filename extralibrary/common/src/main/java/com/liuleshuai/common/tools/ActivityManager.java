package com.liuleshuai.common.tools;

import android.app.Activity;

import java.util.Stack;

/**
 * Created by LiuKuo at 2018/3/21
 */

public class ActivityManager {
    private static ActivityManager instance;

    public static ActivityManager getInstance() {
        if (instance == null) {
            instance = new ActivityManager();
        }
        return instance;
    }

    private Stack<Activity> activityStack;

    public void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<>();
        }
        activityStack.push(activity);
    }

    public void removeActivity() {
        if (!activityStack.empty()) {
            activityStack.pop();
        }
    }

    /**
     * 退出应用
     */
    public void exitApp() {
        if (activityStack != null && !activityStack.empty()) {
            synchronized (activityStack) {
                for (Activity activity : activityStack) {
                    activity.finish();
                }
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }
}
