package chord_jars_tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import chord_jars.Note;
import chord_jars.Notes;

class NotesTest {

	Notes notes = new Notes();

	@Test
	void testGetNoteUpWithinBounds() {
		Note result = notes.getNote(new Note("C"), 2, true);
		assertEquals(new Note("D"), result, "C up by 2 should be D");
	}

	@Test
	void testGetNoteDownWithinBounds() {
		Note result = notes.getNote(new Note("C"), 2, false);
		assertEquals(new Note("A#"), result, "C down by 2 should be A#");
	}

	@Test
	void testGetNoteUpWithRollover() {
		Note result = notes.getNote(new Note("G"), 3, true);
		assertEquals(new Note("A#"), result, "G up by 3 should roll over to A#");
	}

	@Test
	void testGetNoteDownWithRollover() {
		Note result = notes.getNote(new Note("C"), 4, false);
		assertEquals(new Note("G#"), result, "C down by 4 should roll over to G#");
	}

	@Test
	void testGetNoteWithLargeUpInterval() {
		Note result = notes.getNote(new Note("A"), 12, true);
		assertEquals(new Note("A"), result, "A up by 12 should return A (full octave)");
	}

	@Test
	void testGetNoteWithLargeDownInterval() {
		Note result = notes.getNote(new Note("A"), 12, false);
		assertEquals(new Note("A"), result, "A down by 12 should return A (full octave)");
	}

}
