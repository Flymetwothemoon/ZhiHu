package Adapter.banner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zhihu.R;
import com.youth.banner.adapter.BannerAdapter;

import java.util.List;

public class ImageAdapter extends BannerAdapter<DataBean, ImageAdapter.BannerViewHolder> {

    Context context;

    public ImageAdapter(Context context,List<DataBean> datas) {
        super(datas);
        this.context = context;
    }

    @Override
    public ImageAdapter.BannerViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        return new BannerViewHolder(LayoutInflater.from(context).inflate(R.layout.banner,parent,false));
    }

    @Override
    public void onBindView(ImageAdapter.BannerViewHolder holder, DataBean data, int position, int size) {
      holder.imageview.setImageResource(data.getPicture());
    }
    class BannerViewHolder extends RecyclerView.ViewHolder{
        ImageView imageview;
        public BannerViewHolder(@NonNull View itemView) {
            super(itemView);
            imageview = itemView.findViewById(R.id.image);
        }
    }
}
