package OkHttp;

import android.app.Activity;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import Adapter.guanzhu_recycler.guanzhuAdapter;

import Adapter.guanzhu_recycler.guanzhu_news;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import api.news;
public class OkHttp_2 {
    public void sendOkHttp(Activity activity, List<guanzhu_news> mList, guanzhuAdapter adapter){
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder().url("https://news-at.zhihu.com/api/3/section/2").build();
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

    private void showResponse(String responseData, Activity activity, List<guanzhu_news> mList, guanzhuAdapter adapter) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
              Gson gson  = new Gson();
              news news = gson.fromJson(responseData,news.class);
              for(int i = 0;i<news.stories.size();i++){
                  guanzhu_news news1 = new guanzhu_news();
                  String url = news.stories.get(i).url;
                  String data = news.stories.get(i).displayDate;
                  String title = news.stories.get(i).title;
                  news1.title = data;
                  news1.author =title;
                  news1.id = url;
                  mList.add(news1);
                  adapter.notifyDataSetChanged();

              }

            }
        });
    }
}
