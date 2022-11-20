package com.example.zhihu.shouye;

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
import com.example.zhihu.shouye.tuijian.tuijianFragment;
import com.example.zhihu.shouye.xiangfa.xiangfaFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

import ViewPager2.shouye.tab_0_MyAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link shouyeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class shouyeFragment extends Fragment {
    private View rootView;
    private ViewPager2 mViewPager2;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TabLayout mTabLayout;
    private List<Fragment>mFragments = new ArrayList<>();
    private List<String>tablayoutdata = new ArrayList<>();
    public shouyeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment shouyeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static shouyeFragment newInstance(String param1, String param2) {
        shouyeFragment fragment = new shouyeFragment();
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
            rootView = inflater.inflate(R.layout.fragment_shouye, container, false);
        }
        init();
        mViewPager2 = rootView.findViewById(R.id.shouye_ViewPager2);
        tab_0_MyAdapter tab_0_myAdapter = new tab_0_MyAdapter(getParentFragmentManager(),getLifecycle(),mFragments);
        mViewPager2.setAdapter(tab_0_myAdapter);
        mTabLayout = rootView.findViewById(R.id.shouye_tab);
        new TabLayoutMediator(mTabLayout, mViewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(tablayoutdata.get(position));

            }
        }).attach();
        Log.d("LOG",tablayoutdata.toString());
        return rootView;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
    public void init(){
        mFragments.add(xiangfaFragment.newInstance("haohao","1"));
        mFragments.add(tuijianFragment.newInstance("haohao","2"));
        mFragments.add(tab_0Fragment.newInstance("haohao","3"));
        tablayoutdata.add("想法");
        tablayoutdata.add("推荐");
        tablayoutdata.add("热榜");
    }

}