package edu.miracosta.cs210.roulettesimulator;

import java.util.ArrayList;
import java.util.List;

public class NumberSet {

    private List<Number> numberSet = new ArrayList<Number>();

    public NumberSet() {
        // number, color, wheelAngle.
        numberSet.add(new Number(0, "G", 180));
        numberSet.add(new Number(1, "R", 44));
        numberSet.add(new Number(2, "B", 238));
        numberSet.add(new Number(3, "R", 160));
        numberSet.add(new Number(4, "B", 219));
        numberSet.add(new Number(5, "R", 5));
        numberSet.add(new Number(6, "B", 277));
        numberSet.add(new Number(7, "R", 122));
        numberSet.add(new Number(8, "B", 336));
        numberSet.add(new Number(9, "R", 83));
        numberSet.add(new Number(10, "B", 355));
        numberSet.add(new Number(11, "B", 316));
        numberSet.add(new Number(12, "R", 141));
        numberSet.add(new Number(13, "B", 297));
        numberSet.add(new Number(14, "R", 63));
        numberSet.add(new Number(15, "B", 199));
        numberSet.add(new Number(16, "R", 24));
        numberSet.add(new Number(17, "B", 258));
        numberSet.add(new Number(18, "R", 102));
        numberSet.add(new Number(19, "R", 209));
        numberSet.add(new Number(20, "B", 54));
        numberSet.add(new Number(21, "R", 229));
        numberSet.add(new Number(22, "B", 92));
        numberSet.add(new Number(23, "R", 345));
        numberSet.add(new Number(24, "B", 15));
        numberSet.add(new Number(25, "R", 248));
        numberSet.add(new Number(26, "B", 170));
        numberSet.add(new Number(27, "R", 287));
        numberSet.add(new Number(28, "B", 131));
        numberSet.add(new Number(29, "B", 112));
        numberSet.add(new Number(30, "R", 326));
        numberSet.add(new Number(31, "B", 73));
        numberSet.add(new Number(32, "R", 190));
        numberSet.add(new Number(33, "B", 34));
        numberSet.add(new Number(34, "R", 268));
        numberSet.add(new Number(35, "B", 151));
        numberSet.add(new Number(36, "R", 306));
    }

    public List<Number> getNumberSet() {
        return numberSet;
    }
}
