package ru.job4j.chess.firuges.black;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.FigureNotFoundException;
import ru.job4j.chess.Logic;
import ru.job4j.chess.OccupiedCellException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

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

    @Test (expected = FigureNotFoundException.class)
    public void testMoveFigureNotFoundException( ) throws FigureNotFoundException, OccupiedCellException {
        Logic logic = new Logic();
        Cell source = Cell.A6;
        Cell sourceWrong = Cell.A5;
        Cell dest = Cell.B5;
        BishopBlack bishopBlack = new BishopBlack(source);
        logic.add(bishopBlack);
        logic.move(sourceWrong, dest);
    }

    @Test (expected = OccupiedCellException.class)
    public void testMoveOccupiedCellException() throws FigureNotFoundException, OccupiedCellException {
        Cell sourceOne = Cell.A6;
        Cell sourceTwo = Cell.B5;
        Cell dest = Cell.C4;
        BishopBlack bishopBlackOne = new BishopBlack(sourceOne);
        BishopBlack bishopBlackTwo = new BishopBlack(sourceTwo);
        Logic logic = new Logic();
        logic.add(bishopBlackOne);
        logic.add(bishopBlackTwo);
        logic.move(sourceOne, dest);
    }
}