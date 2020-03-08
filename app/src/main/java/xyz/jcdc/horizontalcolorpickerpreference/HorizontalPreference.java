package xyz.jcdc.horizontalcolorpickerpreference;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;

public class HorizontalPreference extends Preference {

    public HorizontalPreference(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    public HorizontalPreference(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    public HorizontalPreference(Context context) {
        super(context);

        init();
    }

    private void init() {
        setWidgetLayoutResource(R.layout.preference_horizontal);
    }

    @Override
    public void onBindViewHolder(PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);

        View iconFrame = holder.itemView.findViewById(R.id.icon_frame);
        if (iconFrame != null) {
            iconFrame.setVisibility(getIcon() == null ? View.GONE : View.VISIBLE);
        }
    }

    private void setZeroPaddingToLayoutChildren(View view) {
        if (!(view instanceof ViewGroup))
            return;
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            setZeroPaddingToLayoutChildren(viewGroup.getChildAt(i));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1)
                viewGroup.setPaddingRelative(0, viewGroup.getPaddingTop(), viewGroup.getPaddingEnd(), viewGroup.getPaddingBottom());
            else
                viewGroup.setPadding(0, viewGroup.getPaddingTop(), viewGroup.getPaddingRight(), viewGroup.getPaddingBottom());
        }
    }
}
