package solution.bmp.a2048;

import java.util.Random;

/**
 * Created by mrybak834 on 2/18/17.
 */

public class Cell {
    int value;

    Cell(){
        this.value = 0;
    }

    int random(){
        Random r = new Random();
        int randNumber = r.nextInt(1);

        if(randNumber == 0){
            this.value = 2;
            return 2;
        }
        else{
            this.value = 4;
            return 4;
        }
    }

    int update (Cell c){
        this.value = this.value + c.getValue();
        return this.value;
    }

    int getValue(){
        return this.value;
    }

    void setZero (){
        this.value = 0;
    }
}
