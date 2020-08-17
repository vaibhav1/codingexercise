/**
 *
 */
package com.vaibhav1.codingexercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author vshukla
 *
 * Problem Statement: You have rating (0-10) of the hotels per user in this format:

	scores = [
				{'hotel_id': 1001, 'user_id': 501, 'score': 7},
				{'hotel_id': 1001, 'user_id': 502, 'score': 7},
				{'hotel_id': 1001, 'user_id': 503, 'score': 7},
				{'hotel_id': 2001, 'user_id': 504, 'score': 10},
				{'hotel_id': 3001, 'user_id': 505, 'score': 5},
				{'hotel_id': 2001, 'user_id': 506, 'score': 5}
			]

	Any given hotel might have more than one score.

	Implement a function, get_hotels(scores, min_avg_score) that returns a list of hotel ids
	that have average score equal to or higher than min_avg_score.

	get_hotels(scores, 5) -> [1001, 2001, 3001]
	get_hotels(scores, 7) -> [1001, 2001]

*/


public class HotelsWithAvgScore {


	/**
	 * The idea is simple. We will traverse the Score list and create a Map of hotel_ids & their scores.
	 * We'll then iterate over the map and calculate the average score per hotel
	 * and if avg score is greater than or equal to min_avg_score, add it to the result list
	 *
	 * @param scores - list of Scores
	 * @param min_avg_score - min_avg_score
	 * @return hotel_ids with score greater than min_avg_score
	 */
	public static List<Integer> get_hotels(List<Score> scores, int min_avg_score){
		List<Integer> hotels = new ArrayList<Integer>();

		Map<Integer, List<Integer>> hotel_scores = new HashMap<Integer, List<Integer>>();


		//populate map with all the scores for each hotel
		for(Score score: scores){
			int hotel_id = score.getHotel_id();
			List<Integer> allScores = null;

			if(hotel_scores.get(hotel_id) != null){
				allScores = hotel_scores.get(hotel_id);
			} else {
				allScores = new ArrayList<Integer>();
			}
			allScores.add(score.getScore());
			hotel_scores.put(hotel_id, allScores);
		}

		//iterate the map
		for(Entry<Integer, List<Integer>> entry: hotel_scores.entrySet()){

			int avg = getAverage(entry.getValue());
			if(avg>=min_avg_score){
				hotels.add(entry.getKey());
			}
		}

		return hotels;
	}

	/**
	 * Method to calculate average score from the list of score
	 * @param scores - List of scores
	 * @return average
	 */
	private static int getAverage(List<Integer> scores) {
		int sum=0;
		for(int score: scores){
			sum+=score;
		}
		return sum/scores.size();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Score> scores = new ArrayList<Score>();

		Score score = new Score();
		score.setHotel_id(1001);
		score.setUser_id(501);
		score.setScore(7);
		scores.add(score);

		score = new Score();
		score.setHotel_id(1001);
		score.setUser_id(502);
		score.setScore(10);
		scores.add(score);

		score = new Score();
		score.setHotel_id(2001);
		score.setUser_id(501);
		score.setScore(5);
		scores.add(score);


		score = new Score();
		score.setHotel_id(3001);
		score.setUser_id(502);
		score.setScore(5);
		scores.add(score);


		score = new Score();
		score.setHotel_id(1001);
		score.setUser_id(503);
		score.setScore(5);
		scores.add(score);

		score = new Score();
		score.setHotel_id(2001);
		score.setUser_id(503);
		score.setScore(7);
		scores.add(score);

		List<Integer> hotels = get_hotels(scores, 6);

		System.out.println("Total no. of hotels with avg_score greater than or equal to min avg score-"+6+" are: \n"+hotels.size());
	}

}


/**
 * Score class which is represented as JSON in the problem statement.
 * @author vshukla
 *
 */
class Score{
	int hotel_id;
	int user_id;
	int score;

	public Score(){

	}

	/**
	 * @return the hotel_id
	 */
	public int getHotel_id() {
		return hotel_id;
	}

	/**
	 * @param hotel_id the hotel_id to set
	 */
	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}

	/**
	 * @return the user_id
	 */
	public int getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}


}
