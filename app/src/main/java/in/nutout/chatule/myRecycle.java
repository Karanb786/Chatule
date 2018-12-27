package in.nutout.chatule;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class myRecycle extends RecyclerView.ViewHolder {
    TextView txt_titile,txt_title_pass;

    public myRecycle(@NonNull View itemView) {
        super(itemView);
        txt_title_pass=itemView.findViewById(R.id.txt_title_pas);
        txt_titile=itemView.findViewById(R.id.txt_title);

    }
}
