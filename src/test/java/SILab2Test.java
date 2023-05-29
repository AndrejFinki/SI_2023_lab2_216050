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
    void SimpleTest(){

        User null_user = null;
        List <User> user_list = createList();

        boolean caught_correct_exception = false;
        String expected_message = "Mandatory information missing!";

        try{
            SILab2.function( null_user, user_list );
        } catch ( RuntimeException x ){
            if( x.getMessage().equals( expected_message ) ){
                caught_correct_exception = true;
            }
        }

        assertTrue( caught_correct_exception );

    }

}