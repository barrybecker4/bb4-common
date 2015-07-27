package com.barrybecker4.common.search.slidingpuzzle;

import com.barrybecker4.common.search.AbstractSearchSpace;
import com.barrybecker4.common.search.SearchSpace;

import java.util.List;
import java.util.Set;

/**
 * @author Barry Becker
 */
public class PuzzleSearchSpace extends AbstractSearchSpace<Board, Transition> {

    PuzzleSearchSpace(Board initialState) {
        super(initialState);
    }

    @Override
    public boolean isGoal(Board state) {
        return state.hamming() == 0;
    }

    @Override
    public List<Transition> legalTransitions(Board state) {
        return state.getNeighborTransitions();
    }

    @Override
    public Board transition(Board state, Transition transition) {
        return state.applyTransition(transition);
    }

    @Override
    public int distanceFromGoal(Board state) {
        return state.manhattan();
    }

    @Override
    public int getCost(Transition transition) {
        return 1;
    }

}
