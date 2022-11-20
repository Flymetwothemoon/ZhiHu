package com.example.zhihu.huiyuan;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhihu.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

import ViewPager2.shouye.huiyuan.huiyuan_MyAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link huiyuanFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class huiyuanFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private View rootView;
    private ViewPager2 mViewPager2;
    private TabLayout mTabLayout;
    private List<Fragment> mFragments2 = new ArrayList<>();
    private List<String>tablayoutdata = new ArrayList<>();
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public huiyuanFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment huiyuanFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static huiyuanFragment newInstance(String param1, String param2) {
        huiyuanFragment fragment = new huiyuanFragment();
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
            rootView = inflater.inflate(R.layout.fragment_huiyuan, container, false);
        }
        init();
        Log.d("LOG",tablayoutdata.get(0).toString());
        mViewPager2 = rootView.findViewById(R.id.viewpager_huiyuan);
        huiyuan_MyAdapter huiyuan_myAdapter = new huiyuan_MyAdapter(getParentFragmentManager(),getLifecycle(),mFragments2);
        mViewPager2.setAdapter(huiyuan_myAdapter);
        mTabLayout = rootView.findViewById(R.id.huiyuan_tablayout);
        new TabLayoutMediator(mTabLayout, mViewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(tablayoutdata.get(position));
            }
        }).attach();
        return rootView;
    }
    private void init(){
        mFragments2.add(faxianFragment.newInstance("hao","1"));
        mFragments2.add(huiyuangouFragment.newInstance("hao","2"));
        mFragments2.add(table_1Fragment.newInstance("hao","3"));
        mFragments2.add(table_1Fragment.newInstance("hao","4"));
        mFragments2.add(table_1Fragment.newInstance("hao","5"));
        tablayoutdata.add("发现");
        tablayoutdata.add("会员购");
        tablayoutdata.add("盐故事");
        tablayoutdata.add("盐知识");
        tablayoutdata.add("盐书刊");
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}