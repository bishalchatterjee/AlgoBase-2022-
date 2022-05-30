package com.bishal.algobase;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class MenuActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button login_btn, logout_btn;
    TextView hi_tv, name_tv, app_title_menu, logged_usernamer,logged__gmail,Account_info_title1,Account_info_title2,not_loggedIn;
    Spinner spinner1;
    SwitchCompat theme_switch;
    ImageView share_iv, rate_iv, accountinfo_iv, support_iv,gmail_iv,feedback_iv;
    RelativeLayout AccountInfo;
    private AlertDialog.Builder builder;
    private AlertDialog custom_dialog;
    Animation app_name_animation, customer_support;

    //Rate(Play-Store) function
   public void playstoreApp(){
       Uri uri = Uri.parse("market://details?id=com.bishal.algobase");   //will add the app link when its live on play store
       Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
       // To count with Play market backstack, After pressing back button,
       // to taken back to our application, we need to add following flags to intent.
       goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_NEW_DOCUMENT | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
       try {
           startActivity(goToMarket);
       } catch (ActivityNotFoundException e) {
           startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id=com.bishal.algobase")));
       }
   }
   //Share app function
    public void shareApp(){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Hey Check Out This App At: https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID);
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }
    //omClick Functions (Support image view)
    public void onClickInstagram(View view){
        Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.instagram.com/_bishal_08/"));
        startActivity(viewIntent);
    }
    public void onClickLinkedIn(View view){
        Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.linkedin.com/in/bishal-chatterjee-03304721b"));
        startActivity(viewIntent);
    }
    public void onClickGitHub(View view){
        Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse("https://github.com/bishalchatterjee"));
        startActivity(viewIntent);
    }
    public void onClickEmail(View view){ //to copy email to clipboard
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("Email", "bishalc430@gmail.com");
        clipboard.setPrimaryClip(clip);

        Toast.makeText(MenuActivity.this, "Email Copied to Clipboard", Toast.LENGTH_LONG).show();
    }
    //feedback intent
    public void feedback(View view) {
        Intent intent = (new Intent(getApplicationContext(), MailActivity.class));
        startActivity(intent);
    }
   //Spinner1
    public void versionInfo(View view){
        builder=new AlertDialog.Builder(this);
        View aboutPopUp1= getLayoutInflater().inflate(R.layout.about_info,null);
        builder.setView(aboutPopUp1);
        custom_dialog=builder.create();
        custom_dialog.show();
    }
    public void developerInfo(View view){
        builder=new AlertDialog.Builder(this);
        View aboutPopUp2= getLayoutInflater().inflate(R.layout.developer_info,null);
        builder.setView(aboutPopUp2);
        custom_dialog=builder.create();
        custom_dialog.show();
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // remove the action bar and setting display to full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //google sign in auth
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        GoogleSignInClient googleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions);
        GoogleSignInAccount googleSignInAccount = GoogleSignIn.getLastSignedInAccount(this);


        //linking IDs'
        login_btn = findViewById(R.id.login_btn);
        logout_btn = findViewById(R.id.logout_btn);

        name_tv = findViewById(R.id.name_tv);
        hi_tv = findViewById(R.id.hi_tv);
        hi_tv = findViewById(R.id.hi_tv);
        Account_info_title1 = findViewById(R.id.Account_info_title1);
        Account_info_title2 = findViewById(R.id.Account_info_title2);
        logged__gmail = findViewById(R.id.logged_gmail);
        logged_usernamer = findViewById(R.id.logged_username);
        not_loggedIn = findViewById(R.id.not_loggedIn);
        app_title_menu = findViewById(R.id.app_title_menu);

        theme_switch = findViewById(R.id.darkmode_switch);


        share_iv = findViewById(R.id.share_iv);
        rate_iv = findViewById(R.id.rate_iv);
        accountinfo_iv = findViewById(R.id.accountinfo_iv);
        support_iv = findViewById(R.id.support_iv);
        gmail_iv = findViewById(R.id.gmail_iv);
        feedback_iv = findViewById(R.id.feedback_iv);

        spinner1 = findViewById(R.id.spinner1);

        AccountInfo=findViewById(R.id.AccountInfo);
        AccountInfo.setVisibility(RelativeLayout.GONE);
        //animation
        app_name_animation = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        app_title_menu.setAnimation(app_name_animation);

        //animation for support icon
        customer_support = AnimationUtils.loadAnimation(this, R.anim.experimental_animation);
        support_iv.setAnimation(customer_support);
        //spinner adapters
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.drowpdown1, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(this);


        int nightModeFlags = getApplicationContext().getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        switch (nightModeFlags) {
            case Configuration.UI_MODE_NIGHT_YES:
                theme_switch.setChecked(true);
                break;

            case Configuration.UI_MODE_NIGHT_NO:
                theme_switch.setChecked(false);
                break;
        }

        theme_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    restart();
                }
            }
        });

        share_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             shareApp();
            }
        });
        rate_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               playstoreApp();
            }
        });
        support_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder=new AlertDialog.Builder(MenuActivity.this);
                View aboutPopUp1= getLayoutInflater().inflate(R.layout.support_menu,null);
                builder.setView(aboutPopUp1);
                custom_dialog=builder.create();
                custom_dialog.show();
            }
        });
        feedback_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              feedback(view);
            }
        });


        //google accounts not null then perform else app will crash
        if (googleSignInAccount != null) {
            final String getUsername = googleSignInAccount.getDisplayName();
            final String getGmail = googleSignInAccount.getEmail();
            final Uri getPhotoUrl=googleSignInAccount.getPhotoUrl();

            not_loggedIn.setVisibility(View.GONE);
            Glide.with(MenuActivity.this).load(getPhotoUrl).into(gmail_iv);//getting user g-mail profile photo


            //checking if first word of name is in UpperCase; if yes change its characters to LowerCase except first character
            String modifyUsername = "";
            modifyUsername = getUsername.substring(1, getUsername.indexOf(' '));
            modifyUsername = modifyUsername.toLowerCase();
            name_tv.setText(getUsername.charAt(0) + modifyUsername + "!");


            // if user is logged in we need to hide the log in button & display log out only since both button are overlapping
            login_btn.setVisibility(View.GONE);
            login_btn.setEnabled(false);

            logout_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    googleSignInClient.signOut();
                    startActivity(new Intent(MenuActivity.this, SignupActivity.class));
                    finish();
                }
            });
            accountinfo_iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AccountInfo.setVisibility(RelativeLayout.VISIBLE);
                    logged_usernamer.setText(getUsername);
                    logged__gmail.setText(getGmail);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            AccountInfo.setVisibility(RelativeLayout.GONE);
                        }
                    },5000);

                }
            });
        } else {
            hi_tv.setText("");
            gmail_iv.setVisibility(View.GONE);
            // to re enable the buttons
            logout_btn.setVisibility(View.GONE);
            login_btn.setVisibility(View.VISIBLE);
            login_btn.setEnabled(true);

            login_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    googleSignInClient.signOut();
                    startActivity(new Intent(MenuActivity.this, SignupActivity.class));
                    finish();
                }
            });
            accountinfo_iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AccountInfo.setVisibility(RelativeLayout.VISIBLE);
                    not_loggedIn.setVisibility(View.VISIBLE);
                    not_loggedIn.setText("Your Are Not Logged In! Please LogIn!");
                    Account_info_title1.setText("");
                    Account_info_title2.setText("");
                    logged_usernamer.setText("");
                    logged__gmail.setText("");
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            AccountInfo.setVisibility(RelativeLayout.GONE);
                        }
                    },5000);
                }
            });
        }
    }

 //restart the activity after dark ui enabled
    private void restart() {
        Intent intent=(new Intent(getApplicationContext(), MenuActivity.class));
        startActivity(intent);
        finish();
    }

    //Spinner driver functions
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //making Spinner text null
        ((TextView) view).setText(null);
            switch (position) {
                case 0:
                    break;
                case 1:
                    versionInfo(view);
                    break;
                case 2:
                    developerInfo(view);
                    break;
            }
        }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}