package com.bignerdranch.android.criminalintent;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TimePickerFragment extends DialogFragment {

    public static final String EXTRA_TIME = "com.bignerranch.android.criminalintent.time";
    private static final String ARG_TIME = "time";

    private TimePicker mTimePicker;


    public static TimePickerFragment newInstance(Date time) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_TIME, time);
        TimePickerFragment fragment = new TimePickerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        Date time = (Date) getArguments().getSerializable(ARG_TIME);

        Calendar cal = Calendar.getInstance();
        cal.setTime(time);


        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int min = cal.get(Calendar.MINUTE);

        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_time, null);

        mTimePicker = (TimePicker) v.findViewById(R.id.dialog_time_picker);

        mTimePicker.setHour(hour);
        mTimePicker.setMinute(min);


        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle(R.string.time_picker_title)
                .setPositiveButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                int hour = mTimePicker.getHour();
                                int minute = mTimePicker.getMinute();

                                Date date = deltaTime(hour,minute);


                                sendResult(Activity.RESULT_OK, date);
                            }
                        })
                .create();

    }

    private Date deltaTime(int hour, int minute) {

        Date given = (Date) getArguments().getSerializable(ARG_TIME);
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(given);
//
//        int month = calendar.get(Calendar.MONTH);
//        int day = calendar.get(Calendar.DAY_OF_MONTH);
//        int year = calendar.get(Calendar.YEAR);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.HOUR, hour);

        return calendar.getTime();


    }

    private void sendResult(int resultCode, Date time) {
        if (getTargetFragment() == null) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(EXTRA_TIME, time);
        getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, intent);
    }
}
