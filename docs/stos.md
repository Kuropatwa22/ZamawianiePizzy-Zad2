# Zadanie 3 — trzy ekrany i stos

Do aplikacji Zamawianie pizzy dodałem trzeci ekran „O aplikacji”.

Z pierwszego ekranu można przejść do podsumowania zamówienia albo do informacji o aplikacji.

Sprawdziłem, co dzieje się ze stosem przy przechodzeniu między ekranami.

## 1. Uruchomienie aplikacji

Na początku jest tylko MainActivity.

```text
| MainActivity |
```

## 2. Przejście na ekran 2

Klikam Dalej i otwiera się SummaryActivity.

Nowy ekran jest na wierzchu, a MainActivity zostaje pod nim.

```text
| SummaryActivity |
| MainActivity    |
```

## 3. Naciśnięcie Wstecz

SummaryActivity zostaje zamknięty i wracam do MainActivity.

```text
| MainActivity |
```

## 4. Przejście na ekran 3

Klikam O aplikacji.

Otwiera się AboutActivity, a MainActivity zostaje pod spodem.

```text
| AboutActivity |
| MainActivity  |
```

## 5. Ponowne naciśnięcie Wstecz

AboutActivity zostaje zamknięty i wracam do formularza.

```text
| MainActivity |
```

## 6. Ostatnie naciśnięcie Wstecz

Wracam z pierwszego ekranu poza aplikację, na ekran telefonu.

Nie mam już na wierzchu żadnego ekranu mojej aplikacji.

To, czy MainActivity zostaje od razu zniszczony, zależy od zachowania Androida.

## Logcat

Dodałem Log.d do metod onCreate, onStop i onDestroy we wszystkich trzech aktywnościach.

onCreate oznacza utworzenie ekranu.

onStop oznacza, że ekran przestał być widoczny.

onDestroy oznacza zniszczenie aktywności.

### Mój fragment Logcat

Emulator sie zbuntowal i nie moglem odpalic aplikacji

## Wnioski

Android przechowuje ekrany na stosie.

Kiedy otwieram nowy ekran, pojawia się on na wierzchu poprzedniego.

Kiedy naciskam Wstecz, wracam do poprzedniego ekranu.
