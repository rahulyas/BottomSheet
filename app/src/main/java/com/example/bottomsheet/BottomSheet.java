package com.example.bottomsheet;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BottomSheet#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BottomSheet extends BottomSheetDialogFragment {

    ArrayList<Model> model= new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    Button button;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BottomSheet() {
        // Required empty public constructor
    }

    public static BottomSheet newInstance(String param1, String param2) {
        BottomSheet fragment = new BottomSheet();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View root = inflater.inflate(R.layout.fragment_bottom_sheet, container, false);


        button=root.findViewById(R.id.confirm);
        recyclerView = root.findViewById(R.id.recyclerview);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(adapter.getSelected().size() > 0) {
                    StringBuilder stringBuilder = new StringBuilder();

                    for( int i =0 ; i< adapter.getSelected().size(); i++){
                        stringBuilder.append(adapter.getSelected().get(i).getLanguage1());
                        stringBuilder.append(" \n ");
                        stringBuilder.append(adapter.getSelected().get(i).getLanguage2());
                        stringBuilder.append(" \n ");
                    }
                    ShowToast(stringBuilder.toString().trim());
                    Intent intent= new Intent(getContext(),MainActivity.class);
                    startActivity(intent);

                    //intent.putExtra("language1",adapter.getSelected().get().getLanguage1());
                }else
                    ShowToast("No Selection");
            }
        });

        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL));

        model.add(new Model("हिन्दी","Hindi"));
        model.add(new Model("राजस्थानी","Rajasthani"));
        model.add(new Model("ਪੰਜਾਬੀ","Punjabi"));
        model.add(new Model("ગુજરાતી","Gujarati"));
        model.add(new Model("हरियाणवी","Haryanvi"));
        model.add(new Model("भोजपुरी","Bhojpuri"));
        model.add(new Model("मराठी","Marathi"));
        model.add(new Model("বাংলা","Bengali"));
        model.add(new Model("অসমীয়া","Assamese"));
        model.add(new Model("മലയാളം","Malayalam"));
        model.add(new Model("ಕನ್ನಡ","Kannada"));
        model.add(new Model("اردو","Urdu"));
        model.add(new Model("తెలుగు","Telugu"));
        model.add(new Model("தமிழ்","Tamil"));
        model.add(new Model("ଓଡିଆ","Odia"));
        model.add(new Model("English","English"));

        adapter =new RecyclerAdapter(getContext(),model);
        recyclerView.setAdapter(adapter);

        // Inflate the layout for this fragment
        return root;
    }

    private void ShowToast(String msg){
        Toast.makeText(getContext(),msg, Toast.LENGTH_SHORT).show();
    }
}