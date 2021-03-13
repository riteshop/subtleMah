import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FineTunedSearch {
	public static void main() {
		Scanner feed = new Scanner(System.in);
		int numPreferences = feed.nextInt();

		float weights[] = new float[numPreferences];

		for (int i = 0; i < numPreferences; i++) {
			weights[i] = feed.nextFloat();
		}

		HashMap<Integer, ArrayList<Float>> data = new HashMap<Integer, ArrayList<Float>>();
		ArrayList<float> scores = new ArrayList<float>();

		while (feed.hasNext()) {
			ArrayList<Float> entry = new ArrayList<Float>();
			float score = 0.0f;

			for (int i = 0; i < numPreferences; i++) {
				Float attr = feed.nextFloat();

				score += attr * weights[i];
				entry.add(attr);
			}

			scores.add(score);
		}

		int num = scores.length();

		for (int i = 0; i < num - 1; i++) {
			for(int j = i; j < num - 1; j++) {
				if (scores.get(j) < scores.get(j + 1)) {
					float temp = scores.get(j);
					scores.set(j, scores.get(j + 1));
					scores.set(j + 1, temp);
				}
			}
		}

		feed.close();
	}
}
