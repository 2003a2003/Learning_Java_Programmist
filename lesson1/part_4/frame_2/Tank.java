package lesson1.part_4.frame_2;

public class Tank {

    private final int speed = 5;
    private int direction;
    private int x;
    private int y;

    private ActionField af;
    private BattleField bf;

    public Tank(ActionField af, BattleField bf){
        this(af,bf,0,0,2);
    }

    public Tank(ActionField af, BattleField bf, int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.af = af;
        this.bf = bf;
    }

    public void turn(int direction) throws Exception{
        this.direction = direction;
        af.processTurn(this);
    }

    public void move() throws Exception {
        af.processMove(this);
    }

    public void fire() throws Exception {
        Bullet bullet = new Bullet(x + 25, y + 25, direction);
        af.processFire(bullet);
    }

    private void moveRandom() {

    }

    private void moveToQuadrant(int x, int y) {

    }


    //get - set
    public int getSpeed() {
        return speed;
    }

    public int getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public void updateX(int x) {
        this.x += x;
    }

    public int getY() {
        return y;
    }

    public void updateY(int y) {
        this.y += y;
    }

}
