package com.example.fragment_todo;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Third extends Fragment {

    TextView textView1 ;

    public Third() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    interface communicator3{
        public void respond3(String data);
    }


    public void changeData(String data){

        textView1.setText(data);
    }
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        textView1= (TextView) getActivity().findViewById(R.id.textView4);
        final First.communicator1 communicator =
                (First.communicator1)getActivity();
        Button button = (Button) getActivity().findViewById(R.id.button3);
        final double[] i = new double[1];
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(textView1.getText().toString().equals("")) {
                    i[0]=0;
                    communicator.respond1(i[0] + "");
                }
                else{
                    i[0] = Double.valueOf(textView1.getText().toString());
                    i[0]--;
                    communicator.respond1(i[0] + "");

                }
            }
        });
    }


}
