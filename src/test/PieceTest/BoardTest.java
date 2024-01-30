package test.PieceTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import game.board.Board;
import game.constant.Constant;
import game.piece.Pawn;
import game.position.Position;

public class BoardTest {

    Board b;

    @Before
    public void setUp() {
        b = new Board();
    }
    
    @Test
    public void boardConstructorTest() {

        assertEquals(b.getBoard().size(), Constant.ROW);
        assertEquals(b.getBoard().get(Constant.ROW - 1).size(), Constant.COL);

        for (int i = 0; i < Constant.ROW; i++) {
            for (int j = 0; j < Constant.COL; j++) {
                assertNull(b.getPiece(new Position(i, j)));
            }
        }

        assertEquals(b.getMoves().size(), 0);
    }

    @Test
    public void setPiecePlacementTest() {

        Position pos1 = new Position("h8");
        Pawn p1 = new Pawn(true, pos1, b);
        b.setPiece(p1);
        
        assertEquals(pos1.getCol(), 7);
        assertEquals(pos1.getRow(), 7);
        assertEquals(new Position("h8"), p1.getPos());
        assertEquals("...............................................................P", b.exportBoardToString());

        Position pos2 = new Position("a1");
        Pawn p2 = new Pawn(true, pos2, b);
        b.setPiece(p2);
        
        assertEquals(pos2.getCol(), 0);
        assertEquals(pos2.getRow(), 0);
        assertEquals(p2, b.getBoard().get(0).get(0));

        Position pos3 = new Position("d4");
        Pawn p3 = new Pawn(false, pos3, b);
        b.setPiece(p3);

        assertEquals(pos3.getCol(), 3);
        assertEquals(pos3.getRow(), 3);
        assertEquals(p3, b.getBoard().get(3).get(3));

        Position pos4 = new Position("b1");
        Pawn p4 = new Pawn(false, pos4, b);
        b.setPiece(p4);

        assertEquals(pos4.getCol(), 1);
        assertEquals(pos4.getRow(), 0);
        assertEquals(p4, b.getBoard().get(0).get(1));

        Position pos5 = new Position("f4");
        Pawn p5 = new Pawn(true, pos5, b);
        b.setPiece(p5);

        assertEquals(pos5.getCol(), 5);
        assertEquals(pos5.getRow(), 3);
        assertEquals(p5, b.getBoard().get(3).get(5));
    }

    @Test
    public void getPieceFromBoardTest() {

        Position pos1 = new Position("d4");
        Pawn p1 = new Pawn(true, pos1, b);
        b.setPiece(p1);

        assertEquals(p1, b.getPiece(pos1));

        Position pos2 = new Position("e2");
        Pawn p2 = new Pawn(true, pos2, b);
        b.setPiece(p2);

        assertEquals(p2, b.getPiece(pos2));

        Position pos3 = new Position("a7");
        Pawn p3 = new Pawn(true, pos3, b);
        b.setPiece(p3);

        assertEquals(p3, b.getPiece(pos3));
    }
}
