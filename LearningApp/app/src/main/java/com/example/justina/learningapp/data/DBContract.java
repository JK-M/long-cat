package com.example.justina.learningapp.data;

import android.provider.BaseColumns;

public class DBContract {

    public DBContract() {}

    /* Inner class that defines the table contents */
    public static abstract class TableFav implements BaseColumns {
        public static final String TABLE_NAME = "top_favourites";
        public static final String FIRST_COL_NAME = "firstfav";
        public static final String SECOND_COL_NAME = "secondfav";
        public static final String THIRD_COL_NAME = "thirdfav";
        public static final String FOURTH_COL_NAME = "fourthfav";
        public static final String FIFTH_COL_NAME = "fifthfav";
    }
}
