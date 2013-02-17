package effectivejava.typesaveenum;

/**
 * 安全类型枚举
 * @author xuechong
 *
 */
public class Suit {
	
	private final String name;
	
	private Suit(String name){
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
	public static final Suit CLUBS = new Suit("clubs");
}
