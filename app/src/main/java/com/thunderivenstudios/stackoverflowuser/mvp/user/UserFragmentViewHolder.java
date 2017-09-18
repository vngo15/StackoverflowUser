package com.thunderivenstudios.stackoverflowuser.mvp.user;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.thunderivenstudios.stackoverflowuser.R;
import com.thunderivenstudios.stackoverflowuser.api.ImageLoader;
import com.thunderivenstudios.stackoverflowuser.model.User;
import com.thunderivenstudios.stackoverflowuser.mvp.base.presenter.BaseRecyclerViewPresenter;
import com.thunderivenstudios.stackoverflowuser.mvp.base.recycler_view.BaseRecyclerViewHolder;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Vincent Ngo on 9/18/2017.
 * ©Vincent Ngo. All rights reserved.
 */

class UserFragmentViewHolder extends BaseRecyclerViewHolder<BaseRecyclerViewPresenter> {
    @BindView(R.id.thumbnail)
    ImageView mThumbnail;
    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.gold_count)
    TextView mGoldCount;
    @BindView(R.id.silver_count)
    TextView mSilverCount;
    @BindView(R.id.bronze_count)
    TextView mBronzeCount;
    @BindView(R.id.total_reputation)
    TextView mTotalReputation;

    private UserFragmentViewHolder(View itemView, BaseRecyclerViewPresenter presenter) {
        super(itemView, presenter);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void loadData(int position) {
        User user = (User) getPresenter().getModelAtPosition(0, position);
        if (user != null) {
            new ImageLoader.Builder()
                    .load(user.getProfileImage())
                    .scaleType(ImageLoader.ScaleType.CenterInside)
                    .into(mThumbnail);
            mTitle.setText(user.getDisplayName());
            mGoldCount.setText(String.format(Locale.US, "%d", user.getBadge().getGoldCount()));
            mSilverCount.setText(String.format(Locale.US, "%d", user.getBadge().getSilverCount()));
            mBronzeCount.setText(String.format(Locale.US, "%d", user.getBadge().getBronzeCount()));
            mTotalReputation.setText(String.format(Locale.US, "%d", user.getReputation()));
        }
    }

    static UserFragmentViewHolder newInstance(ViewGroup parent, BaseRecyclerViewPresenter presenter) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vh_user, parent, false);
        return new UserFragmentViewHolder(v, presenter);
    }
}
