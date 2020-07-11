import java.util.Scanner;
import java.util.ArrayList;

public class FlightTest{

	private static ArrayList<Flight> flightList;
	
	public static void main(String args[]){
		flightList = new ArrayList<Flight>();
		menu();
	}

	public static void menu(){

		boolean exitProgram = false;
		String chosenOpt;

		while(!exitProgram){
			System.out.println("\n========== Menu ==========");
			System.out.println("[1] Add Flight");
			System.out.println("[2] Add Passenger");
			System.out.println("[3] Display Flights");
			System.out.println("[4] Display Passengers");
			System.out.println("[5] Exit");
			System.out.println("==========================");

			System.out.print("\nSelect task: ");

			Scanner userInput = new Scanner(System.in);

			chosenOpt = userInput.nextLine();

			switch(chosenOpt){

				case "1":

					System.out.println("<<< Add Flight >>>\n");			
					System.out.print(String.format("%-18s %s" , "Enter Flight Id", " : "));
					String _id = userInput.nextLine();
					System.out.print(String.format("%-18s %s" , "Enter Flight From", " : "));
					String _from = userInput.nextLine();
					System.out.print(String.format("%-18s %s" , "Enter Flight To", " : "));
					String _to = userInput.nextLine();
					System.out.print(String.format("%-18s %s" , "Enter Price Ticket", " : RM"));
					double _price = Double.valueOf(userInput.nextLine());

					Flight newFlight = new Flight(_id,_from,_to,_price);
					flightList.add(newFlight);


					break;

				case "2":

					if(flightList.size() >= 1){

						System.out.println("<<< Add Passenger(s) >>>\n");

						System.out.println("Flight list");

						for(int i=0;i<flightList.size();i++){
							System.out.println(Integer.toString(i+1) + ") " + flightList.get(i).getFlightId());
						}

						System.out.print("\nSelect flight : ");
						int selectedFlight = Integer.valueOf(userInput.nextLine());

						boolean exitPassengerLoop = false;

						while(!exitPassengerLoop){
							System.out.println("\n--- Enter Passenger Info ---\n");
							System.out.print("Enter Name: ");
							String _name = userInput.nextLine();
							System.out.print("Enter Age: ");
							int _age = Integer.valueOf(userInput.nextLine());

							Passenger _newPassenger;

							if(_age <= 12){
								System.out.print("Enter Parent Name: ");
								String _parentName = userInput.nextLine();
								_newPassenger = new Kids(_name,_age,_parentName);
							}else{
								_newPassenger = new Adults(_name,_age);
							}

							flightList.get(selectedFlight-1).addPassenger(_newPassenger);

							System.out.print("\nPress 'Y' to continue >> ");

							String continueOpt = userInput.nextLine();

							if(!continueOpt.equals("Y") && !continueOpt.equals("y")){
								exitPassengerLoop = true;	
							}
						}
					}else{
						System.out.println("Sorry!! No flight, please add flight first...");
					}



					break;

				case "3":

					if(flightList.size() < 1){
						System.out.println("Sorry!! No flight, please add flight first...");
					}else{
						System.out.println("\n<<< Flight Info >>>\n");

						System.out.println("Number of Flights: " + Integer.valueOf(flightList.size()));

						for(int i=0;i<flightList.size();i++){

							System.out.println("\nFlight #" + Integer.valueOf(i+1));

							flightList.get(i).displayInfoFlight();

						}

					}

					break;

				case "4":

					if(flightList.size() < 1){
						System.out.println("Sorry!! No flight, please add flight first...");
					}else{
						System.out.println("\n<<< Flight(s) and Passenger(s) Info >>>\n");

						System.out.println("Number of Flights: " + Integer.valueOf(flightList.size()) + "\n");

						for(int i=0;i<flightList.size();i++){

							System.out.println("Flight #" + Integer.valueOf(i+1));

							flightList.get(i).displayInfoFlight();
							flightList.get(i).displayInfoPassengers();							

						}


					}

					

					break;

				case "5":
					exitProgram = true;
					System.out.println("Thank You! :)");
					break;

			}
		}


	}

}