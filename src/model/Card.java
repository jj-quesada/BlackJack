package model;

public enum Card {
    Ace, _2, _3, _4, _5, _6, _7, _8, _9, _10, Queen, King, Jack;
        
    public int value() {
        return isFace() ? 10 : ordinal() + 1;
    }

    public boolean isFace() {
        return this == King || this == Queen || this == Jack;
    }
}
