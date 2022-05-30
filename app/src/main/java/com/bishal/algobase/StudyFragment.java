package com.bishal.algobase;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;


public class StudyFragment extends Fragment {
    ImageView menu_iv, androiddev_iv, angular_iv, backend_iv, cn_iv, cp_iv, dbms_iv, devops_iv, frontend_iv, java_iv, ml_iv, oops_iv, os_iv, python_iv, react_iv, placements_iv,
            book1_iv, book2_iv, book3_iv, book4_iv, book5_iv, book6_iv, book7_iv, book8_iv, book9_iv, book10_iv, book11_iv, book12_iv, book13_iv, book14_iv, book15_iv, book16_iv, book17_iv,
            site1_iv, site2_iv, site3_iv, site4_iv, site5_iv, site6_iv, site7_iv, site8_iv, site9_iv, site10_iv,
            compiler1_iv;

    ImageView firebase_alert_img,firebase_showAlert;

    SliderView sliderView;
    int[] images={R.drawable.vf_1,
            R.drawable.vf_2,
            R.drawable.vf_3,
            R.drawable.vf_4,
            R.drawable.vf_5,
            R.drawable.vf_6,
            R.drawable.vf_7,
            R.drawable.vf_8,
            R.drawable.vf_9,
            R.drawable.vf_10,
            R.drawable.vf_11,
            R.drawable.vf_12,
            R.drawable.vf_13,
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_study, container, false);

        menu_iv = view.findViewById(R.id.menu_iv);

        firebase_alert_img =view.findViewById(R.id.customAlertFirebase_img);
        firebase_alert_img.setVisibility(View.GONE);

        firebase_showAlert=view.findViewById(R.id.firebase_showAlert);


        //Roadmaps
        androiddev_iv = view.findViewById(R.id.androiddev_iv);
        angular_iv = view.findViewById(R.id.angular_iv);
        backend_iv = view.findViewById(R.id.backend_iv);
        cn_iv = view.findViewById(R.id.cn_iv);
        cp_iv = view.findViewById(R.id.cp_iv);
        dbms_iv = view.findViewById(R.id.dbms_iv);
        devops_iv = view.findViewById(R.id.devops_iv);
        frontend_iv = view.findViewById(R.id.frontend_iv);
        java_iv = view.findViewById(R.id.java_iv);
        ml_iv = view.findViewById(R.id.ml_iv);
        oops_iv = view.findViewById(R.id.oops_iv);
        os_iv = view.findViewById(R.id.os_iv);
        python_iv = view.findViewById(R.id.python_iv);
        react_iv = view.findViewById(R.id.react_iv);
        placements_iv = view.findViewById(R.id.placements_iv);


        //eBooks
        book1_iv = view.findViewById(R.id.book1_iv);
        book2_iv = view.findViewById(R.id.book2_iv);
        book3_iv = view.findViewById(R.id.book3_iv);
        book4_iv = view.findViewById(R.id.book4_iv);
        book5_iv = view.findViewById(R.id.book5_iv);
        book6_iv = view.findViewById(R.id.book6_iv);
        book7_iv = view.findViewById(R.id.book7_iv);
        book8_iv = view.findViewById(R.id.book8_iv);
        book9_iv = view.findViewById(R.id.book9_iv);
        book10_iv = view.findViewById(R.id.book10_iv);
        book11_iv = view.findViewById(R.id.book11_iv);
        book12_iv = view.findViewById(R.id.book12_iv);
        book13_iv = view.findViewById(R.id.book13_iv);
        book14_iv = view.findViewById(R.id.book14_iv);
        book15_iv = view.findViewById(R.id.book15_iv);
        book16_iv = view.findViewById(R.id.book16_iv);
        book17_iv = view.findViewById(R.id.book17_iv);


        //websites
        site1_iv = view.findViewById(R.id.site1_iv);
        site2_iv = view.findViewById(R.id.site2_iv);
        site3_iv = view.findViewById(R.id.site3_iv);
        site4_iv = view.findViewById(R.id.site4_iv);
        site5_iv = view.findViewById(R.id.site5_iv);
        site6_iv = view.findViewById(R.id.site6_iv);
        site7_iv = view.findViewById(R.id.site7_iv);
        site8_iv = view.findViewById(R.id.site8_iv);
        site9_iv = view.findViewById(R.id.site9_iv);
        site10_iv = view.findViewById(R.id.site10_iv);

        //online compilers
        compiler1_iv = view.findViewById(R.id.compiler1_iv);

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


        sliderView=view.findViewById(R.id.img_slider);

        SliderAdapter sliderAdapter=new SliderAdapter(images);

        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.THIN_WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference();

        DatabaseReference getImage = databaseReference.child("Images");


        getImage.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // getting a DataSnapshot for the location at the specified
                // relative path and getting in the link variable
                String link = dataSnapshot.getValue(String.class);
                Glide.with(StudyFragment.this).load(link).into(firebase_alert_img);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        menu_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu_iv.startAnimation(animSet2);
                Intent i = new Intent(getActivity(), MenuActivity.class);
                startActivity(i);
            }
        });

        firebase_showAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Loading Event Details",Toast.LENGTH_LONG).show();
                firebase_alert_img.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable(){
                    public void run() {
                        firebase_alert_img.setVisibility(View.GONE);
                    }
                }, 10000);
            }
        });



        //to check if device is connected to internet
        ConnectivityManager mConnectivityManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
        if (mNetworkInfo == null) {


            //reduce opacity if no internet is available and display the toast
            view.setAlpha(0.5f);


            //if not connected display the internet request toast
            View layouttoast = inflater.inflate(R.layout.internet_request, container, false);

            final Toast custom_toast = new Toast(getContext());
            custom_toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            custom_toast.setDuration(Toast.LENGTH_SHORT);
            custom_toast.setView(layouttoast);
            custom_toast.show(); //custom toast
            custom_toast.setDuration((int) 8000);


        }




        //start of Road-Map on click listeners

        androiddev_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Using Bundle to send data to Solution fragment
                Bundle bundle = new Bundle();
                bundle.putString("YourKey", "https://roadmap.sh/android");
                SolutionFragment sl = new SolutionFragment();
                sl.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout2, sl).addToBackStack(null).commit();
            }


        });
        angular_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Using Bundle to send data to Solution fragment
                Bundle bundle = new Bundle();
                bundle.putString("YourKey", "https://roadmap.sh/angular");
                SolutionFragment sl = new SolutionFragment();
                sl.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout2, sl).addToBackStack(null).commit();
            }


        });
        backend_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Using Bundle to send data to Solution fragment
                Bundle bundle = new Bundle();
                bundle.putString("YourKey", "https://roadmap.sh/backend");
                SolutionFragment sl = new SolutionFragment();
                sl.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout2, sl).addToBackStack(null).commit();
            }


        });
        cn_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Using Bundle to send data to Solution fragment
                Bundle bundle = new Bundle();
                bundle.putString("YourKey", "https://whimsical.com/networking-cheatsheet-by-love-babbar-FcLExFDezehhfsbDPfZDBv                                                                 ");
                SolutionFragment sl = new SolutionFragment();
                sl.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout2, sl).addToBackStack(null).commit();
            }


        });
        cp_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Using Bundle to send data to Solution fragment
                Bundle bundle = new Bundle();
                bundle.putString("YourKey", "https://whimsical.com/codeforces-candidate-master-roadmap-by-love-babbar-CiXPPD3CnwoXPr2d8Ajx1h");
                SolutionFragment sl = new SolutionFragment();
                sl.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout2, sl).addToBackStack(null).commit();
            }


        });
        dbms_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Using Bundle to send data to Solution fragment
                Bundle bundle = new Bundle();
                bundle.putString("YourKey", "https://whimsical.com/dbms-roadmap-by-love-babbar-FmUi8ffVop33t3MmpVxPCo  ");
                SolutionFragment sl = new SolutionFragment();
                sl.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout2, sl).addToBackStack(null).commit();
            }


        });
        devops_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Using Bundle to send data to Solution fragment
                Bundle bundle = new Bundle();
                bundle.putString("YourKey", "https://roadmap.sh/devops");
                SolutionFragment sl = new SolutionFragment();
                sl.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout2, sl).addToBackStack(null).commit();
            }


        });
        frontend_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Using Bundle to send data to Solution fragment
                Bundle bundle = new Bundle();
                bundle.putString("YourKey", "https://roadmap.sh/frontend");
                SolutionFragment sl = new SolutionFragment();
                sl.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout2, sl).addToBackStack(null).commit();
            }


        });
        java_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Using Bundle to send data to Solution fragment
                Bundle bundle = new Bundle();
                bundle.putString("YourKey", "https://roadmap.sh/java");
                SolutionFragment sl = new SolutionFragment();
                sl.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout2, sl).addToBackStack(null).commit();
            }


        });
        ml_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Using Bundle to send data to Solution fragment
                Bundle bundle = new Bundle();
                bundle.putString("YourKey", "https://whimsical.com/machine-learning-roadmap-2020-CA7f3ykvXpnJ9Az32vYXva");
                SolutionFragment sl = new SolutionFragment();
                sl.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout2, sl).addToBackStack(null).commit();
            }


        });
        oops_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Using Bundle to send data to Solution fragment
                Bundle bundle = new Bundle();
                bundle.putString("YourKey", "https://whimsical.com/object-oriented-programming-cheatsheet-by-love-babbar-YbSgLatbWQ4R5paV7EgqFw");
                SolutionFragment sl = new SolutionFragment();
                sl.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout2, sl).addToBackStack(null).commit();
            }


        });
        os_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Using Bundle to send data to Solution fragment
                Bundle bundle = new Bundle();
                bundle.putString("YourKey", "https://whimsical.com/operating-system-cheatsheet-by-love-babbar-S9tuWBCSQfzoBRF5EDNinQ");
                SolutionFragment sl = new SolutionFragment();
                sl.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout2, sl).addToBackStack(null).commit();
            }


        });
        python_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Using Bundle to send data to Solution fragment
                Bundle bundle = new Bundle();
                bundle.putString("YourKey", "https://roadmap.sh/python");
                SolutionFragment sl = new SolutionFragment();
                sl.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout2, sl).addToBackStack(null).commit();
            }


        });
        react_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Using Bundle to send data to Solution fragment
                Bundle bundle = new Bundle();
                bundle.putString("YourKey", "https://roadmap.sh/react");
                SolutionFragment sl = new SolutionFragment();
                sl.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout2, sl).addToBackStack(null).commit();
            }


        });
        placements_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Using Bundle to send data to Solution fragment
                Bundle bundle = new Bundle();
                bundle.putString("YourKey", "https://whimsical.com/4th-year-roadmap-to-dream-placement-WB2HTZixtsohXoDcvr6Me7");
                SolutionFragment sl = new SolutionFragment();
                sl.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout2, sl).addToBackStack(null).commit();
            }


        });


        //end of Road-map on click listeners


        //start of Books on click listeners

        book1_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Using Bundle to send data to Solution fragment

                Bundle bundle = new Bundle();
                bundle.putString("YourKey", "https://drive.google.com/file/d/1MaME8sW57H6eLlZvQ4Gqn5y7aVhuxlj5/view?usp=sharing");
                SolutionFragment sl = new SolutionFragment();
                sl.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout2, sl).addToBackStack(null).commit();
            }


        });
        book2_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Using Bundle to send data to Solution fragment

                Bundle bundle = new Bundle();
                bundle.putString("YourKey", "https://drive.google.com/file/d/1yJjINH-I41e5h-SC0fUxwASj9lxsM5F_/view?usp=sharing");
                SolutionFragment sl = new SolutionFragment();
                sl.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout2, sl).addToBackStack(null).commit();
            }


        });
        book3_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Bundle bundle = new Bundle();
                bundle.putString("YourKey", "https://drive.google.com/file/d/1RxKzUOPqIpKWMM8qft5ug88Qcs59k-rB/view?usp=sharing");
                SolutionFragment sl = new SolutionFragment();
                sl.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout2, sl).addToBackStack(null).commit();
            }


        });
        book4_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Bundle bundle = new Bundle();
                bundle.putString("YourKey", "https://drive.google.com/file/d/1jFqUJ6qilsZaP1bKSJNtjH8KFzpGaBpA/view?usp=sharing");
                SolutionFragment sl = new SolutionFragment();
                sl.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout2, sl).addToBackStack(null).commit();
            }


        });
        book5_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Bundle bundle = new Bundle();
                bundle.putString("YourKey", "https://drive.google.com/file/d/1zsUdPqC_obJvwWuM2Xz6r2-Hxz0_zqe2/view?usp=sharing");
                SolutionFragment sl = new SolutionFragment();
                sl.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout2, sl).addToBackStack(null).commit();
            }


        });
        book6_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Bundle bundle = new Bundle();
                bundle.putString("YourKey", "https://drive.google.com/file/d/1sAaz5pPwgNhSXRQHnIry02acgjxJqIgw/view?usp=sharing");
                SolutionFragment sl = new SolutionFragment();
                sl.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout2, sl).addToBackStack(null).commit();
            }


        });
        book7_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Bundle bundle = new Bundle();
                bundle.putString("YourKey", "https://drive.google.com/file/d/1Bte2pupMnPSoXQSQUmq93d7p2rl_wrYH/view?usp=sharing");
                SolutionFragment sl = new SolutionFragment();
                sl.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout2, sl).addToBackStack(null).commit();
            }


        });
        book8_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Bundle bundle = new Bundle();
                bundle.putString("YourKey", "https://drive.google.com/file/d/1U2fjRA9pN_NyOQZH47T1zWTxKOnBvuvq/view?usp=sharing");
                SolutionFragment sl = new SolutionFragment();
                sl.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout2, sl).addToBackStack(null).commit();
            }


        });
        book9_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Bundle bundle = new Bundle();
                bundle.putString("YourKey", "https://drive.google.com/file/d/1cPvOvz21sqz6T-0tKep9uSblgWbRK4-V/view?usp=sharing");
                SolutionFragment sl = new SolutionFragment();
                sl.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout2, sl).addToBackStack(null).commit();
            }


        });
        book10_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Bundle bundle = new Bundle();
                bundle.putString("YourKey", "https://drive.google.com/file/d/1vQXSBNVgN8wEQ-2ma3l4QR8l7Yk7CNqB/view?usp=sharing");
                SolutionFragment sl = new SolutionFragment();
                sl.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout2, sl).addToBackStack(null).commit();
            }


        });
        book11_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Bundle bundle = new Bundle();
                bundle.putString("YourKey", "https://drive.google.com/file/d/15H3Jl-v6Vxsqj2SD2g_zfyXy2F8880xu/view?usp=sharing");
                SolutionFragment sl = new SolutionFragment();
                sl.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout2, sl).addToBackStack(null).commit();
            }


        });
        book12_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Bundle bundle = new Bundle();
                bundle.putString("YourKey", "https://drive.google.com/file/d/1F7-ovEPiK0uKaxNkZSpRAqxZwDmrkgZq/view?usp=sharing");
                SolutionFragment sl = new SolutionFragment();
                sl.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout2, sl).addToBackStack(null).commit();
            }


        });
        book13_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Bundle bundle = new Bundle();
                bundle.putString("YourKey", "https://drive.google.com/file/d/1DA2yZQNNhBANt7wy8-bKcJFrRKMufLuO/view?usp=sharing");
                SolutionFragment sl = new SolutionFragment();
                sl.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout2, sl).addToBackStack(null).commit();
            }


        });
        book14_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Bundle bundle = new Bundle();
                bundle.putString("YourKey", "https://drive.google.com/file/d/1spdfEOOefOlWktgZP4cIyeg0FLW7jfzV/view?usp=sharing");
                SolutionFragment sl = new SolutionFragment();
                sl.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout2, sl).addToBackStack(null).commit();
            }


        });
        book15_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Bundle bundle = new Bundle();
                bundle.putString("YourKey", "https://drive.google.com/file/d/16AuJtdD7brhU4uVJFN3c4g2pD3hSRtF6/view?usp=sharing");
                SolutionFragment sl = new SolutionFragment();
                sl.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout2, sl).addToBackStack(null).commit();
            }


        });
        book16_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Bundle bundle = new Bundle();
                bundle.putString("YourKey", "https://drive.google.com/file/d/1f9q81TcfL6jMf1pyXYPA_RK8tB-v3FJD/view?usp=sharing");
                SolutionFragment sl = new SolutionFragment();
                sl.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frame_layout2, sl).addToBackStack(null).commit();
            }


        });
        book17_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //calling webActivity class
                Intent i = new Intent(getActivity(), WebActivity.class);
                i.putExtra("Link", "https://github.com/bishalchatterjee/CodingBooks/tree/master/CodingBooks");
                startActivity(i);
            }


        });

        //end of Books on click listeners

        //start of websites on click listeners
        site1_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //calling webActivity class
                Intent i = new Intent(getActivity(), WebActivity.class);
                i.putExtra("Link", "https://www.geeksforgeeks.org/");
                startActivity(i);
            }
        });
        site2_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //calling webActivity class
                Intent i = new Intent(getActivity(), WebActivity.class);
                i.putExtra("Link", "https://www.hackerrank.com/");
                startActivity(i);
            }
        });
        site3_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //calling webActivity class
                Intent i = new Intent(getActivity(), WebActivity.class);
                i.putExtra("Link", "https://www.codechef.com/");
                startActivity(i);
            }
        });
        site4_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //calling webActivity class
                Intent i = new Intent(getActivity(), WebActivity.class);
                i.putExtra("Link", "https://codeforces.com/");
                startActivity(i);
            }
        });
        site5_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //calling webActivity class
                Intent i = new Intent(getActivity(), WebActivity.class);
                i.putExtra("Link", "https://www.spoj.com/");
                startActivity(i);
            }
        });
        site6_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //calling webActivity class
                Intent i = new Intent(getActivity(), WebActivity.class);
                i.putExtra("Link", "https://www.freecodecamp.org/");
                startActivity(i);
            }
        });
        site7_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //calling webActivity class
                Intent i = new Intent(getActivity(), WebActivity.class);
                i.putExtra("Link", "https://icpc.global/");
                startActivity(i);
            }
        });
        site8_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //calling webActivity class
                Intent i = new Intent(getActivity(), WebActivity.class);
                i.putExtra("Link", "https://leetcode.com/");
                startActivity(i);
            }
        });
        site9_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //calling webActivity class
                Intent i = new Intent(getActivity(), WebActivity.class);
                i.putExtra("Link", "https://www.w3schools.com/");
                startActivity(i);
            }
        });
        site10_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //calling webActivity class
                Intent i = new Intent(getActivity(), WebActivity.class);
                i.putExtra("Link", "https://www.interviewbit.com/");
                startActivity(i);
            }
        });


        //end of websites on click listeners


        //start of Online Compilers on click listeners
        compiler1_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //calling webActivity class
                Intent i = new Intent(getActivity(), WebActivity.class);
                i.putExtra("Link", "https://ideone.com/");
                startActivity(i);
            }


        });


        //end of Online Compilers on click listeners


        return view; //finally returning the view
    }

}
