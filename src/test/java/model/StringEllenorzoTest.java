package model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringEllenorzoTest {

    private StringEllenorzo strell;

    @BeforeEach
    void setUp() {strell = new StringEllenorzo();
    }

    @AfterEach
    void tearDown() {strell = null;
    }

    @Test
    void stringEllenorzese() {
        assertEquals("OK", strell.stringEllenorzese("0524/24"));
        assertEquals("OK", strell.stringEllenorzese("0398/1"));
        assertEquals("OK", strell.stringEllenorzese("31607"));
        assertEquals("OK", strell.stringEllenorzese("0497/6/A/1"));
        assertEquals("OK", strell.stringEllenorzese("28673/2/A/2"));
        assertEquals("OK", strell.stringEllenorzese("13465/2"));
        assertEquals("OK", strell.stringEllenorzese("0500/22"));
        assertEquals("OK", strell.stringEllenorzese("17700/2"));
    }

    @Test
    void aBeirtKarakterekSzamaNulla() {
        assertFalse(strell.aBeirtKarakterekSzamaNulla("12345"));
        assertFalse(strell.aBeirtKarakterekSzamaNulla("///+!%/"));
        assertFalse(strell.aBeirtKarakterekSzamaNulla("AGTRZU"));
        assertTrue(strell.aBeirtKarakterekSzamaNulla(""));
    }

    @Test
    void aBeirtKarakterekSzamaMaxTizennyolcLehet() {
        assertFalse(strell.aBeirtKarakterekSzamaMaxTizennyolcLehet("1111111111"));
        assertFalse(strell.aBeirtKarakterekSzamaMaxTizennyolcLehet("0125/A/12"));
        assertTrue(strell.aBeirtKarakterekSzamaMaxTizennyolcLehet("2222222222222222222"));
    }

    @Test
    void nemMegengedettKaraktertTartalmaz() {
        assertTrue(strell.nemMegengedettKaraktertTartalmaz("q"));
        assertTrue(strell.nemMegengedettKaraktertTartalmaz("w"));
        assertTrue(strell.nemMegengedettKaraktertTartalmaz("x"));
        assertTrue(strell.nemMegengedettKaraktertTartalmaz("y"));
        assertTrue(strell.nemMegengedettKaraktertTartalmaz("z"));
        assertTrue(strell.nemMegengedettKaraktertTartalmaz("0125%A/5"));
        assertTrue(strell.nemMegengedettKaraktertTartalmaz("00000_"));
        assertTrue(strell.nemMegengedettKaraktertTartalmaz("1258/I/45"));;
    }

    @Test
    void azEgyHosszusaguHelyrajziSzamCsakNemNullaSzamLehet() {
        assertTrue(strell.azEgyHosszusaguHelyrajziSzamCsakNemNullaSzamLehet("0"));
        assertTrue(strell.azEgyHosszusaguHelyrajziSzamCsakNemNullaSzamLehet("A"));
        assertTrue(strell.azEgyHosszusaguHelyrajziSzamCsakNemNullaSzamLehet("Q"));
        assertFalse(strell.azEgyHosszusaguHelyrajziSzamCsakNemNullaSzamLehet("2"));
        assertFalse(strell.azEgyHosszusaguHelyrajziSzamCsakNemNullaSzamLehet("9"));
    }

    @Test
    void nemKezdodhetKetNullaval() {
        assertTrue(strell.nemKezdodhetKetNullaval("001258/"));
        assertTrue(strell.nemKezdodhetKetNullaval("00125/a/5"));
        assertFalse(strell.nemKezdodhetKetNullaval("0123/R"));
        assertFalse(strell.nemKezdodhetKetNullaval("125/125"));
    }

    @Test
    void ketPerjelNemLehetEgymasMellett() {
        assertTrue(strell.ketPerjelNemLehetEgymasMellett("abc//5"));
        assertTrue(strell.ketPerjelNemLehetEgymasMellett("//"));
        assertTrue(strell.ketPerjelNemLehetEgymasMellett("31605//"));
        assertFalse(strell.ketPerjelNemLehetEgymasMellett("***"));
    }

    @Test
    void maxHaromPerjelLehetBenne() {
        assertTrue(strell.maxHaromPerjelLehetBenne("00000/////"));
        assertTrue(strell.maxHaromPerjelLehetBenne("/ / / / / "));
        assertTrue(strell.maxHaromPerjelLehetBenne("12/32/65/56/"));
        assertFalse(strell.maxHaromPerjelLehetBenne("125/A/5"));
        assertFalse(strell.maxHaromPerjelLehetBenne("00369/7"));
    }

    @Test
    void nemVegzodhetPerjellel() {
        assertTrue(strell.nemVegzodhetPerjellel("12358/"));
        assertTrue(strell.nemVegzodhetPerjellel("......./"));
        assertTrue(strell.nemVegzodhetPerjellel("0125/A/5/"));
        assertFalse(strell.nemVegzodhetPerjellel("667/A/4"));
    }

    @Test
    void betuEsSzamjegyNemLehetEgymasMellett() {
        assertTrue(strell.betuEsSzamjegyNemLehetEgymasMellett("1a"));
        assertTrue(strell.betuEsSzamjegyNemLehetEgymasMellett("5658l/4"));
        assertTrue(strell.betuEsSzamjegyNemLehetEgymasMellett("A1/"));
        assertTrue(strell.betuEsSzamjegyNemLehetEgymasMellett("145/HN/14B"));
    }

}