package lzh.dongruan.com.gitlead.FragmentLayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import lzh.dongruan.com.gitlead.R;

/**
 * Created by lzh220 on 2016/7/26.
 */
public class Two extends FrameLayout {
    public Two(Context context) {
        super(context);
        init();
    }
    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.content_pager_1, this, true);
    }
}
