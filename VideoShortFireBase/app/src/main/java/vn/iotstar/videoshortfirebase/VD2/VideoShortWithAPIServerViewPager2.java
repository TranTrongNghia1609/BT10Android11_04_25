package vn.iotstar.videoshortfirebase.VD2;

import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.iotstar.videoshortfirebase.API.APIService;
import vn.iotstar.videoshortfirebase.R;
import vn.iotstar.videoshortfirebase.adapter.VideosAdapter;
import vn.iotstar.videoshortfirebase.model.MessageVideoModel;
import vn.iotstar.videoshortfirebase.model.VideoModel;

public class VideoShortWithAPIServerViewPager2 extends AppCompatActivity {
    private ViewPager2 viewPager2;
    private VideosAdapter adapter;
    private List<VideoModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_video_short_with_apiserver_view_pager2);
        viewPager2 = findViewById(R.id.vpager);
        list = new ArrayList<>();
        getVideos();

    }
    private void getVideos() {
        APIService.serviceApi.getVideo().enqueue(new Callback<MessageVideoModel>() {
            @Override
            public void onResponse(Call<MessageVideoModel> call, Response<MessageVideoModel> response) {
                list =  response.body().getResult();
                adapter = new VideosAdapter(getApplicationContext(), list);
                viewPager2.setOrientation(viewPager2.ORIENTATION_HORIZONTAL);
                viewPager2.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<MessageVideoModel> call, Throwable t) {
                Log.e("API_ERROR", "Response body is null or unsuccessful: " + t.getMessage());
            }
        });
    }
}