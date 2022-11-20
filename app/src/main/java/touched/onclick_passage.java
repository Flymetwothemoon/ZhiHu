package touched;

import android.content.Intent;
import android.view.View;

import androidx.cardview.widget.CardView;

import com.example.zhihu.Activity.clickable;

public class onclick_passage {
    public void click(CardView cardView, View view){
        Intent intent = new Intent(view.getContext(), clickable.class);
        view.getContext().startActivity(intent);
    }
}
