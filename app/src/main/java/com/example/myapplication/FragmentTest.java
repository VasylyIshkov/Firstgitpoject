package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.fragment.FragmentChooser;

public class FragmentTest extends BaseActivity {

    private FragmentChooser fragmentChooser;
   // private BlankFragment BlankFragment;
    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_test);
        initToolbarWithNavigation(getString(R.string.fragmentTest));
        fragmentChooser = new FragmentChooser();


        menu = getToolbar().getMenu();
        menu.clear();
        menu.add(0,0, 0,"addFragment");
        menu.add(0,1, 0,"removeFragment");
        menu.add(0,2, 0,"replaceFragment");

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case 0: {
                Toast.makeText(this,"dfdf",Toast.LENGTH_LONG);
                    addFragment(fragmentChooser);
                }break;
            case 1: {
                    removeFragment(fragmentChooser);

            }break;
            case 2: {

                //replaceFragment(BlankFragment);
            }break;
            default: {

            }
        }
        return true;
    }

    private void addFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void removeFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.remove(fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
