package javaqaticket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class AviaSoulsTest {
    Ticket ticket1 = new Ticket("Москва", "Стамбул", 30_000, 15_00, 18_00);
    Ticket ticket2 = new Ticket("Москва", "Стамбул", 45_000, 15_00, 19_00);
    Ticket ticket3 = new Ticket("Москва", "Стамбул", 35_000, 15_00, 20_00);
    Ticket ticket4 = new Ticket("Стамбул", "Москва", 40_000, 18_00, 15_00);
    Ticket ticket5 = new Ticket("Москва", "Сочи", 70_000, 10_00, 12_00);

    @Test
    void testSearch() {
        AviaSouls manager = new AviaSouls();

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] expected = {ticket1, ticket3, ticket2};
        Ticket[] actual = manager.search("Москва", "Стамбул");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testSearchNo() {
        AviaSouls manager = new AviaSouls();

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] expected = {};
        Ticket[] actual = manager.search("Москва", "Астрахань");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testCompareToMinus() {

        System.out.println(ticket1.compareTo(ticket2));
    }

    @Test
    void testCompareToPlus() {

        System.out.println(ticket2.compareTo(ticket1));
    }

    @Test
    void testCompareToZero() {

        System.out.println(ticket2.compareTo(ticket2));
    }

    @Test
    void testCompareToArray() {
        Ticket[] tickets = {ticket1, ticket2, ticket3};

        Arrays.sort(tickets);
    }

    @Test
    void testComparator() {

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Ticket[] tickets = {ticket1, ticket2};

        Arrays.sort(tickets, timeComparator);
    }

    @Test
    void testSearchAndSortBy() {

        AviaSouls manager = new AviaSouls();

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket1, ticket2, ticket3};
        Ticket[] actual = manager.searchAndSortBy("Москва", "Стамбул", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testSearchAndSortByNo() {

        AviaSouls manager = new AviaSouls();

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = manager.searchAndSortBy("Москва", "Астрахань", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}