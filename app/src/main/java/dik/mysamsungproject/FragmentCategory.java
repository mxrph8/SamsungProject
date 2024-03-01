package dik.mysamsungproject;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import dik.mysamsungproject.databinding.FragmentCategoryBinding;


public class FragmentCategory extends Fragment {
    private FragmentCategoryBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCategoryBinding.inflate(inflater,container,false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();

    }
    public void offFrag(){
        MainActivity activity = (MainActivity) getActivity();
        FragmentManager ft = activity.getSupportFragmentManager();
        ft.beginTransaction().hide(FragmentCategory.this).commit();
    }

    private void initView(){
        binding.closebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           offFrag();
            }
        });

        binding.cbfm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                MainActivity.getCb_fm().postValue(binding.cbfm.isChecked());
            }
        });
        binding.cbmi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                MainActivity.getCb_mi().postValue(binding.cbmi.isChecked());
            }
        });
        binding.cbse.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                MainActivity.getCb_se().postValue(binding.cbse.isChecked());
            }
        });
        binding.cbxb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                MainActivity.getCb_xb().postValue(binding.cbxb.isChecked());
            }
        });
        binding.sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                MainActivity.getSeekBarValue().postValue(progress);
                binding.tvsb.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}