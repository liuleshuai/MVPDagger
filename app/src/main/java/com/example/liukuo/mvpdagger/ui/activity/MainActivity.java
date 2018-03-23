package com.example.liukuo.mvpdagger.ui.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.common.base.BaseActivity;
import com.example.common.base.BaseFragment;
import com.example.common.tools.BottomNavigationViewHelper;
import com.example.liukuo.mvpdagger.R;
import com.example.liukuo.mvpdagger.app.Constants;
import com.example.liukuo.mvpdagger.model.MainContract;
import com.example.liukuo.mvpdagger.presenter.MainPresenter;
import com.example.liukuo.mvpdagger.ui.fragment.SearchDialogFragment;
import com.example.liukuo.mvpdagger.ui.fragment.WeChatFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author liukuo
 */
@Route(path = "/activity/main")
public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    @BindView(R.id.navigation_view)
    BottomNavigationView bottomNavigationView;

    private List<BaseFragment> fragmentList;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.extra_title_bar_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.search_item) {
            SearchDialogFragment searchDialogFragment = new SearchDialogFragment();
            searchDialogFragment.show(getFragmentManager(), "SearchDialogFragment");
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void initEventAndData() {
        initData();
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        });
        mViewPager.addOnPageChangeListener(onPageListener);
        bottomNavigationView.setOnNavigationItemSelectedListener(onItemSelectedListener);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
    }

    private ViewPager.OnPageChangeListener onPageListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            bottomNavigationView.getMenu().getItem(position).setChecked(true);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private BottomNavigationView.OnNavigationItemSelectedListener onItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.wechat:
                    mViewPager.setCurrentItem(Constants.FIRST);
                    break;
                case R.id.communcation:
                    mViewPager.setCurrentItem(Constants.SECOND);
                    break;
                case R.id.find:
                    mViewPager.setCurrentItem(Constants.THIRD);
                    break;
                case R.id.mine:
                    mViewPager.setCurrentItem(Constants.FOURTH);
                    break;
                default:
                    break;
            }
            return true;
        }
    };

    private void initData() {
        fragmentList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            WeChatFragment fragment = WeChatFragment.getInstance(null, null);
            fragmentList.add(fragment);
        }
    }
}
