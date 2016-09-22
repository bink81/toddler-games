package labyrinth;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class Coordinate {

	private final int x;
	private final int y;

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(x, y);
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Coordinate) {
			Coordinate that = (Coordinate) object;
			return Objects.equal(this.x, that.x) && Objects.equal(this.y, that.y);
		}
		return false;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("x", x).add("y", y).toString();
	}
}
