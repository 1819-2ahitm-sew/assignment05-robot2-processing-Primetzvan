package at.htl.robot.model;

public class Robot {

    private int x = 0;
    private int y = 0;
    private Direction direction = Direction.SOUTH;
    private int maxrow;
    private int maxcol;
    private boolean modi = true;
    private int modiX = -4;
    private int modiY = 50;

    public Robot(int maxrow, int maxcol) {
        this.maxcol = maxcol - 2;
        this.maxrow = maxrow;
    }

    //region Getter and Setter
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    //endregion

    public boolean getModi() {
        return modi;
    }

    public void setModi(boolean modi) {
        this.modi = modi;
    }

    public int getModiX() {
        return modiX;
    }

    public void setModiX(int modiX) {
        this.modiX = modiX;
    }

    public int getModiY() {
        return modiY;
    }

    public void setModiY(int modiY) {
        this.modiY = modiY;
    }

    public void stepForward() {
        if (modi){
        switch (getDirection()){
            case EAST:
                if (getX() < maxrow){
                    setX(getX() + 1);
                }else {
                    setX(0);
                }
                break;
            case WEST:
                if (getX() > 0){
                    setX(getX() - 1);
                }else {
                    setX(maxrow);
                }
                break;
            case NORTH:
                if (getY() > 0){
                    setY(getY() - 1);
                }else{
                    setY(maxcol);
                }
                break;
            case SOUTH:
                if (getY() < maxcol){
                    setY(getY() + 1);
                }else{
                    setY(0);
                }
        }
        }else {
            switch (getDirection()){
                case EAST:
                    if (getX() < maxrow){
                        setX(getX() + 1);
                    }else {
                        setX(getX());
                    }
                    break;
                case WEST:
                    if (getX() > 0){
                        setX(getX() - 1);
                    }else {
                        setX(getX());
                    }
                    break;
                case NORTH:
                    if (getY() > 0){
                        setY(getY() - 1);
                    }else{
                        setY(getY());
                    }
                    break;
                case SOUTH:
                    if (getY() < maxcol){
                        setY(getY() + 1);
                    }else{
                        setY(getY());
                    }
            }
        }
    }

    public void rotateLeft(){
        switch (getDirection()){
            case NORTH:
                setDirection(Direction.WEST);
                setModiX(-23);
                setModiY(+35);
                break;
            case EAST:
                setDirection(Direction.NORTH);
                setModiX(-4);
                setModiY(+20);
                break;
            case SOUTH:
                setDirection(Direction.EAST);
                setModiX(+13);
                setModiY(+35);
                break;
            case WEST:
                setDirection(Direction.SOUTH);
                setModiX(-4);
                setModiY(+50);
                break;


        }
    }



}
