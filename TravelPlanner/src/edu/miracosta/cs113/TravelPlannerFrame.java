package edu.miracosta.cs113;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 * TravelPlannerFrame that will acts viewer for the Travel Planner program.
 * 
 * It will allow user to generate a randomized text file of flight data or use
 * a stored file. Then the user may select a start and destination for a trip.
 * By clicking "Plan Trip", the user will be shown the cheapest flight path from
 * their chosen start location to their destination. If multiple flights are required,
 * their cost will be outputted individually and the total cost will be outputted in
 * the bottom. User can repeat this process untill they exit from the program.
 * 
 * @author Steven Siddall, Angel Tapia, Nathan Tran
 * @version 1.0
 */
public class TravelPlannerFrame extends Application
{
	private final int NUM_AIRPORTS = 50;
	private final String AIRPORT_FILE_NAME = "src/edu/miracosta/cs113/locations.txt";
	private final String FLIGHT_FILE_NAME = "src/edu/miracosta/cs113/flights.txt";
	
	private TravelPlanner planner;
	private boolean generateNewFlightData = false;
	@Override
	public void start(Stage primaryStage)
	{
		planner = new TravelPlanner(NUM_AIRPORTS);
		//create choices for initial dialog box
		List<String> choices = new ArrayList<String>();
		choices.add("Use stored flight data");
		choices.add("Generate new flight data");
		
		//set up dialog box for choosing data set
		ChoiceDialog<String> dialog = new ChoiceDialog<>("Use stored flight data",choices);
		dialog.setTitle("Choose data to use");
		dialog.setHeaderText("What data would you like to use?");
		dialog.setContentText("Choose data set:");
		
		//display dialog and get real data if they chose to use actual flight data
		Optional<String> result = dialog.showAndWait();
		if(result.isPresent() && result.get().equals("Generate new flight data"))
		{
			generateNewFlightData = true;
		}
		
		//BUILD GUI
		primaryStage.setTitle("Trip Planner");
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(30);
		grid.setPadding(new Insets(25,25,25,25));
		
		Text scenetitle = new Text("Welcome\nWhere can we take you?");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.LIGHT, 35));
		grid.add(scenetitle,0,0,4,1);
		
		Label startLabel = new Label("Start:");
		startLabel.setFont(Font.font("Tahoma", FontWeight.LIGHT, 18));
		grid.add(startLabel, 0, 1);
		
		final ComboBox<String> startLocations = new ComboBox<String>();
		grid.add(startLocations, 1, 1);
		
		Label destinationLabel = new Label("Desination:");
		destinationLabel.setFont(Font.font("Tahoma", FontWeight.LIGHT, 18));
		grid.add(destinationLabel, 3, 1);
		
		final ComboBox<String> destinations = new ComboBox<String>();
		grid.add(destinations, 4, 1);
		
		Text feedback = new Text("");
		//feedback.setTextAlignment(TextAlignment.CENTER);
		feedback.setFill(Color.RED);
		grid.add(feedback, 4, 3);
		
		Button planBtn = new Button("Plan Trip");
		planBtn.setAlignment(Pos.CENTER);
		planBtn.setMinSize(100, 30);
		planBtn.setFont(Font.font("Tahoma", FontWeight.LIGHT,15));
		planBtn.setOnAction(new EventHandler<ActionEvent>()
				{
					@Override
					public void handle(ActionEvent e)
					{
						if(startLocations.getSelectionModel().isEmpty())
						{
							feedback.setText("Please select a start location.");
							return;
						}
						else if(destinations.getSelectionModel().isEmpty())
						{
							feedback.setText("Please select a destination.");
							return;
						}
						else
						{
							feedback.setText("");
						}
						
						//find cheapest path
						String start = startLocations.getValue();
						String dest = destinations.getValue();
						String[] route = planner.getCheapestPath(start,dest);
						//build string to put in popup
						double totalCost = 0;
						StringBuilder sb = new StringBuilder();
						for(int i = 0; i < route.length - 1; i++)
						{
							sb.append(route[i] + "    to    " + route[i+1] +
									"    Cost: $" + planner.getFlightCost(route[i], route[i+1]) + "\n");
							totalCost += planner.getFlightCost(route[i], route[i+1]);
						}
						sb.append("\nTotal:    " + route[0] + "    to    " +
								route[route.length - 1] + "    Cost: $" + totalCost);
						
						//display popup
						Alert routeDialog = new Alert(AlertType.INFORMATION);
						routeDialog.setTitle("Cheapest Route");
						routeDialog.setHeaderText("Your Route");
						routeDialog.setContentText(sb.toString());
						routeDialog.showAndWait();
					}
				});
		grid.add(planBtn,2,2);
		
		//BUILD GRAPH
		buildGraph(startLocations.getItems(),destinations.getItems());
		
		//DISPLAY_GUI
		Scene scene = new Scene(grid, 900, 600);
		primaryStage.setResizable(false);
		
		Image image = new Image("https://cdn.pixabay.com/photo/2016/09/14/20/03/air-plan-1670266_960_720.jpg");
		// new BackgroundSize(width, height, widthAsPercentage, heightAsPercentage, contain, cover)
		BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
		// new BackgroundImage(image, repeatX, repeatY, position, size)
		BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.REPEAT,
					BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
		// new Background(images...)
		Background background = new Background(backgroundImage);
		grid.setBackground(background);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	/**
	 * buildGraph method, takes in a randomly generated text file
	 * or a stored text file to create graph.
	 * 
	 * @param startBox - dropdown box in GUI for Start locations
	 * @param destinationBox - dropdown box in GUI for Destination locations
	 */
	private void buildGraph(ObservableList<String> startBox, ObservableList<String> destinationBox)
	{
		Scanner locationsFileIn = null;
		try
		{
			locationsFileIn = new Scanner(new FileInputStream(AIRPORT_FILE_NAME));
		
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Couldn't find input text file");
		}
		//read in airports
		while(locationsFileIn.hasNext())
		{
			String airport = locationsFileIn.nextLine();
			planner.addAirport(airport);
			startBox.addAll(airport);
			destinationBox.addAll(airport);
		}
		locationsFileIn.close();
		
		//generate new data if user chose to do so
		if(generateNewFlightData)
		{
			locationsFileIn = null;
			PrintWriter flightsFileOut = null;
			try
			{
				locationsFileIn = new Scanner(new FileInputStream(AIRPORT_FILE_NAME));
				flightsFileOut = new PrintWriter(new FileOutputStream(FLIGHT_FILE_NAME));
			}
			catch(FileNotFoundException e)
			{
				System.out.println("Couldn't find text file");
			}
			
			generateFlightData(locationsFileIn,flightsFileOut);
			locationsFileIn.close();
			flightsFileOut.close();
		}
		
		locationsFileIn = null;
		Scanner flightsFileIn = null;
		try
		{
			locationsFileIn = new Scanner(new FileInputStream(AIRPORT_FILE_NAME));
			flightsFileIn = new Scanner(new FileInputStream(FLIGHT_FILE_NAME));
		
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Couldn't find input text file");
		}
		
		//read in flights
		while(flightsFileIn.hasNext())
		{
			String source = flightsFileIn.nextLine();
			String destination = flightsFileIn.nextLine();
			double cost = Double.parseDouble(flightsFileIn.nextLine());
			
			planner.addFlight(source, destination, cost);
		}
		
		locationsFileIn.close();
		flightsFileIn.close();
	}
	/**
	 * generateFlightData() method, generates random number of flights with
	 * random cost.
	 * @param locations - locations that will be read in from a text file
	 * @param flights - prints flight start, destination and cost to file.
	 */
	private void generateFlightData(Scanner locations, PrintWriter flights)
	{
		if(locations == null || flights == null)
		{
			System.out.println("ERROR: One of the streams is null");
			return;
		}
		
		Random rng = new Random();
		while(locations.hasNext())
		{
			int numConnections = rng.nextInt(10) + 10;
			String currentLocation = locations.nextLine();
			for(int i = 0; i < numConnections; i++)
			{
				flights.println(currentLocation);
				int destination = rng.nextInt(planner.getNumAirports());
				String destinationName = planner.getAirport(destination);
				flights.println(destinationName);
				double cost = rng.nextInt(800) + 200;
				flights.println(cost);
			}
		}
	}
	//Driver to start Travel Planner Program
	public static void main(String[] args)
	{
		launch(args);
	}
}
