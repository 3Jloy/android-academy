package com.example.yury.bioapp.post.list;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DividerItemDecoration extends RecyclerView.ItemDecoration {

    private final int marginPx;
    private final int orientation;

    DividerItemDecoration(int marginPx, int orientation) {
        this.marginPx = marginPx;
        this.orientation = orientation;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int marginPx = Math.round(convertDpToPixel(view.getContext()));

        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            portraitOrientationMargins(outRect, parent.getChildAdapterPosition(view), marginPx);
        } else {
            landscapeOrientationMargins(outRect, parent.getChildAdapterPosition(view), marginPx);
        }

    }

    private void portraitOrientationMargins(@NonNull Rect outRect, int position, int marginPx) {
        if (position == 0) {
            outRect.set(marginPx, marginPx, marginPx, marginPx);
        } else {
            outRect.set(marginPx, 0, marginPx, marginPx);
        }
    }

    private void landscapeOrientationMargins(@NonNull Rect outRect, int position, int marginPx) {
        if (position == 0) {
            outRect.set(marginPx, marginPx, marginPx, marginPx);
        } else if (position == 1) {
            outRect.set(0, marginPx, marginPx, marginPx);
        } else if (position % 2 == 0) {
            outRect.set(marginPx, 0, marginPx, marginPx);
        } else {
            outRect.set(0, 0, marginPx, marginPx);
        }
    }

    /**
     * This method converts dp unit to equivalent pixels, depending on device density.
     *
     * @param context Context to get resources and device specific display metrics
     * @return A float value to represent px equivalent to dp depending on device density
     */
    private float convertDpToPixel(Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        return (float) marginPx * ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }
}
