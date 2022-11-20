package com.example.zhihu;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhihu.Activity.MainActivity;

import java.util.ArrayList;
import java.util.List;

import Adapter.guanzhu_recycler.guanzhuAdapter;
import Adapter.guanzhu_recycler.guanzhu_news;
import OkHttp.OkHttp_2;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link guanzhuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class guanzhuFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View rootView;
    private List<guanzhu_news>mList = new ArrayList<>();
    public guanzhuFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment guanzhuFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static guanzhuFragment newInstance(String param1, String param2) {
        guanzhuFragment fragment = new guanzhuFragment();
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
            rootView = inflater.inflate(R.layout.fragment_guanzhu, container, false);
        }
        guanzhuAdapter adapter = new guanzhuAdapter(mList);
        new OkHttp_2().sendOkHttp(getActivity(),  mList,  adapter);
        RecyclerView recyclerView = rootView.findViewById(R.id.guanzhu_recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}