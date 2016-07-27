package lzh.dongruan.com.gitlead.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import lzh.dongruan.com.gitlead.Adapter.HotAdapter;
import lzh.dongruan.com.gitlead.R;

/**
 * Created by lzh220 on 2016/7/27.
 */
public class HotFragment extends Fragment {
    @Bind(R.id.tabLayout)
    TabLayout tabLayout;
    @Bind(R.id.viewPager)
    ViewPager viewPager;
    HotAdapter hotAdapter;
    List<String> list;
    List<Fragment> fragmentList;
    MenuFragment m;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       return inflater.inflate(R.layout.fragment_hot_repo, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        list=new ArrayList<String>();
        fragmentList=new ArrayList<Fragment>();

        for(int i=0;i<10;i++){
            list.add("java"+i);
            m=new MenuFragment();
            fragmentList.add(m);
        }

        hotAdapter=new HotAdapter(getChildFragmentManager(),list);
        viewPager.setAdapter(hotAdapter);
        hotAdapter.setList(fragmentList);
        tabLayout.setupWithViewPager(viewPager);
        hotAdapter.notifyDataSetChanged();


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
