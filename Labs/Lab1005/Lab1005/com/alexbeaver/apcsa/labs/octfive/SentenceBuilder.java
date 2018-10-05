package com.alexbeaver.apcsa.labs.octfive;
import java.*;

/**
 * Write a description of class SentenceBuilder here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SentenceBuilder
{
    // instance variables - replace the example below with your own
    private int x;
    private String s;
    private static String[] nou = {
            "area",
            "book",
            "business",
            "case",
            "child",
            "company",
            "country",
            "day",
            "eye",
            "fact",
            "family",
            "government",
            "group",
            "hand",
            "home",
            "job",
            "life",
            "lot",
            "man",
            "money",
            "month",
            "mother",
            "Mr",
            "night",
            "number",
            "part",
            "people",
            "place",
            "point",
            "problem",
            "program",
            "question",
            "right",
            "room",
            "school",
            "state",
            "story",
            "student",
            "study",
            "system",
            "thing",
            "time",
            "water",
            "way",
            "week",
            "woman",
            "word",
            "work",
            "world",
            "year",
        };
    private static String[] ver = {
            "ask",
            "be",
            "becomes",
            "begins",
            "calls",
            "comes",
            "could",
            "does",
            "feels",
            "finds",
            "gets",
            "gives",
            "goes",
            "haves",
            "hears",
            "helps",
            "keeps",
            "knows",
            "leaves",
            "lets",
            "likes",
            "lives",
            "looks",
            "makes",
            "means",
            "mights",
            "moves",
            "needs",
            "plays",
            "puts",
            "runs",
            "says",
            "sees",
            "seems",
            "shows",
            "starts",
            "takes",
            "talks",
            "tells",
            "thinks",
            "tries",
            "turns",
            "uses",
            "wants",
            "wills",
            "works",
            "would",
        };
    private static String[] adj = {
            "able",
            "bad",
            "best",
            "better",
            "big",
            "black",
            "certain",
            "clear",
            "different",
            "early",
            "easy",
            "economic",
            "federal",
            "free",
            "full",
            "good",
            "great",
            "hard",
            "high",
            "human",
            "important",
            "international",
            "large",
            "late",
            "little",
            "local",
            "long",
            "low",
            "major",
            "military",
            "national",
            "new",
            "old",
            "only",
            "other",
            "political",
            "possible",
            "public",
            "real",
            "recent",
            "right",
            "small",
            "social",
            "special",
            "strong",
            "sure",
            "white",
            "whole",
            "young",
        };
    private static String[] adv = {
            "quickly",
            "slowly",
            "emotionally",
            "procedurally",
            "recursively",
            "religiously",
            "carefully",
            "intensely",
            "obnoxiously",
            "deathly",
            "angrily",

        };
    private static String[] prep = {
            "over", 
            "near", 
            "on top of", 
            "behind", "next to", 
            "inside of", 
            "under"
        };
    private static String[] det = {
            "the", 
            "my", 
            "your", 
            "his", 
            "her", 
            "our", 
            "their", 
            "Fred's"
        };

    /**
     * Constructor for objects of class SentenceBuilder
     */
    public SentenceBuilder()
    {
        // initialise instance variables
        x = 0;
    }

    public static void loadSentences(){

    }

    public static String getSentence(){
        return getNounPhrase() +" " + getVerbPhrase() +" " + getPrepositionalPhrase();
    }

    public static String getNounPhrase(){
        return getRandomDeterminer() +" " + getRandomAdjective() + " " + getRandomNoun();
    }

    public static String getPrepositionalPhrase(){
        return getRandomPreposition() +" " + getRandomDeterminer()+" " +getRandomAdjective() +" " + getRandomNoun();
    }

    public static String getVerbPhrase(){
        return getRandomAdverb() +" " + getRandomVerb();
    }

    public static String getRandomNoun(){
        String[] a = nou;
        int index = (int)(Math.random()*a.length);
        return a[index];

    }

    public static String getRandomVerb(){
        String[] a = ver;
        int index = (int)(Math.random()*a.length);
        return a[index];
    }

    public static String getRandomAdjective(){
        String[] a = adj;
        int index = (int)(Math.random()*a.length);
        return a[index];
    }

    public static String getRandomAdverb(){
        String[] a = adv;
        int index = (int)(Math.random()*a.length);
        return a[index];
    }

    public static String getRandomDeterminer(){
        String[] a = det;
        int index = (int)(Math.random()*a.length);
        return a[index];
    }

    public static String getRandomPreposition(){
        String[] a = prep;
        int index = (int)(Math.random()*a.length);
        return a[index];
    }
}
