package Adapter.quanzhan_Recycler;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zhihu.Activity.clickable;
import com.example.zhihu.R;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class quanzhan_recycler extends RecyclerView.Adapter<quanzhan_recycler.ViewHolder> {
    private List<news>mList;
    View view;
    public quanzhan_recycler(List<news> list) {
        mList = list;
    }

    @NonNull
    @Override
    public quanzhan_recycler.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quanzhan_okhttp,parent,false);
        return new ViewHolder(view);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull quanzhan_recycler.ViewHolder holder, int position) {
        CardView cardView = view.findViewById(R.id.cardView);
        holder.title.setText(mList.get(position).news);
        holder.author.setText(mList.get(position).author);
        String url = mList.get(position).images.toString();
        Log.d("picture",url);
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

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title ;
        TextView author;
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.quanzhan_okhttp_textview);
            author = itemView.findViewById(R.id.author);
            image = itemView.findViewById(R.id.quanzhan_image);
        }
    }
}
