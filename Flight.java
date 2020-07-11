import java.util.ArrayList;

class Flight{

	private double price;
	private String id;
	private String from;
	private String to;
	private int numAdults;
	private int numKids;
	private ArrayList<Passenger> passengerList;

	public Flight(String _id, String _from, String _to, double _price){
		this.id = _id;
		this.from = _from;
		this.to = _to;
		this.price = _price;
		this.numKids = 0;
		this.numAdults = 0;
		this.passengerList = new ArrayList<Passenger>();
	}

	public String getFlightId(){
		return this.id;
	}

	public void addPassenger(Passenger p){
		this.passengerList.add(p);

		if(p instanceof Adults){
			this.numAdults = this.numAdults + 1;
		}

		if(p instanceof Kids){
			this.numKids = this.numKids + 1;
		}

	}

	public void displayInfoFlight(){
		System.out.println(String.format("%-10s %s" , "Flight Id", " : " + this.id));
		System.out.println(String.format("%-10s %s" , "From", " : " + this.from));
		System.out.println(String.format("%-10s %s" , "To", " : " + this.to));
	}

	public void displayInfoPassengers(){

		System.out.println(String.format("%-15s %s" , "Price", " : " + this.price));

		System.out.println(String.format("%-25s %s" , "Number of Passengers", " : " + Integer.toString(this.numKids + this.numAdults)));
		System.out.println(String.format("%-25s %s" , "Number of Adults", " : " + Integer.toString(this.numAdults)));
		System.out.println(String.format("%-25s %s" , "Number of Kids", " : " + Integer.toString(this.numKids)));

		for (int i=0;i<this.passengerList.size();i++){
			this.passengerList.get(i).displayDetails();
		}

		//// total price


	}
	
}