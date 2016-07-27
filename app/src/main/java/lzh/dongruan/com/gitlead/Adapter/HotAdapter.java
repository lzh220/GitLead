package lzh.dongruan.com.gitlead.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzh220 on 2016/7/27.
 */
public class HotAdapter extends FragmentPagerAdapter {
    List<Fragment> list;
    List<String> stringList;

    public HotAdapter(FragmentManager fm,List<String> stringList) {
        super(fm);
        this.stringList=stringList;
        list=new ArrayList<Fragment>();
    }

    public List<Fragment> getList() {
        return list;
    }

    public void setList(List<Fragment> list) {
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return stringList.get(position);
    }
}
