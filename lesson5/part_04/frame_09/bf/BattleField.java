package lesson5.part_04.frame_09.bf;

import java.awt.*;
import java.util.Random;

public class BattleField implements Drawable {

	public static final String BRICK = "B";
	public static final String EAGLE = "E";
	public static final String ROCK = "R";
	public static final String WATER = "W";

	private int bfWidth = 576;
	private int bfHeight = 576;
	private final int SIZE_ONE_QUADRANT = 64;

//	private String[][] battleFieldTemplate = {
//			{" ", "W", "B", "B", " ", "B", "B", "B", " "},
//			{"B", " ", " ", " ", " ", " ", " ", " ", "B"},
//			{"B", "B", "B", " ", "R", " ", "B", "B", "B"},
//			{"B", "B", "B", " ", " ", " ", "B", "B", "B"},
//			{"W", "B", "B", " ", "B", " ", "B", "B", "W"},
//			{"B", "B", " ", "B", "B", "B", " ", "B", "B"},
//			{"B", "B", " ", " ", " ", " ", " ", "B", "B"},
//			{"B", " ", " ", "B", "B", "B", " ", " ", "B"},
//			{" ", " ", " ", "B", "E", "B", " ", " ", " "}
//		};
//
//	private String[][] battleFieldTemplate = {
//			{" ", "W", "B", "B", " ", "B", "B", "B", " "},
//			{"B", " ", " ", " ", " ", " ", " ", " ", "B"},
//			{"B", "B", "B", " ", "R", " ", "B", "B", "B"},
//			{"B", "B", "B", " ", " ", " ", "B", "B", "B"},
//			{"W", "B", "B", " ", "B", " ", "B", "B", "W"},
//			{"B", "B", " ", "B", "B", "B", " ", "B", "B"},
//			{"B", "B", " ", " ", " ", " ", " ", "B", "B"},
//			{"B", " ", " ", "B", "B", "B", " ", " ", "B"},
//			{" ", " ", " ", "B", "E", "B", " ", " ", " "}
//	};

	private String[][] battleFieldTemplate = {
			{" ", " ", " ", "B", " ", "B", "R", "W", " "},
			{" ", " ", " ", " ", " ", " ", " ", " ", " "},
			{" ", "B", "B", " ", " ", " ", "R", "B", " "},
			{" ", " ", " ", " ", " ", " ", " ", " ", " "},
			{"B", "B", "B", " ", " ", " ", "B", "B", "B"},
			{"B", "B", " ", "B", " ", "B", " ", "B", "B"},
			{"B", "B", " ", " ", " ", " ", " ", "B", "B"},
			{"B", " ", " ", "B", "B", "B", " ", " ", "B"},
			{" ", " ", " ", "B", "E", "B", " ", " ", " "}
	};


	private BFObject[][] battleField = new BFObject[9][9];

	public BattleField() {
		drawBattleField();
	}

	public BattleField(String[][] battleField) {
		this.battleFieldTemplate = battleField;
		drawBattleField();
	}

	private String getQuadrantXY(int v, int h) {
		return (v - 1) * 64 + "_" + (h - 1) * 64;
	}

	private void drawBattleField() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				String coordinates = getQuadrantXY(i + 1, j + 1);
				int separator = coordinates.indexOf("_");
				int y = Integer.parseInt(coordinates.substring(0, separator));
				int x = Integer.parseInt(coordinates.substring(separator + 1));

				String obj = battleFieldTemplate[i][j];
				BFObject bfObject;
				if (obj.equals(BRICK)) {
					//bfObject = new Brick(x, y);
					battleField[i][j] = new Brick(x, y);
				} else if (obj.equals(ROCK)) {
					//bfObject = new Rock(x, y);
					battleField[i][j] = new Rock(x, y);
				} else if (obj.equals(EAGLE)) {
//					bfObject = new Eagle(x, y);
					battleField[i][j] = new Eagle(x, y);
				} else if (obj.equals(WATER)) {
//					bfObject = new Water(x, y);
					battleField[i][j] = new Water(x, y);
				} else {
//					bfObject = new Blank(x, y);
					battleField[i][j] = new Blank(x, y);
				}
				//battleField[i][j] = bfObject;
			}
		}
	}
	
	@Override
	public void draw(Graphics g) {
		for (int j = 0; j < battleField.length; j++) {
			for (int k = 0; k < battleField.length; k++) {
				battleField[j][k].draw(g);
			}
		}
	}
	
	public void destroyObject(int v, int h) {
		battleField[v][h].destroy();
	}

	public BFObject scanQuadrant(int v, int h) {
		return battleField[v][h];
	}

	public String getAggressorLocation() {
		int x = 0;
		int y = 0;

		Random r = new Random();
		int index = r.nextInt(3);

		if (index == 0) {
			x = 0;
		} else if (index == 1) {
			x = 4 * SIZE_ONE_QUADRANT;
		} else {
			x = 8 * SIZE_ONE_QUADRANT;
		}
		return x +"_" + y;
	}

	public int getBfWidth() {
		return bfWidth;
	}

	public int getBfHeight() {
		return bfHeight;
	}
}
