package OkHttp;

import android.app.Activity;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import Adapter.quanzhan_Recycler.news;
import Adapter.quanzhan_Recycler.quanzhan_recycler;
import Adapter.rebangAdapter.passage;
import Adapter.rebangAdapter.rebang_recycler;
import api.api;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttp_1 {
    public void sendOkHttp(Activity activity, List<passage> mList, rebang_recycler adapter){
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder().url("https://news-at.zhihu.com/api/4/news/latest").build();
                Call call=client.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        System.out.println("shibai");
                    }
                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        response = client.newCall(request).execute();
                        String responseData  = response.body().string();
                        showResponse(responseData,activity,mList,adapter);
                    }
                });
            }
        }).start();
    }
    public void showResponse(String responseData,Activity activity, List<passage> mList, rebang_recycler adapter){
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Gson gson = new Gson();
                api api = gson.fromJson(responseData, api.class);
                for (int i = 0; i < api.topStories.size(); i++) {
                    passage passage = new passage();
                    passage.author = api.topStories.get(i).hint;
                    passage.passage = api.topStories.get(i).title;
                    passage.id =api.topStories.get(i).id.toString();
                    Log.d("LOG1",passage.author);
                    mList.add(passage);
                    adapter.notifyDataSetChanged();
                }
            }
        });


    }
}
