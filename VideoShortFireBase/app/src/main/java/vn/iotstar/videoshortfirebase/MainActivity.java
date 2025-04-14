package vn.iotstar.videoshortfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import vn.iotstar.videoshortfirebase.VD1.UploadVideoActivity;
import vn.iotstar.videoshortfirebase.VD1.VideoShortWithFireBase;
import vn.iotstar.videoshortfirebase.VD2.VideoShortWithAPIServerViewPager2;
import vn.iotstar.videoshortfirebase.login_signup.SignUpActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button btn_api = findViewById(R.id.btn_videoapi);
        btn_api.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, VideoShortWithAPIServerViewPager2.class);
            startActivity(intent);
        });
        Button btn_signup = findViewById(R.id.btn_signup);
        btn_signup.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
            startActivity(intent);
        });
        Button btn_videofirebase = findViewById(R.id.btn_videoFirebase);
        btn_videofirebase.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, VideoShortWithFireBase.class);
            startActivity(intent);
        });
        Button btn_uploadvideo = findViewById(R.id.btn_upload);
        btn_uploadvideo.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, UploadVideoActivity.class);
            startActivity(intent);
        });
    }
}