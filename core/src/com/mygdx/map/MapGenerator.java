package com.mygdx.map;

import com.badlogic.gdx.Gdx;
import com.mygdx.enumeration.WallType;
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
			Wall.wallManager.createWall(WallType.BRICK_WALL, Float.valueOf(point[0]), Float.valueOf(point[1]));
		}
	}
}
