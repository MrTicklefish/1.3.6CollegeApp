package org.pltw.examples.collegeapp;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by PLTW on 1/27/2016.
 */

public class NewGuardianFragment extends GuardianFragment{

    private Guardian mGuardian;
    private TextView mFirstName;
    private TextView mLastName;
    private EditText mEnterFirstName;
    private EditText mEnterLastName;
    private TextView mOccupation;
    private EditText mEnterOccupation;
    private Context mAppContext;
    private static final String TAG = "NewGuardianFragment";
    private static final String FILENAME = "guardian.json";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_guardian, container, false);

        mGuardian = (Guardian)Family.get().getmFamily().get(getActivity().
                getIntent().getIntExtra(FamilyMember.EXTRA_INDEX,0));

        mFirstName = (TextView)rootView.findViewById(R.id.first_name);
        mEnterFirstName = (EditText)rootView.findViewById(R.id.enter_first_name);
        mLastName = (TextView)rootView.findViewById(R.id.last_name);
        mEnterLastName = (EditText)rootView.findViewById(R.id.enter_last_name);
        mOccupation = (TextView)rootView.findViewById(R.id.occupation);
        mEnterOccupation = (EditText)rootView.findViewById(R.id.enter_occupation);

        mFirstName.setText(mGuardian.getFirstName());
        mLastName.setText(mGuardian.getLastName());
        mOccupation.setText(mGuardian.getOccupation());

        FirstNameTextChanger firstNameTextChanger = new FirstNameTextChanger();
        LastNameTextChanger lastNameTextChanger = new LastNameTextChanger();
        OccupationChanger occupationChanger = new OccupationChanger();

        mEnterFirstName.addTextChangedListener(firstNameTextChanger);

        mEnterLastName.addTextChangedListener(lastNameTextChanger);

        mEnterOccupation.addTextChangedListener(occupationChanger);

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
            mGuardian.setFirstName(s.toString());
            ArrayList family = Family.get().getmFamily();
            int index = getActivity().getIntent().getIntExtra(FamilyMember.EXTRA_INDEX, 0);
            family.set(index, mGuardian);
        }

        @Override
        public void afterTextChanged(Editable s) {
            mFirstName.setText(mGuardian.getFirstName());
        }
    }
    private class LastNameTextChanger implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            mGuardian.setLastName(s.toString());
            ArrayList family = Family.get().getmFamily();
            int index = getActivity().getIntent().getIntExtra(FamilyMember.EXTRA_INDEX,0);
            family.set(index, (FamilyMember)mGuardian);
        }

        @Override
        public void afterTextChanged(Editable s) {
            mLastName.setText(mGuardian.getLastName());
        }
    }

    private class OccupationChanger implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            mGuardian.setOccupation(s.toString());
            ArrayList family = Family.get().getmFamily();
            int index = getActivity().getIntent().getIntExtra(FamilyMember.EXTRA_INDEX,0);
            family.set(index, (FamilyMember)mGuardian);
        }

        @Override
        public void afterTextChanged(Editable s) {
            mOccupation.setText(mGuardian.getOccupation());
        }
    }
}
