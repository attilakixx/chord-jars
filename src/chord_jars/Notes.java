package chord_jars;

public class Notes {

	private static final Note A = new Note("A");
	private static final Note A_SHARP = new Note("A#");
	private static final Note B = new Note("B");
	private static final Note C = new Note("C");
	private static final Note C_SHARP = new Note("C#");
	private static final Note D = new Note("D");
	private static final Note D_SHARP = new Note("D#");
	private static final Note E = new Note("E");
	private static final Note F = new Note("F");
	private static final Note F_SHARP = new Note("F#");
	private static final Note G = new Note("G");
	private static final Note G_SHARP = new Note("G#");

	public static Note[] NOTES = {A, A_SHARP, B, C, C_SHARP, D, D_SHARP, E, F, F_SHARP, G, G_SHARP};

	public Note getNote(final Note from, final int interval, final boolean up) {
		int noteIndex = findIndex(from);

		int newIndex = calculateNewIndex(noteIndex, interval, up);

		return NOTES[newIndex];

	}

	private int calculateNewIndex(int noteIndex, int interval, boolean up) {
		int newIndex;
		int notesCount = NOTES.length;

		try {
			if (up) {
				newIndex = (noteIndex + interval) % notesCount;
			} else {
				newIndex = (noteIndex - interval) % notesCount;
				if (newIndex < 0) {
					newIndex += notesCount; // Handle negative modulus results
				}
			}
			return newIndex;
		} catch (Exception e) {
			throw new IllegalArgumentException("Invalid interval or note calculation", e);
		}
	}

	private int findIndex(Note from) {
		for (int i = 0; i < NOTES.length; i++) {
			if (from.equals(NOTES[i])) {
				return i;
			}
		}
		return -1;
	}
}
