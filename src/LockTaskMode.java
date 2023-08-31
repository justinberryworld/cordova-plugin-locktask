package com.justinberryworld.plugins;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;

public class LockTaskMode extends CordovaPlugin {
    private static final String SCANNER_APP_PACKAGE = "io.ionic.starter";
    private static final String[] APP_PACKAGES = {SCANNER_APP_PACKAGE};
    private Activity activity = null;

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
        activity = cordova.getActivity();

        if (action.equals("setLockTaskEnabled")) {
            return setLockTaskEnabled(callbackContext);
        } else if (action.equals("setLockTaskPackages")) {
            return setLockTaskPackages(callbackContext);
        } else {
            return false;
        }
    }

    public boolean setLockTaskEnabled(CallbackContext callbackContext) {
        try {
            ActivityOptions options = ActivityOptions.makeBasic();
            options.setLockTaskEnabled(true);
            callbackContext.success();
            return true;
        } catch (Exception e) {
            callbackContext.error(e.getMessage());
        }

        return false;
    }

    public boolean setLockTaskPackages(CallbackContext callbackContext) {
        try {
            DevicePolicyManager dpm = (DevicePolicyManager) activity.getSystemService(Context.DEVICE_POLICY_SERVICE);
            ComponentName adminName = activity.getComponentName();
            dpm.setLockTaskPackages(adminName, APP_PACKAGES);
            callbackContext.success();
            return true;
        } catch (Exception e) {
            callbackContext.error(e.getMessage());
        }

        return false;
    }
}