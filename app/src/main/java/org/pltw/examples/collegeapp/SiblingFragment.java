package org.pltw.examples.collegeapp;

/**
 * Created by PLTW on 1/14/2016.
 */

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;


public class SiblingFragment extends Fragment {
    private static final String TAG = "SiblingFragment";
    private static final String FILENAME = "guardian.json";
    private Sibling mSibling;
    private TextView mFirstName;
    private TextView mLastName;
    private EditText mEnterFirstName;
    private EditText mEnterLastName;
    private Context mAppContext;
    //ProfileJSONStorer mStorer;


    //@Override
    //public void onCreate(Bundle savedInstanceState) {
    //mSibling = new Guardian();
    //}

    /*public GuardianFragment(){
        try {
            mSibling = mStorer.load2();//loads the data
        } catch (Exception e) {//
            mSibling = new Guardian();//creates a new profile with the original names
            Log.e(TAG, "Error loading profile: " + FILENAME, e);
        }
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        Log.d(TAG, "SiblingFragment Initialized");
        View rootView = inflater.inflate(R.layout.fragment_sibling, container, false);

        mSibling = (Sibling)Family.get().getmFamily().get(getActivity().
                getIntent().getIntExtra(FamilyMember.EXTRA_INDEX,1));

        mFirstName = (TextView)rootView.findViewById(R.id.first_name);
        mEnterFirstName = (EditText)rootView.findViewById(R.id.enter_first_name);
        mLastName = (TextView)rootView.findViewById(R.id.last_name);
        mEnterLastName = (EditText)rootView.findViewById(R.id.enter_last_name);

        mFirstName.setText(mSibling.getFirstName());
        mLastName.setText(mSibling.getLastName());

        FirstNameTextChanger firstNameTextChanger = new FirstNameTextChanger();
        LastNameTextChanger lastNameTextChanger = new LastNameTextChanger();

        mEnterFirstName.addTextChangedListener(firstNameTextChanger);

        mEnterLastName.addTextChangedListener(lastNameTextChanger);

        mAppContext = this.getActivity();
        Log.d(TAG, "Context: " + mAppContext);

        //mStorer = new ProfileJSONStorer(mAppContext, FILENAME);
        return rootView;
    }

    private class FirstNameTextChanger implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            mSibling.setFirstName(s.toString());
            ArrayList family = Family.get().getmFamily();
            int index = getActivity().getIntent().getIntExtra(FamilyMember.EXTRA_INDEX, 1);
            family.set(index, mSibling);
        }

        @Override
        public void afterTextChanged(Editable s) {
            mFirstName.setText(mSibling.getFirstName());
        }
    }

    private class LastNameTextChanger implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            mSibling.setLastName(s.toString());
            ArrayList family = Family.get().getmFamily();
            int index = getActivity().getIntent().getIntExtra(FamilyMember.EXTRA_INDEX,1);
            family.set(index, mSibling);
        }

        @Override
        public void afterTextChanged(Editable s) {
            mLastName.setText(mSibling.getLastName());
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "Fragment started.");
    }

    /*public boolean saveGuardian() {
        try {
            mStorer.save(mSibling);
            Log.d(TAG, "profile saved to file.");
            return true;
        } catch (Exception e) {
            Log.e(TAG, "Error saving profile: ", e);
            return false;
        }
    }*/


    @Override
    public void onPause() {
        super.onPause();
        //saveGuardian();
        Log.d(TAG, "Fragment paused.");
    }

    @Override
    public void onResume() {
        super.onResume();
        /*try {
            mSibling = mStorer.load2();
            Log.d(TAG, "Loaded " + mSibling.getFirstName());
            mFirstName.setText(mSibling.getFirstName());
            mLastName.setText(mSibling.getLastName());
        } catch (Exception e) {
            mSibling = new Guardian();
            Log.e(TAG, "Error loading profile from: " + FILENAME, e);
        }*/
        Log.d(TAG, "Fragment resumed.");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "Fragment stopped.");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Fragment destroyed.");
    }

}

