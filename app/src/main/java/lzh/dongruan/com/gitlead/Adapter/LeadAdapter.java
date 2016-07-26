package lzh.dongruan.com.gitlead.Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import lzh.dongruan.com.gitlead.FragmentLayout.One;
import lzh.dongruan.com.gitlead.FragmentLayout.Three;
import lzh.dongruan.com.gitlead.FragmentLayout.Two;

/**
 * Created by lzh220 on 2016/7/26.
 */
public class LeadAdapter extends PagerAdapter {
    View [] views;

    public LeadAdapter(Context context) {
        views=new View[]{
                new One(context),
                new Two(context),
                new Three(context)
        };
    }

    @Override
    public int getCount() {
        return views.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(views[position],0);
        return views[position];
    }
}
