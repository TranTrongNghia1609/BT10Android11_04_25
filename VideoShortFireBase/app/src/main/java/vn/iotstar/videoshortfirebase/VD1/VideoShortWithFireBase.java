package vn.iotstar.videoshortfirebase.VD1;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import vn.iotstar.videoshortfirebase.R;
import vn.iotstar.videoshortfirebase.adapter.VideosFireBaseAdapter;
import vn.iotstar.videoshortfirebase.model.VideoModel1;

public class VideoShortWithFireBase extends AppCompatActivity {

    ViewPager2 viewPager2;
    private VideosFireBaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_video_short_with_fire_base);
        viewPager2 = findViewById(R.id.vpager2);
        getVideos();

    }
    private void getVideos() {
        // ** set database*/
        DatabaseReference mDataBase = FirebaseDatabase.getInstance().getReference( "Video");
        FirebaseRecyclerOptions<VideoModel1> options = new FirebaseRecyclerOptions.Builder<VideoModel1>()
                .setQuery(mDataBase, VideoModel1.class).build();
        adapter = new VideosFireBaseAdapter(options);
        viewPager2.setOrientation(viewPager2.ORIENTATION_HORIZONTAL);
        viewPager2.setAdapter(adapter);
    }
    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }
}