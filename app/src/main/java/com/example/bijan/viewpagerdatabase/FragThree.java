package com.example.bijan.viewpagerdatabase;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragThree extends Fragment {

    RecyclerView recyclerView;
    ArrayList<Student> arrayList;
    MyAdapter myadapter;
    Cursor cursor;

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = getActivity().getLayoutInflater().inflate(R.layout.row, parent, false);
            ViewHolder viewHolder = new ViewHolder(v);

            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

            Student student = arrayList.get(position);
            holder.textView1.setText(student.getSno());
            holder.textView2.setText(student.getName());
            holder.textView3.setText(student.getSub());
            holder.textView4.setText(student.getEmail());
        }

        @Override
        public int getItemCount() {
            return arrayList.size();

        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            public TextView textView1, textView2, textView3, textView4;

            public ViewHolder(View itemView) {
                super(itemView);

                textView1 = (TextView) itemView.findViewById(R.id.textview1);
                textView2 = (TextView) itemView.findViewById(R.id.textview2);
                textView3 = (TextView) itemView.findViewById(R.id.textview3);
                textView4 = (TextView) itemView.findViewById(R.id.textview4);

            }
        }
    }


    public FragThree() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_frag_three, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerview);
        arrayList = new ArrayList<Student>();

        MainActivity mainActivity = (MainActivity) getActivity();

        cursor = mainActivity.myDatabase.quaryStudent();
        if (cursor!=null){
            while (cursor.moveToNext()){
                int no = cursor.getInt(0);
                String name = cursor.getString(1);
                String sub = cursor.getString(2);
                String email = cursor.getString(3);

                Student student = new Student();
                student.setSno(""+no);
                student.setName(name);
                student.setSub(sub);
                student.setEmail(email);

                arrayList.add(student);
            }
        }
        myadapter = new MyAdapter();
        recyclerView.setAdapter(myadapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        return  v;
    }

}
