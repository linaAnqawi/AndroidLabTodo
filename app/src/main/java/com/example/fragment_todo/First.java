package com.example.fragment_todo;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class First extends Fragment {
    TextView textView ;
    MainActivity m;


    public First() {
        // Required empty public constructor
    }
    interface communicator1 {
        public void respond1(String data);
    }


    public void changeData(String data){
        textView.setText(data);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        textView = (TextView) getActivity().findViewById(R.id.textView);
        m=new MainActivity();
        final Second.communicator2 communicator =
                (Second.communicator2) getActivity();
        final Third.communicator3 communicator3 =
                (Third.communicator3) getActivity();
        final EditText edit1 = (EditText) getActivity().findViewById(R.id.editText1);
        final EditText edit2 = (EditText) getActivity().findViewById(R.id.editText2);
        Button button = (Button) getActivity().findViewById(R.id.button);
        final double[] sumation = {0};
        final double[] sum1 = new double[1];
        final double[] sum2 = new double[1];
        final double[]  multiblication = {0};

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if(edit1.getText().toString().equals("") && edit2.getText().toString().equals("")) {
                    sum1[0]=0;
                    sum2[0]=0;

                }else {
                    sum1[0] = Double.valueOf(edit1.getText().toString());
                    sum2[0] = Double.valueOf(edit2.getText().toString());
                }
                view = getActivity().findViewById(R.id.fragment2);
                view.setVisibility(View.VISIBLE);
                view = getActivity().findViewById(R.id.fragment3);
                view.setVisibility(View.VISIBLE);
                sumation[0] = sum1[0] + sum2[0];
                communicator.respond2(+ sumation[0] +"");
                multiblication[0]= sum1[0] * sum2[0];
               communicator3.respond3(multiblication[0]+"");

            }

        });
    }
}

