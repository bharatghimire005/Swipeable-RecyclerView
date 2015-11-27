package dummy.com.swipedissmissbehaviourdemo;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by Bharat Ghimire on 25/11/15.
 */
public class ItemSwipeHelper extends ItemTouchHelper.Callback {
   private int direction;
   private ItemTouchHelperAdapter itemTouchHelperAdapter;

    public ItemSwipeHelper(int direction,ItemTouchHelperAdapter itemTouchHelperAdapter) {
        this.direction = direction;
        this.itemTouchHelperAdapter= itemTouchHelperAdapter;
    }



    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
       int swipeDirection=0;
        switch(direction)
        {
            case Direction.LEFT:
                swipeDirection=ItemTouchHelper.LEFT;
            break;
            case Direction.RIGHT:
                swipeDirection=ItemTouchHelper.RIGHT;
                break;
            case Direction.UP:
                swipeDirection=ItemTouchHelper.UP;
                break;

            case Direction.DOWN:
                swipeDirection=ItemTouchHelper.DOWN;
                break;
        }

        return makeMovementFlags(0,swipeDirection);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        itemTouchHelperAdapter.swipeToDelete(viewHolder.getAdapterPosition());
    }
}
