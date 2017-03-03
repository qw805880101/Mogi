package com.forzhihu.bean;

import com.forzhihu.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tc on 2017/2/27.
 */

public class LeftItem {

    public static List<LeftItemInfo> getItemBeans() {
        List<LeftItemInfo> itemBeans = new ArrayList<>();
        itemBeans.add(new LeftItemInfo(R.mipmap.menu_01, "Friends"));
        itemBeans.add(new LeftItemInfo(R.mipmap.menu_02, "Message"));
        itemBeans.add(new LeftItemInfo(R.mipmap.menu_03, "Favorites"));
        itemBeans.add(new LeftItemInfo(R.mipmap.menu_04, "My Cart"));
        itemBeans.add(new LeftItemInfo(R.mipmap.menu_05, "Importtant"));
        itemBeans.add(new LeftItemInfo(R.mipmap.menu_05, "Importtant"));
        itemBeans.add(new LeftItemInfo(R.mipmap.menu_06, "Settings"));
        itemBeans.add(new LeftItemInfo(R.mipmap.menu_07, "Logout"));
        return itemBeans;
    }
}
