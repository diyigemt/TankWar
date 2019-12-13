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
			if (divide[i].equals("0"))
				continue;
			WallType type = WallType.getInstance(i);
			String position[] = divide[i].split("'");
			for (int j = 1; j < position.length; j++) {
				String point[] = position[j].split(",");
				switch (point[0].charAt(0)) {
					case '0' : createAWall(type, Float.valueOf(point[1]) , Float.valueOf(point[2])); break;
					case '1' : createABigWall(type, Float.valueOf(point[1]) , Float.valueOf(point[2])); break;
					case '2' : createAListVSmallWall(type, Float.valueOf(point[1]) , Float.valueOf(point[2]), Float.valueOf(point[3])); break;
					case '3' : createAListHSmallWall(type, Float.valueOf(point[1]) , Float.valueOf(point[2]), Float.valueOf(point[3])); break;
					case '4' : createAListVBigWall(type, Float.valueOf(point[1]) , Float.valueOf(point[2]), Float.valueOf(point[3])); break;
					case '5' : createAListHBigWall(type, Float.valueOf(point[1]) , Float.valueOf(point[2]), Float.valueOf(point[3])); break;
					case '6' : createAListVSmallBigWall(type, Float.valueOf(point[1]) , Float.valueOf(point[2]), Float.valueOf(point[3])); break;
					case '7' : createAListHSmallBigWall(type, Float.valueOf(point[1]) , Float.valueOf(point[2]), Float.valueOf(point[3])); break;
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
		createAListVSmallWall(type, x, y, y + Constants.WALL_SIZE);
		createAListVSmallWall(type, x + Constants.WALL_SIZE, y, y + Constants.WALL_SIZE);
	}
	//创建一列小墙
	private void createAListVSmallWall(WallType type, float x, float y, float endY) {
		for (;y <= endY; y += Constants.WALL_SIZE) {
			createAWall(type, x, y);
		}
	}
	//创建一行小墙
	private void createAListHSmallWall(WallType type, float x, float y, float endX) {
		for (;x <= endX; x += Constants.WALL_SIZE) {
			createAWall(type, x, y);
		}
	}
	//创建一列大墙
	private void createAListVBigWall(WallType type, float x, float y, float endY) {
		for (;y <= endY; y += Constants.WALL_SIZE * 2) {
			createAWall(type, x, y);
		}
	}
	//创建一行大墙
	private void createAListHBigWall(WallType type, float x, float y, float endX) {
		for (;x <= endX; x += Constants.WALL_SIZE * 2) {
			createAWall(type, x, y);
		}
	}
	//创建一列由4个小墙组成的大墙
	private void createAListVSmallBigWall(WallType type, float x, float y, float endY) {
		for (; y <= endY; y+= Constants.WALL_SIZE * 2) {
			createABigWall(type, x, y);
		}
	}
	//创建一行由4个小墙组成的大墙
	private void createAListHSmallBigWall(WallType type, float x, float y, float endX) {
		for (; x <= endX; x+= Constants.WALL_SIZE * 2) {
			createABigWall(type, x, y);
		}
	}
}
