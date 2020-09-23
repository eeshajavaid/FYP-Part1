package com.example.finalfyp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Questions {
    @PrimaryKey
    int question_id;
    String question;

    int category_pid;
    public Questions(int question_id, int category_pid, String question) {
        this.question_id = question_id;
        this.question = question;
        this.category_pid = category_pid;
    }
}
