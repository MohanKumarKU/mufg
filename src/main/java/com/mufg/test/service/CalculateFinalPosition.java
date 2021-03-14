package com.mufg.test.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mufg.test.bean.InputPosition;
import com.mufg.test.bean.Move;
import com.mufg.test.bean.OutputPosition;
import com.mufg.test.bean.Position;

@Service
public class CalculateFinalPosition {

	public OutputPosition getFinalPosition(InputPosition input) {

		char dir = input.getPosition().getDirection().charAt(0);
		List<Move> moveList = input.getMove();
		int x = input.getPosition().getX();
		int y = input.getPosition().getY();
		char newdir = 0;

		for (Move move : moveList) {
			
			int value = 0;
			if (move.getR() != 0) {
				value = move.getR() / 90;
			} else if (move.getL() != 0) {
				value = -move.getL() / 90;
			}

			newdir = getDirection(dir, value);

			if (newdir == 'N') {
				if (move.getF() != 0) {
					y += move.getF();
				} else if (move.getB() != 0) {
					y -= move.getB();
				}
			}

			if (newdir == 'S') {
				if (move.getF() != 0) {
					y -= move.getF();
				} else if (move.getB() != 0) {
					y += move.getB();
				}
			}

			if (newdir == 'E') {
				if (move.getF() != 0) {
					x += move.getF();
				} else if (move.getB() != 0) {
					x -= move.getB();
				}
			}

			if (newdir == 'W') {
				if (move.getF() != 0) {
					x -= move.getF();
				} else if (move.getB() != 0) {
					x += move.getB();
				}
			}
			dir = newdir;
		}

		return prepareNewPosition(x, y, newdir);
	}

	private OutputPosition prepareNewPosition(int x, int y, char newdir) {
		OutputPosition outputPosition = new OutputPosition();
		Position newPosition = new Position();
		newPosition.setDirection(String.valueOf(newdir));
		newPosition.setX(x);
		newPosition.setY(y);
		outputPosition.setPosition(newPosition);
		return outputPosition;
	}

	private char getDirection(char dir, int rotate) {
		if (dir == 'N') {
			if (rotate == -1 || rotate == 3) {
				return dir = 'W';
			}
			if (rotate == -2 || rotate == 2) {
				return dir = 'S';
			}
			if (rotate == -3 || rotate == 1) {
				return dir = 'E';
			}
		}
		if (dir == 'E') {
			if (rotate == -1 || rotate == 3) {
				return dir = 'N';
			}
			if (rotate == -2 || rotate == 2) {
				return dir = 'W';
			}
			if (rotate == -3 || rotate == 1) {
				return dir = 'S';
			}
		}
		if (dir == 'S') {
			if (rotate == -1 || rotate == 3) {
				return dir = 'E';
			}
			if (rotate == -2 || rotate == 2) {
				return dir = 'N';
			}
			if (rotate == -3 || rotate == 1) {
				return dir = 'W';
			}
		}
		if (dir == 'W') {
			if (rotate == -1 || rotate == 3) {
				return dir = 'S';
			}
			if (rotate == -2 || rotate == 2) {
				return dir = 'E';
			}
			if (rotate == -3 || rotate == 1) {
				return dir = 'N';
			}
		}
		return dir;
	}

}
