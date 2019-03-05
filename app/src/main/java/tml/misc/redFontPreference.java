package tml.misc;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public class redFontPreference extends Preference {
    public redFontPreference(Context context) {
        super(context);
    }

    public redFontPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public redFontPreference(Context context, AttributeSet attrs,
                                int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onBindView(View view) {
        super.onBindView(view);
        TextView titleView = (TextView) view.findViewById(android.R.id.title);
        titleView.setTextColor(Color.RED);
        titleView.setTypeface(null, Typeface.BOLD);
    }
}
