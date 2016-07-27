package lzh.dongruan.com.gitlead.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.header.StoreHouseHeader;
import lzh.dongruan.com.gitlead.Adapter.MenuAdapter;
import lzh.dongruan.com.gitlead.R;
import lzh.dongruan.com.gitlead.untils.MenuPresenter;

/**
 * Created by lzh220 on 2016/7/27.
 */
public class MenuFragment extends Fragment {
    @Bind(R.id.lvRepos)
    ListView lvRepos;
    @Bind(R.id.ptrClassicFrameLayout)
    PtrClassicFrameLayout ptrClassicFrameLayout;
    @Bind(R.id.emptyView)
    TextView emptyView;
    @Bind(R.id.errorView)
    TextView errorView;
    MenuAdapter menuAdapter;
    List<String> list;
    MenuPresenter menuPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_repo_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        menuPresenter=new MenuPresenter(this);
        list=new ArrayList<String>();
        menuAdapter=new MenuAdapter(getContext());
        lvRepos.setAdapter(menuAdapter);
        initPullToRefresh();
    }

    private void initPullToRefresh() {
        // 使用当前对象做为key，来记录上一次的刷新时间,如果两次下拉太近，将不会触发新刷新
        ptrClassicFrameLayout.setLastUpdateTimeRelateObject(this);
        // 关闭header所用时长
        ptrClassicFrameLayout.setDurationToCloseHeader(1500);
        // 下拉刷新监听处理
        ptrClassicFrameLayout.setPtrHandler(new PtrDefaultHandler() {
            // 当你"下拉时",将触发此方法
            @Override public void onRefreshBegin(PtrFrameLayout frame) {
                // 去做数据的加载，做具体的业务
                // 也就是说，你要抛开视图，到后台线程去做你的业务处理(数据刷新加载)
                menuPresenter.refresh();
            }
        });
        StoreHouseHeader header = new StoreHouseHeader(getContext());
        header.initWithString("I LIKE " + " LZH");
        header.setPadding(0, 60, 0, 60);
        ptrClassicFrameLayout.setHeaderView(header);
        ptrClassicFrameLayout.addPtrUIHandler(header);
        ptrClassicFrameLayout.setBackgroundResource(R.color.colorRefresh);
    }

    // 刷新的方法
    // 视图上:
    // 显示内容 or 错误 or 空白 , 三选一
//    public void showContentView() {
//        ptrClassicFrameLayout.setVisibility(View.VISIBLE);
//        emptyView.setVisibility(View.GONE);
//        errorView.setVisibility(View.GONE);
//    }
//取消刷新
    public void stopRefresh() {
        ptrClassicFrameLayout.refreshComplete();
    }

    // 加载数据
    // 将后台线程更新加载到的数据，刷新显示到视图(listview)上来显示给用户看
    public void refreshData(List<String> list) {
        menuAdapter.setList(list);
        menuAdapter.notifyDataSetChanged();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
