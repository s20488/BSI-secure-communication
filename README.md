# BSI_secure_communication by Anastasiia Ponkratova, Julia Migiel
## Przykład działania programu bezpiecznej komunikacji opartej na asymetrycznym algorytmie szyfrującym RSA
Używając algorytmu RSA, system ten zapewnia zaszyfrowany sposób czatowania dla dwóch użytkowników na różnych urządzeniach. Kod wykorzystuje programowanie socketowe oraz wbudowane biblioteki w Javie dla algorytmu RSA. Serwer nazywa się Ewa, a klient Adam. Najpierw powinien zostać uruchomiony serwer, a następnie klient. Na początku wymieniane są klucze publiczne pomiędzy nimi. Najpierw Adam może wysłać wiadomość, a następnie Ewa może na nią odpowiedzieć i tak dalej. Zaszyfrowana wiadomość jest odbierana, a po potwierdzeniu można ją odszyfrować i obejrzeć.

#### Uruchomienie Testserver
Po uruchomieniu klucz publiczny Adama jest publikowany i Ewa, znając go, może zaszyfrować wiadomość, którą tylko Adam może odczytać odszyfrowując go swoim kluczem prywatnym.
![alt text](https://github.com/s20488/BSI_secure_communication/blob/main/screens/Testserver_start.png?raw=true)

#### Uruchomienie TestClient
Po uruchomieniu klucz publiczny Ewy jest publikowany i Adam, znając go, może zaszyfrować wiadomość, którą tylko Ewa może odczytać odszyfrowując ją swoim kluczem prywatnym.
![alt text](https://github.com/s20488/BSI_secure_communication/blob/main/screens/TestClient_start.png?raw=true)

#### Wysyłanie wiadomości z TestClient
Napiszmy wiadomość dla Ewy.
![alt text](https://github.com/s20488/BSI_secure_communication/blob/main/screens/TestClient_sending_message.png?raw=true)

#### Odbieranie wiadomości z Testserver
Do serwera wysyłana jest zaszyfrowana wiadomość od Adama oraz zaproszenie do odszyfrowania tej wiadomości. Potwierdzamy i odbieramy zaszyfrowaną wiadomość.
![alt text](https://github.com/s20488/BSI_secure_communication/blob/main/screens/Testserver_receiving_message.png?raw=true)

#### Wysyłanie wiadomości z Testserver
Napiszmy wiadomość dla Adama.
![alt text](https://github.com/s20488/BSI_secure_communication/blob/main/screens/Testserver_sending_message.png?raw=true)

#### Odbieranie wiadomości z TestClient
Do serwera wysyłana jest zaszyfrowana wiadomość od Ewy oraz zaproszenie do odszyfrowania tej wiadomości. Potwierdzamy i odbieramy zaszyfrowaną wiadomość.
![alt text](https://github.com/s20488/BSI_secure_communication/blob/main/screens/TestClient_receiving_message.png?raw=true)
