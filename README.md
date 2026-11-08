# Zadanie 2 — Zamawianie pizzy

Zrobiłem aplikację do zamawiania pizzy w Android Studio.

Aplikacja ma dwa ekrany.

Na pierwszym ekranie można wybrać rozmiar pizzy, dodatki, liczbę pizz i wpisać adres dostawy.

Na drugim ekranie pokazuje się podsumowanie zamówienia oraz obliczona cena.

## Przekazywanie danych

Do przechodzenia na drugi ekran użyłem Intent.

Dane przekazuję za pomocą putExtra.

Przekazuję rozmiar, numer rozmiaru, dodatki, ilość i adres.

Użyłem typów String, int i boolean.

## Walidacja

Przed przejściem na drugi ekran aplikacja sprawdza, czy użytkownik wybrał rozmiar pizzy i wpisał adres.

Jeśli nie, pojawia się komunikat błędu i drugi ekran się nie otwiera.

## Potwierdzanie i poprawianie

Po kliknięciu Potwierdź drugi ekran zwraca RESULT_OK i numer zamówienia.

Po kliknięciu Popraw zamówienie wracam do pierwszego ekranu z wynikiem RESULT_CANCELED.

Dane w formularzu pozostają wpisane.

Do odbierania wyniku użyłem ActivityResultLauncher.

## Udostępnianie

Dodałem też przycisk Udostępnij.

Można nim wysłać podsumowanie do innej aplikacji.

Użyłem intencji niejawnej ACTION_SEND oraz try/catch.

## Czym różni się intencja jawna od niejawnej?

Intencja jawna otwiera konkretny ekran, który podajemy w kodzie.

Użyłem jej do przejścia z MainActivity do SummaryActivity.

Intencja niejawna nie wskazuje konkretnej aplikacji, tylko czynność do wykonania.

Użyłem jej przy udostępnianiu podsumowania pizzy.
