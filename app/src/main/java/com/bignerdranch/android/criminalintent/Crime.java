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
    private String mSuspect;
    private SimpleDateFormat df = new SimpleDateFormat("EEEE MMM dd, yyyy");

    public Crime(UUID id) {
        mId = id;
        mDate = new Date();
    }
    public Crime() {
        this(UUID.randomUUID());

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

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public String getSuspect() {
        return mSuspect;
    }

    public void setSuspect(String suspect) {
        mSuspect = suspect;
    }


    public boolean isRequiresFuzz() {
        return mRequiresFuzz;
    }

    public void setRequiresFuzz(boolean requiresFuzz) {
        mRequiresFuzz = requiresFuzz;
    }
}
