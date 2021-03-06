package com.example.tku.accountingsd.ui.depositTarget;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tku.accountingsd.BaseFragment;
import com.example.tku.accountingsd.R;
import com.example.tku.accountingsd.ui.homeScreen.homeScreenFragment;

public class depositTargetFragment extends BaseFragment {

    EditText et_month_revenue, et_expect_deposit;
    TextView tv_result;
    Button button, backHome;

    float revenue, deposit;
    float result = revenue-deposit;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_deposit_target,container,false);
        et_month_revenue = (EditText) v.findViewById(R.id.et_month_revenue);
        et_expect_deposit = (EditText) v.findViewById(R.id.et_expect_deposit);
        tv_result = (TextView) v.findViewById(R.id.tv_result);
        button = (Button) v.findViewById(R.id.cash);
        backHome = (Button) v.findViewById(R.id.myButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateResult();
                tv_result.setText(Float.toString(result));
            }
        });

        backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeScreenFragment homeFragment=new homeScreenFragment();
                FragmentTransaction transection=getFragmentManager().beginTransaction();
                Bundle bundle=new Bundle();
                float test = Float.parseFloat(tv_result.getText().toString().trim());
                bundle.putFloat("expectSave", test);
                homeFragment.setArguments(bundle);
                transection.replace(R.id.content_main, new homeScreenFragment());
                transection.commit();
                //getFragmentManager().beginTransaction().replace(R.id.content_main, new homeScreenFragment()).commit();
            }
        });


        return v;

    }

    private void calculateResult(){
        revenue = Float.parseFloat(et_month_revenue.getText().toString().trim());
        deposit = Float.parseFloat(et_expect_deposit.getText().toString().trim());
        result = revenue-deposit;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("存款目標");
    }




}
