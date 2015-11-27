package dummy.com.swipedissmissbehaviourdemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Toast;

import java.util.ArrayList;

import static android.support.v7.widget.helper.ItemTouchHelper.RIGHT;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerview;
    private LinearLayoutManager mLinearLayoutManager;
    private ArrayList<MovieList> mMovieArrayList;
Context context =this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerview= (RecyclerView) findViewById(R.id.recyclerview);
        intializeData();
        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerview.setLayoutManager(mLinearLayoutManager);
        final MovieAdapter movieAdapter=new MovieAdapter(this,mMovieArrayList);
        mRecyclerview.setAdapter(movieAdapter);
        ItemTouchHelper.Callback itemTouchCallBack=new ItemSwipeHelper(Direction.RIGHT,movieAdapter);
        ItemTouchHelper swipeToDismissTouchHelper =new ItemTouchHelper(itemTouchCallBack);
        swipeToDismissTouchHelper.attachToRecyclerView(mRecyclerview);

    }

    private void intializeData()
    {
      mMovieArrayList=new ArrayList<>();
        for(int i=0;i<20;i++)
      {
          MovieList movieList=new MovieList();
          movieList.setMovieTitle("Titanic");
          movieList.setMovieSummary("Titanic is a 1997 American epic romantic disaster film directed, written, co-produced, and co-edited by James Cameron. A fictionalized account of the sinking of the RMS Titanic, it stars Leonardo DiCaprio and Kate Winslet as members of different social classes who fall in love aboard the ship during its ill-fated maiden voyage.\n" +
                  "\n");
          mMovieArrayList.add(movieList);
      }
    }
}
