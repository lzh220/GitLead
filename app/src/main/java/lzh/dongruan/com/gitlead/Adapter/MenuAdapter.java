package lzh.dongruan.com.gitlead.Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import lzh.dongruan.com.gitlead.R;

/**
 * Created by lzh220 on 2016/7/27.
 */
public class MenuAdapter extends BaseAdapter {
    List<String> list;
    Context context;

    public MenuAdapter(Context context) {
        this.context = context;
        list = new ArrayList<String>();
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        VerHolder vh=null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.layout_item_repo, null);
            vh=new VerHolder();
            vh.tv= (TextView) view.findViewById(R.id.tvRepoInfo);
            view.setTag(vh);
        }else {
            vh= (VerHolder) view.getTag();
        }
        vh.tv.setText(list.get(position));

        return view;
    }

    class VerHolder {
        TextView tv;

    }
}