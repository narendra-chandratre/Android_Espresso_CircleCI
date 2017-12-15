package com.mytaxi.android_demo;

import android.content.Context;
import android.os.Build;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.InstrumentationRegistry.getTargetContext;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
//        clearPreferences();

        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.mytaxi.android_demo", appContext.getPackageName());
    }


//    private void clearPreferences() {
//        try {
//            // clearing app data
//            Runtime runtime = Runtime.getRuntime();
//            runtime.exec("pm clear com.mytaxi.android_demo");
//            Log.e("Notify", "Data Cleared");
//            Thread.sleep(10000);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void grantPermission() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            getInstrumentation().getUiAutomation().executeShellCommand(
//                    "pm grant " + getTargetContext().getPackageName()
//                            + " android.permission.ACCESS_FINE_LOCATION");
//
//            Log.e("Notify", "Permission >> Granted");
//        }
//    }
}














