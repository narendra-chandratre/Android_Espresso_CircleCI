package com.mytaxi.android_demo;

import android.content.Intent;
import android.os.Build;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.GrantPermissionRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;
import android.widget.Toast;

import com.mytaxi.android_demo.activities.MainActivity;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.InstrumentationRegistry.getTargetContext;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.action.ViewActions.typeTextIntoFocusedView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.matcher.ViewMatchers.withInputType;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.google.android.gms.common.data.DataBufferUtils.hasData;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by narendrachandratre on 11/12/17.
 */

    @RunWith(AndroidJUnit4.class)

    public class MainActivityTest {

        @Rule public final LaunchActivity<MainActivity> main=new LaunchActivity<>(MainActivity.class);

        @Before
        public void grantPermission() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                getInstrumentation().getUiAutomation().executeShellCommand(
                    "pm grant " + getTargetContext().getPackageName()
                            + " android.permission.ACCESS_FINE_LOCATION");

                Log.e("Notify", "Permission >> Granted");
            }
        }

        @Test
        public void t01_verifyLoginScreen() throws Exception {
//            grantPermission();
            onView(withId(R.id.btn_login)).check(matches(isDisplayed()));
            Thread.sleep(5000);
        }

        @Test
        public void t02_verifyLogin() throws Exception {

            // Test 1 : Login
            onView(withId(R.id.edt_username)).perform(typeText("whiteelephant261"));
            Thread.sleep(5000);

            onView(withId(R.id.edt_password)).perform(typeText("video"));
            Thread.sleep(5000);

            onView(withId(R.id.btn_login)).perform(click());
            Thread.sleep(5000);

//            onView(withId(R.id.textSearch)).check(ViewAssertions.matches(isDisplayed()));
    }

//    @Rule
//    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);
    private MainActivity mActivity = null;
    private MainActivity mcall = null;

    @Before
    public void setActivity() {
        mActivity = main.get();
    }
        @Test
        public void t03_verifySearchUser() throws Exception {

            // Test 2 : Search User & Call
            onView(withId(R.id.textSearch)).check(matches(isDisplayed()));

            onView(withId(R.id.textSearch)).perform(typeText("s"));
            Thread.sleep(7500);

            onView(withId(R.id.textSearch))
                    .perform(typeTextIntoFocusedView("a"));

            // Check that both suggestions are displayed.
            onView(withText("Sarah Friedrich"))
                    .inRoot(withDecorView(not(is(mActivity.getWindow().getDecorView()))))
                    .check(matches(isDisplayed()));
            Thread.sleep(1000);

            onView(withText("Sarah Meyer"))
                    .inRoot(withDecorView(not(is(mActivity.getWindow().getDecorView()))))
                    .check(matches(isDisplayed()));
            Thread.sleep(1000);

            onView(withText("Sara Coleman"))
                    .inRoot(withDecorView(not(is(mActivity.getWindow().getDecorView()))))
                    .check(matches(isDisplayed()));
            Thread.sleep(5000);


            // Tap on a suggestion.
            onView(withText("Sarah Friedrich"))
                    .inRoot(withDecorView(not(is(mActivity.getWindow().getDecorView()))))
                    .perform(click());
            Thread.sleep(10000);

            // Verify - Avatar + Date + Location visibility
            onView(withId(R.id.imageViewDriverAvatar)).check(matches(isDisplayed()));
            onView(withId(R.id.imageViewDriverDate)).check(matches(isDisplayed()));
            onView(withId(R.id.imageViewDriverLocation)).check(matches(isDisplayed()));

            onView(withId(R.id.fab)).perform(click());
            Thread.sleep(10000);

//            onView(withText("Add to Contacts"))
//                    .inRoot(withDecorView(not(is(mActivity.getWindow().getDecorView()))))
//                    .check(matches(isDisplayed()));
//            Thread.sleep(5000);

//            onView(withText("Add to Contacts")).check(matches(isDisplayed()));

//            intended(allOf(hasAction(Intent.ACTION_DIAL), hasData(INTENT_DATA_PHONE_NUMBER)));
        }

    }

