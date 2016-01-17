package com.evanglazer.thecabaleffect.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.evanglazer.thecabaleffect.FeedDetailActivity;
import com.evanglazer.thecabaleffect.R;
import com.evanglazer.thecabaleffect.models.feeds;
import com.evanglazer.thecabaleffect.models.profile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evan on 1/16/2016.
 */
public class FeedAdapter extends BaseAdapter {


    private List<feeds> feedsList = null;
    Context mContext;
    LayoutInflater inflater;

    private ArrayList<feeds> arraylist;

    public FeedAdapter(Context context, List<feeds> object) {
        mContext = context;
        this.feedsList = object;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<feeds>();
        this.arraylist.addAll(object);
    }

    public class ViewHolder {
        TextView feedTitle;
        TextView feedAuthor;
        TextView feedCount;
        TextView commentCount;
    }

    @Override
    public int getCount() {
        return feedsList.size();
    }

    @Override
    public feeds getItem(int position) {
        return feedsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.feeds_layout, null);

            holder.feedTitle = (TextView) view.findViewById(R.id.feedsTitle);
            holder.feedAuthor = (TextView) view.findViewById(R.id.authorName);
            holder.feedCount = (TextView) view.findViewById(R.id.conspiratorNumber);
            holder.commentCount = (TextView) view.findViewById(R.id.textView6);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        profile prof = new profile();
        // Set the results into TextViews
        holder.feedTitle.setText("" + feedsList.get(position).getTitle());
        holder.feedAuthor.setText("" +feedsList.get(position).getAuthor());
        holder.feedCount.setText("" + feedsList.get(position).getConspiratorCount());
        holder.commentCount.setText( "" + feedsList.get(position).getCommentCount());

        // Listen for ListView Item Click
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(mContext, FeedDetailActivity.class);
                intent.putExtra("title",
                        (feedsList.get(position).getTitle()));
                intent.putExtra("author",
                        (feedsList.get(position).getAuthor()));
                intent.putExtra("conspirator",
                        (feedsList.get(position).getConspiratorCount()));
                intent.putExtra("comments",
                        (feedsList.get(position).getCommentCount()));
                // Start SingleItemView Class
                mContext.startActivity(intent);
            }
            });

        return view;
    }
}





