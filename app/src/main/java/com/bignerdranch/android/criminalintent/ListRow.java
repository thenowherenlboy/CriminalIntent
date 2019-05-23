package com.bignerdranch.android.criminalintent;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;


public class ListRow extends RecyclerView.ViewHolder {
    public ImageView mThumbnail;

    public ListRow(View view) {
        super(view);
        mThumbnail = (ImageView) view.findViewById(R.id.invisible);
        // TODO: change invisible to thumbnail after it's defined
    }
}
