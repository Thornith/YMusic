package com.ymusic.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.ListViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.ymusic.R;
import com.ymusic.activity.VideoDraggable;
import com.ymusic.adapter.AdapterMusic;

/**
 * Created by Thornith on 14/12/2015.
 */
public class FragmentMusic extends Fragment {

    private AdapterMusic mAdapter;
    private ListViewCompat mListMusic;

    public FragmentMusic() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mview = inflater.inflate(R.layout.fragment_music, container, false);
        mAdapter = new AdapterMusic(getActivity());
        mListMusic = (ListViewCompat) mview.findViewById(R.id.list_music);
        mListMusic.setAdapter(mAdapter);

        for (int i = 0; i < 100; i++) {
            mAdapter.addItems("Music Title" + i);
        }

        mListMusic.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent minIntent = new Intent(getContext(), VideoDraggable.class);
                getActivity().startActivity(minIntent);
            }
        });


        return mview;
    }
}
