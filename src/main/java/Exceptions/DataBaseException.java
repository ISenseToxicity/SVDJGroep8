package Exceptions;

import javax.swing.*;

public class DataBaseException extends Exception{
    @Override
    public String getMessage() {
        return "Excuses voor het ongemak de Database Connectie is niet gelukt";
    }
}
