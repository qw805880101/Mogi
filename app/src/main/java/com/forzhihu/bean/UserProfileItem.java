package com.forzhihu.bean;

import com.forzhihu.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tc on 2017/3/1.
 */

public class UserProfileItem {

    public static List<UserProfileInfo> getUserProfile() {
        List<UserProfileInfo> mList = new ArrayList<>();
        mList.add(new UserProfileInfo(R.mipmap.main_bg, "Randy Jenkins", "TODAY, 14:35", "Nam porttitor blandit " +
                "accumsan. Ut veldictum sem, a pretium dui. Curabitur atvestibulum nisi. Nullam vehicula nisi velit."));
        mList.add(new UserProfileInfo(R.mipmap.main_bg, "Elizabeth Delgado", "TODAY, 14:35", "Fusce vehicula dolor " +
                "arcu, sit amet blandit dolor mollis nec. Donec viverra eleifend lacus, vitae ullamcorper metus."));
//        mList.add(new UserProfileInfo(R.mipmap.main_bg, "Randy Jenkins", "TODAY, 14:35", ""));
//        mList.add(new UserProfileInfo(R.mipmap.main_bg, "Randy Jenkins", "TODAY, 14:35", ""));
//        mList.add(new UserProfileInfo(R.mipmap.main_bg, "Randy Jenkins", "TODAY, 14:35", ""));
        return mList;
    }

}
