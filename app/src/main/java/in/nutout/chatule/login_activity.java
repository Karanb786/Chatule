package in.nutout.chatule;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class login_activity extends AppCompatActivity {
    FirebaseDatabase db;
    DatabaseReference rf;
    FirebaseRecyclerOptions<post> options;
    FirebaseRecyclerAdapter<post,myRecycle>adapter;

EditText name,password;
Button sumbit;
RecyclerView recycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);

        name=findViewById(R.id.name);
        password=findViewById(R.id.password);
        sumbit = findViewById(R.id.submit);
        recycle = findViewById(R.id.recycle);

        db=FirebaseDatabase.getInstance();
        rf=db.getReference("USER");
        sumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postComment();
                diaplayall();
            }
        });


    }

    private void postComment() {

        String title= name.getText().toString().trim();
        String title2= password.getText().toString().trim();
        post post = new post(title,title2);
        rf.push().setValue(post);

        adapter.notifyDataSetChanged();





    }

    private void diaplayall() {
         options=
                new FirebaseRecyclerOptions.Builder<post>()
                .build();
        adapter=
                new FirebaseRecyclerAdapter<post, myRecycle>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull myRecycle holder, int position, @NonNull post model) {
                        holder.txt_titile.setText(model.getTitle());
                        holder.txt_title_pass.setText(model.getTitle2());
                    }

                    @NonNull
                    @Override
                    public myRecycle onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                        View itemvew = LayoutInflater.from(getBaseContext()).inflate(R.layout.post_item,viewGroup,false);
                        return new myRecycle(itemvew);
                    }
                };
        adapter.startListening();
        recycle.setAdapter(adapter);

    }
}
