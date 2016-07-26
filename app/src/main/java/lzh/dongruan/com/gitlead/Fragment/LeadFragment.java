package lzh.dongruan.com.gitlead.Fragment;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import lzh.dongruan.com.gitlead.Adapter.LeadAdapter;
import lzh.dongruan.com.gitlead.R;
import me.relex.circleindicator.CircleIndicator;


/**
 * Created by lzh220 on 2016/7/26.
 */
public class LeadFragment extends Fragment {
    @Bind(R.id.ivPhoneBlank)
    ImageView ivPhoneBlank;
    @Bind(R.id.ivPhoneFont)
    ImageView ivPhoneFont;
    @Bind(R.id.layoutPhoneInner)
    FrameLayout layoutPhoneInner;
    @Bind(R.id.layoutPhone)
    FrameLayout layoutPhone;
    @Bind(R.id.viewPager)
    ViewPager viewPager;
    @Bind(R.id.indicator)
    CircleIndicator indicator;
    @Bind(R.id.content)
    FrameLayout content;
    private int colorGreen;
    private int colorRed;
    private int colorYellow;
    LeadAdapter leadAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash_pager, container, false);
        ButterKnife.bind(this, view);
        colorGreen = getResources().getColor(R.color.colorGreen);
        colorRed = getResources().getColor(R.color.colorRed);
        colorYellow = getResources().getColor(R.color.colorYellow);
        leadAdapter=new LeadAdapter(getContext());
        viewPager.setAdapter(leadAdapter);
        indicator.setViewPager(viewPager);
        viewPager.addOnPageChangeListener(colorlistener);
        viewPager.addOnPageChangeListener(phonelistener);
        return view;
    }
ViewPager.OnPageChangeListener colorlistener=new ViewPager.OnPageChangeListener() {
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        ArgbEvaluator argbEvaluator=new ArgbEvaluator();
        if(position==0){
            int color= (int) argbEvaluator.evaluate(positionOffset,colorGreen,colorRed);
            content.setBackgroundColor(color);
        }
        if(position==1){
            int color= (int) argbEvaluator.evaluate(positionOffset,colorRed,colorYellow);
            content.setBackgroundColor(color);
        }
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
};
    ViewPager.OnPageChangeListener phonelistener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            if(position==0){
                float animal=0.3f+0.7F*positionOffset;
                layoutPhone.setScaleX(animal);
                layoutPhone.setScaleY(animal);
                int scoll= (int) ((positionOffset-1)*360);
                layoutPhone.setTranslationX(scoll);
                ivPhoneFont.setAlpha(positionOffset);



            }
            if(position==1){
                layoutPhone.setTranslationX(-positionOffsetPixels);
            }
        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
