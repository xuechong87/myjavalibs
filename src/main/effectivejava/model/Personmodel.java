package effectivejava.model;

public class Personmodel implements Comparable<Personmodel>{
	
	private String name;
	private Integer age;
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Personmodel)){
			return false;
		}
		Personmodel p  = (Personmodel)obj;
		if(p.getName().equals(this.name)&&p.getAge().equals(this.age)){
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return (this.name.hashCode() + this.age.hashCode());
	}
	
	@Override
	public String toString() {
		return  super.toString() + "||" +"name:" + name + "  age:" +  age ;
	}
	
	@Override
	public int compareTo(Personmodel o) {
		if(o.equals(this)){
			return 0;
		}
		return o.getAge().hashCode()>this.hashCode()?1:-1;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
}
