package lesson5.part_05.frame_05.bf.tanks;

import lesson5.part_05.frame_05.bf.*;

import java.util.ArrayList;
import java.util.List;

public class AggressorLogic {

    //private List<String> novigator = ArrayList(9*9);
    //peredaem v igru
    private BattleField bf;

    private int xs;
    private int ys;

    private int xe;
    private int ye;

    int iters = 0;
    int itere = 9 * 9;

    public AggressorLogic(int xs, int ys, BattleField bf) {
        this.xs = xs;
        this.ys = ys;
        xe = 4;
        ye = 8;
        this.bf = bf;
    }

    public int scanCenterLineH(){
        int rez = 0;
        for(int i = 1; i < 8; i++){
           if(bf.scanQuadrant(i,4) instanceof Brick){
                rez = 1;
           }else if(bf.scanQuadrant(i, 4) instanceof Rock){
               rez = -1;
           }
        }
        return rez;
    }

}
