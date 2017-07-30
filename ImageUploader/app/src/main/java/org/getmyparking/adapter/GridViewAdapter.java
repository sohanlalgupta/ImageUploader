package org.getmyparking.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.sohan.imageuploader.R;

import org.getmyparking.model.ImageModel;

import java.util.List;

/**
 * Created by sohan on 30-07-2017.
 */

public class GridViewAdapter extends RecyclerView.Adapter<GridViewAdapter.ViewHolder> {

    private  List<ImageModel> mImageList;
    private Context mContext;

    public GridViewAdapter(Context context,List<ImageModel> list) {
        mImageList = list;
        mContext=context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public ViewHolder(View v) {
            super(v);
            mImageView = (ImageView) v.findViewById(R.id.image_view);;
        }
    }

    @Override
    public GridViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_view_layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
       holder.mImageView.setImageBitmap(mImageList.get(position).getBitmap());
    }

    @Override
    public int getItemCount() {
        return mImageList.size();
    }
}