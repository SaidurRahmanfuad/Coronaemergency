package com.saidur.corona.emergency;



import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class EmergencyTabAdapter extends FragmentPagerAdapter {
    int tabCount;

    public EmergencyTabAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.tabCount = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new EmergencyFragment();
            case 1:
                return new HealthComplexFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }


  /*  @StringRes
    private static final int[] TAB_TITLES =
            new int[] { R.string.tab_text_1, R.string.tab_text_2};
    private final Context mContext;

    public VaraTabAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    public VaraTabAdapter(FragmentManager fm, Context mContext) {
        super(fm);
        this.mContext = mContext;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return NiomitoFragment.newInstance();
            case 1:
                return BokeyaFragment.newInstance();
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }*/
}