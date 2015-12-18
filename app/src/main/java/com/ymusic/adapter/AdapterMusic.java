package com.ymusic.adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ymusic.R;

import java.util.ArrayList;

/**
 * Created by Thornith on 14/12/2015.
 */
public class AdapterMusic extends BaseAdapter {

    private LayoutInflater mInflater;
    private Context mContext;
    private ArrayList<String> mData = new ArrayList<String>();

    public AdapterMusic(Context context) {

        this.mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }

    public void addItems(String item) {
        mData.add(item);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View mView = null;
        ViewMusicHolder musicHolder;
        if (mView == null) {

            mView = mInflater.inflate(R.layout.itme_listmusic, null);
            musicHolder = new ViewMusicHolder();
            musicHolder.txvTitleMusic = (TextView) mView.findViewById(R.id.txv_title_music);
            mView.setTag(musicHolder);

        } else {

            musicHolder = (ViewMusicHolder) mView.getTag();
        }

        String title = mData.get(position);
        musicHolder.txvTitleMusic.setText(title);

        return mView;
    }

    public class ViewMusicHolder {

        AppCompatImageView imgThumbnail;
        AppCompatImageView imgMenu;
        TextView txvTitleMusic;
        TextView txvViewMusic;

    }
}
