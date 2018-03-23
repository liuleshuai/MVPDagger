package com.example.liukuo.mvpdagger.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.common.base.BaseDialogFragment;
import com.example.liukuo.mvpdagger.R;
import com.example.liukuo.mvpdagger.model.SearchDialogContract;
import com.example.liukuo.mvpdagger.presenter.SearchDialogPresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by LiuKuo at 2018/3/23
 */

public class SearchDialogFragment extends BaseDialogFragment<SearchDialogPresenter> implements SearchDialogContract.View {
    @BindView(R.id.search_back_ib)
    ImageButton searchBackIb;
    @BindView(R.id.search_tv)
    TextView searchTv;
    @BindView(R.id.search_edit)
    EditText searchEdit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/*        DialogFragment.STYLE_NORMAL;//默认样式
        DialogFragment.STYLE_NO_TITLE;//无标题样式
        DialogFragment.STYLE_NO_FRAME;//无边框样式
        DialogFragment.STYLE_NO_INPUT;//不可输入，不可获得焦点样式*/
        setStyle(DialogFragment.STYLE_NO_FRAME, R.style.DialogStyle);
    }

    @Override
    public void onResume() {
        super.onResume();
        initDialog();
    }

    private void initDialog() {
        Window window = getDialog().getWindow();
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        //DialogSearch的宽
        int width = (int) (metrics.widthPixels * 0.98);
        assert window != null;
        window.setLayout(width, WindowManager.LayoutParams.MATCH_PARENT);
        window.setGravity(Gravity.TOP);
    }



    @Override
    protected int getLayoutId() {
        return R.layout.fragment_search;
    }

    @Override
    protected void initEventAndData() {

    }

    @OnClick(R.id.search_back_ib)
    public void onViewClicked() {
        dismiss();
    }
}
