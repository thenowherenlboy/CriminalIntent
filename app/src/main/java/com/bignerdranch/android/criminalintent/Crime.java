package com.bignerdranch.android.criminalintent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Crime {

    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;
    private boolean mRequiresFuzz;
    private SimpleDateFormat df = new SimpleDateFormat("EEEE MMM dd, yyyy");
    private SimpleDateFormat time = new SimpleDateFormat("HH:mm");

    public Crime() {
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Date getDate() {
        return mDate;
    }

    public String getFormattedDate() {
        return df.format(mDate);
    }

    public String getTime() { return time.format(mDate); }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }


    public boolean isRequiresFuzz() {
        return mRequiresFuzz;
    }

    public void setRequiresFuzz(boolean requiresFuzz) {
        mRequiresFuzz = requiresFuzz;
    }
}
