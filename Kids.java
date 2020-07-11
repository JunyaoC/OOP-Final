class Kids extends Passenger{

	private String parentName;

	public Kids(String _name, int _age, String _parentName){
		super(_name,_age);
		this.parentName = _parentName;
	}

	public double calcDisc(){
		if(super.age <= 2){
			return DiscConsiderable.DISC_KIDS;
		}else{
			return 0;
		}
	}

	public void displayDetails(){
		System.out.print(String.format("%-25s%-5s%-20s", super.name,Integer.toString(super.age),this.parentName));
	}
}