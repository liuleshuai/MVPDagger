package com.liuleshuai.mvp.ui.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.liuleshuai.mvp.R;
import com.liuleshuai.mvp.bean.WeChatBean;

import java.util.List;

/**
 * Created by LiuKuo at 2018/3/23
 */

public class WeChatAdapter extends BaseQuickAdapter<WeChatBean, BaseViewHolder> {
    public WeChatAdapter(@LayoutRes int layoutResId, @Nullable List<WeChatBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, WeChatBean item) {
        helper.setText(R.id.tv, item.getText())
                .setImageResource(R.id.iv, item.getDrawable())
                .addOnClickListener(R.id.iv);
    }
}
