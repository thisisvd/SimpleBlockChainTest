package com.company;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class Main {

    public static ArrayList<Block> blockChain = new ArrayList<>();

    public static void main(String[] args) {

//        Older Code (without using Arraylist) -

//        Block startBlock = new Block("Hi, I am the first ever block here.","0");
//        System.out.println("Hash for block 1 : " + startBlock.hash);
//
//        Block secondBlock = new Block("Hello, I am the second block presented here.", startBlock.hash);
//        System.out.println("Hash for block 2 : " + secondBlock.hash);
//
//        Block thirdBlock = new Block("Hey, I am the third last block created.", secondBlock.hash);
//        System.out.println("Hash for block 3 : " + thirdBlock.hash);


//      Code using ArrayList -
        blockChain.add(new Block("Hi, I am the first ever block here.","0"));
        blockChain.add(new Block("Hello, I am the second block presented here.", blockChain.get(blockChain.size()-1).hash));
        blockChain.add(new Block("Hey, I am the third last block created.", blockChain.get(blockChain.size()-1).hash));

//      GSON Viewer -
        String blockChainGSON = new GsonBuilder().setPrettyPrinting().create().toJson(blockChain);
        System.out.println(blockChainGSON);

    }

    public static boolean isBlockChainValid(){

        Block currentBlock;
        Block previousBlock;

        for (int i=1; i< blockChain.size(); i++){
            currentBlock = blockChain.get(i);
            previousBlock = blockChain.get(i-1);

            if(!currentBlock.hash.endsWith(currentBlock.calculateHash())){
                System.out.println("Current Hashes are not equal.");
                return false;
            }

            if(!previousBlock.hash.equals(previousBlock.calculateHash())){
                System.out.println("Previous Hashes are not equal.");
                return false;
            }
        }

        return true;

    }

}
