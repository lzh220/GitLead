package lzh.dongruan.com.gitlead.untils;

import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

import lzh.dongruan.com.gitlead.Fragment.MenuFragment;

/**
 * Created by lzh220 on 2016/7/27.
 */
public class MenuPresenter {
    private MenuFragment menuFragment;
    int count=1;

    public MenuPresenter(MenuFragment menuFragment) {
        this.menuFragment = menuFragment;
    }
    public void refresh() {
        new RefreshTask().execute();

    }
    class RefreshTask extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
          List<String> list=new ArrayList<String>();
            for(int i=0;i<6;i++){
                list.add("lzh"+(count++));
            }
            menuFragment.stopRefresh();
            menuFragment.refreshData(list);
//            menuFragment.showContentView();
        }

    }
}
