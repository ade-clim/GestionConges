package fr.formation.afpa.controllers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class InfoControle {

	public boolean verifLogin(String login) {
		boolean valeur = false;
		try{
			Pattern p = Pattern.compile("[a-zA-Z]+");
			Matcher m = p.matcher(login);
			if (p.matches("[a-zA-Z]+",login)) {
				System.out.print("login correct");
				valeur = true;
			} else {
				System.out.print("login incorrect");
				valeur = false;
			}
			System.out.println();
		}catch(PatternSyntaxException e) {
			System.out.println("erreur dans la methode verigLogin" + e.getMessage());
		}
		return valeur;
	}

	public boolean verifPassword(String password) {
		boolean valeur = false;
		try{
			Pattern p = Pattern.compile("[a-zA-Z]+");
			Matcher m = p.matcher(password);
			if (p.matches("[a-zA-Z]+",password)) {
				System.out.print("password correct");
				valeur = true;
			} else {
				System.out.print("password incorrect");
				valeur = false;
			}
			System.out.println();
		}catch(PatternSyntaxException e) {
			System.out.println("erreur dans la methode verifPassword" + e.getMessage());
		}
		return valeur;
	}
}
