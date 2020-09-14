import java.util.Random;

public class Map {
	public int value[][];
	private int x, y;
	public Map(int x, int y) {
		this.x = x;
		this.y = y;
		CreateMap();
		
	}
	private void CreateMap() {
		value = new int[x][y];
		for(int i = 0; i < x; i++) {value[i][0] = 2; value[i][y - 1] = 2;}
		for(int j = 0; j < y; j++) {value[0][j] = 2; value[x-1][j] = 2;}
		value[1][1] = 1;
		createNextTo(1, 1);
		checkZeroValue();
		createEndPoint();
	}
	
	private void createEndPoint() {
		int max = x + y - 2;
		while(true) {
			for(int i = max - x; i <= y; i++) {
				if(value[max - i - 1][i - 1] == 1) {
					value[max - i - 1][i - 1] = 0;
					return ;
				}
			}
			max--;
		}
	}
	private void checkZeroValue() {
		for(int i = 1; i < x - 1; i++) {
			for(int j = 1; j < y - 1; j++) {
				if(value[i][j] == 0) {
					if(i == 1) {
						breakWall1(i, j);
					}
					else if(j == 1) {
						breakWall2(i, j);
					}
					else {
						int tmp = new Random().nextInt() % 2;
						if(tmp > 0) {
							breakWall2(i, j);
						} else {
							breakWall1(i, j);
						}
					}
				}
			}
		}
	}
	private void breakWall1(int i, int j) {
		value[i][j-1] = 1;
		createNextTo(i, j - 1);
	}
	private void breakWall2(int i, int j) {
		value[i - 1][j] = 1;
		createNextTo(i - 1, j);
	}
	private void createNextTo(int i, int j) {
		check(i - 1, j);
		check(i, j - 1);
		check(i + 1, j);
		check(i, j + 1);
	}
	private void check(int i, int j) {
		if(i < 1 || j < 1 || i > x || j > y) return ;
		if(value[i][j] != 0) return ;
		Random r = new Random();
		int tmp = r.nextInt() % 500;
		if(tmp <= 0) {
			value[i][j] = 2;
			return ;
		}
		else {
			value[i][j] = 1;
			createNextTo(i, j);
			return ;
		}
	}
	public void PrintMap() {
		for(int j = 0; j < y; j++) {
			for(int i = 0; i < x; i++) {
				System.out.print(value[i][j] == 2 ? "[]" : value[i][j] == 1 ? "  " : "\\/");
			}
			System.out.println();
		}
	}
}
