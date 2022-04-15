package controller;

import dao.entity.BookGenre;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reader {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Scanner in = new Scanner(System.in);

    public static String readName() {
        String name;
        while (true) {
            System.out.println("Please enter a valid value>> ");
            try {
                String line = reader.readLine();
                // Accept a line with alphabetic characters delimited with space.
                if (line.matches("[A-Za-z ]+$")) {
                    name = line;
                    break;
                }
            } catch (IOException e) {
                // Handle broken input stream here.
                name = "";
                e.printStackTrace();
                break;
            }
        }
        return name;
    }

    public static String readEmail() {
        String email;
        Pattern VALID_EMAIL_ADDRESS_REGEX =
                Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher mather;
        while (true) {
            System.out.println("Please enter a valid email>> ");
            try {
                String line = reader.readLine();
                mather = VALID_EMAIL_ADDRESS_REGEX.matcher(line);
                if (mather.matches()) {
                    email = line;
                    break;
                }
            } catch (IOException e) {
                email = "";
                e.printStackTrace();
                break;
            }
        }
        return email;
    }

    public static Long readId() {
        Long id = 0L;
        while (true) {
            System.out.println("Please enter a valid id>> ");
            String s = in.nextLine();
            try {
                id = Long.parseLong(s);
                break;
            } catch (NumberFormatException e) {
            }
        }
        return id;
    }

    public static Double readPrice() {
        Double price = 0.0;
        while (true) {
            System.out.println("Please enter a valid price>> ");
            String s = in.nextLine();
            try {
                price = Double.parseDouble(s);
                break;
            } catch (NumberFormatException e) {
            }
        }
        return price;
    }

    public static Calendar readCalendar() {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        while (date == null) {
            System.out.println("Please enter a valid data>> ");
            String line = in.nextLine();
            try {
                date = format.parse(line);
            } catch (ParseException e) {
            }
        }
        Calendar yearOfPublishing = Calendar.getInstance();
        yearOfPublishing.setTime(date);
        return yearOfPublishing;
    }

    public static BookGenre readBookGenre() {
        String genre;
        BookGenre bookGenre = null;
        while (bookGenre == null) {
            System.out.println("Please enter a valid book genre>> ");
            genre = in.nextLine().toUpperCase();
            try {
                bookGenre = BookGenre.valueOf(genre);
            } catch (IllegalArgumentException e) {
                return bookGenre;
            }
        }
        return bookGenre;
    }
}
