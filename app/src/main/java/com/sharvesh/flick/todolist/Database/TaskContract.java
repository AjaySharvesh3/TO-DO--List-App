package com.sharvesh.flick.todolist.Database;

import android.net.Uri;
import android.provider.BaseColumns;

//public class TaskContract {
//
//    public static final String AUTHORITY = "com.sharvesh.flick.todolist";
//    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + AUTHORITY);
//    public static final String PATH_TASKS = "tasks";
//
//    public static final class TaskEntryData implements BaseColumns {
//        public static final Uri FULL_CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_TASKS).build();
//        public static final String TABLE_NAME = "tasks";
//        public static final String DESCRIPTION = "descriptions";
//        public static final String PRIORITY = "priority";
//    }
//
//}

public class TaskContract {

    /* Add content provider constants to the Contract
     Clients need to know how to access the task data, and it's your job to provide
     these content URI's for the path to that data:
        1) Content authority,
        2) Base content URI,
        3) Path(s) to the tasks directory
        4) Content URI for data in the TaskEntry class
      */

    // The authority, which is how your code knows which Content Provider to access
    public static final String AUTHORITY = "com.sharvesh.flick.todolist";

    // The base content URI = "content://" + <authority>
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + AUTHORITY);

    // Define the possible paths for accessing data in this contract
    // This is the path for the "tasks" directory
    public static final String PATH_TASKS = "tasks";

    /* TaskEntry is an inner class that defines the contents of the task table */
    public static final class TaskEntryData implements BaseColumns {

        // TaskEntry content URI = base content URI + path
        public static final Uri FULL_CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_TASKS).build();


        // Task table and column names
        public static final String TABLE_NAME = "tasks";

        // Since TaskEntry implements the interface "BaseColumns", it has an automatically produced
        // "_ID" column in addition to the two below
        public static final String DESCRIPTION = "description";
        public static final String PRIORITY = "priority";


    }
}