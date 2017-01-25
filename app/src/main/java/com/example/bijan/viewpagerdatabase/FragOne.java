package com.example.bijan.viewpagerdatabase;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragOne extends Fragment {

    EditText editText1, editText2, editText3;
    Button button;

    public FragOne() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_frag_one, container, false);

        editText1 = (EditText) v.findViewById(R.id.edittext1);
        editText2 = (EditText) v.findViewById(R.id.edittext2);
        editText3 = (EditText) v.findViewById(R.id.edittext3);
        button = (Button) v.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText1.getText().toString();
                String sub = editText2.getText().toString();
                String email = editText3.getText().toString();

                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.myDatabase.insertStudent(name, sub, email);
                Toast.makeText(getActivity(), "INSERTED", Toast.LENGTH_SHORT).show();
                mainActivity.notifyData();
            }
        });

        return v;
    }

}
