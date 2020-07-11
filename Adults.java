class Adults extends Passenger{
	public Adults(String _name, int _age){
		super(_name,_age);
	}

	public double calcDisc(){
		if(super.age >= 60){
			return DiscConsiderable.DISC_SENIOR;
		}else{
			return 0;
		}
	}

	public void displayDetails(){
		System.out.println(super.name + " " + Integer.toString(super.age) + "-");
	}
}