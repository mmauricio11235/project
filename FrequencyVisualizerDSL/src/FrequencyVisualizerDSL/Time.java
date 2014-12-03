package FrequencyVisualizerDSL;

import java.util.ArrayList;

import objectdraw.*;

public class Time implements Runnable {

	private int startTime, endTime;
	private ArrayList<Frequency> frequencyList = new ArrayList<Frequency>();
	private int numFrequencies = 0;
	private int maxFrequencies = 10;
	private double runTimeInSeconds;

	public Time(int start, int end) {
		startTime = start;
		endTime = end;
	}

	public int getStartTime() {
		return startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setStartTime(int newStartTime) {
		startTime = newStartTime;
	}

	public void setRunTimeInSeconds(double runTimeInSeconds2) {
		runTimeInSeconds = runTimeInSeconds2;
	}

	public void setEndTime(int newEndTime) {
		endTime = newEndTime;
	}

	public int getNumFrequencies() {
		return numFrequencies;
	}

	public int getMaxFrequencies() {
		return maxFrequencies;
	}

	public void addFrequency(Frequency newFrequency) {
		frequencyList.add(newFrequency);
		numFrequencies++;
	}

	public void run() {
		System.out.print("number of frequencies: " + frequencyList.size());
		try {
			Thread.sleep((long) (runTimeInSeconds * 1000 * startTime / 100));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long timeStart = System.currentTimeMillis();
		for (Frequency x : frequencyList) {
			ArrayList<Image> currentImages = x.getImageList();
			for (Image y : currentImages) {
				new Thread(y).start();
				System.out.print("Got to the images");

			}
		}

	}

}
