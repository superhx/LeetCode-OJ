public class Candy {
	public int candy(int[] ratings) {
		int i = 0; // start of the sequence
		int count = 1; // total number of candy needed
		int n = ratings.length; // number of childen
		int lastCandy = 1; // number of Candy the last child of previous
							// sequence hold
		while (i < n - 1) {
			int j = i + 1; // j is the next node of end of this sequence
			int tmp = 0;
			if (ratings[j] > ratings[i]) {// find the whole upside sequence,
											// it's from i to j - 1,
				while (j < n && ratings[j] > ratings[j - 1])
					j++;
				tmp = j - i - 1; // total number in up sequence, count them from
									// 2 to (count +1) because the first one is
									// already included in previous sequence
				count += (tmp * (tmp + 3) / 2); // add them up
				lastCandy = tmp + lastCandy;
				i = j - 1;
			} else if (ratings[j] < ratings[i]) {// find the downside sequence,
													// it's from i to j - 1;
				while (j < n && ratings[j] < ratings[j - 1])
					j++;
				// total number in down sequence, count them from (count - 1) to
				// 1,
				tmp = j - i - 1;
				count += (tmp * (tmp + 1) / 2);
				// if the last child in previous sequence has less candy than
				// he/she should have, add it up by the down sequence number
				if (tmp >= lastCandy)
					count += (tmp + 1 - lastCandy);
				lastCandy = 1;
				i = j - 1;
			} else {// same rating as previous one, start with only 1 candy
				count++;
				lastCandy = 1;
				i = j;
			}
		}
		return count;
	}
}