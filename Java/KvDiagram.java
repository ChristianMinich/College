package de.modsim.mathe;

import java.util.ArrayList;

public class KvDiagram {
    private static boolean[][] createEmptyTruthTable() {
        boolean[][] bool = {
                {false, false, false, false},
                {false, false, false, true},
                {false, false, true, false},
                {false, false, true, true},
                {false, true, false, false},
                {false, true, false, true},
                {false, true, true, false},
                {false, true, true, true},
                {true, false, false, false},
                {true, false, false, true},
                {true, false, true, false},
                {true, false, true, true},
                {true, true, false, false},
                {true, true, false, true},
                {true, true, true, false},
                {true, true, true, true}};
        return bool;
    }

    private static ArrayList<Boolean> generateYList() {
        ArrayList<Boolean> yList = new ArrayList<Boolean>();

        yList.add(false);
        yList.add(false);
        yList.add(true);
        yList.add(true);
        yList.add(false);
        yList.add(false);
        yList.add(false);
        yList.add(false);
        yList.add(true);
        yList.add(false);
        yList.add(true);
        yList.add(true);
        yList.add(true);
        yList.add(true);
        yList.add(true);
        yList.add(true);
        return yList;
    }

    private static boolean[][] buildEmptyDiagram() {
        boolean[][] diagram = {
                {false, false, false, false},
                {false, false, false, false},
                {false, false, false, false},
                {false, false, false, false}};
        return diagram;
    }

    public static void printMatrix(boolean[][] bool, ArrayList<Boolean> yList){
        int numberOfColums = bool.length;

        System.out.println("a     " + "b     " + "c     " + "d     " + "y     ");

        for(int row = 0; row < numberOfColums -1; row++){
            for(int col = 0; col < bool[row].length; col++){
                System.out.print(bool[row][col] + " ");
            }
            System.out.println("| " + yList.get(row));
            System.out.println();
        }
    }

    public static void printDiagram(boolean[][] diagram){
        int numberOfColums = diagram.length;

        for(int row = 0; row < numberOfColums; row++){
            for(int col = 0; col < diagram[row].length; col++){
                System.out.print(diagram[row][col] + " ");
            }
            System.out.println();
        }

        System.out.println("    a  " + " " + "  a");
        System.out.println("  -----" + " " + "-----");
        System.out.println("b" + "|" + diagram[0][0] + " " + diagram[0][1] + " " + diagram[0][2] + " " + diagram[0][3] + " |" +"d");
        System.out.println("b" + "|" + diagram[1][0] + " " + diagram[1][1] + " " + diagram[1][2] + " " + diagram[1][3]);
        System.out.println(" " + " " + diagram[2][0] + " " + diagram[2][1] + " " + diagram[2][2] + " " + diagram[2][3]);
        System.out.println(" " + " " + diagram[3][0] + " " + diagram[3][1] + " " + diagram[3][2] + " " + diagram[3][3] + " |" + "d");
        System.out.println("  -----" + "             " + "-----");
        System.out.println("   c " + "                " + "  c ");
    }

    public static boolean[][] solveDiagram(boolean[][] diagram, boolean[][] bool, ArrayList<Boolean> yList){
        int lengthOfYList = yList.size();
        for(int i = 0; i < lengthOfYList; i++){
            if(yList.get(i)){
                // A * B * C * D
                if(bool[i][0] && bool[i][1] && bool[i][2] && bool[i][3]){
                    diagram[0][0] = true;
                }
                // A * B * !C * D
                else if(bool[i][0] && bool[i][1] && (!bool[i][2]) && bool[i][3]){
                    diagram[0][1] = true;
                }
                // !A * B * !C * D
                else if((!bool[i][0]) && bool[i][1] && (!bool[i][2]) && bool[i][3]){
                    diagram[0][2] = true;
                }
                // !A * B * C * D
                else if((!bool[i][0]) && bool[i][1] && bool[i][2] && bool[i][3]){
                    diagram[0][3] = true;
                }
                // A * B * C * !D
                else if(bool[i][0] && bool[i][1] && bool[i][2] && (!bool[i][3])){
                    diagram[1][0] = true;
                }
                // A * B * !C * !D
                else if(bool[i][0] && bool[i][1] && (!bool[i][2]) && (!bool[i][3])){
                    diagram[1][1] = true;
                }
                // !A * B * !C * !D
                else if((!bool[i][0]) && bool[i][1] && (!bool[i][2]) && (!bool[i][3])){
                    diagram[1][2] = true;
                }
                // !A * B * C * !D
                else if((!bool[i][0]) && bool[i][1] && bool[i][2] && (!bool[i][3])){
                    diagram[1][3] = true;
                }
                // A * !B * C * !D
                else if(bool[i][0] && (!bool[i][1]) && bool[i][2] && (!bool[i][3])){
                    diagram[2][0] = true;
                }
                // A * !B * !C * !D
                else if(bool[i][0] && (!bool[i][1]) && (!bool[i][2]) && (!bool[i][3])){
                    diagram[2][1] = true;
                }
                // !A * !B * !C * !D
                else if((!bool[i][0]) && (!bool[i][1]) && (!bool[i][2]) && (!bool[i][3])){
                    diagram[2][2] = true;
                }
                // !A * !B * C * !D
                else if((!bool[i][0]) && (!bool[i][1]) && bool[i][2] && (!bool[i][3])){
                    diagram[2][3] = true;
                }
                // A * !B * C * D
                else if(bool[i][0] && (!bool[i][1]) && bool[i][2] && bool[i][3]){
                    diagram[3][0] = true;
                }
                // A * !B * !C * D
                else if(bool[i][0] && (!bool[i][1]) && (!bool[i][2]) && bool[i][3]){
                    diagram[3][1] = true;
                }
                // !A * !B * !C * D
                else if((!bool[i][0]) && (!bool[i][1]) && (!bool[i][2]) && bool[i][3]){
                    diagram[3][2] = true;
                }
                // !A * !B * C * D
                else if((!bool[i][0]) && (!bool[i][1]) && bool[i][2] && bool[i][3]){
                    diagram[3][3] = true;
                }
            }
        }
        return diagram;
    }



    public static void main(String[] args){


        boolean[][] truthTable = createEmptyTruthTable();

        ArrayList<Boolean> yList = generateYList();

        boolean[][] kvDiagram = buildEmptyDiagram();

        printMatrix(truthTable, yList);

        solveDiagram(kvDiagram, truthTable, yList);

        printDiagram(kvDiagram);
    }

}
