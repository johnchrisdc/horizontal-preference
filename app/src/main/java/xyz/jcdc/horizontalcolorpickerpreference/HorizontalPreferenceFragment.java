package xyz.jcdc.horizontalcolorpickerpreference;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HorizontalPreferenceFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.horizontal_preference);
    }

    @Override
    public RecyclerView.LayoutManager onCreateLayoutManager() {
        return new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
    }
}
