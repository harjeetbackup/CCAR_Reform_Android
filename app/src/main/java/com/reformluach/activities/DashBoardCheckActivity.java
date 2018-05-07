package com.reformluach.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.reformluach.R;
import com.reformluach.fragments.DashboardFragment;
import com.reformluach.utils.Controller;

/**
 * Created by Naveen Mishra on 1/12/2018.
 */
public class DashBoardCheckActivity extends AppCompatActivity {
    private Controller controller;
    private Context context;
    private boolean mHasSaveInstanceState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        controller = (Controller) context.getApplicationContext();
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        setContentView(R.layout.activity_dash_board_check);
        initialiseView();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        mHasSaveInstanceState = true;
        super.onSaveInstanceState(outState);
    }

    private void initialiseView() {
        getSupportFragmentManager().beginTransaction().replace(R.id.replace_container, new DashboardFragment()).addToBackStack(null).commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mHasSaveInstanceState = false;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        //exitFromApp();
    }

    public void exitFromApp() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.are_you_sure_you_want_to_exit_from_the_app)).setCancelable(true).setTitle(R.string.app_name).setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        }).setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        try {
            builder.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
