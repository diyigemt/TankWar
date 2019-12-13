package com.mygdx.map;

import com.badlogic.gdx.Gdx;
import com.mygdx.enumeration.WallType;
import com.mygdx.game.Constants;
import com.mygdx.wall.Wall;

import java.io.FileInputStream;

public class MapGenerator {
	public MapGenerator() {

	}
	public void generate(int mapId) {
		String divide[] = Gdx.files.internal("map/" + String.valueOf(mapId) + ".txt").readString().split(";");
		String position[] = divide[0].split("'");
		int n = Integer.valueOf(position[0]);
		for (int i = 1; i < n + 1; i++) {
			String point[] = position[i].split(",");
			if (point[0].equals("1")) {
				float x = Float.valueOf(point[1]);
				for (float y = Float.valueOf(point[2]); y <= Float.valueOf(point[3]); y += Constants.WALL_SIZE) {
					Wall.wallManager.createWall(WallType.BRICK_WALL, x + Constants.MAP_TRANSLATION_X, y + Constants.MAP_TRANSLATION_Y);
				}
			}else {
				float y = Float.valueOf(point[1]);
				for (float x = Float.valueOf(point[2]); x <= Float.valueOf(point[3]); x += Constants.WALL_SIZE) {
					Wall.wallManager.createWall(WallType.BRICK_WALL, x + Constants.MAP_TRANSLATION_X, y + Constants.MAP_TRANSLATION_Y);
				}
			}
		}
	}
}
