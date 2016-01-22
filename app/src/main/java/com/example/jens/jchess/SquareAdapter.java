package com.example.jens.jchess;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class SquareAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;
    // private Piece[] lp;

    // Piece currentPiece = null;

    FrameLayout flcp;
    ImageView imgvcp = null;

    private int whiteTurn;


    // CHESSBOARD
    // references to our images

    private Integer[] chessboardIds = {
            R.drawable.lightsquare, R.drawable.darksquare, R.drawable.lightsquare, R.drawable.darksquare,
            R.drawable.lightsquare, R.drawable.darksquare, R.drawable.lightsquare, R.drawable.darksquare,
            R.drawable.darksquare, R.drawable.lightsquare, R.drawable.darksquare, R.drawable.lightsquare,
            R.drawable.darksquare, R.drawable.lightsquare, R.drawable.darksquare, R.drawable.lightsquare,
            R.drawable.lightsquare, R.drawable.darksquare, R.drawable.lightsquare, R.drawable.darksquare,
            R.drawable.lightsquare, R.drawable.darksquare, R.drawable.lightsquare, R.drawable.darksquare,
            R.drawable.darksquare, R.drawable.lightsquare, R.drawable.darksquare, R.drawable.lightsquare,
            R.drawable.darksquare, R.drawable.lightsquare, R.drawable.darksquare, R.drawable.lightsquare,
            R.drawable.lightsquare, R.drawable.darksquare, R.drawable.lightsquare, R.drawable.darksquare,
            R.drawable.lightsquare, R.drawable.darksquare, R.drawable.lightsquare, R.drawable.darksquare,
            R.drawable.darksquare, R.drawable.lightsquare, R.drawable.darksquare, R.drawable.lightsquare,
            R.drawable.darksquare, R.drawable.lightsquare, R.drawable.darksquare, R.drawable.lightsquare,
            R.drawable.lightsquare, R.drawable.darksquare, R.drawable.lightsquare, R.drawable.darksquare,
            R.drawable.lightsquare, R.drawable.darksquare, R.drawable.lightsquare, R.drawable.darksquare,
            R.drawable.darksquare, R.drawable.lightsquare, R.drawable.darksquare, R.drawable.lightsquare,
            R.drawable.darksquare, R.drawable.lightsquare, R.drawable.darksquare, R.drawable.lightsquare,
    };


    static class ViewHolder {
        public ImageView square;
        public ImageView piece;
    }


    public SquareAdapter(Context c /*, Piece[] listPiece, int turn */) {
        mContext = c;
        Context context = c.getApplicationContext();
        mInflater = LayoutInflater.from(context);
        /*
        lp = listPiece;
        whiteTurn = turn;
        */
    }

    @Override
    public int getCount() {
        return chessboardIds.length;
    }

    @Override
    public Object getItem(int arg0) {
        return null;
    }

    @Override
    public long getItemId(int arg0) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        if (rowView == null) {  // if it's not recycled, initialize some attributes

            rowView = mInflater.inflate(R.layout.square, null);


            ViewHolder viewHolder = new ViewHolder();
            viewHolder.square = (ImageView) rowView.findViewById(R.id.square_background);
            viewHolder.square.setImageResource(chessboardIds[position]);
            viewHolder.piece = (ImageView) rowView.findViewById(R.id.piece);
            // viewHolder.piece.setImageResource(lp[position].getRessource());

            // lp[position].setCurrentSquare(position);

            // Assign the touch listener to your view which you want to move
            /* viewHolder.piece.setOnTouchListener(new MyTouchListener());

            viewHolder.square.setOnDragListener(new MyDragListener());
*/
            rowView.setTag(viewHolder);
        }

        ViewHolder holder = (ViewHolder) rowView.getTag();

//      if(lp[position] != null ){
//          holder.piece.setImageResource(((Piece) lp[position]).getRessource());

//      }


        //      if(currentPiece == null){
        //          currentPiece = new Piece();
        //      }else{
        //          Log.v("Test", "Test class " + `lp[position].getClass().toString());`
        //      }

//      lp[position].setCurrentSquare(position);
 //       holder.piece.setTag(lp[position]);

        return rowView;
    }


    // This defines your touch listener
    /*
    private final class MyTouchListener implements OnTouchListener {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                ClipData data = ClipData.newPlainText("", "");
                DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                view.setVisibility(View.INVISIBLE);


                flcp = (FrameLayout) view.getParent();
                imgvcp = (ImageView) flcp.getChildAt(1);
                currentPiece = (Piece) view.getTag();

                //              ((ChessActivity) mContext).setNewAdapter(((Piece) view.getTag()).getPossibleMoves());

                return true;
            } else {
                return false;
            }
        }
    }

    class MyDragListener implements OnDragListener {

        @Override
        public boolean onDrag(View v, DragEvent event) {
            int action = event.getAction();

            FrameLayout fl2;
            ImageView imgv2;

            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    //              Log.v("Test", "Entered start");
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    //              Log.v("Test", "Entered drag");
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
                    //              Log.v("Test", "Entered drop");
                    fl2 = (FrameLayout) v.getParent();
                    imgv2 = (ImageView) fl2.getChildAt(1);
                    Piece square = (Piece) imgv2.getTag();

                    if (currentPiece.getPossibleMoves().contains(square.getCurrentSquare())) {
                        //                  imgv.setImageResource(currentPiece.getRessource());
                        Piece destinationPiece = lp[square.getCurrentSquare()];
                        lp[square.getCurrentSquare()] = currentPiece;
                        lp[currentPiece.getCurrentSquare()] = new Piece();

                        if ((yourBeingCheckedDumbAss(currentPiece))
                                || ((destinationPiece instanceof King)
                                && (destinationPiece.getColor() != currentPiece.getColor()))
                                || (whiteTurn != currentPiece.getColor())) {
                            imgvcp.setImageResource(currentPiece.getRessource());
                            imgvcp.setVisibility(View.VISIBLE);
                            lp[square.getCurrentSquare()] = destinationPiece;
                            lp[currentPiece.getCurrentSquare()] = currentPiece;
                        } else {
                            imgvcp.setImageResource(currentPiece.getRessource());
                            ((ChessActivity) mContext).setNewAdapter(lp);
                        }

                    } else {
                        imgvcp.setVisibility(View.VISIBLE);
                    }

                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                default:
                    break;
            }
            return true;
        }

        public boolean movementValid() {

            return false;

        }
    }


    public boolean yourBeingCheckedDumbAss(Piece p) {

        boolean isCheck = false;

        int positionOfMyKing = 0;


        for (int i = 0; i <= 63; i++) {
            if ((lp[i].getColor() == p.getColor()
                    && (lp[i] instanceof King))) {
                positionOfMyKing = i;
            }
        }

        for (int i = 0; i <= 63; i++) {
            if ((lp[i].getColor() != -1)
                    && (lp[i].getColor() != p.getColor())) {
                if (lp[i].getPossibleMoves().contains(positionOfMyKing)) {
                    isCheck = true;
                }
            }

        }

        return isCheck;


    }
    */
}