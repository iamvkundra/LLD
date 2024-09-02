package com.vmware.ensemble.rules.i18n;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.vmware.ensemble.rules.i18n.enums.PlayerType;
import com.vmware.ensemble.rules.i18n.model.Team.Team;
import com.vmware.ensemble.rules.i18n.model.Team.player.Person;
import com.vmware.ensemble.rules.i18n.model.Team.player.Player;
import com.vmware.ensemble.rules.i18n.model.common.Address;

public class Main {
    public static void main(String[] args) {
        Main ob = new Main();

        Team teamA = ob.addTeam("India");
        Team teamB = ob.addTeam("SriLanka");

        MatchType matchType = new T20MatchType();
        Match match = new Match(teamA, teamB, null, "SMS STADIUM", matchType);
        match.startMatch();
    }

    private Team addTeam(String name) {

        Queue<Player> playerDetails = new LinkedList<>();

        Player p1 = addPlayer(name + "1", PlayerType.ALL_ROUNDER);
        Player p2 = addPlayer(name + "2", PlayerType.ALL_ROUNDER);
        Player p3 = addPlayer(name + "3", PlayerType.ALL_ROUNDER);
        Player p4 = addPlayer(name + "4", PlayerType.ALL_ROUNDER);
        Player p5 = addPlayer(name + "5", PlayerType.ALL_ROUNDER);
        Player p6 = addPlayer(name + "6", PlayerType.ALL_ROUNDER);
        Player p7 = addPlayer(name + "7", PlayerType.ALL_ROUNDER);
        Player p8 = addPlayer(name + "8", PlayerType.ALL_ROUNDER);
        Player p9 = addPlayer(name + "9", PlayerType.ALL_ROUNDER);
        Player p10 = addPlayer(name + "10", PlayerType.ALL_ROUNDER);
        Player p11 = addPlayer(name + "11", PlayerType.ALL_ROUNDER);

        playerDetails.add(p1);
        playerDetails.add(p2);
        playerDetails.add(p3);
        playerDetails.add(p4);
        playerDetails.add(p5);
        playerDetails.add(p6);
        playerDetails.add(p7);
        playerDetails.add(p8);
        playerDetails.add(p9);
        playerDetails.add(p10);
        playerDetails.add(p11);

        List<Player> bowlers = new ArrayList<>();
        bowlers.add(p8);
        bowlers.add(p9);
        bowlers.add(p10);
        bowlers.add(p11);

        return new Team(name, playerDetails, new ArrayList<>(), bowlers);
        }

        private Player addPlayer(String name, PlayerType playerType) {
            Person person = new Person(name, 27, new Address("Ranchi", "Jharkhand", "India"));
            return new Player(person, playerType);
        }
}