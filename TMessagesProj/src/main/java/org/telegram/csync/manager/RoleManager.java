package org.telegram.csync.managers;

import org.telegram.csync.models.role.UserRole;

public class RoleManager {

    public static boolean isStudent(UserRole role){

        return role==UserRole.STUDENT_MAJOR ||

                role==UserRole.STUDENT_MINOR;

    }

    public static boolean isFaculty(UserRole role){

        return role==UserRole.FACULTY ||

                role==UserRole.HOD;

    }

    public static boolean isGuest(UserRole role){

        return role==UserRole.GUEST;

    }

}