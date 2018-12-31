package com.example.macprosam.ytsmovies;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAcceuilAdapter extends RecyclerView.Adapter<PlaceViewHolderhome> {
    private Context mContext;

    private List<Movie> moviesnames;

    public MyAcceuilAdapter(Context mContext, List<Movie> moviesnames) {
        this.mContext = mContext;

        this.moviesnames = moviesnames;
    }

    @Override
    public PlaceViewHolderhome onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.homerow,
                parent, false);
        return new PlaceViewHolderhome(view);
    }

    @Override
    public void onBindViewHolder( final PlaceViewHolderhome holder, int position) {

        Picasso.with(mContext).load(moviesnames.get(position).getNomimage()).into(holder.mPlace);
        holder.mnames.setText(moviesnames.get(position).getTitle());
        holder.moviescore.setText(String.valueOf(moviesnames.get(position).getValuerate()));
        holder.year.setText(String.valueOf(moviesnames.get(position).getYear()));
     /*   holder.mPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(mContext, DetailActivity.class);
                mIntent.putExtra("Image", moviesnames.get(holder.getAdapterPosition()).getNomimage());
                mIntent.putExtra("Title", moviesnames.get(holder.getAdapterPosition()).getTitle());
                mIntent.putExtra("id", moviesnames.get(holder.getAdapterPosition()).getId());
                mIntent.putExtra("desc", moviesnames.get(holder.getAdapterPosition()).getDesc());
                mIntent.putExtra("overview", moviesnames.get(holder.getAdapterPosition()).getOverview());
                mIntent.putExtra("year", moviesnames.get(holder.getAdapterPosition()).getYear());
                mIntent.putExtra("tags", moviesnames.get(holder.getAdapterPosition()).getTag());
                mIntent.putExtra("rate", moviesnames.get(holder.getAdapterPosition()).getValuerate());


                mContext.startActivity(mIntent);
            }
        });*/

    }


    @Override
    public int getItemCount() {
        return moviesnames.size();
    }

}

class PlaceViewHolderhome extends RecyclerView.ViewHolder {

    ImageView mPlace;
    TextView mnames,moviescore,year;

    public PlaceViewHolderhome(View itemView) {
        super(itemView);

        mPlace = itemView.findViewById(R.id.ivhome);
        mnames= itemView.findViewById(R.id.Movienamehome);
        moviescore = itemView.findViewById(R.id.Moviescorehome);
        year = itemView.findViewById(R.id.yearhome);
    }
}