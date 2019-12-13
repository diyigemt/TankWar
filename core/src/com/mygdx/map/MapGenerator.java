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
		String divide[] = Gdx.files.internal("map/" + String.valueOf(mapId) + ".txt").readString().split("\\r\\n");
		for (int i = 0; i < 4; i++) {
			if (divide[0].charAt(0) == '0')
				continue;
			WallType type = WallType.getInstance(i);
			String position[] = divide[i].split("'");
			for (int j = 1; j <= Integer.valueOf(position[0]); j++) {
				String point[] = position[j].split(",");
				switch (point[0].charAt(0)) {
					case '0' : createAWall(type, Float.valueOf(point[1]) , Float.valueOf(point[2]));
					case '1' : createABigWall(type, Float.valueOf(point[1]) , Float.valueOf(point[2]));
					case '2' : createAListSmallWall(type, Float.valueOf(point[1]) , Float.valueOf(point[2]), Float.valueOf(point[3]));
					case '3' : createAListSmallWall(type, Float.valueOf(point[2]) , Float.valueOf(point[1]), Float.valueOf(point[3]));
					case '4' : createAListBigWall(type, Float.valueOf(point[1]) , Float.valueOf(point[2]), Float.valueOf(point[3]));
					case '5' : createAListBigWall(type, Float.valueOf(point[2]) , Float.valueOf(point[1]), Float.valueOf(point[3]));
					case '6' : createAListSmallBigWall(type, Float.valueOf(point[1]) , Float.valueOf(point[2]), Float.valueOf(point[3]));
					case '7' : createAListSmallBigWall(type, Float.valueOf(point[2]) , Float.valueOf(point[1]), Float.valueOf(point[3]));
				}
			}
		}
	}

	//创建一个墙
	private void createAWall(WallType type, float x, float y) {
		Wall.wallManager.createWall(type, x + Constants.MAP_TRANSLATION_X, y + Constants.MAP_TRANSLATION_Y);
	}
	//创建一个由4个小墙组成的大墙
	private void createABigWall(WallType type, float x, float y) {
		createAListSmallWall(type, x, y, y + Constants.WALL_SIZE);
		createAListSmallWall(type, x + Constants.WALL_SIZE, y, y + Constants.WALL_SIZE);
	}
	//创建一列小墙
	private void createAListSmallWall(WallType type, float x, float y, float end) {
		for (;y <= end; y += Constants.WALL_SIZE) {
			createAWall(type, x, y);
		}
	}
	//创建一列大墙
	private void createAListBigWall(WallType type, float x, float y, float end) {
		for (;y <= end; y += Constants.WALL_SIZE * 2) {
			createAWall(type, x, y);
		}
	}
	//创建一列由4个小墙组成的大墙
	private void createAListSmallBigWall(WallType type, float x, float y, float end) {
		for (; y <= end; y+= Constants.WALL_SIZE * 2) {
			createABigWall(type, x, y);
		}
	}
}
