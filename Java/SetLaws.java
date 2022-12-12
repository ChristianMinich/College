package de.modsim.mathe;

import java.util.HashSet;
import java.util.Random;

public class SetLaws {

    // Variable Declaration
    private static final int N = 4;
    private static final int M = 8;

    public static HashSet<Integer> setA;
    public static HashSet<Integer> setB;
    public static HashSet<Integer> setC;
    private static Random rnd = new Random();

    // Constructor for initialisation

     public SetLaws(){
         setA = new HashSet<Integer>();
         setB = new HashSet<Integer>();
         setC = new HashSet<Integer>();
         this.fillSet(setA, N);
         this.fillSet(setB, N);
         this.fillSet(setC, N);
     }

     // Loading Hashsets
     public void fillSet(HashSet<Integer> set, int N){
         while(set.size() < N){
             int current_random = rnd.nextInt(1, M);
                 set.add(current_random);
         }
     }

     // Set - Intersection
     public static HashSet<Integer> setIntersection(HashSet<Integer> a, HashSet<Integer> b){
         HashSet<Integer> intersectSet = new HashSet<>(a);
         intersectSet.retainAll(b);
         return intersectSet;
     }

     // Set - Union
    public static HashSet<Integer> setUnion(HashSet<Integer> a, HashSet<Integer> b){
        HashSet<Integer> unionSet = new HashSet<Integer>(a);
        unionSet.addAll(b);
        return unionSet;
    }

    // Set - Complement
    public static HashSet<Integer> setComplement(HashSet<Integer> a, HashSet<Integer> b){
         HashSet<Integer> complementSet = new HashSet<Integer>(a);
         complementSet.removeAll(b);
        return complementSet;
    }

    // Reflexivity
    public static boolean testReflexivity(HashSet<Integer> a){
         return a.containsAll(a);
    }

    // Anti-Symmetry
    public static boolean testAntiSymmetry(HashSet<Integer> a, HashSet<Integer> b){
         return !(a.containsAll(b) && b.containsAll(a));
    }

    // Transitivity
    public static boolean testTransitivity(HashSet<Integer> a, HashSet<Integer> b, HashSet<Integer> c){
         return (a.containsAll(b) == b.containsAll(c)) && a.containsAll(c);
    }

    public static void main(String[] args){

         SetLaws admin = new SetLaws();

        // Set String Output
        System.out.println("setA " + setA.toString());
        System.out.println("setB " + setB.toString());

        // Set Operations
        System.out.println("Intersection " + setIntersection(setA, setB));
        System.out.println("Union " + setUnion(setA, setB));
        System.out.println("Complement " + setComplement(setA, setB));

        // Set Laws
        //Reflexivity
        System.out.println("setA" + " Reflexivity: " + testReflexivity(setA) + " | aRa");
        System.out.println("setB" + " Reflexivity: " + testReflexivity(setB) + " | bRb");

        // AntiSymmetry
        System.out.println("setA" + " setB" + " AntiSymmetry: " + testAntiSymmetry(setA, setB) + " | aRb != bRa");

        // Set String Output for setC
        System.out.println("setC " + setC.toString());

        //Transitivity
        System.out.println("setA " + "setB " + "setC " +
                "Transitivity: " + testTransitivity(setA, setB, setC) + " | aRb = bRc => aRc");
    }
}
