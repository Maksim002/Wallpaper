package com.example.wallpaper.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wallpaper.R;
import com.example.wallpaper.model.ModelGallery;
import com.example.wallpaper.ui.adapter.recycler.winter.WinterRecyclerAdapter;
import com.example.wallpaper.ui.util.ResourceManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class WinterFragment extends Fragment implements Listener {
    private RecyclerView recyclerView;
    private WinterRecyclerAdapter adapter;
    private String SAMPLES = "test.json";
    private ModelList modelList;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_winter,container,false);

        recyclerView = view.findViewById(R.id.recyclerWinter);
        recyclerView.setAdapter(adapter = new WinterRecyclerAdapter(getQuestions(),this));
        adapter.updeteList(getQuestions());

        return view;
    }
    private List<ModelGallery> getQuestions() {
        String json = ResourceManager.readFromAssets(getContext(), SAMPLES);
        Type type = new TypeToken<List<ModelGallery>>() {
        }.getType();
        return new Gson().fromJson(json, type);
    }

    @Override
    public void onClickWinter(int adapterPosition, ModelGallery data) {
        modelList = new ModelList();
    }
}
