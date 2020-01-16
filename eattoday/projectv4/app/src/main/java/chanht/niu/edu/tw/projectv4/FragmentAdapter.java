package chanht.niu.edu.tw.projectv4;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class FragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragment;

    public FragmentAdapter(List<Fragment> fragments,FragmentManager fm){
        super(fm);
        this.mFragment = fragments;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragment.get(position);
    }

    @Override
    public int getCount() {
        return mFragment.size();
    }
}
