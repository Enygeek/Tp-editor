package fr.istic.aco.editor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EngineTest {

    private Engine engine;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        engine = new EngineImpl();
    }


    @Test
    @DisplayName("Buffer must be empty after initialisation")
    void getSelection() {
        engine.insert("test");
        Selection selection = engine.getSelection();
        assertEquals(selection.getBufferBeginIndex(),selection.getBeginIndex());
        assertEquals("",engine.getBufferContents());
    }

    @Test
    void getBufferContents() {
        engine.insert("test");
        assertEquals("test",engine.getBufferContents());
    }

    @Test
    void getClipboardContents() {
        engine.insert("test");
        engine.getSelection().setBeginIndex(1);
        engine.getSelection().setEndIndex(3);
        engine.copySelectedText();
        assertEquals("es",engine.getClipboardContents());
    }

    @Test
    void cutSelectedText() {
        engine.insert("test");
        engine.getSelection().setBeginIndex(1);
        engine.getSelection().setEndIndex(3);
        engine.cutSelectedText();
        assertEquals("es", engine.getClipboardContents());
        assertEquals("tt",engine.getBufferContents());
        assertEquals(1, engine.getSelection().getBeginIndex());
        assertEquals(1, engine.getSelection().getEndIndex());
    }

    @Test
    void copySelectedText() {
        engine.insert("test");
        engine.getSelection().setEndIndex(3);
        engine.getSelection().setBeginIndex(1);
        engine.copySelectedText();
        assertEquals("es",engine.getClipboardContents());
    }

    @Test
    void pasteClipboard() {
        engine.insert("test");
        engine.getSelection().setEndIndex(3);
        engine.getSelection().setBeginIndex(1);
        engine.copySelectedText();
        engine.getSelection().setEndIndex(0);
        engine.getSelection().setBeginIndex(0);
        engine.pasteClipboard();
        assertEquals("estest",engine.getBufferContents());
    }

    @Test
    void insert() {
        engine.insert("test");
        engine.getSelection().setEndIndex(3);
        engine.getSelection().setBeginIndex(1);
        engine.insert("abc");
        assertEquals("tabct",engine.getBufferContents());
        assertEquals(4, engine.getSelection().getEndIndex());
        assertEquals(4, engine.getSelection().getBeginIndex());
    }

    @Test
    void delete() {
        engine.insert("test");
        engine.getSelection().setEndIndex(3);
        engine.getSelection().setBeginIndex(1);
        engine.delete();
        assertEquals("tt", engine.getBufferContents());
        assertEquals(1, engine.getSelection().getEndIndex());
        assertEquals(1, engine.getSelection().getBeginIndex());

    }
}
