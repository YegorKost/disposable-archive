package com.yegor.disposableArchive;


import com.yegor.parser.ParseCmd;

/**
 * The main class that start the program
 */
public class DisposableArchive {

    public static void main (String[] args) {

        ParseCmd parseCmd = new ParseCmd(args);
        parseCmd.parse();

    }

}
