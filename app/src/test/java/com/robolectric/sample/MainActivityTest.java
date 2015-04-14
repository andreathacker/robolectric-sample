package com.robolectric.sample;

import android.app.Activity;
import android.app.Fragment;
import android.view.Menu;
import android.widget.TextView;

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

    @Test
    public void onCreate_shouldSetupTime() throws Exception {
        Activity activity = Robolectric.setupActivity(MainActivity.class);

        TextView currentTimeText = (TextView) activity.findViewById(R.id.current_time_text);

        assertThat(currentTimeText != null);
        assertThat(!currentTimeText.getText().toString().isEmpty());
    }

}
