package Adapter.xiangfa_recycler;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zhihu.Activity.xiangfa;
import com.example.zhihu.R;

import java.util.List;

public class think_recycler extends RecyclerView.Adapter<think_recycler.ViewHolder> {
    private List<think>mList;

    public think_recycler(List<think> list) {
        mList = list;
    }

    @NonNull
    @Override
    public think_recycler.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.xiangfa,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull think_recycler.ViewHolder holder, int position) {
        holder.mView.setText(mList.get(position).text);
        holder.mImageView.setImageResource(mList.get(position).picture);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(view.getContext(), xiangfa.class);
                String name  = holder.mView.getText().toString();
                intent1.putExtra("data",name);
                view.getContext().startActivity(intent1);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView ;
        TextView mView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.xiangfa_image);
            mView = itemView.findViewById(R.id.xiangfa_text);
        }
    }
}
