package com.bishal.algobase;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class SignupActivity extends AppCompatActivity {
    ImageView google_signin,skip_img;
    TextView app_name,skip_text,skip_text2;
    Animation app_name_animation,skip_text_animation,skip_text2_animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // remove the action bar and setting display to full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        google_signin=findViewById(R.id.google_signin_img);
        skip_img=findViewById(R.id.skip_img);


        app_name=findViewById(R.id.app_name);
        skip_text=findViewById(R.id.skip_text);
        skip_text2=findViewById(R.id.skip_text2);



       //animation for app title
        app_name_animation= AnimationUtils.loadAnimation(this, R.anim.experimental_animation);
        app_name.setAnimation(app_name_animation);

        //animation for Don't want to SignUp?
        skip_text_animation= AnimationUtils.loadAnimation(this, R.anim.interpolator_anim);
        skip_text.setAnimation(skip_text_animation);
        //animation for Tap the skip arrow
        skip_text2_animation= AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        skip_text2.setAnimation(skip_text2_animation);


        GoogleSignInOptions googleSignInOptions=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        GoogleSignInClient googleSignInClient= GoogleSignIn.getClient(this, googleSignInOptions);
        GoogleSignInAccount googleSignInAccount=GoogleSignIn.getLastSignedInAccount(this);

        if(googleSignInAccount !=null){
            Intent i = new Intent(SignupActivity.this, DashboardActivity.class);
            startActivity(i);
        }

        ActivityResultLauncher<Intent> activityResultLauncher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {

                //getting signed in account after user selected an account
                Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(result.getData());
                handleSignInTask(task);


            }


            private void handleSignInTask(Task<GoogleSignInAccount> task) {
                try {
                    GoogleSignInAccount account = task.getResult(ApiException.class);

                    final String getFullName=account.getDisplayName();
                    final String getEmail=account.getEmail();
                    final Uri getPhotoUrl=account.getPhotoUrl();

                    Intent i = new Intent(SignupActivity.this, DashboardActivity.class);
                    startActivity(i);
                    finish();
                } catch (ApiException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),"Failed To Fetch Account!",Toast.LENGTH_SHORT).show();
                }
            }
        });


        google_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signInIntent =googleSignInClient.getSignInIntent();
                activityResultLauncher.launch(signInIntent);
            }
        });





        skip_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignupActivity.this, DashboardActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}

