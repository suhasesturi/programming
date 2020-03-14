package interviewbit.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class HotelBookingsPossible {
	public static void main(String[] args) {
		System.out.println(new HotelBookingsPossible().hotel(
				new ArrayList<>(Arrays.asList(1, 2, 3, 4)),
				new ArrayList<>(Arrays.asList(10, 2, 6, 14)),
				2
		));
	}

	public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int k) {
		Collections.sort(arrive);
		Collections.sort(depart);
		int count = 0;
		for (int i = 0, j = 0; i < arrive.size() && j < depart.size(); ) {
			if (arrive.get(i) < depart.get(j)) {
				count++;
				i++;
			} else {
				count--;
				j++;
			}
			if (count > k) return false;
		}
		return true;
	}
}
