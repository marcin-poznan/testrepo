<img alt="Logo" src="http://coderslab.pl/svg/logo-coderslab.svg" width="400">

# Programowanie obiektowe i bazy danych &ndash; egzamin.

Przed przystąpieniem do rozwiązywania zadań przeczytaj poniższe wskazówki

## Jak zacząć?

1. Stwórz [*fork*](https://guides.github.com/activities/forking/) repozytorium z zadaniami.
2. Sklonuj repozytorium na swój komputer. Użyj do tego komendy `git clone adres_repozytorium`
Adres repozytorium możesz znaleźć na stronie repozytorium po naciśnięciu w guzik "Clone or download".
3. Rozwiąż zadania i skomituj zmiany do swojego repozytorium. Użyj do tego komend `git add nazwa_pliku`.
Jeżeli chcesz dodać wszystkie zmienione pliki użyj `git add .` 
Pamiętaj że kropka na końcu jest ważna!
Następnie skommituj zmiany komendą `git commit -m "nazwa_commita"`
4. Wypchnij zmiany do swojego repozytorium na GitHubie.  Użyj do tego komendy `git push origin master`
5. Stwórz [*pull request*](https://help.github.com/articles/creating-a-pull-request) do oryginalnego repozytorium, gdy skończysz wszystkie zadania.

#### Pamiętaj, że pull request musi być stworzony, aby wykładowca dostał Twoje odpowiedzi.

* podczas egzaminu **możesz** korzystać z notatek, kodu napisanego wcześniej, internetu i prezentacji,
* zabroniona jest jakakolwiek komunikacja z innymi kursantami oraz osobami na zewnątrz.

**Powodzenia!**

----------------------------------------------------------------------------------------

Pamiętaj aby rozwiązania do zadań umieszczać w odpowiednich plikach java, przygotowanych do zadań. 

Nie zmieniaj nazwy pakietu.

Nie zapomnij o dodaniu sterownika do bazy danych!

### Nazwa bazy danych to `exam2`.

#### Zadanie 1 (4,5 pkt)

W pliku `Main1.java` wpisz zapytania do przygotowanych zmiennych,

W bazie danych mamy następujące tabele:
```SQL
* users: id : int (AUTO_INCREMENT), name : varchar(60), email : varchar(60), password : varchar(60)
* messages: id : int (AUTO_INCREMENT), user_id: int, message : text
* items: id : int (AUTO_INCREMENT), name : varchar(40), description : text, price : decimal(7,2)
* orders: id : int (AUTO_INCREMENT), description : text, created - typ daty, user_id: int
```
Napisz następujące zapytania SQL
Zapytania wpisz w odpowiednie zmienne w przygotowanym pliku `Main1.java`, np. `QUERY1`.

**Wywołaj wszystkie zapytania w metodzie `main` programu.**

1. Tworzące tabelę `users` (email ma być unikatowy).
2. Tworzące tabelę `messages` (pamiętaj o relacji jeden do wielu z tabelą `users`).
3. Tworzące tabelę `items`.
4. Tworzące tabelę `orders` (pamiętaj o relacji jeden do wielu z tabelą `users`).
5. Stworzenie relacji wiele do wielu między tabelami `items` a `orders`.  
     Tabela łącząca ma się nazywać `items_orders`.


#### Zadanie 2 (3,5 pkt)

Zapytania wpisz w odpowiednie zmienne w przygotowanym pliku `Main2.java`, np. `QUERY1`.

**Nie musisz wywoływać zapytań w kodzie Javy.**
     
1. Wybranie wszystkich itemów o cenie większej niż `50`, `posortowanych rosnąco` po `cenie`.
2. Włożenie do tabeli `items` nowego produktu o nazwie `product 1` i opisie : `desc 1`.
3. Usuniecie użytkownika o `id` 7.
4. Wybranie wszystkich użytkowników, którzy maja jakąś wiadomość, `posortowanych rosnąco` po `id` użytkownika.
5. Pobranie itemu o największej wartości z zamówienia (**tabela order**) o id równym 2.
6. Pobranie wszystkich zamówień z dnia 2017-11-12.
7.  Dodanie do tabeli `items_orders` (stworzonej w punkcie 2) wpisu łączącego zamówienie (tabela `orders`) o `id` `6`
 z przedmiotem (tabela `items`) o `id` `2`.


#### Zadanie 3 (4 pkt)

W pliku `Main3.java` napisz program, , który spełni następujące założenia:
1. Wyświetli wszystkie wiadomości dla użytkownika o `id` pobranym z konsoli.
2. Następnie wyświetli wszystkie jego zamówienia.
 
Pamiętaj o poprawnym połączeniu do bazy danych i jego zamknięciu.

#### Zadanie 4 (5 pkt)

W pliku `Main4.java` napisz program, który spełni następujące założenia:

1. z linii komend pobierze następujące parametry:
    * `name`: napis,
    * `description`: napis,
    * `price`: liczba zmiennoprzecinkowa.
2. Zweryfikuje poprawność danych (wartość liczbowa musi być poprawna).
3. W przypadku jeżeli dane nie są poprawne, mają zostać wczytane ponownie.
4. Zapisze te dane do bazy danych do tabeli `Items` (tabela taka sama jak w zadaniu 1).

Pamiętaj o poprawnym połączeniu do bazy danych i jego zamknięciu.


#### Zadanie 5 (3 pkt)
Utwórz klasę `VIPUser`. 

Klasa ma spełniać następujące właściwości:

1. Dziedziczyć po klasie `User` (znajduje się w pliku **User.java**).
2. Mieć dodatkowy prywatny atrybut: ```vipCardNumber``` typu **Integer** - typ opakowujący dla **int**.
3. Mieć prywatną metodę ```checkCard(newNumber)``` &ndash; numer jest prawidłowy, 
jeżeli jest większy niż 999 i podzielny przez 2 - metoda ma zwracać wartość logiczną.
4. Mieć konstruktor, który przyjmuje następujące dane: imię, nazwisko, mail, numer karty VIP.
 Imię, nazwisko i mail mają być przekazywane do konstruktora klasy nadrzędnej.
 Konstruktor ma sprawdzać, czy podany numer jest prawidłowy.
  Jeżeli jest  &ndash; to go nastawiać, jeżeli nie  &ndash; to numer ma być nastawiony na ```null```.
5. Mieć publiczną metodę ```setVipCardNumber(newCardNumber)``` i ```getVipCardNumber()```. 
Metoda **setVipCardNumber** ma nastawiać zmienną `vipCardNumber` (jeżeli podany nowy numer spełnia założenia), 
a metoda **getVipCardNumber** &ndash; ją zwracać.

