# System aukcyjny

## Wprowadzenie

Specyfikacja wymagań funkcjonalnych w ramach informatyzacji procesu sprzedaży produktów w oparciu o mechanizm aukcyjny. 

## Procesy biznesowe

---
<a id="bc1"></a>
### BC1: Sprzedaż aukcyjna 

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Opis:** Proces biznesowy opisujący sprzedaż za pomocą mechanizmu aukcyjnego. |

**Scenariusz główny:**
1. [Sprzedający](#ac1) wystawia produkt na aukcję. ([UC1](#uc1))
2. [Kupujący](#ac2) oferuje kwotę za produkt wyższą od aktualnie najwyższej oferty. ([BR1](#br1))
3. [Kupujący](#ac2) wygrywa aukcję ([BR2](#br2))
4. [Kupujący](#ac2) przekazuje należność Sprzedającemu.
5. [Sprzedający](#ac1) przekazuje produkt Kupującemu.

**Scenariusze alternatywne:** 

2.A. Oferta Kupującego została przebita, a [Kupujący](#ac2) pragnie przebić aktualnie najwyższą ofertę.
* 2.A.1. Przejdź do kroku 2.

3.A. Czas aukcji upłynął i [Kupujący](#ac2) przegrał aukcję. ([BR2](#br2))
* 3.A.1. Koniec przypadku użycia.

---

## Aktorzy

<a id="ac1"></a>
### AC1: Sprzedający

Osoba oferująca towar na aukcji.

<a id="ac2"></a>
### AC2: Kupujący

Osoba chcąca zakupić produkt na aukcji.


## Przypadki użycia poziomu użytkownika

### Aktorzy i ich cele

[Sprzedający](#ac1):
* [UC1](#uc1): Wystawienie produktu na aukcję
* [UC5](#uc5): Sprzedaż produktu

[Kupujący](#ac2)
* [UC2](#uc2): Złożenie oferty kupna
* [UC3](#uc3): Wygranie aukcji
* [UC4](#uc4): Przekazanie należności sprzedającemu

---
<a id="uc1"></a>
### UC1: Wystawienie produktu na aukcję

**Aktorzy:** [Sprzedający](#ac1)

**Scenariusz główny:**
1. [Sprzedający](#ac1) zgłasza do systemu chęć wystawienia produktu na aukcję.
2. System prosi o podanie danych produktu i ceny wywoławczej.
3. [Sprzedający](#ac1) podaje dane produktu oraz cenę wywoławczą.
4. System weryfikuje poprawność danych.
5. System informuje o pomyślnym wystawieniu produktu na aukcję.

**Scenariusze alternatywne:** 

4.A. Podano niepoprawne lub niekompletne dane produktu.
* 4.A.1. System informuje o błędnie podanych danych.
* 4.A.2. Przejdź do kroku 2.

---

<a id="uc2"></a>
### UC2: Złożenie oferty kupna

**Aktorzy:**  [Sprzedający](#ac1), [Kupujący](#ac2)

**Scenariusz główny:**
1. [Kupujący](#ac2) zgłasza do systemu chęć przebicia aktualnej oferty.
2. System prosi o podanie ceny zakupu.
3. [Kupujący](#ac2) podaje cenę za jaką chce licytować.
4. System weryfikuje poprawność danych.
5. System informuje o poprawnym przebiciu oferty.
6. [Sprzedający](#ac1) przekazuje nową cenę.

**Scenariusze alternatywne:** 

1.A. Podano za niską cenę przebicia.
* 4.A.1. System odrzuca ofertę. (cena za niska)


---

<a id="uc3"></a>
### UC3: Wygranie aukcji

**Aktorzy:**  [Kupujący](#ac2)

**Scenariusz główny:**
1. Czas akcji się skończył.
2. System blokuje wstawianie ofert.
2. System informuje zwyciezcę aukcji  ([Kupującego](#ac2)) o wygranej.

---

<a id="uc4"></a>
### UC4: Przekazanie należności sprzedającemu

**Aktorzy:**  [Sprzedający](#ac1), [Kupujący](#ac2)

**Scenariusz główny:**
1. [Kupujący](#ac2) przekazuje należność do [Sprzedającego](#ac1).
2. System weryfikuje poprawność danych.


**Scenariusze alternatywne:**

1.A. Podano błedną kwotę.
* 4.A.1. System informuje o przekazanej błędnej kwocie. 
* 4.A.2. Przejdź do punktu 1.

---

<a id="uc5"></a>
### UC5: Sprzedaż produktu

**Aktorzy:**  [Sprzedający](#ac1), [Kupujący](#ac2)

**Scenariusz główny:**

1. [Kupujący](#ac2) przekazuje dane wysyłki do [Sprzedającego](#ac1).
2. System weryfikuje poprawność danych.
3. [Sprzedający](#ac1) wysyła przedmiot.

**Scenariusze alternatywne:**

1.A. Podano błedne dane.
* 4.A.1. System informuje o błędnie podanych danych.
* 4.A.2. Przejdź do punktu 1.

---

## Obiekty biznesowe (inaczje obiekty dziedzinowe lub informatycjne)

### BO1: Aukcja

Aukcja jest formą zawierania transakcji kupna-sprzedaży, w której Sprzedający określa cenę wywoławczą produktu, natomiast Kupujący mogą oferować własną ofertę zakupu każdorazowo proponując kwotę wyższą od aktualnie oferowanej kwoty. Aukcja kończy się po upływie określonego czasu. Jeśli złożona została co najmniej jedna oferta zakupy produkt nabywa ten Kupujący, który zaproponował najwyższą kwotę. 

### BO2: Produkt

Fizyczny lub cyfrowy obiekt, który ma zostać sprzedany w ramach aukcji.

### BO3: Cena

Wartość, którą musi zapłacić kupujący za wygrany produkt.

### BO4: Paczka

Produkt, który posiada dane wysyłkowe.

### BO5: Oferta

Kupujący składa ofertę za która jest w stanie kupić produkt.


## Reguły biznesowe

<a id="br1"></a>
### BR1: Złożenie oferty

Złożenie oferty wymaga zaproponowania kwoty wyższej niż aktualnie oferowana o minimum 1,00 PLN.


<a id="br2"></a>
### BR2: Rozstrzygnięcie aukcji

Aukcję wygrywa ten z [Kupujących](#ac2), który w momencie jej zakończenia (upłynięcia czasu) złożył najwyższą ofertę.

<a id="br3"></a>
### BR3: Przebijanie oferty

[Kupujący](#ac2) który w momencie trwania aukcji złożył najwyższą ofertę, nie może jej przebić.


## Macierz CRUDL


| Przypadek użycia                                  | Aukcja | Produkt | ... |
| ------------------------------------------------- | ------ | ------- | --- |
| UC1: Wystawienia produktu na aukcję               |    C   |    C    | ... |
| ???                                               |  ...   |  ...    | ... |


