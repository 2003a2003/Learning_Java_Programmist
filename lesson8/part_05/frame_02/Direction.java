package lesson8.part_05.frame_02;

public enum Direction {
    UP(1), DOWN(2), LEFT(3), RIGHT(4);

    private int id;

    Direction(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
