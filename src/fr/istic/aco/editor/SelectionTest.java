package fr.istic.aco.editor;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SelectionTest {

    private Selection selection;
    private StringBuilder buffer;

    @org.junit.jupiter.api.BeforeEach
    void setUp(){
        buffer= new StringBuilder();
        selection= new SelectionImpl(buffer);
    }

    private void todo() {
        fail("Unimplemented test");
    }

    @Test
    void getBeginIndex() {
        todo();
    }

    @Test
    void getEndIndex() {
        todo();
    }

    @Test
    void getBufferBeginIndex() {
        todo();
    }

    @Test
    void getBufferEndIndex() {
        todo();
    }

    @Test
    void setBeginIndex() {
        todo();
    }

    @Test
    void setEndIndex() {
        todo();
    }
}