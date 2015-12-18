package com.ymusic.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.ListViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ymusic.R;
import com.ymusic.adapter.AdapterMusic;
import com.ymusic.adapter.AdapterPlaylist;

/**
 * Created by Thornith on 14/12/2015.
 */
public class FragmentPlaylist extends Fragment {

    private AdapterPlaylist mAdapter;
    private ListViewCompat mListMusic;

    public FragmentPlaylist() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mview = inflater.inflate(R.layout.fragment_music, container, false);
        mAdapter = new AdapterPlaylist(getActivity());
        mListMusic = (ListViewCompat) mview.findViewById(R.id.list_music);
        mListMusic.setAdapter(mAdapter);

        for (int i = 0; i < 100; i++) {
            mAdapter.addItems("Music Title" + i);
        }


        return mview;
    }
}
