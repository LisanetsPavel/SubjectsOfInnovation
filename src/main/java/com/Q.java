package com;

class Q {
    void mQ(int i) {
        System.out.print("mQ" + i);
    } }
class Quest6 extends Q {
    public void mQ(int i) {
        System.out.print("mQuest" + i);
    }

    public static void main(String args[]) {
        Q ob = new Quest6(); //1
        ob.mQ(1); //2

    } }