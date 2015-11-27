package dummy.com.swipedissmissbehaviourdemo;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Bharat Ghimire on 25/11/15.
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>
        implements ItemTouchHelperAdapter
{

    ArrayList<MovieList> movieListArrayList;
    Activity activity;

    public MovieAdapter(Activity activity, ArrayList<MovieList> movieListArrayList) {
        this.movieListArrayList = movieListArrayList;
        this.activity = activity;

    }

    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false);
        return  new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        MovieList movieList=movieListArrayList.get(position);
        viewHolder.textViewMovieTitle.setText(movieList.getMovieTitle());
        viewHolder.textViewMovieSummary.setText(movieList.getMovieSummary());
    }




    @Override
    public int getItemCount() {
        return movieListArrayList.size();
    }

    @Override
    public void swipeToDelete(int position) {
        movieListArrayList.remove(position);
        Toast.makeText(activity, "Item Remove at position " + position, Toast.LENGTH_LONG).show();
        notifyDataSetChanged();

    }

    class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView textViewMovieTitle;
        TextView textViewMovieSummary;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cardview);
            textViewMovieTitle = (TextView) itemView.findViewById(R.id.textview_title);
            textViewMovieSummary = (TextView) itemView.findViewById(R.id.textview_content);
        }
        public void remove(int position) {
            movieListArrayList.remove(position);
            notifyItemRemoved(position);
        }
    }
}
