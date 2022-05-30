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

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class AlgorithmsFragment extends Fragment {

    ImageView menu_iv, visualise_img11,visualise_img12,visualise_img13,visualise_img14,visualise_img15,visualise_img16,visualise_img17,visualise_img18,visualise_img19;;
    CardView algo_item_1,algo_item_2,algo_item_3,algo_item_4,algo_item_5,algo_item_6,algo_item_7,algo_item_8,algo_item_9;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_algorithms, container, false);
        menu_iv=view.findViewById(R.id.menu_iv);


        //algo items linking
        algo_item_1=view.findViewById(R.id.algo_item_1);
        algo_item_2=view.findViewById(R.id.algo_item_2);
        algo_item_3=view.findViewById(R.id.algo_item_3);
        algo_item_4=view.findViewById(R.id.algo_item_4);
        algo_item_5=view.findViewById(R.id.algo_item_5);
        algo_item_6=view.findViewById(R.id.algo_item_6);
        algo_item_7=view.findViewById(R.id.algo_item_7);
        algo_item_8=view.findViewById(R.id.algo_item_8);
        algo_item_9=view.findViewById(R.id.algo_item_9);

        visualise_img11= view.findViewById(R.id.visualize11);
        visualise_img12= view.findViewById(R.id.visualize12);
        visualise_img13= view.findViewById(R.id.visualize13);
        visualise_img14= view.findViewById(R.id.visualize14);
        visualise_img15= view.findViewById(R.id.visualize15);
        visualise_img16= view.findViewById(R.id.visualize16);
        visualise_img17= view.findViewById(R.id.visualize17);
        visualise_img18= view.findViewById(R.id.visualize18);
        visualise_img19= view.findViewById(R.id.visualize19);



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




        algo_item_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visualise_img11.startAnimation(animSet);
                //replace the fragment layout to another frgment it info frag
                //use setter getter to pass layout id
                Bundle bundle = new Bundle();
                bundle.putString("YourKey", "11");
                InformationFragment i=new InformationFragment();
                i.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout5,i).addToBackStack(null).commit();
            }
        });
        algo_item_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visualise_img12.startAnimation(animSet);
                //replace the fragment layout to another frgment it info frag
                //use setter getter to pass layout id
                Bundle bundle = new Bundle();
                bundle.putString("YourKey", "12");
                InformationFragment i=new InformationFragment();
                i.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout5,i).addToBackStack(null).commit();
            }
        });
        algo_item_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visualise_img13.startAnimation(animSet);
                //replace the fragment layout to another frgment it info frag
                //use setter getter to pass layout id
                Bundle bundle = new Bundle();
                bundle.putString("YourKey", "13");
                InformationFragment i=new InformationFragment();
                i.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout5,i).addToBackStack(null).commit();
            }
        });
        algo_item_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visualise_img14.startAnimation(animSet);
                //replace the fragment layout to another frgment it info frag
                //use setter getter to pass layout id
                Bundle bundle = new Bundle();
                bundle.putString("YourKey", "14");
                InformationFragment i=new InformationFragment();
                i.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout5,i).addToBackStack(null).commit();
            }
        });
        algo_item_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visualise_img15.startAnimation(animSet);
                //replace the fragment layout to another frgment it info frag
                //use setter getter to pass layout id
                Bundle bundle = new Bundle();
                bundle.putString("YourKey", "15");
                InformationFragment i=new InformationFragment();
                i.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout5,i).addToBackStack(null).commit();
            }
        });
        algo_item_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visualise_img16.startAnimation(animSet);
                //replace the fragment layout to another frgment it info frag
                //use setter getter to pass layout id
                Bundle bundle = new Bundle();
                bundle.putString("YourKey", "16");
                InformationFragment i=new InformationFragment();
                i.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout5,i).addToBackStack(null).commit();
            }
        });
        algo_item_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visualise_img17.startAnimation(animSet);
                //replace the fragment layout to another frgment it info frag
                //use setter getter to pass layout id
                Bundle bundle = new Bundle();
                bundle.putString("YourKey", "17");
                InformationFragment i=new InformationFragment();
                i.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout5,i).addToBackStack(null).commit();
            }
        });
        algo_item_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visualise_img18.startAnimation(animSet);
                //replace the fragment layout to another frgment it info frag
                //use setter getter to pass layout id
                Bundle bundle = new Bundle();
                bundle.putString("YourKey", "18");
                InformationFragment i=new InformationFragment();
                i.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout5,i).addToBackStack(null).commit();
            }
        });
        algo_item_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visualise_img19.startAnimation(animSet);
                //replace the fragment layout to another frgment it info frag
                //use setter getter to pass layout id
                Bundle bundle = new Bundle();
                bundle.putString("YourKey", "19");
                InformationFragment i=new InformationFragment();
                i.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout5,i).addToBackStack(null).commit();
            }
        });

        return view;
    }
}