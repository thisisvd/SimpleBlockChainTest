package com.company;

import java.util.Date;

public class Block {

    public String hash;
    public String previousHash;
    public String data;
    public long timeStamp;

    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }

    public String calculateHash(){
        String calculatedHash = StringUtil.applySHA256(previousHash +
                Long.toString(timeStamp) +
                data
        );

        return calculatedHash;
    }


}
