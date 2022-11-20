package com.example.zhihu.shouye.tuijian;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhihu.R;
import com.example.zhihu.shouye.tuijian.quanzhan.quanzhanFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

import Adapter.quanzhan_Recycler.news;
import ViewPager2.shouye.tuijian.tuijian_MyAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link tuijianFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class tuijianFragment extends Fragment {
    private View rootView;
    private ViewPager2 mViewPager2;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private TabLayout mTabLayout;
    public List<news>mList = new ArrayList<>();
    private List<Fragment> mFragments1 = new ArrayList<>();
    private List<String>tablayoutdata = new ArrayList<>();
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public tuijianFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment tuijianFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static tuijianFragment newInstance(String param1, String param2) {
        tuijianFragment fragment = new tuijianFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_tuijian, container, false);
        }

        init();
        mViewPager2 = rootView.findViewById(R.id.tuijian_viewpager2);
        tuijian_MyAdapter tuijian_myAdapter = new tuijian_MyAdapter(getParentFragmentManager(),getLifecycle(),mFragments1);

        mViewPager2.setAdapter(tuijian_myAdapter);
        mTabLayout = rootView.findViewById(R.id.tuijian_tablayout);
        new TabLayoutMediator(mTabLayout, mViewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(tablayoutdata.get(position));

            }
        }).attach();
        Log.d("LOG",tablayoutdata.toString());
        return rootView;
    }
    private void init(){
        mFragments1.add(quanzhanFragment.newInstance("haohao","1"));
        mFragments1.add(tuijian_tabFragment.newInstance("haohao","2"));
        mFragments1.add(tuijian_tabFragment.newInstance("haohao","3"));
        mFragments1.add(tuijian_tabFragment.newInstance("haohao","3"));
        mFragments1.add(tuijian_tabFragment.newInstance("haohao","3"));
        mFragments1.add(tuijian_tabFragment.newInstance("haohao","3"));
        mFragments1.add(tuijian_tabFragment.newInstance("haohao","3"));
        tablayoutdata.add("全站");
        tablayoutdata.add("好物");
        tablayoutdata.add("直播");
        tablayoutdata.add("高赞");
        tablayoutdata.add("电竞");
        tablayoutdata.add("健康");
        tablayoutdata.add("种草");
    }
}