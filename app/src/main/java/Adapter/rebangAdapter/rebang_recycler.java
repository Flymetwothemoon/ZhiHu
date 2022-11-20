package Adapter.rebangAdapter;

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
import com.example.zhihu.Activity.xiangfa;
import com.example.zhihu.R;

import java.util.List;

public class rebang_recycler extends RecyclerView.Adapter<rebang_recycler.rebang_recyclerViewHolder> {
    List<passage>mList;

    public rebang_recycler(List<passage> list) {
        mList = list;
    }

    @NonNull
    @Override
    public rebang_recycler.rebang_recyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rebang,parent,false);
        return new rebang_recyclerViewHolder(view);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull rebang_recycler.rebang_recyclerViewHolder holder, int position) {
        holder.author.setText(mList.get(position).author);
        holder.title.setText(mList.get(position).passage);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), clickable.class);
                String id = mList.get(position).id;
                Log.d("LOG1","ID"+id);
                intent.putExtra("id",id);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class rebang_recyclerViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView author;
        public rebang_recyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            title  = itemView.findViewById(R.id.title1);
            author = itemView.findViewById(R.id.author1);
        }
    }
}
