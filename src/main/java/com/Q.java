package com;

import com.dao.implement.SubjectDaoImpl;

class Q {
    void mQ(int i) {
        System.out.print("mQ" + i);
    } }
class Quest6 extends Q {
    public void mQ(int i) {
        System.out.print("mQuest" + i);
    }

    public static void main(String args[]) {
        SubjectDaoImpl si =new SubjectDaoImpl();
        System.out.println(si.getSubjectById(2l));



    } }