package lesson5.part_04.frame_09;

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
