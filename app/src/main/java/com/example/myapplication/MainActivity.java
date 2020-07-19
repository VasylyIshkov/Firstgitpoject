package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.DrawableRes;

import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.classes.Phone;
import com.example.myapplication.fragment.FragmentChooser;
import com.example.myapplication.fragment.FragmentViewer;
import com.example.myapplication.listeners.FragmentChooseListener;

public class MainActivity extends BaseActivity {
    private FragmentViewer fragmentViewer;
    private FragmentChooser fragmentChooser;
    private FragmentChooseListener fragmentChooseListener;
    boolean inLandscapeMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar(getString(R.string.main_activity_title));
        inLandscapeMode = findViewById(R.id.fragment_viewer) != null;

        fragmentChooser = (FragmentChooser) getSupportFragmentManager().findFragmentById(R.id.fragment_chooser);
        if (inLandscapeMode)
            fragmentViewer = (FragmentViewer) getSupportFragmentManager().findFragmentById(R.id.fragment_viewer);
        fragmentChooseListener = new FragmentChooseListener() {
            @Override
            public void onXiaomiClick() {
                Phone xiaomi = new Phone("Xiaomi Mi 10", "Qualcomm Snapdragon 865", "8Gb");
                displaySelected(xiaomi.getInfo(), R.drawable.xiaomi_mi_10);
            }

            @Override
            public void onSamsungClick() {
                Phone samsung = new Phone("Samsung Galaxy M21", "Samsung Exynos 9611", "4Gb");
                displaySelected(samsung.getInfo(), R.drawable.samsun);

            }

            @Override
            public void onIphoneClick() {
                Phone iphone = new Phone("iPhone SE 64GB", "Apple A13 Bionic", "3Gb");
                displaySelected(iphone.getInfo(), R.drawable.apple_iphone_se);
            }

            @Override
            public void onRelameClick() {
                Phone relame = new Phone("Realme 6 Pro", " Qualcomm Snapdragon 720G", "8Gb");
                displaySelected(relame.getInfo(), R.drawable.realme_6);
            }

            @Override
            public void onHuaweiClick() {
                Phone huawei = new Phone("Huawei P30 Lite", "HiSilicon Kirin 710", "4Gb");
                displaySelected(huawei.getInfo(),R.drawable.huawei_p30);
            }
        };
        fragmentChooser.setFragmentChooseListener(fragmentChooseListener);
    }


    private void displaySelected(String resPhoneInfo, @DrawableRes int resImageId) {
        if (inLandscapeMode) {
            fragmentViewer.displayResorce(resImageId, resPhoneInfo);
        } else {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra(Constants.KEY_RES_ID, resImageId);
            intent.putExtra(Constants.PHONE_INFO_STR, resPhoneInfo);
            startActivity(intent);
        }
    }

}
