package com.bridgelabz.logicalprograms.utils;

import java.util.Random;

import org.apache.log4j.Logger;

import com.bridgelabz.errors.UnspecifiedOptionSelectedError;
import com.bridgelabz.exceptions.InvalidIntegerException;
import com.bridgelabz.exceptions.NumberNotInRequiredFormatOrSizeException;

public class Utility {

	public Utility() {

	}

	static Logger logger = Logger.getLogger("Utility.class");
	/**
	 * Calculate the number of times of gamble and returns the number of wins, wins percentage, loss percentage
	 * @param stake
	 * @param goal
	 * @return
	 */
	public static double[] gambler(int stake, int goal) {
		int wins = 0;
		int loss = 0;
		double[] winsAndLosses = new double[3];
		// create the variable to take the input from user
		int choice = 0;
		do {
			while (stake < 1) {
				logger.info("Hey you can't start empty handed!");
				logger.info("Please enter an amount greater than 0");
				stake = InputUtility.intVal();
			}
			if (goal == stake) {
				logger.info("You already reached your Goal.");
				return winsAndLosses;
			}
			while (goal < stake) {
				logger.info("Dear to be millionare, your here to win! So enter an amount greater than your stake!");
				goal = InputUtility.intVal();
			}
			float totalGambles = 0;
			int gamble = 0;
			Random random = new Random();
			do {
				gamble = random.nextInt(2);
				logger.info("gambles is" + gamble);
				totalGambles++;
				if (gamble == 0) {
					stake++;
					logger.info("Yay you won! You now have " + stake + ". Your goal:" + goal);
					wins++;
				} else {
					stake--;
					logger.info("Bad luck!You lost! You now have " + stake + ". Your goal:" + goal);
					loss++;
				}
			} while (!(stake == 0 || stake == goal));
			winsAndLosses[0] = wins;
			float winp = (wins / totalGambles) * 100;
			winsAndLosses[1] = winp;
			float lossp = (loss / totalGambles) * 100;
			winsAndLosses[2] = lossp;
			logger.info("press 1 for continue");
			choice = InputUtility.intVal();
		} while (choice == 1);
		return winsAndLosses;
	} 
	//Distinct Coupon Number
	/**
	 * 
	 * @param n
	 * @return
	 */
	public static int getCoupon(int n) {
		return (int) (Math.random()*n);
	}
	public static int compare(int[] array,int random) {
		int val=0;
		int var=0;
		for(int i=0;i<array.length;i++) {
			var = array[i];
			if(var != random) {
				val=1;
				break;
			}
		}
		return val;
	}
	public static int distinctCouponNumbers(int randomNumberByUser) {
		int index = 0;
		int count=0;
		int val;
		int randomValue;
		int distinct = 0;
		int[] distinctArray= new int [randomNumberByUser];
		while(distinct < randomNumberByUser ) {
			if(index >= randomNumberByUser) {
				break;
			}
			randomValue = getCoupon(randomNumberByUser);
			count++;
			val=compare(distinctArray, randomValue);
			if(val == 1) {
				distinctArray[index] = randomValue;
				distinct++;
				index++;
			}
		}
		return count;
		}
	// Stop Watch logic
	/**
	 * Stop watch accepts the start and stop values and returns time elapsed between them
	 * @param startTimer
	 * @param stopTimer
	 * @return
	 * @throws NumberNotInRequiredFormatOrSizeException
	 */

		public static double getElapsedTime(String stop) throws NumberNotInRequiredFormatOrSizeException {
				   
		    	final long start = System.currentTimeMillis();
		    	logger.info("start time "+ start);
		    	logger.info("enter the stop to stop the timer");
		    	long end=0;
		    	while(!stop.equals("stop")) {
		    	end = System.currentTimeMillis();
		    	logger.info("end time is "+ end );

		    	logger.info("Took: " + ((end - start) / 1000000.0) + "ms");
		    	logger.info("Took: " + (end - start)/ 1000000000.0 + " seconds");
		    	}
		    	return end;
		}
		
		public static double stopWatch(int endTime) throws InvalidIntegerException {
		 	if(endTime <=0 ) {
		 		throw new InvalidIntegerException("end Time cant go reverse(negative) or be zero");
		 	}else {
	        // sum of square roots of integers from 1 to n using Math.sqrt(x).
	        Stopwatch timer1 = new Stopwatch(endTime);
	        
	        double time1 = timer1.elapsedTime();
	        return time1;
		 	}
		}
		
	// Tic-Tac-Toe
	
		static int player = 0;
		static int[][] BOARD = new int[3][3];
		static boolean isEmpty = true;
		/**
		 * This piece of code is used give the introduction to the user about the game
		 */
		static void initBoard() {
			logger.info("TIC TAC TOE GAME\nComputer is o\nPlayer  is x ");
			for (int i = 0; i < BOARD.length; i++) {
				for (int j = 0; j < BOARD[i].length; j++) {
					BOARD[i][j] = -10;
				}
			}
			logger.info("Board is this :");
			dispBoard();
		}
		/**
		 * This code is used to display the board
		 */
		static void dispBoard() {
			int count = 0;
			for (int i = 0; i < BOARD.length; i++) {
				System.out.println("---------------");
				System.out.print("||");
				for (int j = 0; j < BOARD[i].length; j++) {
					if (BOARD[i][j] == 0) {
						count++;
						System.out.print(" o |");
					} else if (BOARD[i][j] == 1) {
						count++;
						System.out.print(" x |");
					} else
						System.out.print("   |");
				}
				System.out.println("|");
			}
			if (count == 9) {
				isEmpty = false;
			}
			System.out.println("---------------");
		}
		/**
		 * this piece of code is used to put the values in the appropriate positions chosen by computer and user
		 */
		static void putVal() {
			int i;
			int j;
			if (player % 2 == 1) {
				i = (int) (Math.random() * 10) % 3;
				j = (int) (Math.random() * 10) % 3;
				
				if(i<0 || i>2 || j < 0 || j>2) {
					throw new UnspecifiedOptionSelectedError("Selected i and j which are not present in the board");
				}
			} else {
				logger.info("enter value of i and j values");
				i = InputUtility.intVal();
				j = InputUtility.intVal();
				
				if(i<0 || i>2 || j < 0 || j>2) {
					throw new UnspecifiedOptionSelectedError("Selected i and j which are not present in the board");
				}
			}
			if (BOARD[i][j] == -10) {
				if (player % 2 == 0) {
					BOARD[i][j] = 0;
				} else {
					BOARD[i][j] = 1;
					logger.info("Coumputer Choosing " + i + " " + j);
				}
			} else
				putVal();

		}
		/**
		 *this piece of code is used to determine the winner
		 * @return
		 */
		static boolean win() {
			return ((BOARD[0][0] + BOARD[0][1] + BOARD[0][2] == player * 3)
					|| (BOARD[1][0] + BOARD[1][1] + BOARD[1][2] == player * 3)
					|| (BOARD[2][0] + BOARD[2][1] + BOARD[2][2] == player * 3)
					|| (BOARD[0][0] + BOARD[1][0] + BOARD[2][0] == player * 3)
					|| (BOARD[0][1] + BOARD[1][1] + BOARD[2][1] == player * 3)
					|| (BOARD[0][2] + BOARD[1][2] + BOARD[2][2] == player * 3)
					|| (BOARD[0][0] + BOARD[1][1] + BOARD[2][2] == player * 3)
					|| (BOARD[2][0] + BOARD[1][1] + BOARD[0][2] == player * 3));
		}
		/**
		 * This piece of code is used to decided whose turn is to play the game whether player or computer
		 */
		public static String playTicTacToe() {
			String decision = "";
			initBoard();
			while (isEmpty) {
				logger.info("Players turn");
				putVal();
				dispBoard();
				if (win()) {
					logger.info("Player won");
					decision= "player won";
					return decision;
				}
				player = 1;
				logger.info("Computers turn");
				putVal();
				dispBoard();
				if (win()) {
					logger.info("Computer won");
					decision= "Computer won";
					return decision;
				}
				player = 0;
			}
			return "";
		} 
	}
	
