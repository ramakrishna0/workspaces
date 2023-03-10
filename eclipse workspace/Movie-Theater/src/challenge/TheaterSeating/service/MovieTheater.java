package challenge.TheaterSeating.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class MovieTheater {
	int rows = 10;
	int columns = 20;
	int numberOfSeats = rows * columns;
	LinkedHashMap<String, ArrayList<String>> hm = new LinkedHashMap<>();
	String[][] seats = new String[10][20];
	int remainingSeats[] = { 20, 20, 20, 20, 20, 20, 20, 20, 20, 20 };

	public int bookSeat(String reservation) {
		String[] input = reservation.split(" ");
		String rno = input[0];
		int count = Integer.parseInt(input[1]);
		int group = count;
		if(count > 0){
		if (numberOfSeats >= count) {
			if (group > 20) {
				while (group > 20) {
					allocate(rno, 20);
					group -= 20;
				}
				allocate(rno, group);
			} else 
				allocate(rno, group);
			
			return 0;
			
		} else
			return -1;
		} else
			return 1;
	}

	private int allocate(String rno, int seatsToBook) {
		int counter = 1;
		boolean check = true;
		int r = (rows / 2) - 1;
		while (r >= 0 && r < rows && seatsToBook > 0) {
			if (remainingSeats[r] >= seatsToBook) {
				for (int c = 0; c < 20 && seatsToBook > 0; c++) {
					if (seats[r][c] == null) {
						seats[r][c] = rno;
						if (hm.containsKey(rno)) {
							hm.get(rno).add(
									(char) (r + 65) + Integer.toString(c + 1));
						} else {
							ArrayList<String> list = new ArrayList<>();
							list.add((char) (r + 65) + Integer.toString(c + 1));
							hm.put(rno, list);
						}
						remainingSeats[r]--;
						numberOfSeats--;
						seatsToBook--;
					}
				}
			}
			if (check) {
				r = r + counter;
				counter++;
				check = false;
			} else {
				r = r - counter;
				counter++;
				check = true;
			}

		}
		counter = 1;
		check = true;
		r = (rows / 2) - 1;
		while (r >= 0 && r < rows && seatsToBook > 0) {
			if (remainingSeats[r] >= seatsToBook) {
				for (int c = 0; c < 20 && seatsToBook > 0; c++) {
					if (seats[r][c] == null) {
						seats[r][c] = rno;
						if (hm.containsKey(rno)) {
							hm.get(rno).add(
									(char) (r + 65) + Integer.toString(c + 1));
						} else {
							ArrayList<String> list = new ArrayList<>();
							list.add((char) (r + 65) + Integer.toString(c + 1));
							hm.put(rno, list);
						}
						remainingSeats[r]--;
						numberOfSeats--;
						seatsToBook--;
					}
				}
			}
			if (check) {
				r = r + counter;
				counter++;
				check = false;
			} else {
				r = r - counter;
				counter++;
				check = true;
			}

		}
		if (seatsToBook == 0) {
			return 0;
		} else {
			// find and allocate in the remaining seat
			counter = 1;
			check = true;
			int i = (rows / 2) - 1;
			while (i >= 0 && i < rows && seatsToBook > 0) {
				if (remainingSeats[i] > 0) {
					for (int j = 19; j>=0 && seatsToBook > 0; j--) {
						if (seats[i][j] == null) {
							seats[i][j] = rno;
							if (hm.containsKey(rno)) {
								hm.get(rno).add(
										(char) (i + 65) + Integer.toString(j + 1));
							} else {
								ArrayList<String> list = new ArrayList<>();
								list.add((char) (i + 65) + Integer.toString(j + 1));
								hm.put(rno, list);
							}
							seatsToBook--;
							numberOfSeats--;
							remainingSeats[i]--;
						}
					}
				}
				if (check) {
					i = i + counter;
					counter++;
					check = false;
				} else {
					i = i - counter;
					counter++;
					check = true;
				}
			}
			return 0;
		}
	}

	public ArrayList<String> getList(int row, int columnStart, int columnEnd) {
		ArrayList<String> list = new ArrayList<>();
		for (int c = columnStart; c <= columnEnd; c++) {
			list.add(seats[row][c]);
		}
		return list;
	}

	public LinkedHashMap<String, ArrayList<String>> getResults() {
		return hm;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void printLayout() {
		System.out.println(numberOfSeats);
		System.out.println("********************* RESERVATIONS **********************");
		for (int r = 0; r < 10; r++) {
			System.out.print((char) (r + 65) + " ");
			for (int c = 0; c < 20; c++) {
				System.out.print(" " + seats[r][c]);
			}
			System.out.println();
		}
	}
}
