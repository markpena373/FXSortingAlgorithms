package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;

public class MainController implements Initializable{
	
	@FXML
	private TextField field1 = new TextField();
	
	@FXML
	private TextField field2 = new TextField();
	
	@FXML
	private TextField field3 = new TextField();
	
	@FXML
	private TextField field4 = new TextField();
	
	@FXML
	private TextField field5 = new TextField();
	
	@FXML
	private TextField field6 = new TextField();
	
	@FXML
	private TextField field7 = new TextField();
	
	@FXML
	private TextField field8 = new TextField();
	
	@FXML
	private TextField field9 = new TextField();
	
	@FXML
	private TextField field10 = new TextField();
	
	@FXML
	private ComboBox<String> algorithmComboBox;
	
	@FXML
	private Rectangle rect1;
	
	@FXML
	private Rectangle rect2;
	
	@FXML
	private Rectangle rect3;
	
	@FXML
	private Rectangle rect4;
	
	@FXML
	private Rectangle rect5;
	
	@FXML
	private Rectangle rect6;
	
	@FXML
	private Rectangle rect7;
	
	@FXML
	private Rectangle rect8;
	
	@FXML
	private Rectangle rect9;
	
	@FXML
	private Rectangle rect10;
	
	
	@FXML
	private Slider speedSlider;
	
	Rectangle[] rects;
	TextField[] fields;
	//List<Integer> values = new ArrayList<Integer>();
	//int[] values = new int[10];
	//int[] sortedList;
	
	ObservableList<String> algorithmList = FXCollections.observableArrayList(
			"Bubble Sort", "Merge Sort", "Quick Sort", "Selection Sort", "Inserstion Sort");
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//initSlider();
		initComboBox();
	}
	
	/**
	 * 
	 * @param e
	 */
	@FXML
	public void submit(ActionEvent e) {
		switch(getSelection()) {
			case "Bubble Sort":
				System.out.println(getSelection() + " was selected");
				bubbleSort(parseTextFields());
				
				clearTextFields();
				break;
		}
		
		
		
		/*
		int[] test = {1,2,4,6,8,7,9,3,5,0};
		ArrayList<Integer> list = bubbleSort(test);
		for(int s : list) {
			System.out.println(s);
		}
		*/
		//parseTextFields();
		//clearTextFields();
	}
	
	@FXML
	public String getSelection() {
		return algorithmComboBox.getValue();
	}
	
	/**
	 * 
	 */
	public void initSlider() {

	}
	
	/**
	 * 
	 */
	public void initComboBox() {
		algorithmComboBox.setItems(algorithmList);
	}
	
	/**
	 * 
	 */
	public int[] parseTextFields() {
		int[] values = new int[10];
		fields = new TextField[] {field1, field2, field3, field4, field5, field6, field7, field8, field9, field10};
		try {
			for(int i = 0 ; i < fields.length; i++) {
				if(fields[i].getText().equals("") || fields[i].getText().equals(null)) {
					continue;
				}else if(fields[i].getText().matches("[0-9]*")){
					values[i] = Integer.parseInt(fields[i].getText());
					//values.add(Integer.parseInt(fields[i].getText()));
				}
			}
		}catch(NumberFormatException e){
			e.printStackTrace();
			System.err.println("Error with blank or null string input");
		}
		return values;
	}
	
	public void clearTextFields() {
		fields = new TextField[] {field1, field2, field3, field4, field5, field6, field7, field8, field9, field10};
		for(TextField t : fields) {
			t.clear();
		}
		//clears array aswell
	}
	
	public void initRects() {
		rects = new Rectangle[] {rect1, rect2, rect3, rect4, rect5, rect6, rect7, rect8, rect9, rect10};
		for(Rectangle r : rects) {
			r.setHeight(0);
		}
	}
	
	public int[] bubbleSort(int[] numbers) {
		boolean isSorted = false;
		while(true){
			isSorted = true; // set isSorted == true for condition break
			for(int i = 0 ;  i < numbers.length - 1 ; i++) {
				int j = numbers[i];
				int k = numbers[i+1];
				if(j > k) {
					numbers[i] = k;
					numbers[i+1] = j;
					isSorted = false; // if we made a swap, then isSorted == false because array isnt sorted yet
				}
				// if we didn't make swap, the above if block is skipped
				// then below if block is executed b/c isSorted was marked true to begin with
			}
			if(isSorted == true) { 
				break;
			}
		}
		//ArrayList<Integer> sortedList = (ArrayList<Integer>) Arrays.stream(numbers).boxed().collect(Collectors.toList());
		//return sortedList;
		return numbers;
	}
	
	//public int[] quickSort(int[] numbers) {
		// get last element of array, it is the pivot
		// get current element, lowest index
		// if larger, leave there
		// then next element, if larger leave there
		// then next element, if smaller, move to the 
		
	//}
	

}
