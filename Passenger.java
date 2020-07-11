abstract class Passenger{
	
	protected String name;
	protected int age;

	public Passenger(String _name, int _age){
		this.name = _name;
		this.age = _age;
	}

	public abstract void displayDetails();

}