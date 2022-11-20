package com.example.zhihu.shouye.tuijian.quanzhan;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhihu.R;

import java.util.ArrayList;
import java.util.List;

import Adapter.banner.DataBean;
import Adapter.banner.ImageAdapter;
import Adapter.quanzhan_Recycler.news;
import Adapter.quanzhan_Recycler.quanzhan_recycler;
import OkHttp.OkHttp;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link quanzhanFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class quanzhanFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public List<news>mList1 = new ArrayList<>();
    List<DataBean> mList = new ArrayList<>();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View view;
    public quanzhanFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment quanzhanFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static quanzhanFragment newInstance(String param1, String param2) {
        quanzhanFragment fragment = new quanzhanFragment();
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
        if(view == null) {
            view = inflater.inflate(R.layout.fragment_quanzhan, container, false);
        }
        ImageAdapter imageAdapter  =  new ImageAdapter(getActivity(),mList);
        quanzhan_recycler adapter = new quanzhan_recycler(mList1);
        new OkHttp().sendOkHttp(getActivity(),mList1,adapter);
        RecyclerView recyclerView = view.findViewById(R.id.quanzhan_recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

//        initDate();

//        mbanner = view.findViewById(R.id.banner);
//        mbanner.setAdapter(imageAdapter);
//        mbanner.isAutoLoop(true);
//        // Set an indicator for Banner.
//        mbanner.setIndicator(new CircleIndicator(getActivity()));
//        mbanner.start();

        return view;

    }
    private void initDate(){
        mList.add(new DataBean(R.drawable.picture));

    }


}