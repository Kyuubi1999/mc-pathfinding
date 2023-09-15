package com.github.btror.mcpathfinding.simulation.pathfinding;

import com.github.btror.mcpathfinding.simulation.Simulation;
import com.github.btror.mcpathfinding.simulation.util.Node;

public class GreedyBestFirstSearch extends Simulation {

    public GreedyBestFirstSearch() {
    }

    public GreedyBestFirstSearch(int[][][] simulationSnapshot, int[] simulationStart, int[] simulationTarget) {
        super(simulationSnapshot, simulationStart, simulationTarget);
    }

    @Override
    public void start() {
        nodeCurrent = new Node(
                simulationStart[0],
                simulationStart[1],
                simulationStart[2],
                0
        );
        nodeTarget = new Node(
                simulationTarget[0],
                simulationTarget[1],
                simulationTarget[2],
                0
        );
        nodeSnapshot[simulationStart[0]][simulationStart[1]][simulationStart[2]] = nodeCurrent;
        nodeSnapshot[simulationTarget[0]][simulationTarget[1]][simulationTarget[2]] = nodeTarget;

        for (int i = 0; i < simulationSnapshot.length; i++) {
            for (int j = 0; j < simulationSnapshot[i].length; j++) {
                for (int k = 0; k < simulationSnapshot[i][j].length; k++) {
                    if (simulationSnapshot[i][j][k] == 0) {
                        Node node = new Node(i, j, k, 0);
                        nodeSnapshot[i][j][k] = node;
                    }
                    if (simulationSnapshot[i][j][k] == 1) {
                        Node node = new Node(i, j, k, 1);
                        nodeSnapshot[i][j][k] = node;
                    }
                }
            }
        }

        int g = calculateG(nodeCurrent);
        nodeCurrent.setG(g);

        int h = calculateH(nodeCurrent);
        nodeCurrent.setH(h);

        nodeCurrent.setBfsF();
        nodeStart = nodeCurrent;
        openList.add(nodeCurrent);
    }

    @Override
    public void calculateNeighborValues() {
        int row = nodeCurrent.getRow();
        int col = nodeCurrent.getCol();
        int zNum = nodeCurrent.getZ();

        if (zNum - 1 > -1 && nodeSnapshot[row][col][zNum - 1].getType() == 0
                && !closedList.contains(nodeSnapshot[row][col][zNum - 1])) {
            Node[][][] grid = nodeSnapshot;
            grid[row][col][zNum - 1].setParent(nodeCurrent);
            int g = calculateG(grid[row][col][zNum - 1]);
            grid[row][col][zNum - 1].setG(g);
            int h = calculateH(grid[row][col][zNum - 1]);
            grid[row][col][zNum - 1].setH(h);
            grid[row][col][zNum - 1].setBfsF();
            nodeSnapshot = grid;
            openList.add(grid[row][col][zNum - 1]);
            simulationSnapshot[row][col][zNum - 1] = 2;
        }

        if (col + 1 < nodeSnapshot.length && nodeSnapshot[row][col + 1][zNum].getType() == 0
                && !closedList.contains(nodeSnapshot[row][col + 1][zNum])) {
            Node[][][] grid = nodeSnapshot;
            grid[row][col + 1][zNum].setParent(nodeCurrent);
            int g = calculateG(grid[row][col + 1][zNum]);
            grid[row][col + 1][zNum].setG(g);
            int h = calculateH(grid[row][col + 1][zNum]);
            grid[row][col + 1][zNum].setH(h);
            grid[row][col + 1][zNum].setBfsF();
            nodeSnapshot = grid;
            openList.add(grid[row][col + 1][zNum]);
            simulationSnapshot[row][col + 1][zNum] = 2;
        }

        if (row - 1 > -1 && nodeSnapshot[row - 1][col][zNum].getType() == 0
                && !closedList.contains(nodeSnapshot[row - 1][col][zNum])) {
            Node[][][] grid = nodeSnapshot;
            grid[row - 1][col][zNum].setParent(nodeCurrent);
            int g = calculateG(grid[row - 1][col][zNum]);
            grid[row - 1][col][zNum].setG(g);
            int h = calculateH(grid[row - 1][col][zNum]);
            grid[row - 1][col][zNum].setH(h);
            grid[row - 1][col][zNum].setBfsF();
            nodeSnapshot = grid;
            openList.add(grid[row - 1][col][zNum]);
            simulationSnapshot[row - 1][col][zNum] = 2;
        }

        if (col - 1 > -1 && nodeSnapshot[row][col - 1][zNum].getType() == 0
                && !closedList.contains(nodeSnapshot[row][col - 1][zNum])) {
            Node[][][] grid = nodeSnapshot;
            grid[row][col - 1][zNum].setParent(nodeCurrent);
            int g = calculateG(grid[row][col - 1][zNum]);
            grid[row][col - 1][zNum].setG(g);
            int h = calculateH(grid[row][col - 1][zNum]);
            grid[row][col - 1][zNum].setH(h);
            grid[row][col - 1][zNum].setBfsF();
            nodeSnapshot = grid;
            openList.add(grid[row][col - 1][zNum]);
            simulationSnapshot[row][col - 1][zNum] = 2;
        }

        if (row + 1 < nodeSnapshot.length && nodeSnapshot[row + 1][col][zNum].getType() == 0
                && !closedList.contains(nodeSnapshot[row + 1][col][zNum])) {
            Node[][][] grid = nodeSnapshot;
            grid[row + 1][col][zNum].setParent(nodeCurrent);
            int g = calculateG(grid[row + 1][col][zNum]);
            grid[row + 1][col][zNum].setG(g);
            int h = calculateH(grid[row + 1][col][zNum]);
            grid[row + 1][col][zNum].setH(h);
            grid[row + 1][col][zNum].setBfsF();
            nodeSnapshot = grid;
            openList.add(grid[row + 1][col][zNum]);
            simulationSnapshot[row + 1][col][zNum] = 2;
        }

        if (zNum + 1 < nodeSnapshot.length && nodeSnapshot[row][col][zNum + 1].getType() == 0
                && !closedList.contains(nodeSnapshot[row][col][zNum + 1])) {
            Node[][][] grid = nodeSnapshot;
            grid[row][col][zNum + 1].setParent(nodeCurrent);
            int g = calculateG(grid[row][col][zNum + 1]);
            grid[row][col][zNum + 1].setG(g);
            int h = calculateH(grid[row][col][zNum + 1]);
            grid[row][col][zNum + 1].setH(h);
            grid[row][col][zNum + 1].setBfsF();
            nodeSnapshot = grid;
            openList.add(grid[row][col][zNum + 1]);
            simulationSnapshot[row][col][zNum + 1] = 2;
        }
    }
}
