package com.rahulawasthi.main;

import com.rahulawasthi.services.*;
	
	import java.util.Scanner;
	import java.util.Stack;

	/**
	 * Algo Comment Start
	 * <p>
	 * Create DayWise FloorSize array
	 * Create desc Order FloorSizes Stack such that pop operation return max floor size value
	 * Create empty temp Stack
	 * <p>
	 * Loop through for each day
	 * fetch and compare the floor size of the day with the largest floor size which is not yet assembled
	 * if floorSizeOfTheDay != largestFloorSize
	 * Push floorSizeOfTheDay onto tempStack
	 * else
	 * print floorSize of the day
	 * loop through tempStack
	 * if tempStack.peek() == descFloorSizesStack.peek()
	 * pop from descFloorSizesStack and tempStack, as well as print the popped Item
	 * else
	 * break out of the loop.
	 * <p>
	 * Algo comment End
	 */
	public class SkyScraper  {

	    public static void main(String[] args) {
	        //Defining new Scanner
	        Scanner sc = new Scanner(System.in);

	        //Taking input for no of floors
	        System.out.println("Enter the total no of floors in the building");
	        int noOfFloors = sc.nextInt();

	        //Taking input for floor sizes day wise
	        int[] dayWiseFloorSizes = new int[noOfFloors];
	        for (int i = 0; i < noOfFloors; i++) {
	            System.out.println("Enter the floor size given on day: " + (i + 1));
	            dayWiseFloorSizes[i] = sc.nextInt();
	        }

	        //Make a copy of Day wise floorSizes and sort it into ascending order
	        int[] ascFloorSizesArr = dayWiseFloorSizes.clone();
	        var mergeSort = new MergeSort();
	        mergeSort.sortArray(ascFloorSizesArr);

	        //Store the ascending order floor sizes into stack so that pop will return the highest floor size
	        var descFloorSizesStack = new Stack<Integer>();
	        for (int i : ascFloorSizesArr) {
	            descFloorSizesStack.push(i);
	        }

	        /*Algo implementation Start*/
	        System.out.println("The order of construction is as follows");
	        var tempStack = new Stack<Integer>();

	        for (int i = 0; i < noOfFloors; i++) {
	            System.out.println("Day: " + (i + 1));
	            int floorSizeOfTheDay = dayWiseFloorSizes[i];

	            int largestFloorSize = descFloorSizesStack.peek();
	            if (floorSizeOfTheDay != largestFloorSize) {
	                tempStack.push(floorSizeOfTheDay);
	            } else {
	                System.out.print(descFloorSizesStack.pop() + " ");
	                while (!tempStack.isEmpty() && descFloorSizesStack.peek() == tempStack.peek()) {
	                    var poppedItem = descFloorSizesStack.pop();
	                    tempStack.pop();
	                    System.out.print(poppedItem + " ");
	                }
	            }
	            System.out.println("");
	        }
	        /*Algo implementation End*/

	        sc.close();
	    }
	}
