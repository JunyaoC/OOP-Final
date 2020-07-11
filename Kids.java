class Kids extends Passenger{

	private String parentName;

	public Kids(String _name, int _age, String _parentName){
		super(_name,_age);
		this.parentName = _parentName;
	}

	public double calcDisc(){
		if(super.age <= 2){
			return DiscConsiderable.DISC_KIDS;
		}
	}

	public void displayDetails(){
		System.out.println(super.name + " " + Integer.toString(super.age) + " " + this.parentName);
	}
}