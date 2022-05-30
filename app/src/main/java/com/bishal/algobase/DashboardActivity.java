package com.bishal.algobase;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

public class DashboardActivity extends AppCompatActivity {
    //initialize variable
    MeowBottomNavigation bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        // remove the action bar and setting display to full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        bottomNavigation =findViewById(R.id.bottom_navigation);


        //Add menu items
        bottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.datastructure_vector));
        bottomNavigation.add(new MeowBottomNavigation.Model(2,R.drawable.algorithm_vector));
        bottomNavigation.add(new MeowBottomNavigation.Model(3,R.drawable.resources_vector));
        bottomNavigation.add(new MeowBottomNavigation.Model(4,R.drawable.problems_vector));





        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                //Initialize fragment
                Fragment fragment = null;
                //Switch
                switch (item.getId()){
                    case 1:
                        //for id 1
                        fragment =new DatastructuresFragment();
                        break;
                    case 2:
                        //for id 2
                        fragment =new AlgorithmsFragment();
                        break;
                    case 3:
                        //for id 3
                        fragment =new StudyFragment();
                        break;
                    case 4:
                        //for id 3
                        fragment =new ProblemsFragment();
                        break;


                }
                //Loading fragments
                loadFragment(fragment);
            }


        });

        //set notification count
        bottomNavigation.setCount(1,"10");
        bottomNavigation.setCount(2,"9");
        bottomNavigation.setCount(3,"25");
        bottomNavigation.setCount(4,"400");
        //set home fragment initially selected
        bottomNavigation.show(1,true);

        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
//                Toast.makeText(getApplicationContext(),"Selected "+ item.getId(),Toast.LENGTH_SHORT).show();

            }
        });

        bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
//                Toast.makeText(getApplicationContext(),"Re-selected "+ item.getId(),Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout,fragment)
                .commit();
    }
}