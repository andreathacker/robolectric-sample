package com.robolectric.sample;

import android.app.Activity;
import android.widget.TextView;
import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.assertj.core.api.Assertions.assertThat;
import static org.robolectric.Shadows.shadowOf;

/**
 * Created by davidthacker on 4/13/15.
 */

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainActivityTest {

    private Activity mainActivity;

    @Before
    public void setupActivity() throws Exception {
        mainActivity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void isActivitySetup() throws Exception {
        assertThat(mainActivity).isNotNull();
    }

    @Test
    public void onCreate_timeHasBeenSetup() throws Exception {
        TextView currentTimeText = (TextView) mainActivity.findViewById(R.id.current_formatted_time);

        assertThat(currentTimeText).isNotNull();
        assertThat(!currentTimeText.getText().toString().isEmpty());
    }

    @Test
    public void onCreate_millisHaveBeenSetup() throws Exception {
        TextView currentMillisText = (TextView) mainActivity.findViewById(R.id.current_millis_time);

        assertThat(!currentMillisText.getText().toString().isEmpty());
    }

    @Test
    public void onCreate_shouldFail() {

        String nullString = null;

        assertThat(nullString).isNotNull();
    }
}
