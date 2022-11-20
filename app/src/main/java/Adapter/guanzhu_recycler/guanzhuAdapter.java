package Adapter.guanzhu_recycler;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zhihu.Activity.clickable;
import com.example.zhihu.Activity.guanzhuActivity;
import com.example.zhihu.R;

import java.util.List;

public class guanzhuAdapter extends RecyclerView.Adapter<guanzhuAdapter.guanzhuAdapter_ViewHolder> {
    private List<guanzhu_news>mList;

    public guanzhuAdapter(List<guanzhu_news> list) {
        mList = list;
    }

    @NonNull
    @Override
    public guanzhuAdapter.guanzhuAdapter_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.guanzhu_recycler,parent,false);
        return new guanzhuAdapter_ViewHolder(view);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull guanzhuAdapter.guanzhuAdapter_ViewHolder holder, int position) {
        holder.title.setText(mList.get(position).title);
        holder.author.setText(mList.get(position).author);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), guanzhuActivity.class);
                String url = mList.get(position).id;
                intent.putExtra("data",url);
                view.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class guanzhuAdapter_ViewHolder extends RecyclerView.ViewHolder {
        TextView author;
        TextView title;

        public guanzhuAdapter_ViewHolder(@NonNull View itemView) {
            super(itemView);
            author = itemView.findViewById(R.id.guanzhu_author);
            title = itemView.findViewById(R.id.guanzhu_title);

        }
    }
}
