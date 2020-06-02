package com.example.fragment_todo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements Second.communicator2,Third.communicator3,First.communicator1{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      View view= ((View) findViewById(R.id.fragment2));
      view.setVisibility(View.INVISIBLE);
        View view1= ((View) findViewById(R.id.fragment3));
        view1.setVisibility(View.INVISIBLE);

    }

    @Override
    public void respond2(String data) {
        Second secondFragment =
                (Second)getSupportFragmentManager().findFragmentById(R.id.fragment2);
        secondFragment.changeData(data);
    }
    public void respond3(String data) {
        Third ThirdFragment =
                (Third) getSupportFragmentManager().findFragmentById(R.id.fragment3);
        ThirdFragment.changeData(data);
    }
    public void respond1(String data) {
        First FirstFragment =
                (First) getSupportFragmentManager().findFragmentById(R.id.fragment1);
      FirstFragment.changeData(data);
    }
   public void addfragments2(){
      Second news =new Second();
      Third newt=new Third();
       FragmentManager fragmentmanger=getSupportFragmentManager();
       FragmentTransaction trans=fragmentmanger.beginTransaction();
       trans.add(R.id.fragment,news);
       trans.add(R.id.fragment,newt);
       trans.commit();

    }


    private  void removfragments(){
        Fragment fragment;
        FragmentManager fragmentmanger=getSupportFragmentManager();
         FragmentTransaction f=fragmentmanger.beginTransaction();
        Second news=new Second();
        Third newt=new Third();
        First newf =new First();
        f.remove(newt);
        f.commit();


    }
    private  void replace(){
        Fragment fragment;
        FragmentManager fragmentmanger=getSupportFragmentManager();
        FragmentTransaction  f=fragmentmanger.beginTransaction();
        Second news=new Second();
        Third newt=new Third();
        f.replace(R.id.fragment1,news,"second");
        f.replace(R.id.fragment1,newt,"second");

        f.commit();
    }


}
