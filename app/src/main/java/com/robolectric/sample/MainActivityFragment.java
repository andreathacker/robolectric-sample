package com.robolectric.sample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private TextView mCurrentTimeTextView;
    private TextView mCurrentMillisTextView;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mCurrentTimeTextView = (TextView) view.findViewById(R.id.current_formatted_time);
        mCurrentMillisTextView = (TextView) view.findViewById(R.id.current_millis_time);

        setCurrentTime();
    }

    private void setCurrentTime(){

        String format = "HH:mm a";
        Date currentDate = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat(format, Locale.US);

        mCurrentTimeTextView.setText(dateFormat.format(currentDate));
    }
}
