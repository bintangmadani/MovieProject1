package com.example.movieproject1.list_movie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.movieproject1.R;

import java.util.ArrayList;

public class ListMovieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mcontext;
    private ArrayList<MovieModel> movieModels;

    private OnItemClickListener mitemclickListener;

    public ListMovieAdapter(Context context, ArrayList<MovieModel> movieModels) {
        this.mcontext = context;
        this.movieModels = movieModels;
    }

    public void updateList(ArrayList<MovieModel> movieModels) {
        this.movieModels = movieModels;
        notifyDataSetChanged();

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movie_list, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof ViewHolder) {
            final MovieModel model = getItem(position);
            ViewHolder genericViewHolder = (ViewHolder) holder;

            genericViewHolder.itemTextTitle.setText(model.getTitle());

            if (model.getOverview().length()>50){
                genericViewHolder.itemTextOverview.setText(model.getOverview().substring(0,49)+" ... ");
            }else{
                genericViewHolder.itemTextOverview.setText(model.getOverview());
            }

            genericViewHolder.imagePoster.setImageResource(model.getPoster());


        }
    }

    @Override
    public int getItemCount() {

        return movieModels.size();
    }

    public void SetOnItemClickListener(final OnItemClickListener mitemclickListener) {
        this.mitemclickListener = mitemclickListener;

    }

    private MovieModel getItem(int position) {
        return movieModels.get(position);
    }

    public interface OnItemClickListener {
        void onClick(View view, int position, MovieModel model);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imagePoster;
        private TextView itemTextTitle;
        private TextView itemTextOverview;

        public ViewHolder(final View itemView) {
            super(itemView);

            this.imagePoster = itemView.findViewById(R.id.image_poster);
            this.itemTextTitle = itemView.findViewById(R.id.item_text_title);
            this.itemTextOverview = itemView.findViewById(R.id.item_text_overview);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mitemclickListener.onClick(itemView,getAdapterPosition(),movieModels.get(getAdapterPosition()));
                }
            });
        }
    }
}
