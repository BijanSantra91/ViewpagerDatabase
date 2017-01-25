package com.example.bijan.viewpagerdatabase;


import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragTwo extends Fragment {

    ListView listView;
    Cursor cursor;
    SimpleCursorAdapter simpleCursorAdapter;
 //   MyDatabase myDatabase;

    public FragTwo() {
        // Required empty public constructor
    }

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        myDatabase = new MyDatabase(getActivity());
//        myDatabase.open();
//    }
//
//    @Override
//    public void onDestroy() {
//        myDatabase.close();
//        super.onDestroy();
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_frag_two, container, false);

        listView = (ListView) v.findViewById(R.id.listView);

        MainActivity mainActivity = (MainActivity) getActivity();

        cursor = mainActivity.myDatabase.quaryStudent();

        simpleCursorAdapter = new SimpleCursorAdapter(getActivity(),
                R.layout.row,
                cursor,
                new String[]{"_id", "name", "sub", "email"},
                new int[]{R.id.textview1, R.id.textview2, R.id.textview3, R.id.textview4});

        listView.setAdapter(simpleCursorAdapter);

        return  v;
    }

}
