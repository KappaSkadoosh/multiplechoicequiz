package com.example.kappa.quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Kappa on 2/18/2017.
 */

public class QuestionLib {


    private String Question[]={
            "What is Shield capacity of Abaddon's maxed Aphotic Shield before talent upgrade?",
            "What is bounty rune multiplier of Alchemist's Greevil's Greed?",
            "How long does Ancient Apparition's Ice Blast last with Aghanim's Scepter upgrade?",
            "How long is the cooldown of Anti-Mage's Mana Void with talent upgrade?",
            "What is the cooldown of Axe's level 4 Berserker's Call?",
            "How much does Bane's maxed Brain Sap damage/heal self/enemy after talent upgrade?",
            "Percentage of damage amplified by Bloodseeker's level 4 Bloodrage?",
            "Effect of Bounty Hunter's Aghanim's Scepter upgrade?",
            "How many spiderlings will Broodmother's maxed Spawn Spiderling spawn?",
            "How many strength does Centaur Warrunner gain each level?",
            "Which skill can Invoker invoke with only 3 Exort essences?",
            "What is the level 25 upgrade for Nature's Prophet during the beginning of version 7.00",
            "The hitpoints of Lone Druid's spirit bear during the first level.",
            "How much is the critical damge of Phantom Assassin's Coup de Grace at level 3?",
            "Which response if sniper most well known for?",
            "What effect does Lifestealer's Aghanim's Scepter provide?",
            "This is AdmiralBulldog, he is most well known for?",
            "How much mana does Wraith King's Reincarnation cost with talent upgrade?"


    };

    private String choices [] []={
            {"200", "225", "300"},
            {"3x", "2x", "7x"},
            {"15", "20", "17" },
            {"35", "12", "20"},
            {"15", "12", "10"},
            {"500", "322", "420"},
            {"40%", "90%", "60%"},
            {"Shuriken Toss deals double damage", "Shuriken Toss bounces twice on each tracked hero",
            "More track gold per kill"},
            {"3","2","4"},
            {"4.0","4.2","3.2"},
            {"Chaos Meteor","Sun Strike", "Forge Spirit"},
            {"+6 treants","Double treants's damage and health", "10 seconds Sprout"},
            {"1400","1600","1000"},
            {"420%","500%","450%"},
            {"HOHO HAHA!", "Time for target practice.", "Easy as shooting gnats!"},
            {"Let an ally hide within him", "Devour an enemy instantly causing death", "30seconds Rage duration"},
            {"Being a TI (THE INTERNATIONAL TOURNAMENT) WINNER","Being a popular streamer","His ratting skills"},
            {"0","50","20"}


    };



    private String CorrectAnswers[]={"200","2x","17","20","10","500","40%",
            "Shuriken Toss bounces twice on each tracked hero","4","4.0","Sun Strike","+6 treants",
            "1400","450%","HOHO HAHA!","Let an ally hide within him",
            "Being a TI (THE INTERNATIONAL TOURNAMENT) WINNER","0"

    };

    public String getQuestion(int index){
        String question= Question[index];
        return question;
    };

    public String getChoice1(int index){
        String choice1=choices[index][0];
        return choice1;
    }

    public String getChoice2(int index){
        String choice2=choices[index][1];
        return choice2;
    }
    public String getChoice3(int index){
        String choice3=choices[index][2];
        return choice3;
    }

    public String getAnswer(int index){
        String answer= CorrectAnswers[index];
        return answer;
    }

}
