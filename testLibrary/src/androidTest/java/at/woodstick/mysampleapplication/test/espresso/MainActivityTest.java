package at.woodstick.mysampleapplication.test.espresso;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import at.woodstick.mysampleapplication.MainActivity;
import at.woodstick.mysampleapplication.R;

import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.ComponentNameMatchers.hasShortClassName;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static at.woodstick.mysampleapplication.test.util.EspressoUtils.clickButton;
import static org.hamcrest.core.AllOf.allOf;

/**
 *
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    private static final String PACKAGE_NAME = "at.woodstick.mysampleapplication";
    private static final String ACTIVITY_CLASS_SHORTNAME_GSAMPLE = ".GSampleActivity";

    @Rule
    public IntentsTestRule<MainActivity> intentRule = new IntentsTestRule<>(MainActivity.class);

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void mainButton_click_InitiatesActivity() {
        clickButton(R.id.start_gsample_button);

        intended(
            allOf(
                hasComponent(hasShortClassName(ACTIVITY_CLASS_SHORTNAME_GSAMPLE)),
                toPackage(PACKAGE_NAME)
            )
        );
    }

}
