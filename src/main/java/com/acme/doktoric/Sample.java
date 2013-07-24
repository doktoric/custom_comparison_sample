package com.acme.doktoric;

import com.google.common.collect.ComparisonChain;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: Ricsi
 * Date: 2013.07.24.
 * Time: 21:02
 * To change this template use File | Settings | File Templates.
 */
public class Sample {

    public static void main(String args[]) {
        Integer countOfMembers = 20;
        String superTeam = "Super Team";
        Type type = Type.FOOTBALL;
        Boss boss = new Boss("Bob", 32);
        Team team1 = new Team(boss, countOfMembers, superTeam, type);
        Team team2 = new Team(new Boss("Bob", 32), countOfMembers, superTeam, type);

        SimpleComparison(team1, team2);
        CustomComparison(team1, team2);
        CustomComparisonWithDeepComparator(team1, team2);
        CustomComparisonWithOutDeepComparator(team1, team2);
    }

    public static void SimpleComparison(Team team1, Team team2) {
        System.out.println("Simple equals: " + team1.equals(team2));
    }

    public static void CustomComparison(Team team1, Team team2) {
        int result = ComparisonChain.start()
                .compare(team1.getName(), team2.getName())
                .compare(team1.getCountOfMembers(), team2.getCountOfMembers())
                .compare(team1.getType(), team2.getType())
                .compare(team1.getBoss(), team2.getBoss(), new Comparator<Boss>() {
                    @Override
                    public int compare(Boss o1, Boss o2) {
                        return (o1.equals(o2) == true ? 0 : 1);
                    }
                })
                .result();
        System.out.println("Custom equals: " + (result > 0 ? false : true));
    }

    public static void CustomComparisonWithDeepComparator(Team team1, Team team2) {
        int result = ComparisonChain.start()
                .compare(team1.getName(), team2.getName())
                .compare(team1.getCountOfMembers(), team2.getCountOfMembers())
                .compare(team1.getType(), team2.getType())
                .compare(team1.getBoss(), team2.getBoss(), new Comparator<Boss>() {
                    @Override
                    public int compare(Boss o1, Boss o2) {
                        return ComparisonChain.start()
                                .compare(o1.getAge(), o2.getAge())
                                .compare(o1.getName(), o2.getName())
                                .result();
                    }
                })
                .result();
        System.out.println("Custom Deep equals: " + (result > 0 ? false : true));
    }

    public static void CustomComparisonWithOutDeepComparator(Team team1, Team team2) {
        int result = ComparisonChain.start()
                .compare(team1.getName(), team2.getName())
                .compare(team1.getCountOfMembers(), team2.getCountOfMembers())
                .compare(team1.getType(), team2.getType())
                .compare(team1.getBoss().getAge(), team2.getBoss().getAge())
                .compare(team1.getBoss().getName(), team2.getBoss().getName())
                .result();
        System.out.println("Custom Deep Without Comparator equals: " + (result > 0 ? false : true));
    }


}
