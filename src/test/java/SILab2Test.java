import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    private List <User> createList( User ... elems ) {
        return new ArrayList<>( Arrays.asList(elems) );
    }

    @Test
    void every_branch_test(){

        /* Branch 1: Null User */
        Exception exception = assertThrows( RuntimeException.class, () -> SILab2.function( null, createList() ) );
        assertTrue( exception.getMessage().contains( "Mandatory information missing!" ) );

        /* Branch 2: User with null username, that exists in the user list */
        assertFalse( SILab2.function( new User( null, "finki123", "andrej.shekerov@students.finki.ukim.mk" ), createList( new User( null, "finki123", "andrej.shekerov@students.finki.ukim.mk" ) ) ) );

        /* Branch 3: User with valid username that is contained in password, and invalid email */
        assertFalse( SILab2.function( new User( "andrej", "andrej", "andrej" ), createList() ) );

        /* Branch 4: User with a space in their password that doesn't match with at least one user in the user list */
        assertFalse( SILab2.function( new User( "andrej", "finki password", "a@f.c" ) , createList( new User( "nikola", "python123", "n@f.c" ) ) ) );

        /* Branch 5: User with a password with a special character */
        assertTrue( SILab2.function( new User( "andrej", "finki123#", "a@f.c" ), createList() ) );

    }

    @Test
    void multiple_condition_test(){

        /* if( user==null || user.getPassword()==null || user.getEmail()==null ) */

        /* TXX */
        Exception exception_1 = assertThrows( RuntimeException.class, () -> SILab2.function( null, createList() ) );
        assertTrue( exception_1.getMessage().contains( "Mandatory information missing!" ) );

        /* FTX */
        Exception exception_2 = assertThrows( RuntimeException.class, () -> SILab2.function( new User( "andrej", null, null ), createList() ) );
        assertTrue( exception_2.getMessage().contains( "Mandatory information missing!" ) );

        /* FFT */
        Exception exception_3 = assertThrows( RuntimeException.class, () -> SILab2.function( new User( "andrej", "pswd", null ), createList() ) );
        assertTrue( exception_2.getMessage().contains( "Mandatory information missing!" ) );

        /* FFF */
        assertTrue( SILab2.function( new User( "andrej", "finki123#", "a@f.c" ), createList() ) );

    }

}