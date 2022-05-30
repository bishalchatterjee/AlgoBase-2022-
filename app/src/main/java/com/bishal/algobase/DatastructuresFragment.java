package com.bishal.algobase;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;


public class DatastructuresFragment extends Fragment {

    ImageView menu_iv, visualise_img1,visualise_img2,visualise_img3,visualise_img4,visualise_img5,visualise_img6,visualise_img7,visualise_img8,visualise_img9,visualise_img10;
    CardView ds_item_1,ds_item_2,ds_item_3,ds_item_4,ds_item_5,ds_item_6,ds_item_7,ds_item_8,ds_item_9,ds_item_10;
    ConstraintLayout MainArea;
    LinearLayout Youtube_Layout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_datastructures, container, false);
        menu_iv=view.findViewById(R.id.menu_iv);


        MainArea=view.findViewById(R.id.MainArea);
        Youtube_Layout=view.findViewById(R.id.Youtube_Layout);
        Youtube_Layout.setVisibility(View.GONE);

        //ds items linking
        ds_item_1=view.findViewById(R.id.ds_item_1);
        ds_item_2=view.findViewById(R.id.ds_item_2);
        ds_item_3=view.findViewById(R.id.ds_item_3);
        ds_item_4=view.findViewById(R.id.ds_item_4);
        ds_item_5=view.findViewById(R.id.ds_item_5);
        ds_item_6=view.findViewById(R.id.ds_item_6);
        ds_item_7=view.findViewById(R.id.ds_item_7);
        ds_item_8=view.findViewById(R.id.ds_item_8);
        ds_item_9=view.findViewById(R.id.ds_item_9);
        ds_item_10=view.findViewById(R.id.ds_item_10);


        visualise_img1= view.findViewById(R.id.visualize1);
        visualise_img2= view.findViewById(R.id.visualize2);
        visualise_img3= view.findViewById(R.id.visualize3);
        visualise_img4= view.findViewById(R.id.visualize4);
        visualise_img5= view.findViewById(R.id.visualize5);
        visualise_img6= view.findViewById(R.id.visualize6);
        visualise_img7= view.findViewById(R.id.visualize7);
        visualise_img8= view.findViewById(R.id.visualize8);
        visualise_img9= view.findViewById(R.id.visualize9);
        visualise_img10= view.findViewById(R.id.visualize10);

        //Rotation animation of visualize iv
        AnimationSet animSet = new AnimationSet(true);
        animSet.setInterpolator(new DecelerateInterpolator());
        animSet.setFillAfter(true);
        animSet.setFillEnabled(true);

        final RotateAnimation animRotate = new RotateAnimation(0.0f, -360.0f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);

        animRotate.setDuration(1500);
        animRotate.setFillAfter(true);
        animSet.addAnimation(animRotate);

        //Rotation animation of menu iv
        AnimationSet animSet2 = new AnimationSet(true);
        animSet2.setInterpolator(new DecelerateInterpolator());
        animSet2.setFillAfter(true);
        animSet2.setFillEnabled(true);
        final RotateAnimation animRotate2 = new RotateAnimation(0.0f, 360.0f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);

        animRotate2.setDuration(2500);
        animRotate2.setFillAfter(true);
        animSet2.addAnimation(animRotate2);

        menu_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu_iv.startAnimation(animSet2);
                Intent i = new Intent(getActivity(), MenuActivity.class);
                startActivity(i);
            }
        });



        ds_item_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visualise_img1.startAnimation(animSet);
                //replace the fragment layout to another frgment it info frag
                //use setter getter to pass layout id
                Bundle bundle = new Bundle();
                bundle.putString("YourKey", "1");
                InformationFragment i=new InformationFragment();
                i.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout3,i).addToBackStack(null).commit();
            }
        });
        ds_item_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visualise_img2.startAnimation(animSet);
                //replace the fragment layout to another frgment it info frag
                //use setter getter to pass layout id
                Bundle bundle = new Bundle();
                bundle.putString("YourKey", "2");
                InformationFragment i=new InformationFragment();
                i.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout3,i).addToBackStack(null).commit();
            }
        });
        ds_item_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visualise_img3.startAnimation(animSet);
                //replace the fragment layout to another frgment it info frag
                //use setter getter to pass layout id
                Bundle bundle = new Bundle();
                bundle.putString("YourKey", "3");
                InformationFragment i=new InformationFragment();
                i.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout3,i).addToBackStack(null).commit();
            }
        });
        ds_item_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visualise_img4.startAnimation(animSet);
                //replace the fragment layout to another frgment it info frag
                //use setter getter to pass layout id
                Bundle bundle = new Bundle();
                bundle.putString("YourKey", "4");
                InformationFragment i=new InformationFragment();
                i.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout3,i).addToBackStack(null).commit();
            }
        });
        ds_item_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visualise_img5.startAnimation(animSet);
                //replace the fragment layout to another frgment it info frag
                //use setter getter to pass layout id
                Bundle bundle = new Bundle();
                bundle.putString("YourKey", "5");
                InformationFragment i=new InformationFragment();
                i.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout3,i).addToBackStack(null).commit();
            }
        });
        ds_item_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visualise_img6.startAnimation(animSet);
                //replace the fragment layout to another frgment it info frag
                //use setter getter to pass layout id
                Bundle bundle = new Bundle();
                bundle.putString("YourKey", "6");
                InformationFragment i=new InformationFragment();
                i.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout3,i).addToBackStack(null).commit();
            }
        });
        ds_item_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visualise_img7.startAnimation(animSet);
                //replace the fragment layout to another frgment it info frag
                //use setter getter to pass layout id
                Bundle bundle = new Bundle();
                bundle.putString("YourKey", "7");
                InformationFragment i=new InformationFragment();
                i.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout3,i).addToBackStack(null).commit();
            }
        });
        ds_item_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visualise_img8.startAnimation(animSet);
                //replace the fragment layout to another frgment it info frag
                //use setter getter to pass layout id
                Bundle bundle = new Bundle();
                bundle.putString("YourKey", "8");
                InformationFragment i=new InformationFragment();
                i.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout3,i).addToBackStack(null).commit();
            }
        });
        ds_item_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visualise_img9.startAnimation(animSet);
                //replace the fragment layout to another frgment it info frag
                //use setter getter to pass layout id
                Bundle bundle = new Bundle();
                bundle.putString("YourKey", "9");
                InformationFragment i=new InformationFragment();
                i.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout3,i).addToBackStack(null).commit();
            }
        });
        ds_item_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visualise_img10.startAnimation(animSet);
                //replace the fragment layout to another frgment it info frag
                //use setter getter to pass layout id
                Bundle bundle = new Bundle();
                bundle.putString("YourKey", "10");
                InformationFragment i=new InformationFragment();
                i.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout3,i).addToBackStack(null).commit();
            }
        });

        //Visualize linker
        visualise_img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visualise_img1.startAnimation(animSet);
                Youtube_Layout.setVisibility(View.VISIBLE);
                MainArea.setVisibility(View.GONE);
                YouTubePlayerView youTubePlayerView = view.findViewById(R.id.youtube_player_view);
                getLifecycle().addObserver(youTubePlayerView);

                youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                    @Override
                    public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                        String videoId = "p5TDnxAYAZY";
                        youTubePlayer.loadVideo(videoId, 0);
                    }
                });
            }
        });

        return view;
    }

}