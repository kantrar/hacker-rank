import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GridlandMetro {
	private static class Track {
		Track parent;
		long startCol;
		long endCol;

		Track(long start, long end) {
			this.parent = this;
			this.startCol = start;
			this.endCol = end;
		}
	}

	static long gridlandMetro(long n, long m, int k, long[][] track) {
		Map<Long, List<Track>> map = new HashMap<>();

		long grids = n * m;

		for (int i = 0; i < track.length; i++) {
			long row = track[i][0];
			long startCol = track[i][1];
			long endCol = track[i][2];

			updateMap(map, row, startCol, endCol);
		}

		for (Long row : map.keySet()) {
			List<Track> trackList = map.get(row);
			for (Track currentTrack : trackList) {
				grids -= (currentTrack.endCol - currentTrack.startCol + 1);
			}
		}

		return grids;
	}

	private static void updateMap(Map<Long, List<Track>> map, long row, long startCol, long endCol) {
		List<Track> trackList = map.getOrDefault(row, new ArrayList<>());

		for (Track currentTrack : trackList) {
			if (startCol >= currentTrack.startCol && startCol <= currentTrack.endCol) {
				currentTrack.endCol = Math.max(endCol, currentTrack.endCol);
				return;
			} else if (endCol >= currentTrack.startCol && endCol <= currentTrack.endCol) {
				currentTrack.startCol = Math.min(startCol, currentTrack.startCol);
				return;
			} else if (currentTrack.startCol >= startCol && currentTrack.endCol <= endCol) {
				currentTrack.startCol = startCol;
				currentTrack.endCol = endCol;
				return;
			}
		}
		trackList.add(new Track(startCol, endCol));
		map.put(row, trackList);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		long n = scanner.nextLong();

		long m = scanner.nextLong();

		int k = scanner.nextInt();

		long[][] track = new long[k][3];

		for (int i = 0; i < k; i++) {
			for (int j = 0; j < 3; j++) {
				long trackItem = scanner.nextLong();
				track[i][j] = trackItem;
			}
		}

		long result = gridlandMetro(n, m, k, track);


		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
