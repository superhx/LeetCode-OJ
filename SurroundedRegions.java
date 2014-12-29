package Practice;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class SurroundedRegions  {
	public void solve(char[][] board) {
		int height = board.length;
		if (height == 0)
			return;
		int width = board[0].length;
		boolean[][] mark = new boolean[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				mark[i][j] = false;
			}
		}

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (!mark[i][j] && board[i][j] != 'X') {
					Stack<Point> net = new Stack<Point>();
					ArrayList<Point> nodes = new ArrayList<Point>();
					boolean isAround = true;
					net.push(new Point(i, j));
					while (!net.empty()) {
						Point node = net.pop();
						nodes.add(node);
						int x = node.x;
						int y = node.y;
						mark[x][y] = true;
						isAround = !isAround ? isAround : !(x == height - 1
								|| x == 0 || y == width - 1 || y == 0);
						neighbor(x, y + 1, height, width, board, mark, net);
						neighbor(x, y - 1, height, width, board, mark, net);
						neighbor(x + 1, y, height, width, board, mark, net);
						neighbor(x - 1, y, height, width, board, mark, net);
					}
					if (isAround) {
						Iterator<Point> it = nodes.iterator();
						while (it.hasNext()) {
							Point node = it.next();
							board[node.x][node.y] = 'X';
						}
					}
				}
			}
		}
	}

	private void neighbor(int neighborX, int neighborY, int height, int width,
			char[][] board, boolean[][] mark, Stack<Point> net) {
		if (neighborX < height && neighborY < width && neighborX >= 0
				&& neighborY >= 0 && !mark[neighborX][neighborY]
				&& board[neighborX][neighborY] != 'X') {
			mark[neighborX][neighborY] = true;
			net.push(new Point(neighborX, neighborY));
		}
	}
}