# BSI_secure_communication by Anastasiia Ponkratova, Julia Migiel
## Przykład działania programu bezpiecznej komunikacji opartej na asymetrycznym algorytmie szyfrującym RSA
Używając algorytmu RSA, system ten zapewnia zaszyfrowany sposób czatowania dla dwóch użytkowników na różnych urządzeniach. Kod wykorzystuje programowanie socketowe oraz wbudowane biblioteki w Javie dla algorytmu RSA. Serwer nazywa się Ewa, a klient Adam. Najpierw powinien zostać uruchomiony serwer, a następnie klient. Na początku wymieniane są klucze publiczne pomiędzy nimi. Najpierw Adam może wysłać wiadomość, a następnie Ewa może na nią odpowiedzieć i tak dalej. Zaszyfrowana wiadomość jest odbierana, a po potwierdzeniu można ją odszyfrować i obejrzeć.

#### Wyświetlanie menu głównego w celu wyboru algorytmu
![alt text](?raw=true)
