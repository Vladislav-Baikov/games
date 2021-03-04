package ru.job4j.chess.firuges.black;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;

public class BishopBlackPositionTest {

    @Test
    public void testPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C3);
        Assert.assertThat(bishopBlack.position(), is(Cell.C3));
    }

    @Test
    public void testCopy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C3);
        Assert.assertThat(bishopBlack.copy(Cell.F6).position(), is(Cell.F6));
    }

    @Test
    public void testWay() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] result = bishopBlack.way(Cell.G5);
        Assert.assertThat(Arrays.toString(result), is("[D2, E3, F4, G5]"));
    }
}