package org.pltw.examples.collegeapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;

/**
 * Created by PLTW on 1/14/2016.
 */
public class FamilyMemberActivity extends FragmentActivity {
    private static final String TAG = "FamilyMemberActivity";
    public static int guardianCall;
    public static int siblingCall;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_member);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = null;// = fm.findFragmentById(R.id.fragmentContainer);

        if (fragment == null) {
            if (guardianCall == 1) {
                fragment = new NewGuardianFragment();
                fm.beginTransaction()
                        .add(R.id.fragmentContainer, fragment)
                        .commit();
                guardianCall = 0;
                Log.d(TAG, "GuardianCall set to 0");
            } else if (siblingCall == 1) {
                fragment = new NewSiblingFragment();
                fm.beginTransaction()
                        .add(R.id.fragmentContainer, fragment)
                        .commit();
                siblingCall = 0;
                Log.d(TAG, "SiblingCall set to 0");
            } else if (getIntent().getIntExtra(FamilyMember.EXTRA_RELATION, 0) ==
                    FamilyMember.GUARDIAN) {
                fragment = new GuardianFragment();
                fm.beginTransaction()
                        .add(R.id.fragmentContainer, fragment)
                        .commit();
            } else if (getIntent().getIntExtra(FamilyMember.EXTRA_RELATION, 1) ==
                    FamilyMember.SIBLING) {
                fragment = new SiblingFragment();
                fm.beginTransaction()
                        .add(R.id.fragmentContainer, fragment)
                        .commit();
            }

        }
    }
}

