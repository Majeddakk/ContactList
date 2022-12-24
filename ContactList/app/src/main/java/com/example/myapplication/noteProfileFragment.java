package com.example.myapplication;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;


public class noteProfileFragment extends Fragment {

    private static final String NAME = "NoteName";
    private static final String NUMBER = "NoteSubject";
    private static final String RELATIONSHIP = "OtherNotes";

    private String mNote;
    private String mSubject;
    private ArrayList<String> mList;

    public ListView contact_relationships;
    public TextView name_fragment;
    public TextView number_fragment;

    private ArrayList<note> contacts = new ArrayList<>();



    public noteProfileFragment() {

    }

    public static noteProfileFragment newInstance(String names, String number, ArrayList<String> List) {
        noteProfileFragment fragment = new noteProfileFragment();
        Bundle args = new Bundle();

        args.putString("name", names);
        args.putString(NUMBER, number);
        args.putStringArrayList(RELATIONSHIP, List);

        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if (getArguments() != null){

            mNote = getArguments().getString(NAME);
            mSubject = getArguments().getString(NUMBER);
            mList = getArguments().getStringArrayList(RELATIONSHIP);

        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note_profile, container, false);

        contact_relationships = view.findViewById(R.id.relationshipList);
        name_fragment = view.findViewById(R.id.NameFragment);
        number_fragment = view.findViewById(R.id.PhoneFragment);

        name_fragment.setText(mNote);
        number_fragment.setText(mSubject);

        final CustomAdapter customAdapter = new CustomAdapter();
        contact_relationships.setAdapter(customAdapter);

        return view;
    }

    public ArrayList<note> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<note> contacts) {
        this.contacts = contacts;
    }



    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public Object getItem(int position) {
            return mList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return ((long) position);
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.frag_relationship, null);

            TextView contact_name = convertView.findViewById(R.id.fraglistContact_name);
            System.out.println(mList);
            contact_name.setText(mList.get(position));


            contact_name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view){
                }
            });

            return convertView;
        }
    }

}
