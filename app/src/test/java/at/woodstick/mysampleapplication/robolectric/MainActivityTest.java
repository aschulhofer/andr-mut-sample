package at.woodstick.mysampleapplication.robolectric;



import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.widget.Button;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.Locale;

import at.woodstick.mysampleapplication.BuildConfig;
import at.woodstick.mysampleapplication.MainActivity;
import at.woodstick.mysampleapplication.R;

/**
 * TODO: FIX ROBOLECTRIC after studio, build tools and gradle upgrade
 *
 * If encountering error
 *
 * No such manifest file: build\intermediates\bundles\debug\AndroidManifest.xml
 * android.content.res.Resources$NotFoundException: Resource ID #0x7f020052
 *
 * Try:
 * Run > Edit Configurations.. > Defaults > Android JUnit
 * Working Directory: $MODULE_DIR$
 */
//@RunWith(RobolectricTestRunner.class)
//@Config(constants = BuildConfig.class)
public class MainActivityTest {

    private MainActivity mainActivity;
    private Resources mainActivityResources;

    @Before
    public void setUp() {
        mainActivity = Robolectric.setupActivity(MainActivity.class);
        mainActivityResources = mainActivity.getResources();
    }

    //@Test
    @Config(qualifiers = "de")
    public void shouldCheckGermanButtonText() {
        Button gsampleButton = getViewById(mainActivity, R.id.start_gsample_button);

        String actualGSampleButtonText = (String)gsampleButton.getText();
        String expectedGSampleButtonText = mainActivity.getResources().getString(R.string.button_start_gsample);

        Assert.assertEquals("GSample starten", actualGSampleButtonText);
        Assert.assertEquals(expectedGSampleButtonText, actualGSampleButtonText);
    }

    /**
     * @param language
     * @deprecated not working with robolectric use {@link org.robolectric.annotation.Config}  qualifier = "&lt;locale&gt;
     */
    @Deprecated
    public void setLocale(String language) {
        setLocale(language, "");
    }

    /**
     * @param language
     * @param country
     * @deprecated not working with robolectric use {@link org.robolectric.annotation.Config} qualifier = "&lt;locale&gt;"
     */
    @Deprecated
    public void setLocale(String language, String country) {
        Locale locale = new Locale(language, country);
        Locale.setDefault(locale);

        Configuration config = mainActivityResources.getConfiguration();
        config.locale = locale;
        mainActivityResources.updateConfiguration(config, mainActivityResources.getDisplayMetrics());
    }

    @SuppressWarnings("unchecked")
    public <T> T getViewById(Activity activity, int id) {
        return (T) activity.findViewById(id);
    }
}
