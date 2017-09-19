package com.thunderivenstudios.stackoverflowuser.api;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.thunderivenstudios.stackoverflowuser.R;

/**
 * Created by Vincent Ngo on 9/17/2017.
 * ©Vincent Ngo. All rights reserved.
 *
 * Wrapper class for Glide and demonstrate the use of Builder Pattern.
 * It is also known as facade design pattern where we wrap the external library into a simple class for maintainability.
 */

public class ImageLoader {
    private ImageLoader() {}

    public enum ScaleType {
        CenterCrop,
        FitCenter,
        CircleCrop,
        CenterInside
    }

    public static Builder with(Context context) {
        return new Builder(context);
    }

    @SuppressWarnings("all")
    public static class Builder {
        private String mUrl;
        private RequestOptions mOptions;
        private Context mContext;

        /**
         * private init, only accessible via ImageLoader.with(Context context)
         */
        private Builder(Context context) {
            mOptions = new RequestOptions();
            mContext = context;
        }

        public Builder load(String url) {
            mUrl = url;
            return this;
        }

        public Builder scaleType(ScaleType scaleType) {
            switch (scaleType) {
                case CenterCrop:
                    mOptions.centerCrop();
                    break;
                case FitCenter:
                    mOptions.fitCenter();
                    break;
                case CircleCrop:
                    mOptions.circleCrop();
                    break;
                case CenterInside:
                    mOptions.centerInside();
                    break;
            }
            return this;
        }

        public void into(ImageView imageView) {
            Glide.with(mContext)
                    .load(mUrl)
                    .thumbnail(Glide.with(imageView.getContext()).load(R.drawable.loading)) // Loading gif
                    .apply(mOptions)
                    .into(imageView);
        }
    }
}
