public class Point {

	private int x;
	private int y;

	public Point(int i, int j) {
		x = i;
		y = j;
	}

	public void printpoint() {
		System.out.println("x: " + this.x + "\n y:" + this.y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
