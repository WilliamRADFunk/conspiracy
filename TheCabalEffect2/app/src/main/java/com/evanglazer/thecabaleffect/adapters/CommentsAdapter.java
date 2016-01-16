package com.evanglazer.thecabaleffect.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.evanglazer.thecabaleffect.R;
import com.evanglazer.thecabaleffect.models.comments;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evan on 1/16/2016.
 */
public class CommentsAdapter extends BaseAdapter {


    private List<comments> commentsList = null;
    Context mContext;
    LayoutInflater inflater;

    private ArrayList<comments> arraylist;

    public CommentsAdapter(Context context, List<comments> object) {
        mContext = context;
        this.commentsList = object;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<comments>();
        this.arraylist.addAll(object);
    }

    public class ViewHolder {
        TextView commentUsername;
        TextView content;
        TextView postedDate;
    }

    @Override
    public int getCount() {
        return commentsList.size();
    }

    @Override
    public comments getItem(int position) {
        return commentsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.comments_layout, null);

            holder.commentUsername = (TextView) view.findViewById(R.id.feedsTitle);
            holder.content = (TextView) view.findViewById(R.id.authorName);
            holder.postedDate = (TextView) view.findViewById(R.id.conspiratorNumber);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.commentUsername.setText("" + commentsList.get(position).getUsername());
        holder.content.setText("" + commentsList.get(position).getContent());
        holder.postedDate.setText("" + commentsList.get(position).getPostedDate());

        // Listen for ListView Item Click
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

            }
        });

        return view;
    }
}