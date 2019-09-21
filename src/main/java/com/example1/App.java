	
package com.example1;

import com.example1.info.PersonalNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class App {

    private static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        List<PersonalNumber> customerList = new ArrayList<>();
        int choice;
        Scanner s = new Scanner(System.in);
        do {
            logger.info("1. Insert");
            logger.info("2. Display one");
            logger.info("3. Display all");
            logger.info("4. Delete");
            logger.info("5. Update");
            logger.info("6. Lucky number");
            logger.info("7. Numerlogy");
            logger.info("8. Exit");
            logger.info("Enter your choice");

            choice = s.nextInt();

            switch (choice) {
                case 1:
                    PersonalNumber personalNumber = getNewPerson(s);
                    customerList.add(personalNumber);
                    break;
                case 2:
                    logger.info("Enter customer id : ");
                    int idToSearch = s.nextInt();

                    if (isExists(idToSearch, customerList) == true) {
                        printCustomer(idToSearch, customerList);
                    } else {
                        logger.error("Provided id {} not found!", idToSearch);
                    }
                    break;
                case 3:
                    printCustomerList(customerList);
                    break;
                case 4:
                    logger.info("Enter customer id : ");
                    idToSearch = s.nextInt();

                    if (isExists(idToSearch, customerList) == true) {
                        removeCustomer(idToSearch, customerList);
                    } else {
                        logger.error("Provided id {} not found!", idToSearch);
                    }
                    break;
                case 5:
                    logger.info("Enter customer id : ");
                    idToSearch = s.nextInt();
                    if (isExists(idToSearch, customerList) == true) {
                        updateCustomer(idToSearch, customerList, s);
                    } else {
                        logger.error("Provided id {} not found!", idToSearch);
                    }
                    break;

                case 6:
                    logger.info("Enter customer id : ");
                    idToSearch = s.nextInt();
                    if (isExists(idToSearch, customerList) == true) {
                        numerologyOnDate(idToSearch, customerList);
                    } else {
                        logger.error("Provided id {} not found!", idToSearch);
                    }


                    break;
                case 7:

                    logger.info("Enter customer id : ");
                    idToSearch = s.nextInt();
                    if (isExists(idToSearch, customerList) == true) {
                        numerologyOnFullDate(idToSearch, customerList);
                    } else {
                        logger.error("Provided id {} not found!", idToSearch);
                    }
                    break;
                case 8:
                    break;

                default:
                    logger.warn("Please enter correct choice");
                    break;
            }

        } while (choice != 8);
    }

    private static void numerologyOnFullDate(int idToSearch, List<PersonalNumber> customerList) {

        PersonalNumber person = findPerson(idToSearch, customerList);

        int year = person.getYear();
        int n = person.getDateOfBirth();
        int o = person.getMonth();

        int first = extractDigit(year, 0);
        int second = extractDigit(year, 1);
        int third = extractDigit(year, 2);
        int fourth = extractDigit(year, 3);

        logger.info(fourth + "," + third + "," + second + "," + first);
        int numerology = n + o + fourth + third + second + first;

        int sum = getSumTillSingleDigit(numerology);
        logger.info("\n Hey " + person.getName() + ",YOUR LUCKY NUMBER IS..." + sum);

    }

    private static int getSumTillSingleDigit(int numerology) {
        int sum = 0;

        if (numerology < 10) {
            sum = numerology;
        } else {
            while (numerology > 9) {
                sum = 0;
                while (numerology > 0) {
                    int r;
                    r = numerology % 10;
                    numerology = numerology / 10;
                    sum = sum + r;
                }
                numerology = sum;
            }
        }
        return sum;
    }

    private static int extractDigit(int year, int position) {
        String stringYear = String.valueOf(year);
        return stringYear.charAt(position) - 48;
    }

    private static PersonalNumber findPerson(int idToSearch, List<PersonalNumber> customerList) {
        Iterator<PersonalNumber> iterator4 = customerList.iterator();
        while (iterator4.hasNext()) {
            PersonalNumber customer = iterator4.next();
            if (customer.getId() == idToSearch) {
                return customer;
            }
        }
        return null;
    }

    private static void numerologyOnDate(int idToSearch, List<PersonalNumber> customerList) {

        PersonalNumber person = findPerson(idToSearch, customerList);

        int m = person.getDateOfBirth();
        int sum = getSumTillSingleDigit(m);

        printLuckyNumberInfo(person, sum);
    }

    private static void printLuckyNumberInfo(PersonalNumber person, int sum) {
        logger.info("\n Hey " + person.getName() + ",YOUR LUCKY NUMBER IS..." + sum);

        switch (sum) {
            case 1:
                logger.info(" Hard work pays off in the future, laziness pays off now. ");
                break;
            case 2:
                logger.info("-2- You learn from your mistakes... you will learn a lot today. ");
                break;
            case 3:
                logger.info("-3- Your high minded principles spell success. ");
                break;
            case 4:
                logger.info("-4- A dream you have will come true. ");
                break;
            case 5:
                logger.info("-5- The greatest risk is not taking one. ");
                break;
            case 6:
                logger.info("-6- Your ability for accomplishment will follow with success. ");
                break;
            case 7:
                logger.info("-7- You will travel to many exotic places in your lifetime. ");
                break;
            case 8:
                logger.info("-8- Keep your eye out for someone special. ");
                break;
            case 9:
                logger.info("-9- Now is the time to try something new. ");
                break;
        }
    }

    private static void updateCustomer(int idToSearch, List<PersonalNumber> customerList, Scanner s) {
        Iterator<PersonalNumber> iterator3 = customerList.iterator();

        while (iterator3.hasNext()) {
            PersonalNumber customer = iterator3.next();
            if (customer.getId() == idToSearch) {
                logger.info("Enter name to be update");
                String tsName = s.next();
                customer.setName(tsName);
                logger.info("Enter date of birth to be update");
                int tsCity = s.nextInt();
                customer.setDateOfBirth(tsCity);
                logger.info("Record Updated");
            }
        }
    }

    private static void removeCustomer(int idToSearch, List<PersonalNumber> customerList) {
        Iterator<PersonalNumber> iterator2 = customerList.iterator();
        while (iterator2.hasNext()) {
            PersonalNumber customer = iterator2.next();
            if (customer.getId() == idToSearch) {
                customerList.remove(customer);
                break;
            }
        }
    }

    private static void printCustomerList(List<PersonalNumber> customerList) {
        logger.info("Customer List");
        Iterator<PersonalNumber> iterator = customerList.iterator();
        while (iterator.hasNext()) {
            PersonalNumber customer = iterator.next();
            logger.info(customer.toString());
        }
    }

    private static void printCustomer(int idToSearch, List<PersonalNumber> customerList) {
        Iterator<PersonalNumber> iterator1 = customerList.iterator();
        while (iterator1.hasNext()) {
            PersonalNumber customer = iterator1.next();
            if (customer.getId() == idToSearch) {
                logger.info("----------- Person information ---------");
                logger.info("Id  : {}", customer.getId());
                logger.info("Name: {}", customer.getName());
                logger.info("DOB : {}/{}/{}", customer.getDateOfBirth(), customer.getMonth(), customer.getYear());
                logger.info("----------------------------------------");
                break;
            }
        }
    }

    private static boolean isExists(int idToSearch, List<PersonalNumber> customerList) {
        Iterator<PersonalNumber> iterator1 = customerList.iterator();
        while (iterator1.hasNext()) {
            PersonalNumber customer = iterator1.next();
            if (customer.getId() == idToSearch) {
                return true;
            }
        }
        return false;
    }


    public static PersonalNumber getNewPerson(Scanner s) {
        logger.info("Enter Customer information:");
        logger.info("Id:");
        int tId = s.nextInt();
        logger.info("Name:");
        String tName = s.next();
        logger.info("Date of birth");
        int tCity = s.nextInt();
        logger.info("Month");
        int tMonth = s.nextInt();
        logger.info("Year");
        int tYear = s.nextInt();
        return new PersonalNumber(tId, tName, tCity, tMonth, tYear);
    }
}
/*
                    logger.info("Enter customer id : ");
                    int forid1 = s.nextInt();
                    Iterator<PersonalNumber> iterator5 = customerList.iterator();
                    while (iterator5.hasNext()) {
                        PersonalNumber customer1 = iterator5.next();
                        if (customer1.getId() == forid1) {
                            int m = customer1.getYear();
                            String strYear = String.valueOf(m);
                            int first = strYear.charAt(0) - 48;
                            int second = strYear.charAt(1) - 48;
                            int third = strYear.charAt(2) - 48;
                            int fourth = strYear.charAt(3) - 48;

                            System.out.printf("\n f: %s s: %s t: %s f: %s \n", first, second, third, fourth);
  */