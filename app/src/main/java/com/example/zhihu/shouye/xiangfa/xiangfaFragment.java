package com.example.zhihu.shouye.xiangfa;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhihu.R;

import java.util.ArrayList;
import java.util.List;

import Adapter.quanzhan_Recycler.news;
import Adapter.xiangfa_recycler.think;
import Adapter.xiangfa_recycler.think_recycler;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link xiangfaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class xiangfaFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private View mView;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private List<think>mList = new ArrayList<>();
    private String[]text = {"不愧是清华大佬,把Python整理成了漫画","歌尔算是苹果踢出的第二大体量供应商,第一个是欧菲光",
            "大家觉得乔布斯和库克谁更牛?口说无凭,我们拿数据说话","安卓系统和iOS系统区别，有这么大吗" +
            "请不要骗我","苹果到了14这代已经彻底摆烂了"};
    private int[]picture = {R.mipmap.xiangfa_image_0,
            R.mipmap.xiangfa_image_1,
            R.mipmap.xiangfa_image_2,
            R.mipmap.xiangfa_image_3,
            R.mipmap.xiangfa_image_4};
    public xiangfaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment xiangfaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static xiangfaFragment newInstance(String param1, String param2) {
        xiangfaFragment fragment = new xiangfaFragment();
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
        if(mView==null){
            mView = inflater.inflate(R.layout.fragment_xiangfa, container, false);
        }
        init();
        RecyclerView recyclerView = mView.findViewById(R.id.xiangfa_recycler);

        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        think_recycler adapter = new think_recycler(mList);
        recyclerView.setAdapter(adapter);
       return mView;
    }
    private void init(){
        for(int j = 0;j<20;j++) {
            for (int i = 0; i < text.length; i++) {
                think think = new think();
                think.text = text[i];
                think.picture = picture[i];
                mList.add(think);
            }
        }
        Log.d("LOG",mList.get(0).text);
        Log.d("LOG",mList.get(1).text);
//            think.picture = picture.get(1);
//            think.text = passage.get(1);
//            mList.add(think);
    }

}