package com.aaron.gank;

import com.aaron.gank.data.entity.CategoryTitle;
import com.aaron.gank.data.entity.DailyHeader;
import com.aaron.gank.data.entity.GankEntity;
import com.aaron.gank.ui.provider.CategoryTitleProvider;
import com.aaron.gank.ui.provider.DailyHeaderProvider;
import com.aaron.gank.ui.provider.GankEntityProvider;

import me.drakeet.multitype.GlobalMultiTypePool;

/**
 * Created by Aaron on 2016/12/29.
 */

public class MultiypeItemProvider {

    public static void register() {
        GlobalMultiTypePool.register(GankEntity.class, new GankEntityProvider());
        GlobalMultiTypePool.register(CategoryTitle.class, new CategoryTitleProvider());
        GlobalMultiTypePool.register(DailyHeader.class, new DailyHeaderProvider());
    }

}
