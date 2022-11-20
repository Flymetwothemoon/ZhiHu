package Adapter.xiangfaViewpager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zhihu.R;

import java.util.List;

public class xiangfaviewpager2Adapter extends RecyclerView.Adapter<xiangfaviewpager2Adapter.xiangfaviewpager2AdapterviewHolder> {
    List<Image>mList;

    public xiangfaviewpager2Adapter(List<Image> list) {
        mList = list;
    }

    @NonNull
    @Override
    public xiangfaviewpager2Adapter.xiangfaviewpager2AdapterviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.xiangfaviewpager2,parent,false);
        return new xiangfaviewpager2AdapterviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull xiangfaviewpager2Adapter.xiangfaviewpager2AdapterviewHolder holder, int position) {
        holder.image.setImageResource(mList.get(position).image11);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class xiangfaviewpager2AdapterviewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        public xiangfaviewpager2AdapterviewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.xiangfa_viewpager2_image);
        }
    }
}
