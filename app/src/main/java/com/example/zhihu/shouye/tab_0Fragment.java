package com.example.zhihu.shouye;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zhihu.R;

import java.util.ArrayList;
import java.util.List;

import Adapter.banner.ImageAdapter;
import Adapter.quanzhan_Recycler.quanzhan_recycler;
import Adapter.rebangAdapter.passage;
import Adapter.rebangAdapter.rebang_recycler;
import OkHttp.OkHttp_1;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link tab_0Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class tab_0Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    View rootView;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private List<passage>mList = new ArrayList<>();

    public tab_0Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment tab_0Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static tab_0Fragment newInstance(String param1, String param2) {
        tab_0Fragment fragment = new tab_0Fragment();
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
            rootView = inflater.inflate(R.layout.fragment_tab_0, container, false);
        }
        rebang_recycler mRebang_recycler = new rebang_recycler(mList);
        new OkHttp_1().sendOkHttp(getActivity(),mList,mRebang_recycler);
        RecyclerView recyclerView = rootView.findViewById(R.id.tab_0recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mRebang_recycler);
        return rootView;
    }




}