package com.example.uniliachatboat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ResourceFragment extends Fragment {

    private RecyclerView recyclerView;
    private ResourceAdapter adapter;
    private List<Resource> resourceList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_resources, container, false);

        recyclerView = view.findViewById(R.id.resources_recycler_view);
        resourceList = new ArrayList<>();

        // Add dummy data
        resourceList.add(new Resource("Lecture Notes", "Access your course materials and slides here."));
        resourceList.add(new Resource("Assignments", "View upcoming deadlines and submit your work."));
        resourceList.add(new Resource("Past Exam Papers", "Practice with previous years' examination papers."));
        resourceList.add(new Resource("Announcements", "Stay updated with the latest university news."));
        resourceList.add(new Resource("Timetable", "Check your class schedules and locations."));

        adapter = new ResourceAdapter(resourceList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        return view;
    }
}