package com.bl_lia.realmtoy;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            final TodoListFragment fragment = TodoListFragment.newInstance();
            final FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.layout_content, fragment);
            transaction.commit();
        }
    }
}
