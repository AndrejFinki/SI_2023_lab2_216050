# SI_2023_lab2_216050
Andrej Shekerov 216050

# Control Flow Graph
![Control Flow Graph.png](Control%20Flow%20Graph.png)

# Цикломатска Комплексност
Можеме да искористиме две формули за да ја добиеме истата цикломатска комплексност.

`R: Result`

Првата формула `R = E - N + 2` ни бара да го изброиме бројот на нодови `N: 28` и бројот на ребра `E: 37` за да добиеме резултат `R: 11`

Втората формула `R = P + 1` ни бара да го изброиме бројот на предикатни нодови `P: 10` за да добиеме резултат `R: 11`

# Тестови според Every Branch

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

# Тестови според Multiple Condition за `if (user==null || user.getPassword()==null || user.getEmail()==null)`

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

# Oбјаснување за тестови - Every Branch

Тестовите во оваа група имаат со цел да го поминат секое ребро во CFG. Подетално за секој тест случај е дадено во 
[Every Branch Document.pdf](Every%20Branch%20Document.pdf), но идеата е секој тест да помине ново ребро кое до сега не е поминато.

1) Првата гранка е кога имаме user кој е null

2) Втората гранка е кога имаме user чие име e null, но има валиден пасворд и емаил, и исто така тој веќе постои во листата на корисници

3) Третата гранка е кога имаме user чие име е исто како пасвордот, и исто така има невалиден емаил

4) Четвртата гранка е кога user има празно место во нивниот пасворд, и исто така во листата на корисници има барем еден друг корисник

5) Петтата гранка е кога имаме корисник кој што има доволно долг пасворд со специјален карактер, валиден емаил, валиден username, и не постои веќе во листата на корисници

# Објаснување на тестови - Multiple Condition

Тука идеата е со тестовите да го поминеме секој можен исход на if-statementот, а можни исходи во овој случај се:

1) `True X X`
Кога user e null

2) `False True X`
Кога user не е null, но username е null

3) `False False True`
Кога user и password не се null, но email e null

4) `False False False`
Кога user, password и email не се null
