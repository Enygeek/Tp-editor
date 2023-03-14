package fr.istic.aco.editor;

public class SelectionImpl implements Selection {

    StringBuilder buffer; 
    int BeginIndex=0;
    int EndIndex=0;
    int BufferBeginIndex=0;
    int BufferEndIndex;

    SelectionImpl(StringBuilder buffer){
        this.buffer=buffer;
    }

    @Override
    public int getBeginIndex() {
        //retourne l'index de debut de la selection
        return BeginIndex;
    }

    @Override
    public int getEndIndex() {
        //retourne l'index de fin de la selection
        return EndIndex;
    }

    @Override
    public int getBufferBeginIndex() {
        //retourne l'index de debut du buffer
        return BufferBeginIndex;
    }

    @Override
    public int getBufferEndIndex() {
        //retourne l'index de fin du buffer
        return buffer.length();
    }

    @Override
    public void setBeginIndex(int beginIndex){
        //Changes the value of the begin index of the selection
        if (getBufferBeginIndex()<=beginIndex){
            this.BeginIndex=beginIndex;
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void setEndIndex(int endIndex) {
        //Changes the value of the end index of the selection
        if (getBufferEndIndex()>=endIndex){
            this.EndIndex=endIndex;
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }

}
