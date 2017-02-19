package solution.bmp.a2048;

import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private float x1,x2,y1,y2;
    static final int MIN_DISTANCE_L_R = 150;
    static final int MIN_DISTANCE_R_L = -150;

    private Board board;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        board = new Board(4);
        updateGUI();
    }


    public void updateGUI()
    {
        TextView loc_0_0 = (TextView) findViewById(R.id.loc_0_0);
        TextView loc_0_1 = (TextView) findViewById(R.id.loc_0_1);
        TextView loc_0_2 = (TextView) findViewById(R.id.loc_0_2);
        TextView loc_0_3 = (TextView) findViewById(R.id.loc_0_3);
        TextView loc_1_0 = (TextView) findViewById(R.id.loc_1_0);
        TextView loc_1_1 = (TextView) findViewById(R.id.loc_1_1);
        TextView loc_1_2 = (TextView) findViewById(R.id.loc_1_2);
        TextView loc_1_3 = (TextView) findViewById(R.id.loc_1_3);
        TextView loc_2_0 = (TextView) findViewById(R.id.loc_2_0);
        TextView loc_2_1 = (TextView) findViewById(R.id.loc_2_1);
        TextView loc_2_2 = (TextView) findViewById(R.id.loc_2_2);
        TextView loc_2_3 = (TextView) findViewById(R.id.loc_2_3);
        TextView loc_3_0 = (TextView) findViewById(R.id.loc_3_0);
        TextView loc_3_1 = (TextView) findViewById(R.id.loc_3_1);
        TextView loc_3_2 = (TextView) findViewById(R.id.loc_3_2);
        TextView loc_3_3 = (TextView) findViewById(R.id.loc_3_3);

        Cell[][] temp = board.getBoard();
        int tempsize = board.getSize();
        for (int i = 0; i < tempsize; i++)
        {
            for(int j = 0; j < tempsize; j++)
            {


                switch(i){
                    case 0:
                        switch(j){
                            case 0: loc_0_0.setText("" + temp[i][j].getValue());
                                    break;
                            case 1: loc_0_1.setText("" + temp[i][j].getValue());
                                    break;
                            case 2: loc_0_2.setText("" + temp[i][j].getValue());
                                    break;
                            case 3: loc_0_3.setText("" + temp[i][j].getValue());
                                    break;
                        }
                    case 1:
                        switch(j){
                            case 0: loc_1_0.setText("" + temp[i][j].getValue());
                                break;
                            case 1: loc_1_1.setText("" + temp[i][j].getValue());
                                break;
                            case 2: loc_1_2.setText("" + temp[i][j].getValue());
                                break;
                            case 3: loc_1_3.setText("" + temp[i][j].getValue());
                                break;

                        }
                    case 2:
                        switch(j){
                            case 0: loc_2_0.setText("" + temp[i][j].getValue());
                                break;
                            case 1: loc_2_1.setText("" + temp[i][j].getValue());
                                break;
                            case 2: loc_2_2.setText("" + temp[i][j].getValue());
                                break;
                            case 3: loc_2_3.setText("" + temp[i][j].getValue());
                                break;

                        }
                    case 3:
                        switch(j){
                            case 0: loc_3_0.setText("" + temp[i][j].getValue());
                                break;
                            case 1: loc_3_1.setText("" + temp[i][j].getValue());
                                break;
                            case 2: loc_3_2.setText("" + temp[i][j].getValue());
                                break;
                            case 3: loc_3_3.setText("" + temp[i][j].getValue());
                                break;

                        }
                }
            }
        }

    }



    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                y1 = event.getY();

                break;
            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                y2 = event.getY();

                float deltaX = x2 - x1;
                float deltaY = y2 - y1;
                if (deltaX > MIN_DISTANCE_L_R)
                {
                    board.moveRight();
                    updateGUI();
                    Log.d("DEBUG", "left2right swipe " + deltaX);
                }
                else if (deltaX < MIN_DISTANCE_R_L)
                {
                    board.moveLeft();
                    updateGUI();
                    Log.d("DEBUG", "right2left swipe" + deltaX);
                }
                else if (deltaY > MIN_DISTANCE_L_R)
                {
                    board.moveDown();
                    updateGUI();
                    Log.d("DEBUG", "top2bottom swipe" + deltaY);
                }
                else if (deltaY < MIN_DISTANCE_R_L)
                {
                    board.moveUp();
                    updateGUI();
                    Log.d("DEBUG", "bottom2top swipe" + deltaY);
                }
                break;
        }
        return super.onTouchEvent(event);
    }
}

