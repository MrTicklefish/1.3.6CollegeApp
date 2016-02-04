package org.pltw.examples.collegeapp;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by PLTW on 12/10/2015.
 */
public class Family {

    private final static String TAG = "Family";
    private static Family sFamily;

    ArrayList<FamilyMember> mFamily;

    private Family(){
        mFamily = new ArrayList<FamilyMember>();
        mFamily.add(new Guardian());
        mFamily.add(new Guardian("Jason", "Van Hoesen"));
        mFamily.add(new Sibling("Natalie", "Van Hoesen"));
    }
    public static Family get() {
        Log.d(TAG, "Family get");
        if( sFamily == null ) {
            sFamily = new Family();
        }
        return sFamily;
    }

    public ArrayList<FamilyMember> getmFamily() {
        Log.d(TAG, "mFamily Gotten");
        return mFamily;
    }

    public void setmFamily(ArrayList<FamilyMember> mFamily) {
        this.mFamily = mFamily;
    }

    public void addFamilyMember(FamilyMember familyMember){
        mFamily.add(familyMember);
    }

    public void deleteFamilyMember(FamilyMember familyMember){}

}
